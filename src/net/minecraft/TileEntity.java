package net.minecraft;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.Callable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
	
	protected World world;
	protected Position position;
	protected boolean d;
	private int h;
	protected Block e;

	public TileEntity() {
		this.position = Position.ZERO;
		this.h = -1;
	}

	public World getPrimaryWorld() {
		return this.world;
	}

	public void a(World var1) {
		this.world = var1;
	}

	public boolean t() {
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

	public int u() {
		if (this.h == -1) {
			BlockState var1 = this.world.getBlockState(this.position);
			this.h = var1.getBlock().c(var1);
		}

		return this.h;
	}

	public void update() {
		if (this.world != null) {
			BlockState var1 = this.world.getBlockState(this.position);
			this.h = var1.getBlock().c(var1);
			this.world.b(this.position, this);
			if (this.getBlock() != Blocks.AIR) {
				this.world.e(this.position, this.getBlock());
			}
		}

	}

	public Position v() {
		return this.position;
	}

	public Block getBlock() {
		if (this.e == null) {
			this.e = this.world.getBlockState(this.position).getBlock();
		}

		return this.e;
	}

	public Packet<?> getUpdatePacket() {
		return null;
	}

	public boolean x() {
		return this.d;
	}

	public void y() {
		this.d = true;
	}

	public void D() {
		this.d = false;
	}

	public boolean c(int var1, int var2) {
		return false;
	}

	public void E() {
		this.e = null;
		this.h = -1;
	}

	public void a(CrashReportSystemDetails var1) {
		var1.addDetails("Name", new Callable<String>() {
			@Override
			public String call() throws Exception {
				return (String) classToName.get(getClass()) + " // " + getClass().getCanonicalName();
			}
		});
		if (this.world != null) {
			CrashReportSystemDetails.a(var1, this.position, this.getBlock(), this.u());
			var1.addDetails("Actual block type", (Callable<?>) (new bco(this)));
			var1.addDetails("Actual block data value", (Callable<?>) (new bcp(this)));
		}
	}

	public void a(Position var1) {
		this.position = var1;
	}

}
