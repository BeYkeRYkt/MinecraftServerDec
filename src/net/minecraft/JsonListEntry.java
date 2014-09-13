package net.minecraft;

import com.google.gson.JsonObject;

public class JsonListEntry<T> {

	private final T object;

	public JsonListEntry(T object) {
		this.object = object;
	}

	protected JsonListEntry(T object, JsonObject jsonObject) {
		this.object = object;
	}

	public T getObject() {
		return this.object;
	}

	boolean hasExpired() {
		return false;
	}

	protected void toJsonObject(JsonObject jsonObject) {
	}

}
