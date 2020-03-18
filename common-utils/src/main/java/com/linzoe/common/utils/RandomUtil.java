package com.linzoe.common.utils;

public class RandomUtil {

	/**
	 * 生成指定位数的随机码
	 * @param count
	 * @return
	 */
	public static String getRandomNum(int count) {
		String[] string = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		StringBuffer msg = new StringBuffer();
		for (int i = 0; i < count; i++) {
			int temp = (int) (Math.random() * 10);
			String aString = string[temp];
			msg.append(aString);
		}
		return msg.toString();
	}


	
}
