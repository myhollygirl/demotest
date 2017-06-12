package cn.Util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	//@return 返回字符型日期
	public static String formatedDate (Date date , String format){
		
		String result = "";
		
		try{
			if (date != null){
				DateFormat df = new SimpleDateFormat (format);
				result = df.format(date);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//@return 返回int型年份
	public static int getYear (Date date){
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR);
	}
	
	//@return 返回int型月份
	public static int getMonth (Date date){
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MONTH)+1;
	}
	
	//@return 返回int型月份中的第几天
	public static int getDay (Date date){
			
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_MONTH);
	}
		
	//@return 返回int型返回小时
	public static int getHour (Date date){
			
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.HOUR_OF_DAY);
	}		
	
	//@return 返回int型返回分钟
	public static int getMinute (Date date){
			
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MINUTE);
	}		

	//@return 返回int型返回秒
	public static int getSecond (Date date){
			
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.SECOND);
	}	
	
}
