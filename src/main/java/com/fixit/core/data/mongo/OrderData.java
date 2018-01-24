package com.fixit.core.data.mongo;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Transient;

import org.bson.types.ObjectId;
import org.springframework.util.StringUtils;

import com.fixit.core.data.JobLocation;
import com.fixit.core.data.OrderType;
import com.fixit.core.data.UserType;
import com.fixit.core.utils.Formatter;

public class OrderData implements MongoModelObject {
	
	private ObjectId _id;
	private ObjectId[] tradesmen;
	private ObjectId userId;
	private int professionId;
	private JobLocation location;
	private int[] jobReasons;
	private String comment;
	private boolean feedbackProvided;
	private UserType userType;
	private OrderType orderType;
	private Date createdAt;
	private BigDecimal amountCharged;
	private double commissionPercentage;
	private int trafficSourceId;
	private String cancelReason;
	
	public OrderData() { }
	
	public OrderData(ObjectId[] tradesmen, ObjectId userId, int professionId, JobLocation location, int[] jobReasons, String comment, boolean feedbackProvided, UserType userType, OrderType orderType, Date createdAt, int trafficSourceId){
		this.tradesmen = tradesmen;
		this.userId = userId;
		this.professionId = professionId;
		this.location = location;
		this.jobReasons = jobReasons;
		this.comment = comment;
		this.feedbackProvided = feedbackProvided;
		this.userType = userType;
		this.orderType = orderType;
		this.createdAt = createdAt;
		this.trafficSourceId = trafficSourceId;
	}
	
	@Override
	public ObjectId get_id() {
		return _id;
	}

	@Override
	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public ObjectId[] getTradesmen() {
		return tradesmen;
	}

	public void setTradesmen(ObjectId[] tradesmen) {
		this.tradesmen = tradesmen;
	}

	public ObjectId getUserId() {
		return userId;
	}

	public void setUserId(ObjectId userId) {
		this.userId = userId;
	}
	
	public int getProfessionId() {
		return professionId;
	}

	public void setProfessionId(int professionId) {
		this.professionId = professionId;
	}

	public int[] getJobReasons() {
		return jobReasons;
	}

	public void setJobReasons(int[] jobReasons) {
		this.jobReasons = jobReasons;
	}

	public JobLocation getLocation() {
		return location;
	}

	public void setLocation(JobLocation location) {
		this.location = location;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public boolean isFeedbackProvided() {
		return feedbackProvided;
	}

	public void setFeedbackProvided(boolean feedbackProvided) {
		this.feedbackProvided = feedbackProvided;
	}
	
	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public BigDecimal getAmountCharged() {
		return amountCharged;
	}

	public void setAmountCharged(BigDecimal amountCharged) {
		this.amountCharged = amountCharged;
	}

	public double getCommissionPercentage() {
		return commissionPercentage;
	}

	public void setCommissionPercentage(double commissionPercentage) {
		this.commissionPercentage = commissionPercentage;
	}
	
	public int getTrafficSourceId() {
		return trafficSourceId;
	}

	public void setTrafficSourceId(int trafficSourceId) {
		this.trafficSourceId = trafficSourceId;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	@Transient
	public boolean isOrderComplete() {
		return amountCharged != null && amountCharged.signum() > 0 && commissionPercentage > 0;
	}
	
	@Transient
	public boolean isOrderCancelled() {
		return !StringUtils.isEmpty(cancelReason);
	}
	
	@Transient
	public BigDecimal calculateEarnings() {
		if(isOrderComplete()) {
			return Formatter.percentage(amountCharged, commissionPercentage);
		}
		return BigDecimal.ZERO;
	}

	@Override
	public String toString() {
		return "OrderData [_id=" + _id + ", tradesmen=" + Arrays.toString(tradesmen) + ", userId=" + userId
				+ ", professionId=" + professionId + ", location=" + location + ", jobReasons="
				+ Arrays.toString(jobReasons) + ", comment=" + comment + ", feedbackProvided=" + feedbackProvided
				+ ", userType=" + userType + ", orderType=" + orderType + ", createdAt=" + createdAt
				+ ", amountCharged=" + amountCharged + ", commissionPercentage=" + commissionPercentage
				+ ", trafficSourceId=" + trafficSourceId + ", cancelReason=" + cancelReason + "]";
	}

}
