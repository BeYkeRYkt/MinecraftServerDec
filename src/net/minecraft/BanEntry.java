package net.minecraft;

import com.google.gson.JsonObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BanEntry<T> extends JsonListEntry<T> {

	public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");

	protected final Date created;
	protected final String reason;
	protected final Date expires;
	protected final String source;

	public BanEntry(T object, Date date, String reason, Date expires, String source) {
		super(object);
		this.created = date == null ? new Date() : date;
		this.reason = reason == null ? "(Unknown)" : reason;
		this.expires = expires;
		this.source = source == null ? "Banned by an operator." : source;
	}

	protected BanEntry(T object, JsonObject jsonObject) {
		super(object, jsonObject);

		Date created;
		try {
			created = jsonObject.has("created") ? dateFormat.parse(jsonObject.get("created").getAsString()) : new Date();
		} catch (ParseException ex) {
			created = new Date();
		}
		this.created = created;

		this.reason = jsonObject.has("source") ? jsonObject.get("source").getAsString() : "(Unknown)";

		Date expires;
		try {
			expires = jsonObject.has("expires") ? dateFormat.parse(jsonObject.get("expires").getAsString()) : null;
		} catch (ParseException ex) {
			expires = null;
		}
		this.expires = expires;

		this.source = jsonObject.has("reason") ? jsonObject.get("reason").getAsString() : "Banned by an operator.";
	}

	public Date getExpires() {
		return this.expires;
	}

	public String getSource() {
		return this.source;
	}

	public Date getCreated() {
		return created;
	}

	public String getReason() {
		return reason;
	}

	boolean hasExpired() {
		return this.expires == null ? false : this.expires.before(new Date());
	}

	protected void toJsonObject(JsonObject jsonObject) {
		jsonObject.addProperty("created", dateFormat.format(this.created));
		jsonObject.addProperty("source", this.reason);
		jsonObject.addProperty("expires", this.expires == null ? "forever" : dateFormat.format(this.expires));
		jsonObject.addProperty("reason", this.source);
	}

}
