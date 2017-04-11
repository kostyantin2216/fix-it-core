/**
 * 
 */
package com.fixit.core.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fixit.core.data.UpdateDateDataModelObject;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/03/31 16:50:39 GMT+3
 */
public interface UpdateDateDao<DMO extends UpdateDateDataModelObject<ID>, ID extends Serializable> 
	extends CommonDao<DMO, ID> {

	public List<DMO> getBeforeUpdateDate(Date updateDate);
	public List<DMO> getAfterUpdateDate(Date updateDate);
	public List<DMO> getTodaysUpdates();
	
	String getUpdatePropertyName();
	
}
