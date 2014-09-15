package net.minecraft;

import com.google.common.base.Objects;

public class CuboidArea {

	public static CuboidArea getMaximumArea() {
		return new CuboidArea(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
	}

	public static CuboidArea a(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, BlockFace var9) {
		switch (bjc.a[var9.ordinal()]) {
			case 1:
				return new CuboidArea(var0 + var3, var1 + var4, var2 - var8 + 1 + var5, var0 + var6 - 1 + var3, var1 + var7 - 1 + var4, var2 + var5);
			case 2:
				return new CuboidArea(var0 + var3, var1 + var4, var2 + var5, var0 + var6 - 1 + var3, var1 + var7 - 1 + var4, var2 + var8 - 1 + var5);
			case 3:
				return new CuboidArea(var0 - var8 + 1 + var5, var1 + var4, var2 + var3, var0 + var5, var1 + var7 - 1 + var4, var2 + var6 - 1 + var3);
			case 4:
				return new CuboidArea(var0 + var5, var1 + var4, var2 + var3, var0 + var8 - 1 + var5, var1 + var7 - 1 + var4, var2 + var6 - 1 + var3);
			default:
				return new CuboidArea(var0 + var3, var1 + var4, var2 + var5, var0 + var6 - 1 + var3, var1 + var7 - 1 + var4, var2 + var8 - 1 + var5);
		}
	}

	public static CuboidArea a(int var0, int var1, int var2, int var3, int var4, int var5) {
		return new CuboidArea(Math.min(var0, var3), Math.min(var1, var4), Math.min(var2, var5), Math.max(var0, var3), Math.max(var1, var4), Math.max(var2, var5));
	}

	public int minX;
	public int minY;
	public int minZ;
	public int maxX;
	public int maxY;
	public int maxZ;

	public CuboidArea() {
	}

	public CuboidArea(int[] coordArray) {
		if (coordArray.length == 6) {
			this.minX = coordArray[0];
			this.minY = coordArray[1];
			this.minZ = coordArray[2];
			this.maxX = coordArray[3];
			this.maxY = coordArray[4];
			this.maxZ = coordArray[5];
		}

	}

	public CuboidArea(CuboidArea cuboidArea) {
		this.minX = cuboidArea.minX;
		this.minY = cuboidArea.minY;
		this.minZ = cuboidArea.minZ;
		this.maxX = cuboidArea.maxX;
		this.maxY = cuboidArea.maxY;
		this.maxZ = cuboidArea.maxZ;
	}

	public CuboidArea(int minX, int minY, int minZ, int maxX, int maxY, int maxZ) {
		this.minX = minX;
		this.minY = minY;
		this.minZ = minZ;
		this.maxX = maxX;
		this.maxY = maxY;
		this.maxZ = maxZ;
	}

	public CuboidArea(fd var1, fd var2) {
		this.minX = Math.min(var1.getX(), var2.getX());
		this.minY = Math.min(var1.getY(), var2.getY());
		this.minZ = Math.min(var1.getZ(), var2.getZ());
		this.maxX = Math.max(var1.getX(), var2.getX());
		this.maxY = Math.max(var1.getY(), var2.getY());
		this.maxZ = Math.max(var1.getZ(), var2.getZ());
	}

	public CuboidArea(int minX, int minZ, int maxX, int maxZ) {
		this.minX = minX;
		this.minZ = minZ;
		this.maxX = maxX;
		this.maxZ = maxZ;
		this.minY = 1;
		this.maxY = 512;
	}

	public boolean a(CuboidArea var1) {
		return this.maxX >= var1.minX && this.minX <= var1.maxX && this.maxZ >= var1.minZ && this.minZ <= var1.maxZ && this.maxY >= var1.minY && this.minY <= var1.maxY;
	}

	public boolean a(int var1, int var2, int var3, int var4) {
		return this.maxX >= var1 && this.minX <= var3 && this.maxZ >= var2 && this.minZ <= var4;
	}

	public void b(CuboidArea var1) {
		this.minX = Math.min(this.minX, var1.minX);
		this.minY = Math.min(this.minY, var1.minY);
		this.minZ = Math.min(this.minZ, var1.minZ);
		this.maxX = Math.max(this.maxX, var1.maxX);
		this.maxY = Math.max(this.maxY, var1.maxY);
		this.maxZ = Math.max(this.maxZ, var1.maxZ);
	}

	public void a(int var1, int var2, int var3) {
		this.minX += var1;
		this.minY += var2;
		this.minZ += var3;
		this.maxX += var1;
		this.maxY += var2;
		this.maxZ += var3;
	}

	public boolean b(fd var1) {
		return var1.getX() >= this.minX && var1.getX() <= this.maxX && var1.getZ() >= this.minZ && var1.getZ() <= this.maxZ && var1.getY() >= this.minY && var1.getY() <= this.maxY;
	}

	public fd b() {
		return new fd(this.maxX - this.minX, this.maxY - this.minY, this.maxZ - this.minZ);
	}

	public int c() {
		return this.maxX - this.minX + 1;
	}

	public int d() {
		return this.maxY - this.minY + 1;
	}

	public int e() {
		return this.maxZ - this.minZ + 1;
	}

	public fd f() {
		return new Position(this.minX + (this.maxX - this.minX + 1) / 2, this.minY + (this.maxY - this.minY + 1) / 2, this.minZ + (this.maxZ - this.minZ + 1) / 2);
	}

	public String toString() {
		return Objects.toStringHelper((Object) this).add("x0", this.minX).add("y0", this.minY).add("z0", this.minZ).add("x1", this.maxX).add("y1", this.maxY).add("z1", this.maxZ).toString();
	}

	public NBTIntArrayTag g() {
		return new NBTIntArrayTag(new int[] { this.minX, this.minY, this.minZ, this.maxX, this.maxY, this.maxZ });
	}
}
