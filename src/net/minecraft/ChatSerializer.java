package net.minecraft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map.Entry;

public class ChatSerializer implements JsonDeserializer, JsonSerializer {

	private static final Gson gson;
	static {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeHierarchyAdapter(IChatBaseComponent.class, new ChatSerializer());
		builder.registerTypeHierarchyAdapter(ChatModifier.class, new ChatModifierSerializer());
		builder.registerTypeAdapterFactory(new ChatTypeAdapterFactory());
		gson = builder.create();
	}

	public IChatBaseComponent a(JsonElement var1, Type var2, JsonDeserializationContext var3) {
		if (var1.isJsonPrimitive()) {
			return new ChatComponentText(var1.getAsString());
		} else if (!var1.isJsonObject()) {
			if (var1.isJsonArray()) {
				JsonArray var11 = var1.getAsJsonArray();
				IChatBaseComponent var12 = null;
				Iterator var15 = var11.iterator();

				while (var15.hasNext()) {
					JsonElement var17 = (JsonElement) var15.next();
					IChatBaseComponent var18 = this.a(var17, (Type) var17.getClass(), var3);
					if (var12 == null) {
						var12 = var18;
					} else {
						var12.a(var18);
					}
				}

				return var12;
			} else {
				throw new JsonParseException("Don\'t know how to turn " + var1.toString() + " into a Component");
			}
		} else {
			JsonObject var4 = var1.getAsJsonObject();
			Object var5;
			if (var4.has("text")) {
				var5 = new ChatComponentText(var4.get("text").getAsString());
			} else if (var4.has("translate")) {
				String var6 = var4.get("translate").getAsString();
				if (var4.has("with")) {
					JsonArray var7 = var4.getAsJsonArray("with");
					Object[] var8 = new Object[var7.size()];

					for (int var9 = 0; var9 < var8.length; ++var9) {
						var8[var9] = this.a(var7.get(var9), var2, var3);
						if (var8[var9] instanceof ChatComponentText) {
							ChatComponentText var10 = (ChatComponentText) var8[var9];
							if (var10.getChatModifier().g() && var10.a().isEmpty()) {
								var8[var9] = var10.g();
							}
						}
					}

					var5 = new ChatMessage(var6, var8);
				} else {
					var5 = new ChatMessage(var6, new Object[0]);
				}
			} else if (var4.has("score")) {
				JsonObject var13 = var4.getAsJsonObject("score");
				if (!var13.has("name") || !var13.has("objective")) {
					throw new JsonParseException("A score component needs a least a name and an objective");
				}

				var5 = new ht(JSONParser.getString(var13, "name"), JSONParser.getString(var13, "objective"));
				if (var13.has("value")) {
					((ht) var5).b(JSONParser.getString(var13, "value"));
				}
			} else {
				if (!var4.has("selector")) {
					throw new JsonParseException("Don\'t know how to turn " + var1.toString() + " into a Component");
				}

				var5 = new hu(JSONParser.getString(var4, "selector"));
			}

			if (var4.has("extra")) {
				JsonArray var14 = var4.getAsJsonArray("extra");
				if (var14.size() <= 0) {
					throw new JsonParseException("Unexpected empty array of components");
				}

				for (int var16 = 0; var16 < var14.size(); ++var16) {
					((IChatBaseComponent) var5).a(this.a(var14.get(var16), var2, var3));
				}
			}

			((IChatBaseComponent) var5).a((ChatModifier) var3.deserialize(var1, ChatModifier.class));
			return (IChatBaseComponent) var5;
		}
	}

	private void a(ChatModifier var1, JsonObject var2, JsonSerializationContext var3) {
		JsonElement var4 = var3.serialize(var1);
		if (var4.isJsonObject()) {
			JsonObject var5 = (JsonObject) var4;
			Iterator var6 = var5.entrySet().iterator();

			while (var6.hasNext()) {
				Entry var7 = (Entry) var6.next();
				var2.add((String) var7.getKey(), (JsonElement) var7.getValue());
			}
		}

	}

	public JsonElement a(IChatBaseComponent var1, Type var2, JsonSerializationContext var3) {
		if (var1 instanceof ChatComponentText && var1.getChatModifier().g() && var1.a().isEmpty()) {
			return new JsonPrimitive(((ChatComponentText) var1).g());
		} else {
			JsonObject var4 = new JsonObject();
			if (!var1.getChatModifier().g()) {
				this.a(var1.getChatModifier(), var4, var3);
			}

			if (!var1.a().isEmpty()) {
				JsonArray var5 = new JsonArray();
				Iterator var6 = var1.a().iterator();

				while (var6.hasNext()) {
					IChatBaseComponent var7 = (IChatBaseComponent) var6.next();
					var5.add(this.a(var7, (Type) var7.getClass(), var3));
				}

				var4.add("extra", var5);
			}

			if (var1 instanceof ChatComponentText) {
				var4.addProperty("text", ((ChatComponentText) var1).g());
			} else if (var1 instanceof ChatMessage) {
				ChatMessage var11 = (ChatMessage) var1;
				var4.addProperty("translate", var11.i());
				if (var11.j() != null && var11.j().length > 0) {
					JsonArray var14 = new JsonArray();
					Object[] var16 = var11.j();
					int var8 = var16.length;

					for (int var9 = 0; var9 < var8; ++var9) {
						Object var10 = var16[var9];
						if (var10 instanceof IChatBaseComponent) {
							var14.add(this.a((IChatBaseComponent) var10, (Type) var10.getClass(), var3));
						} else {
							var14.add(new JsonPrimitive(String.valueOf(var10)));
						}
					}

					var4.add("with", var14);
				}
			} else if (var1 instanceof ht) {
				ht var12 = (ht) var1;
				JsonObject var15 = new JsonObject();
				var15.addProperty("name", var12.g());
				var15.addProperty("objective", var12.h());
				var15.addProperty("value", var12.getComponentVaue());
				var4.add("score", var15);
			} else {
				if (!(var1 instanceof hu)) {
					throw new IllegalArgumentException("Don\'t know how to serialize " + var1 + " as a Component");
				}

				hu var13 = (hu) var1;
				var4.addProperty("selector", var13.g());
			}

			return var4;
		}
	}

	public static String toJsonString(IChatBaseComponent component) {
		return gson.toJson(component);
	}

	public static IChatBaseComponent fromJsonString(String string) {
		return (IChatBaseComponent) gson.fromJson(string, IChatBaseComponent.class);
	}

	// $FF: synthetic method
	public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
		return this.a((IChatBaseComponent) var1, var2, var3);
	}

	// $FF: synthetic method
	public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) {
		return this.a(var1, var2, var3);
	}

}
