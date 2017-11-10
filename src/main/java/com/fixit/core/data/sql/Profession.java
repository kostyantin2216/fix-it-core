package com.fixit.core.data.sql;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Profession")
public class Profession implements UpdateDateSqlModelObject<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String namePlural;
	
	private String description;
	
	private String imageUrl;
	
	private Boolean isActive;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	
	public Profession() { }
	
	public Profession(String name, String namePlural, String description, String imageUrl) {
		this.name = name;
		this.namePlural = namePlural;
		this.description = description;
		this.imageUrl = imageUrl;
		this.updatedAt = new Date();
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNamePlural() {
		return namePlural;
	}

	public void setNamePlural(String namePlural) {
		this.namePlural = namePlural;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Profession [id=" + id + ", name=" + name + ", namePlural=" + namePlural + ", description=" + description
				+ ", imageUrl=" + imageUrl + ", isActive=" + isActive + ", updatedAt=" + updatedAt + "]";
	}
	
}
