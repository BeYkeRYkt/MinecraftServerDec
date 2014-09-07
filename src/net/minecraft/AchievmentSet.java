package net.minecraft;

import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

import java.util.Set;

public class AchievmentSet extends ForwardingSet<Object> implements IJsonStatistic {

	private final Set<Object> set = Sets.newHashSet();

	public void a(JsonElement json) {
		if (json.isJsonArray()) {
			for (JsonElement element : json.getAsJsonArray()) {
				add(element.getAsString());
			}
		}
	}

	public JsonElement a() {
		JsonArray array = new JsonArray();
		for (Object obj : this) {
			array.add(new JsonPrimitive((String) obj));
		}
		return array;
	}

	protected Set<Object> delegate() {
		return this.set;
	}

}
