package com.fixit.core.data;

import org.bson.types.ObjectId;

public class JobLocation {

	private String province;
	private String city;
	private String neighborhood;
	private String street;
	private String zipCode;
	private int streetNum;
	private int apartmentNum;
	private int floorNum;
	private double lat;
	private double lng;
	private ObjectId mapAreaId;
	private String comment;
    private String googleAddress;
	
	public JobLocation(String province, String city, String neighborhood, String street, String zipCode, int streetNum,
			int apartmentNum, int floorNum, double lat, double lng, ObjectId mapAreaId, String comment, String googleAddress) {
		this.province = province;
		this.city = city;
		this.neighborhood = neighborhood;
		this.street = street;
		this.zipCode = zipCode;
		this.streetNum = streetNum;
		this.apartmentNum = apartmentNum;
		this.floorNum = floorNum;
		this.lat = lat;
		this.lng = lng;
		this.mapAreaId = mapAreaId;
		this.comment = comment;
		this.googleAddress = googleAddress;
	}
	
	public String getProvince() {
		return province;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getNeighborhood() {
		return neighborhood;
	}
	
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public int getStreetNum() {
		return streetNum;
	}
	
	public void setStreetNum(int streetNum) {
		this.streetNum = streetNum;
	}
	
	public int getApartmentNum() {
		return apartmentNum;
	}
	
	public void setApartmentNum(int apartmentNum) {
		this.apartmentNum = apartmentNum;
	}
	
	public int getFloorNum() {
		return floorNum;
	}
	
	public void setFloorNum(int floorNum) {
		this.floorNum = floorNum;
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
	
	public ObjectId getMapAreaId() {
		return mapAreaId;
	}

	public void setMapAreaId(ObjectId mapAreaId) {
		this.mapAreaId = mapAreaId;
	}

	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getGoogleAddress() {
		return googleAddress;
	}

	public void setGoogleAddress(String googleAddress) {
		this.googleAddress = googleAddress;
	}

	public String toReadableAddress(boolean includeProvince) {
		StringBuilder sb = new StringBuilder();
		
		if(apartmentNum > -1) {
			sb.append(apartmentNum).append("/");
		}
		sb.append(streetNum).append(" ");
		if(floorNum > -1) {
			sb.append("floor ").append(floorNum).append(" ");
		}
		
		sb.append(street).append(" ")
		  .append(neighborhood).append(", ")
		  .append(city);
		
		if(includeProvince) {
			sb.append(", ").append(province);
		}
		
		return sb.toString();
	}

	@Override
	public String toString() {
		return "JobLocation [province=" + province + ", city=" + city + ", neighborhood=" + neighborhood + ", street="
				+ street + ", zipCode=" + zipCode + ", streetNum=" + streetNum + ", apartmentNum=" + apartmentNum
				+ ", floorNum=" + floorNum + ", lat=" + lat + ", lng=" + lng + ", mapAreaId=" + mapAreaId + ", comment="
				+ comment + ", googleAddress=" + googleAddress + "]";
	}
	
}
