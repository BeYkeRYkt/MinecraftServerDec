package net.minecraft;

import java.util.List;
import java.util.Random;

public class bmb extends bmk {

	private boolean a;

	public bmb() {
	}

	public bmb(int var1, Random var2, CuboidArea var3, BlockFace var4) {
		super(var1);
		this.m = var4;
		this.l = var3;
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		var1.put("Mob", this.a);
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		this.a = var1.getBoolean("Mob");
	}

	public void a(bms var1, List var2, Random var3) {
		if (var1 != null) {
			((bmh) var1).b = this;
		}

	}

	public static bmb a(List var0, Random var1, int var2, int var3, int var4, BlockFace var5, int var6) {
		CuboidArea var7 = CuboidArea.a(var2, var3, var4, -4, -1, 0, 11, 8, 16, var5);
		return a(var7) && bms.a(var0, var7) == null ? new bmb(var6, var1, var7, var5) : null;
	}

	public boolean a(World var1, Random var2, CuboidArea var3) {
		this.a(var1, var3, 0, 0, 0, 10, 7, 15, false, var2, blr.c());
		this.a(var1, var2, var3, bml.c, 4, 1, 0);
		byte var4 = 6;
		this.a(var1, var3, 1, var4, 1, 1, var4, 14, false, var2, blr.c());
		this.a(var1, var3, 9, var4, 1, 9, var4, 14, false, var2, blr.c());
		this.a(var1, var3, 2, var4, 1, 8, var4, 2, false, var2, blr.c());
		this.a(var1, var3, 2, var4, 14, 8, var4, 14, false, var2, blr.c());
		this.a(var1, var3, 1, 1, 1, 2, 1, 4, false, var2, blr.c());
		this.a(var1, var3, 8, 1, 1, 9, 1, 4, false, var2, blr.c());
		this.a(var1, var3, 1, 1, 1, 1, 1, 3, Blocks.FLOWING_LAVA.getBlockState(), Blocks.FLOWING_LAVA.getBlockState(), false);
		this.a(var1, var3, 9, 1, 1, 9, 1, 3, Blocks.FLOWING_LAVA.getBlockState(), Blocks.FLOWING_LAVA.getBlockState(), false);
		this.a(var1, var3, 3, 1, 8, 7, 1, 12, false, var2, blr.c());
		this.a(var1, var3, 4, 1, 9, 6, 1, 11, Blocks.FLOWING_LAVA.getBlockState(), Blocks.FLOWING_LAVA.getBlockState(), false);

		int var5;
		for (var5 = 3; var5 < 14; var5 += 2) {
			this.a(var1, var3, 0, 3, var5, 0, 4, var5, Blocks.IRON_BARS.getBlockState(), Blocks.IRON_BARS.getBlockState(), false);
			this.a(var1, var3, 10, 3, var5, 10, 4, var5, Blocks.IRON_BARS.getBlockState(), Blocks.IRON_BARS.getBlockState(), false);
		}

		for (var5 = 2; var5 < 9; var5 += 2) {
			this.a(var1, var3, var5, 3, 15, var5, 4, 15, Blocks.IRON_BARS.getBlockState(), Blocks.IRON_BARS.getBlockState(), false);
		}

		var5 = this.a(Blocks.STONE_BROCK_STAIRS, 3);
		this.a(var1, var3, 4, 1, 5, 6, 1, 7, false, var2, blr.c());
		this.a(var1, var3, 4, 2, 6, 6, 2, 7, false, var2, blr.c());
		this.a(var1, var3, 4, 3, 7, 6, 3, 7, false, var2, blr.c());

		int var6;
		for (var6 = 4; var6 <= 6; ++var6) {
			this.a(var1, Blocks.STONE_BROCK_STAIRS.a(var5), var6, 1, 4, var3);
			this.a(var1, Blocks.STONE_BROCK_STAIRS.a(var5), var6, 2, 5, var3);
			this.a(var1, Blocks.STONE_BROCK_STAIRS.a(var5), var6, 3, 6, var3);
		}

		var6 = BlockFace.NORTH.toDirection();
		int var7 = BlockFace.SOUTH.toDirection();
		int var8 = BlockFace.EAST.toDirection();
		int var9 = BlockFace.WEST.toDirection();
		if (this.m != null) {
			switch (blu.b[this.m.ordinal()]) {
				case 2:
					var6 = BlockFace.SOUTH.toDirection();
					var7 = BlockFace.NORTH.toDirection();
					break;
				case 3:
					var6 = BlockFace.WEST.toDirection();
					var7 = BlockFace.EAST.toDirection();
					var8 = BlockFace.SOUTH.toDirection();
					var9 = BlockFace.NORTH.toDirection();
					break;
				case 4:
					var6 = BlockFace.EAST.toDirection();
					var7 = BlockFace.WEST.toDirection();
					var8 = BlockFace.SOUTH.toDirection();
					var9 = BlockFace.NORTH.toDirection();
			}
		}

		this.a(var1, Blocks.END_PORTAL_FRAME.a(var6).a(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 4, 3, 8, var3);
		this.a(var1, Blocks.END_PORTAL_FRAME.a(var6).a(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 5, 3, 8, var3);
		this.a(var1, Blocks.END_PORTAL_FRAME.a(var6).a(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 6, 3, 8, var3);
		this.a(var1, Blocks.END_PORTAL_FRAME.a(var7).a(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 4, 3, 12, var3);
		this.a(var1, Blocks.END_PORTAL_FRAME.a(var7).a(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 5, 3, 12, var3);
		this.a(var1, Blocks.END_PORTAL_FRAME.a(var7).a(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 6, 3, 12, var3);
		this.a(var1, Blocks.END_PORTAL_FRAME.a(var8).a(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 3, 3, 9, var3);
		this.a(var1, Blocks.END_PORTAL_FRAME.a(var8).a(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 3, 3, 10, var3);
		this.a(var1, Blocks.END_PORTAL_FRAME.a(var8).a(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 3, 3, 11, var3);
		this.a(var1, Blocks.END_PORTAL_FRAME.a(var9).a(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 7, 3, 9, var3);
		this.a(var1, Blocks.END_PORTAL_FRAME.a(var9).a(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 7, 3, 10, var3);
		this.a(var1, Blocks.END_PORTAL_FRAME.a(var9).a(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 7, 3, 11, var3);
		if (!this.a) {
			int var12 = this.d(3);
			Position var10 = new Position(this.a(5, 6), var12, this.b(5, 6));
			if (var3.b((fd) var10)) {
				this.a = true;
				var1.a(var10, Blocks.MOB_SPAWNER.getBlockState(), 2);
				TileEntity var11 = var1.getTileEntity(var10);
				if (var11 instanceof TileEntityMobSpawner) {
					((TileEntityMobSpawner) var11).b().a("Silverfish");
				}
			}
		}

		return true;
	}
}
