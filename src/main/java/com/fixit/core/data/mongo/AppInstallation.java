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
 * @createdAt 	2016/12/24 22:39:30 GMT+2
 */
public class AppInstallation implements MongoModelObject {

	private ObjectId _id;
	private String playStoreUrl;
	private DeviceInfo device;
	private VersionInfo version;
	private String ip;
	private Date cretedAt;

	@Override
	public ObjectId get_id() {
		return _id;
	}

	@Override
	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getPlayStoreUrl() {
		return playStoreUrl;
	}

	public void setPlayStoreUrl(String playStoreUrl) {
		this.playStoreUrl = playStoreUrl;
	}

	public DeviceInfo getDevice() {
		return device;
	}

	public void setDevice(DeviceInfo device) {
		this.device = device;
	}

	public VersionInfo getVersion() {
		return version;
	}

	public void setVersion(VersionInfo version) {
		this.version = version;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getCretedAt() {
		return cretedAt;
	}

	public void setCretedAt(Date cretedAt) {
		this.cretedAt = cretedAt;
	}

	@Override
	public String toString() {
		return "AppInstallation [_id=" + _id + ", playStoreUrl=" + playStoreUrl + ", device=" + device + ", version="
				+ version + ", ip=" + ip + ", cretedAt=" + cretedAt + "]";
	}

}
