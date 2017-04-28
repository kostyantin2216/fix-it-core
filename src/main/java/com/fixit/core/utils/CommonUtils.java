package com.fixit.core.utils;

import java.util.Iterator;
import java.util.List;

public class CommonUtils {
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
	
	public static void main(String[] args) {
		System.out.println("isNumeric");
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
		System.out.println("null = " + isInteger(null));
	}
}
