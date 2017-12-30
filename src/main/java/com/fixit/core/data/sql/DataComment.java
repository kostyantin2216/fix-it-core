/**
 * 
 */
package com.fixit.core.data.sql;

import java.util.Comparator;
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
 * @createdAt 	2017/12/25 23:11:46 GMT+2
 */
@Entity
@Table(name = "DataComment")
public class DataComment implements SqlModelObject<Integer> {
	
	public final static Comparator<DataComment> CREATION_DATE_COMPARATOR = (n, o) -> o.createdAt.compareTo(n.createdAt);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer dataType;
	
	private String dataTypeId;

	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDataType() {
		return dataType;
	}

	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}

	public String getDataTypeId() {
		return dataTypeId;
	}

	public void setDataTypeId(String dataTypeId) {
		this.dataTypeId = dataTypeId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "DataComment [id=" + id + ", dataType=" + dataType + ", dataTypeId=" + dataTypeId + ", content="
				+ content + ", createdAt=" + createdAt + "]";
	}
	
}
