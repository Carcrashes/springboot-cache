package com.dy.cache.util;



import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类名： DateUtil
 * 概要：
 *
 * @version 1.00 ( 2017年5月16日 )
 * @author huanghuajun
 *
 */
public class DateUtil {

    /**
     * 构造器
     */
    private DateUtil()
    {

    }

    /**
     * 获取所有分期还款日(月付)
     *
     * @param firstRepaymentDay
     *            首付日
     * @param numberOfInstallments
     *            分期数
     * @return 分期还款日集合
     */
    public static List<LocalDate> allRepaymentDays(LocalDate firstRepaymentDay, int numberOfInstallments)
    {
        if (firstRepaymentDay == null || numberOfInstallments <= 0) {
            return new ArrayList<LocalDate>();
        }

        List<LocalDate> repaymentDays = new ArrayList<LocalDate>(numberOfInstallments);
        for (int i = 0; i < numberOfInstallments; i++) {

            repaymentDays.add(firstRepaymentDay.plusMonths(i + 1).withDayOfMonth(15));
        }

        return repaymentDays;
    }


    /**
     * 获取所有分期还款日(月付)的合并字符串
     *
     * @param firstRepaymentDay
     *            首付日
     * @param numberOfInstallments
     *            分期数
     * @param delim
     *            合并分隔符
     * @param datePattern
     *            日期格式化模式
     * @return 分期还款日合并字符串
     */
    public static String allRepaymentDaysToString(LocalDate firstRepaymentDay, int numberOfInstallments, String delim,
            String datePattern)
    {
        if (delim == null) {
            delim = "";
        }
        return allRepaymentDays(firstRepaymentDay, numberOfInstallments).stream()
                .map(date -> LocalDateUtil.format(date, datePattern)).collect(Collectors.joining(delim));
    }

    /**
     * 获取所有分期还款日(月付)的合并字符串
     *
     * @param firstRepaymentDay
     *            首付日
     * @param numberOfInstallments
     *            分期数
     * @param delim
     *            合并分隔符
     * @return 分期还款日合并字符串
     */
    public static String allRepaymentDaysToString(LocalDate firstRepaymentDay, int numberOfInstallments, String delim)
    {
        return allRepaymentDaysToString(firstRepaymentDay, numberOfInstallments, delim, null);
    }

    /**
     * 转换年月
     * 
     * @param strDateYM
     *            年月字符串
     * @return LocalDate
     */
    public static LocalDate parseDateYM(String strDateYM)
    {
        return parseDateYM(strDateYM, null);
    }

    /**
     * 转换年月
     * 
     * @param strDateYM
     *            年月字符串
     * @param pattern
     *            转换模式
     * @return LocalDate
     */
    public static LocalDate parseDateYM(String strDateYM, String pattern)
    {
        LocalDate dateYM = null;
        try {
            dateYM = LocalDateUtil.parse(strDateYM, LocalDateUtil.getFormatterWithDay1(pattern));
        } catch (Exception e) {
            dateYM = null;
        }
        return dateYM;
    }

    /**
     * 转换年月
     * 
     * @param strDateYM
     *            年月字符串
     * @return LocalDateTime
     */
    public static LocalDateTime parseDateTimeYM(String strDateYM)
    {
        return parseDateTimeYM(strDateYM, null);
    }

    /**
     * 转换年月
     * 
     * @param strDateYM
     *            年月字符串
     * @param pattern
     *            转换模式
     * @return LocalDateTime
     */
    public static LocalDateTime parseDateTimeYM(String strDateYM, String pattern)
    {
        return LocalDateTimeUtil.toDateTime(parseDateYM(strDateYM, pattern));
    }

    public static String formatDate2Str(Long seconds){
    	String totalDate = "";
    	if(seconds != null){
    		//天计算
			long days = (seconds)/(24*3600);
		    //小时计算
			long hours = (seconds)%(24*3600)/3600;
		    //分钟计算
			long minutes = (seconds)%3600/60;
		    //秒计算
			long second = (seconds)%60;
			totalDate = days + " 天 " + hours + " 小时 " + minutes + " 分钟 " + second + " 秒 ";
    	}
		return totalDate;
    }
    
    /**
     * 格式化时间
     * @param date
     * @param pattern
     * @return
     */
    public static String formatMonth(Date date,String pattern){
    	SimpleDateFormat format = new SimpleDateFormat(pattern);
    	String time = null;
    	try {
    		time = format.format(date);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
    	return time;
    }
    
    /**
     * number 0:当前月    -1：上月 以此类推
     * 获取当前年份/月份 /日等 
     * @return
     */
    public static String getCurrentMonth(String patten, Integer number) {
    	SimpleDateFormat sdf = new SimpleDateFormat(patten);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, number);
		Date date = calendar.getTime();
	    return sdf.format(date);
    }
    
    /**
     * 获取本月或者前后月的第一天
     * 例如本月number：0  上月 ： -1
     * @return
     */
    public static LocalDate getFirstDayOfMonth(int number) {
    	//获取当前日期 
    	Calendar calendar = Calendar.getInstance();
    	calendar.add(Calendar.MONTH, number);
    	//设置为1号,当前日期既为本月第一天 
    	calendar.set(Calendar.DAY_OF_MONTH,1);
        Date date = calendar.getTime();
		Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		return LocalDateTime.ofInstant(instant, zone).toLocalDate();
    }
    
    /**
     * 获取本月或者前后月的第一天早上00:00:00
     * 例如本月number：0  上月 ： -1
     * @return
     */
    @SuppressWarnings("deprecation")
	public static LocalDateTime getFirstDayOfMonthMorning(int number) {
    	//获取当前日期 
    	Calendar calendar = Calendar.getInstance();
    	calendar.add(Calendar.MONTH, number);
    	//设置为1号,当前日期既为本月第一天 
    	calendar.set(Calendar.DAY_OF_MONTH,1);
        Date date = calendar.getTime();
        date.setHours(0);
		date.setMinutes(0);
		date.setSeconds(0);
		Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		return LocalDateTime.ofInstant(instant, zone);
    }
    
    /**
     * 获取本月前几个月或者后几个月的日期
     * @param number
     * @return
     */
    public static LocalDate getBeforeOrAfterMonth(Integer number) {
    	Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, number);
		Date date = calendar.getTime();
		Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		return LocalDateTime.ofInstant(instant, zone).toLocalDate();
    }
    
    /**
     * 获取今天前或者后几个月的凌晨12点整
     * @param number
     * @return
     */
    @SuppressWarnings("deprecation")
	public static LocalDateTime getBeforeOrAfterMonthMorning(Integer number){
    	Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, number);
		Date date = calendar.getTime();
		date.setHours(0);
		date.setMinutes(0);
		date.setSeconds(0);
		Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		return LocalDateTime.ofInstant(instant, zone);
	}
    
    /**
     * 获取今天前或者后几天的凌晨12点整
     * @param number
     * @return
     */
    @SuppressWarnings("deprecation")
	public static LocalDateTime getBeforeOrAfterDayMorning(Integer number){
    	Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, number);
		Date date = calendar.getTime();
		date.setHours(0);
		date.setMinutes(0);
		date.setSeconds(0);
		Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		return LocalDateTime.ofInstant(instant, zone);
	}
    
    /**
     * 获取本月当天或者上月，下月当天
     * 例如本月number：0  上月 ： -1
     * @return
     */
    public static LocalDate getCurrentDayOfMonth(int number) {
    	//获取当前日期 
    	Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, number);
        Date date = calendar.getTime();
		Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		return LocalDateTime.ofInstant(instant, zone).toLocalDate();
    }
    
    /**
     * 获取本月当天或者上月，下月当天晚上23:59:59
     * 例如本月number：0  上月 ： -1
     * @return
     */
    @SuppressWarnings("deprecation")
	public static LocalDateTime getCurrentDayOfMonthNight(int number) {
    	//获取当前日期 
    	Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, number);
        Date date = calendar.getTime();
        date.setHours(23);
		date.setMinutes(59);
		date.setSeconds(59);
		Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		return LocalDateTime.ofInstant(instant, zone);
    }

    public static String getBeforeOrAfterYear(int number){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, number);
        Date time = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        return format.format(time);
    }

    /**
     * 获取当天或者昨天，明天晚上23:59:59
     * 例如本天number：0  昨天 ： -1
     * @return
     */
    @SuppressWarnings("deprecation")
	public static LocalDateTime getCurrentDayOfDayNight(int number) {
    	//获取当前日期 
    	Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, number);
        Date date = calendar.getTime();
        date.setHours(23);
		date.setMinutes(59);
		date.setSeconds(59);
		Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		return LocalDateTime.ofInstant(instant, zone);
    }
    
    /**
     * 今天除以本月的总共天数    比如  13/31
     */
    public static BigDecimal getCurrentMonthProgress() {
    	Calendar calendar = Calendar.getInstance();
    	//本月的天数
    	int day = calendar.getActualMaximum(Calendar.DATE);
    	//今天
    	String toDay = getCurrentMonth("d",0);
    	return BigDecimalUtil.calDivide(new BigDecimal(Integer.parseInt(toDay)),new BigDecimal(day),4);
    }
    
    /**
     * 获取本月前几天或者后几天的日期
     * @param number
     * @return
     */
    public static LocalDateTime getBeforeOrAfterDay(Integer number) {
    	Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, number);
		Date date = calendar.getTime();
		Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		return LocalDateTime.ofInstant(instant, zone);
    }
    
    /**
     * 获取本月或者前几月最后一天
     */
    public static LocalDate getLastDayOfMonth(Integer number) {
    	Calendar calendar = Calendar.getInstance(); 
    	calendar.add(Calendar.MONTH, number);
    	calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
        Date date = calendar.getTime();
		Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		return LocalDateTime.ofInstant(instant, zone).toLocalDate();
    }

    /**
     * 日期转换
     */
    public static String toDate(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        Date date = Date.from(zdt.toInstant());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }

    /**
     * 获取指定年月的第一天
     * @param year
     * @param month
     * @return
     */
    public static LocalDateTime getFirstDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);
        //获取某月最小天数
        int firstDay = cal.getMinimum(Calendar.DATE);
        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH,firstDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String s = sdf.format(cal.getTime());
        LocalDate localDate = LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return localDate.atStartOfDay();
    }

    /**
     * 获取指定年月的最后一天
     * @param year
     * @param month
     * @return
     */
    public static LocalDateTime getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DATE);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String s = sdf.format(cal.getTime());
        LocalDate localDate = LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return localDate.atStartOfDay();
    }

    public static String getMonth(LocalDate date){
        if(date != null){
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM");
            return date.format(fmt);
        }
        return null;
    }


    public static void main(String[] args) {
    	//System.out.println(getLastDayOfMonth(-1));
    	//System.out.println(getBeforeOrAfterDayMorning(-1));
        List<LocalDate> allRepaymentDays=allRepaymentDays(LocalDate.now(),3);
        for(LocalDate l:allRepaymentDays){
            System.out.println(l.toString());
        }
	}
    
}
