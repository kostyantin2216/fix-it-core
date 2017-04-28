/**
 * 
 */
package com.fixit.core.dao.sql;

import com.fixit.core.data.sql.TradesmanLead;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/04/27 20:53:02 GMT+3
 */
public interface TradesmanLeadDao extends SqlDao<TradesmanLead, Long> {
	boolean isNewLead(TradesmanLead lead);
}
