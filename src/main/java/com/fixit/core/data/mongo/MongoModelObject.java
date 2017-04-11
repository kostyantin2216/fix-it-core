package com.fixit.core.data.mongo;

import org.bson.types.ObjectId;

import com.fixit.core.data.DataModelObject;

public interface MongoModelObject extends DataModelObject<ObjectId> {
	ObjectId get_id();
	void set_id(ObjectId _id);
}
