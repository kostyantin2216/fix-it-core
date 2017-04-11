/**
 * 
 */
package com.fixit.core.dao.sql;

import java.io.Serializable;
import java.util.Map;

import com.fixit.core.dao.CommonDao;
import com.fixit.core.data.sql.SqlModelObject;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/15 21:49:05 GMT+2
 */
public interface SqlDao<E extends SqlModelObject<ID>, ID extends Serializable> 
		extends CommonDao<E, ID> {
	Integer getCount(Map<String, Object> properties);
}
