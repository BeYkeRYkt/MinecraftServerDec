package net.minecraft;

import java.util.List;
import java.util.Random;

public class WorldGenMineshaftStart extends StructureStart {

	public WorldGenMineshaftStart() {
	}

	public WorldGenMineshaftStart(World var1, Random var2, int var3, int var4) {
		super(var3, var4);
		WorldGenMineshaftRoom var5 = new WorldGenMineshaftRoom(0, var2, (var3 << 4) + 2, (var4 << 4) + 2);
		this.a.add(var5);
		var5.a((StructurePiece) var5, (List) this.a, var2);
		this.c();
		this.a(var1, var2, 10);
	}

}
