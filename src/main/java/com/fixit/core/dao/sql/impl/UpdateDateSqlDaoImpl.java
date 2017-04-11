/**
 * 
 */
package com.fixit.core.dao.sql.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.TemporalType;

import com.fixit.core.dao.sql.UpdateDateSqlDao;
import com.fixit.core.data.sql.UpdateDateSqlModelObject;
import com.fixit.core.utils.DateUtils;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/04/01 11:58:28 GMT+3
 */
public abstract class UpdateDateSqlDaoImpl<DMO extends UpdateDateSqlModelObject<ID>,ID extends Serializable> extends SqlDaoImpl<DMO, ID> 
	implements UpdateDateSqlDao<DMO, ID> {

	@Override
	public List<DMO> getBeforeUpdateDate(Date updateDate) {
		String queryStr = "select _this from " + getTableName() + " _this where _this." + getUpdatePropertyName() + " < :timestamp";
		
		return getSession()
			.createQuery(queryStr, getEntityClass())
			.setParameter(":timestamp", updateDate, TemporalType.TIMESTAMP)
			.getResultList();
	}
	
	
	public List<DMO> getAfterUpdateDate(Date updateDate) {
		String queryStr = "select _this from " + getTableName() + " _this where _this." + getUpdatePropertyName() + " > :timestamp";
		
		return getSession()
			.createQuery(queryStr, getEntityClass())
			.setParameter(":timestamp", updateDate, TemporalType.TIMESTAMP)
			.getResultList();
		
	}
	
	public List<DMO> getTodaysUpdates() {
		String queryStr = "select _this from " + getTableName() + " _this where _this." + getUpdatePropertyName() + " >= :fromDate and " + getUpdatePropertyName() + " <= :toDate";
		
		Date now = new Date();
		return getSession()
			.createQuery(queryStr, getEntityClass())
			.setParameter(":fromDate", DateUtils.getStartOfDay(now), TemporalType.TIMESTAMP)
			.setParameter(":toDate", DateUtils.getEndOfDay(now), TemporalType.TIMESTAMP)
			.getResultList();
	}
	
}
