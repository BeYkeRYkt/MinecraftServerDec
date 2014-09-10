package net.minecraft;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class bji extends bms {

	private List a = Lists.newLinkedList();

	public bji() {
	}

	public bji(int var1, Random var2, int var3, int var4) {
		super(var1);
		this.l = new CuboidArea(var3, 50, var4, var3 + 7 + var2.nextInt(6), 54 + var2.nextInt(6), var4 + 7 + var2.nextInt(6));
	}

	public void a(bms var1, List var2, Random var3) {
		int var4 = this.d();
		int var6 = this.l.d() - 3 - 1;
		if (var6 <= 0) {
			var6 = 1;
		}

		int var5;
		bms var7;
		CuboidArea var8;
		for (var5 = 0; var5 < this.l.c(); var5 += 4) {
			var5 += var3.nextInt(this.l.c());
			if (var5 + 3 > this.l.c()) {
				break;
			}

			var7 = bje.a(var1, var2, var3, this.l.minX + var5, this.l.minY + var3.nextInt(var6) + 1, this.l.minZ - 1, BlockFace.NORTH, var4);
			if (var7 != null) {
				var8 = var7.c();
				this.a.add(new CuboidArea(var8.minX, var8.minY, this.l.minZ, var8.maxX, var8.maxY, this.l.minZ + 1));
			}
		}

		for (var5 = 0; var5 < this.l.c(); var5 += 4) {
			var5 += var3.nextInt(this.l.c());
			if (var5 + 3 > this.l.c()) {
				break;
			}

			var7 = bje.a(var1, var2, var3, this.l.minX + var5, this.l.minY + var3.nextInt(var6) + 1, this.l.maxZ + 1, BlockFace.SOUTH, var4);
			if (var7 != null) {
				var8 = var7.c();
				this.a.add(new CuboidArea(var8.minX, var8.minY, this.l.maxZ - 1, var8.maxX, var8.maxY, this.l.maxZ));
			}
		}

		for (var5 = 0; var5 < this.l.e(); var5 += 4) {
			var5 += var3.nextInt(this.l.e());
			if (var5 + 3 > this.l.e()) {
				break;
			}

			var7 = bje.a(var1, var2, var3, this.l.minX - 1, this.l.minY + var3.nextInt(var6) + 1, this.l.minZ + var5, BlockFace.WEST, var4);
			if (var7 != null) {
				var8 = var7.c();
				this.a.add(new CuboidArea(this.l.minX, var8.minY, var8.minZ, this.l.minX + 1, var8.maxY, var8.maxZ));
			}
		}

		for (var5 = 0; var5 < this.l.e(); var5 += 4) {
			var5 += var3.nextInt(this.l.e());
			if (var5 + 3 > this.l.e()) {
				break;
			}

			var7 = bje.a(var1, var2, var3, this.l.maxX + 1, this.l.minY + var3.nextInt(var6) + 1, this.l.minZ + var5, BlockFace.EAST, var4);
			if (var7 != null) {
				var8 = var7.c();
				this.a.add(new CuboidArea(this.l.maxX - 1, var8.minY, var8.minZ, this.l.maxX, var8.maxY, var8.maxZ));
			}
		}

	}

	public boolean a(World var1, Random var2, CuboidArea var3) {
		if (this.a(var1, var3)) {
			return false;
		} else {
			this.a(var1, var3, this.l.minX, this.l.minY, this.l.minZ, this.l.maxX, this.l.minY, this.l.maxZ, Blocks.DIRT.getBlockState(), Blocks.AIR.getBlockState(), true);
			this.a(var1, var3, this.l.minX, this.l.minY + 1, this.l.minZ, this.l.maxX, Math.min(this.l.minY + 3, this.l.maxY), this.l.maxZ, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
			Iterator var4 = this.a.iterator();

			while (var4.hasNext()) {
				CuboidArea var5 = (CuboidArea) var4.next();
				this.a(var1, var3, var5.minX, var5.maxY - 2, var5.minZ, var5.maxX, var5.maxY, var5.maxZ, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
			}

			this.a(var1, var3, this.l.minX, this.l.minY + 4, this.l.minZ, this.l.maxX, this.l.maxY, this.l.maxZ, Blocks.AIR.getBlockState(), false);
			return true;
		}
	}

	protected void a(NBTCompoundTag var1) {
		NBTListTag var2 = new NBTListTag();
		Iterator var3 = this.a.iterator();

		while (var3.hasNext()) {
			CuboidArea var4 = (CuboidArea) var3.next();
			var2.addTag((NBTTag) var4.g());
		}

		var1.put("Entrances", (NBTTag) var2);
	}

	protected void b(NBTCompoundTag var1) {
		NBTListTag var2 = var1.getList("Entrances", 11);

		for (int var3 = 0; var3 < var2.getSize(); ++var3) {
			this.a.add(new CuboidArea(var2.getIntArray(var3)));
		}

	}
}
