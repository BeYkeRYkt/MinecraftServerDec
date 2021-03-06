package pipebukkit.server.metadata;

import org.bukkit.entity.Entity;
import org.bukkit.metadata.MetadataStore;
import org.bukkit.metadata.MetadataStoreBase;

public class EntityMetadataStorage extends MetadataStoreBase<Entity> implements MetadataStore<Entity> {

	@Override
	protected String disambiguate(Entity entity, String metadataKey) {
		return entity.getUniqueId().toString() + ":" + metadataKey;
	}

}
