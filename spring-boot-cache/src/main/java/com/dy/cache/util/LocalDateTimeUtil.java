/**
 * 工程：sdframework
 * 文件：framework.sd.util.LocalDateTimeUtil.java
 */
package com.dy.cache.util;



import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

/**
 * 类名： LocalDateTimeUtil
 * 概要： LocalDateTime工具类
 *
 * @version 1.00 ( 2015年12月25日 )
 * @author huanghuajun
 *
 */
public class LocalDateTimeUtil {

    /**
     * 构造器。
     */
    protected LocalDateTimeUtil()
    {
    }

    /**
     * 默认格式
     */
    public static final String DEFAULT_DATETIME_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final String DEFAULT_DATE_FORMAT_PATTERN = "yyyy-MM-dd";

    /**
     * 格式化
     *
     * @param datetime
     *            LocalDateTime
     * @return 格式化字符串
     */
    public static String format(LocalDateTime datetime)
    {
        return format(datetime, null);
    }

    /**
     * 格式化
     *
     * @param datetime
     *            LocalDateTime
     * @param pattern
     *            格式化Pattern
     * @return 格式化字符串
     */
    public static String format(LocalDateTime datetime, String pattern)
    {
        if (datetime == null) {
            return null;
        }
        if (StringUtils.isEmpty(pattern)) {
            pattern = DEFAULT_DATETIME_FORMAT_PATTERN;
        }
        return datetime.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String format(Long datetime)
    {
        if (datetime == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT_PATTERN);
        return sdf.format(new Date(datetime));
    }

    /**
     * 解析
     *
     * @param datetime
     *            字符串
     * @return LocalDateTime
     */
    public static LocalDateTime parse(String datetime)
    {
        return parse(datetime, (String) null);
    }

    /**
     * 解析
     *
     * @param datetime
     *            字符串
     * @param pattern
     *            解析Pattern
     * @return LocalDateTime
     */
    public static LocalDateTime parse(String datetime, String pattern)
    {
        if (StringUtils.isEmpty(pattern)) {
            // 默认日期转换格式
            pattern = DEFAULT_DATETIME_FORMAT_PATTERN;
        }
        try {
            // 尝试给定日期转换格式
            return LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern(pattern));
        } catch (Exception ep) {
            try {
                // 尝试spring默认日期转换格式
                return LocalDateTime.parse(datetime,
                        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT, FormatStyle.SHORT));
            } catch (Exception el) {
                try {
                    // 尝试Java默认日期转换格式
                    return LocalDateTime.parse(datetime);
                } catch (Exception ex) {
                    return null;
                }
            }
        }
    }

    /**
     * 解析
     *
     * @param datetime
     *            字符串
     * @param formatter
     *            格式
     * @return LocalDateTime
     */
    public static LocalDateTime parse(String datetime, DateTimeFormatter formatter)
    {
        try {
            // 尝试给定日期转换格式
            return LocalDateTime.parse(datetime, formatter);
        } catch (Exception ep) {
            try {
                // 尝试spring默认日期转换格式
                return LocalDateTime.parse(datetime,
                        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT, FormatStyle.SHORT));
            } catch (Exception el) {
                try {
                    // 尝试Java默认日期转换格式
                    return LocalDateTime.parse(datetime);
                } catch (Exception ex) {
                    return null;
                }
            }
        }
    }

    /**
     * 当前时间和指定时间进行比较，大于返回正数，小于返回负数，相等返回0
     *
     * @param dt
     *            指定日期
     * @return
     */
    public static long compare(LocalDateTime dt)
    {
        LocalDateTime currentlytime = LocalDateTime.now();
        return currentlytime.compareTo(dt);
    }

    /**
     * 指定时间进行比较，大于返回正数，小于返回负数，相等返回0
     *
     * @param dt1
     *            指定日期1
     * @param dt1
     *            指定日期2
     * @return
     */
    public static long compare(LocalDateTime dt1, LocalDateTime dt2)
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
     * 转换为时间
     *
     * @param date
     *            日期
     * @return 时间
     */
    public static LocalDateTime toDateTime(LocalDate date)
    {
        if (date == null) {
            return null;
        }

        return LocalDateTime.of(date, LocalTime.of(0, 0, 0));
    }

}
