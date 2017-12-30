package com.fixit.core.data;

import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by konstantin on 4/2/2017.
 *
 * dayOfWeek starts from 1 same as {@link Calendar}.
 *  1 = sunday
 *  2 = monday
 *  3 = tuesday
 *  etc..
 *
 */
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
		return "WorkingDay [day=" + dayOfWeek + ", hours=" + Arrays.toString(hours) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dayOfWeek;
		result = prime * result + Arrays.hashCode(hours);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkingDay other = (WorkingDay) obj;
		if (dayOfWeek != other.dayOfWeek)
			return false;
		if (!Arrays.equals(hours, other.hours))
			return false;
		return true;
	}
	
}
