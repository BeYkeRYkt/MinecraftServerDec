package net.minecraft;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

public class ChatModifierSerializer implements JsonDeserializer, JsonSerializer {

	public ChatModifier a(JsonElement var1, Type var2, JsonDeserializationContext var3) {
		if (var1.isJsonObject()) {
			ChatModifier var4 = new ChatModifier();
			JsonObject var5 = var1.getAsJsonObject();
			if (var5 == null) {
				return null;
			} else {
				if (var5.has("bold")) {
					ChatModifier.a(var4, Boolean.valueOf(var5.get("bold").getAsBoolean()));
				}

				if (var5.has("italic")) {
					ChatModifier.b(var4, Boolean.valueOf(var5.get("italic").getAsBoolean()));
				}

				if (var5.has("underlined")) {
					ChatModifier.c(var4, Boolean.valueOf(var5.get("underlined").getAsBoolean()));
				}

				if (var5.has("strikethrough")) {
					ChatModifier.d(var4, Boolean.valueOf(var5.get("strikethrough").getAsBoolean()));
				}

				if (var5.has("obfuscated")) {
					ChatModifier.e(var4, Boolean.valueOf(var5.get("obfuscated").getAsBoolean()));
				}

				if (var5.has("color")) {
					ChatModifier.a(var4, (EnumChatFormat) var3.deserialize(var5.get("color"), EnumChatFormat.class));
				}

				if (var5.has("insertion")) {
					ChatModifier.a(var4, var5.get("insertion").getAsString());
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
							ChatModifier.a(var4, new hm(var8, var10));
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
							ChatModifier.a(var4, new ChatHoverable(var11, var12));
						}
					}
				}

				return var4;
			}
		} else {
			return null;
		}
	}

	public JsonElement a(ChatModifier var1, Type var2, JsonSerializationContext var3) {
		if (var1.g()) {
			return null;
		} else {
			JsonObject var4 = new JsonObject();
			if (ChatModifier.b(var1) != null) {
				var4.addProperty("bold", ChatModifier.b(var1));
			}

			if (ChatModifier.c(var1) != null) {
				var4.addProperty("italic", ChatModifier.c(var1));
			}

			if (ChatModifier.d(var1) != null) {
				var4.addProperty("underlined", ChatModifier.d(var1));
			}

			if (ChatModifier.e(var1) != null) {
				var4.addProperty("strikethrough", ChatModifier.e(var1));
			}

			if (ChatModifier.f(var1) != null) {
				var4.addProperty("obfuscated", ChatModifier.f(var1));
			}

			if (ChatModifier.g(var1) != null) {
				var4.add("color", var3.serialize(ChatModifier.g(var1)));
			}

			if (ChatModifier.h(var1) != null) {
				var4.add("insertion", var3.serialize(ChatModifier.h(var1)));
			}

			JsonObject var5;
			if (ChatModifier.i(var1) != null) {
				var5 = new JsonObject();
				var5.addProperty("action", ChatModifier.i(var1).a().b());
				var5.addProperty("value", ChatModifier.i(var1).b());
				var4.add("clickEvent", var5);
			}

			if (ChatModifier.j(var1) != null) {
				var5 = new JsonObject();
				var5.addProperty("action", ChatModifier.j(var1).a().b());
				var5.add("value", var3.serialize(ChatModifier.j(var1).b()));
				var4.add("hoverEvent", var5);
			}

			return var4;
		}
	}

	// $FF: synthetic method
	public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
		return this.a((ChatModifier) var1, var2, var3);
	}

	// $FF: synthetic method
	public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) {
		return this.a(var1, var2, var3);
	}
}
