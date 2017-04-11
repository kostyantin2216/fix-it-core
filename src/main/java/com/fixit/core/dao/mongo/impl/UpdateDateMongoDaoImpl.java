/**
 * 
 */
package com.fixit.core.dao.mongo.impl;

import static com.mongodb.client.model.Filters.*;

import java.util.Date;
import java.util.List;

import com.fixit.core.dao.mongo.UpdateDateMongoDao;
import com.fixit.core.data.mongo.UpdateDateMongoModelObject;
import com.fixit.core.utils.DateUtils;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/04/01 12:45:20 GMT+3
 */
public abstract class UpdateDateMongoDaoImpl<DMO extends UpdateDateMongoModelObject> extends MongoDaoImpl<DMO> implements UpdateDateMongoDao<DMO> {

	@Override
	public List<DMO> getBeforeUpdateDate(Date updateDate) {
		return convertToList(
				mCollection
					.find(gt(getUpdatePropertyName(), updateDate))
					.iterator()
		);
	}

	@Override
	public List<DMO> getAfterUpdateDate(Date updateDate) {
		return convertToList(
				mCollection
					.find(lt(getUpdatePropertyName(), updateDate))
					.iterator()
		);
	}

	@Override
	public List<DMO> getTodaysUpdates() {
		Date now = new Date();
		return convertToList(
				mCollection
				.find(and(
						gte(getUpdatePropertyName(), DateUtils.getStartOfDay(now)), 
						lte(getUpdatePropertyName(), DateUtils.getEndOfDay(now))
				))
				.iterator()
		);
	}

}
