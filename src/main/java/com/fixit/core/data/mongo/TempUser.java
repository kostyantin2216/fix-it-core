/**
 * 
 */
package com.fixit.core.data.mongo;

import java.util.Date;

import org.bson.types.ObjectId;

import com.fixit.core.data.UserType;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/11/10 23:45:09 GMT+2
 */
public class TempUser implements CommonUser {

	private ObjectId _id;
	
	private String name;
	
	private String email;
	
	private String telephone;
	
	private Date createdAt;
	
	public TempUser() { }
	
	public TempUser(String name, String email, String telephone) {
		this.name = name;
		this.email = email;
		this.telephone = telephone.replaceAll("\\s+","");
		this.createdAt = new Date();
	}
	
	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public UserType getType() {
		return UserType.TEMP;
	}
	
	@Override
	public String toString() {
		return "TempUser [_id=" + _id + ", name=" + name + ", email=" + email + ", telephone=" + telephone + "]";
	}

}
