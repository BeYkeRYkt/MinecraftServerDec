package net.minecraft;

import com.mojang.authlib.GameProfile;

public class kk {

	private final int b;
	private final GameMode c;
	private final GameProfile d;
	private final IChatBaseComponent e;
	// $FF: synthetic field
	final kh a;

	public kk(kh var1, GameProfile var2, int var3, GameMode var4, IChatBaseComponent var5) {
		this.a = var1;
		this.d = var2;
		this.b = var3;
		this.c = var4;
		this.e = var5;
	}

	public GameProfile a() {
		return this.d;
	}

	public int b() {
		return this.b;
	}

	public GameMode c() {
		return this.c;
	}

	public IChatBaseComponent d() {
		return this.e;
	}
}
