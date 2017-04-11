package com.fixit.core.data.sql;

import java.io.Serializable;

import com.fixit.core.data.DataModelObject;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/15 21:50:30 GMT+2
 */
public interface SqlModelObject<ID extends Serializable> extends DataModelObject<ID> {
	ID getId();
	void setId(ID id);	
}
