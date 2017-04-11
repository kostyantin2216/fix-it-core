package com.fixit.core.data;

import java.util.List;

public class Geometry {
	
	private String type;
	private List<List<double[]>> coordinates;
	
	public Geometry() { }
	
	public Geometry(String type, List<List<double[]>> coordinates) {
		this.type = type;
		this.coordinates = coordinates;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<List<double[]>> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<List<double[]>> coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public String toString() {
		return "Geometry [type=" + type + ", coordinates=" + coordinates + "]";
	}

}
