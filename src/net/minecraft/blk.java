package net.minecraft;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class blk extends bln {

	private boolean[] e = new boolean[4];
	private static final List f = Lists.newArrayList((Object[]) (new vl[] { new vl(Items.DIAMOND, 0, 1, 3, 3), new vl(Items.IRON_INGOT, 0, 1, 5, 10), new vl(Items.GOLD_INGOT, 0, 2, 7, 15), new vl(Items.EMERALD, 0, 1, 3, 2), new vl(Items.BONE, 0, 4, 6, 20), new vl(Items.ROTTEN_FLESH, 0, 3, 7, 16), new vl(Items.SADDLE, 0, 1, 1, 3), new vl(Items.IRON_HORSE_ARMOR, 0, 1, 1, 1), new vl(Items.GOLDEN_HORSE_ARMOR, 0, 1, 1, 1), new vl(Items.DIAMOND_HORSE_ARMOR, 0, 1, 1, 1) }));

	public blk() {
	}

	public blk(Random var1, int var2, int var3) {
		super(var1, var2, 64, var3, 21, 15, 21);
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		var1.put("hasPlacedChest0", this.e[0]);
		var1.put("hasPlacedChest1", this.e[1]);
		var1.put("hasPlacedChest2", this.e[2]);
		var1.put("hasPlacedChest3", this.e[3]);
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		this.e[0] = var1.getBoolean("hasPlacedChest0");
		this.e[1] = var1.getBoolean("hasPlacedChest1");
		this.e[2] = var1.getBoolean("hasPlacedChest2");
		this.e[3] = var1.getBoolean("hasPlacedChest3");
	}

	public boolean a(World var1, Random var2, bjb var3) {
		this.a(var1, var3, 0, -4, 0, this.a - 1, 0, this.c - 1, Blocks.SANDSTONE.P(), Blocks.SANDSTONE.P(), false);

		int var4;
		for (var4 = 1; var4 <= 9; ++var4) {
			this.a(var1, var3, var4, var4, var4, this.a - 1 - var4, var4, this.c - 1 - var4, Blocks.SANDSTONE.P(), Blocks.SANDSTONE.P(), false);
			this.a(var1, var3, var4 + 1, var4, var4 + 1, this.a - 2 - var4, var4, this.c - 2 - var4, Blocks.AIR.P(), Blocks.AIR.P(), false);
		}

		int var5;
		for (var4 = 0; var4 < this.a; ++var4) {
			for (var5 = 0; var5 < this.c; ++var5) {
				byte var6 = -5;
				this.b(var1, Blocks.SANDSTONE.P(), var4, var6, var5, var3);
			}
		}

		var4 = this.a(Blocks.SANDSTONE_STAIRS, 3);
		var5 = this.a(Blocks.SANDSTONE_STAIRS, 2);
		int var14 = this.a(Blocks.SANDSTONE_STAIRS, 0);
		int var7 = this.a(Blocks.SANDSTONE_STAIRS, 1);
		int var8 = ~akv.b.b() & 15;
		int var9 = ~akv.l.b() & 15;
		this.a(var1, var3, 0, 0, 0, 4, 9, 4, Blocks.SANDSTONE.P(), Blocks.AIR.P(), false);
		this.a(var1, var3, 1, 10, 1, 3, 10, 3, Blocks.SANDSTONE.P(), Blocks.SANDSTONE.P(), false);
		this.a(var1, Blocks.SANDSTONE_STAIRS.a(var4), 2, 10, 0, var3);
		this.a(var1, Blocks.SANDSTONE_STAIRS.a(var5), 2, 10, 4, var3);
		this.a(var1, Blocks.SANDSTONE_STAIRS.a(var14), 0, 10, 2, var3);
		this.a(var1, Blocks.SANDSTONE_STAIRS.a(var7), 4, 10, 2, var3);
		this.a(var1, var3, this.a - 5, 0, 0, this.a - 1, 9, 4, Blocks.SANDSTONE.P(), Blocks.AIR.P(), false);
		this.a(var1, var3, this.a - 4, 10, 1, this.a - 2, 10, 3, Blocks.SANDSTONE.P(), Blocks.SANDSTONE.P(), false);
		this.a(var1, Blocks.SANDSTONE_STAIRS.a(var4), this.a - 3, 10, 0, var3);
		this.a(var1, Blocks.SANDSTONE_STAIRS.a(var5), this.a - 3, 10, 4, var3);
		this.a(var1, Blocks.SANDSTONE_STAIRS.a(var14), this.a - 5, 10, 2, var3);
		this.a(var1, Blocks.SANDSTONE_STAIRS.a(var7), this.a - 1, 10, 2, var3);
		this.a(var1, var3, 8, 0, 0, 12, 4, 4, Blocks.SANDSTONE.P(), Blocks.AIR.P(), false);
		this.a(var1, var3, 9, 1, 0, 11, 3, 4, Blocks.AIR.P(), Blocks.AIR.P(), false);
		this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), 9, 1, 1, var3);
		this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), 9, 2, 1, var3);
		this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), 9, 3, 1, var3);
		this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), 10, 3, 1, var3);
		this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), 11, 3, 1, var3);
		this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), 11, 2, 1, var3);
		this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), 11, 1, 1, var3);
		this.a(var1, var3, 4, 1, 1, 8, 3, 3, Blocks.SANDSTONE.P(), Blocks.AIR.P(), false);
		this.a(var1, var3, 4, 1, 2, 8, 2, 2, Blocks.AIR.P(), Blocks.AIR.P(), false);
		this.a(var1, var3, 12, 1, 1, 16, 3, 3, Blocks.SANDSTONE.P(), Blocks.AIR.P(), false);
		this.a(var1, var3, 12, 1, 2, 16, 2, 2, Blocks.AIR.P(), Blocks.AIR.P(), false);
		this.a(var1, var3, 5, 4, 5, this.a - 6, 4, this.c - 6, Blocks.SANDSTONE.P(), Blocks.SANDSTONE.P(), false);
		this.a(var1, var3, 9, 4, 9, 11, 4, 11, Blocks.AIR.P(), Blocks.AIR.P(), false);
		this.a(var1, var3, 8, 1, 8, 8, 3, 8, Blocks.SANDSTONE.a(bae.c.a()), Blocks.SANDSTONE.a(bae.c.a()), false);
		this.a(var1, var3, 12, 1, 8, 12, 3, 8, Blocks.SANDSTONE.a(bae.c.a()), Blocks.SANDSTONE.a(bae.c.a()), false);
		this.a(var1, var3, 8, 1, 12, 8, 3, 12, Blocks.SANDSTONE.a(bae.c.a()), Blocks.SANDSTONE.a(bae.c.a()), false);
		this.a(var1, var3, 12, 1, 12, 12, 3, 12, Blocks.SANDSTONE.a(bae.c.a()), Blocks.SANDSTONE.a(bae.c.a()), false);
		this.a(var1, var3, 1, 1, 5, 4, 4, 11, Blocks.SANDSTONE.P(), Blocks.SANDSTONE.P(), false);
		this.a(var1, var3, this.a - 5, 1, 5, this.a - 2, 4, 11, Blocks.SANDSTONE.P(), Blocks.SANDSTONE.P(), false);
		this.a(var1, var3, 6, 7, 9, 6, 7, 11, Blocks.SANDSTONE.P(), Blocks.SANDSTONE.P(), false);
		this.a(var1, var3, this.a - 7, 7, 9, this.a - 7, 7, 11, Blocks.SANDSTONE.P(), Blocks.SANDSTONE.P(), false);
		this.a(var1, var3, 5, 5, 9, 5, 7, 11, Blocks.SANDSTONE.a(bae.c.a()), Blocks.SANDSTONE.a(bae.c.a()), false);
		this.a(var1, var3, this.a - 6, 5, 9, this.a - 6, 7, 11, Blocks.SANDSTONE.a(bae.c.a()), Blocks.SANDSTONE.a(bae.c.a()), false);
		this.a(var1, Blocks.AIR.P(), 5, 5, 10, var3);
		this.a(var1, Blocks.AIR.P(), 5, 6, 10, var3);
		this.a(var1, Blocks.AIR.P(), 6, 6, 10, var3);
		this.a(var1, Blocks.AIR.P(), this.a - 6, 5, 10, var3);
		this.a(var1, Blocks.AIR.P(), this.a - 6, 6, 10, var3);
		this.a(var1, Blocks.AIR.P(), this.a - 7, 6, 10, var3);
		this.a(var1, var3, 2, 4, 4, 2, 6, 4, Blocks.AIR.P(), Blocks.AIR.P(), false);
		this.a(var1, var3, this.a - 3, 4, 4, this.a - 3, 6, 4, Blocks.AIR.P(), Blocks.AIR.P(), false);
		this.a(var1, Blocks.SANDSTONE_STAIRS.a(var4), 2, 4, 5, var3);
		this.a(var1, Blocks.SANDSTONE_STAIRS.a(var4), 2, 3, 4, var3);
		this.a(var1, Blocks.SANDSTONE_STAIRS.a(var4), this.a - 3, 4, 5, var3);
		this.a(var1, Blocks.SANDSTONE_STAIRS.a(var4), this.a - 3, 3, 4, var3);
		this.a(var1, var3, 1, 1, 3, 2, 2, 3, Blocks.SANDSTONE.P(), Blocks.SANDSTONE.P(), false);
		this.a(var1, var3, this.a - 3, 1, 3, this.a - 2, 2, 3, Blocks.SANDSTONE.P(), Blocks.SANDSTONE.P(), false);
		this.a(var1, Blocks.SANDSTONE_STAIRS.P(), 1, 1, 2, var3);
		this.a(var1, Blocks.SANDSTONE_STAIRS.P(), this.a - 2, 1, 2, var3);
		this.a(var1, Blocks.STONE_SLAB.a(bbg.b.a()), 1, 2, 2, var3);
		this.a(var1, Blocks.STONE_SLAB.a(bbg.b.a()), this.a - 2, 2, 2, var3);
		this.a(var1, Blocks.SANDSTONE_STAIRS.a(var7), 2, 1, 2, var3);
		this.a(var1, Blocks.SANDSTONE_STAIRS.a(var14), this.a - 3, 1, 2, var3);
		this.a(var1, var3, 4, 3, 5, 4, 3, 18, Blocks.SANDSTONE.P(), Blocks.SANDSTONE.P(), false);
		this.a(var1, var3, this.a - 5, 3, 5, this.a - 5, 3, 17, Blocks.SANDSTONE.P(), Blocks.SANDSTONE.P(), false);
		this.a(var1, var3, 3, 1, 5, 4, 2, 16, Blocks.AIR.P(), Blocks.AIR.P(), false);
		this.a(var1, var3, this.a - 6, 1, 5, this.a - 5, 2, 16, Blocks.AIR.P(), Blocks.AIR.P(), false);

		int var10;
		for (var10 = 5; var10 <= 17; var10 += 2) {
			this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), 4, 1, var10, var3);
			this.a(var1, Blocks.SANDSTONE.a(bae.b.a()), 4, 2, var10, var3);
			this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), this.a - 5, 1, var10, var3);
			this.a(var1, Blocks.SANDSTONE.a(bae.b.a()), this.a - 5, 2, var10, var3);
		}

		this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), 10, 0, 7, var3);
		this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), 10, 0, 8, var3);
		this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), 9, 0, 9, var3);
		this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), 11, 0, 9, var3);
		this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), 8, 0, 10, var3);
		this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), 12, 0, 10, var3);
		this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), 7, 0, 10, var3);
		this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), 13, 0, 10, var3);
		this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), 9, 0, 11, var3);
		this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), 11, 0, 11, var3);
		this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), 10, 0, 12, var3);
		this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), 10, 0, 13, var3);
		this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var9), 10, 0, 10, var3);

		for (var10 = 0; var10 <= this.a - 1; var10 += this.a - 1) {
			this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), var10, 2, 1, var3);
			this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), var10, 2, 2, var3);
			this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), var10, 2, 3, var3);
			this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), var10, 3, 1, var3);
			this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), var10, 3, 2, var3);
			this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), var10, 3, 3, var3);
			this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), var10, 4, 1, var3);
			this.a(var1, Blocks.SANDSTONE.a(bae.b.a()), var10, 4, 2, var3);
			this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), var10, 4, 3, var3);
			this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), var10, 5, 1, var3);
			this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), var10, 5, 2, var3);
			this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), var10, 5, 3, var3);
			this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), var10, 6, 1, var3);
			this.a(var1, Blocks.SANDSTONE.a(bae.b.a()), var10, 6, 2, var3);
			this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), var10, 6, 3, var3);
			this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), var10, 7, 1, var3);
			this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), var10, 7, 2, var3);
			this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), var10, 7, 3, var3);
			this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), var10, 8, 1, var3);
			this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), var10, 8, 2, var3);
			this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), var10, 8, 3, var3);
		}

		for (var10 = 2; var10 <= this.a - 3; var10 += this.a - 3 - 2) {
			this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), var10 - 1, 2, 0, var3);
			this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), var10, 2, 0, var3);
			this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), var10 + 1, 2, 0, var3);
			this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), var10 - 1, 3, 0, var3);
			this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), var10, 3, 0, var3);
			this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), var10 + 1, 3, 0, var3);
			this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), var10 - 1, 4, 0, var3);
			this.a(var1, Blocks.SANDSTONE.a(bae.b.a()), var10, 4, 0, var3);
			this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), var10 + 1, 4, 0, var3);
			this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), var10 - 1, 5, 0, var3);
			this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), var10, 5, 0, var3);
			this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), var10 + 1, 5, 0, var3);
			this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), var10 - 1, 6, 0, var3);
			this.a(var1, Blocks.SANDSTONE.a(bae.b.a()), var10, 6, 0, var3);
			this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), var10 + 1, 6, 0, var3);
			this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), var10 - 1, 7, 0, var3);
			this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), var10, 7, 0, var3);
			this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), var10 + 1, 7, 0, var3);
			this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), var10 - 1, 8, 0, var3);
			this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), var10, 8, 0, var3);
			this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), var10 + 1, 8, 0, var3);
		}

		this.a(var1, var3, 8, 4, 0, 12, 6, 0, Blocks.SANDSTONE.a(bae.c.a()), Blocks.SANDSTONE.a(bae.c.a()), false);
		this.a(var1, Blocks.AIR.P(), 8, 6, 0, var3);
		this.a(var1, Blocks.AIR.P(), 12, 6, 0, var3);
		this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), 9, 5, 0, var3);
		this.a(var1, Blocks.SANDSTONE.a(bae.b.a()), 10, 5, 0, var3);
		this.a(var1, Blocks.STAINDED_HARDENED_CLAY.a(var8), 11, 5, 0, var3);
		this.a(var1, var3, 8, -14, 8, 12, -11, 12, Blocks.SANDSTONE.a(bae.c.a()), Blocks.SANDSTONE.a(bae.c.a()), false);
		this.a(var1, var3, 8, -10, 8, 12, -10, 12, Blocks.SANDSTONE.a(bae.b.a()), Blocks.SANDSTONE.a(bae.b.a()), false);
		this.a(var1, var3, 8, -9, 8, 12, -9, 12, Blocks.SANDSTONE.a(bae.c.a()), Blocks.SANDSTONE.a(bae.c.a()), false);
		this.a(var1, var3, 8, -8, 8, 12, -1, 12, Blocks.SANDSTONE.P(), Blocks.SANDSTONE.P(), false);
		this.a(var1, var3, 9, -11, 9, 11, -1, 11, Blocks.AIR.P(), Blocks.AIR.P(), false);
		this.a(var1, Blocks.STONE_PRESSURE_PLATE.P(), 10, -11, 10, var3);
		this.a(var1, var3, 9, -13, 9, 11, -13, 11, Blocks.TNT.P(), Blocks.AIR.P(), false);
		this.a(var1, Blocks.AIR.P(), 8, -11, 10, var3);
		this.a(var1, Blocks.AIR.P(), 8, -10, 10, var3);
		this.a(var1, Blocks.SANDSTONE.a(bae.b.a()), 7, -10, 10, var3);
		this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), 7, -11, 10, var3);
		this.a(var1, Blocks.AIR.P(), 12, -11, 10, var3);
		this.a(var1, Blocks.AIR.P(), 12, -10, 10, var3);
		this.a(var1, Blocks.SANDSTONE.a(bae.b.a()), 13, -10, 10, var3);
		this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), 13, -11, 10, var3);
		this.a(var1, Blocks.AIR.P(), 10, -11, 8, var3);
		this.a(var1, Blocks.AIR.P(), 10, -10, 8, var3);
		this.a(var1, Blocks.SANDSTONE.a(bae.b.a()), 10, -10, 7, var3);
		this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), 10, -11, 7, var3);
		this.a(var1, Blocks.AIR.P(), 10, -11, 12, var3);
		this.a(var1, Blocks.AIR.P(), 10, -10, 12, var3);
		this.a(var1, Blocks.SANDSTONE.a(bae.b.a()), 10, -10, 13, var3);
		this.a(var1, Blocks.SANDSTONE.a(bae.c.a()), 10, -11, 13, var3);
		Iterator var15 = en.a.iterator();

		while (var15.hasNext()) {
			BlockFace var11 = (BlockFace) var15.next();
			if (!this.e[var11.toByte()]) {
				int var12 = var11.g() * 2;
				int var13 = var11.i() * 2;
				this.e[var11.toByte()] = this.a(var1, var3, var2, 10 + var12, -11, 10 + var13, vl.a(f, new vl[] { Items.ENCHANTED_BOOK.b(var2) }), 2 + var2.nextInt(5));
			}
		}

		return true;
	}

}
