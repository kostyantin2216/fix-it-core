/**
 * 
 */
package com.fixit.core.data;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/11/10 21:40:39 GMT+2
 */
public class Address {

    private String featureName;
	private String adminArea;
    private String subAdminArea;
    private String locality;
    private String subLocality;
    private String thoroughfare;
    private String subThoroughfare;
    private String premises;
    private String postalCode;
    private String countryCode;
    private String countryName;
    private String addressLine;
    private double latitude;
    private double longitude;
    
	public String getFeatureName() {
		return featureName;
	}
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}
	public String getAdminArea() {
		return adminArea;
	}
	public void setAdminArea(String adminArea) {
		this.adminArea = adminArea;
	}
	public String getSubAdminArea() {
		return subAdminArea;
	}
	public void setSubAdminArea(String subAdminArea) {
		this.subAdminArea = subAdminArea;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getSubLocality() {
		return subLocality;
	}
	public void setSubLocality(String subLocality) {
		this.subLocality = subLocality;
	}
	public String getThoroughfare() {
		return thoroughfare;
	}
	public void setThoroughfare(String thoroughfare) {
		this.thoroughfare = thoroughfare;
	}
	public String getSubThoroughfare() {
		return subThoroughfare;
	}
	public void setSubThoroughfare(String subThoroughfare) {
		this.subThoroughfare = subThoroughfare;
	}
	public String getPremises() {
		return premises;
	}
	public void setPremises(String premises) {
		this.premises = premises;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return "Address [featureName=" + featureName + ", adminArea=" + adminArea + ", subAdminArea=" + subAdminArea
				+ ", locality=" + locality + ", subLocality=" + subLocality + ", thoroughfare=" + thoroughfare
				+ ", subThoroughfare=" + subThoroughfare + ", premises=" + premises + ", postalCode=" + postalCode
				+ ", countryCode=" + countryCode + ", countryName=" + countryName + ", addressLine=" + addressLine
				+ ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}
