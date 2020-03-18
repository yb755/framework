package com.linzoe.common.constant;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public enum DeviceEvent {

	Event06((byte) 0x06, "电源故障保护","电源故障跳闸"),

	Event07((byte) 0x07, "本机其他故障保护", "本机其他故障跳闸"),

	Event11((byte) 0x11, "漏电保护", "漏电跳闸"),

	Event12((byte) 0x12, "N线过温保护", "N线过温跳闸"),

	Event13((byte) 0x13, "温度开关过温保护", "温度开关过温跳闸"),

	Event21((byte) 0x21, "短路保护", "短路跳闸"),

	Event22((byte) 0x22, "过载保护(>200mS)", "过载跳闸"),

	Event23((byte) 0x23, "过载保护(>1.2S)", "过载跳闸"),

	Event24((byte) 0x24, "过载保护(>2分钟)", "过载跳闸"),

	Event25((byte) 0x25, "过压保护", "过压跳闸"),

	Event26((byte) 0x26, "过压保护(<0.1秒)", "过压跳闸"),

	Event27((byte) 0x27, "欠压保护", "欠压跳闸"),

	Event28((byte) 0x28, "过温保护", "过温跳闸"),

	Event29((byte) 0x29, "电弧保护", "电弧跳闸"),

	Event50((byte) 0x50, "温度传感器故障", "温度传感器故障"),

	Event51((byte) 0x51, "漏电传感器故障", "漏电传感器故障"),

	Event52((byte) 0x52, "电压检测故障", "电压检测故障"),

	Event53((byte) 0x53, "电流互感器错相故障", "电流互感器错相故障"),

	Event54((byte) 0x54, "重合闸故障", "重合闸故障"),

	Event60((byte) 0x60, "上电", "上电"),

	Event61((byte) 0x61, "停电", "停电"),

	Event62((byte) 0x62, "停电/休眠", "停电/休眠"),

	Event63((byte) 0x63, "重启", "重启"),

	Event64((byte) 0x64, "断闸", "断闸"),

	Event65((byte) 0x65, "断闸/休眠", "断闸/休眠"),

	Event66((byte) 0x66, "合闸", "合闸"),

	Event67((byte) 0x67, "远程断闸", "远程断闸"),

	Event68((byte) 0x68, "远程合闸", "远程合闸"),

	Event69((byte) 0x69, "手动断闸", "手动断闸"),

	Event6A((byte) 0x6A, "手动合闸", "手动合闸"),

	Event6B((byte) 0x6B, "自动合闸", "自动合闸"),

	Event6C((byte) 0x6C, "重合闸错误", "重合闸错误"),

	Event6D((byte) 0x6D, "定时断闸", "定时断闸"),

	Event6E((byte) 0x6E, "定时合闸", "定时合闸"),
	
	EventFE((byte) 0xFE, "检修", "检修"),//软件定义的
	
	EventFF((byte) 0xFF, "检修复位", "检修复位");//软件定义的

	private DeviceEvent(byte eventType, String eventName, String showName) {
		this.eventType = eventType;
		this.eventName = eventName;
		this.showName = showName;
	}

	byte eventType;
	String eventName;
	String showName;

	private static Map<Byte, DeviceEvent> DEVICE_EVENT_MAP = new HashMap<Byte, DeviceEvent>();

	static {
		for (DeviceEvent deviceEvent : DeviceEvent.values()) {
			DEVICE_EVENT_MAP.put(deviceEvent.eventType, deviceEvent);
		}
	}

	public static DeviceEvent get(byte eventType) {
		return DEVICE_EVENT_MAP.get(eventType);
	}
}
