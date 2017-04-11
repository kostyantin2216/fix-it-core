/**
 * 
 */
package com.fixit.core.dao.sql.impl;

import org.springframework.stereotype.Repository;

import com.fixit.core.dao.sql.DataTypeDao;
import com.fixit.core.data.sql.DataType;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/16 20:41:21 GMT+2
 */
@Repository("dataTypeDao")
public class DataTypeDaoImpl extends SqlDaoImpl<DataType, Integer> implements DataTypeDao {

	public final static String TABLE_NAME = "DataType";
	
	public final static String PROP_ID = "id";
	public final static String PROP_CLASS_NAME = "className";
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public Class<DataType> getEntityClass() {
		return DataType.class;
	}

}
