/**
 * 
 */
package com.fixit.core.data.mongo;

import java.util.Date;

import org.bson.types.ObjectId;

import com.fixit.core.data.DeviceInfo;
import com.fixit.core.data.VersionInfo;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/16 20:43:36 GMT+2
 */
public class AppLog implements MongoModelObject {

	private ObjectId _id;
	private ObjectId userId;
	private String level;
	private String tag;
	private String message;
	private String stackTrace;
	private DeviceInfo deviceInfo;
	private VersionInfo versionInfo;
	private Date createdAt;
	
	public AppLog() { }
	
	public AppLog(ObjectId userId, String level, String tag, String message, String stackTrace,
			DeviceInfo deviceInfo, VersionInfo versionInfo, Date createdAt) {
		this.userId = userId;
		this.level = level;
		this.tag = tag;
		this.message = message;
		this.stackTrace = stackTrace;
		this.deviceInfo = deviceInfo;
		this.versionInfo = versionInfo;
		this.createdAt = createdAt;
	}

	@Override
	public ObjectId get_id() {
		return _id;
	}
	
	@Override
	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public ObjectId getUserId() {
		return userId;
	}

	public void setUserId(ObjectId userId) {
		this.userId = userId;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	public DeviceInfo getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(DeviceInfo deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public VersionInfo getVersionInfo() {
		return versionInfo;
	}

	public void setVersionInfo(VersionInfo versionInfo) {
		this.versionInfo = versionInfo;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "AppLog [_id=" + _id + ", userId=" + userId + ", level=" + level + ", tag=" + tag + ", message="
				+ message + ", stackTrace=" + stackTrace + ", deviceInfo=" + deviceInfo + ", versionInfo=" + versionInfo
				+ ", createdAt=" + createdAt + "]";
	}

}
