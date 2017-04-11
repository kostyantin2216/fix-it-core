/**
 * 
 */
package com.fixit.core.dao.sql;

import java.io.Serializable;

import com.fixit.core.dao.UpdateDateDao;
import com.fixit.core.data.sql.UpdateDateSqlModelObject;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/03/31 16:57:34 GMT+3
 */
public interface UpdateDateSqlDao<DMO extends UpdateDateSqlModelObject<ID>, ID extends Serializable> extends UpdateDateDao<DMO, ID>  {
	
}
