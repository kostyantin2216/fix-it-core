package com.fixit.core.data.mongo;

import org.bson.types.ObjectId;

import com.fixit.core.data.Geometry;
import com.fixit.core.data.MapAreaType;

public class MapArea implements MongoModelObject {
	
	private ObjectId _id;
	private ObjectId parentId;
	private String name;
	private String type;
	private Geometry geometry;
	
	public MapArea(ObjectId parentId, String name, String type, Geometry geometry) {
		this.parentId = parentId;
		this.name = name;
		this.type = type;
		this.geometry = geometry;
	}
	
	@Override
	public ObjectId get_id() {
		return _id;
	}

	@Override
	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public ObjectId getParentId() {
		return parentId;
	}

	public void setParentId(ObjectId parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}
	
	public MapAreaType getEnumType() {
		return MapAreaType.valueOf(type);
	}

	@Override
	public String toString() {
		return "MapArea [_id=" + _id + ", parentId=" + parentId + ", name=" + name + ", type=" + type + ", geometry="
				+ geometry + "]";
	}	

}
