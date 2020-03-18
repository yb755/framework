package com.linzoe.common.constant.history;

public enum SensorItem {
	voltageA(1),

	voltageB(2),

	voltageC(3),

	electricA(4),

	electricB(5),

	electricC(6),

	temperatureA(7),

	temperatureB(8),

	temperatureC(9),

	temperatureN(10),

	powerA(11),

	powerB(12),

	powerC(13),
	// 能耗
	energy_cal(14),
	// 抄表能耗
	energy_real(15),
	// 漏电流
	leak_current(16);

	private SensorItem(int value) {
		this.value = value;
	}

	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
