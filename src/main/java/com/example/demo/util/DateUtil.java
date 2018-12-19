package com.example.demo.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static final String FMT_SEPERATOR_yMdHms = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * yyyyMMddHHmmss
	 */
	public static final String FMT_yMdHms="yyyyMMddHHmmss";
	
	/**
	 * yyyy-MM-dd
	 */
	public static final String FMT_SEPERATOR_yMd = "yyyy-MM-dd";
	
	/**
	 * yyyyMMdd
	 */
	public static final String FMT_yMd="yyyyMMdd";
	
	/**
	 *  HH:mm:ss
	 */
	public static final String FMT_SEPERATOR_Hms = " HH:mm:ss";
	
	/**
	 *  23:59:59
	 */
	public static final String FMT_SEPERATOR_Hms_FIRST = " 00:00:00";
	/**
	 *  23:59:59
	 */
	public static final String FMT_SEPERATOR_Hms_LAST = " 23:59:59";
	
	public static final String PREV_MONTH_FIRST_DAY="prevMonthFD";
	
	public static final String PREV_MONTH_END_DAY="prevMonthPD";
	
	/**
	 * 返回自定义格式时间
	 * 
	 * @param time 时间戳
	 * @param fmt  yyyy-MM-dd HH:mm:ss
	 * @return 日期字符串
	 */
	public static String formatTime(Timestamp time, String fmt) {
		if (time == null) {
			return "";
		}
		SimpleDateFormat myFormat = new SimpleDateFormat(fmt);
		return myFormat.format(time);
	}
	public static long getTimeMillis(String time) {
		try {
			DateFormat dateFormat = new SimpleDateFormat(FMT_SEPERATOR_yMdHms);
			DateFormat dayFormat = new SimpleDateFormat(FMT_SEPERATOR_yMd);
			Date curDate = dateFormat.parse(dayFormat.format(new Date()) + " " + time);
			return curDate.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 返回自定义格式时间
	 * 
	 * @param time 时间戳
	 * @param fmt  yyyy-MM-dd HH:mm:ss
	 * @return 日期字符串
	 */
	public static String formatDate(Date time) {
		if (time == null) {
			return "";
		}
		SimpleDateFormat myFormat = new SimpleDateFormat(FMT_SEPERATOR_yMdHms);
		return myFormat.format(time);
	}

	/**
	 * 获取当前时间戳
	 * 
	 * @return
	 */
	public static Timestamp getTime() {
		SimpleDateFormat myFormat = new SimpleDateFormat(FMT_SEPERATOR_yMdHms);
		Calendar calendar = Calendar.getInstance();
		String mystrdate = myFormat.format(calendar.getTime());
		return Timestamp.valueOf(mystrdate);
	}

	/**
	 * 获取每天开始时间戳
	 * 
	 * @return
	 */
	public static Timestamp getDateFirst() {
		SimpleDateFormat myFormat = new SimpleDateFormat(FMT_SEPERATOR_yMd+FMT_SEPERATOR_Hms_FIRST);
		Calendar calendar = Calendar.getInstance();
		String mystrdate = myFormat.format(calendar.getTime());
		return Timestamp.valueOf(mystrdate);
	}

	/**
	 * 获取每天结束时间戳
	 * 
	 * @return
	 */
	public static Timestamp getDateLast() {
		SimpleDateFormat myFormat = new SimpleDateFormat(FMT_SEPERATOR_yMd+FMT_SEPERATOR_Hms_LAST);
		Calendar calendar = Calendar.getInstance();
		String mystrdate = myFormat.format(calendar.getTime());
		return Timestamp.valueOf(mystrdate);
	}

	/**
	 * 获取当前时间(标准时区时间)
	 * 
	 * @return
	 */
	public static Date getDate() {
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}

	/**
	 * 获得指定时间时间戳
	 * 
	 * @param timeString 必须是 yyyy-MM-dd HH:mm:ss 格式
	 * @return
	 */
	public static Timestamp getTime(String timeString) {
		return Timestamp.valueOf(timeString);
	}

	/**
	 *
	 * @param timeString
	 * @param fmt
	 * @return
	 * @throws Exception
	 */
	public static Timestamp getTime(String timeString, String fmt) throws Exception {
		SimpleDateFormat myFormat = new SimpleDateFormat(fmt);
		Date date = myFormat.parse(timeString);
		myFormat = new SimpleDateFormat(FMT_SEPERATOR_yMdHms);
		return getTime(myFormat.format(date));
	}

	/**
	 * 
	 * @return yyyy-MM-dd HH:mm:ss
	 * @throws Exception
	 */
	public static String formatDate() {
		SimpleDateFormat myFormat = new SimpleDateFormat(FMT_SEPERATOR_yMdHms);
		return myFormat.format(new Date());
	}

	/**
	 * 
	 * @param date 时间
	 * @param fmt  yyyy-MM-dd HH:mm:ss
	 * @return 返输入格式的日期字符串
	 * @throws Exception
	 */
	public static String formatDate(Date date, String fmt) throws Exception {
		if (date == null) {
			return "";
		}
		SimpleDateFormat myFormat = new SimpleDateFormat(fmt);
		return myFormat.format(date);
	}

	public static Timestamp getDateFirst(String timeString) throws Exception {
		if ((timeString == null) || (timeString.equals(""))) {
			return null;
		}
		if (timeString.length() > 10) {
			return getTime(timeString, FMT_SEPERATOR_yMdHms);
		}
		return getTime(timeString, FMT_SEPERATOR_yMd);
	}

	public static Timestamp getDateLast(String timeString) throws Exception {
		if ((timeString == null) || (timeString.equals(""))) {
			return null;
		}
		if (timeString.length() > 10) {
			return getTime(timeString, FMT_SEPERATOR_yMdHms);
		}
		return getTime(timeString + FMT_SEPERATOR_Hms_LAST, FMT_SEPERATOR_yMdHms);
	}

	public static Timestamp getMonday() {
		Calendar calendar = Calendar.getInstance();
		int dayofweek = calendar.get(7) - 1;
		if (dayofweek == 0)
			dayofweek = 7;
		calendar.add(5, -dayofweek + 1);

		SimpleDateFormat myFormat = new SimpleDateFormat(FMT_SEPERATOR_yMd+FMT_SEPERATOR_Hms_FIRST);
		String mystrdate = myFormat.format(calendar.getTime());
		return Timestamp.valueOf(mystrdate);
	}

	public static Timestamp getSunday() {
		Calendar calendar = Calendar.getInstance();
		int dayofweek = calendar.get(7) - 1;
		if (dayofweek == 0)
			dayofweek = 7;
		calendar.add(5, -dayofweek + 7);

		SimpleDateFormat myFormat = new SimpleDateFormat(FMT_SEPERATOR_yMd+FMT_SEPERATOR_Hms_LAST);
		String mystrdate = myFormat.format(calendar.getTime());
		return Timestamp.valueOf(mystrdate);
	}

	public static Timestamp addDay(Timestamp time, Integer day) {
		Timestamp time2 = new Timestamp(time.getTime() + day.intValue() * 1000L * 60L * 60L * 24L);
		return time2;
	}

	public static Integer compareDate(String str1, String str2) throws Exception {
		return Integer.valueOf(Integer.parseInt(str1) - Integer.parseInt(str2));
	}

	public static long compareDateTime(String str1, String str2) throws Exception {
		return Long.parseLong(str1) - Long.parseLong(str2);
	}

	public static Integer getDay(Timestamp time1, Timestamp time2) {
		Long dayTime = Long.valueOf((time1.getTime() - time2.getTime()) / 86400000L);
		return Integer.valueOf(dayTime.intValue());
	}

	public static Date parseToDate(String val) {
		Date date = null;
		if ((val != null) && (val.trim().length() != 0) && (!val.trim().toLowerCase().equals("null"))) {
			val = val.trim();
			try {
				if (val.length() > 10) {
					SimpleDateFormat sdf = new SimpleDateFormat(FMT_SEPERATOR_yMdHms);
					date = sdf.parse(val);
				}
				if (val.length() <= 10) {
					SimpleDateFormat sdf = new SimpleDateFormat(FMT_SEPERATOR_yMd);
					date = sdf.parse(val);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}

		}
		return date;
	}

	public static Map<String, String> getPreMonth() {
		SimpleDateFormat df = new SimpleDateFormat(FMT_SEPERATOR_yMd);
		GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

		calendar.add(2, -1);
		Date theDate = calendar.getTime();
		gcLast.setTime(theDate);
		gcLast.set(5, 1);
		String day_first_prevM = df.format(gcLast.getTime());
		StringBuffer str = new StringBuffer().append(day_first_prevM).append(FMT_SEPERATOR_Hms_FIRST);

		day_first_prevM = str.toString();

		calendar.add(2, 1);
		calendar.set(5, 1);
		calendar.add(5, -1);
		String day_end_prevM = df.format(calendar.getTime());
		StringBuffer endStr = new StringBuffer().append(day_end_prevM).append(FMT_SEPERATOR_Hms_LAST);

		day_end_prevM = endStr.toString();

		Map<String, String> map = new HashMap<String, String>();
		map.put("prevMonthFD", day_first_prevM);
		map.put("prevMonthPD", day_end_prevM);
		return map;
	}

	public static Map<String, String> getNextMonth() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

		calendar.add(2, 1);
		Date theDate = calendar.getTime();
		gcLast.setTime(theDate);
		gcLast.set(5, 1);
		String day_first_nextvM = df.format(gcLast.getTime());
		StringBuffer str = new StringBuffer().append(day_first_nextvM).append(FMT_SEPERATOR_Hms_FIRST);

		day_first_nextvM = str.toString();

		calendar.add(2, 1);
		calendar.set(5, 1);
		calendar.add(5, -1);
		String day_end_nextvM = df.format(calendar.getTime());
		StringBuffer endStr = new StringBuffer().append(day_end_nextvM).append(FMT_SEPERATOR_Hms_LAST);

		day_end_nextvM = endStr.toString();

		Map<String, String> map = new HashMap<String, String>();
		map.put("nextvMonthFD", day_first_nextvM);
		map.put("nextvMonthPD", day_end_nextvM);
		return map;
	}

	public static Timestamp getPreMonday() {
		Calendar calendar = Calendar.getInstance();
		int dayofweek = calendar.get(7);
		System.out.println(dayofweek);
		if (dayofweek == 1) {
			calendar.add(4, -1);
		}

		calendar.set(7, 2);
		calendar.add(4, -1);

		SimpleDateFormat myFormat = new SimpleDateFormat(FMT_SEPERATOR_yMd+FMT_SEPERATOR_Hms_FIRST);
		String mystrdate = myFormat.format(calendar.getTime());
		return Timestamp.valueOf(mystrdate);
	}

	public static Timestamp getPreSunday() {
		Calendar calendar = Calendar.getInstance();
		int dayofweek = calendar.get(7);
		if (dayofweek != 1) {
			calendar.add(4, 1);
		}

		calendar.set(7, 1);
		calendar.add(4, -1);

		SimpleDateFormat myFormat = new SimpleDateFormat(FMT_SEPERATOR_yMd+FMT_SEPERATOR_Hms_LAST);
		String mystrdate = myFormat.format(calendar.getTime());
		return Timestamp.valueOf(mystrdate);
	}

	public static String getDateyyyyMMddHHmmss() {
		SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(FMT_yMdHms);
		Calendar localCalendar = Calendar.getInstance();
		return localSimpleDateFormat.format(localCalendar.getTime());
	}

	public static String getDateyyyyMMdd() {
		SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(FMT_yMd);
		Calendar localCalendar = Calendar.getInstance();
		return localSimpleDateFormat.format(localCalendar.getTime());
	}

	public static String getCycleDate(String time, String executeCycle) throws Exception {
		String result = "";
		DateFormat df = new SimpleDateFormat(FMT_yMd);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(df.parse(time));
		calendar.setFirstDayOfWeek(2);
		if ("01".equals(executeCycle)) {
			calendar.add(5, 1);
			result = df.format(calendar.getTime());
		} else if ("02".equals(executeCycle)) {
			calendar.set(7, 2);
			calendar.add(8, 1);
			result = df.format(calendar.getTime());
		} else if ("03".equals(executeCycle)) {
			calendar.set(2, calendar.get(2) + 1);
			calendar.set(5, calendar.getActualMinimum(5));
			result = df.format(calendar.getTime());
		} else if ("04".equals(executeCycle)) {
			int month = calendar.get(2);
			int quarter = month / 3 + 1;
			month = quarter * 3;
			calendar.set(2, month);
			calendar.set(5, calendar.getActualMinimum(5));
			result = df.format(calendar.getTime());
		} else if ("05".equals(executeCycle)) {
			calendar.set(calendar.get(1) + 1, 0, 1);
			result = df.format(calendar.getTime());
		} else if ("06".equals(executeCycle)) {
			result = "";
		} else {
			throw new Exception("营销活动执行周期定义非法，无法找出对应的中奖记录");
		}
		return result;
	}

	public static String getCycleDate2(String time, String executeCycle) throws Exception {
		if (executeCycle == null) {
			throw new Exception("营销活动执行周期为null，无法找出对应的中奖记录");
		}
		executeCycle = executeCycle.trim();
		String result = "";
		String endStr = "";
		String startStr = "";
		DateFormat df = new SimpleDateFormat(FMT_yMd);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(df.parse(time.trim()));
		calendar.setFirstDayOfWeek(2);
		if ("01".equals(executeCycle)) {
			calendar.add(5, -1);
			startStr = df.format(calendar.getTime());
			endStr = df.format(calendar.getTime());
		} else if ("02".equals(executeCycle)) {
			calendar.set(7, 2);
			calendar.add(8, -1);
			startStr = df.format(calendar.getTime());
			calendar.set(7, 1);
			endStr = df.format(calendar.getTime());
		} else if ("03".equals(executeCycle)) {
			calendar.set(2, calendar.get(2) - 1);
			calendar.set(5, calendar.getActualMinimum(5));
			startStr = df.format(calendar.getTime());
			calendar.set(5, calendar.getActualMaximum(5));
			endStr = df.format(calendar.getTime());
		} else if ("04".equals(executeCycle)) {
			int month = calendar.get(2);
			int quarter = month / 3;
			month = quarter * 3;
			calendar.set(2, month);
			calendar.add(2, -3);
			calendar.set(5, calendar.getActualMinimum(5));
			startStr = df.format(calendar.getTime());
			calendar.add(2, 2);
			calendar.set(5, calendar.getActualMaximum(5));
			endStr = df.format(calendar.getTime());
		} else if ("05".equals(executeCycle)) {
			calendar.set(calendar.get(1) - 1, 0, 1);
			startStr = df.format(calendar.getTime());
			calendar.set(2, calendar.getActualMaximum(2));
			calendar.set(5, calendar.getActualMaximum(5));
			endStr = df.format(calendar.getTime());
		} else {
			throw new Exception("营销活动执行周期定义非法，无法找出对应的中奖记录");
		}
		result = startStr + "-" + endStr;
		return result;
	}

	public static String transformyyyyMMddHHmmss(String timeString)  {
		SimpleDateFormat myFormat = new SimpleDateFormat(FMT_SEPERATOR_yMdHms);
		Date date = null;
		try {
			date = myFormat.parse(timeString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		myFormat = new SimpleDateFormat(FMT_yMdHms);
		return myFormat.format(date);
	}
	
	public static String datetimeTransform(String timeString) throws Exception {
		SimpleDateFormat myFormat = new SimpleDateFormat(FMT_yMdHms);
		Date date = myFormat.parse(timeString);
		myFormat = new SimpleDateFormat(FMT_SEPERATOR_yMdHms);
		return myFormat.format(date);
	}

	public static String datetimeFmtString(String timeString) throws Exception {
		SimpleDateFormat myFormat = new SimpleDateFormat(FMT_SEPERATOR_yMdHms);
		Date date = myFormat.parse(timeString);
		myFormat = new SimpleDateFormat("yyyyMMdd");
		return myFormat.format(date);
	}

	public static String dateTransform(String timeString) throws Exception {
		SimpleDateFormat myFormat = new SimpleDateFormat(FMT_yMd);
		Date date = myFormat.parse(timeString);
		myFormat = new SimpleDateFormat(FMT_SEPERATOR_yMd);
		return myFormat.format(date);
	}

	public static String getTomorrow(String date) throws Exception {
		DateFormat df = new SimpleDateFormat(FMT_yMd);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(df.parse(date));
		calendar.setFirstDayOfWeek(2);
		calendar.add(5, 1);
		Date d = calendar.getTime();
		return df.format(d);
	}

	public static String getDateStr() {
		Date d = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat(FMT_yMd);
		String ds = dateformat.format(d);
		return ds;
	}

	public static String getDateHmsStr() {
		Date d = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat(FMT_SEPERATOR_yMdHms);
		String ds = dateformat.format(d);
		return ds;
	}

	public static String getDateHms() {
		Date d = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("HHmmsssss");
		String ds = dateformat.format(d);
		return ds;
	}

	public static String getDateHm() {
		Date d = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm");
		String ds = dateformat.format(d);
		return ds;
	}
	
	public static String getDateHHmi(String date) {
		Date d = parseToDate(date);
		SimpleDateFormat dateformat = new SimpleDateFormat("HHmm");
		String ds = dateformat.format(d);
		return ds;
	}
	public static String getDateHms(String date) {
		Date d = parseToDate(date);
		SimpleDateFormat dateformat = new SimpleDateFormat("HHmmss");
		String ds = dateformat.format(d);
		return ds;
	}
	
	public static String getDateYmd(String date) {
		Date d = parseToDate(date);
		SimpleDateFormat dateformat = new SimpleDateFormat(FMT_yMd);
		String ds = dateformat.format(d);
		return ds;
	}
	
	public static String getDateSeperatorYmd(String date) {
		Date d = parseToDate(date);
		SimpleDateFormat dateformat = new SimpleDateFormat(FMT_SEPERATOR_yMd);
		String ds = dateformat.format(d);
		return ds;
	}
	
	public static String getDateSeperatorHHmi(String date) {
		Date d = parseToDate(date);
		SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm");
		String ds = dateformat.format(d);
		return ds;
	}

	public static String getYestoday() {
		Date d = new Date(System.currentTimeMillis() - 86400000L);
		SimpleDateFormat dateformat = new SimpleDateFormat(FMT_yMd);
		String ds = dateformat.format(d);
		return ds;
	}

	public static Timestamp getOtherDay(int day) {
		Date d = new Date(System.currentTimeMillis() - 86400000 * day);
		SimpleDateFormat dateformat = new SimpleDateFormat(FMT_SEPERATOR_yMdHms);
		String ds = dateformat.format(d);
		return Timestamp.valueOf(ds);
	}

	public static String getTomorrow() {
		Date d = new Date(System.currentTimeMillis() + 86400000L);
		SimpleDateFormat dateformat = new SimpleDateFormat(FMT_yMd);
		String ds = dateformat.format(d);
		return ds;
	}

	public static String getAfterDateByFmt(int afterSeconds, String fmt) {
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		Date now = new Date();
		Date afterDate = new Date(now.getTime() + afterSeconds * 1000);
		String ds = sdf.format(afterDate);
		return ds;
	}

	public static String getAfterDateByFmt(Date now, int afterSeconds, String fmt) {
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		Date afterDate = new Date(now.getTime() + afterSeconds * 1000);
		String ds = sdf.format(afterDate);
		return ds;
	}
	
	
	public static String getAfterDateByFmt(String date, int afterSeconds, String fmt) {
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		Date afterDate = new Date(parseToDate(date).getTime() + afterSeconds * 1000);
		String ds = sdf.format(afterDate);
		return ds;
	}

	public static String getWeekStartTime() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FMT_SEPERATOR_yMd, Locale.getDefault());
		Calendar cal = Calendar.getInstance();
		int day_of_week = cal.get(7) - 1;
		if (day_of_week == 0) {
			day_of_week = 7;
		}
		cal.add(5, -day_of_week + 1);
		return simpleDateFormat.format(cal.getTime()) + "000000000";
	}

	public static String getWeekEndTime() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FMT_SEPERATOR_yMd, Locale.getDefault());
		Calendar cal = Calendar.getInstance();
		int day_of_week = cal.get(7) - 1;
		if (day_of_week == 0) {
			day_of_week = 7;
		}
		cal.add(5, -day_of_week + 7);
		return simpleDateFormat.format(cal.getTime()) + "235959999";
	}
	
	/**
	 * 
	 * @param firstTime  格式为yyyy-MM-dd HH:mm:ss
	 * @param secondTime 格式为yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	
	public static boolean compareTwoTime(String firstTime, String secondTime) {
		try {
			firstTime = DateUtil.transformyyyyMMddHHmmss(firstTime);
			secondTime = DateUtil.transformyyyyMMddHHmmss(secondTime);
			long result = DateUtil.compareDateTime(firstTime, secondTime);
			if (result <= 0l) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(getAfterDateByFmt(-3600, FMT_SEPERATOR_yMdHms));
		String preDayStr = "2018-10-28 17:28:00";
		
		System.out.println(getDateSeperatorHHmi(preDayStr));
	}
}