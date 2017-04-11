/**
 * 
 */
package com.fixit.core.data.sql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/25 19:39:53 GMT+2
 */
@Entity
@Table(name = "RestClient")
public class RestClient implements SqlModelObject<String> {

	@Id
	private String key;
	
	private String name;
	
	private String userAgent;
	
	private Boolean isActive;
	
	public RestClient() {	}

	@Override
	public String getId() {
		return key;
	}

	@Override
	public void setId(String id) {
		this.key = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "RestClient [name=" + name + ", userAgent=" + userAgent + ", key=" + key + ", isActive="
				+ isActive + "]";
	}

}
