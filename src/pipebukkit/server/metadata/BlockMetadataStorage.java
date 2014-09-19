package pipebukkit.server.metadata;

import java.lang.ref.WeakReference;
import java.util.List;

import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.metadata.MetadataStore;
import org.bukkit.metadata.MetadataStoreBase;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

public class BlockMetadataStorage extends MetadataStoreBase<Block> implements MetadataStore<Block> {

	private final WeakReference<World> world;

	public BlockMetadataStorage(World world) {
		this.world = new WeakReference<World>(world);
	}

	@Override
	protected String disambiguate(Block block, String metadataKey) {
		return Integer.toString(block.getX()) + ":" + Integer.toString(block.getY()) + ":" + Integer.toString(block.getZ()) + ":" + metadataKey;
	}

	@Override
	public List<MetadataValue> getMetadata(Block block, String metadataKey) {
		if (block.getWorld() == world.get()) {
			return super.getMetadata(block, metadataKey);
		} else {
			World world = this.world.get();
			if (world == null) {
				throw new IllegalArgumentException("World went out of scope");
			} else {
				throw new IllegalArgumentException("Block does not belong to world " + world.getName());
			}
		}
	}

	@Override
	public boolean hasMetadata(Block block, String metadataKey) {
		if (block.getWorld() == world.get()) {
			return super.hasMetadata(block, metadataKey);
		} else {
			World world = this.world.get();
			if (world == null) {
				throw new IllegalArgumentException("World went out of scope");
			} else {
				throw new IllegalArgumentException("Block does not belong to world " + world.getName());
			}
		}
	}

	@Override
	public void removeMetadata(Block block, String metadataKey, Plugin owningPlugin) {
		if (block.getWorld() == world.get()) {
			super.removeMetadata(block, metadataKey, owningPlugin);
		} else {
			World world = this.world.get();
			if (world == null) {
				throw new IllegalArgumentException("World went out of scope");
			} else {
				throw new IllegalArgumentException("Block does not belong to world " + world.getName());
			}
		}
	}

	@Override
	public void setMetadata(Block block, String metadataKey, MetadataValue newMetadataValue) {
		if (block.getWorld() == world) {
			super.setMetadata(block, metadataKey, newMetadataValue);
		} else {
			World world = this.world.get();
			if (world == null) {
				throw new IllegalArgumentException("World went out of scope");
			} else {
				throw new IllegalArgumentException("Block does not belong to world " + world.getName());
			}
		}
	}

}
