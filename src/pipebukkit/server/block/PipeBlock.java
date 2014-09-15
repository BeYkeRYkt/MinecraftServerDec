package pipebukkit.server.block;

import java.util.Collection;
import java.util.List;

import net.minecraft.IBlockState;
import net.minecraft.Position;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import pipebukkit.server.PipeChunk;

public class PipeBlock implements Block {

	private PipeChunk chunk;
	private int x;
	private int y;
	private int z;

	public PipeBlock(PipeChunk chunk, int x, int y, int z) {
		this.chunk = chunk;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public List<MetadataValue> getMetadata(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasMetadata(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeMetadata(String arg0, Plugin arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMetadata(String arg0, MetadataValue arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean breakNaturally() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean breakNaturally(ItemStack arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Biome getBiome() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getBlockPower() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBlockPower(BlockFace arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Chunk getChunk() {
		return chunk;
	}

	@Override
	public byte getData() {
		return (byte) chunk.getHandle().getBlockDataAt(new Position(x, y, z));
	}

	@Override
	public Collection<ItemStack> getDrops() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ItemStack> getDrops(ItemStack arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlockFace getFace(Block block) {
		BlockFace[] values = BlockFace.values();
		for (BlockFace face : values) {
			if (
				(this.getX() + face.getModX() == block.getX()) &&
				(this.getY() + face.getModY() == block.getY()) &&
				(this.getZ() + face.getModZ() == block.getZ())
			) {
				return face;
			}
		}
		return null;
	}

	@Override
	public double getHumidity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public byte getLightFromBlocks() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public byte getLightFromSky() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public byte getLightLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Location getLocation() {
		return new Location(getWorld(), x, y, z);
	}

	@Override
	public Location getLocation(Location store) {
		if (store != null) {
			store.setWorld(getWorld());
			store.setX(x);
			store.setY(y);
			store.setZ(z);
			store.setYaw(0);
			store.setPitch(0);
		}
		return store;
	}

	@Override
	public PistonMoveReaction getPistonMoveReaction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Block getRelative(BlockFace face) {
		return getRelative(face, 1);
	}

	@Override
	public Block getRelative(BlockFace face, int distance) {
		return getRelative(face.getModX() * distance, face.getModY() * distance, face.getModZ() * distance);
	}

	@Override
	public Block getRelative(int modX, int modY, int modZ) {
		return getWorld().getBlockAt(getX() + modX, getY() + modY, getZ() + modZ);
	}

	@Override
	public BlockState getState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getTemperature() {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Material getType() {
		return Material.getMaterial(getTypeId());
	}

	@Override
	public int getTypeId() {
		return net.minecraft.Block.getBlockId(chunk.getHandle().getBlockAtWorldCoords(x, y, z));
	}

	@Override
	public World getWorld() {
		return chunk.getWorld();
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getZ() {
		return z;
	}

	@Override
	public boolean isBlockFaceIndirectlyPowered(BlockFace arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isBlockFacePowered(BlockFace arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isBlockIndirectlyPowered() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isBlockPowered() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		return getType() == Material.AIR;
	}

	@Override
	public boolean isLiquid() {
		return chunk.getHandle().getBlockAtWorldCoords(x, y, z).getMaterial().isLiquid();
	}

	@Override
	public void setBiome(Biome arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setData(byte data) {
		setData(data, true);
	}

	@Override
	public void setData(byte data, boolean applyPhysics) {
		setTypeIdAndData(getTypeId(), data, applyPhysics);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setType(Material material) {
		setTypeId(material.getId());
	}

	@Override
	public boolean setTypeId(int id) {
		return setTypeId(id, true);
	}

	@Override
	public boolean setTypeId(int id, boolean applyPhysics) {
		return setTypeIdAndData(id, (byte) 0, applyPhysics);
	}

	@Override
	public boolean setTypeIdAndData(int id, byte data, boolean applyPhysics) {
		Position position = new Position(x, y, z);
		IBlockState blockState = net.minecraft.Block.getStateById((data & 0xF) << 12 + (id & 0xF0));
		if (applyPhysics) {
			return chunk.getHandle().getWorld().setBlockAt(position, blockState, 3);
		} else {
			boolean success = chunk.getHandle().getWorld().setBlockAt(position, blockState, 2);
			if (success) {
				chunk.getHandle().getWorld().notify(new Position(x, y, z));
			}
			return success;
		}
	}

}
