package com.fixit.core.data.mongo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

import org.bson.types.ObjectId;

import com.fixit.core.data.MutableLatLng;
import com.fixit.core.data.WorkingDay;

public class Tradesman implements MongoModelObject {
	
	public static Comparator<Tradesman> PRIORITY_COMPARATOR = (e1, e2) -> e2.getPriority() - e1.getPriority();

	private ObjectId _id;
	private long leadId;
	private int[] professions;
	private String contactName;
	private String companyName;
	private String email;
	private String telephone;
	private String password;
	private String logoUrl;
	private String featureImageUrl;
	private float rating;
	private MutableLatLng lastKnownLocation;
	private ObjectId[] workingAreas;
	private WorkingDay[] workingDays;
	private boolean active;
	private int priority;
	private Date subscriptionExpiryTime;
	
	public Tradesman() { }

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	
	public long getLeadId() {
		return leadId;
	}

	public void setLeadId(long leadId) {
		this.leadId = leadId;
	}

	public int[] getProfessions() {
		return professions;
	}

	public void setProfessions(int[] professions) {
		this.professions = professions;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getFeatureImageUrl() {
		return featureImageUrl;
	}

	public void setFeatureImageUrl(String featureImageUrl) {
		this.featureImageUrl = featureImageUrl;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public MutableLatLng getLastKnownLocation() {
		return lastKnownLocation;
	}

	public void setLastKnownLocation(MutableLatLng lastKnownLocation) {
		this.lastKnownLocation = lastKnownLocation;
	}

	public ObjectId[] getWorkingAreas() {
		return workingAreas;
	}

	public void setWorkingAreas(ObjectId[] workingAreas) {
		this.workingAreas = workingAreas;
	}

	public WorkingDay[] getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(WorkingDay[] workingDays) {
		this.workingDays = workingDays;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean isActive) {
		this.active = isActive;
	}
	
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Date getSubscriptionExpiryTime() {
		return subscriptionExpiryTime;
	}

	public void setSubscriptionExpiryTime(Date subscriptionExpiryTime) {
		this.subscriptionExpiryTime = subscriptionExpiryTime;
	}

	@Override
	public String toString() {
		return "Tradesman [_id=" + _id + ", leadId=" + leadId + ", professions=" + Arrays.toString(professions)
				+ ", contactName=" + contactName + ", companyName=" + companyName + ", email=" + email + ", telephone="
				+ telephone + ", password=" + password + ", logoUrl=" + logoUrl + ", featureImageUrl=" + featureImageUrl
				+ ", rating=" + rating + ", lastKnownLocation=" + lastKnownLocation + ", workingAreas="
				+ Arrays.toString(workingAreas) + ", workingDays=" + Arrays.toString(workingDays) + ", active=" + active
				+ ", priority=" + priority + ", subscriptionExpiryTime=" + subscriptionExpiryTime + "]";
	}
	
}
