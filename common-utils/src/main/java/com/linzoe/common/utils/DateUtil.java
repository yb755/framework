package com.linzoe.common.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {

	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public static Date parseDateTime(String dateTimeStr) {
		try {
			return dateFormat.parse(dateTimeStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 默认的日期格式组合，用来将字符串转化为日期用
	 * 
	 */
	private static final String[] DATE_PARSE_PATTERNS = { "yyyy/MM/dd", "yyyy-MM-dd", "yyyy年MM月dd日" };

	/**
	 * 默认的时间格式
	 */
	public static final String DEFAULT_TIME_PATTERN = "HH:mm:ss";

	/**
	 * 默认的日期格式
	 */
	public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";

	/**
	 * 日期代码，周日
	 */
	public static final int SUNDAY = 1;

	/**
	 * 日期代码，周一
	 */
	public static final int MONDAY = 2;

	/**
	 * 日期代码，周二
	 */
	public static final int TUESDAY = 3;

	/**
	 * 日期代码，周三
	 */
	public static final int WEDNESDAY = 4;

	/**
	 * 日期代码，周四
	 */
	public static final int THURSDAY = 5;

	/**
	 * 日期代码，周五
	 */
	public static final int FRIDAY = 6;

	/**
	 * 日期代码，周六
	 */
	public static final int SATURDAY = 7;

	/**
	 * 日期精度，秒
	 */
	public static final int ACCURACY_SECOND = 1;

	/**
	 * 日期精度，分
	 */
	public static final int ACCURACY_MINUTE = 2;

	/**
	 * 日期精度，小时
	 */
	public static final int ACCURACY_HOUR = 3;

	/**
	 * 日期精度，天
	 */
	public static final int ACCURACY_DAY = 4;

	/**
	 * 日期精度，月
	 */
	public static final int ACCURACY_MONTH = 5;

	/**
	 * 日期精度，年
	 */
	public static final int ACCURACY_YEAR = 6;

	/**
	 * 比较用日期格式，精度为年
	 */
	private static final String ACCURACY_PATTERN_YEAR = "yyyy";

	/**
	 * 比较用日期格式，精度为月
	 */
	private static final String ACCURACY_PATTERN_MONTH = "yyyyMM";

	/**
	 * 比较用日期格式，精度为月
	 */
	public static final String ACCURACY_PATTERN_WEEK = "yyyyww";

	/**
	 * 比较用日期格式，精度为日
	 */
	public static final String ACCURACY_PATTERN_DAY = "yyyyMMdd";

	/**
	 * 比较用日期格式，精度为时
	 */
	private static final String ACCURACY_PATTERN_HOUR = "yyyyMMddHH";

	/**
	 * 比较用日期格式，精度为分
	 */
	public static final String ACCURACY_PATTERN_MINUTE = "yyyyMMddHHmm";

	public static final String ACCURACY_PATTERN_MINUTE2 = "MM-dd HH:mm";

	public static final String ACCURACY_PATTERN_DAY_HH = "dd HH:mm";

	/**
	 * 比较用日期格式，精度为秒
	 */
	public static final String ACCURACY_PATTERN_SECOND = "yyyyMMddHHmmss";

	/**
	 * 比较用日期格式，精度为秒
	 */
	public static final String ACCURACY_PATTERN_MILLISECOND = "yyMMddHHmmsss";

	public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 单一属性格式，时
	 */
	private static final String SINGLE_YEAR = "yyyy";

	/**
	 * 单一属性格式，时
	 */
	private static final String SINGLE_MONTH = "M";

	/**
	 * 单一属性格式，时
	 */
	private static final String SINGLE_DAY = "d";

	/**
	 * 单一属性格式，时
	 */
	private static final String SINGLE_HOUR = "H";

	/**
	 * 单一属性格式，分
	 */
	private static final String SINGLE_MINUTE = "m";

	/**
	 * 单一属性格式，秒
	 */
	private static final String SINGLE_SECOND = "s";

	/**
	 * 
	 */
	private static final long MILLISECONDS_PER_SECOND = 1000;

	/**
	 * 
	 */
	private static final long MILLISECONDS_PER_MINUTE = 1000 * 60;

	/**
	 * 
	 */
	private static final long MILLISECONDS_PER_HOUR = 1000 * 60 * 60;

	/**
	 * 
	 */
	private static final long MILLISECONDS_PER_DAY = 1000 * 60 * 60 * 24;

	public static String formatLongTimestamp(Timestamp ts) {
		java.text.SimpleDateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format1.format(ts);
	}

	public static Timestamp getCurrentTimestamp() {

		return new Timestamp(System.currentTimeMillis());
	}

	public static long nowTime() {
		return System.currentTimeMillis();
	}

	/**
	 * 获取yyyy-MM-dd hh:mm:ss格式的当前时间
	 * 
	 * @return
	 */
	public static String getLongDate() {
		java.text.DateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format1.format(new Date());
	}

	/**
	 * 将给定的日期字符串，按照预定的日期格式，转化为Date型数据
	 * 
	 * @param dateStr 日期字符字符串
	 * @return 日期型结果
	 */
	public static Date parseDate(String dateStr) {
		Date date = null;
		try {
			date = org.apache.commons.lang3.time.DateUtils.parseDate(dateStr, DATE_PARSE_PATTERNS);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 根据指定格式转化String型日期到Date型
	 * 
	 * @param dateStr      String型日期
	 * @param parsePattern 指定的格式
	 * @return Date型日期
	 */
	public static Date parseDate(String dateStr, String parsePattern) {
		Date date = null;
		try {
			date = org.apache.commons.lang3.time.DateUtils.parseDate(dateStr, new String[] { parsePattern.toString() });
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 根据指定格式转化String型日期到Date型
	 * 
	 * @param dateStr      String型日期
	 * @param parsePattern 指定的格式
	 * @return Date型日期
	 */
	public static String parseDate(Date date, String parsePattern) {

		SimpleDateFormat format = getFormat(parsePattern);

		return format.format(date);

	}

	/**
	 * Format
	 * 
	 * @param pattern
	 * 
	 * @return format
	 */
	private static SimpleDateFormat getFormat(String pattern) {
		SimpleDateFormat format = new SimpleDateFormat();

		if ((pattern != null) && (pattern.trim().length() > 0)) {
			format.applyPattern(pattern);
		} else {
			format.applyPattern(DEFAULT_PATTERN);
		}

		return format;
	}

	/**
	 * 返回系统当前时间（Date型）
	 * 
	 * @return 系统当前时间
	 */
	public static Date getCurrentDate() {
		// 设置时区
		TimeZone tz = TimeZone.getTimeZone("Asia/Shanghai");
		TimeZone.setDefault(tz);
		return new Date();
	}

	/**
	 * 日期计算，日加减
	 * 
	 * @param date   初始日期
	 * @param amount 天数增量（负数为减）
	 * @return 计算后的日期
	 */
	public static Date addDays(Date date, int day) {
		return org.apache.commons.lang3.time.DateUtils.addDays(date, day);
	}

	/**
	 * 日期计算，周加减
	 * 
	 * @param date   初始日期
	 * @param amount 周数增量（负数为减）
	 * @return 计算后的日期
	 */
	public static Date addWeeks(Date date, int week) {
		return org.apache.commons.lang3.time.DateUtils.addWeeks(date, week);
	}

	/**
	 * 日期计算，月加减
	 * 
	 * @param date   初始日期
	 * @param amount 月数增量（负数为减）
	 * @return 计算后的日期
	 */
	public static Date addMonths(Date date, int amount) {
		return org.apache.commons.lang3.time.DateUtils.addMonths(date, amount);
	}

	/**
	 * 日期计算，年加减
	 * 
	 * @param date   初始日期
	 * @param amount 年数增量（负数为减）
	 * @return 计算后的日期
	 */
	public static Date addYears(Date date, int year) {
		return org.apache.commons.lang3.time.DateUtils.addYears(date, year);
	}

	/**
	 * 日期计算，小时加减
	 * 
	 * @param date   初始日期
	 * @param amount 小时增量（负数为减）
	 * @return 计算后的日期
	 */
	public static Date addHours(Date date, int amount) {
		return org.apache.commons.lang3.time.DateUtils.addHours(date, amount);
	}

	/**
	 * 日期计算，分钟加减
	 * 
	 * @param date   初始日期
	 * @param amount 分钟增量（负数为减）
	 * @return 计算后的日期
	 */
	public static Date addMinutes(Date date, int minute) {
		return org.apache.commons.lang3.time.DateUtils.addMinutes(date, minute);
	}

	/**
	 * 日期计算，秒加减
	 * 
	 * @param date   初始日期
	 * @param amount 秒增量（负数为减）
	 * @return 计算后的日期
	 */
	public static Date addSeconds(Date date, int second) {
		return org.apache.commons.lang3.time.DateUtils.addSeconds(date, second);
	}

	/**
	 * 计算出生日期
	 * 
	 * @param age     当前的年龄(${age}岁)
	 * @param maxDate 是否最大出生日期，默认为false; 为true是表示计算${age}周岁时出生日期
	 * @return maxDate为false时：返回 age+1周岁后一天。例如: age为4,
	 *         当前为2015-07-04;返回2010-07-05对应的Date maxDate为true时, 返回age周岁当天。例如: age为4,
	 *         当前为2015-07-04;返回2011-07-04对应的Date
	 */
	public static Date ageToDate(int age, boolean maxDate) {
		Calendar cal = Calendar.getInstance();
		Calendar cal1 = Calendar.getInstance();
		if (maxDate) {
			cal.set(Calendar.YEAR, cal1.get(Calendar.YEAR) - age);
		} else {
			cal.set(Calendar.YEAR, cal1.get(Calendar.YEAR) - age - 1);
			cal.set(Calendar.DAY_OF_MONTH, cal1.get(Calendar.DAY_OF_MONTH) + 1);
		}
		return cal.getTime();
	}

	/**
	 * 计算出生日期
	 * 
	 * @param age
	 * @return 返回 age+1周岁后一天。例如: age为4, 当前为2015-07-4;返回2010-07-05对应的Date
	 */
	public static Date ageToDate(int age) {
		return ageToDate(age, false);
	}

	/**
	 * 根据指定格式，返回日期时间字符串
	 * 
	 * @param date    日期变量
	 * @param pattern 日期格式
	 * @return 日期时间字符串
	 */
	public static String getDateStr(Date date, String pattern) {
		DateFormat df = new SimpleDateFormat(pattern);
		return df.format(date);
	}

	/**
	 * 输出时间String(默认格式)
	 * 
	 * @param date 日期
	 * @return 默认格式化的日期
	 */
	public static String getTimeStr(Date date) {
		return getDateStr(date, DEFAULT_TIME_PATTERN);
	}

	/**
	 * 取指定日期所在月的第一天的日期
	 * 
	 * @param date 指定的日期
	 * @return 指定日期所在月的第一天
	 */
	public static Date getFirstDayOfMonth(Date date) {
		Calendar cal = getCalendar(date);
		cal.set(Calendar.DATE, 1);
		return cal.getTime();
	}

	/**
	 * 取指定日期所在月的最后一天的日期
	 * 
	 * @param date 指定的日期
	 * @return 指定日期所在月的最后一天
	 */
	public static Date getLastDayOfMonth(Date date) {
		Date nextMonth = addMonths(date, 1);
		Date firstDayOfNextMonth = getFirstDayOfMonth(nextMonth);
		return addDays(firstDayOfNextMonth, -1);
	}

	/**
	 * 取指定日期所在年的第一天的日期
	 * 
	 * @param date 指定的日期
	 * @return 指定日期所在年的第一天
	 */
	public static Date getFirstDayOfYear(Date date) {
		Calendar cal = getCalendar(date);
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.MONTH, 0);
		return cal.getTime();
	}

	public static String getDay(int date) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		return parseDate(cal.getTime(), DEFAULT_DATE_PATTERN);
	}

	/**
	 * 取指定日期所在年的最后一天的日期
	 * 
	 * @param date 指定的日期
	 * @return 指定日期所在月的最后一天
	 */
	public static Date getLastDayOfYear(Date date) {
		Date nextMonth = addYears(date, 1);
		Date firstDayOfNextYear = getFirstDayOfYear(nextMonth);
		return addDays(firstDayOfNextYear, -1);
	}

	/**
	 * 取指定日期所在周的指定天的日期
	 * 
	 * @param date     指定的日期
	 * @param day      指定的天（星期几）
	 * @param firstDay 一星期的起始天
	 * @return 指定周星期日的日期
	 */
	public static Date getDayInWeek(Date date, int day, int firstDay) {
		Calendar cal = getCalendar(date);
		cal.setFirstDayOfWeek(firstDay);
		cal.set(Calendar.DAY_OF_WEEK, day);
		return cal.getTime();
	}

	/**
	 * 根据Date型的日期，取Calendar型的日期
	 * 
	 * @param date Date型的日期
	 * @return Calendar型的日期
	 */
	public static Calendar getCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	/**
	 * 日期比较（精确到天），date1晚于date2
	 * 
	 * @param date1 日期1
	 * @param date2 日期2
	 * @return date1晚于date2，返回true，否则返回false
	 */
	public static boolean later(Date date1, Date date2) {
		boolean result = false;
		if (1 == compare(date1, date2, ACCURACY_DAY)) {
			result = true;
		}
		return result;
	}

	/**
	 * 日期比较（精确到天），date1早于date2
	 * 
	 * @param date1 日期1
	 * @param date2 日期2
	 * @return date1早于date2，返回true，否则返回false
	 */
	public static boolean earlier(Date date1, Date date2) {
		boolean result = false;
		if (-1 == compare(date1, date2, ACCURACY_DAY)) {
			result = true;
		}
		return result;
	}

	/**
	 * 日期比较（精确到天），date1等于date2
	 * 
	 * @param date1 日期1
	 * @param date2 日期2
	 * @return date1等于date2，返回true，否则返回false
	 */
	public static boolean equal(Date date1, Date date2) {
		boolean result = false;
		if (0 == compare(date1, date2, ACCURACY_DAY)) {
			result = true;
		}
		return result;
	}

	/**
	 * 根据指定规则比较日期，date1晚于date2
	 * 
	 * @param date1    日期1
	 * @param date2    日期2
	 * @param accuracy 日期精度
	 * @return date1晚于date2，返回true，否则返回false
	 */
	public static boolean later(Date date1, Date date2, int accuracy) {
		boolean result = false;
		if (1 == compare(date1, date2, accuracy)) {
			result = true;
		}
		return result;
	}

	/**
	 * 根据指定规则比较日期，date1早于date2
	 * 
	 * @param date1    日期1
	 * @param date2    日期2
	 * @param accuracy 日期精度
	 * @return date1早于date2，返回true，否则返回false
	 */
	public static boolean earlier(Date date1, Date date2, int accuracy) {
		boolean result = false;
		if (-1 == compare(date1, date2, accuracy)) {
			result = true;
		}
		return result;
	}

	/**
	 * 根据指定规则比较日期，date1等于date2
	 * 
	 * @param date1    日期1
	 * @param date2    日期2
	 * @param accuracy 日期精度
	 * @return date1等于date2，返回true，否则返回false
	 */
	public static boolean equal(Date date1, Date date2, int accuracy) {
		boolean result = false;
		if (0 == compare(date1, date2, accuracy)) {
			result = true;
		}
		return result;
	}

	/**
	 * 根据指定日期的时间差
	 * 
	 * @param date1 日期1
	 * @param date2 日期2
	 * @return long
	 */
	public static long minuteBetween(Date startTime, Date endTime) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(startTime);
		long time1 = cal.getTimeInMillis();
		cal.setTime(endTime);
		long time2 = cal.getTimeInMillis();
		long between_Mins = (time2 - time1) / (1000 * 60);
		return between_Mins;
	}

	/**
	 * 根据指定规则，比较日期
	 * 
	 * @param date1    日期1
	 * @param date2    日期2
	 * @param accuracy 日期精度
	 * @return int型，date1晚，返回1；date1早，返回-1；相等，返回0
	 */
	private static int compare(Date date1, Date date2, int accuracy) {
		String pattern = DEFAULT_DATE_PATTERN;
		switch (accuracy) {
		case ACCURACY_YEAR:
			pattern = ACCURACY_PATTERN_YEAR;
			break;
		case ACCURACY_MONTH:
			pattern = ACCURACY_PATTERN_MONTH;
			break;
		case ACCURACY_DAY:
			pattern = ACCURACY_PATTERN_DAY;
			break;
		case ACCURACY_HOUR:
			pattern = ACCURACY_PATTERN_HOUR;
			break;
		case ACCURACY_MINUTE:
			pattern = ACCURACY_PATTERN_MINUTE;
			break;
		case ACCURACY_SECOND:
			pattern = ACCURACY_PATTERN_SECOND;
			break;
		default:
			break;
		}
		Date formatedDate1 = transDateFormat(date1, pattern);
		Date formatedDate2 = transDateFormat(date2, pattern);
		return formatedDate1.compareTo(formatedDate2);
	}

	/**
	 * 根据指定规则，转化日期，如只取年、取年月等
	 * 
	 * @param date    待转化日期
	 * @param pattern 日期格式
	 * @return 转化后的日期
	 */
	public static Date transDateFormat(Date date, String pattern) {
		String dateStr = getDateStr(date, pattern);
		return parseDate(dateStr, pattern);
	}

	/**
	 * 返回时定时间的年
	 * 
	 * @param date 日期
	 * @return String型的年
	 */
	public static String getYear(Date date) {
		return getDateStr(date, SINGLE_YEAR);
	}

	/**
	 * 返回时定时间的月
	 * 
	 * @param date 日期
	 * @return String型的月
	 */
	public static String getMonth(Date date) {
		return getDateStr(date, SINGLE_MONTH);
	}

	/**
	 * 返回时定时间的日
	 * 
	 * @param date 日期
	 * @return String型的日
	 */
	public static String getDay(Date date) {
		return getDateStr(date, SINGLE_DAY);
	}

	/**
	 * 返回时定时间的小时
	 * 
	 * @param date 日期
	 * @return String型的小时
	 */
	public static String getHour(Date date) {
		return getDateStr(date, SINGLE_HOUR);
	}

	/**
	 * 返回时定时间的分
	 * 
	 * @param date 日期
	 * @return String型的分
	 */
	public static String getMinute(Date date) {
		return getDateStr(date, SINGLE_MINUTE);
	}

	/**
	 * 返回时定时间的秒
	 * 
	 * @param date 日期
	 * @return String型的秒
	 */
	public static String getSecond(Date date) {
		return getDateStr(date, SINGLE_SECOND);
	}

	/**
	 * 将时间日期变量的年份变为指定年, 如果日期不存在，则向后一天，如20102月
	 * 
	 * @param date   日期时间变量
	 * @param amount 指定年
	 * @return 修改后的日期变量
	 */
	public static Date setYear(Date date, int amount) {
		Calendar cal = getCalendar(date);
		cal.set(Calendar.YEAR, amount);
		return cal.getTime();
	}

	/**
	 * 将时间日期变量的月份变为指定月
	 * 
	 * @param date   日期时间变量
	 * @param amount 指定月
	 * @return 修改后的日期变量
	 */
	public static Date setMonth(Date date, int amount) {
		Calendar cal = getCalendar(date);
		cal.set(Calendar.MONTH, amount - 1);
		return cal.getTime();
	}

	/**
	 * 将时间日期变量的年份变为指定日
	 * 
	 * @param date   日期时间变量
	 * @param amount 指定日
	 * @return 修改后的日期变量
	 */
	public static Date setDay(Date date, int amount) {
		Calendar cal = getCalendar(date);
		cal.set(Calendar.DAY_OF_MONTH, amount);
		return cal.getTime();
	}

	/**
	 * 将时间日期变量的小时变为指定时
	 * 
	 * @param date   日期时间变量
	 * @param amount 指定时
	 * @return 修改后的日期变量
	 */
	public static Date setHour(Date date, int amount) {
		Calendar cal = getCalendar(date);
		cal.set(Calendar.HOUR_OF_DAY, amount);
		return cal.getTime();
	}

	/**
	 * 将时间日期变量的分钟变为指定分
	 * 
	 * @param date   日期时间变量
	 * @param amount 指定分
	 * @return 修改后的日期变量
	 */
	public static Date setMinute(Date date, int amount) {
		Calendar cal = getCalendar(date);
		cal.set(Calendar.MINUTE, amount);
		return cal.getTime();
	}

	/**
	 * 将时间日期变量的秒变为指定秒
	 * 
	 * @param date   日期时间变量
	 * @param amount 指定秒
	 * @return 修改后的日期变量
	 */
	public static Date setSecond(Date date, int amount) {
		Calendar cal = getCalendar(date);
		cal.set(Calendar.SECOND, amount);
		return cal.getTime();
	}

	/**
	 * 根据制定单位，计算两个日期之间的天数差
	 * 
	 * @param a 时间点1
	 * @param b 时间点2
	 * @return 时间差
	 */
	public static int getDateDistance(Date a, Date b) {
		return getDateDistance(a, b, ACCURACY_DAY);
	}

	/**
	 * 根据制定单位，计算两个日期之间的差
	 * 
	 * @param a    时间点1
	 * @param b    时间点2
	 * @param unit 时间单位
	 * @return 时间差
	 */
	public static int getDateDistance(Date a, Date b, int unit) {
		int result = 0;
		if ((null != a && null != b) && (ACCURACY_SECOND <= unit && ACCURACY_DAY >= unit)) {
			String pattern = null;
			switch (unit) {
			case ACCURACY_DAY:
				pattern = ACCURACY_PATTERN_DAY;
				break;
			case ACCURACY_HOUR:
				pattern = ACCURACY_PATTERN_HOUR;
				break;
			case ACCURACY_MINUTE:
				pattern = ACCURACY_PATTERN_MINUTE;
				break;
			case ACCURACY_SECOND:
				pattern = ACCURACY_PATTERN_SECOND;
				break;
			default:
				break;
			}
			Date startDate = transDateFormat(1 == a.compareTo(b) ? b : a, pattern);
			Date endDate = transDateFormat(1 == a.compareTo(b) ? a : b, pattern);
			result = getDistanceByUnit(startDate, endDate, unit);
		}
		return result;
	}

	/**
	 * 内部方法，计算时间点的差距
	 * 
	 * @param startDate 起始时间
	 * @param endDate   终止时间
	 * @param unit      时间单位
	 * @return 时间差
	 */
	private static int getDistanceByUnit(Date startDate, Date endDate, int unit) {
		int result = 0;
		long millisecondPerUnit = MILLISECONDS_PER_DAY;
		switch (unit) {
		case ACCURACY_HOUR:
			millisecondPerUnit = MILLISECONDS_PER_HOUR;
			break;
		case ACCURACY_MINUTE:
			millisecondPerUnit = MILLISECONDS_PER_MINUTE;
			break;
		case ACCURACY_SECOND:
			millisecondPerUnit = MILLISECONDS_PER_SECOND;
			break;
		default:
			break;
		}
		long start = startDate.getTime();
		long end = endDate.getTime();
		long distance = end - start;
		result = Integer.valueOf((distance / millisecondPerUnit) + "");
		return result;
	}

	/**
	 * 返回指定日期是当年的第几周
	 * 
	 * @param date 指定日期
	 * @return 周数（从1开始）
	 */
	public static int getWeekOfYear(Date date) {
		return getCalendar(date).get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 获取指定日期是星期几
	 * 
	 * @param date 指定日期
	 * @return 星期日--1; 星期一--2; 星期二--3; 星期三--4; 星期四--5; 星期五--6; 星期六--7;
	 */
	public static int getWeekOfDate(Date date) {
		return getCalendar(date).get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 判断指定年份日期的年份是否为闰年
	 * 
	 * @param date 日期
	 * @return 闰年ture，非闰年false
	 */
	public static boolean isLeapYear(Date date) {
		int year = getCalendar(date).get(Calendar.YEAR);
		return isLeapYear(year);
	}

	/**
	 * 判断指定年份日期的年份是否为闰年
	 * 
	 * @param year 年份数字
	 * @return 闰年ture，非闰年false
	 */
	public static boolean isLeapYear(int year) {
		if ((year % 400) == 0) {
			return true;
		} else if ((year % 4) == 0) {
			if ((year % 100) == 0) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	/**
	 * 按照strFormat格式输出当前时间
	 * 
	 * @param strFormat 格式
	 * @return 指定格式的当前系统日期
	 */
	public static String getCurrentDate(String strFormat) {
		return getDateStr(getCurrentDate(), strFormat);
	}

	/**
	 * 校验日期数据（校验输入值是否为指定的日期格式）
	 * 
	 * @param strDate   要校验的日期
	 * @param strFormat 日期格式
	 * @return true/false （符合/不符合）
	 */
	public static boolean checkDate(String strDate, String strFormat) {
		Date date = null;
		if ((strDate != null) && (strDate.trim().length() != 0)) {
			java.text.DateFormat myDateFmt = new SimpleDateFormat(strFormat);
			try {
				date = myDateFmt.parse(strDate);

				if (!strDate.equals(myDateFmt.format(date))) {
					date = null;
					return false;
				}
			} catch (java.text.ParseException e) {
				date = null;
				return false;
			}
		}
		return true;
	}

	/** 计算年龄 */
	public static int getAge(Date birthDay) {
		Calendar cal = Calendar.getInstance();
		if (cal.before(birthDay)) {
			throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
		}
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

		cal.setTime(birthDay);
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH);
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

		int age = yearNow - yearBirth;

		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				if (dayOfMonthNow < dayOfMonthBirth) {
					age--;
				}
			} else {
				age--;
			}
		}
		return age;
	}

	public static boolean isToday(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = format.format(date);
		String todayStr = format.format(new Date());
		return todayStr.equals(dateStr);
	}

	public static boolean compareToday(long timestamp) {
		String today = DateUtil.getCurrentDate("yyyy-MM-dd");
		Date d = new Date(timestamp);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String t = sdf.format(d);
		return today.equals(t);
	}

	/**
	 * 抹去时分秒，保留日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date eraseHMS(Date date) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date);
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
		return c1.getTime();
	}

	/**
	 * 两个日期相差月份
	 */
	public static int defferMonth(Date d1, Date d2) {
		int iMonth = 0;
		int flag = 0;
		try {
			Calendar objCalendarDate1 = Calendar.getInstance();
			objCalendarDate1.setTime(d1);

			Calendar objCalendarDate2 = Calendar.getInstance();
			objCalendarDate2.setTime(d2);

			if (objCalendarDate2.equals(objCalendarDate1))
				return 0;
			if (objCalendarDate1.after(objCalendarDate2)) {
				Calendar temp = objCalendarDate1;
				objCalendarDate1 = objCalendarDate2;
				objCalendarDate2 = temp;
			}
			if (objCalendarDate2.get(Calendar.DAY_OF_MONTH) < objCalendarDate1.get(Calendar.DAY_OF_MONTH))
				flag = 1;

			if (objCalendarDate2.get(Calendar.YEAR) > objCalendarDate1.get(Calendar.YEAR))
				iMonth = ((objCalendarDate2.get(Calendar.YEAR) - objCalendarDate1.get(Calendar.YEAR)) * 12 + objCalendarDate2.get(Calendar.MONTH) - flag) - objCalendarDate1.get(Calendar.MONTH);
			else
				iMonth = objCalendarDate2.get(Calendar.MONTH) - objCalendarDate1.get(Calendar.MONTH) - flag;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return iMonth + 1;

	}

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Date date = null;
		try {
			date = sdf.parse("2016-04");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(DateUtil.defferMonth(date, new Date()));
	}

	/**
	 *
	 *
	 tkey为24小时制的当前时间，所在时区为东八区，格式为14位数字如：
	 20160625130530, 客户时间早于或晚于网关时间超过2分钟，则网关拒绝提交。
	 */
	public static String getNowDateString(String sfString) {
		SimpleDateFormat sdf = new SimpleDateFormat(sfString);
		Date date = new Date();
		return sdf.format(date);
	}
}