/**
 * 
 */
package com.fixit.core.dao.sql;

import com.fixit.core.data.sql.RestClient;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/25 19:42:31 GMT+2
 */
public interface RestClientDao extends SqlDao<RestClient, String> {
	RestClient findByName(String name);
}
