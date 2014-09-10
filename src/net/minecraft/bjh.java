package net.minecraft;

import java.util.List;
import java.util.Random;

public class bjh extends bms {

	private BlockFace a;
	private boolean b;

	public bjh() {
	}

	protected void a(NBTCompoundTag var1) {
		var1.put("tf", this.b);
		var1.put("D", this.a.toDirection());
	}

	protected void b(NBTCompoundTag var1) {
		this.b = var1.getBoolean("tf");
		this.a = BlockFace.fromDirection(var1.getInt("D"));
	}

	public bjh(int var1, Random var2, CuboidArea var3, BlockFace var4) {
		super(var1);
		this.a = var4;
		this.l = var3;
		this.b = var3.d() > 3;
	}

	public static CuboidArea a(List var0, Random var1, int var2, int var3, int var4, BlockFace var5) {
		CuboidArea var6 = new CuboidArea(var2, var3, var4, var2, var3 + 2, var4);
		if (var1.nextInt(4) == 0) {
			var6.maxY += 4;
		}

		switch (bjf.a[var5.ordinal()]) {
			case 1:
				var6.minX = var2 - 1;
				var6.maxX = var2 + 3;
				var6.minZ = var4 - 4;
				break;
			case 2:
				var6.minX = var2 - 1;
				var6.maxX = var2 + 3;
				var6.maxZ = var4 + 4;
				break;
			case 3:
				var6.minX = var2 - 4;
				var6.minZ = var4 - 1;
				var6.maxZ = var4 + 3;
				break;
			case 4:
				var6.maxX = var2 + 4;
				var6.minZ = var4 - 1;
				var6.maxZ = var4 + 3;
		}

		return bms.a(var0, var6) != null ? null : var6;
	}

	public void a(bms var1, List var2, Random var3) {
		int var4 = this.d();
		switch (bjf.a[this.a.ordinal()]) {
			case 1:
				bje.a(var1, var2, var3, this.l.minX + 1, this.l.minY, this.l.minZ - 1, BlockFace.NORTH, var4);
				bje.a(var1, var2, var3, this.l.minX - 1, this.l.minY, this.l.minZ + 1, BlockFace.WEST, var4);
				bje.a(var1, var2, var3, this.l.maxX + 1, this.l.minY, this.l.minZ + 1, BlockFace.EAST, var4);
				break;
			case 2:
				bje.a(var1, var2, var3, this.l.minX + 1, this.l.minY, this.l.maxZ + 1, BlockFace.SOUTH, var4);
				bje.a(var1, var2, var3, this.l.minX - 1, this.l.minY, this.l.minZ + 1, BlockFace.WEST, var4);
				bje.a(var1, var2, var3, this.l.maxX + 1, this.l.minY, this.l.minZ + 1, BlockFace.EAST, var4);
				break;
			case 3:
				bje.a(var1, var2, var3, this.l.minX + 1, this.l.minY, this.l.minZ - 1, BlockFace.NORTH, var4);
				bje.a(var1, var2, var3, this.l.minX + 1, this.l.minY, this.l.maxZ + 1, BlockFace.SOUTH, var4);
				bje.a(var1, var2, var3, this.l.minX - 1, this.l.minY, this.l.minZ + 1, BlockFace.WEST, var4);
				break;
			case 4:
				bje.a(var1, var2, var3, this.l.minX + 1, this.l.minY, this.l.minZ - 1, BlockFace.NORTH, var4);
				bje.a(var1, var2, var3, this.l.minX + 1, this.l.minY, this.l.maxZ + 1, BlockFace.SOUTH, var4);
				bje.a(var1, var2, var3, this.l.maxX + 1, this.l.minY, this.l.minZ + 1, BlockFace.EAST, var4);
		}

		if (this.b) {
			if (var3.nextBoolean()) {
				bje.a(var1, var2, var3, this.l.minX + 1, this.l.minY + 3 + 1, this.l.minZ - 1, BlockFace.NORTH, var4);
			}

			if (var3.nextBoolean()) {
				bje.a(var1, var2, var3, this.l.minX - 1, this.l.minY + 3 + 1, this.l.minZ + 1, BlockFace.WEST, var4);
			}

			if (var3.nextBoolean()) {
				bje.a(var1, var2, var3, this.l.maxX + 1, this.l.minY + 3 + 1, this.l.minZ + 1, BlockFace.EAST, var4);
			}

			if (var3.nextBoolean()) {
				bje.a(var1, var2, var3, this.l.minX + 1, this.l.minY + 3 + 1, this.l.maxZ + 1, BlockFace.SOUTH, var4);
			}
		}

	}

	public boolean a(World var1, Random var2, CuboidArea var3) {
		if (this.a(var1, var3)) {
			return false;
		} else {
			if (this.b) {
				this.a(var1, var3, this.l.minX + 1, this.l.minY, this.l.minZ, this.l.maxX - 1, this.l.minY + 3 - 1, this.l.maxZ, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
				this.a(var1, var3, this.l.minX, this.l.minY, this.l.minZ + 1, this.l.maxX, this.l.minY + 3 - 1, this.l.maxZ - 1, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
				this.a(var1, var3, this.l.minX + 1, this.l.maxY - 2, this.l.minZ, this.l.maxX - 1, this.l.maxY, this.l.maxZ, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
				this.a(var1, var3, this.l.minX, this.l.maxY - 2, this.l.minZ + 1, this.l.maxX, this.l.maxY, this.l.maxZ - 1, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
				this.a(var1, var3, this.l.minX + 1, this.l.minY + 3, this.l.minZ + 1, this.l.maxX - 1, this.l.minY + 3, this.l.maxZ - 1, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
			} else {
				this.a(var1, var3, this.l.minX + 1, this.l.minY, this.l.minZ, this.l.maxX - 1, this.l.maxY, this.l.maxZ, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
				this.a(var1, var3, this.l.minX, this.l.minY, this.l.minZ + 1, this.l.maxX, this.l.maxY, this.l.maxZ - 1, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
			}

			this.a(var1, var3, this.l.minX + 1, this.l.minY, this.l.minZ + 1, this.l.minX + 1, this.l.maxY, this.l.minZ + 1, Blocks.PLANKS.getBlockState(), Blocks.AIR.getBlockState(), false);
			this.a(var1, var3, this.l.minX + 1, this.l.minY, this.l.maxZ - 1, this.l.minX + 1, this.l.maxY, this.l.maxZ - 1, Blocks.PLANKS.getBlockState(), Blocks.AIR.getBlockState(), false);
			this.a(var1, var3, this.l.maxX - 1, this.l.minY, this.l.minZ + 1, this.l.maxX - 1, this.l.maxY, this.l.minZ + 1, Blocks.PLANKS.getBlockState(), Blocks.AIR.getBlockState(), false);
			this.a(var1, var3, this.l.maxX - 1, this.l.minY, this.l.maxZ - 1, this.l.maxX - 1, this.l.maxY, this.l.maxZ - 1, Blocks.PLANKS.getBlockState(), Blocks.AIR.getBlockState(), false);

			for (int var4 = this.l.minX; var4 <= this.l.maxX; ++var4) {
				for (int var5 = this.l.minZ; var5 <= this.l.maxZ; ++var5) {
					if (this.a(var1, var4, this.l.minY - 1, var5, var3).getBlock().getMaterial() == Material.AIR) {
						this.a(var1, Blocks.PLANKS.getBlockState(), var4, this.l.minY - 1, var5, var3);
					}
				}
			}

			return true;
		}
	}
}
