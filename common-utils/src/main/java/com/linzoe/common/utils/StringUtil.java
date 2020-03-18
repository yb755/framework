package com.linzoe.common.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtil {

	private static Logger logger = LoggerFactory.getLogger(StringUtil.class);

	/**
	 * 将集合转成字符串
	 * 
	 * @param lists
	 * @return
	 */
	public static String turnString(List<String> lists) {
		StringBuilder builder = new StringBuilder();
		for (String list : lists) {
			builder.append("'");
			builder.append(list);
			builder.append("'");
			builder.append(",");
		}
		return substring(builder.toString());
	}

	public static boolean isArrayStr(String arrayStr) {
		if (StringUtils.isBlank(arrayStr)) {
			return false;
		}
		String start = arrayStr.substring(0, 1);
		String end = arrayStr.substring(arrayStr.length() - 1, arrayStr.length());
		if (start.equals("[") && end.equals("]")) {
			return true;
		}
		return false;
	}

	/**
	 * 将集合转成字符串
	 * 
	 * @param lists
	 * @return
	 */
	public static String turnInt(List<Integer> lists) {
		StringBuilder builder = new StringBuilder();
		for (Integer list : lists) {
			builder.append(list);
			builder.append(",");
		}
		return substring(builder.toString());
	}

	/**
	 * 截取字符串(去掉最后一个逗号符号位)
	 * 
	 * @param str
	 * @return
	 */
	public static String substring(String str) {
		if (StringUtils.isBlank(str)) {
			return str;
		}
		if (str.endsWith(",")) {
			return str.substring(0, str.length() - 1);
		}
		return str;
	}

	/**
	 * 截取字符串(去掉最后一个符号位)
	 * 
	 * @param str
	 * @param symbol
	 * @return
	 */
	public static String substring(String str, String symbol) {
		if (StringUtils.isBlank(str)) {
			return str;
		}
		if (str.endsWith(symbol)) {
			return str.substring(0, str.length() - 1);
		}
		return str;
	}

	/**
	 * 截取字符串(0,length-1)
	 * 
	 * @param str
	 * @return
	 */
	public static String substringLast(String str) {
		if (StringUtils.isBlank(str)) {
			return str;
		}
		return str.substring(0, str.length() - 1);
	}

	/**
	 * 构建全like查询字符串
	 * 
	 * @param cloumn
	 * @return
	 */
	public static String likeStr(String cloumn) {
		StringBuilder builder = new StringBuilder();
		builder.append("LIKE CONCAT");
		builder.append("(CONCAT('%',#{");
		builder.append(cloumn);
		builder.append("}),'%')");
		return builder.toString();
	}

	/**
	 * 构建后like查询字符串
	 * 
	 * @param cloumn
	 * @return
	 */
	public static String likeLastStr(String cloumn) {
		StringBuilder builder = new StringBuilder();
		builder.append("LIKE CONCAT");
		builder.append("(#{");
		builder.append(cloumn);
		builder.append("},'%')");
		return builder.toString();
	}

	/**
	 * byte[]类型的字符串转为byte数组
	 * 
	 * @param byteStr
	 * @return
	 */
	public static byte[] parseStrByte(String byteStr) {
		String[] split = byteStr.substring(1, byteStr.length() - 1).split(",");
		byte[] buff = new byte[split.length];
		for (int i = 0; i < split.length; i++) {
			buff[i] = Byte.parseByte(split[i]);
		}
		return buff;
	}

	/**
	 * int[]类型的字符串转为int数组
	 * 
	 * @param byteStr
	 * @return
	 */
	public static int[] parseStrInt(String byteStr) {
		String[] split = byteStr.substring(1, byteStr.length() - 1).split(",");
		int[] buff = new int[split.length];
		for (int i = 0; i < split.length; i++) {
			buff[i] = Integer.parseInt(split[i]);
		}
		return buff;
	}

	public static String[] parseStr(String byteStr) {
		String[] split = byteStr.substring(1, byteStr.length() - 1).split(",");
		String[] str = new String[split.length];
		for (int i = 0; i < split.length; i++) {
			str[i] = split[i];
		}
		return str;
	}

	public static String[] parseStr2(String byteStr) {
		String[] split = byteStr.substring(0, byteStr.length()).split(",");
		String[] str = new String[split.length];
		for (int i = 0; i < split.length; i++) {
			str[i] = split[i];
		}
		return str;
	}

	/**
	 * byte数组转为字符串[2,1,3]
	 * 
	 * @param buff
	 * @return
	 */
	public static String StringToByteStr(String[] buff) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < buff.length; i++) {
			// NOTE YeBing 如果传过来的值非-127~127则会抛异常
			builder.append((byte) Integer.valueOf(buff[i]).intValue() + ",");
			// builder.append(Byte.parseByte(buff[i])+",");
		}
		return "[" + StringUtil.substring(builder.toString()) + "]";
	}

	/**
	 * byte数组转为字符串[2,1,3]
	 * 
	 * @param buff
	 * @return
	 */
	public static String StringToIntStr(String[] buff) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < buff.length; i++) {
			builder.append(Integer.parseInt(buff[i]) + ",");
		}
		return "[" + StringUtil.substring(builder.toString()) + "]";
	}

	/**
	 * byte数组转为字符串[2,1,3]
	 * 
	 * @param buff
	 * @return
	 */
	public static String byteToStr(byte[] buff) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < buff.length; i++) {
			builder.append(buff[i] + ",");
		}
		return "[" + StringUtil.substring(builder.toString()) + "]";
	}

	/**
	 * byte数组转为字符串[2,1,3]
	 * 
	 * @param buff
	 * @return
	 */
	public static String byteToStr(Byte[] buff) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < buff.length; i++) {
			builder.append(buff[i] + ",");
		}
		return "[" + StringUtil.substring(builder.toString()) + "]";
	}

	/**
	 * int数组转为字符串[2,1,3]
	 * 
	 * @param buff
	 * @return
	 */
	public static String intToStr(int[] buff) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < buff.length; i++) {
			builder.append(buff[i] + ",");
		}
		return "[" + StringUtil.substring(builder.toString()) + "]";
	}

	/**
	 * integer数组转为字符串[2,1,3]
	 * 
	 * @param buff
	 * @return
	 */
	public static String integerToStr(Integer[] buff) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < buff.length; i++) {
			builder.append(buff[i] + ",");
		}
		return "[" + StringUtil.substring(builder.toString()) + "]";
	}

	/**
	 * 验证邮箱
	 * 
	 * @param email
	 * @return
	 */
	public static boolean checkEmail(String email) {
		boolean flag = false;
		try {
			String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(email);
			flag = matcher.matches();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	/**
	 * 验证手机号码
	 * 
	 * @param mobiles
	 * @return
	 */
	public static boolean checkMobileNumber(String mobileNumber) {
		boolean flag = false;
		try {
			Pattern regex = Pattern.compile("^(1\\d{10,11})$");
			Matcher matcher = regex.matcher(mobileNumber);
			flag = matcher.matches();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	/**
	 * 是否包含
	 * 
	 * @param excludes 数字字符串列表
	 * @param target   目标数字
	 * @return true 包含,false 不包含
	 */
	public static boolean isInclude(String excludes, Integer target) {
		if (StringUtils.isBlank(excludes)) {
			return false;
		}
		String[] arrays = excludes.split(",");
		List<Integer> exDtIds = CollectionUtil.arrayToIntegerList(arrays);
		if (exDtIds.contains(target)) {
			return true;
		}
		return false;
	}

	private static String assembleDayHourSecondStr(String content) {
		String[] splitContents = content.split("#");
		int seconds = Integer.valueOf(splitContents[1]);
		int day = seconds / (60 * 60 * 24);// 换成天
		int hour = (seconds - (60 * 60 * 24 * day)) / 3600;// 总秒数-换算成天的秒数=剩余的秒数 剩余的秒数换算为小时
		int minute = (seconds - 60 * 60 * 24 * day - 3600 * hour) / 60;// 总秒数-换算成天的秒数-换算成小时的秒数=剩余的秒数 剩余的秒数换算为分
		StringBuilder result = new StringBuilder();
		if (day != 0) {
			result.append(day + "天");
		}
		if (hour != 0) {
			result.append(hour + "小时");
		}
		if (minute != 0) {
			result.append(minute + "分钟");
		}
		return result.toString();
	}

	/**
	 * 验证是否为正整数
	 * 
	 * @return
	 */
	public static boolean regexPositiveValue(String value) {
		return regexMatcher("^([1-9]*[1-9][0-9]*)|0$", value);
	}

	/**
	 * 判断正则表达式是否匹配
	 * 
	 * @param regexPattern
	 * @param value
	 * @return true:匹配
	 */
	public static boolean regexMatcher(String regexPattern, String value) {
		Pattern pattern = Pattern.compile(regexPattern);
		return pattern.matcher(value).matches();
	}

	public static boolean regexFirstFind(String regexPattern, String value) {
		Pattern pattern = Pattern.compile(regexPattern);
		return pattern.matcher(value).find();
	}

	public static String regexFirstMatcherStr(String regexPattern, String value) {
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(value);
		if (matcher.find()) {
			return matcher.group();
		}
		return null;
	}

	/**
	 * int类型是否有效且大于0
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isIntGt0(Integer number) {
		return number != null && number > 0;
	}

	public static String getHostIp() {
		try {
			String ox = "window".toUpperCase();
			String system = System.getProperty("by.push.os");
			if (StringUtils.isNotBlank(system)) {
				ox = system.toUpperCase();
			}
			String hostName = System.getProperty("by.push.netface");
			if (ox.equals("linux".toUpperCase())) {
				String ip = null;
				Enumeration<NetworkInterface> netInterfaces = null;
				if (StringUtils.isNotBlank(hostName)) {
					netInterfaces = NetworkInterface.getNetworkInterfaces();
					List<String> netfaces = CollectionUtil.arrayStrToStringList(hostName, ",");
					while (netInterfaces.hasMoreElements()) {
						NetworkInterface ni = netInterfaces.nextElement();
						String name = ni.getName();
						logger.info("获取平台ox:{},主机名称netface:{}", ox, name);
						if (StringUtils.isNotBlank(name) && netfaces.contains(name)) {
							Enumeration<InetAddress> ips = ni.getInetAddresses();
							while (ips.hasMoreElements()) {
								ip = ips.nextElement().getHostAddress();
								logger.info("获取平台ox:{},主机名称netface:{},ip:{}", ox, name, ip);
								if (regexMatcher("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}", ip)) {
									break;
								}
							}
							break;
						}
					}
				}
				if (ip == null) {
					netInterfaces = NetworkInterface.getNetworkInterfaces();
					while (netInterfaces.hasMoreElements()) {
						NetworkInterface ni = netInterfaces.nextElement();
						Enumeration<InetAddress> ips = ni.getInetAddresses();
						String tempIp = null;
						while (ips.hasMoreElements()) {
							tempIp = ips.nextElement().getHostAddress();
							logger.info("获取平台ox:{},主机ip:{}", ox, tempIp);
							if (regexMatcher("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}", tempIp)) {
								ip = tempIp;
								break;
							}
						}
						break;
					}
				}
				return ip;
			} else if (ox.equals("window".toUpperCase())) {
				InetAddress addr = InetAddress.getLocalHost();
				String ip = addr.getHostAddress();
				return ip;
			} else {
				InetAddress addr = InetAddress.getLocalHost();
				String ip = addr.getHostAddress();
				return ip;
			}
		} catch (Exception e) {
			throw new RuntimeException("获取本机ip异常");
		}
	}

	public static String getWindowHostIp() {
		try {
			InetAddress addr = InetAddress.getLocalHost();
			String ip = addr.getHostAddress();
			return ip;
		} catch (Exception e) {
			throw new RuntimeException("获取本机ip异常");
		}
	}

	public static boolean startsWithIgnoreCase(String str, String prefix) {
		if (str == null || prefix == null) {
			return false;
		}
		if (str.startsWith(prefix)) {
			return true;
		}
		if (str.length() < prefix.length()) {
			return false;
		}
		String lcStr = str.substring(0, prefix.length()).toLowerCase();
		String lcPrefix = prefix.toLowerCase();
		return lcStr.equals(lcPrefix);
	}

	public static boolean hasText(String str) {
		if (!hasLength(str)) {
			return false;
		}
		int strLen = str.length();
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasLength(String str) {
		return (str != null && str.length() > 0);
	}

	/**
	 * 数字采用前端补0的方式转换为固定长度的字符串<br/>
	 * 该方法不支持超过10位长度的数字转换<br/>
	 * 如果数字长度大于等于字符串长度，返回原数字对应的字符串<br/>
	 * 
	 * @param num    需要转换的数字
	 * @param length 需要的字符串长度
	 * @return 定长的数字字符串
	 */
	public static String int2Str(Integer num, Integer length) {
		if (length > 0 && length <= 10) {
			String fmt = "%0" + length + "d";
			return String.format(fmt, num);
		}
		return null;
	}

	/**
	 * 功能描述：判断字符串是否为整数
	 * 
	 * @param str 传入的字符串
	 * @return 是整数返回true,否则返回false
	 */
	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]+$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 判断是否为浮点数，包括double和float
	 * 
	 * @param str 传入的字符串
	 * @return 是浮点数返回true,否则返回false
	 */
	public static boolean isDouble(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?\\d+\\.\\d+$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 判断输入的字符串是否符合Email样式.
	 * 
	 * @param email 传入的字符串
	 * @return 是Email样式返回true,否则返回false
	 */
	public static boolean isEmail(String email) {
		if (email == null || email.length() < 1 || email.length() > 256) {
			return false;
		}
		Pattern pattern = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
		return pattern.matcher(email).matches();
	}

	/**
	 * 判断输入的字符串是否为纯汉字
	 * 
	 * @param str 传入的字符窜
	 * @return 如果是纯汉字返回true,否则返回false
	 */
	public static boolean isChinese(String str) {
		Pattern pattern = Pattern.compile("[\u0391-\uFFE5]+$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 格式化姓名，取姓名第一个字，后面转为**
	 * 
	 * @return
	 */
	public static String formatName(String name) {
		char[] names = name.toCharArray();
		for (int i = 1; i < names.length; i++) {
			names[i] = '*';
		}
		return String.valueOf(names);
	}

	/**
	 * 格式化手机号码，取手机号码前3个和后面4个，中间为*号
	 * 
	 * @return
	 */
	public static String formatMobile(String mobile) {
		if (StringUtils.isEmpty(mobile)) {
			return null;
		}
		char[] mobiles = mobile.toCharArray();
		for (int i = 3; i < mobiles.length - 4; i++) {
			mobiles[i] = '*';
		}
		return String.valueOf(mobiles);
	}

	/**
	 * 格式化车牌号，车牌号保留前后两位中间全部用*替代
	 * 
	 * @return
	 */
	public static String formatCarNum(String carNum) {
		if (StringUtils.isEmpty(carNum)) {
			return null;
		}
		char[] names = carNum.toCharArray();
		for (int i = names.length - 3; i > 1; i--) {
			names[i] = '*';
		}
		return String.valueOf(names);
	}

	/**
	 * 格式化车架号，车架号保留前后三位中间全部用*替代
	 * 
	 * @return
	 */
	public static String formatCarVin(String carVin) {
		if (StringUtils.isEmpty(carVin)) {
			return null;
		}
		char[] names = carVin.toCharArray();
		for (int i = names.length - 4; i > 2; i--) {
			names[i] = '*';
		}
		return String.valueOf(names);
	}

	/**
	 * 格式化银行卡号，只保留后4位
	 * 
	 * @return
	 */
	public static String formatBankCard(String bankCard) {
		if (StringUtils.isEmpty(bankCard)) {
			return null;
		}
		char[] names = bankCard.toCharArray();
		for (int i = 0; i < names.length - 4; i++) {
			names[i] = '*';
		}
		return String.valueOf(names);
	}

	public static boolean isEmpty(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}
		return false;
	}
}
