package com.fixit.core.data.mongo;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.util.StringUtils;

public class User implements MongoModelObject {
	
	private ObjectId _id;
	private String name;
	private String email;
	private String telephone;
	private String avatarUrl;
	private String facebookId;
	private String googleId;
	private Date createdAt;
	
	public User() { }

	public User(String name, String email, String telephone, String avatarUrl,
				String facebookId, String googleId, Date createdAt) {
		this.name = name;
		this.email = email;
		this.telephone = telephone;
		this.avatarUrl = avatarUrl;
		this.facebookId = facebookId;
		this.googleId = googleId;
		this.createdAt = createdAt;
	}
	
	public boolean update(User user) {
		boolean updated = false;
		if(!StringUtils.isEmpty(user.getFacebookId())) {
			this.facebookId = user.getFacebookId();
			updated = true;
		}
		
		if(!StringUtils.isEmpty(user.getGoogleId())) {
			this.googleId = user.getGoogleId();
			updated = true;
		}
		
		return updated;
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
	
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getUserAvatarUrl() {
		return avatarUrl;
	}

	public void setUserAvatarUrl(String userAvatarUrl) {
		this.avatarUrl = userAvatarUrl;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public String getGoogleId() {
		return googleId;
	}

	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}
	
	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "User [_id=" + _id + ", name=" + name + ", email=" + email + ", telephone=" + telephone 
				+ ", userAvatarUrl=" + avatarUrl + ", facebookId=" + facebookId + ", googleId="
				+ googleId + "]";
	}

}
