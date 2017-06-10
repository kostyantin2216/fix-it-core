package com.fixit.core.data.mongo;

import org.bson.types.ObjectId;

import com.fixit.core.data.JobLocation;

public class Order implements MongoModelObject {
	
	private ObjectId _id;
	private ObjectId[] tradesmen;
	private ObjectId userId;
	private JobLocation location;
	private String comment;
	
	public Order() { }
	
	public Order(ObjectId[] tradesmen, ObjectId userId, JobLocation location, String comment){
		this.tradesmen = tradesmen;
		this.userId = userId;
		this.location = location;
		this.comment = comment;
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

	public void setTradesmanId(ObjectId[] tradesmen) {
		this.tradesmen = tradesmen;
	}

	public ObjectId getUserId() {
		return userId;
	}

	public void setUserId(ObjectId userId) {
		this.userId = userId;
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
	
	@Override
	public String toString() {
		return "Job [_id=" + _id + ", tradesmen=" + tradesmen + ", userId=" + userId + ", location=" + location
				+ ", comment=" + comment + "]";
	}

}
