package pipebukkit.server.block;

import java.util.Collection;
import java.util.List;

import net.minecraft.BlockRedstoneWire;
import net.minecraft.Blocks;
import net.minecraft.EnumSkyBlock;
import net.minecraft.IBlockState;
import net.minecraft.Position;
import net.minecraft.server.MinecraftServer;

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
	public List<MetadataValue> getMetadata(String metadataKey) {
		return MinecraftServer.getInstance().getPipeServer().getBlockMetadataStorage(getWorld()).getMetadata(this, metadataKey);
	}

	@Override
	public boolean hasMetadata(String metadataKey) {
		return MinecraftServer.getInstance().getPipeServer().getBlockMetadataStorage(getWorld()).hasMetadata(this, metadataKey);
	}

	@Override
	public void removeMetadata(String metadataKey, Plugin owningPlugin) {
		MinecraftServer.getInstance().getPipeServer().getBlockMetadataStorage(getWorld()).removeMetadata(this, metadataKey, owningPlugin);
	}

	@Override
	public void setMetadata(String metadataKey, MetadataValue metadataValue) {
		MinecraftServer.getInstance().getPipeServer().getBlockMetadataStorage(getWorld()).setMetadata(this, metadataKey, metadataValue);
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
		return getWorld().getBiome(x, z);
	}

	@Override
	public void setBiome(Biome biome) {
		getWorld().setBiome(x, z, biome);
	}

	@Override
	public Chunk getChunk() {
		return chunk;
	}

	@Override
	public byte getData() {
		return (byte) chunk.getHandle().getBlockDataAt(getPosition());
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
		return getWorld().getHumidity(x, z);
	}

	@Override
	public byte getLightFromBlocks() {
		return (byte) chunk.getHandle().getBrightness(EnumSkyBlock.BLOCK, getPosition());
	}

	@Override
	public byte getLightFromSky() {
		return (byte) chunk.getHandle().getBrightness(EnumSkyBlock.SKY, getPosition());
	}

	@Override
	public byte getLightLevel() {
		return (byte) chunk.getHandle().getWorld().getLightLevel(getPosition());
	}

	@Override
	public double getTemperature() {
		return getWorld().getTemperature(x, z);
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

	@SuppressWarnings("deprecation")
	@Override
	public PistonMoveReaction getPistonMoveReaction() {
		return PistonMoveReaction.getById(chunk.getHandle().getBlockAtWorldCoords(x, y, z).getMaterial().getPushReaction());
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
		Material material = getType();
		switch (material) {
			case SIGN: case SIGN_POST: case WALL_SIGN: {
				return new PipeSign(this);
			}
			case CHEST: case TRAPPED_CHEST: {
				return new PipeChest(this);
			}
			case BURNING_FURNACE: case FURNACE: {
				return new PipeFurnace(this);
			}
			case DISPENSER: {
				return new PipeDispenser(this);
			}
			case DROPPER: {
				return new PipeDropper(this);
			}
			case HOPPER: {
				return new PipeHopper(this);
			}
			case MOB_SPAWNER: {
				return new PipeMobSpawner(this);
			}
			case NOTE_BLOCK: {
				return new PipeNoteBlock(this);
			}
			case JUKEBOX: {
				return new PipeJukebox(this);
			}
			case BREWING_STAND: {
				return new PipeBrewingStand(this);
			}
			case SKULL: {
				return new PipeSkull(this);
			}
			case COMMAND: {
				return new PipeCommandBlock(this);
			}
			case BEACON: {
				return new PipeBeacon(this);
			}
			default: {
				return new PipeBlockState(this);
			}
		}
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
	public boolean isEmpty() {
		return getType() == Material.AIR;
	}

	@Override
	public boolean isLiquid() {
		return chunk.getHandle().getBlockAtWorldCoords(x, y, z).getMaterial().isLiquid();
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

	@Override
	public int getBlockPower() {
		return getBlockPower(BlockFace.SELF);
	}

	@Override
	public int getBlockPower(BlockFace face) {
		//TODO: check this
		int power = 0;
		BlockRedstoneWire redstonewire = Blocks.REDSTONE_WIRE;
		net.minecraft.World nmsWorld = chunk.getHandle().getWorld();
		if ((face == BlockFace.DOWN || face == BlockFace.SELF) && nmsWorld.isBlockFacePowered(getPosition().getDown(), net.minecraft.BlockFace.DOWN)) {
			power = redstonewire.getPower(nmsWorld, getPosition().getDown(), power);
		}
		if ((face == BlockFace.UP || face == BlockFace.SELF) && nmsWorld.isBlockFacePowered(getPosition().getUp(), net.minecraft.BlockFace.UP)) {
			power = redstonewire.getPower(nmsWorld, getPosition().getUp(), power);
		}
		if ((face == BlockFace.EAST || face == BlockFace.SELF) && nmsWorld.isBlockFacePowered(getPosition().getEast(), net.minecraft.BlockFace.EAST)) {
			power = redstonewire.getPower(nmsWorld, getPosition().getEast(), power);
		}
		if ((face == BlockFace.WEST || face == BlockFace.SELF) && nmsWorld.isBlockFacePowered(getPosition().getWest(), net.minecraft.BlockFace.WEST)) {
			power = redstonewire.getPower(nmsWorld, getPosition().getWest(), power);
		}
		if ((face == BlockFace.NORTH || face == BlockFace.SELF) && nmsWorld.isBlockFacePowered(getPosition().getNorth(), net.minecraft.BlockFace.NORTH)) {
			power = redstonewire.getPower(nmsWorld, getPosition().getNorth(), power);
		}
		if ((face == BlockFace.SOUTH || face == BlockFace.SELF) && nmsWorld.isBlockFacePowered(getPosition().getSouth(), net.minecraft.BlockFace.SOUTH)) {
			power = redstonewire.getPower(nmsWorld, getPosition().getSouth(), power);
		}
		return power > 0 ? power : (face == BlockFace.SELF ? isBlockIndirectlyPowered() : isBlockFaceIndirectlyPowered(face)) ? 15 : 0;
	}

	@Override
	public boolean isBlockIndirectlyPowered() {
		return chunk.getHandle().getWorld().isBlockIndirectlyPowered(getPosition());
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean isBlockFaceIndirectlyPowered(BlockFace face) {
		//TODO: check this
		int power = chunk.getHandle().getWorld().getBlockFacePower(getPosition(), net.minecraft.BlockFace.valueOf(face.name()));
		Block relative = getRelative(face);
		if (relative.getType() == Material.REDSTONE_WIRE) {
			return Math.max(power, relative.getData()) > 0;
		}
		return power > 0;
	}

	@Override
	public boolean isBlockFacePowered(BlockFace face) {
		//TODO: check this
		return chunk.getHandle().getWorld().getBlockFacePower(getPosition(), net.minecraft.BlockFace.valueOf(face.name())) > 0;
	}

	@Override
	public boolean isBlockPowered() {
		return chunk.getHandle().getWorld().getBlockPower(getPosition()) > 0;
	}

	@Override
	public int hashCode() {
		return y << 24 ^ x ^ z ^ getWorld().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Block)) {
			return false;
		}
		Block other = (Block) obj;
		return x == other.getX() && y == other.getY() && z == other.getZ() && getWorld() == other.getWorld();
	}

	private Position getPosition() {
		return new Position(getX(), getY(), getZ());
	} 

}
