package net.minecraft;

import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JsonList<T> {

	protected static final Logger logger = LogManager.getLogger();
	private static final ParameterizedType type = new JsonListType();

	protected final Gson gson;
	private final File file;
	private final Map<String, JsonListEntry<T>> map = Maps.newHashMap();
	private boolean enabled = true;

	public JsonList(File file) {
		this.file = file;
		GsonBuilder builder = (new GsonBuilder()).setPrettyPrinting();
		builder.registerTypeHierarchyAdapter(JsonListEntry.class, new JsonListEntrySerializer(this, (JsonListType) null));
		this.gson = builder.create();
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public File getFile() {
		return this.file;
	}

	public void add(JsonListEntry<T> entry) {
		this.map.put(this.toString(entry.getObject()), entry);

		try {
			this.save();
		} catch (IOException var3) {
			logger.warn("Could not save the list after adding a user.", (Throwable) var3);
		}

	}

	public JsonListEntry<T> get(T object) {
		this.removeExpired();
		return this.map.get(this.toString(object));
	}

	public void remove(T object) {
		this.map.remove(this.toString(object));

		try {
			this.save();
		} catch (IOException ex) {
			logger.warn("Could not save the list after removing a user.", ex);
		}

	}

	protected boolean contains(T key) {
		return this.map.containsKey(this.toString(key));
	}

	public String[] getEntries() {
		return this.map.keySet().toArray(new String[this.map.size()]);
	}

	public boolean isEmpty() {
		return this.map.isEmpty();
	}

	private void removeExpired() {
		Iterator<JsonListEntry<T>> iterator = this.map.values().iterator();

		while (iterator.hasNext()) {
			JsonListEntry<T> entry = iterator.next();
			if (entry.hasExpired()) {
				iterator.remove();
			}
		}
	}

	protected JsonListEntry<T> toListEntry(JsonObject jsonObject) {
		return new JsonListEntry<T>(null, jsonObject);
	}

	protected Map<String, JsonListEntry<T>> getMap() {
		return this.map;
	}

	public void save() throws IOException {
		Collection<JsonListEntry<T>> collection = this.map.values();
		String gsonString = this.gson.toJson(collection);
		BufferedWriter writer = null;

		try {
			writer = Files.newWriter(this.file, Charsets.UTF_8);
			writer.write(gsonString);
		} finally {
			IOUtils.closeQuietly((Writer) writer);
		}

	}

	public void load() throws FileNotFoundException {
		Collection<JsonListEntry<T>> collection = null;
		BufferedReader reader = null;

		try {
			reader = Files.newReader(this.file, Charsets.UTF_8);
			collection = this.gson.fromJson(reader, type);
		} finally {
			IOUtils.closeQuietly((Reader) reader);
		}

		if (collection != null) {
			this.map.clear();
			for (JsonListEntry<T> entry : collection) {
				if (entry.getObject() != null) {
					map.put(this.toString(entry.getObject()), entry);
				}
			}
		}
	}

	protected String toString(T key) {
		return key.toString();
	}

}
