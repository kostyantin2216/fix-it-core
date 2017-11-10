package com.fixit.core.data.mongo;

import java.util.Arrays;
import java.util.Date;

import org.bson.types.ObjectId;

import com.fixit.core.data.JobLocation;
import com.fixit.core.data.OrderType;

public class OrderData implements MongoModelObject {
	
	private ObjectId _id;
	private ObjectId[] tradesmen;
	private ObjectId userId;
	private int professionId;
	private JobLocation location;
	private int[] jobReasons;
	private String comment;
	private boolean feedbackProvided;
	private OrderType orderType;
	private Date createdAt;
	
	public OrderData() { }
	
	public OrderData(ObjectId[] tradesmen, ObjectId userId, int professionId, JobLocation location, int[] jobReasons, String comment, boolean feedbackProvided, OrderType orderType, Date createdAt){
		this.tradesmen = tradesmen;
		this.userId = userId;
		this.professionId = professionId;
		this.location = location;
		this.jobReasons = jobReasons;
		this.comment = comment;
		this.feedbackProvided = feedbackProvided;
		this.orderType = orderType;
		this.createdAt = createdAt;
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

	@Override
	public String toString() {
		return "OrderData [_id=" + _id + ", tradesmen=" + Arrays.toString(tradesmen) + ", userId=" + userId
				+ ", professionId=" + professionId + ", location=" + location + ", jobReasons="
				+ Arrays.toString(jobReasons) + ", comment=" + comment + ", feedbackProvided=" + feedbackProvided
				+ ", createdAt=" + createdAt + "]";
	}

}
