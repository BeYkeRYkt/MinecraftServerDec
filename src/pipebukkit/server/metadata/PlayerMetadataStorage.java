package pipebukkit.server.metadata;

import org.bukkit.OfflinePlayer;
import org.bukkit.metadata.MetadataStore;
import org.bukkit.metadata.MetadataStoreBase;

public class PlayerMetadataStorage extends MetadataStoreBase<OfflinePlayer> implements MetadataStore<OfflinePlayer> {

	@Override
	protected String disambiguate(OfflinePlayer player, String metadataKey) {
		return player.getName().toLowerCase() + ":" + metadataKey;
	}

}
