package net.minecraft;

import com.google.gson.JsonObject;
import java.io.File;
import java.net.SocketAddress;

public class sd extends ss {

	public sd(File var1) {
		super(var1);
	}

	protected sr a(JsonObject var1) {
		return new se(var1);
	}

	public boolean a(SocketAddress var1) {
		String var2 = this.c(var1);
		return this.d(var2);
	}

	public se b(SocketAddress var1) {
		String var2 = this.c(var1);
		return (se) this.b(var2);
	}

	private String c(SocketAddress var1) {
		String var2 = var1.toString();
		if (var2.contains("/")) {
			var2 = var2.substring(var2.indexOf(47) + 1);
		}

		if (var2.contains(":")) {
			var2 = var2.substring(0, var2.indexOf(58));
		}

		return var2;
	}
}
