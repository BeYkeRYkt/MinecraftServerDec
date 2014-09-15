package net.minecraft;

import com.google.gson.JsonObject;
import java.util.Date;

public class IpBanEntry extends BanEntry<String> {

	public IpBanEntry(String address) {
		this(address, null, null, null, null);
	}

	public IpBanEntry(String address, Date date, String reason, Date expires, String source) {
		super(address, date, reason, expires, source);
	}

	public IpBanEntry(JsonObject jsonObject) {
		super(fromJsonObject(jsonObject), jsonObject);
	}

	protected void toJsonObject(JsonObject jsonObject) {
		if (this.getObject() != null) {
			jsonObject.addProperty("ip", (String) this.getObject());
			super.toJsonObject(jsonObject);
		}
	}

	private static String fromJsonObject(JsonObject jsonObject) {
		return jsonObject.has("ip") ? jsonObject.get("ip").getAsString() : null;
	}

}
