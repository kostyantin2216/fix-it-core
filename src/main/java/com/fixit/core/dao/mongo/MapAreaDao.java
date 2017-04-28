/**
 * 
 */
package com.fixit.core.dao.mongo;

import java.util.List;

import com.fixit.core.data.JobLocation;
import com.fixit.core.data.MapAreaType;
import com.fixit.core.data.mongo.MapArea;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/15 21:58:22 GMT+2
 */
public interface MapAreaDao extends MongoDao<MapArea> {
	public MapArea getMapAreaAtLocationForType(double longitude, double latitude, MapAreaType type);
	public MapArea getMapAreaForJob(JobLocation jobLocation);
	public List<MapArea> getAreasIn(MapArea mapArea, MapAreaType type) throws IllegalArgumentException;
}
