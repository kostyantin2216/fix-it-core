/**
 * 
 */
package com.fixit.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fixit.core.dao.mongo.MapAreaDao;
import com.fixit.core.data.ImmutableLatLng;
import com.fixit.core.data.mongo.MapArea;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/04/30 14:45:55 GMT+3
 */
@Component
public class MapAreaService {

	@Autowired
	private MapAreaDao mapAreaDao;
	
	
	
	public static class MapAreaRepresentation {
		public final String id;
		public final String name;
		public final ImmutableLatLng[][] polygons;
		
		public MapAreaRepresentation(MapArea mapArea) {
			this.id = mapArea.get_id().toHexString();
			this.name = mapArea.getName();
			
			double[][][] coords = mapArea.getGeometry().getCoordinates();
			
			this.polygons = new ImmutableLatLng[coords.length][];
			for(int polygonIndex = 0; polygonIndex < coords.length; polygonIndex++) {
				double[][] polygonCoords = coords[polygonIndex];
				this.polygons[polygonIndex] = new ImmutableLatLng[polygonCoords.length];
				for(int coordsIndex = 0; coordsIndex < polygonCoords.length; coordsIndex++) {
					this.polygons[polygonIndex][coordsIndex] = new ImmutableLatLng(polygonCoords[coordsIndex][1], polygonCoords[coordsIndex][0]);
				}
			}
		}
	}
	
}
