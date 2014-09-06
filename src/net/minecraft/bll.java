package net.minecraft;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;

public class bll extends bln {

	private boolean e;
	private boolean f;
	private boolean g;
	private boolean h;
	private static final List i = Lists.newArrayList((Object[]) (new vl[] { new vl(Items.i, 0, 1, 3, 3), new vl(Items.j, 0, 1, 5, 10), new vl(Items.k, 0, 2, 7, 15), new vl(Items.bO, 0, 1, 3, 2), new vl(Items.aX, 0, 4, 6, 20), new vl(Items.bt, 0, 3, 7, 16), new vl(Items.aA, 0, 1, 1, 3), new vl(Items.ck, 0, 1, 1, 1), new vl(Items.cl, 0, 1, 1, 1), new vl(Items.cm, 0, 1, 1, 1) }));
	private static final List j = Lists.newArrayList((Object[]) (new vl[] { new vl(Items.g, 0, 2, 7, 30) }));
	private static blm k = new blm((blj) null);

	public bll() {
	}

	public bll(Random var1, int var2, int var3) {
		super(var1, var2, 64, var3, 12, 10, 15);
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		var1.put("placedMainChest", this.e);
		var1.put("placedHiddenChest", this.f);
		var1.put("placedTrap1", this.g);
		var1.put("placedTrap2", this.h);
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		this.e = var1.getBoolean("placedMainChest");
		this.f = var1.getBoolean("placedHiddenChest");
		this.g = var1.getBoolean("placedTrap1");
		this.h = var1.getBoolean("placedTrap2");
	}

	public boolean a(World var1, Random var2, bjb var3) {
		if (!this.a(var1, var3, 0)) {
			return false;
		} else {
			int var4 = this.a(Blocks.aw, 3);
			int var5 = this.a(Blocks.aw, 2);
			int var6 = this.a(Blocks.aw, 0);
			int var7 = this.a(Blocks.aw, 1);
			this.a(var1, var3, 0, -4, 0, this.a - 1, 0, this.c - 1, false, var2, k);
			this.a(var1, var3, 2, 1, 2, 9, 2, 2, false, var2, k);
			this.a(var1, var3, 2, 1, 12, 9, 2, 12, false, var2, k);
			this.a(var1, var3, 2, 1, 3, 2, 2, 11, false, var2, k);
			this.a(var1, var3, 9, 1, 3, 9, 2, 11, false, var2, k);
			this.a(var1, var3, 1, 3, 1, 10, 6, 1, false, var2, k);
			this.a(var1, var3, 1, 3, 13, 10, 6, 13, false, var2, k);
			this.a(var1, var3, 1, 3, 2, 1, 6, 12, false, var2, k);
			this.a(var1, var3, 10, 3, 2, 10, 6, 12, false, var2, k);
			this.a(var1, var3, 2, 3, 2, 9, 3, 12, false, var2, k);
			this.a(var1, var3, 2, 6, 2, 9, 6, 12, false, var2, k);
			this.a(var1, var3, 3, 7, 3, 8, 7, 11, false, var2, k);
			this.a(var1, var3, 4, 8, 4, 7, 8, 10, false, var2, k);
			this.a(var1, var3, 3, 1, 3, 8, 2, 11);
			this.a(var1, var3, 4, 3, 6, 7, 3, 9);
			this.a(var1, var3, 2, 4, 2, 9, 5, 12);
			this.a(var1, var3, 4, 6, 5, 7, 6, 9);
			this.a(var1, var3, 5, 7, 6, 6, 7, 8);
			this.a(var1, var3, 5, 1, 2, 6, 2, 2);
			this.a(var1, var3, 5, 2, 12, 6, 2, 12);
			this.a(var1, var3, 5, 5, 1, 6, 5, 1);
			this.a(var1, var3, 5, 5, 13, 6, 5, 13);
			this.a(var1, Blocks.AIR.P(), 1, 5, 5, var3);
			this.a(var1, Blocks.AIR.P(), 10, 5, 5, var3);
			this.a(var1, Blocks.AIR.P(), 1, 5, 9, var3);
			this.a(var1, Blocks.AIR.P(), 10, 5, 9, var3);

			int var8;
			for (var8 = 0; var8 <= 14; var8 += 14) {
				this.a(var1, var3, 2, 4, var8, 2, 5, var8, false, var2, k);
				this.a(var1, var3, 4, 4, var8, 4, 5, var8, false, var2, k);
				this.a(var1, var3, 7, 4, var8, 7, 5, var8, false, var2, k);
				this.a(var1, var3, 9, 4, var8, 9, 5, var8, false, var2, k);
			}

			this.a(var1, var3, 5, 6, 0, 6, 6, 0, false, var2, k);

			for (var8 = 0; var8 <= 11; var8 += 11) {
				for (int var9 = 2; var9 <= 12; var9 += 2) {
					this.a(var1, var3, var8, 4, var9, var8, 5, var9, false, var2, k);
				}

				this.a(var1, var3, var8, 6, 5, var8, 6, 5, false, var2, k);
				this.a(var1, var3, var8, 6, 9, var8, 6, 9, false, var2, k);
			}

			this.a(var1, var3, 2, 7, 2, 2, 9, 2, false, var2, k);
			this.a(var1, var3, 9, 7, 2, 9, 9, 2, false, var2, k);
			this.a(var1, var3, 2, 7, 12, 2, 9, 12, false, var2, k);
			this.a(var1, var3, 9, 7, 12, 9, 9, 12, false, var2, k);
			this.a(var1, var3, 4, 9, 4, 4, 9, 4, false, var2, k);
			this.a(var1, var3, 7, 9, 4, 7, 9, 4, false, var2, k);
			this.a(var1, var3, 4, 9, 10, 4, 9, 10, false, var2, k);
			this.a(var1, var3, 7, 9, 10, 7, 9, 10, false, var2, k);
			this.a(var1, var3, 5, 9, 7, 6, 9, 7, false, var2, k);
			this.a(var1, Blocks.aw.a(var4), 5, 9, 6, var3);
			this.a(var1, Blocks.aw.a(var4), 6, 9, 6, var3);
			this.a(var1, Blocks.aw.a(var5), 5, 9, 8, var3);
			this.a(var1, Blocks.aw.a(var5), 6, 9, 8, var3);
			this.a(var1, Blocks.aw.a(var4), 4, 0, 0, var3);
			this.a(var1, Blocks.aw.a(var4), 5, 0, 0, var3);
			this.a(var1, Blocks.aw.a(var4), 6, 0, 0, var3);
			this.a(var1, Blocks.aw.a(var4), 7, 0, 0, var3);
			this.a(var1, Blocks.aw.a(var4), 4, 1, 8, var3);
			this.a(var1, Blocks.aw.a(var4), 4, 2, 9, var3);
			this.a(var1, Blocks.aw.a(var4), 4, 3, 10, var3);
			this.a(var1, Blocks.aw.a(var4), 7, 1, 8, var3);
			this.a(var1, Blocks.aw.a(var4), 7, 2, 9, var3);
			this.a(var1, Blocks.aw.a(var4), 7, 3, 10, var3);
			this.a(var1, var3, 4, 1, 9, 4, 1, 9, false, var2, k);
			this.a(var1, var3, 7, 1, 9, 7, 1, 9, false, var2, k);
			this.a(var1, var3, 4, 1, 10, 7, 2, 10, false, var2, k);
			this.a(var1, var3, 5, 4, 5, 6, 4, 5, false, var2, k);
			this.a(var1, Blocks.aw.a(var6), 4, 4, 5, var3);
			this.a(var1, Blocks.aw.a(var7), 7, 4, 5, var3);

			for (var8 = 0; var8 < 4; ++var8) {
				this.a(var1, Blocks.aw.a(var5), 5, 0 - var8, 6 + var8, var3);
				this.a(var1, Blocks.aw.a(var5), 6, 0 - var8, 6 + var8, var3);
				this.a(var1, var3, 5, 0 - var8, 7 + var8, 6, 0 - var8, 9 + var8);
			}

			this.a(var1, var3, 1, -3, 12, 10, -1, 13);
			this.a(var1, var3, 1, -3, 1, 3, -1, 13);
			this.a(var1, var3, 1, -3, 1, 9, -1, 5);

			for (var8 = 1; var8 <= 13; var8 += 2) {
				this.a(var1, var3, 1, -3, var8, 1, -2, var8, false, var2, k);
			}

			for (var8 = 2; var8 <= 12; var8 += 2) {
				this.a(var1, var3, 1, -1, var8, 3, -1, var8, false, var2, k);
			}

			this.a(var1, var3, 2, -2, 1, 5, -2, 1, false, var2, k);
			this.a(var1, var3, 7, -2, 1, 9, -2, 1, false, var2, k);
			this.a(var1, var3, 6, -3, 1, 6, -3, 1, false, var2, k);
			this.a(var1, var3, 6, -1, 1, 6, -1, 1, false, var2, k);
			this.a(var1, Blocks.bR.a(this.a(Blocks.bR, PaintingDirection.f.toByte())).a(BlockTripwireHook.M, Boolean.valueOf(true)), 1, -3, 8, var3);
			this.a(var1, Blocks.bR.a(this.a(Blocks.bR, PaintingDirection.e.toByte())).a(BlockTripwireHook.M, Boolean.valueOf(true)), 4, -3, 8, var3);
			this.a(var1, Blocks.bS.P().a(BlockTripwire.M, Boolean.valueOf(true)), 2, -3, 8, var3);
			this.a(var1, Blocks.bS.P().a(BlockTripwire.M, Boolean.valueOf(true)), 3, -3, 8, var3);
			this.a(var1, Blocks.af.P(), 5, -3, 7, var3);
			this.a(var1, Blocks.af.P(), 5, -3, 6, var3);
			this.a(var1, Blocks.af.P(), 5, -3, 5, var3);
			this.a(var1, Blocks.af.P(), 5, -3, 4, var3);
			this.a(var1, Blocks.af.P(), 5, -3, 3, var3);
			this.a(var1, Blocks.af.P(), 5, -3, 2, var3);
			this.a(var1, Blocks.af.P(), 5, -3, 1, var3);
			this.a(var1, Blocks.af.P(), 4, -3, 1, var3);
			this.a(var1, Blocks.MOSSY_COBBLESTONE.P(), 3, -3, 1, var3);
			if (!this.g) {
				this.g = this.a(var1, var3, var2, 3, -2, 1, PaintingDirection.c.a(), j, 2);
			}

			this.a(var1, Blocks.bn.a(15), 3, -2, 2, var3);
			this.a(var1, Blocks.bR.a(this.a(Blocks.bR, PaintingDirection.c.toByte())).a(BlockTripwireHook.M, Boolean.valueOf(true)), 7, -3, 1, var3);
			this.a(var1, Blocks.bR.a(this.a(Blocks.bR, PaintingDirection.d.toByte())).a(BlockTripwireHook.M, Boolean.valueOf(true)), 7, -3, 5, var3);
			this.a(var1, Blocks.bS.P().a(BlockTripwire.M, Boolean.valueOf(true)), 7, -3, 2, var3);
			this.a(var1, Blocks.bS.P().a(BlockTripwire.M, Boolean.valueOf(true)), 7, -3, 3, var3);
			this.a(var1, Blocks.bS.P().a(BlockTripwire.M, Boolean.valueOf(true)), 7, -3, 4, var3);
			this.a(var1, Blocks.af.P(), 8, -3, 6, var3);
			this.a(var1, Blocks.af.P(), 9, -3, 6, var3);
			this.a(var1, Blocks.af.P(), 9, -3, 5, var3);
			this.a(var1, Blocks.MOSSY_COBBLESTONE.P(), 9, -3, 4, var3);
			this.a(var1, Blocks.af.P(), 9, -2, 4, var3);
			if (!this.h) {
				this.h = this.a(var1, var3, var2, 9, -2, 3, PaintingDirection.e.a(), j, 2);
			}

			this.a(var1, Blocks.bn.a(15), 8, -1, 3, var3);
			this.a(var1, Blocks.bn.a(15), 8, -2, 3, var3);
			if (!this.e) {
				this.e = this.a(var1, var3, var2, 8, -3, 3, vl.a(i, new vl[] { Items.cd.b(var2) }), 2 + var2.nextInt(5));
			}

			this.a(var1, Blocks.MOSSY_COBBLESTONE.P(), 9, -3, 2, var3);
			this.a(var1, Blocks.MOSSY_COBBLESTONE.P(), 8, -3, 1, var3);
			this.a(var1, Blocks.MOSSY_COBBLESTONE.P(), 4, -3, 5, var3);
			this.a(var1, Blocks.MOSSY_COBBLESTONE.P(), 5, -2, 5, var3);
			this.a(var1, Blocks.MOSSY_COBBLESTONE.P(), 5, -1, 5, var3);
			this.a(var1, Blocks.MOSSY_COBBLESTONE.P(), 6, -3, 5, var3);
			this.a(var1, Blocks.MOSSY_COBBLESTONE.P(), 7, -2, 5, var3);
			this.a(var1, Blocks.MOSSY_COBBLESTONE.P(), 7, -1, 5, var3);
			this.a(var1, Blocks.MOSSY_COBBLESTONE.P(), 8, -3, 5, var3);
			this.a(var1, var3, 9, -1, 1, 9, -1, 5, false, var2, k);
			this.a(var1, var3, 8, -3, 8, 10, -1, 10);
			this.a(var1, Blocks.bf.a(BlockSmoothBrick.O), 8, -2, 11, var3);
			this.a(var1, Blocks.bf.a(BlockSmoothBrick.O), 9, -2, 11, var3);
			this.a(var1, Blocks.bf.a(BlockSmoothBrick.O), 10, -2, 11, var3);
			this.a(var1, Blocks.ay.a(BlockLever.a(PaintingDirection.a(this.a(Blocks.ay, PaintingDirection.c.a())))), 8, -2, 12, var3);
			this.a(var1, Blocks.ay.a(BlockLever.a(PaintingDirection.a(this.a(Blocks.ay, PaintingDirection.c.a())))), 9, -2, 12, var3);
			this.a(var1, Blocks.ay.a(BlockLever.a(PaintingDirection.a(this.a(Blocks.ay, PaintingDirection.c.a())))), 10, -2, 12, var3);
			this.a(var1, var3, 8, -3, 8, 8, -3, 10, false, var2, k);
			this.a(var1, var3, 10, -3, 8, 10, -3, 10, false, var2, k);
			this.a(var1, Blocks.MOSSY_COBBLESTONE.P(), 10, -2, 9, var3);
			this.a(var1, Blocks.af.P(), 8, -2, 9, var3);
			this.a(var1, Blocks.af.P(), 8, -2, 10, var3);
			this.a(var1, Blocks.af.P(), 10, -1, 9, var3);
			this.a(var1, Blocks.STICKY_PISTON.a(PaintingDirection.b.a()), 9, -2, 8, var3);
			this.a(var1, Blocks.STICKY_PISTON.a(this.a(Blocks.STICKY_PISTON, PaintingDirection.e.a())), 10, -2, 8, var3);
			this.a(var1, Blocks.STICKY_PISTON.a(this.a(Blocks.STICKY_PISTON, PaintingDirection.e.a())), 10, -1, 8, var3);
			this.a(var1, Blocks.bb.a(this.a(Blocks.bb, PaintingDirection.c.toByte())), 10, -2, 10, var3);
			if (!this.f) {
				this.f = this.a(var1, var3, var2, 9, -3, 10, vl.a(i, new vl[] { Items.cd.b(var2) }), 2 + var2.nextInt(5));
			}

			return true;
		}
	}

}
