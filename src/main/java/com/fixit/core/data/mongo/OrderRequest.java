/**
 * 
 */
package com.fixit.core.data.mongo;

import java.util.Arrays;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.util.StringUtils;

import com.fixit.core.data.JobLocation;
import com.fixit.core.data.OrderType;

/**
 * @author 		Kostyantin
 * @createdAt 	2018/01/17 18:32:44 GMT+2
 */
public class OrderRequest implements MongoModelObject {

	private ObjectId _id;
	private ObjectId[] tradesmen;
	private ObjectId userId;
	private int professionId;
	private String address;
	private JobLocation location;
	private int[] jobReasons;
	private String comment;
	private int trafficSourceId;
	private OrderType orderType;
	private boolean notifyTradesmen;
	private ObjectId fulfilledOrderId;
	private String reasonDenied;
	private Date createdAt;
	private boolean newRequest;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public JobLocation getLocation() {
		return location;
	}

	public void setLocation(JobLocation location) {
		this.location = location;
	}

	public int[] getJobReasons() {
		return jobReasons;
	}

	public void setJobReasons(int[] jobReasons) {
		this.jobReasons = jobReasons;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getTrafficSourceId() {
		return trafficSourceId;
	}

	public void setTrafficSourceId(int trafficSourceId) {
		this.trafficSourceId = trafficSourceId;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	public boolean isNotifyTradesmen() {
		return notifyTradesmen;
	}

	public void setNotifyTradesmen(boolean notifyTradesmen) {
		this.notifyTradesmen = notifyTradesmen;
	}

	public ObjectId getFulfilledOrderId() {
		return fulfilledOrderId;
	}

	public void setFulfilledOrderId(ObjectId fulfilledOrderId) {
		this.fulfilledOrderId = fulfilledOrderId;
	}

	public String getReasonDenied() {
		return reasonDenied;
	}

	public void setReasonDenied(String reasonDenied) {
		this.reasonDenied = reasonDenied;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public boolean isNewRequest() {
		return newRequest;
	}

	public void setNewRequest(boolean newRequest) {
		this.newRequest = newRequest;
	}

	public String getExistingAddress() {
		if(location == null || StringUtils.isEmpty(location.getGoogleAddress())) {
			return address;
		} else {
			return location.getGoogleAddress();
		}
	}
	
	public boolean isPending() {
		return StringUtils.isEmpty(reasonDenied) && fulfilledOrderId == null;
	}
	
	public boolean isFulfilled() {
		return fulfilledOrderId != null;
	}
	
	public boolean isDenied() {
		return !StringUtils.isEmpty(reasonDenied);
	}

	@Override
	public String toString() {
		return "OrderRequest [_id=" + _id + ", tradesmen=" + Arrays.toString(tradesmen) + ", userId=" + userId
				+ ", professionId=" + professionId + ", address=" + address + ", location=" + location + ", jobReasons="
				+ Arrays.toString(jobReasons) + ", comment=" + comment + ", trafficSourceId=" + trafficSourceId
				+ ", orderType=" + orderType + ", notifyTradesmen=" + notifyTradesmen + ", fulfilledOrderId="
				+ fulfilledOrderId + ", reasonDenied=" + reasonDenied + ", createdAt=" + createdAt + ", newRequest="
				+ newRequest + "]";
	}
	
}
