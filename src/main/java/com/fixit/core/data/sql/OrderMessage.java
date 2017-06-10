/**
 * 
 */
package com.fixit.core.data.sql;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/05/29 18:00:28 GMT+3
 */
@Entity
@Table(name = "OrderMessage")
public class OrderMessage implements SqlModelObject<String> {

	@Id
	private String messageSid;
	
	private String orderId;
	
	private String userId;
	
	private String tradesmanId;
	
	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date sentAt;

	public OrderMessage() {	}

	public OrderMessage(String messageSid, String orderId, String userId, String tradesmanId, String content) {
		this.messageSid = messageSid;
		this.orderId = orderId;
		this.userId = userId;
		this.tradesmanId = tradesmanId;
		this.content = content;
		this.sentAt = new Date();
	}

	@Override
	public String getId() {
		return messageSid;
	}

	@Override
	public void setId(String id) {
		this.messageSid = id;
	}

	public String getMessageSid() {
		return messageSid;
	}

	public void setMessageSid(String messageSid) {
		this.messageSid = messageSid;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTradesmanId() {
		return tradesmanId;
	}

	public void setTradesmanId(String tradesmanId) {
		this.tradesmanId = tradesmanId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSentAt() {
		return sentAt;
	}

	public void setSentAt(Date sentAt) {
		this.sentAt = sentAt;
	}

	@Override
	public String toString() {
		return "OrderMessage [messageSid=" + messageSid + ", orderId=" + orderId + ", userId=" + userId
				+ ", tradesmanId=" + tradesmanId + ", content=" + content + ", sentAt=" + sentAt + "]";
	}

}
