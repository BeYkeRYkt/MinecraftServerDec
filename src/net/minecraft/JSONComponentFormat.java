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

public class JSONComponentFormat implements JsonDeserializer, JsonSerializer {

	private static final Gson a;

	public IJSONComponent a(JsonElement var1, Type var2, JsonDeserializationContext var3) {
		if (var1.isJsonPrimitive()) {
			return new hy(var1.getAsString());
		} else if (!var1.isJsonObject()) {
			if (var1.isJsonArray()) {
				JsonArray var11 = var1.getAsJsonArray();
				IJSONComponent var12 = null;
				Iterator var15 = var11.iterator();

				while (var15.hasNext()) {
					JsonElement var17 = (JsonElement) var15.next();
					IJSONComponent var18 = this.a(var17, (Type) var17.getClass(), var3);
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
				var5 = new hy(var4.get("text").getAsString());
			} else if (var4.has("translate")) {
				String var6 = var4.get("translate").getAsString();
				if (var4.has("with")) {
					JsonArray var7 = var4.getAsJsonArray("with");
					Object[] var8 = new Object[var7.size()];

					for (int var9 = 0; var9 < var8.length; ++var9) {
						var8[var9] = this.a(var7.get(var9), var2, var3);
						if (var8[var9] instanceof hy) {
							hy var10 = (hy) var8[var9];
							if (var10.b().g() && var10.a().isEmpty()) {
								var8[var9] = var10.g();
							}
						}
					}

					var5 = new hz(var6, var8);
				} else {
					var5 = new hz(var6, new Object[0]);
				}
			} else if (var4.has("score")) {
				JsonObject var13 = var4.getAsJsonObject("score");
				if (!var13.has("name") || !var13.has("objective")) {
					throw new JsonParseException("A score component needs a least a name and an objective");
				}

				var5 = new ht(uh.h(var13, "name"), uh.h(var13, "objective"));
				if (var13.has("value")) {
					((ht) var5).b(uh.h(var13, "value"));
				}
			} else {
				if (!var4.has("selector")) {
					throw new JsonParseException("Don\'t know how to turn " + var1.toString() + " into a Component");
				}

				var5 = new hu(uh.h(var4, "selector"));
			}

			if (var4.has("extra")) {
				JsonArray var14 = var4.getAsJsonArray("extra");
				if (var14.size() <= 0) {
					throw new JsonParseException("Unexpected empty array of components");
				}

				for (int var16 = 0; var16 < var14.size(); ++var16) {
					((IJSONComponent) var5).a(this.a(var14.get(var16), var2, var3));
				}
			}

			((IJSONComponent) var5).a((hv) var3.deserialize(var1, hv.class));
			return (IJSONComponent) var5;
		}
	}

	private void a(hv var1, JsonObject var2, JsonSerializationContext var3) {
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

	public JsonElement a(IJSONComponent var1, Type var2, JsonSerializationContext var3) {
		if (var1 instanceof hy && var1.b().g() && var1.a().isEmpty()) {
			return new JsonPrimitive(((hy) var1).g());
		} else {
			JsonObject var4 = new JsonObject();
			if (!var1.b().g()) {
				this.a(var1.b(), var4, var3);
			}

			if (!var1.a().isEmpty()) {
				JsonArray var5 = new JsonArray();
				Iterator var6 = var1.a().iterator();

				while (var6.hasNext()) {
					IJSONComponent var7 = (IJSONComponent) var6.next();
					var5.add(this.a(var7, (Type) var7.getClass(), var3));
				}

				var4.add("extra", var5);
			}

			if (var1 instanceof hy) {
				var4.addProperty("text", ((hy) var1).g());
			} else if (var1 instanceof hz) {
				hz var11 = (hz) var1;
				var4.addProperty("translate", var11.i());
				if (var11.j() != null && var11.j().length > 0) {
					JsonArray var14 = new JsonArray();
					Object[] var16 = var11.j();
					int var8 = var16.length;

					for (int var9 = 0; var9 < var8; ++var9) {
						Object var10 = var16[var9];
						if (var10 instanceof IJSONComponent) {
							var14.add(this.a((IJSONComponent) var10, (Type) var10.getClass(), var3));
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
				var15.addProperty("value", var12.e());
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

	public static String a(IJSONComponent var0) {
		return a.toJson((Object) var0);
	}

	public static IJSONComponent a(String var0) {
		return (IJSONComponent) a.fromJson(var0, IJSONComponent.class);
	}

	// $FF: synthetic method
	public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
		return this.a((IJSONComponent) var1, var2, var3);
	}

	// $FF: synthetic method
	public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) {
		return this.a(var1, var2, var3);
	}

	static {
		GsonBuilder var0 = new GsonBuilder();
		var0.registerTypeHierarchyAdapter(IJSONComponent.class, new JSONComponentFormat());
		var0.registerTypeHierarchyAdapter(hv.class, new hx());
		var0.registerTypeAdapterFactory(new ut());
		a = var0.create();
	}
}
