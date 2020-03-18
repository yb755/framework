package com.linzoe.common.constant;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public enum SensorType {

	VOLTAGE_A(1),

	VOLTAGE_B(2),

	VOLTAGE_C(3),

	LEAKAGE_CURRENT(4),

	CURRENT_A(5),
	
	CURRENT_B(6),
	
	CURRENT_C(7),

	TEMPERATURE_A(8),

	TEMPERATURE_B(9),

	TEMPERATURE_C(10),

	POWER(11),
	
	LINE(12),
	
	TEMPERATURE_N(13),;

	private SensorType(int value) {
		this.value = value;
	}

	private int value;

	private static Map<Integer, SensorType> SENSOR_TYPE_MAP = new HashMap<Integer, SensorType>();

	static {
		SensorType[] types = SensorType.values();
		for (SensorType type : types) {
			SENSOR_TYPE_MAP.put(type.value, type);
		}
	};

	public static SensorType get(Integer value) {
		return SENSOR_TYPE_MAP.get(value);
	};
}
