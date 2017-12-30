package com.fixit.core.data.mongo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

import org.bson.types.ObjectId;

import com.fixit.core.data.MutableLatLng;
import com.fixit.core.data.WorkingDay;

public class Tradesman implements MongoModelObject, Serializable {
	private static final long serialVersionUID = -3385711727209566760L;

	public final static Comparator<Tradesman> PRIORITY_COMPARATOR = (e1, e2) -> e2.getPriority() - e1.getPriority();

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
	private String[] workingAreas;
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

	public String[] getWorkingAreas() {
		return workingAreas;
	}

	public void setWorkingAreas(String[] workingAreas) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_id == null) ? 0 : _id.hashCode());
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((contactName == null) ? 0 : contactName.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((featureImageUrl == null) ? 0 : featureImageUrl.hashCode());
		result = prime * result + (int) (leadId ^ (leadId >>> 32));
		result = prime * result + ((logoUrl == null) ? 0 : logoUrl.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + priority;
		result = prime * result + Arrays.hashCode(professions);
		result = prime * result + Float.floatToIntBits(rating);
		result = prime * result + ((subscriptionExpiryTime == null) ? 0 : subscriptionExpiryTime.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		result = prime * result + Arrays.hashCode(workingAreas);
		result = prime * result + Arrays.hashCode(workingDays);
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
		Tradesman other = (Tradesman) obj;
		if (_id == null) {
			if (other._id != null)
				return false;
		} else if (!_id.equals(other._id))
			return false;
		if (active != other.active)
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (contactName == null) {
			if (other.contactName != null)
				return false;
		} else if (!contactName.equals(other.contactName))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (featureImageUrl == null) {
			if (other.featureImageUrl != null)
				return false;
		} else if (!featureImageUrl.equals(other.featureImageUrl))
			return false;
		if (leadId != other.leadId)
			return false;
		if (logoUrl == null) {
			if (other.logoUrl != null)
				return false;
		} else if (!logoUrl.equals(other.logoUrl))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (priority != other.priority)
			return false;
		if (!Arrays.equals(professions, other.professions))
			return false;
		if (Float.floatToIntBits(rating) != Float.floatToIntBits(other.rating))
			return false;
		if (subscriptionExpiryTime == null) {
			if (other.subscriptionExpiryTime != null)
				return false;
		} else if (!subscriptionExpiryTime.equals(other.subscriptionExpiryTime))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		if (!Arrays.equals(workingAreas, other.workingAreas))
			return false;
		if (!Arrays.equals(workingDays, other.workingDays))
			return false;
		return true;
	}
	
	
	
}
