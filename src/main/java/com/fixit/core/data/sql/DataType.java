/**
 * 
 */
package com.fixit.core.data.sql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/16 20:38:47 GMT+2
 */
@Entity
@Table(name = "DataType")
public class DataType implements SqlModelObject<Integer> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String className;
	
	public DataType() { }
	
	public DataType(String className) {
		this.className = className;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "DataType [id=" + id + ", className=" + className + "]";
	}
	
}
