package com.fixit.core.config.json;

import java.lang.reflect.Type;

import org.bson.types.ObjectId;
import org.springframework.util.StringUtils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class ObjectIdTypeAdatper 
	implements JsonSerializer<ObjectId>, JsonDeserializer<ObjectId> {

	@Override
	public ObjectId deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		String objectId = null;
		if(json.isJsonPrimitive()) {
			objectId = json.getAsString();
		} else {
			JsonObject jsonObj = json.getAsJsonObject();
			objectId = jsonObj.get("$oid").getAsString();
		}
		
		return StringUtils.isEmpty(objectId) ? null : new ObjectId(objectId);
	}
	
	@Override
	public JsonElement serialize(ObjectId src, Type typeOfSrc, JsonSerializationContext context) {
		return new JsonPrimitive(src.toHexString());
	}

}
