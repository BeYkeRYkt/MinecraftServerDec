package net.minecraft;

import java.util.Random;

public class avt extends Block {

	public static boolean M;

	public avt() {
		super(Material.SAND);
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public avt(Material var1) {
		super(var1);
	}

	public void c(World var1, Position var2, bec var3) {
		var1.a(var2, (Block) this, this.a(var1));
	}

	public void a(World var1, Position var2, bec var3, Block var4) {
		var1.a(var2, (Block) this, this.a(var1));
	}

	public void b(World var1, Position var2, bec var3, Random var4) {
		if (!var1.D) {
			this.e(var1, var2);
		}

	}

	private void e(World var1, Position var2) {
		if (d(var1, var2.b()) && var2.getY() >= 0) {
			byte var3 = 32;
			if (!M && var1.a(var2.a(-var3, -var3, -var3), var2.a(var3, var3, var3))) {
				if (!var1.D) {
					EntityFallingBlock var5 = new EntityFallingBlock(var1, (double) var2.getX() + 0.5D, (double) var2.getY(), (double) var2.getZ() + 0.5D, var1.p(var2));
					this.a(var5);
					var1.d((Entity) var5);
				}
			} else {
				var1.g(var2);

				Position var4;
				for (var4 = var2.b(); d(var1, var4) && var4.getY() > 0; var4 = var4.b()) {
					;
				}

				if (var4.getY() > 0) {
					var1.a(var4.a(), this.P());
				}
			}

		}
	}

	protected void a(EntityFallingBlock var1) {
	}

	public int a(World var1) {
		return 2;
	}

	public static boolean d(World var0, Position var1) {
		Block var2 = var0.p(var1).getBlock();
		Material var3 = var2.material;
		return var2 == Blocks.ab || var3 == Material.AIR || var3 == Material.WATER || var3 == Material.LAVA;
	}

	public void a_(World var1, Position var2) {
	}
}
