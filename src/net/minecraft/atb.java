package net.minecraft;

import com.google.common.base.Predicate;
import java.util.Random;

public class atb extends atg {

	public static final beu a = beu.a("facing", (Predicate) en.a);
	public static final bew b = bew.a("rotation", 0, 15);

	protected atb() {
		super(Material.WOOD);
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
		return new bci();
	}

	public Item a(bec var1, Random var2, int var3) {
		return amk.cE;
	}

	public void a(World var1, Position var2, bec var3, float var4, int var5) {
		bcm var6 = var1.s(var2);
		if (var6 instanceof bci) {
			ItemStack var7 = new ItemStack(amk.cE, 1, ((bci) var6).b());
			NBTCompoundTag var8 = new NBTCompoundTag();
			var6.b(var8);
			var8.remove("x");
			var8.remove("y");
			var8.remove("z");
			var8.remove("id");
			var7.a("BlockEntityTag", (NBTTag) var8);
			a(var1, var2, var7);
		} else {
			super.a(var1, var2, var3, var4, var5);
		}

	}

	public void a(World var1, EntityHuman var2, Position var3, bec var4, bcm var5) {
		if (var5 instanceof bci) {
			ItemStack var6 = new ItemStack(amk.cE, 1, ((bci) var5).b());
			NBTCompoundTag var7 = new NBTCompoundTag();
			var5.b(var7);
			var7.remove("x");
			var7.remove("y");
			var7.remove("z");
			var7.remove("id");
			var6.a("BlockEntityTag", (NBTTag) var7);
			a(var1, var3, var6);
		} else {
			super.a(var1, var2, var3, var4, (bcm) null);
		}

	}

}
