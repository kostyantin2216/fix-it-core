/**
 * 
 */
package com.fixit.core.dao.mongo;

import java.util.List;

import org.bson.types.ObjectId;

import com.fixit.core.data.JobLocation;
import com.fixit.core.data.MapAreaType;
import com.fixit.core.data.mongo.MapArea;
import com.fixit.core.structure.TreeNode;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/15 21:58:22 GMT+2
 */
public interface MapAreaDao extends MongoDao<MapArea> {
	public final static String TABLE_NAME = "MapArea";
	
	public final static String PROP_PARENT_ID = "parentId";
	public final static String PROP_NAME = "name";
	public final static String PROP_TYPE = "type";
	public final static String PROP_GEOMETRY = "geometry";
	
	public final static ObjectId ID_JOBURG_PROVINCE = new ObjectId("585e6df2dabad5205065fb20");
	
	public MapArea getMapAreaAtLocationForType(double longitude, double latitude, MapAreaType type);
	public MapArea getMapAreaForJob(JobLocation jobLocation);
	public List<MapArea> getAreasIn(MapArea mapArea, MapAreaType type) throws IllegalArgumentException;
	public List<MapArea> getAreas(ObjectId... ids);
	public List<MapArea> getAreasForType(MapAreaType type);
	public List<MapArea> getChildren(ObjectId parentId);
	public TreeNode<MapArea> getNode(ObjectId areaId);
	
}
