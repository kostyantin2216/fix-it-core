/**
 * 
 */
package com.fixit.core.data;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/04/02 20:31:01 GMT+3
 */
public class MutableLatLng {

	private double lat;
	private double lng;
	
	public MutableLatLng(double lat, double lng) {
		this.lat = lat;
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "MutableLatLng [lat=" + lat + ", lng=" + lng + "]";
	}

}
