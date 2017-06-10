package com.fixit.core.data.sql;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "UserStatistics")
public class UserStatistics implements SqlModelObject<String> {

	@Id
	private String userId;
	
	private Integer jobsOrdered;
	
	private Integer reviewsMade;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date registrationDate;
	
	public UserStatistics() { }
	
	public UserStatistics(String userId) {
		this.userId = userId;
		this.jobsOrdered = 0;
		this.reviewsMade = 0;
		this.registrationDate = new Date();
	}
	
	public UserStatistics(String userId, Integer jobsOrdered, Integer reviewsMade, Date registrationDate) {
		this.userId = userId;
		this.jobsOrdered = jobsOrdered;
		this.reviewsMade = reviewsMade;
		this.registrationDate = registrationDate;
	}

	@Override
	public String getId() {
		return userId;
	}

	@Override
	public void setId(String id) {
		this.userId = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getJobsOrdered() {
		return jobsOrdered;
	}

	public void setJobsOrdered(Integer jobsOrdered) {
		this.jobsOrdered = jobsOrdered;
	}

	public Integer getReviewsMade() {
		return reviewsMade;
	}

	public void setReviewsMade(Integer reviewsMade) {
		this.reviewsMade = reviewsMade;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public String toString() {
		return "UserStatistics [userId=" + userId + ", jobsOrdered=" + jobsOrdered + ", reviewsMade=" + reviewsMade
				+ ", registrationDate=" + registrationDate + "]";
	}

}
