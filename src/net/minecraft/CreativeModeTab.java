package net.minecraft;

public abstract class CreativeModeTab {

	public static final CreativeModeTab[] tabs = new CreativeModeTab[12];
	public static final CreativeModeTab BUILDING_BLOCKS = new akg(0, "buildingBlocks");
	public static final CreativeModeTab DECORATIONS = new akk(1, "decorations");
	public static final CreativeModeTab REDSTONE = new akl(2, "redstone");
	public static final CreativeModeTab TRANSPORTATION = new akm(3, "transportation");
	public static final CreativeModeTab MISC = (new akn(4, "misc"));
	public static final CreativeModeTab SEARCH = (new ako(5, "search"));
	public static final CreativeModeTab FOOD = new akp(6, "food");
	public static final CreativeModeTab TOOLS = (new akq(7, "tools"));
	public static final CreativeModeTab COMBAT = (new akr(8, "combat"));
	public static final CreativeModeTab BREWING = new akh(9, "brewing");
	public static final CreativeModeTab MATERIALS = new aki(10, "materials");
	public static final CreativeModeTab INVENTORY = (new akj(11, "inventory"));

	public CreativeModeTab(int id, String name) {
		tabs[id] = this;
	}

}
