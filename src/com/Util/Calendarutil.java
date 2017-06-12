package com.Util;

import java.util.Calendar;

/**
 * This class is used to get the values of current time, date and calandar.
 * 
 */

public class Calendarutil {
	
	private static int currentYear;
	private static int currentMonth;
	private static int currentDay;
	private static int currentHour;
	private static int currentMinute;
	private static int currentSecond;
	
	/**
	 * get an instance of Calendar class
	 * 
	 * @param null
	 * @return Calendar
	 */
	public static Calendar getCalendarInstance() {
		Calendar calendar = Calendar.getInstance();
		return calendar;
	}
	
	/**
	 * get current year
	 * 
	 * @param null
	 * @return int
	 */
	public static int getCurrentYear() {
		currentYear = getCalendarInstance().get(Calendar.YEAR);
		return currentYear;
	}
	
	/**
	 * get current month (e.g. March --> 3,  October --> 10)
	 * 
	 * @param null
	 * @return int
	 */
	public static int getCurrentMonth() {
		//month is start from 0
		currentMonth = getCalendarInstance().get(Calendar.MONTH)+1;
		return currentMonth;
	}
	
	/**
	 * get current day
	 * 
	 * @param null
	 * @return int
	 */
	public static int getCurrentDay() {
		currentDay = getCalendarInstance().get(Calendar.DAY_OF_MONTH);
		return currentDay;
	}
	
	/**
	 * get current hour
	 * 
	 * @param null
	 * @return int
	 */
	public static int getCurrentHour() {
		currentHour = getCalendarInstance().get(Calendar.HOUR_OF_DAY);
		return currentHour;
	}
	
	/**
	 * get current minute
	 * 
	 * @param null
	 * @return int
	 */
	public static int getCurrentMinute() {
		currentMinute = getCalendarInstance().get(Calendar.MINUTE);
		return currentMinute;
	}
	
	/**
	 * get current second
	 * 
	 * @param null
	 * @return int
	 */
	public static int getCurrentSecond() {
		currentSecond = getCalendarInstance().get(Calendar.SECOND);
		return currentSecond;
	}
	
	/**Month,Day,Hour,Minute,Second
	 * If number<10, add a "0" before it. (e.g. 6 --> 06)
	 * 
	 * @param int number - the number to be formatted
	 * @return String
	 */
	private static String formatNumber(long number) {
		String s = null;
		if(number>9) {
			s = String.valueOf(number);
		}
		else {
			s = "0" + String.valueOf(number);
		}
		return s;
	}
	
	/**
	 * get current date and time as string.
	 * 
	 * @param null
	 * @return String
	 */
	public static String getNow() {
		String now = null;
		String year = String.valueOf(getCurrentYear());
		String month = formatNumber(getCurrentMonth());
		String day = formatNumber(getCurrentDay());
		String hour = formatNumber(getCurrentHour());
		String minute = formatNumber(getCurrentMinute());
		String second = formatNumber(getCurrentSecond());
		now = month + day + year + hour + minute + second;
		return now;
	}
	
	/**
	 * get current date and time as formatted string.
	 * 
	 * @param null
	 * @return String
	 */
	public static String getFormattedNow() {
		String now = null;
		String year = String.valueOf(getCurrentYear());
		String month = formatNumber(getCurrentMonth());
		String day = formatNumber(getCurrentDay());
		String hour = formatNumber(getCurrentHour());
		String minute = formatNumber(getCurrentMinute());
		String second = formatNumber(getCurrentSecond());
		now = month + "/" + day + "/" + year + " " + hour + ":" + minute + ":" + second;
		return now;
	}
	
	//返回YYYY-MM-DD格式的日期
	public static String getFormatteddate(){
		String now = null;
		String year = String.valueOf(getCurrentYear());
		String month = formatNumber(getCurrentMonth());
		String day = formatNumber(getCurrentDay());
		now = year + "-" + month + "-" + day;
		return now;
	}
	
	//返回MM-DD-HH-MM式的日期
	public static String getFormattedDT() {
		String now = null;
		//String year = String.valueOf(getCurrentYear());
		String month = formatNumber(getCurrentMonth());
		String day = formatNumber(getCurrentDay());
		String hour = formatNumber(getCurrentHour());
		String minute = formatNumber(getCurrentMinute());
//		String second = formatNumber(getCurrentSecond());
		long s = Calendar.getInstance().getTimeInMillis();
		String timemillis = String.valueOf(s);
		now = month + "."+day + "-" + timemillis;
		return now;
	}
	
	//返回HH:MM:SS格式的日期
	public static String getFormattedTime() {
		String now = null;
		//String year = String.valueOf(getCurrentYear());
		//String month = formatNumber(getCurrentMonth());
		//String day = formatNumber(getCurrentDay());
		String hour = formatNumber(getCurrentHour());
		String minute = formatNumber(getCurrentMinute());
		String second = formatNumber(getCurrentSecond());
		now = hour + ":" + minute + ":" + second;
		return now;
	}
	
	
	
	/**
	 * Get the duration in the form of " **h, **min, **sec "
	 * 
	 * @param long startTime - starting time in the form of millisecond
	 * @param long endTime - ending time in the form of millisecond
	 * @return String
	 */
	public static String getDuration(long startTime, long endTime) {
		String duration = null;
		long period, hour, minute, second;
		period = endTime - startTime;
		second = (period/1000)%60;
		minute = ((period/1000 - second)/60)%60;
		hour = ((period/1000 - second)/60 - minute)/60;
		
		duration = formatNumber(hour) + "h:" + formatNumber(minute) + "min:" + formatNumber(second) + "sec";		
		return duration;
	}

}
