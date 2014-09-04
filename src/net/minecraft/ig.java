package net.minecraft;

public class ig {

	public static void a(id var0, hg var1, vn var2) {
		if (!var2.isMainThread()) {
			var2.a(new ih(var0, var1));
			throw pi.a;
		}
	}
}
