/**
 * 
 */
package com.fixit.core.dao.mongo;

import java.util.List;

import com.fixit.core.data.mongo.MapArea;
import com.fixit.core.data.mongo.Tradesman;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/15 21:59:08 GMT+2
 */
public interface TradesmanDao extends MongoDao<Tradesman> {
	List<Tradesman> getTradesmenForArea(MapArea area);
	List<Tradesman> getTradesmenForArea(int professionId, MapArea area);
}
