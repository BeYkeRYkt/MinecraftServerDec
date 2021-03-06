package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ItemPotion extends Item {

	private Map a = Maps.newHashMap();
	private static final Map b = Maps.newLinkedHashMap();

	public ItemPotion() {
		this.setMaxStackSize(1);
		this.a(true);
		this.setDurability(0);
		this.setCreativeModeTab(CreativeModeTab.BREWING);
	}

	public List h(ItemStack var1) {
		if (var1.hasTag() && var1.getTag().isTagAssignableFrom("CustomPotionEffects", 9)) {
			ArrayList var7 = Lists.newArrayList();
			NBTListTag var3 = var1.getTag().getList("CustomPotionEffects", 10);

			for (int var4 = 0; var4 < var3.getSize(); ++var4) {
				NBTCompoundTag var5 = var3.getCompound(var4);
				MobEffect var6 = MobEffect.load(var5);
				if (var6 != null) {
					var7.add(var6);
				}
			}

			return var7;
		} else {
			List var2 = (List) this.a.get(Integer.valueOf(var1.getWearout()));
			if (var2 == null) {
				var2 = PotionBrewer.b(var1.getWearout(), false);
				this.a.put(Integer.valueOf(var1.getWearout()), var2);
			}

			return var2;
		}
	}

	public List e(int var1) {
		List var2 = (List) this.a.get(Integer.valueOf(var1));
		if (var2 == null) {
			var2 = PotionBrewer.b(var1, false);
			this.a.put(Integer.valueOf(var1), var2);
		}

		return var2;
	}

	public ItemStack b(ItemStack var1, World var2, EntityHuman var3) {
		if (!var3.playerProperties.instabuild) {
			--var1.amount;
		}

		if (!var2.isStatic) {
			List var4 = this.h(var1);
			if (var4 != null) {
				Iterator var5 = var4.iterator();

				while (var5.hasNext()) {
					MobEffect var6 = (MobEffect) var5.next();
					var3.c(new MobEffect(var6));
				}
			}
		}

		var3.b(StatisticList.USE_ITEM_COUNT[Item.getId((Item) this)]);
		if (!var3.playerProperties.instabuild) {
			if (var1.amount <= 0) {
				return new ItemStack(Items.GLASS_BOTTLE);
			}

			var3.playerInventory.pickup(new ItemStack(Items.GLASS_BOTTLE));
		}

		return var1;
	}

	public int d(ItemStack var1) {
		return 32;
	}

	public EnumAnimation e(ItemStack var1) {
		return EnumAnimation.DRINK;
	}

	public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
		if (f(var1.getWearout())) {
			if (!var3.playerProperties.instabuild) {
				--var1.amount;
			}

			var2.a((Entity) var3, "random.bow", 0.5F, 0.4F / (rnd.nextFloat() * 0.4F + 0.8F));
			if (!var2.isStatic) {
				var2.addEntity((Entity) (new EntityPotion(var2, var3, var1)));
			}

			var3.b(StatisticList.USE_ITEM_COUNT[Item.getId((Item) this)]);
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
		if (var1.getWearout() == 0) {
			return LocaleI18n.get("item.emptyPotion.name").trim();
		} else {
			String var2 = "";
			if (f(var1.getWearout())) {
				var2 = LocaleI18n.get("potion.prefix.grenade").trim() + " ";
			}

			List var3 = Items.POTION.h(var1);
			String var4;
			if (var3 != null && !var3.isEmpty()) {
				var4 = ((MobEffect) var3.get(0)).getName();
				var4 = var4 + ".postfix";
				return var2 + LocaleI18n.get(var4).trim();
			} else {
				var4 = PotionBrewer.c(var1.getWearout());
				return LocaleI18n.get(var4).trim() + " " + super.a(var1);
			}
		}
	}

}
