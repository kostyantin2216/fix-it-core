package com.fixit.core.data.mongo;

import org.bson.types.ObjectId;

public class User implements MongoModelObject {
	
	private ObjectId _id;
	private String name;
	private String email;
	private String password;
	private String telephone;
	
	public User() { }
	
	public User(String name, String email, String password, String telephone) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
	}

	@Override
	public ObjectId get_id() {
		return _id;
	}

	@Override
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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "User [_id=" + _id + ", name=" + name + ", email=" + email + ", password=" + password + ", telephone="
				+ telephone + "]";
	}

}
