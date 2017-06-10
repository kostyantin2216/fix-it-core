package com.fixit.core.data.mongo;

import org.bson.types.ObjectId;

public class User implements MongoModelObject {
	
	private ObjectId _id;
	private String name;
	private String email;
	private String telephone;
	private String avatarUrl;
	private String facebookId;
	private String googleId;
	
	public User() { }

	public User(String name, String email, String telephone, String avatarUrl,
				String facebookId, String googleId) {
		this.name = name;
		this.email = email;
		this.telephone = telephone;
		this.avatarUrl = avatarUrl;
		this.facebookId = facebookId;
		this.googleId = googleId;
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

	@Override
	public String toString() {
		return "User [_id=" + _id + ", name=" + name + ", email=" + email + ", telephone=" + telephone 
				+ ", userAvatarUrl=" + avatarUrl + ", facebookId=" + facebookId + ", googleId="
				+ googleId + "]";
	}

}
