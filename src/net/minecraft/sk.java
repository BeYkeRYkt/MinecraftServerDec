package net.minecraft;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.ProfileLookupCallback;
import java.util.List;
import net.minecraft.server.MinecraftServer;

final class sk implements ProfileLookupCallback {

	// $FF: synthetic field
	final MinecraftServer a;
	// $FF: synthetic field
	final List b;

	sk(MinecraftServer var1, List var2) {
		this.a = var1;
		this.b = var2;
	}

	public void onProfileLookupSucceeded(GameProfile var1) {
		this.a.getUserCache().a(var1);
		this.b.add(var1);
	}

	public void onProfileLookupFailed(GameProfile var1, Exception var2) {
		sf.a().warn("Could not lookup user whitelist entry for " + var1.getName(), (Throwable) var2);
	}
}
