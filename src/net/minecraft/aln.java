package net.minecraft;

public class aln extends Item {

	private final Class a;

	public aln(Class var1) {
		this.a = var1;
		this.a(CreativeModeTab.c);
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, ej var5, float var6, float var7, float var8) {
		if (var5 == ej.a) {
			return false;
		} else if (var5 == ej.b) {
			return false;
		} else {
			Position var9 = var4.a(var5);
			if (!var2.a(var9, var5, var1)) {
				return false;
			} else {
				adj var10 = this.a(var3, var9, var5);
				if (var10 != null && var10.j()) {
					if (!var3.D) {
						var3.d((Entity) var10);
					}

					--var1.b;
				}

				return true;
			}
		}
	}

	private adj a(World var1, Position var2, ej var3) {
		return (adj) (this.a == adm.class ? new adm(var1, var2, var3) : (this.a == adk.class ? new adk(var1, var2, var3) : null));
	}
}
