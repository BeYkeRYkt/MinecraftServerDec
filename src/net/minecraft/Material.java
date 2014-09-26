package net.minecraft;

public class Material {

	public static final Material AIR = new MaterialsGas(MaterialMapColor.b);
	public static final Material GRASS = new Material(MaterialMapColor.c);
	public static final Material EARTH = new Material(MaterialMapColor.l);
	public static final Material WOOD = (new Material(MaterialMapColor.o)).g();
	public static final Material STONE = (new Material(MaterialMapColor.m)).setDoesNotAlwaysDropItem();
	public static final Material ORE = (new Material(MaterialMapColor.h)).setDoesNotAlwaysDropItem();
	public static final Material HEAVY = (new Material(MaterialMapColor.h)).setDoesNotAlwaysDropItem().setBlockPushReaction();
	public static final Material WATER = (new MaterialLiquid(MaterialMapColor.n)).setBreakPushReaction();
	public static final Material LAVA = (new MaterialLiquid(MaterialMapColor.f)).setBreakPushReaction();
	public static final Material LEAVES = (new Material(MaterialMapColor.i)).g().s().setBreakPushReaction();
	public static final Material PLANT = (new MaterialDecoration(MaterialMapColor.i)).setBreakPushReaction();
	public static final Material REPLACEABLE_PLANT = (new MaterialDecoration(MaterialMapColor.i)).g().setBreakPushReaction().i();
	public static final Material SPONGE = new Material(MaterialMapColor.e);
	public static final Material CLOTH = (new Material(MaterialMapColor.e)).g();
	public static final Material FIRE = (new MaterialsGas(MaterialMapColor.b)).setBreakPushReaction();
	public static final Material SAND = new Material(MaterialMapColor.d);
	public static final Material ORIENTABLE = (new MaterialDecoration(MaterialMapColor.b)).setBreakPushReaction();
	public static final Material WOOL = (new MaterialDecoration(MaterialMapColor.e)).g();
	public static final Material SHATTERABLE = (new Material(MaterialMapColor.b)).s();
	public static final Material BUILDABLE_GLASS = (new Material(MaterialMapColor.b));
	public static final Material TNT = (new Material(MaterialMapColor.f)).g().s();
	public static final Material CORAL = (new Material(MaterialMapColor.i)).setBreakPushReaction();
	public static final Material ICE = (new Material(MaterialMapColor.g)).s();
	public static final Material SNOW_LAYER = (new Material(MaterialMapColor.g));
	public static final Material PACKED_ICE = (new MaterialDecoration(MaterialMapColor.j)).i().s().setDoesNotAlwaysDropItem().setBreakPushReaction();
	public static final Material SNOW_BLOCK = (new Material(MaterialMapColor.j)).setDoesNotAlwaysDropItem();
	public static final Material CACTUS = (new Material(MaterialMapColor.i)).s().setBreakPushReaction();
	public static final Material CLAY = new Material(MaterialMapColor.k);
	public static final Material PUMPKIN = (new Material(MaterialMapColor.i)).setBreakPushReaction();
	public static final Material DRAGON_EGG = (new Material(MaterialMapColor.i)).setBreakPushReaction();
	public static final Material PORTAL = (new MaterialPortal(MaterialMapColor.b)).setBlockPushReaction();
	public static final Material CAKE = (new Material(MaterialMapColor.b)).setBreakPushReaction();
	public static final Material WEB = (new MaterialWeb(MaterialMapColor.e)).setDoesNotAlwaysDropItem().setBreakPushReaction();
	public static final Material PISTON = (new Material(MaterialMapColor.m)).setBlockPushReaction();
	public static final Material BARRIER = (new Material(MaterialMapColor.b)).setDoesNotAlwaysDropItem().setBlockPushReaction();

	private boolean J;
	private boolean K;
	private boolean L;
	private final MaterialMapColor mapColor;
	private boolean alwaysDropsItems = true;
	private int pushReaction;

	public Material(MaterialMapColor mapColor) {
		this.mapColor = mapColor;
	}

	public boolean isLiquid() {
		return false;
	}

	public boolean isBuildable() {
		return true;
	}

	public boolean blocksLight() {
		return true;
	}

	public boolean isSolid() {
		return true;
	}

	private Material s() {
		this.L = true;
		return this;
	}

	protected Material setDoesNotAlwaysDropItem() {
		this.alwaysDropsItems = false;
		return this;
	}

	protected Material g() {
		this.J = true;
		return this;
	}

	public boolean h() {
		return this.J;
	}

	public Material i() {
		this.K = true;
		return this;
	}

	public boolean j() {
		return this.K;
	}

	public boolean k() {
		return this.L ? false : this.isSolid();
	}

	public boolean alwaysDropsItem() {
		return this.alwaysDropsItems;
	}

	public int getPushReaction() {
		return this.pushReaction;
	}

	protected Material setBreakPushReaction() {
		this.pushReaction = 1;
		return this;
	}

	protected Material setBlockPushReaction() {
		this.pushReaction = 2;
		return this;
	}

	public MaterialMapColor getMapColor() {
		return this.mapColor;
	}

}
