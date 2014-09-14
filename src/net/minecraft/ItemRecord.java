package net.minecraft;

import com.google.common.collect.Maps;
import java.util.Map;

public class ItemRecord extends Item {

	private static final Map b = Maps.newHashMap();
	public final String a;

	protected ItemRecord(String var1) {
		this.a = var1;
		this.maxStackSize = 1;
		this.setCreativeModeTab(CreativeModeTab.MISC);
		b.put("records." + var1, this);
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, BlockFace var5, float var6, float var7, float var8) {
		IBlockState var9 = var3.getBlockState(var4);
		if (var9.getBlock() == Blocks.JUKEBOX && !((Boolean) var9.b(BlockJukeBox.a)).booleanValue()) {
			if (var3.isStatic) {
				return true;
			} else {
				((BlockJukeBox) Blocks.JUKEBOX).a(var3, var4, var9, var1);
				var3.a((EntityHuman) null, 1005, var4, Item.getId((Item) this));
				--var1.amount;
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
