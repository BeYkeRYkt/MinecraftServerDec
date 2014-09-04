package net.minecraft;

import com.google.common.base.Predicate;
import java.util.Random;

public class atb extends atg {

	public static final beu a = beu.a("facing", (Predicate) en.a);
	public static final bew b = bew.a("rotation", 0, 15);

	protected atb() {
		super(bof.d);
		float var1 = 0.25F;
		float var2 = 1.0F;
		this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var2, 0.5F + var1);
	}

	public brt a(World var1, dt var2, bec var3) {
		return null;
	}

	public boolean d() {
		return false;
	}

	public boolean b(ard var1, dt var2) {
		return true;
	}

	public boolean c() {
		return false;
	}

	public bcm a(World var1, int var2) {
		return new bci();
	}

	public alq a(bec var1, Random var2, int var3) {
		return amk.cE;
	}

	public void a(World var1, dt var2, bec var3, float var4, int var5) {
		bcm var6 = var1.s(var2);
		if (var6 instanceof bci) {
			amj var7 = new amj(amk.cE, 1, ((bci) var6).b());
			NBTCompoundTag var8 = new NBTCompoundTag();
			var6.b(var8);
			var8.o("x");
			var8.o("y");
			var8.o("z");
			var8.o("id");
			var7.a("BlockEntityTag", (NBTTag) var8);
			a(var1, var2, var7);
		} else {
			super.a(var1, var2, var3, var4, var5);
		}

	}

	public void a(World var1, ahd var2, dt var3, bec var4, bcm var5) {
		if (var5 instanceof bci) {
			amj var6 = new amj(amk.cE, 1, ((bci) var5).b());
			NBTCompoundTag var7 = new NBTCompoundTag();
			var5.b(var7);
			var7.o("x");
			var7.o("y");
			var7.o("z");
			var7.o("id");
			var6.a("BlockEntityTag", (NBTTag) var7);
			a(var1, var3, var6);
		} else {
			super.a(var1, var2, var3, var4, (bcm) null);
		}

	}

}
