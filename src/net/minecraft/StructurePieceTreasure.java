package net.minecraft;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class StructurePieceTreasure extends vk {

	private ItemStack b;
	private int c;
	private int d;

	public StructurePieceTreasure(Item var1, int var2, int var3, int var4, int var5) {
		super(var5);
		this.b = new ItemStack(var1, 1, var2);
		this.c = var3;
		this.d = var4;
	}

	public StructurePieceTreasure(ItemStack var1, int var2, int var3, int var4) {
		super(var4);
		this.b = var1;
		this.c = var2;
		this.d = var3;
	}

	public static void a(Random var0, List var1, IInventory var2, int var3) {
		for (int var4 = 0; var4 < var3; ++var4) {
			StructurePieceTreasure var5 = (StructurePieceTreasure) WeightedRandom.a(var0, var1);
			int var6 = var5.c + var0.nextInt(var5.d - var5.c + 1);
			if (var5.b.getMaxStackSize() >= var6) {
				ItemStack var7 = var5.b.getCopy();
				var7.amount = var6;
				var2.setItem(var0.nextInt(var2.getSize()), var7);
			} else {
				for (int var9 = 0; var9 < var6; ++var9) {
					ItemStack var8 = var5.b.getCopy();
					var8.amount = 1;
					var2.setItem(var0.nextInt(var2.getSize()), var8);
				}
			}
		}

	}

	public static void a(Random var0, List var1, TileEntityDispenser var2, int var3) {
		for (int var4 = 0; var4 < var3; ++var4) {
			StructurePieceTreasure var5 = (StructurePieceTreasure) WeightedRandom.a(var0, var1);
			int var6 = var5.c + var0.nextInt(var5.d - var5.c + 1);
			if (var5.b.getMaxStackSize() >= var6) {
				ItemStack var7 = var5.b.getCopy();
				var7.amount = var6;
				var2.setItem(var0.nextInt(var2.getSize()), var7);
			} else {
				for (int var9 = 0; var9 < var6; ++var9) {
					ItemStack var8 = var5.b.getCopy();
					var8.amount = 1;
					var2.setItem(var0.nextInt(var2.getSize()), var8);
				}
			}
		}

	}

	public static List a(List var0, StructurePieceTreasure... var1) {
		ArrayList var2 = Lists.newArrayList((Iterable) var0);
		Collections.addAll(var2, var1);
		return var2;
	}
}
