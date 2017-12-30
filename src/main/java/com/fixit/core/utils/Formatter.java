package com.fixit.core.utils;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

public class Formatter {
	
	private final static Pattern PATTERN_24_HOURS = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]"); 
	private final static Pattern PATTERN_SA_TELEPHONE = Pattern.compile(Constants.RGX_SA_TELEPHONE);
	
	public final static String FORMAT_REST_DATE = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
	
	private final static BigDecimal ONE_HUNDRED = new BigDecimal(100);
	
	public static BigDecimal percentage(BigDecimal base, BigDecimal percent) {
		return base.multiply(percent).divide(ONE_HUNDRED);
	}
	
	public static BigDecimal percentage(BigDecimal base, double percent) {
		return percentage(base, new BigDecimal(percent));
	}

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
	
	public static <E> String toString(List<E> list) {
		StringBuilder sb = new StringBuilder();
		
		Iterator<E> itr = list.iterator();
		sb.append("List:");
		if(itr.hasNext()) {
			int i = 0;
			do  {
				sb.append("\n");
				sb.append("\t[").append(i++).append("] = ").append(itr.next());
			} while(itr.hasNext());
		} else {
			sb.append(" EMPTY");
		}
		
		return sb.toString();
	}
	
	public static String capitalizeSentence(String sentence) {
		return sentence.substring(0, 1).toUpperCase() + sentence.substring(1);
	}
	
	public static String normalizeTelephone(String telephone) {
		if(telephone != null) {
			telephone = telephone.replaceAll("\\s+","");
			if(!telephone.isEmpty() && !telephone.startsWith("+")) {
				telephone = "+" + telephone;
			}
		}
		return telephone;
	}
	
	public static float percent(float percent, float amount) {
		return (amount * (percent / 100f));
	}
	
	public static boolean isInteger(String str) {
		return isNumeric(str, false);
	}
	
	public static boolean isNumeric(String str) {
		return isNumeric(str, true);
	}
	
	private static boolean isNumeric(String str, boolean decimalAllowed) {
		boolean result = false;
		
		if(str != null && str.length() > 0) {
			boolean containsDecimal = !decimalAllowed;
			char[] charArr = str.toCharArray();
			
			int charCount = charArr.length;			
			for(int i = 0; i < charCount; i++) {
				char c = charArr[i];
				if((c >= '0' && c <= '9') || (i == 0 && c == '-')) {
					result = true;
				} else if(!containsDecimal && c == '.') {
					containsDecimal = true;
				} else {
					result = false;
					break;
				}
			}
		}
		
		return result;
	}
	
	public static boolean is24Hours(String time) {
		return !StringUtils.isEmpty(time) && PATTERN_24_HOURS.matcher(time).matches();
	}
	
	public static boolean isSaTelephone(String telephone) {
		return true;// !StringUtils.isEmpty(telephone) && PATTERN_SA_TELEPHONE.matcher(telephone).matches();
	}

	public static String capitalize(String line) {
		return Character.toUpperCase(line.charAt(0)) + line.substring(1).toLowerCase();
	}

	public static String deCapitalize(String line) {
		return Character.toLowerCase(line.charAt(0)) + line.substring(1);
	}
	
	public static Date timeFractionToDateTime(double hundredths) {
        if(hundredths > 0) {
            int hours = (int) Math.floor(hundredths);
            int minutes = (int) ((hundredths - (long) hundredths) * 60);

            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.MINUTE, minutes);
            cal.set(Calendar.HOUR_OF_DAY, hours);
            return cal.getTime();
        }
        return null;
    }
	
	public static double dateTimeToTimeFraction(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int hours = cal.get(Calendar.HOUR_OF_DAY);
		int minutes = cal.get(Calendar.MINUTE);
		int minutesInHundredths = timeToHundredths(minutes);
		
		return Double.parseDouble(hours + "." + (minutesInHundredths < 10 ? "0" : "") + minutesInHundredths);
	}

	/**
	 * Does not work properly with values over 100
	 * @param time 
	 * @return minutes in hundredths
	 */
	public static int timeToHundredths(int time) {
	    int hours;
	    int minutes;
	    if(time >= 100) {
	        String valueStr = String.valueOf(time);
	        hours = Integer.parseInt(valueStr.substring(0, (valueStr.length() > 3 ? 2 : 1)));
	        minutes = Integer.parseInt(valueStr.substring(valueStr.length() - 2, valueStr.length()));
	    } else if(time > 0) {
	        hours = 0;
	        minutes = time;
	    } else {
	        return 0;
	    }

	    return Integer.parseInt(hours
	            + (minutes == 0 ? "00" : String.valueOf(Math.round(((1.0 * minutes) / 60) * 100))));
	}
	
	public static void main(String[] args) {
		System.out.println("4 = " + timeToHundredths(4));
		System.out.println("60 = " + timeToHundredths(60));
		System.out.println("84 = " + timeToHundredths(84));
		System.out.println("24 = " + timeToHundredths(24));
		System.out.println("120 = " + timeToHundredths(120));
		System.out.println("1203 = " + timeToHundredths(1203));
		
		
		/*System.out.println("isNumeric");
		System.out.println("123 = " + isNumeric("123"));
		System.out.println("-123 = " + isNumeric("-123"));
		System.out.println("-12.3 = " + isNumeric("-12.3"));
		System.out.println("12.3 = " + isNumeric("12.3"));
		System.out.println("12.3.4 = " + isNumeric("12.3.4"));
		System.out.println("1v3 = " + isNumeric("1v3"));
		System.out.println("(space) = " + isNumeric(" "));
		System.out.println(". = " + isNumeric("."));
		System.out.println("null = " + isNumeric(null));
		
		System.out.println("isInteger");
		System.out.println("123 = " + isInteger("123"));
		System.out.println("-123 = " + isInteger("-123"));
		System.out.println("-12.3 = " + isInteger("-12.3"));
		System.out.println("12.3 = " + isInteger("12.3"));
		System.out.println("12.3.4 = " + isInteger("12.3.4"));
		System.out.println("1v3 = " + isInteger("1v3"));
		System.out.println("(space) = " + isInteger(" "));
		System.out.println(". = " + isInteger("."));
		System.out.println("null = " + isInteger(null));*/
	}
}
