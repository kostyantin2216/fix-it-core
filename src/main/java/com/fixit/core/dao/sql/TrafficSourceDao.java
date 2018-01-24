/**
 * 
 */
package com.fixit.core.dao.sql;

import com.fixit.core.data.sql.TrafficSource;

/**
 * @author 		Kostyantin
 * @createdAt 	2018/01/15 19:15:44 GMT+2
 */
public interface TrafficSourceDao extends SqlDao<TrafficSource, Integer> {
	
	public final static String TABLE_NAME = "TrafficSource";
	
	public final static String PROP_ID = "id";
	public final static String PROP_NAME = "name";

}
