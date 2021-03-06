package net.minecraft;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class WorldGenMineshaft extends StructureGenerator {

	private double d = 0.004D;

	public WorldGenMineshaft() {
	}

	public String getName() {
		return "Mineshaft";
	}

	public WorldGenMineshaft(Map var1) {
		Iterator var2 = var1.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry) var2.next();
			if (((String) var3.getKey()).equals("chance")) {
				this.d = MathHelper.a((String) var3.getValue(), this.d);
			}
		}

	}

	protected boolean a(int var1, int var2) {
		return this.b.nextDouble() < this.d && this.b.nextInt(80) < Math.max(Math.abs(var1), Math.abs(var2));
	}

	protected StructureStart b(int var1, int var2) {
		return new WorldGenMineshaftStart(this.c, this.b, var1, var2);
	}

}
