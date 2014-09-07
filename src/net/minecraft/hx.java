package net.minecraft;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

public class hx implements JsonDeserializer, JsonSerializer {

	public hv a(JsonElement var1, Type var2, JsonDeserializationContext var3) {
		if (var1.isJsonObject()) {
			hv var4 = new hv();
			JsonObject var5 = var1.getAsJsonObject();
			if (var5 == null) {
				return null;
			} else {
				if (var5.has("bold")) {
					hv.a(var4, Boolean.valueOf(var5.get("bold").getAsBoolean()));
				}

				if (var5.has("italic")) {
					hv.b(var4, Boolean.valueOf(var5.get("italic").getAsBoolean()));
				}

				if (var5.has("underlined")) {
					hv.c(var4, Boolean.valueOf(var5.get("underlined").getAsBoolean()));
				}

				if (var5.has("strikethrough")) {
					hv.d(var4, Boolean.valueOf(var5.get("strikethrough").getAsBoolean()));
				}

				if (var5.has("obfuscated")) {
					hv.e(var4, Boolean.valueOf(var5.get("obfuscated").getAsBoolean()));
				}

				if (var5.has("color")) {
					hv.a(var4, (EnumChatFormat) var3.deserialize(var5.get("color"), EnumChatFormat.class));
				}

				if (var5.has("insertion")) {
					hv.a(var4, var5.get("insertion").getAsString());
				}

				JsonObject var6;
				JsonPrimitive var7;
				if (var5.has("clickEvent")) {
					var6 = var5.getAsJsonObject("clickEvent");
					if (var6 != null) {
						var7 = var6.getAsJsonPrimitive("action");
						hn var8 = var7 == null ? null : hn.a(var7.getAsString());
						JsonPrimitive var9 = var6.getAsJsonPrimitive("value");
						String var10 = var9 == null ? null : var9.getAsString();
						if (var8 != null && var10 != null && var8.a()) {
							hv.a(var4, new hm(var8, var10));
						}
					}
				}

				if (var5.has("hoverEvent")) {
					var6 = var5.getAsJsonObject("hoverEvent");
					if (var6 != null) {
						var7 = var6.getAsJsonPrimitive("action");
						EnumHoverAction var11 = var7 == null ? null : EnumHoverAction.a(var7.getAsString());
						IChatBaseComponent var12 = (IChatBaseComponent) var3.deserialize(var6.get("value"), IChatBaseComponent.class);
						if (var11 != null && var12 != null && var11.a()) {
							hv.a(var4, new ChatHoverable(var11, var12));
						}
					}
				}

				return var4;
			}
		} else {
			return null;
		}
	}

	public JsonElement a(hv var1, Type var2, JsonSerializationContext var3) {
		if (var1.g()) {
			return null;
		} else {
			JsonObject var4 = new JsonObject();
			if (hv.b(var1) != null) {
				var4.addProperty("bold", hv.b(var1));
			}

			if (hv.c(var1) != null) {
				var4.addProperty("italic", hv.c(var1));
			}

			if (hv.d(var1) != null) {
				var4.addProperty("underlined", hv.d(var1));
			}

			if (hv.e(var1) != null) {
				var4.addProperty("strikethrough", hv.e(var1));
			}

			if (hv.f(var1) != null) {
				var4.addProperty("obfuscated", hv.f(var1));
			}

			if (hv.g(var1) != null) {
				var4.add("color", var3.serialize(hv.g(var1)));
			}

			if (hv.h(var1) != null) {
				var4.add("insertion", var3.serialize(hv.h(var1)));
			}

			JsonObject var5;
			if (hv.i(var1) != null) {
				var5 = new JsonObject();
				var5.addProperty("action", hv.i(var1).a().b());
				var5.addProperty("value", hv.i(var1).b());
				var4.add("clickEvent", var5);
			}

			if (hv.j(var1) != null) {
				var5 = new JsonObject();
				var5.addProperty("action", hv.j(var1).a().b());
				var5.add("value", var3.serialize(hv.j(var1).b()));
				var4.add("hoverEvent", var5);
			}

			return var4;
		}
	}

	// $FF: synthetic method
	public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
		return this.a((hv) var1, var2, var3);
	}

	// $FF: synthetic method
	public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) {
		return this.a(var1, var2, var3);
	}
}
