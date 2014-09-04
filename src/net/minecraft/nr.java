package net.minecraft;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.mojang.authlib.GameProfile;
import java.lang.reflect.Type;
import java.util.UUID;

public class nr implements JsonDeserializer, JsonSerializer {

	public nq a(JsonElement var1, Type var2, JsonDeserializationContext var3) {
		JsonObject var4 = uh.l(var1, "players");
		nq var5 = new nq(uh.m(var4, "max"), uh.m(var4, "online"));
		if (uh.d(var4, "sample")) {
			JsonArray var6 = uh.t(var4, "sample");
			if (var6.size() > 0) {
				GameProfile[] var7 = new GameProfile[var6.size()];

				for (int var8 = 0; var8 < var7.length; ++var8) {
					JsonObject var9 = uh.l(var6.get(var8), "player[" + var8 + "]");
					String var10 = uh.h(var9, "id");
					var7[var8] = new GameProfile(UUID.fromString(var10), uh.h(var9, "name"));
				}

				var5.a(var7);
			}
		}

		return var5;
	}

	public JsonElement a(nq var1, Type var2, JsonSerializationContext var3) {
		JsonObject var4 = new JsonObject();
		var4.addProperty("max", (Number) Integer.valueOf(var1.a()));
		var4.addProperty("online", (Number) Integer.valueOf(var1.b()));
		if (var1.c() != null && var1.c().length > 0) {
			JsonArray var5 = new JsonArray();

			for (int var6 = 0; var6 < var1.c().length; ++var6) {
				JsonObject var7 = new JsonObject();
				UUID var8 = var1.c()[var6].getId();
				var7.addProperty("id", var8 == null ? "" : var8.toString());
				var7.addProperty("name", var1.c()[var6].getName());
				var5.add(var7);
			}

			var4.add("sample", var5);
		}

		return var4;
	}

	// $FF: synthetic method
	public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
		return this.a((nq) var1, var2, var3);
	}

	// $FF: synthetic method
	public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) {
		return this.a(var1, var2, var3);
	}
}
