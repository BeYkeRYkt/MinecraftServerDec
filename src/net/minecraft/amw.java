package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class amw extends Item {

	private Map a = Maps.newHashMap();
	private static final Map b = Maps.newLinkedHashMap();

	public amw() {
		this.c(1);
		this.a(true);
		this.d(0);
		this.a(CreativeModeTab.k);
	}

	public List h(ItemStack var1) {
		if (var1.hasTag() && var1.getTag().isTagAssignableFrom("CustomPotionEffects", 9)) {
			ArrayList var7 = Lists.newArrayList();
			NBTListTag var3 = var1.getTag().getList("CustomPotionEffects", 10);

			for (int var4 = 0; var4 < var3.getSize(); ++var4) {
				NBTCompoundTag var5 = var3.getCompound(var4);
				wq var6 = wq.b(var5);
				if (var6 != null) {
					var7.add(var6);
				}
			}

			return var7;
		} else {
			List var2 = (List) this.a.get(Integer.valueOf(var1.i()));
			if (var2 == null) {
				var2 = ans.b(var1.i(), false);
				this.a.put(Integer.valueOf(var1.i()), var2);
			}

			return var2;
		}
	}

	public List e(int var1) {
		List var2 = (List) this.a.get(Integer.valueOf(var1));
		if (var2 == null) {
			var2 = ans.b(var1, false);
			this.a.put(Integer.valueOf(var1), var2);
		}

		return var2;
	}

	public ItemStack b(ItemStack var1, World var2, EntityHuman var3) {
		if (!var3.by.instabuild) {
			--var1.b;
		}

		if (!var2.D) {
			List var4 = this.h(var1);
			if (var4 != null) {
				Iterator var5 = var4.iterator();

				while (var5.hasNext()) {
					wq var6 = (wq) var5.next();
					var3.c(new wq(var6));
				}
			}
		}

		var3.b(ty.J[Item.getId((Item) this)]);
		if (!var3.by.instabuild) {
			if (var1.b <= 0) {
				return new ItemStack(amk.bA);
			}

			var3.playerInventory.a(new ItemStack(amk.bA));
		}

		return var1;
	}

	public int d(ItemStack var1) {
		return 32;
	}

	public ano e(ItemStack var1) {
		return ano.c;
	}

	public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
		if (f(var1.i())) {
			if (!var3.by.instabuild) {
				--var1.b;
			}

			var2.a((Entity) var3, "random.bow", 0.5F, 0.4F / (rnd.nextFloat() * 0.4F + 0.8F));
			if (!var2.D) {
				var2.d((Entity) (new ahv(var2, var3, var1)));
			}

			var3.b(ty.J[Item.getId((Item) this)]);
			return var1;
		} else {
			var3.a(var1, this.d(var1));
			return var1;
		}
	}

	public static boolean f(int var0) {
		return (var0 & 16384) != 0;
	}

	public String a(ItemStack var1) {
		if (var1.i() == 0) {
			return fi.a("item.emptyPotion.name").trim();
		} else {
			String var2 = "";
			if (f(var1.i())) {
				var2 = fi.a("potion.prefix.grenade").trim() + " ";
			}

			List var3 = amk.bz.h(var1);
			String var4;
			if (var3 != null && !var3.isEmpty()) {
				var4 = ((wq) var3.get(0)).g();
				var4 = var4 + ".postfix";
				return var2 + fi.a(var4).trim();
			} else {
				var4 = ans.c(var1.i());
				return fi.a(var4).trim() + " " + super.a(var1);
			}
		}
	}

}
