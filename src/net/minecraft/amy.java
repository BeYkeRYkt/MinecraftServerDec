package net.minecraft;

import com.google.common.collect.Maps;
import java.util.Map;

public class amy extends Item {

	private static final Map b = Maps.newHashMap();
	public final String a;

	protected amy(String var1) {
		this.a = var1;
		this.maxStackSize = 1;
		this.a(CreativeModeTab.f);
		b.put("records." + var1, this);
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, PaintingDirection var5, float var6, float var7, float var8) {
		bec var9 = var3.p(var4);
		if (var9.c() == aty.aN && !((Boolean) var9.b(axc.a)).booleanValue()) {
			if (var3.D) {
				return true;
			} else {
				((axc) aty.aN).a(var3, var4, var9, var1);
				var3.a((EntityHuman) null, 1005, var4, Item.getId((Item) this));
				--var1.b;
				return true;
			}
		} else {
			return false;
		}
	}

	public amx g(ItemStack var1) {
		return amx.c;
	}

}
