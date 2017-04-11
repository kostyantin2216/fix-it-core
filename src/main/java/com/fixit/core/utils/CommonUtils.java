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
	
	public static void main(String[] args) {
		double result = percent(80, 6);
		System.out.println("result = " + result);
	}
}
