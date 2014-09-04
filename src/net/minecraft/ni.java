package net.minecraft;

import com.mojang.authlib.GameProfile;
import java.util.UUID;

public class ni implements id<nh> {

	private GameProfile a;

	public ni() {
	}

	public ni(GameProfile var1) {
		this.a = var1;
	}

	public void a(hd var1) {
		this.a = new GameProfile((UUID) null, var1.c(16));
	}

	public void b(hd var1) {
		var1.a(this.a.getName());
	}

	public void a(nh var1) {
		var1.a(this);
	}

	public GameProfile a() {
		return this.a;
	}
}
