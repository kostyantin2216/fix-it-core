package com.fixit.core.data.sql;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TradesmanStatistics")
public class TradesmanStatistics implements SqlModelObject<String> {

	@Id
	private String tradesmanId;
	
	private Integer timesShown;
	
	private Integer jobsSent;
	
	private Integer jobsCompleted;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date joinDate;
	
	public TradesmanStatistics() { }
	
	public TradesmanStatistics(String tradesmanId) {
		this.tradesmanId = tradesmanId;
		this.timesShown = 0;
		this.jobsSent = 0;
		this.jobsCompleted = 0;
		this.joinDate = new Date();
	}
	
	public TradesmanStatistics(String tradesmanId, Integer timesShown, Integer jobsSent, Integer jobsCompleted, Date joinDate) {
		this.tradesmanId = tradesmanId;
		this.timesShown = timesShown;
		this.jobsSent = jobsSent;
		this.jobsCompleted = jobsCompleted;
		this.joinDate = joinDate;
	}

	@Override
	public String getId() {
		return tradesmanId;
	}
	
	@Override
	public void setId(String id) {
		this.tradesmanId = id;
	}

	public String getTradesmanId() {
		return tradesmanId;
	}

	public void setTradesmanId(String tradesmanId) {
		this.tradesmanId = tradesmanId;
	}

	public Integer getTimesShown() {
		return timesShown;
	}

	public void setTimesShown(Integer timesShown) {
		this.timesShown = timesShown;
	}

	public Integer getJobsSent() {
		return jobsSent;
	}

	public void setJobsSent(Integer jobsSent) {
		this.jobsSent = jobsSent;
	}

	public Integer getJobsCompleted() {
		return jobsCompleted;
	}

	public void setJobsCompleted(Integer jobsCompleted) {
		this.jobsCompleted = jobsCompleted;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "TradesmanStatistics [tradesmanId=" + tradesmanId + ", timesShown=" + timesShown + ", jobsSent="
				+ jobsSent + ", jobsCompleted=" + jobsCompleted + ", joinDate=" + joinDate + "]";
	}
	
}
