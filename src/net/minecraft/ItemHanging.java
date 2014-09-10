package net.minecraft;

public class ItemHanging extends Item {

	private final Class a;

	public ItemHanging(Class var1) {
		this.a = var1;
		this.setCreativeModeTab(CreativeModeTab.DECORATIONS);
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, BlockFace var5, float var6, float var7, float var8) {
		if (var5 == BlockFace.DOWN) {
			return false;
		} else if (var5 == BlockFace.UP) {
			return false;
		} else {
			Position var9 = var4.a(var5);
			if (!var2.a(var9, var5, var1)) {
				return false;
			} else {
				adj var10 = this.a(var3, var9, var5);
				if (var10 != null && var10.j()) {
					if (!var3.isStatic) {
						var3.d((Entity) var10);
					}

					--var1.amount;
				}

				return true;
			}
		}
	}

	private adj a(World var1, Position var2, BlockFace var3) {
		return (adj) (this.a == EntityPainting.class ? new EntityPainting(var1, var2, var3) : (this.a == EntityItemFrame.class ? new EntityItemFrame(var1, var2, var3) : null));
	}
}
