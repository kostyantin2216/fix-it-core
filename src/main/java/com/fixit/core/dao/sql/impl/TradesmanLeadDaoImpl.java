/**
 * 
 */
package com.fixit.core.dao.sql.impl;

import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.fixit.core.dao.sql.TradesmanLeadDao;
import com.fixit.core.data.sql.TradesmanLead;
import com.fixit.core.logging.FILog;
import com.fixit.core.utils.Constants;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/04/27 20:53:52 GMT+3
 */
@Repository("tradesmanLeadDao")
public class TradesmanLeadDaoImpl extends SqlDaoImpl<TradesmanLead, Long> 
	implements TradesmanLeadDao {

	public final static String TABLE_NAME = "TradesmanLead";
	
	public final static String PROP_ID = "id";
	public final static String PROP_SHOPIFY_ID = "shopifyId";
	public final static String PROP_FIRST_NAME = "firstName";
	public final static String PROP_LAST_NAME = "lastName";
	public final static String PROP_EMAIL = "email";
	public final static String PROP_EMAIL_SENT = "emailSent";
	public final static String PROP_CREATED_AT = "createdAt";
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}
	
	@Override
	public Class<TradesmanLead> getEntityClass() {
		return TradesmanLead.class;
	}

	@Override
	public boolean isNewLead(TradesmanLead lead) {
		String email = lead.getEmail();
		if (!StringUtils.isEmpty(email)) {

			String hqlQuery = "select count(*) from " + TABLE_NAME + " where " + PROP_EMAIL + " = :" + PROP_EMAIL;

			TypedQuery<Long> query = getSession().createQuery(hqlQuery, Long.class);
			query.setParameter(PROP_EMAIL, email);

			boolean isNewLead = query.getSingleResult() == 0;

			if (!isNewLead) {
				FILog.w(Constants.LT_TRADESMAN_REGISTRATION, "Lead is already registered: " + lead, true);
			}

			return isNewLead;
		}
		return false;
	}
	
	@Override
	public boolean emailSent(TradesmanLead lead) throws EntityNotFoundException {
		Long id = lead.getId();
		String hqlQuery = "select count(*) from " + TABLE_NAME 
				+ " where " + PROP_EMAIL_SENT + " = :" + PROP_EMAIL_SENT 
				+ " and ";
		TypedQuery<Long> query;
		if(id != null) {
			hqlQuery += PROP_ID + " = :" + PROP_ID;
			query = getSession().createQuery(hqlQuery, Long.class);
			query.setParameter(PROP_ID, id);
		} else {
			String email = lead.getEmail();
			if(!StringUtils.isEmpty(email)) {
				hqlQuery = PROP_EMAIL + " = :" + PROP_EMAIL;
				query = getSession().createQuery(hqlQuery, Long.class);
				query.setParameter(PROP_EMAIL, email);
			} else {
				throw new EntityNotFoundException();
			}
		}
		query.setParameter(PROP_EMAIL_SENT, true);
		
		return query.getSingleResult() == 0;
	}

}
