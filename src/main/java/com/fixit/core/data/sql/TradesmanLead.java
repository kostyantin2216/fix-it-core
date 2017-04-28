/**
 * 
 */
package com.fixit.core.data.sql;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/04/27 20:51:18 GMT+3
 */
@Entity
@Table(name = "TradesmanLead")
public class TradesmanLead implements SqlModelObject<Long> {
	
	public static TradesmanLead newLead(Long shopifyId, String firstName, String lastName, String email) {
		return new TradesmanLead(shopifyId, firstName, lastName, email, new Date());
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long shopifyId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	public TradesmanLead() { }

	private TradesmanLead(Long shopifyId, String firstName, String lastName, String email, Date createdAt) {
		this.shopifyId = shopifyId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.createdAt = createdAt;
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
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "TradesmanLead [id=" + id + ", shopifyId=" + shopifyId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", createdAt=" + createdAt + "]";
	}	
	
}
