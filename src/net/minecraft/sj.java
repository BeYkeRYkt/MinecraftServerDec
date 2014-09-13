package net.minecraft;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.ProfileLookupCallback;
import com.mojang.authlib.yggdrasil.ProfileNotFoundException;
import net.minecraft.server.MinecraftServer;

final class sj implements ProfileLookupCallback {

	// $FF: synthetic field
	final MinecraftServer a;
	// $FF: synthetic field
	final WhiteList b;

	sj(MinecraftServer var1, WhiteList var2) {
		this.a = var1;
		this.b = var2;
	}

	public void onProfileLookupSucceeded(GameProfile var1) {
		this.a.getUserCache().saveProfile(var1);
		this.b.add((JsonListEntry) (new WhiteListEntry(var1)));
	}

	public void onProfileLookupFailed(GameProfile var1, Exception var2) {
		sf.a().warn("Could not lookup user whitelist entry for " + var1.getName(), (Throwable) var2);
		if (!(var2 instanceof ProfileNotFoundException)) {
			throw new sm("Could not request user " + var1.getName() + " from backend systems", var2, (sg) null);
		}
	}
}
