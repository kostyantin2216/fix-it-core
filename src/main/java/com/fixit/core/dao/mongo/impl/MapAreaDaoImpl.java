package com.fixit.core.dao.mongo.impl;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.geoIntersects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fixit.core.config.GsonManager;
import com.fixit.core.config.MongoClientManager;
import com.fixit.core.dao.mongo.MapAreaDao;
import com.fixit.core.data.JobLocation;
import com.fixit.core.data.MapAreaType;
import com.fixit.core.data.mongo.MapArea;
import com.fixit.core.structure.TreeNode;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;

@Repository("mapAreaDao")
public class MapAreaDaoImpl extends MongoDaoImpl<MapArea>
		implements MapAreaDao {
	
	private final static ConcurrentMap<MapAreaType, List<MapArea>> MapAreasForType = new ConcurrentHashMap<>();
	private final static ConcurrentMap<String, TreeNode<MapArea>> MapAreaNodes = new ConcurrentHashMap<>();
	
	@Autowired
	public MapAreaDaoImpl(MongoClientManager mongoClientManager, GsonManager gsonManager) {
		super(mongoClientManager.getCollection(TABLE_NAME), gsonManager.getMongoGson());
	}
	
	@Override
	public MapArea getMapAreaAtLocationForType(double longitude, double latitude, MapAreaType type) {			
		FindIterable<Document> result = mCollection.find(
				and(
						geoIntersects(PROP_GEOMETRY, new Point(new Position(longitude, latitude))),
						eq(PROP_TYPE, type.name())
				)
		);
		
		return convertToType(result.first());
	}

	@Override
	public MapArea getMapAreaForJob(JobLocation jobLocation) {
		FindIterable<Document> result = mCollection.find(
				and(
						geoIntersects(PROP_GEOMETRY, new Point(
								new Position(
										jobLocation.getLng(), 
										jobLocation.getLat()
								)
						)),
						eq(PROP_TYPE, MapAreaType.Ward)
				)
		);
		
		return convertToType(result.first());
	}

	@Override
	public List<MapArea> getAreasIn(MapArea mapArea, MapAreaType requestedType) throws IllegalArgumentException {
		MapAreaType queryType = mapArea.getEnumType();
		
		if(queryType.level > requestedType.level) {
			throw new IllegalArgumentException("Cannot look for " + requestedType.name() + " type's in " + queryType.name() + " type.");
		} else if(queryType.level == requestedType.level) {
			List<MapArea> mapAreas = new ArrayList<>();
			mapAreas.add(mapArea);
			return mapAreas;
		} else {
			return drillDownAreasToType(findByProperty(PROP_PARENT_ID, mapArea.get_id()), requestedType);
		}
	}
	
	@Override
	public List<MapArea> getAreas(ObjectId... ids) {
		return findIn(PROP_ID, (Object[]) ids);
	}
	
	@Override
	public List<MapArea> getAreasForType(MapAreaType type) {
		List<MapArea> mapAreas = MapAreasForType.get(type);
		if(mapAreas == null) {
			mapAreas = findByProperty(PROP_TYPE, type.name());
			MapAreasForType.putIfAbsent(type, mapAreas);
		}
		return mapAreas;
	}

	@Override
	public TreeNode<MapArea> getNode(ObjectId areaId) {
		String areaIdHex = areaId.toHexString();
		TreeNode<MapArea> node = MapAreaNodes.get(areaIdHex);
		if(node == null) {
			MapArea mapArea = findById(areaId);
			node = new TreeNode<MapArea>(mapArea);
			fillTreeNode(node);
			MapAreaNodes.putIfAbsent(areaIdHex, node);
		}
		return node;
	}
	
	private void fillTreeNode(TreeNode<MapArea> node) {
		MapArea mapArea = node.getData();
		
		List<MapArea> childrenAreas = getChildren(mapArea.get_id());
		if(childrenAreas != null) {
			for(MapArea childArea : childrenAreas) {
				fillTreeNode(node.addChild(childArea));
			}
		}
	}
	
	@Override
	public List<MapArea> getChildren(ObjectId parentId) {
		return findByProperty(PROP_PARENT_ID, parentId);
	}
	
	private List<MapArea> drillDownAreasToType(List<MapArea> fromAreas, MapAreaType requestedType) {
		List<MapArea> resultingAreas = new ArrayList<>();
		
		if(fromAreas != null && !fromAreas.isEmpty()) {
			for(MapArea mapArea : fromAreas) {
				if(mapArea.getEnumType() == requestedType) {
					resultingAreas.add(mapArea);
				} else {
					resultingAreas.addAll(drillDownAreasToType(findByProperty(PROP_PARENT_ID, mapArea.get_id()), requestedType));
				}
			}
		}
		
		return resultingAreas;
	}

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public Class<MapArea> getEntityClass() {
		return MapArea.class;
	}
}
