package com.fixit.core.data;

public class WorkingHours {
	
	private double open;
	private double close;
	
	public WorkingHours(double open, double close) {
		this.open = open;
		this.close = close;
	}
	
	public double getOpen() {
		return open;
	}
	public void setOpen(double open) {
		this.open = open;
	}
	public double getClose() {
		return close;
	}
	public void setClose(double close) {
		this.close = close;
	}

	@Override
	public String toString() {
		return "OpeningHours [open=" + open + ", close=" + close + "]";
	}

}
