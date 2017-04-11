package com.fixit.core.data.mongo;

import java.util.Arrays;

import org.bson.types.ObjectId;

import com.fixit.core.data.JobLocation;

public class Job implements MongoModelObject {
	
	private ObjectId _id;
	private ObjectId tradesmanId;
	private ObjectId userId;
	private JobLocation location;
	private String comment;
	private String[] problems;
	
	public Job() { }
	
	public Job(ObjectId tradesmanId, ObjectId userId, JobLocation location, String comment, String[] problems) {
		this.tradesmanId = tradesmanId;
		this.userId = userId;
		this.location = location;
		this.comment = comment;
		this.problems = problems;
	}
	
	@Override
	public ObjectId get_id() {
		return _id;
	}

	@Override
	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public ObjectId getTradesmanId() {
		return tradesmanId;
	}

	public void setTradesmanId(ObjectId tradesmanId) {
		this.tradesmanId = tradesmanId;
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

	public String[] getProblems() {
		return problems;
	}

	public void setProblems(String[] problems) {
		this.problems = problems;
	}

	@Override
	public String toString() {
		return "Job [_id=" + _id + ", tradesmanId=" + tradesmanId + ", userId=" + userId + ", location=" + location
				+ ", comment=" + comment + ", problems=" + Arrays.toString(problems) + "]";
	}

}
