/**
 * 工程：sdframework
 * 文件：framework.sd.util.LocalDateUtil.java
 */
package com.dy.cache.util;



import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * 类名： LocalDateUtil
 * 概要： LocalDate工具类
 *
 * @version 1.00 ( 2016年1月20日 )
 * @author huwj
 *
 */
public final class LocalDateUtil {
    /**
     * 页面默认展示日期格式
     */
    public static final String DEFAULT_DATE_FORMAT_PATTERN = "yyyy-MM-dd";
    
    /**
     * 回访日期页面默认展示日期格式-精确到小时
     */
    public static final String DEFAULT_HOUR_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    
    /**
     * 默认日期格式(数据库存储格式)
     */
    public static final String DEFAULT_DATE_FORMAT_SHORT_PATTERN = "yyyyMMdd";
    /**
     * 页面默认展示日期格式(年月)
     */
    public static final String DEFAULT_DATE_YM_FORMAT_PATTERN = "yyyy-MM";

    /**
     * 默认日为1的DateTimeFormatter
     *
     * @return
     */
    public static DateTimeFormatter getFormatterWithDay1()
    {
        return getFormatterWithDay1(null);
    }

    /**
     * 默认日为1的DateTimeFormatter
     *
     * @param pattern
     *            日期字符格式
     * @return
     */
    public static DateTimeFormatter getFormatterWithDay1(String pattern)
    {
        if (StringUtils.isEmpty(pattern)) {
            pattern = DEFAULT_DATE_YM_FORMAT_PATTERN;
        }
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        builder.parseDefaulting(ChronoField.DAY_OF_MONTH, 1);
        builder.append(DateTimeFormatter.ofPattern(pattern));
        return builder.toFormatter();
    }

    /**
     * 字符解析日期
     *
     * @param date
     *            日期字符
     * @return 日期
     */
    public static LocalDate parse(String date)
    {
        return parse(date, (String) null);
    }

    /**
     * 字符解析日期
     *
     * @param date
     *            日期字符
     * @param pattern
     *            日期字符格式
     * @return 日期
     */
    public static LocalDate parse(String date, String pattern)
    {
        if (date == null) {
            return null;
        }

        if (StringUtils.isEmpty(pattern)) {
            pattern = DEFAULT_DATE_FORMAT_PATTERN;
        }

        try {
            return LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * 解析日期
     *
     * @param date
     *            日期字符
     * @param formatter
     *            日期格式
     * @return 日期
     */
    public static LocalDate parse(String date, DateTimeFormatter formatter)
    {
        if (date == null || formatter == null) {
            return null;
        }

        try {
            return LocalDate.parse(date, formatter);
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * 格式化
     *
     * @param date
     *            LocalDate
     * @return 格式化字符串
     */
    public static String format(LocalDate date)
    {
        return format(date, null);
    }

    /**
     * 日期格式化字符
     *
     * @param date
     *            日期
     * @param pattern
     *            输出字符格式
     * @return 字符
     */
    public static String format(LocalDate date, String pattern)
    {
        if (date == null)
            return null;
        if (StringUtils.isEmpty(pattern)) {
            pattern = DEFAULT_DATE_FORMAT_PATTERN;
        }

        try {
            return date.format(DateTimeFormatter.ofPattern(pattern));
        } catch (Exception e) {
            return null;
        }

    }
    
    
    public static String formatHour(LocalDateTime localDateTime)
    {
    	return formatHour(localDateTime,null);
    }
    /**
     * 时间格式化字符
     *
     * @param date
     *            日期
     * @param pattern
     *            输出字符格式
     * @return 字符
     */
    
    public static String formatHour(LocalDateTime localDateTime, String pattern)
    {
        if (localDateTime == null)
            return null;
        if (StringUtils.isEmpty(pattern)) {
            pattern = DEFAULT_HOUR_FORMAT_PATTERN;
        }

        try {
        	 DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        	    return localDateTime.format(formatter);
        } catch (Exception e) {
            return null;
        }

    }


    /**
     * 当前日期和指定日期进行比较，大于返回正数，小于返回负数，相等返回0
     *
     * @param dt
     *            指定日期
     * @return
     */
    public static long compare(LocalDate dt)
    {
        LocalDate currentlydate = LocalDate.now();
        return currentlydate.compareTo(dt);
    }

    /**
     * 指定日期进行比较，大于返回正数，小于返回负数，相等返回0
     *
     * @param dt1
     *            指定日期1
     * @param dt1
     *            指定日期2
     * @return
     */
    public static long compare(LocalDate dt1, LocalDate dt2)
    {
        if (dt1 == null) {
            return -1;
        }
        if (dt2 == null) {
            return 1;
        }
        String dtString1 = format(dt1);
        String dtString2 = format(dt2);
        if (StringUtils.equals(dtString1, dtString2)) {
            return 0;
        }
        return dt1.compareTo(dt2);
    }

    /**
     * 转换为日期
     * 
     * @param datetime
     *            时间
     * @return 日期
     */
    public static LocalDate toDate(LocalDateTime datetime)
    {
        if (datetime == null) {
            return null;
        }

        return datetime.toLocalDate();
    }
    
    /**
     * 月份转换
     * @param date
     * @param pattern
     * @return
     */
    public static LocalDate dateParse(String date,String pattern){
    	SimpleDateFormat format = new SimpleDateFormat(pattern);  
        Date date1 = null;  
        LocalDate localDate = null;
        try {  
            date1 = format.parse(date);
            Instant instant = date1.toInstant();
            ZoneId zoneId = ZoneId.systemDefault();
            // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
            localDate = instant.atZone(zoneId).toLocalDate();
        } catch (ParseException e) {
            System.out.println(e.getMessage());  
        } 
    	return localDate;
    }
    
    /**
     * date转换成localdateTime
     * @param date
     * @return
     */
    public static LocalDateTime parseLocalDateTime(Date date) {
    	if(null != date) {
    		 Instant instant = date.toInstant();
             ZoneId zoneId = ZoneId.systemDefault();
    		return instant.atZone(zoneId).toLocalDateTime(); 
    	}
        return null;
    }

    public static LocalDate dateToLocalDate(Date dateTime) {
        if (dateTime == null) {
            return null;
        }
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime.toLocalDate();
    }

}
