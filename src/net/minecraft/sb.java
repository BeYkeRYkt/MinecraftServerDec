package net.minecraft;

import com.mojang.authlib.GameProfile;
import java.util.Date;

class sb {

	private final GameProfile b;
	private final Date c;
	// $FF: synthetic field
	final ry a;

	private sb(ry var1, GameProfile var2, Date var3) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
	}

	public GameProfile a() {
		return this.b;
	}

	public Date b() {
		return this.c;
	}

	// $FF: synthetic method
	sb(ry var1, GameProfile var2, Date var3, rz var4) {
		this(var1, var2, var3);
	}

	// $FF: synthetic method
	static Date a(sb var0) {
		return var0.c;
	}
}
