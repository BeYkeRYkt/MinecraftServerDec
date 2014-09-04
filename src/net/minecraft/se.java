package net.minecraft;

import com.google.gson.JsonObject;
import java.util.Date;

public class se extends rx {

	public se(String var1) {
		this(var1, (Date) null, (String) null, (Date) null, (String) null);
	}

	public se(String var1, Date var2, String var3, Date var4, String var5) {
		super(var1, var2, var3, var4, var5);
	}

	public se(JsonObject var1) {
		super(b(var1), var1);
	}

	private static String b(JsonObject var0) {
		return var0.has("ip") ? var0.get("ip").getAsString() : null;
	}

	protected void a(JsonObject var1) {
		if (this.f() != null) {
			var1.addProperty("ip", (String) this.f());
			super.a(var1);
		}
	}
}
