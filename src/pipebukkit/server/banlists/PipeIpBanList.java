package pipebukkit.server.banlists;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Date;
import java.util.Set;

import net.minecraft.IpBanEntry;
import net.minecraft.IpBanList;
import net.minecraft.server.MinecraftServer;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.bukkit.BanList;

import com.google.common.collect.ImmutableSet;

public class PipeIpBanList implements BanList {

	private IpBanList nmsBanList;
	public PipeIpBanList(IpBanList nmsBanList) {
		this.nmsBanList = nmsBanList;
	}

	@Override
	public org.bukkit.BanEntry getBanEntry(String target) {
		Validate.notNull(target, "Target cannot be null");
		IpBanEntry entry = (IpBanEntry) nmsBanList.get(target);
		if (entry == null) {
			return null;
		}
		return new PipeIpBanEntry(target, entry, nmsBanList);
	}

	@Override
	public org.bukkit.BanEntry addBan(String target, String reason, Date expires, String source) {
		Validate.notNull(target, "Ban target cannot be null");
		IpBanEntry entry = new IpBanEntry(target, new Date(), StringUtils.isBlank(source) ? null : source, expires, StringUtils.isBlank(reason) ? null : reason);
		nmsBanList.add(entry);
		try {
			nmsBanList.save();
		} catch (IOException ex) {
			MinecraftServer.getLogger().error("Failed to save banned-ips.json, " + ex.getMessage());
		}
		return new PipeIpBanEntry(target, entry, nmsBanList);
	}

	@Override
	public Set<org.bukkit.BanEntry> getBanEntries() {
		ImmutableSet.Builder<org.bukkit.BanEntry> builder = ImmutableSet.builder();
		for (String target : nmsBanList.getEntries()) {
			builder.add(new PipeIpBanEntry(target, (IpBanEntry) nmsBanList.get(target), nmsBanList));
		}
		return builder.build();
	}

	@Override
	public boolean isBanned(String target) {
		Validate.notNull(target, "Target cannot be null");
		return nmsBanList.isBanned(InetSocketAddress.createUnresolved(target, 0));
	}

	@Override
	public void pardon(String target) {
		Validate.notNull(target, "Target cannot be null");
		nmsBanList.remove(target);
	}

}
