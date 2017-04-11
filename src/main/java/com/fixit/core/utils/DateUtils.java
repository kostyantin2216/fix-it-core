/**
 * 
 */
package com.fixit.core.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/04/01 12:39:19 GMT+3
 */
public class DateUtils {
	
    public final static String FORMAT_REST_DATE = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

	public static Date getStartOfDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MILLISECOND, cal.getActualMinimum(Calendar.MILLISECOND));
		cal.set(Calendar.SECOND, cal.getActualMinimum(Calendar.SECOND));
		cal.set(Calendar.MINUTE, cal.getActualMinimum(Calendar.MINUTE));
		cal.set(Calendar.HOUR_OF_DAY, cal.getActualMinimum(Calendar.HOUR_OF_DAY));
		
		return cal.getTime();
	}
	
	public static Date getEndOfDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MILLISECOND, cal.getActualMaximum(Calendar.MILLISECOND));
		cal.set(Calendar.SECOND, cal.getActualMaximum(Calendar.SECOND));
		cal.set(Calendar.MINUTE, cal.getActualMaximum(Calendar.MINUTE));
		cal.set(Calendar.HOUR_OF_DAY, cal.getActualMaximum(Calendar.HOUR_OF_DAY));
		
		return cal.getTime();
	}
	
}
