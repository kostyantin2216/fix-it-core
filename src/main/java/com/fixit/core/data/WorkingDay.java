package com.fixit.core.data;

import java.util.Arrays;

public class WorkingDay {
	
	private int dayOfWeek;
	private WorkingHours[] hours;
	
	public WorkingDay(int day, WorkingHours[] hours) {
		this.dayOfWeek = day;
		this.hours = hours;
	}
	
	public int getDay() {
		return dayOfWeek;
	}
	
	public void setDay(int day) {
		this.dayOfWeek = day;
	}
	
	public WorkingHours[] getHours() {
		return hours;
	}
	
	public void setHours(WorkingHours[] hours) {
		this.hours = hours;
	}
	
	@Override
	public String toString() {
		return "OpeningDays [day=" + dayOfWeek + ", hours=" + Arrays.toString(hours) + "]";
	}
	
}
