package pipebukkit.server;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.minecraft.NBTCompoundTag;
import net.minecraft.WorldNBTStorage;
import net.minecraft.server.MinecraftServer;

import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;
import org.bukkit.entity.Player;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import net.minecraft.util.com.mojang.authlib.GameProfile;

@SerializableAs("Player")
public class PipeOfflinePlayer implements OfflinePlayer, ConfigurationSerializable {

	private GameProfile profile;
	private final WorldNBTStorage storage;

	public PipeOfflinePlayer(GameProfile profile) {
		this.profile = profile;
		this.storage = (WorldNBTStorage) (MinecraftServer.getInstance().getPrimaryWorld().getDataManager());
	}

	@Override
	public boolean isOp() {
		return MinecraftServer.getInstance().getPlayerList().isOp(profile);
	}

	@Override
	public void setOp(boolean op) {
		if (isOp() == op) {
			return;
		}
		if (op) {
			MinecraftServer.getInstance().getPlayerList().addOp(profile);
		} else {
			MinecraftServer.getInstance().getPlayerList().removeOp(profile);
		}
	}

	@Override
	public Location getBedSpawnLocation() {
		NBTCompoundTag data = getData();
		if (data == null) {
			return null;
		}
		if (data.hasKey("SpawnX") && data.hasKey("SpawnY") && data.hasKey("SpawnZ")) {
			String spawnWorld = data.getString("SpawnWorld");
			if (spawnWorld.equals("")) {
				spawnWorld = Bukkit.getWorlds().get(0).getName();
			}
			return new Location(Bukkit.getWorld(spawnWorld), data.getInt("SpawnX"), data.getInt("SpawnY"), data.getInt("SpawnZ"));
		}
		return null;
	}

	@Override
	public long getFirstPlayed() {
		Player player = getPlayer();
		if (player != null) {
			return player.getFirstPlayed();
		}
		NBTCompoundTag data = getBukkitData();
		if (data != null) {
			if (data.hasKey("firstPlayed")) {
				return data.getLong("firstPlayed");
			} else {
				File file = getDataFile();
				return file.lastModified();
			}
		} else {
			return 0;
		}
	}

	@Override
	public long getLastPlayed() {
		Player player = getPlayer();
		if (player != null) {
			return player.getLastPlayed();
		}
		NBTCompoundTag data = getBukkitData();
		if (data != null) {
			if (data.hasKey("lastPlayed")) {
				return data.getLong("lastPlayed");
			} else {
				File file = getDataFile();
				return file.lastModified();
			}
		} else {
			return 0;
		}
	}

	@Override
	public boolean hasPlayedBefore() {
		return getDataFile().exists();
	}

	@Override
	public String getName() {
		Player player = getPlayer();
		if (player != null) {
			return player.getName();
		}

		if (profile.getName() != null) {
			return profile.getName();
		}

		NBTCompoundTag data = getBukkitData();
		if (data != null) {
			if (data.hasKey("lastKnownName")) {
				return data.getString("lastKnownName");
			}
		}

		return null;
	}

	@Override
	public UUID getUniqueId() {
		return profile.getId();
	}

	@Override
	public Player getPlayer() {
		return Bukkit.getServer().getPlayer(getUniqueId());
	}

	@Override
	public boolean isOnline() {
		return getPlayer() != null;
	}

	@Override
	public boolean isBanned() {
		if (getName() == null) {
			return false;
		}
		return Bukkit.getBanList(Type.NAME).isBanned(getName());
	}

	@Override
	public void setBanned(boolean banned) {
		if (getName() == null) {
			return;
		}
		if (banned) {
			Bukkit.getBanList(Type.NAME).addBan(getName(), null, null, null);
		} else {
			Bukkit.getBanList(Type.NAME).pardon(getName());
		}
	}

	@Override
	public boolean isWhitelisted() {
		return MinecraftServer.getInstance().getPlayerList().getWhitelist().isWhitelisted(profile);
	}

	@Override
	public void setWhitelisted(boolean whitelisted) {
		if (whitelisted) {
			MinecraftServer.getInstance().getPlayerList().addWhitelist(profile);
		} else {
			MinecraftServer.getInstance().getPlayerList().removeWhitelist(profile);
		}
	}

	@Override
	public Map<String, Object> serialize() {
		Map<String, Object> result = new LinkedHashMap<String, Object>();
		result.put("UUID", profile.getId().toString());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof OfflinePlayer)) {
			return false;
		}
		OfflinePlayer other = (OfflinePlayer) obj;
		if ((this.getUniqueId() == null) || (other.getUniqueId() == null)) {
			return false;
		}
		return this.getUniqueId().equals(other.getUniqueId());
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 97 * hash + (this.getUniqueId() != null ? this.getUniqueId().hashCode() : 0);
		return hash;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "[UUID=" + profile.getId() + "]";
	}

	private NBTCompoundTag getBukkitData() {
		NBTCompoundTag result = getData();
		if (result != null) {
			if (!result.hasKey("bukkit")) {
				result.put("bukkit", new NBTCompoundTag());
			}
			result = result.getCompound("bukkit");
		}
		return result;
	}

	private File getDataFile() {
		return new File(storage.getPlayerDir(), getUniqueId() + ".dat");
	}

	private NBTCompoundTag getData() {
		return storage.getPlayerData(getUniqueId().toString());
	}

	public void setMetadata(String metadataKey, MetadataValue metadataValue) {
		 MinecraftServer.getInstance().getPipeServer().getPlayerMetadataStorage().setMetadata(this, metadataKey, metadataValue);
	}

	public List<MetadataValue> getMetadata(String metadataKey) {
		return MinecraftServer.getInstance().getPipeServer().getPlayerMetadataStorage().getMetadata(this, metadataKey);
	}

	public boolean hasMetadata(String metadataKey) {
		return MinecraftServer.getInstance().getPipeServer().getPlayerMetadataStorage().hasMetadata(this, metadataKey);
	}

	public void removeMetadata(String metadataKey, Plugin plugin) {
		MinecraftServer.getInstance().getPipeServer().getPlayerMetadataStorage().removeMetadata(this, metadataKey, plugin);
	}

}
