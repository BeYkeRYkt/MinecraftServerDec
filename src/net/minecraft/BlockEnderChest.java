package net.minecraft;

import com.google.common.base.Predicate;
import java.util.Random;

public class BlockEnderChest extends atg {

	public static final beu a = beu.a("facing", (Predicate) en.a);

	protected BlockEnderChest() {
		super(Material.STONE);
		this.j(this.L.b().a(a, BlockFace.NORTH));
		this.a(CreativeModeTab.DECORATIONS);
		this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
	}

	public boolean c() {
		return false;
	}

	public boolean d() {
		return false;
	}

	public int b() {
		return 2;
	}

	public Item a(bec var1, Random var2, int var3) {
		return Item.getItemOf(Blocks.OBSIDIAN);
	}

	public int a(Random var1) {
		return 8;
	}

	protected boolean G() {
		return true;
	}

	public bec a(World var1, Position var2, BlockFace var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		return this.P().a(a, var8.aO().getOpposite());
	}

	public void a(World var1, Position var2, bec var3, EntityLiving var4, ItemStack var5) {
		var1.a(var2, var3.a(a, var4.aO().getOpposite()), 2);
	}

	public boolean a(World var1, Position var2, bec var3, EntityHuman var4, BlockFace var5, float var6, float var7, float var8) {
		InventoryEnderChest var9 = var4.cn();
		TileEntity var10 = var1.s(var2);
		if (var9 != null && var10 instanceof TileEntityEnderChest) {
			if (var1.p(var2.a()).getBlock().t()) {
				return true;
			} else if (var1.D) {
				return true;
			} else {
				var9.a((TileEntityEnderChest) var10);
				var4.a((IInventory) var9);
				return true;
			}
		} else {
			return true;
		}
	}

	public TileEntity a(World var1, int var2) {
		return new TileEntityEnderChest();
	}

	public bec a(int var1) {
		BlockFace var2 = BlockFace.getById(var1);
		if (var2.k() == el.b) {
			var2 = BlockFace.NORTH;
		}

		return this.P().a(a, var2);
	}

	public int c(bec var1) {
		return ((BlockFace) var1.b(a)).getId();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
