package net.minecraft;

public abstract class CreativeModeTab {

	public static final CreativeModeTab[] tabs = new CreativeModeTab[12];
	public static final CreativeModeTab BUILDING_BLOCKS = new CreativeModeTab1(0, "buildingBlocks");
	public static final CreativeModeTab DECORATIONS = new CreativeModeTab2(1, "decorations");
	public static final CreativeModeTab REDSTONE = new CreativeModeTab3(2, "redstone");
	public static final CreativeModeTab TRANSPORTATION = new CreativeModeTab4(3, "transportation");
	public static final CreativeModeTab MISC = new CreativeModeTab5(4, "misc");
	public static final CreativeModeTab SEARCH = new CreativeModeTab6(5, "search");
	public static final CreativeModeTab FOOD = new CreativeModeTab7(6, "food");
	public static final CreativeModeTab TOOLS = new CreativeModeTab8(7, "tools");
	public static final CreativeModeTab COMBAT = new CreativeModeTab9(8, "combat");
	public static final CreativeModeTab BREWING = new CreativeModeTab10(9, "brewing");
	public static final CreativeModeTab MATERIALS = new CreativeModeTab11(10, "materials");
	public static final CreativeModeTab INVENTORY = new CreativeModeTab12(11, "inventory");

	public CreativeModeTab(int id, String name) {
		tabs[id] = this;
	}

}
