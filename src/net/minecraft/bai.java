package net.minecraft;

import java.util.Random;

public class bai extends atg {

	protected bai() {
		super(bof.d);
		float var1 = 0.25F;
		float var2 = 1.0F;
		this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var2, 0.5F + var1);
	}

	public brt a(World var1, Position var2, bec var3) {
		return null;
	}

	public boolean d() {
		return false;
	}

	public boolean b(ard var1, Position var2) {
		return true;
	}

	public boolean c() {
		return false;
	}

	public bcm a(World var1, int var2) {
		return new bdj();
	}

	public Item a(bec var1, Random var2, int var3) {
		return amk.ap;
	}

	public boolean a(World var1, Position var2, bec var3, EntityHuman var4, PaintingDirection var5, float var6, float var7, float var8) {
		if (var1.D) {
			return true;
		} else {
			bcm var9 = var1.s(var2);
			return var9 instanceof bdj ? ((bdj) var9).b(var4) : false;
		}
	}
}
