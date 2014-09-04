package net.minecraft;

import com.google.gson.JsonObject;
import com.mojang.authlib.GameProfile;
import java.util.UUID;

public class sq extends sr {

	private final int a;

	public sq(GameProfile var1, int var2) {
		super(var1);
		this.a = var2;
	}

	public sq(JsonObject var1) {
		super(b(var1), var1);
		this.a = var1.has("level") ? var1.get("level").getAsInt() : 0;
	}

	public int a() {
		return this.a;
	}

	protected void a(JsonObject var1) {
		if (this.f() != null) {
			var1.addProperty("uuid", ((GameProfile) this.f()).getId() == null ? "" : ((GameProfile) this.f()).getId().toString());
			var1.addProperty("name", ((GameProfile) this.f()).getName());
			super.a(var1);
			var1.addProperty("level", (Number) Integer.valueOf(this.a));
		}
	}

	private static GameProfile b(JsonObject var0) {
		if (var0.has("uuid") && var0.has("name")) {
			String var1 = var0.get("uuid").getAsString();

			UUID var2;
			try {
				var2 = UUID.fromString(var1);
			} catch (Throwable var4) {
				return null;
			}

			return new GameProfile(var2, var0.get("name").getAsString());
		} else {
			return null;
		}
	}
}
