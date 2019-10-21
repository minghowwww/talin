package com.asianrapid.talin.common.utils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DateUtil {

	private static Lock lock = new ReentrantLock();

	private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap<String, ThreadLocal<SimpleDateFormat>>();

	/**
	 * 返回一个ThreadLocal的sdf,每个线程只会new一次sdf
	 * 
	 * @param pattern
	 * @return
	 */
	public static SimpleDateFormat getSdf(final String pattern) {
		ThreadLocal<SimpleDateFormat> tl = sdfMap.get(pattern);
		// 此处的双重判断和同步是为了防止sdfMap这个单例被多次put重复的sdf
		if (tl == null) {
			lock.lock();
			try {
				tl = sdfMap.get(pattern);
				if (tl == null) {
					// 使用ThreadLocal<SimpleDateFormat>替代原来直接new SimpleDateFormat
					tl = new ThreadLocal<SimpleDateFormat>() {
						@Override
						protected SimpleDateFormat initialValue() {
							return new SimpleDateFormat(pattern);
						}
					};
					sdfMap.put(pattern, tl);
				}
			} finally {
				lock.unlock();
			}
		}

		return tl.get();
	}

	public static SimpleDateFormat getFormatYMD() {
		return getSdf("yyyy-MM-dd");
	}

	public static SimpleDateFormat getFormatYMDHMS() {
		return getSdf("yyyy-MM-dd HH:mm:ss");
	}

	public static SimpleDateFormat getFormatYMDHM() {
		return getSdf("yyyy-MM-dd HH:mm");
	}

	public static SimpleDateFormat getFormatYM() {
		return getSdf("yyyy-MM");
	}

	public static SimpleDateFormat getFormatHM() {
		return getSdf("HH:mm");
	}

	public static SimpleDateFormat getFormatYMDCN() {
		return getSdf("yyyy年MM月dd日");
	}

	public static SimpleDateFormat getFormatMDCN() {
		return getSdf("MM月dd日");
	}

	public static SimpleDateFormat getFormatISO() {
		return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
	}

	// 一天的毫秒数 60*60*1000*24
	private final static long DAY_MILLIS = 86400000;

	// 一小时的毫秒数 60*60*1000
	private final static long HOUR_MILLIS = 3600000;

	// 一分钟的毫秒数 60*1000
	private final static long MINUTE_MILLIS = 60000;

	public static Date parse(String date) {
		try {
			return getFormatYMDHMS().parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("时间格式错误");
		}
	}

	public static Date parseYMD(String date) {
		try {
			return getFormatYMD().parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("时间格式错误");
		}
	}

	public static Date parseHM(String date) {
		try {
			return getFormatHM().parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("时间格式错误");
		}
	}

	public static Date parseYMDHM(String date) {
		try {
			return getFormatYMDHM().parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("时间格式错误");
		}
	}

	public static Date parseYM(String date) {
		try {
			return getFormatYM().parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("时间格式错误");
		}
	}

	public static String format(Date date) {
		return getFormatYMDHMS().format(date);
	}

	public static String formatYMD(Date date) {
		return getFormatYMD().format(date);
	}

	public static String formatYM(Date date) {
		return getFormatYM().format(date);
	}

	public static String formatMDCN(Date date) {
		return getFormatMDCN().format(date);
	}

	public static String formatYMDHM(Date date) {
		return getFormatYMDHM().format(date);
	}

	public static String formatHM(Date date) {
		return getFormatHM().format(date);
	}

	/**
	 * 
	 * @Title: getDateNextDay
	 * @Description: 当前日期后一天
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 * @return: String
	 */
	public static String getDateNextDay(String dateStr) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getFormatYMD().parse(dateStr));
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		return getFormatYMD().format(calendar.getTime());
	}

	/**
	 * 
	 * @Title: getDateNextDay
	 * @Description: 当前日期前一天
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 * @return: String
	 */
	public static String getDateBeforeDay(String dateStr) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getFormatYMD().parse(dateStr));
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		return getFormatYMD().format(calendar.getTime());
	}

	/**
	 * 是否是今天
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isToday(final Date date) {
		return isTheDay(date, new Date());
	}

	/**
	 * 是否是指定日期
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static boolean isTheDay(final Date date, final Date day) {
		return date.getTime() >= DateUtil.dayBegin(day).getTime() && date.getTime() <= DateUtil.dayEnd(day).getTime();
	}

	/**
	 * 获取指定时间的那天 00:00:00.000 的时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date dayBegin(final Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	/**
	 * 获取指定时间的那天 23:59:59.999 的时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date dayEnd(final Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
		return c.getTime();
	}

	public static Set<Integer> getWeeks(Date dateFrom, Date dateTo) {
		Set<Integer> set = new HashSet<Integer>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateFrom);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		while (dateTo.after(calendar.getTime())) {
			set.add(calendar.get(Calendar.DAY_OF_WEEK));
			calendar.add(Calendar.DATE, 1);
		}
		return set;
	}

	public static List<String> getDayList(Date from, Date to) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<String> list = new ArrayList<String>();
		Calendar cfrom = Calendar.getInstance();
		cfrom.setTime(from);
		cfrom.set(Calendar.HOUR_OF_DAY, 0);
		cfrom.set(Calendar.MINUTE, 0);
		cfrom.set(Calendar.SECOND, 0);
		cfrom.set(Calendar.MILLISECOND, 0);
		while (cfrom.getTime().before(to)) {
			list.add(sdf.format(cfrom.getTime()));
			cfrom.add(Calendar.DAY_OF_MONTH, 1);
		}
		return list;
	}

	public static List<String> getMonthList(Date from, Date to) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		List<String> list = new ArrayList<String>();
		Calendar cfrom = Calendar.getInstance();
		cfrom.setTime(from);
		cfrom.set(Calendar.DAY_OF_MONTH, 1);
		cfrom.set(Calendar.HOUR_OF_DAY, 0);
		cfrom.set(Calendar.MINUTE, 0);
		cfrom.set(Calendar.SECOND, 0);
		cfrom.set(Calendar.MILLISECOND, 0);
		while (cfrom.getTime().before(to)) {
			list.add(sdf.format(cfrom.getTime()));
			cfrom.add(Calendar.MONTH, 1);
		}
		return list;
	}

	public static int getHour(Date startTime, Date endTime) {
		long microseconds = endTime.getTime() - startTime.getTime();

		long hours = microseconds / (1000 * 60 * 60);

		if (microseconds % (1000 * 60 * 60) > 0)
			hours += 1;
		return new BigDecimal(hours).intValue();
	}

	// 计算天数，不满一天算一天
	public static int getDay(Date startTime, Date endTime) {
		long microseconds = endTime.getTime() - startTime.getTime();

		long day = microseconds / (1000 * 60 * 60 * 24);

		if ((microseconds % (1000 * 60 * 60 * 24) - 1000) > 0)
			day += 1;
		return new BigDecimal(day).intValue();
	}

	public static long timeSpan(Date endDate, Date startDate) {
		if (endDate.compareTo(startDate) < 0) {
			throw new RuntimeException("endDate must be bigger than startDate");
		}

		return endDate.getTime() - startDate.getTime();
	}

	public static String getYear() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		String year = df.format(new Date());
		return year;
	}

	public static String getMonthDay() {
		SimpleDateFormat df = new SimpleDateFormat("MMdd");
		String md = df.format(new Date());
		return md;
	}

	public static Date addHour(Date date, int hour) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, hour);
		return calendar.getTime();
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差小时数
	 * @throws ParseException
	 */
	public static long timesBetween(Date smdate, Date bdate, String timeType) {

		long startL = smdate.getTime();
		long endL = bdate.getTime();

		if (timeType.equals("DAY")) {
			return (endL - startL) / DAY_MILLIS;
		} else if (timeType.equals("HOUR")) {
			return (endL - startL) / HOUR_MILLIS;
		} else if (timeType.equals("MINUTE")) {
			return (endL - startL) / MINUTE_MILLIS;
		} else {
			return (endL - startL);
		}

	}

	public static boolean CalendarBetweenDate(Date date1, Date date2, Calendar calendar) {
		if (calendar.getTime().getTime() >= date1.getTime() && calendar.getTime().getTime() <= date2.getTime())
			return true;
		return false;
	}

	public static List<Calendar> getMonthDays(Date date) {
		if (date == null)
			return null;
		List<Calendar> calendars = new ArrayList<Calendar>();
		Calendar from = Calendar.getInstance();
		Calendar to = Calendar.getInstance();
		from.setTime(date);
		from.set(Calendar.DAY_OF_MONTH, 1);
		to.setTime(date);
		to.set(Calendar.DAY_OF_MONTH, to.getActualMaximum(Calendar.DAY_OF_MONTH));
		while (from.compareTo(to) <= 0) {
			Calendar newCalendar = Calendar.getInstance();
			newCalendar.setTime(from.getTime());
			calendars.add(newCalendar);
			from.add(Calendar.DAY_OF_MONTH, 1);
		}
		return calendars;
	}

	public static int getMonthDayTotal(Date date) {
		if (date == null)
			return 0;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	public static int getDayOfMonth(Date date) {
		if (date == null)
			return 0;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	public static int getDayOfWeek(Date date) {
		if (date == null)
			return 0;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int weekday = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if(weekday == 0){
			weekday = 7;
		}
		return weekday;
	}

	public static Date addDay(Date date, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, day);
		return calendar.getTime();
	}

	public static void main(String[] args) throws Exception {
		System.out.println(getFirstOfWeek("2018-10-22","yyyy-MM-dd","yyyy-MM-dd"));
		System.out.println(getLastOfWeek("2018-10-22","yyyy-MM-dd","yyyy-MM-dd"));
		System.out.println(getDayOfWeek(DateUtil.parseYMD("2018-08-27")));
		String timeStr = "2018-08-22 19:32:25";
		System.out.println(getDateNextHalfHour(parse(timeStr)));
		System.out.println(addDateHalfHour(getDateNextHalfHour(parse(timeStr))));
		String dateStr = "2016-03-04T03:03:02+07:00";
		try {
			System.out.println(getNewDate2String());
			System.out.println(getFormatISO().format(new Date()));

			Date date = getFormatISO().parse(dateStr);
			System.out.println(getFormatYMDHMS().format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}


	}

	/**
	 * 获取当前时间并格式化：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getNewDate2String(){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 将当前时间格式化为yyMMddHHmm
	 * @return
	 */
	public static String getNewDate2ymdhmString(){
		return new SimpleDateFormat("yyMMddHHmm").format(new Date());
	}

	/**
	 *
	 * @Title: getDateNextHalfHour
	 * @Description: 获取日期的下个半点，如果已经是半点，则返回原数据
	 * @param date
	 * @return
	 * @throws ParseException
	 * @return: Date
	 */
	public static Date getDateNextHalfHour(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if(calendar.get(Calendar.MINUTE) == 0 || calendar.get(Calendar.MINUTE) == 30){
			calendar.set(Calendar.SECOND,0);
			return date;
		}
		calendar.setTimeInMillis(date.getTime() + 30 * 60 * 1000);
		if(calendar.get(Calendar.MINUTE) >= 30){
			calendar.set(Calendar.MINUTE,30);
		}else{
			calendar.set(Calendar.MINUTE,0);
		}
		calendar.set(Calendar.SECOND,0);
		return calendar.getTime();
	}

	/**
	 *
	 * @Title: getDateNextHalfHour
	 * @Description: 日期增加半小时
	 * @param date
	 * @return
	 * @throws
	 * @return: Date
	 */
	public static Date addDateHalfHour(Date date) {
		return new Date(date.getTime() + 30 * 60 * 1000);
	}

	/**
	 * 每周的第一天
	 * @param dataStr
	 * @param dateFormat
	 * @param resultDateFormat
	 * @return
	 * @throws ParseException
	 */
	public static String getFirstOfWeek(String dataStr,String dateFormat,String resultDateFormat) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new SimpleDateFormat(dateFormat).parse(dataStr));
		buildFirstOfWeek(cal);
		// 所在周开始日期
		String data = new SimpleDateFormat(resultDateFormat).format(cal.getTime());
		return data;

	}

	private static void buildFirstOfWeek(Calendar cal){
		int d;
		if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
			d = -6;
		} else {
			d = 2 - cal.get(Calendar.DAY_OF_WEEK);
		}
		cal.add(Calendar.DAY_OF_WEEK, d);
	}

	/**
	 * 每周的最后一天
	 * @param dataStr
	 * @param dateFormat
	 * @param resultDateFormat
	 * @return
	 * @throws ParseException
	 */
	public static String getLastOfWeek(String dataStr,String dateFormat,String resultDateFormat) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new SimpleDateFormat(dateFormat).parse(dataStr));
		buildFirstOfWeek(cal);
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) + 6);
		// 所在周结束日期
		String data = new SimpleDateFormat(resultDateFormat).format(cal.getTime());
		return data;

	}

}
