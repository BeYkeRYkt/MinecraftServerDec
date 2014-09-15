package net.minecraft;

import net.minecraft.util.com.mojang.authlib.GameProfile;
import net.minecraft.util.com.mojang.authlib.ProfileLookupCallback;
import net.minecraft.util.com.mojang.authlib.yggdrasil.ProfileNotFoundException;
import net.minecraft.server.MinecraftServer;

final class si implements ProfileLookupCallback {

	// $FF: synthetic field
	final MinecraftServer a;
	// $FF: synthetic field
	final OpList b;

	si(MinecraftServer var1, OpList var2) {
		this.a = var1;
		this.b = var2;
	}

	public void onProfileLookupSucceeded(GameProfile var1) {
		this.a.getUserCache().saveProfile(var1);
		this.b.add((JsonListEntry) (new OpListEntry(var1, this.a.getOpPermissionLevel())));
	}

	public void onProfileLookupFailed(GameProfile var1, Exception var2) {
		sf.a().warn("Could not lookup oplist entry for " + var1.getName(), (Throwable) var2);
		if (!(var2 instanceof ProfileNotFoundException)) {
			throw new sm("Could not request user " + var1.getName() + " from backend systems", var2, (sg) null);
		}
	}
}
