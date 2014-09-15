package net.minecraft;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public abstract class StructureStart {

	protected LinkedList a = new LinkedList();
	protected CuboidArea b;
	private int c;
	private int d;

	public StructureStart() {
	}

	public StructureStart(int var1, int var2) {
		this.c = var1;
		this.d = var2;
	}

	public CuboidArea a() {
		return this.b;
	}

	public LinkedList b() {
		return this.a;
	}

	public void a(World var1, Random var2, CuboidArea var3) {
		Iterator var4 = this.a.iterator();

		while (var4.hasNext()) {
			StructurePiece var5 = (StructurePiece) var4.next();
			if (var5.c().a(var3) && !var5.a(var1, var2, var3)) {
				var4.remove();
			}
		}

	}

	protected void c() {
		this.b = CuboidArea.getMaximumArea();
		Iterator var1 = this.a.iterator();

		while (var1.hasNext()) {
			StructurePiece var2 = (StructurePiece) var1.next();
			this.b.b(var2.c());
		}

	}

	public NBTCompoundTag a(int var1, int var2) {
		NBTCompoundTag var3 = new NBTCompoundTag();
		var3.put("id", WorldGenFactory.a(this));
		var3.put("ChunkX", var1);
		var3.put("ChunkZ", var2);
		var3.put("BB", (NBTTag) this.b.g());
		NBTListTag var4 = new NBTListTag();
		Iterator var5 = this.a.iterator();

		while (var5.hasNext()) {
			StructurePiece var6 = (StructurePiece) var5.next();
			var4.addTag((NBTTag) var6.b());
		}

		var3.put("Children", (NBTTag) var4);
		this.a(var3);
		return var3;
	}

	public void a(NBTCompoundTag var1) {
	}

	public void a(World var1, NBTCompoundTag var2) {
		this.c = var2.getInt("ChunkX");
		this.d = var2.getInt("ChunkZ");
		if (var2.hasKey("BB")) {
			this.b = new CuboidArea(var2.getIntArray("BB"));
		}

		NBTListTag var3 = var2.getList("Children", 10);

		for (int var4 = 0; var4 < var3.getSize(); ++var4) {
			this.a.add(WorldGenFactory.b(var3.getCompound(var4), var1));
		}

		this.b(var2);
	}

	public void b(NBTCompoundTag var1) {
	}

	protected void a(World var1, Random var2, int var3) {
		int var4 = 63 - var3;
		int var5 = this.b.d() + 1;
		if (var5 < var4) {
			var5 += var2.nextInt(var4 - var5);
		}

		int var6 = var5 - this.b.maxY;
		this.b.a(0, var6, 0);
		Iterator var7 = this.a.iterator();

		while (var7.hasNext()) {
			StructurePiece var8 = (StructurePiece) var7.next();
			var8.c().a(0, var6, 0);
		}

	}

	protected void a(World var1, Random var2, int var3, int var4) {
		int var5 = var4 - var3 + 1 - this.b.d();
		boolean var6 = true;
		int var10;
		if (var5 > 1) {
			var10 = var3 + var2.nextInt(var5);
		} else {
			var10 = var3;
		}

		int var7 = var10 - this.b.minY;
		this.b.a(0, var7, 0);
		Iterator var8 = this.a.iterator();

		while (var8.hasNext()) {
			StructurePiece var9 = (StructurePiece) var8.next();
			var9.c().a(0, var7, 0);
		}

	}

	public boolean d() {
		return true;
	}

	public boolean a(ChunkCoordIntPair var1) {
		return true;
	}

	public void b(ChunkCoordIntPair var1) {
	}

	public int e() {
		return this.c;
	}

	public int f() {
		return this.d;
	}
}
