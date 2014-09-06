package net.minecraft;

public class BlockWood extends Block {

	public static final bev a = bev.a("variant", ayx.class);

	public BlockWood() {
		super(Material.WOOD);
		this.j(this.L.b().a(a, ayx.a));
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public int a(bec var1) {
		return ((ayx) var1.b(a)).a();
	}

	public bec a(int var1) {
		return this.P().a(a, ayx.a(var1));
	}

	public int c(bec var1) {
		return ((ayx) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
