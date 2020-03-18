package com.linzoe.common.constant;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public enum WarnTypeFor80 {

	ALL((byte) 0x00, "所有预警"),

	VOLTAGE_EXCEED((byte) 0x01, "过压预警"),

	VOLTAGE_LOWER_THAN((byte) 0x02, "欠压预警"),

	CURRENT_EXCEED((byte) 0x03, "过流预警"),

	LEAKAGE_CURRENT_EXCEED((byte) 0x04, "漏电预警"),

	TEMPLATE_EXCEED((byte) 0x05, "过温预警"),

	CONNECT_POOR((byte) 0x06, "接警不良预警");

	private WarnTypeFor80(Byte value, String name) {
		this.value = value;
		this.name = name;
	}

	Byte value;
	String name;

	private static Map<Byte, WarnTypeFor80> WARN_TYPE_MAP = new HashMap<Byte, WarnTypeFor80>();

	static {
		for (WarnTypeFor80 warnType : WarnTypeFor80.values()) {
			WARN_TYPE_MAP.put(warnType.value, warnType);
		}
	}

	public static WarnTypeFor80 get(byte type) {
		return WARN_TYPE_MAP.get(type);
	}
}
