package com.linzoe.common.constant;

import lombok.Getter;

@Getter
public enum Phase {

	A(1, "A相"),

	B(2, "B相"),

	C(3, "C相"),

	N(4, "N线"),

	COMM(5, "");

	private Phase(int value, String name) {
		this.value = value;
		this.name = name;
	}

	private int value;

	private String name;
}
