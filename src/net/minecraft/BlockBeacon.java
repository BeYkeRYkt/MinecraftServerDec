package net.minecraft;

public class BlockBeacon extends atg {

	public BlockBeacon() {
		super(Material.SHATTERABLE);
		this.c(3.0F);
		this.a(CreativeModeTab.f);
	}

	public bcm a(World var1, int var2) {
		return new bck();
	}

	public boolean a(World var1, Position var2, bec var3, EntityHuman var4, PaintingDirection var5, float var6, float var7, float var8) {
		if (var1.D) {
			return true;
		} else {
			bcm var9 = var1.s(var2);
			if (var9 instanceof bck) {
				var4.a((IInventory) ((bck) var9));
			}

			return true;
		}
	}

	public boolean c() {
		return false;
	}

	public boolean d() {
		return false;
	}

	public int b() {
		return 3;
	}

	public void a(World var1, Position var2, bec var3, EntityLiving var4, ItemStack var5) {
		super.a(var1, var2, var3, var4, var5);
		if (var5.s()) {
			bcm var6 = var1.s(var2);
			if (var6 instanceof bck) {
				((bck) var6).a(var5.q());
			}
		}

	}

	public void a(World var1, Position var2, bec var3, Block var4) {
		bcm var5 = var1.s(var2);
		if (var5 instanceof bck) {
			((bck) var5).m();
			var1.c(var2, this, 1, 0);
		}

	}

	public static void d(World var0, Position var1) {
		ui.a.submit((Runnable) (new atn(var0, var1)));
	}
}