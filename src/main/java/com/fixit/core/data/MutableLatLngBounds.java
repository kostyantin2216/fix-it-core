/**
 * 
 */
package com.fixit.core.data;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/11/10 18:42:46 GMT+2
 */
public class MutableLatLngBounds {

	private MutableLatLng northeast;
    private MutableLatLng southwest;

    public MutableLatLng getNortheast() {
        return northeast;
    }

    public void setNortheast(MutableLatLng northeast) {
        this.northeast = northeast;
    }

    public MutableLatLng getSouthwest() {
        return southwest;
    }

    public void setSouthwest(MutableLatLng southwest) {
        this.southwest = southwest;
    }

    @Override
    public String toString() {
        return "MutableLatLngBounds{" +
                "northeast=" + northeast +
                ", southwest=" + southwest +
                '}';
    }
	
}
