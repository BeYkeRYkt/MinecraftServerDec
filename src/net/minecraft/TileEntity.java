package net.minecraft;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.Callable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bukkit.inventory.InventoryHolder;

public abstract class TileEntity {

	private static final Logger logger = LogManager.getLogger();
	private static Map<String, Class<? extends TileEntity>> nameToClass = Maps.newHashMap();
	private static Map<Class<? extends TileEntity>, String> classToName = Maps.newHashMap();

	private static void register(Class<? extends TileEntity> tileEntityClass, String name) {
		if (nameToClass.containsKey(name)) {
			throw new IllegalArgumentException("Duplicate id: " + name);
		} else {
			nameToClass.put(name, tileEntityClass);
			classToName.put(tileEntityClass, name);
		}
	}

	public static TileEntity fromNBT(NBTCompoundTag nbt) {
		TileEntity tile = null;

		try {
			Class<? extends TileEntity> tileEntityClass = nameToClass.get(nbt.getString("id"));
			if (tileEntityClass != null) {
				tile = tileEntityClass.newInstance();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		if (tile != null) {
			tile.read(nbt);
		} else {
			logger.warn("Skipping BlockEntity with id " + nbt.getString("id"));
		}

		return tile;
	}

	static {
		register(TileEntityFurnace.class, "Furnace");
		register(TileEntityChest.class, "Chest");
		register(TileEntityEnderChest.class, "EnderChest");
		register(TileEntityRecordPlayer.class, "RecordPlayer");
		register(TileEntityDispenser.class, "Trap");
		register(TileEntityDropper.class, "Dropper");
		register(TileEntitySign.class, "Sign");
		register(TileEntityMobSpawner.class, "MobSpawner");
		register(TileEntityNote.class, "Music");
		register(TileEntityPiston.class, "Piston");
		register(TileEntityBrewingStand.class, "Cauldron");
		register(TileEntityEnchantTable.class, "EnchantTable");
		register(TileEntityEnderPortal.class, "Airportal");
		register(TileEntityCommand.class, "Control");
		register(TileEntityBeacon.class, "Beacon");
		register(TileEntitySkull.class, "Skull");
		register(TileEntityLightDetector.class, "DLDetector");
		register(TileEntityHopper.class, "Hopper");
		register(TileEntityComparator.class, "Comparator");
		register(TileEntityFlowerPot.class, "FlowerPot");
		register(TileEntityBanner.class, "Banner");
	}
	
	protected WorldServer world;
	protected Position position;
	protected boolean invalid;
	private int blockData;
	protected Block block;

	public TileEntity() {
		this.position = Position.ZERO;
		this.blockData = -1;
	}

	public WorldServer getWorld() {
		return this.world;
	}

	public void setWorld(WorldServer world) {
		this.world = world;
	}

	public boolean hasWorld() {
		return this.world != null;
	}

	public void read(NBTCompoundTag tag) {
		this.position = new Position(tag.getInt("x"), tag.getInt("y"), tag.getInt("z"));
	}

	public void write(NBTCompoundTag tag) {
		String name = (String) classToName.get(this.getClass());
		if (name == null) {
			throw new RuntimeException(this.getClass() + " is missing a mapping! This is a bug!");
		} else {
			tag.put("id", name);
			tag.put("x", this.position.getX());
			tag.put("y", this.position.getY());
			tag.put("z", this.position.getZ());
		}
	}

	public int getBlockData() {
		if (this.blockData == -1) {
			IBlockState var1 = this.world.getBlockState(this.position);
			this.blockData = var1.getBlock().getData(var1);
		}

		return this.blockData;
	}

	public void update() {
		if (this.world != null) {
			IBlockState blockState = this.world.getBlockState(this.position);
			this.blockData = blockState.getBlock().getData(blockState);
			this.world.b(this.position, this);
			if (this.getBlock() != Blocks.AIR) {
				this.world.e(this.position, this.getBlock());
			}
		}

	}

	public Position getPosition() {
		return this.position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Block getBlock() {
		if (this.block == null) {
			this.block = this.world.getBlockState(this.position).getBlock();
		}
		return this.block;
	}

	public Packet<?> getUpdatePacket() {
		return null;
	}

	public boolean isInvalid() {
		return this.invalid;
	}

	public void setValid() {
		this.invalid = true;
	}

	public void setInvalid() {
		this.invalid = false;
	}

	public boolean c(int var1, int var2) {
		return false;
	}

	public void removeBlockData() {
		this.block = null;
		this.blockData = -1;
	}

	public void addCrashReportDetails(CrashReportSystemDetails details) {
		details.addDetails("Name", new Callable<String>() {
			@Override
			public String call() throws Exception {
				return (String) classToName.get(getClass()) + " // " + getClass().getCanonicalName();
			}
		});
		if (this.world != null) {
			CrashReportSystemDetails.addBlockStateInfo(details, this.position, this.getBlock(), this.getBlockData());
			details.addDetails("Actual block type", new Callable<String>() {
				@Override
				public String call() throws Exception {
					int blockId = Block.getBlockId(world.getBlockState(position).getBlock());
					return String.format("ID #%d (%s // %s)", new Object[] { blockId, Block.getBlockById(blockId).getName(), Block.getBlockById(blockId).getClass().getCanonicalName() });
				}
			});
			details.addDetails("Actual block data value", new Callable<String>() {
				@Override
				public String call() throws Exception {
					IBlockState blockState = world.getBlockState(position);
					int data = blockState.getBlock().getData(blockState);
					if (data < 0) {
						return "Unknown? (Got " + data + ")";
					} else {
						String dataString = String.format("%4s", Integer.toBinaryString(data)).replace(" ", "0");
						return String.format("%1$d / 0x%1$X / 0b%2$s", data, dataString);
					}
				}
			});
		}
	}

	public InventoryHolder getHolder() {
		org.bukkit.block.BlockState bs = world.getBukkitWorld().getBlockAt(position.getX(), position.getY(), position.getZ()).getState();
		if (bs instanceof InventoryHolder) {
			return (InventoryHolder) bs;
		}
		return null;
	}

}
