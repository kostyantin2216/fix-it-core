/**
 * 
 */
package com.fixit.core.dao.sql.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fixit.core.dao.sql.DataCommentDao;
import com.fixit.core.data.sql.DataComment;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/12/25 23:37:08 GMT+2
 */
@Repository("dataCommentDao")
public class DataCommentDaoImpl extends SqlDaoImpl<DataComment, Integer> implements DataCommentDao {

	@Override
	public List<DataComment> findForData(Integer dataType, String dataId) {
		Map<String, Object> properties = new HashMap<>();
		properties.put(PROP_DATA_TYPE, dataType);
		properties.put(PROP_DATA_TYPE_ID, dataId);
		return findByMap(properties);
	}
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public Class<DataComment> getEntityClass() {
		return DataComment.class;
	}

}
