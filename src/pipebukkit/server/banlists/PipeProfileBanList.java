package pipebukkit.server.banlists;

import java.io.IOException;
import java.util.Date;
import java.util.Set;

import net.minecraft.GameProfileBanEntry;
import net.minecraft.GameProfileBanList;
import net.minecraft.JsonListEntry;
import net.minecraft.server.MinecraftServer;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.bukkit.BanList;

import com.google.common.collect.ImmutableSet;
import com.mojang.authlib.GameProfile;

public class PipeProfileBanList implements BanList {

	private GameProfileBanList nmsBanList;
	public PipeProfileBanList(GameProfileBanList nmsBanList) {
		this.nmsBanList = nmsBanList;
	}

	@Override
	public org.bukkit.BanEntry getBanEntry(String target) {
		Validate.notNull(target, "Target cannot be null");
		GameProfile profile = MinecraftServer.getInstance().getUserCache().getProfile(target);
		if (profile == null) {
			return null;
		}
		GameProfileBanEntry entry = (GameProfileBanEntry) nmsBanList.get(profile);
		if (entry == null) {
			return null;
		}
		return new PipeProfileBanEntry(profile, entry, nmsBanList);
	}

	@Override
	public org.bukkit.BanEntry addBan(String target, String reason, Date expires, String source) {
		Validate.notNull(target, "Ban target cannot be null");
		GameProfile profile = MinecraftServer.getInstance().getUserCache().getProfile(target);
		if (profile == null) {
			return null;
		}
		GameProfileBanEntry entry = new GameProfileBanEntry(profile, new Date(), StringUtils.isBlank(source) ? null : source, expires, StringUtils.isBlank(reason) ? null : reason);
		nmsBanList.add(entry);
		try {
			nmsBanList.save();
		} catch (IOException ex) {
			MinecraftServer.getLogger().error("Failed to save banned-players.json, " + ex.getMessage());
		}
		return new PipeProfileBanEntry(profile, entry, nmsBanList);
	}

	@Override
	public Set<org.bukkit.BanEntry> getBanEntries() {
		ImmutableSet.Builder<org.bukkit.BanEntry> builder = ImmutableSet.builder();
		for (JsonListEntry<GameProfile> entry : nmsBanList.getProfiles()) {
			GameProfile profile = entry.getObject();
			builder.add(new PipeProfileBanEntry(profile, (GameProfileBanEntry) entry, nmsBanList));
		}
		return builder.build();
	}

	@Override
	public boolean isBanned(String target) {
		Validate.notNull(target, "Target cannot be null");
		GameProfile profile = MinecraftServer.getInstance().getUserCache().getProfile(target);
		if (profile == null) {
			return false;
		}
		return nmsBanList.isBanned(profile);
	}

	@Override
	public void pardon(String target) {
		Validate.notNull(target, "Target cannot be null");
		GameProfile profile = MinecraftServer.getInstance().getUserCache().getProfile(target);
		nmsBanList.remove(profile);
	}

}
