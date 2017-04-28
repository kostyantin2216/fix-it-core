/**
 * 
 */
package com.fixit.core.dao.sql.impl;

import org.springframework.stereotype.Component;

import com.fixit.core.dao.sql.ServerLogDao;
import com.fixit.core.data.sql.ServerLog;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/04/27 21:45:12 GMT+3
 */
@Component("serverLogDao")
public class ServerLogDaoImpl extends SqlDaoImpl<ServerLog, Long> 
	implements ServerLogDao {

	public final static String TABLE_NAME = "ServerLog";
	
	public final static String PROP_ID = "id";
	public final static String PROP_TAG = "tag";
	public final static String PROP_LEVEL = "level";
	public final static String PROP_MESSAGE = "message";
	public final static String PROP_STACK_TRACE = "stackTrace";
	public final static String PROP_CREATED_AT = "createdAt";

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}
	
	@Override
	public Class<ServerLog> getEntityClass() {
		return ServerLog.class;
	}
	
}
