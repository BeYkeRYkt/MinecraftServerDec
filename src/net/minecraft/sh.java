package net.minecraft;

import net.minecraft.util.com.mojang.authlib.GameProfile;
import net.minecraft.util.com.mojang.authlib.ProfileLookupCallback;
import net.minecraft.util.com.mojang.authlib.yggdrasil.ProfileNotFoundException;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import net.minecraft.server.MinecraftServer;

final class sh implements ProfileLookupCallback {

	// $FF: synthetic field
	final MinecraftServer a;
	// $FF: synthetic field
	final Map b;
	// $FF: synthetic field
	final GameProfileBanList c;

	sh(MinecraftServer var1, Map var2, GameProfileBanList var3) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
	}

	public void onProfileLookupSucceeded(GameProfile var1) {
		this.a.getUserCache().saveProfile(var1);
		String[] var2 = (String[]) this.b.get(var1.getName().toLowerCase(Locale.ROOT));
		if (var2 == null) {
			sf.a().warn("Could not convert user banlist entry for " + var1.getName());
			throw new sm("Profile not in the conversionlist", (sg) null);
		} else {
			Date var3 = var2.length > 1 ? sf.a(var2[1], (Date) null) : null;
			String var4 = var2.length > 2 ? var2[2] : null;
			Date var5 = var2.length > 3 ? sf.a(var2[3], (Date) null) : null;
			String var6 = var2.length > 4 ? var2[4] : null;
			this.c.add((JsonListEntry) (new GameProfileBanEntry(var1, var3, var4, var5, var6)));
		}
	}

	public void onProfileLookupFailed(GameProfile var1, Exception var2) {
		sf.a().warn("Could not lookup user banlist entry for " + var1.getName(), (Throwable) var2);
		if (!(var2 instanceof ProfileNotFoundException)) {
			throw new sm("Could not request user " + var1.getName() + " from backend systems", var2, (sg) null);
		}
	}
}
