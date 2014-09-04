package net.minecraft;

public class aju extends alq {

	protected final atr a;

	public aju(atr var1) {
		this.a = var1;
	}

	public aju b(String var1) {
		super.c(var1);
		return this;
	}

	public boolean a(amj var1, ahd var2, World var3, dt var4, ej var5, float var6, float var7, float var8) {
		bec var9 = var3.p(var4);
		atr var10 = var9.c();
		if (var10 == aty.aH && ((Integer) var9.b(bao.a)).intValue() < 1) {
			var5 = ej.b;
		} else if (!var10.f(var3, var4)) {
			var4 = var4.a(var5);
		}

		if (var1.b == 0) {
			return false;
		} else if (!var2.a(var4, var5, var1)) {
			return false;
		} else if (var4.o() == 255 && this.a.r().a()) {
			return false;
		} else if (var3.a(this.a, var4, false, var5, (Entity) null, var1)) {
			int var11 = this.a(var1.i());
			bec var12 = this.a.a(var3, var4, var5, var6, var7, var8, var11, var2);
			if (var3.a(var4, var12, 3)) {
				var12 = var3.p(var4);
				if (var12.c() == this.a) {
					a(var3, var4, var1);
					this.a.a(var3, var4, var12, (EntityLiving) var2, var1);
				}

				var3.a((double) ((float) var4.n() + 0.5F), (double) ((float) var4.o() + 0.5F), (double) ((float) var4.p() + 0.5F), this.a.H.b(), (this.a.H.d() + 1.0F) / 2.0F, this.a.H.e() * 0.8F);
				--var1.b;
			}

			return true;
		} else {
			return false;
		}
	}

	public static boolean a(World var0, dt var1, amj var2) {
		if (var2.n() && var2.o().b("BlockEntityTag", 10)) {
			bcm var3 = var0.s(var1);
			if (var3 != null) {
				NBTCompoundTag var4 = new NBTCompoundTag();
				NBTCompoundTag var5 = (NBTCompoundTag) var4.getCopy();
				var3.b(var4);
				NBTCompoundTag var6 = (NBTCompoundTag) var2.o().a("BlockEntityTag");
				var4.a(var6);
				var4.a("x", var1.n());
				var4.a("y", var1.o());
				var4.a("z", var1.p());
				if (!var4.equals(var5)) {
					var3.a(var4);
					var3.o_();
					return true;
				}
			}
		}

		return false;
	}

	public String e_(amj var1) {
		return this.a.a();
	}

	public String a() {
		return this.a.a();
	}

	public atr d() {
		return this.a;
	}

	// $FF: synthetic method
	public alq c(String var1) {
		return this.b(var1);
	}
}
