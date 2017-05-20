/**
 * 
 */
package com.fixit.core.data;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/04/30 14:31:36 GMT+3
 */
public class ImmutableLatLng {
	
	public final double lat;
	public final double lng;
	
	public ImmutableLatLng(double lat, double lng) {
		this.lat = lat;
		this.lng = lng;
	}

}
