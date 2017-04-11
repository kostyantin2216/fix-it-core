package com.fixit.core.dao.sql.impl;

import org.springframework.stereotype.Repository;

import com.fixit.core.dao.sql.TradesmanStatisticsDao;
import com.fixit.core.data.sql.TradesmanStatistics;

@Repository
public class TradesmanStatisticsDaoImpl extends SqlDaoImpl<TradesmanStatistics, String>
		implements TradesmanStatisticsDao {

	public final static String TABLE_NAME = "TradesmanStatistics";
	
	public final static String PROP_TRADESMAN_ID = "tradesmanId";
	public final static String PROP_TIMES_SHOWN = "timesShown";
	public final static String PROP_JOBS_COMPLETED = "jobsCompleted";
	public final static String PROP_JOIN_DATE = "joinDate";
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public Class<TradesmanStatistics> getEntityClass() {
		return TradesmanStatistics.class;
	}

}
