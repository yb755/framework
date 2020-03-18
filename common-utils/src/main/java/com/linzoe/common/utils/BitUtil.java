package com.linzoe.common.utils;

import java.util.Map;
import java.util.TreeMap;

public class BitUtil {
	public static int toShort(byte[] data, int offset) {
		int b0 = data[offset] & 0xFF;
		int b1 = (data[offset + 1] << 8) & 0xFF00;
		return b0 | b1;
	}

	public static byte[] toBytes(short data) {
		byte[] bytes = new byte[2];
		bytes[0] = (byte) (data & 0xFF);
		bytes[1] = (byte) (( data & 0xFF00) >> 8);
		return bytes;
	}

	public static int toInt(byte[] data, int offset) {
		int b0 = data[offset] & 0xFF;
		int b1 = (data[offset + 1] << 8) & 0xFF00;
		int b2 = (data[offset + 2] << 16) & 0xFF0000;
		int b3 = (data[offset + 3] << 24) & 0xFF000000;
		return b0 | b1 | b2 | b3;
	}

	public static byte[] toBytes(int data) {
		byte[] bytes = new byte[4];
		bytes[0] = (byte) (data & 0xFF);
		bytes[1] = (byte) ((data & 0xFF00) >> 8);
		bytes[2] = (byte) ((data & 0xFF0000) >> 16);
		bytes[3] = (byte) ((data & 0xFF000000) >> 24);
		return bytes;
	}

	public static float toFloat(byte[] data, int offset) {
		return Float.intBitsToFloat(toInt(data, offset));
	}

	public static byte[] toBytes(float data) {
		return toBytes(Float.floatToIntBits(data));
	}

	public static long toLong(byte[] data, int offset) {
		long b0 = data[offset] & 0xFF;
		long b1 = (data[offset + 1] << 8) & 0xFF00l;
		long b2 = (data[offset + 2] << 16) & 0xFF0000l;
		long b3 = (data[offset + 3] << 24) & 0xFF000000l;
		long b4 = (data[offset + 3] << 32) & 0xFF00000000l;
		long b5 = (data[offset + 3] << 40) & 0xFF0000000000l;
		long b6 = (data[offset + 3] << 48) & 0xFF000000000000l;
		long b7 = (data[offset + 3] << 56) & 0xFF00000000000000l;
		return b0 | b1 | b2 | b3 | b4 | b5 | b6 | b7;
	}

	public static byte[] toBytes(long data) {
		byte[] bytes = new byte[8];
		bytes[0] = (byte) (data & 0xFFl);
		bytes[1] = (byte) ((data & 0xFF00l) >> 8);
		bytes[2] = (byte) ((data & 0xFF0000l) >> 16);
		bytes[3] = (byte) ((data & 0xFF000000l) >> 24);
		bytes[4] = (byte) ((data & 0xFF00000000l) >> 32);
		bytes[5] = (byte) ((data & 0xFF0000000000l) >> 40);
		bytes[6] = (byte) ((data & 0xFF000000000000l) >> 48);
		bytes[7] = (byte) ((data & 0xFF00000000000000l) >> 56);
		return bytes;
	}

	public static String binaryString2hexString(String bString) {
		if (bString == null || bString.equals("") || bString.length() % 8 != 0)
			return null;
		StringBuffer tmp = new StringBuffer();
		int iTmp = 0;
		for (int i = 0; i < bString.length(); i += 4) {
			iTmp = 0;
			for (int j = 0; j < 4; j++) {
				iTmp += Integer.parseInt(bString.substring(i + j, i + j + 1)) << (4 - j - 1);
			}
			tmp.append(Integer.toHexString(iTmp));
		}
		return tmp.toString();
	}

	private static String intToHex(int n) {
		StringBuffer result = new StringBuffer();
		char[] b = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		while (n != 0) {
			result = result.append(b[n % 16]);
			n = n / 16;
		}
		return result.reverse().toString();
	}

	public static String binary2decimal(int decNum, int digit) {
		String binStr = "";
		for (int i = digit - 1; i >= 0; i--) {
			binStr += (decNum >> i) & 1;
		}
		return binStr;
	}

	public static Map<String, Object> getSwitchTimingByte() {
		Map<String, Object> mapinfo = new TreeMap<>();
		for (int i = 0; i < 32; i++) {
			String hex1 = intToHex(8 + i);
			String hex2 = intToHex(8 * i);
			hex2 = hex2.length() > 0 ? hex2 : "0";
			mapinfo.put("50" + (hex1.length() > 1 ? hex1 : "0" + hex1), "B0" + (hex2.length() > 1 ? hex2 : "0" + hex2));
		}
		return mapinfo;
	}

	public static Map<String, Object> getSwitchId() {
		Map<String, Object> mapinfo = new TreeMap<>();
		for (int i = 0; i < 32; i++) {
			String hex2 = intToHex(8 + i);
			mapinfo.put((i + 1) + "", "50" + (hex2.length() > 1 ? hex2 : "0" + hex2));
		}
		return mapinfo;
	}

	public static byte[] hexToByteArr(String hexStr) {
		char[] charArr = hexStr.toCharArray();
		byte btArr[] = new byte[charArr.length / 2];
		int index = 0;
		for (int i = 0; i < charArr.length; i++) {
			btArr[index] = (byte) (charToByte(charArr[i]) << 4 | charToByte(charArr[++i]));
			index++;
		}
		return btArr;
	}

	private static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}

	public static int toAmmanNumber(byte[] data,int offset){
		byte[] ammanData=new byte[4];
		System.arraycopy(data,offset,ammanData,0,4);
		String hex=ByteUtil.bytesToHexString(ammanData);
		String ammanValueString=hex.substring(6,8)+hex.substring(4,6)+hex.substring(2,4)+hex.substring(0,2);
		return Integer.parseInt(ammanValueString);
	}


}