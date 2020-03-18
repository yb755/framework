package com.linzoe.common.constant;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public enum WarnType {

	// A相
	VOLTAGE_A_EXCEED(SensorType.VOLTAGE_A, 1001, "A相过压"),

	VOLTAGE_A_LOWER_THAN(SensorType.VOLTAGE_A, 1002, "A相欠压"),

	VOLTAGE_A_NO_PHASE(SensorType.VOLTAGE_A, 1003, "A相缺相"),

	CURRENT_A_EXCEED(SensorType.CURRENT_A, 1004, "A相过载"),

	TEMPLATE_A_BROKE(SensorType.TEMPERATURE_A, 1005, "A相温度断线"),

	TEMPLATE_A_EXCEED(SensorType.TEMPERATURE_A, 1006, "A相温度过高"),

	LINE_A_CONNECT_POOR(SensorType.LINE, 1007, "A相接触不良"),

	// B相
	VOLTAGE_B_EXCEED(SensorType.VOLTAGE_B, 1101, "B相过压"),

	VOLTAGE_B_LOWER_THAN(SensorType.VOLTAGE_B, 1102, "B相欠压"),

	VOLTAGE_B_NO_PHASE(SensorType.VOLTAGE_B, 1103, "B相缺相"),

	CURRENT_B_EXCEED(SensorType.CURRENT_B, 1104, "B相过载"),

	TEMPLATE_B_BROKE(SensorType.TEMPERATURE_B, 1105, "B相温度断线"),

	TEMPLATE_B_EXCEED(SensorType.TEMPERATURE_B, 1106, "B相温度过高"),

	LINE_B_CONNECT_POOR(SensorType.LINE, 1107, "B相接触不良"),

	// C相
	VOLTAGE_C_EXCEED(SensorType.VOLTAGE_C, 1201, "C相过压"),

	VOLTAGE_C_LOWER_THAN(SensorType.VOLTAGE_C, 1202, "C相欠压"),

	VOLTAGE_C_NO_PHASE(SensorType.VOLTAGE_C, 1203, "C相缺相"),

	CURRENT_C_EXCEED(SensorType.CURRENT_C, 1204, "C相过载"),

	TEMPLATE_C_BROKE(SensorType.TEMPERATURE_C, 1205, "C相温度断线"),

	TEMPLATE_C_EXCEED(SensorType.TEMPERATURE_C, 1206, "C相温度过高"),

	LINE_C_CONNECT_POOR(SensorType.LINE, 1207, "C相接触不良"),

	// N相
	TEMPLATE_N_BROKE(SensorType.TEMPERATURE_N, 1301, "N相温度断线"),

	TEMPLATE_N_EXCEED(SensorType.TEMPERATURE_N, 1302, "N相温度过高"),

	// 漏电流
	LEAKAGE_CURRENT_EXCEED(SensorType.LEAKAGE_CURRENT, 1401, "漏电流"),

	LEAKAGE_CURRENT_WRONG_LINE(SensorType.LEAKAGE_CURRENT, 1402, "接错线路"),

	// 停电
	POWER_SHUTDOWN(SensorType.POWER, 1501, "停电");

	private WarnType(SensorType sensorType, int value, String name) {
		this.sensorType = sensorType;
		this.value = value;
		this.name = name;
	}

	private SensorType sensorType;

	private int value;

	private String name;

	private static Map<Integer, WarnType> WARN_TYPE_MAP = new HashMap<Integer, WarnType>();

	static {
		WarnType[] types = WarnType.values();
		for (WarnType type : types) {
			WARN_TYPE_MAP.put(type.value, type);
		}
	};

	public static WarnType get(Integer value) {
		return WARN_TYPE_MAP.get(value);
	};
}
