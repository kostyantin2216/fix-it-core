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
 * @createdAt 	2017/04/27 21:31:28 GMT+3
 */
@Entity
@Table(name = "ServerLog")
public class ServerLog implements SqlModelObject<Long> {

	public static ServerLog createLog(String tag, String level, String message, String stackTrace) {
		return new ServerLog(
				tag,
				level,
				message,
				stackTrace,
				new Date()
		);
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String tag;
	
	private String level;
	
	private String message;
	
	private String stackTrace;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	public ServerLog() { }
	
	private ServerLog(String tag, String level, String message, String stackTrace, Date createdAt) {
		this.tag = tag;
		this.level = level;
		this.message = message;
		this.stackTrace = stackTrace;
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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "ServerLog [id=" + id + ", tag=" + tag + ", level=" + level + ", message=" + message + ", stackTrace="
				+ stackTrace + ", createdAt=" + createdAt + "]";
	}
	
}
