/**
 * 
 */
package com.fixit.core.data.sql;

import java.io.Serializable;

import com.fixit.core.data.UpdateDateDataModelObject;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/03/31 16:56:24 GMT+3
 */
public interface UpdateDateSqlModelObject<ID extends Serializable> extends SqlModelObject<ID>, UpdateDateDataModelObject<ID> {

}
