package com.linzoe.common.constant;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public enum WarnChannelFor80 {

	ALL((byte) 0x00, "全部"),

	A((byte) 0x01, "A相"),

	B((byte) 0x02, "B相"),

	C((byte) 0x03, "C相"),

	N((byte) 0x04, "N线"),

	L((byte) 0x05, "L线");

	private WarnChannelFor80(Byte value, String name) {
		this.value = value;
		this.name = name;
	}

	Byte value;
	String name;

	private static Map<Byte, WarnChannelFor80> WARN_CHANNEL_MAP = new HashMap<Byte, WarnChannelFor80>();

	static {
		for (WarnChannelFor80 warnChannel : WarnChannelFor80.values()) {
			WARN_CHANNEL_MAP.put(warnChannel.value, warnChannel);
		}
	}

	public static WarnChannelFor80 get(byte type) {
		return WARN_CHANNEL_MAP.get(type);
	}
}
