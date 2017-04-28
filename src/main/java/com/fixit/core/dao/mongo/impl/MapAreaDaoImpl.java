package com.fixit.core.dao.mongo.impl;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.geoIntersects;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Repository;

import com.fixit.core.dao.mongo.MapAreaDao;
import com.fixit.core.data.JobLocation;
import com.fixit.core.data.MapAreaType;
import com.fixit.core.data.mongo.MapArea;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;

@Repository("mapAreaDao")
public class MapAreaDaoImpl extends MongoDaoImpl<MapArea>
		implements MapAreaDao {
	
	public final static String TABLE_NAME = "MapArea";
	
	public final static String PROP_PARENT_ID = "parentId";
	public final static String PROP_NAME = "name";
	public final static String PROP_TYPE = "type";
	public final static String PROP_GEOMETRY = "geometry";

	@Override
	public MapArea getMapAreaAtLocationForType(double longitude, double latitude, MapAreaType type) {			
		FindIterable<Document> result = mCollection.find(
				and(
						geoIntersects(PROP_GEOMETRY, new Point(new Position(longitude, latitude))),
						eq(PROP_TYPE, type.name())
				)
		);
		
		return mGson.fromJson(result.first().toJson(), MapArea.class);
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
		
		return mGson.fromJson(result.first().toJson(), MapArea.class);
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
