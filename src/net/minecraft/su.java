package net.minecraft;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

class su implements JsonDeserializer, JsonSerializer {

	// $FF: synthetic field
	final ss a;

	private su(ss var1) {
		this.a = var1;
	}

	public JsonElement a(sr var1, Type var2, JsonSerializationContext var3) {
		JsonObject var4 = new JsonObject();
		var1.a(var4);
		return var4;
	}

	public sr a(JsonElement var1, Type var2, JsonDeserializationContext var3) {
		if (var1.isJsonObject()) {
			JsonObject var4 = var1.getAsJsonObject();
			sr var5 = this.a.a(var4);
			return var5;
		} else {
			return null;
		}
	}

	// $FF: synthetic method
	public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
		return this.a((sr) var1, var2, var3);
	}

	// $FF: synthetic method
	public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) {
		return this.a(var1, var2, var3);
	}

	// $FF: synthetic method
	su(ss var1, st var2) {
		this(var1);
	}
}
