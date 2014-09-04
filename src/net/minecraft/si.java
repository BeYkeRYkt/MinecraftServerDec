package net.minecraft;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.ProfileLookupCallback;
import com.mojang.authlib.yggdrasil.ProfileNotFoundException;
import net.minecraft.server.MinecraftServer;

final class si implements ProfileLookupCallback {

	// $FF: synthetic field
	final MinecraftServer a;
	// $FF: synthetic field
	final sp b;

	si(MinecraftServer var1, sp var2) {
		this.a = var1;
		this.b = var2;
	}

	public void onProfileLookupSucceeded(GameProfile var1) {
		this.a.aD().a(var1);
		this.b.a((sr) (new sq(var1, this.a.p())));
	}

	public void onProfileLookupFailed(GameProfile var1, Exception var2) {
		sf.a().warn("Could not lookup oplist entry for " + var1.getName(), (Throwable) var2);
		if (!(var2 instanceof ProfileNotFoundException)) {
			throw new sm("Could not request user " + var1.getName() + " from backend systems", var2, (sg) null);
		}
	}
}
