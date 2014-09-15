package pipebukkit.server;

import java.util.ArrayList;

import net.minecraft.EntitySlice;
import net.minecraft.WorldServer;

import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;

import pipebukkit.server.block.PipeBlock;

public class PipeChunk implements Chunk {

	private WorldServer nmsWorld;
	private int x;
	private int z;

	public PipeChunk(WorldServer nmsWorld, int x, int z) {
		this.nmsWorld = nmsWorld;
		this.x = x;
		this.z = z;
	}

	@Override
	public Block getBlock(int x, int y, int z) {
		return new PipeBlock(this, this.x << 4 + x, y, this.z << 4 + z);
	}

	@Override
	public ChunkSnapshot getChunkSnapshot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChunkSnapshot getChunkSnapshot(boolean arg0, boolean arg1, boolean arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity[] getEntities() {
		ArrayList<Entity> entites = new ArrayList<Entity>();
		for (EntitySlice<net.minecraft.Entity> entityslice : getHandle().getEntitySlices()) {
			for (Class<net.minecraft.Entity> clazz : entityslice.getRegisteredClasses()) {
				for (net.minecraft.Entity entity : entityslice.getValues(clazz)) {
					entites.add(entity.getBukkitEntity(Entity.class));
				}
			}
		}
		return entites.toArray(new Entity[entites.size()]);
	}

	@Override
	public BlockState[] getTileEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public World getWorld() {
		return nmsWorld.getBukkitWorld();
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getZ() {
		return z;
	}

	@Override
	public boolean isLoaded() {
		return getWorld().isChunkLoaded(this);
	}

	@Override
	public boolean load() {
		return load(true);
	}

	@Override
	public boolean load(boolean generate) {
		return getWorld().loadChunk(x, z, generate);
	}

	@Override
	public boolean unload() {
		return getWorld().unloadChunk(x, z);
	}

	@Override
	public boolean unload(boolean save) {
		return getWorld().unloadChunk(x, z, save);
	}

	@Override
	public boolean unload(boolean save, boolean safe) {
		return getWorld().unloadChunk(x, z, save, safe);
	}

	public net.minecraft.Chunk getHandle() {
		return nmsWorld.chunkProviderServer.getChunkAt(x, z);
	}

}
