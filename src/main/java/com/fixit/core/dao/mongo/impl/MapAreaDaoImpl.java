package com.fixit.core.dao.mongo.impl;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.geoIntersects;

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
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public Class<MapArea> getEntityClass() {
		return MapArea.class;
	}

}
