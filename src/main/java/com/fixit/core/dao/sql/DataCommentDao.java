/**
 * 
 */
package com.fixit.core.dao.sql;

import java.util.List;

import com.fixit.core.data.sql.DataComment;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/12/25 23:36:23 GMT+2
 */
public interface DataCommentDao extends SqlDao<DataComment, Integer> {

	public final static String TABLE_NAME = "DataComment";
	
	public final static String PROP_ID = "id";
	public final static String PROP_DATA_TYPE = "dataType";
	public final static String PROP_DATA_TYPE_ID = "dataTypeId";
	public final static String PROP_CONTENT = "content";
	public final static String PROP_CREATED_AT = "createdAt";
	
	public List<DataComment> findForData(Integer dataType, String dataId);
	
}
