package com.linzoe.common.constant.device;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public enum DeviceTypeEnum {

	UNKNOWN(-1, false),
	// 单相交流
	SINGLE_PHASE_AC(0, false),
	// 单相直流
	SINGLE_PHASE_DC(1, false),
	// 三相三线
	THREE_PHASE_THREE_LINE(2, true),
	// 三相四线
	THREE_PHASE_FOUR_LINE(3, true),
	// 网关
	GATEWAY(4, false),
	// 电力载波插座
	POWER_CARRIER_SOCKER(5, false),
	// 红外开关
	INFRARED_SWITCH(6, false);

	private DeviceTypeEnum(int value, boolean isThreePhase) {
		this.value = value;
	}

	private int value;

	private boolean isThreePhase;

	private static Map<Integer, DeviceTypeEnum> DEVICE_TYPE_MAP = new HashMap<Integer, DeviceTypeEnum>();

	static {
		for (DeviceTypeEnum deviceType : DeviceTypeEnum.values()) {
			DEVICE_TYPE_MAP.put(deviceType.value, deviceType);
		}
	}

	public static DeviceTypeEnum get(Integer value) {
		return DEVICE_TYPE_MAP.get(value);
	}
}
