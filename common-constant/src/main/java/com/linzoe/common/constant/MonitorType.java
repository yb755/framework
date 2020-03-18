package com.linzoe.common.constant;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public enum MonitorType {

	VOLTAGE(1),

	LEAKAGE_CURRENT(2),

	CURRENT(3),

	TEMPERATURE(4),

	POWER(5);

	private MonitorType(int value) {
		this.value = value;
	}

	private int value;

	private static Map<Integer, MonitorType> MONITOR_TYPE_MAP = new HashMap<Integer, MonitorType>();

	static {
		MonitorType[] types = MonitorType.values();
		for (MonitorType type : types) {
			MONITOR_TYPE_MAP.put(type.value, type);
		}
	};

	public static MonitorType get(Integer value) {
		return MONITOR_TYPE_MAP.get(value);
	};
}
