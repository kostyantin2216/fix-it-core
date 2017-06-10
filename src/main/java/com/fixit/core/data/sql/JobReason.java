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
 * @createdAt 	2017/06/01 16:24:41 GMT+3
 */
@Entity
@Table(name = "JobReason")
public class JobReason implements UpdateDateSqlModelObject<Integer>  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer professionId;
	
	private String name;
	
	private String comment;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProfessionId() {
		return professionId;
	}

	public void setProfessionId(Integer professionId) {
		this.professionId = professionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "JobReason [id=" + id + ", professionId=" + professionId + ", name=" + name + ", comment=" + comment
				+ ", updatedAt=" + updatedAt + "]";
	}
	
}
