/**
 * 
 */
package com.fixit.core.data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/03/31 16:51:14 GMT+3
 */
public interface UpdateDateDataModelObject<ID extends Serializable> extends DataModelObject<ID> {

	public Date getUpdatedAt();
	
}
