package net.minecraft;

import com.mojang.authlib.GameProfile;
import java.util.UUID;

public class nd implements id<nc> {

	private GameProfile a;

	public nd() {
	}

	public nd(GameProfile var1) {
		this.a = var1;
	}

	public void a(hd var1) {
		String var2 = var1.c(36);
		String var3 = var1.c(16);
		UUID var4 = UUID.fromString(var2);
		this.a = new GameProfile(var4, var3);
	}

	public void b(hd var1) {
		UUID var2 = this.a.getId();
		var1.a(var2 == null ? "" : var2.toString());
		var1.a(this.a.getName());
	}

	public void a(nc var1) {
		var1.a(this);
	}
}
