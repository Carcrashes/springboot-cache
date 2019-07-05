package com.dy.cache.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DatetimeUtil {

	public final static String DATETIME_PATTERN = "yyyyMMddHHmmss";

	public final static String TIME_STAMP_PATTERN = "yyyyMMddHHmmssSSS";

	public final static String DATE_PATTERN = "yyyyMMdd";

	public final static String TIME_PATTERN = "HHmmss";

	public final static String STANDARD_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

	public final static String STANDARD_DATETIME_PATTERN_HM = "yyyy-MM-dd HH:mm";

	public final static String STANDARD_DATE_PATTERN = "yyyy-MM-dd";

	public final static String STANDARD_OF_DATE = "yyyy年MM月dd日";

	public final static String STANDARD_TIME_PATTERN = "HH:mm:ss";

	public final static String STANDARD_DATETIME_PATTERN_SOLIDUS = "yyyy/MM/dd HH:mm:ss";

	public final static String STANDARD_DATETIME_PATTERN_SOLIDUS_HM = "yyyy/MM/dd HH:mm";

	public final static String STANDARD_DATE_PATTERN_SOLIDUS = "yyyy/MM/dd";

	private DatetimeUtil() {
		super();
	}

	public static Timestamp currentTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	public static String currentDatetime() {
		return formatDate(new Date());
	}

	public static Timestamp parseDate(String dateStr, String pattern) throws ParseException {
		Date d = DatetimeUtil.parse(dateStr, pattern);
		return new Timestamp(d.getTime());
	}

	public static Timestamp parseDate(String dateStr) throws ParseException {
		return parseDate(dateStr, STANDARD_DATE_PATTERN);
	}

	public static java.sql.Date parseSQLDate(String dateStr, String pattern) throws ParseException {
		Date d = parse(dateStr, pattern);
		return new java.sql.Date(d.getTime());
	}

	public static java.sql.Date parseSQLDate(String dateStr) throws ParseException {
		Date d = parse(dateStr, STANDARD_DATE_PATTERN);
		return new java.sql.Date(d.getTime());
	}

	public static Timestamp getFutureTime(int month) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, month);
		return new Timestamp(c.getTimeInMillis());
	}

	/**
	 * 显示今天时间
	 * 
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String today() {
		return formatDateTime(new Date());
	}

	public static String formatDate(Timestamp t) {
		return formatDate(new Date(t.getTime()));
	}

	public static String formatDate(Timestamp t, String pattern) {
		return formatDate(new Date(t.getTime()), STANDARD_DATE_PATTERN);
	}

	public static String formatDateTime(Timestamp t, String pattern) {
		return formatDate(new Date(t.getTime()), STANDARD_DATETIME_PATTERN);
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @return yyyy-MM-dd
	 */
	public static String formatDate(Date date) {
		return formatDate(date, STANDARD_DATE_PATTERN);
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @return yy年MM月dd日
	 */
	public static String formatOfDate(Date date) {
		return formatDate(date, STANDARD_OF_DATE);
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, STANDARD_DATETIME_PATTERN);
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 *            日期
	 * @param pattern
	 *            格式
	 * @return
	 */
	public static String formatDate(Date date, String pattern) {
		if (date == null)
			return null;
		DateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	/**
	 * 解析日期
	 * 
	 * @param dateStr
	 *            yyyy-MM-dd
	 * @return
	 */
	public static Date parse(String dateStr) {
		return parse(dateStr, STANDARD_DATE_PATTERN);
	}

	/**
	 * 解析日期
	 * 
	 * @param dateStr
	 *            yyyy年MM月dd日
	 * @return
	 */
	public static Date parseOf(String dateStr) {
		return parse(dateStr, STANDARD_OF_DATE);
	}

	/**
	 * 解析日期
	 * 
	 * @param dateStr
	 *            yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Date parseTime(String dateStr) {
		return parse(dateStr, STANDARD_DATETIME_PATTERN);
	}

	public static Date parse(String dateStr, String pattern) {

		try {
			DateFormat format = new SimpleDateFormat(pattern);
			return format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 当月的第一天
	 * 
	 * @return
	 */
	public static String firstDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return DatetimeUtil.formatDate(calendar.getTime()) + " 00:00:00";
	}

	/**
	 * 当月的最后一天
	 * 
	 * @return
	 */
	public static String lastDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 0);
		return DatetimeUtil.formatDate(calendar.getTime()) + " 23:59:59";
	}

	/**
	 * 解析str是否为pattern时间格式的字符串
	 * 
	 * @param str
	 * @param pattern
	 * @return
	 */
	public static boolean isValidDate(String str, String pattern) {
		boolean convertSuccess = true;
		// 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			// 设置lenient为false.
			// 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
			format.setLenient(false);
			format.parse(str);
		} catch (ParseException e) {
			// e.printStackTrace();
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			convertSuccess = false;
		}
		return convertSuccess;
	}

	/**
	 * 将yy-MM-dd 转为 yy年MM月dd日
	 * 
	 * @param str
	 * @return
	 */
	public static Date dateFormatTransfer(String str) {
		Date parse = parse(formatOfDate(parse(str)), STANDARD_OF_DATE);
		return parse;
	}
	
	 /**
     * 获取当月的 天数
     */
    public static int getCurrentMonthDay() {

        Calendar a = Calendar.getInstance();
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 根据 年、月 获取对应的月份 的 天数
     */
    public static int getDaysByYearMonth(int year, int month) {

        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 根据日期 找到对应日期的 星期几
     */
    public static String getDayOfWeekByDate(String date) {
        String dayOfweek = "-1";
        try {
            SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
            Date myDate = myFormatter.parse(date);
            SimpleDateFormat formatter = new SimpleDateFormat("E");
            String str = formatter.format(myDate);
            dayOfweek = str;

        } catch (Exception e) {
            System.out.println("错误!");
        }
        return dayOfweek;
    }
    
    //计算起始时间间隔时间
    public static ArrayList<String> GetDates(String startDate, String endDate){
    	ArrayList<String> dates = new ArrayList<>();
    	try {
			Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);//定义起始日期
			Long startTime = d1.getTime();
			Date d2 = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);//定义结束日期
			Long endTime = d2.getTime();
			Long oneDay = 1000 * 60 * 60 * 24l;
			Long time = startTime;
			while (time <= endTime) {//判断是否到结束日期
				Date d = new Date(time); 
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String str = sdf.format(d);
				dates.add(str);
				time += oneDay;//进行当前日期月份加1
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return dates;
    }

	/**
	 * 获取本月前几个月或者后几个月的日期
	 * @param number
	 * @return
	 */
	public static Date getBeforeOrAfterMonth(Integer number) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, number);
		Date date = calendar.getTime();
		return date;
	}

	/**
	 * 获取前几天或后几天
	 * @param number
	 * @return
	 * @throws ParseException
	 */
	public static Date getBeforeOrAfterDay(Integer number) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(STANDARD_DATE_PATTERN);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, number);
		Date date = calendar.getTime();
		return sdf.parse(sdf.format(date));
	}

    
}
