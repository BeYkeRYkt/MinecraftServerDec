package pipebukkit.server.block;

import java.util.List;

import net.minecraft.Position;
import net.minecraft.TileEntity;
import net.minecraft.server.MinecraftServer;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import pipebukkit.server.PipeWorld;

public class PipeBlockState implements BlockState {

	private int type;
	private MaterialData data;
	private Location location;
	private byte light;

	@SuppressWarnings("deprecation")
	public PipeBlockState(PipeBlock block) {
		type = block.getTypeId();
		data = new MaterialData(type, block.getData());
		location = block.getLocation();
		light = block.getLightLevel();
	}

	@Override
	public List<MetadataValue> getMetadata(String metadataKey) {
		return MinecraftServer.getInstance().getPipeServer().getBlockMetadataStorage(getWorld()).getMetadata(getBlock(), metadataKey);
	}

	@Override
	public boolean hasMetadata(String metadataKey) {
		return MinecraftServer.getInstance().getPipeServer().getBlockMetadataStorage(getWorld()).hasMetadata(getBlock(), metadataKey);
	}

	@Override
	public void removeMetadata(String metadataKey, Plugin owningPlugin) {
		MinecraftServer.getInstance().getPipeServer().getBlockMetadataStorage(getWorld()).removeMetadata(getBlock(), metadataKey, owningPlugin);
	}

	@Override
	public void setMetadata(String metadataKey, MetadataValue metadataValue) {
		MinecraftServer.getInstance().getPipeServer().getBlockMetadataStorage(getWorld()).setMetadata(getBlock(), metadataKey, metadataValue);
	}

	@Override
	public Block getBlock() {
		return location.getBlock();
	}

	@Override
	public Chunk getChunk() {
		return location.getChunk();
	}

	@Override
	public MaterialData getData() {
		return data;
	}

	@Override
	public byte getLightLevel() {
		return light;
	}

	@Override
	public Location getLocation() {
		return location;
	}

	@Override
	public Location getLocation(Location store) {
		return store.zero().add(location);
	}

	@SuppressWarnings("deprecation")
	@Override
	public byte getRawData() {
		return data.getData();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Material getType() {
		return Material.getMaterial(getTypeId());
	}

	@Override
	public int getTypeId() {
		return type;
	}

	@Override
	public World getWorld() {
		return location.getWorld();
	}

	@Override
	public int getX() {
		return location.getBlockX();
	}

	@Override
	public int getY() {
		return location.getBlockY();
	}

	@Override
	public int getZ() {
		return location.getBlockZ();
	}

	@Override
	public void setData(MaterialData data) {
		this.data = data;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setRawData(byte data) {
		this.data.setData(data);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setType(Material material) {
		setTypeId(material.getId());
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean setTypeId(int type) {
		if (this.type != type) {
			data = new MaterialData(type, (byte) 0);
		}
		this.type = type;
		return true;
	}

	@Override
	public boolean update() {
		return update(false);
	}

	@Override
	public boolean update(boolean force) {
		return update(force, true);
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean update(boolean force, boolean applyPhysics) {
		if (type != getBlock().getTypeId() && !force) {
			return false;
		}
		return getBlock().setTypeIdAndData(type, getRawData(), applyPhysics);
	}

	protected TileEntity getTileEntity() {
		return ((PipeWorld) getWorld()).getHandle().getTileEntity(new Position(getX(), getY(), getZ()));
	}

}
