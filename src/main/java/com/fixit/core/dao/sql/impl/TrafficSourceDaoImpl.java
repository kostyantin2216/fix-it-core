/**
 * 
 */
package com.fixit.core.dao.sql.impl;

import org.springframework.stereotype.Repository;

import com.fixit.core.dao.sql.TrafficSourceDao;
import com.fixit.core.data.sql.TrafficSource;

/**
 * @author 		Kostyantin
 * @createdAt 	2018/01/15 19:16:18 GMT+2
 */
@Repository("trafficSourceDao")
public class TrafficSourceDaoImpl extends SqlDaoImpl<TrafficSource, Integer> implements TrafficSourceDao {

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public Class<TrafficSource> getEntityClass() {
		return TrafficSource.class;
	}

}
