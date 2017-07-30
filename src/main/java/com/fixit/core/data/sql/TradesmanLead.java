/**
 * 
 */
package com.fixit.core.data.sql;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fixit.eclipse.utils.JsonToStringBuilder;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/04/27 20:51:18 GMT+3
 */
@Entity
@Table(name = "TradesmanLead")
public class TradesmanLead implements SqlModelObject<Long> {
	
	public static TradesmanLead newLead(String firstName, String lastName, String email) {
		return new TradesmanLead(0L, null, firstName, lastName, email, new Date());
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long shopifyId;
	
	private Long tradesmanId;
	
	private String firstName;
	
	private String lastName;
	
	@Column(unique = true)
	private String email;
	
	private boolean emailSent;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	public TradesmanLead() { }

	private TradesmanLead(Long shopifyId, Long tradesmanId, String firstName, String lastName, String email, Date createdAt) {
		this.shopifyId = shopifyId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.createdAt = createdAt;
		this.tradesmanId = tradesmanId;
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getShopifyId() {
		return shopifyId;
	}

	public void setShopifyId(Long shopifyId) {
		this.shopifyId = shopifyId;
	}

	public Long getTradesmanId() {
		return tradesmanId;
	}

	public void setTradesmanId(Long tradesmanId) {
		this.tradesmanId = tradesmanId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isEmailSent() {
		return emailSent;
	}

	public void setEmailSent(boolean emailSent) {
		this.emailSent = emailSent;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		JsonToStringBuilder sb = new JsonToStringBuilder(this);
		sb.append("id", id);
		sb.append("shopifyId", shopifyId);
		sb.append("tradesmanId", tradesmanId);
		sb.append("firstName", firstName);
		sb.append("lastName", lastName);
		sb.append("email", email);
		sb.append("emailSent", emailSent);
		sb.append("createdAt", createdAt);
		return sb.build();
	}

}
