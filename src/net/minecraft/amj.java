package net.minecraft;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import java.text.DecimalFormat;
import java.util.Random;

public final class amj {

	public static final DecimalFormat a = new DecimalFormat("#.###");
	public int b;
	public int c;
	private alq d;
	private NBTCompoundTag e;
	private int f;
	private adk g;
	private atr h;
	private boolean i;
	private atr j;
	private boolean k;

	public amj(atr var1) {
		this(var1, 1);
	}

	public amj(atr var1, int var2) {
		this(var1, var2, 0);
	}

	public amj(atr var1, int var2, int var3) {
		this(alq.a(var1), var2, var3);
	}

	public amj(alq var1) {
		this(var1, 1);
	}

	public amj(alq var1, int var2) {
		this(var1, var2, 0);
	}

	public amj(alq var1, int var2, int var3) {
		this.h = null;
		this.i = false;
		this.j = null;
		this.k = false;
		this.d = var1;
		this.b = var2;
		this.f = var3;
		if (this.f < 0) {
			this.f = 0;
		}

	}

	public static amj a(NBTCompoundTag var0) {
		amj var1 = new amj();
		var1.c(var0);
		return var1.b() != null ? var1 : null;
	}

	private amj() {
		this.h = null;
		this.i = false;
		this.j = null;
		this.k = false;
	}

	public amj a(int var1) {
		amj var2 = new amj(this.d, var1, this.f);
		if (this.e != null) {
			var2.e = (NBTCompoundTag) this.e.getCopy();
		}

		this.b -= var1;
		return var2;
	}

	public alq b() {
		return this.d;
	}

	public boolean a(ahd var1, World var2, dt var3, ej var4, float var5, float var6, float var7) {
		boolean var8 = this.b().a(this, var1, var2, var3, var4, var5, var6, var7);
		if (var8) {
			var1.b(ty.J[alq.b(this.d)]);
		}

		return var8;
	}

	public float a(atr var1) {
		return this.b().a(this, var1);
	}

	public amj a(World var1, ahd var2) {
		return this.b().a(this, var1, var2);
	}

	public amj b(World var1, ahd var2) {
		return this.b().b(this, var1, var2);
	}

	public NBTCompoundTag b(NBTCompoundTag var1) {
		oa var2 = (oa) alq.e.c(this.d);
		var1.a("id", var2 == null ? "minecraft:air" : var2.toString());
		var1.a("Count", (byte) this.b);
		var1.a("Damage", (short) this.f);
		if (this.e != null) {
			var1.a("tag", (NBTTag) this.e);
		}

		return var1;
	}

	public void c(NBTCompoundTag var1) {
		if (var1.b("id", 8)) {
			this.d = alq.d(var1.j("id"));
		} else {
			this.d = alq.b(var1.e("id"));
		}

		this.b = var1.d("Count");
		this.f = var1.e("Damage");
		if (this.f < 0) {
			this.f = 0;
		}

		if (var1.b("tag", 10)) {
			this.e = var1.m("tag");
			if (this.d != null) {
				this.d.a(this.e);
			}
		}

	}

	public int c() {
		return this.b().j();
	}

	public boolean d() {
		return this.c() > 1 && (!this.e() || !this.g());
	}

	public boolean e() {
		return this.d == null ? false : (this.d.l() <= 0 ? false : !this.n() || !this.o().n("Unbreakable"));
	}

	public boolean f() {
		return this.d.k();
	}

	public boolean g() {
		return this.e() && this.f > 0;
	}

	public int h() {
		return this.f;
	}

	public int i() {
		return this.f;
	}

	public void b(int var1) {
		this.f = var1;
		if (this.f < 0) {
			this.f = 0;
		}

	}

	public int j() {
		return this.d.l();
	}

	public boolean a(int var1, Random var2) {
		if (!this.e()) {
			return false;
		} else {
			if (var1 > 0) {
				int var3 = aph.a(apf.t.B, this);
				int var4 = 0;

				for (int var5 = 0; var3 > 0 && var5 < var1; ++var5) {
					if (apd.a(this, var3, var2)) {
						++var4;
					}
				}

				var1 -= var4;
				if (var1 <= 0) {
					return false;
				}
			}

			this.f += var1;
			return this.f > this.j();
		}
	}

	public void a(int var1, EntityLiving var2) {
		if (!(var2 instanceof ahd) || !((ahd) var2).by.d) {
			if (this.e()) {
				if (this.a(var1, var2.bb())) {
					var2.b(this);
					--this.b;
					if (var2 instanceof ahd) {
						ahd var3 = (ahd) var2;
						var3.b(ty.K[alq.b(this.d)]);
						if (this.b == 0 && this.b() instanceof ajz) {
							var3.bZ();
						}
					}

					if (this.b < 0) {
						this.b = 0;
					}

					this.f = 0;
				}

			}
		}
	}

	public void a(EntityLiving var1, ahd var2) {
		boolean var3 = this.d.a(this, var1, (EntityLiving) var2);
		if (var3) {
			var2.b(ty.J[alq.b(this.d)]);
		}

	}

	public void a(World var1, atr var2, dt var3, ahd var4) {
		boolean var5 = this.d.a(this, var1, var2, var3, var4);
		if (var5) {
			var4.b(ty.J[alq.b(this.d)]);
		}

	}

	public boolean b(atr var1) {
		return this.d.b(var1);
	}

	public boolean a(ahd var1, EntityLiving var2) {
		return this.d.a(this, var1, var2);
	}

	public amj k() {
		amj var1 = new amj(this.d, this.b, this.f);
		if (this.e != null) {
			var1.e = (NBTCompoundTag) this.e.getCopy();
		}

		return var1;
	}

	public static boolean a(amj var0, amj var1) {
		return var0 == null && var1 == null ? true : (var0 != null && var1 != null ? (var0.e == null && var1.e != null ? false : var0.e == null || var0.e.equals(var1.e)) : false);
	}

	public static boolean b(amj var0, amj var1) {
		return var0 == null && var1 == null ? true : (var0 != null && var1 != null ? var0.d(var1) : false);
	}

	private boolean d(amj var1) {
		return this.b != var1.b ? false : (this.d != var1.d ? false : (this.f != var1.f ? false : (this.e == null && var1.e != null ? false : this.e == null || this.e.equals(var1.e))));
	}

	public static boolean c(amj var0, amj var1) {
		return var0 == null && var1 == null ? true : (var0 != null && var1 != null ? var0.a(var1) : false);
	}

	public boolean a(amj var1) {
		return var1 != null && this.d == var1.d && this.f == var1.f;
	}

	public String a() {
		return this.d.e_(this);
	}

	public static amj b(amj var0) {
		return var0 == null ? null : var0.k();
	}

	public String toString() {
		return this.b + "x" + this.d.a() + "@" + this.f;
	}

	public void a(World var1, Entity var2, int var3, boolean var4) {
		if (this.c > 0) {
			--this.c;
		}

		this.d.a(this, var1, var2, var3, var4);
	}

	public void a(World var1, ahd var2, int var3) {
		var2.a(ty.I[alq.b(this.d)], var3);
		this.d.d(this, var1, var2);
	}

	public int l() {
		return this.b().d(this);
	}

	public ano m() {
		return this.b().e(this);
	}

	public void b(World var1, ahd var2, int var3) {
		this.b().a(this, var1, var2, var3);
	}

	public boolean n() {
		return this.e != null;
	}

	public NBTCompoundTag o() {
		return this.e;
	}

	public NBTCompoundTag a(String var1, boolean var2) {
		if (this.e != null && this.e.b(var1, 10)) {
			return this.e.m(var1);
		} else if (var2) {
			NBTCompoundTag var3 = new NBTCompoundTag();
			this.a(var1, (NBTTag) var3);
			return var3;
		} else {
			return null;
		}
	}

	public NBTListTag p() {
		return this.e == null ? null : this.e.c("ench", 10);
	}

	public void d(NBTCompoundTag var1) {
		this.e = var1;
	}

	public String q() {
		String var1 = this.b().a(this);
		if (this.e != null && this.e.b("display", 10)) {
			NBTCompoundTag var2 = this.e.m("display");
			if (var2.b("Name", 8)) {
				var1 = var2.j("Name");
			}
		}

		return var1;
	}

	public amj c(String var1) {
		if (this.e == null) {
			this.e = new NBTCompoundTag();
		}

		if (!this.e.b("display", 10)) {
			this.e.a("display", (NBTTag) (new NBTCompoundTag()));
		}

		this.e.m("display").a("Name", var1);
		return this;
	}

	public void r() {
		if (this.e != null) {
			if (this.e.b("display", 10)) {
				NBTCompoundTag var1 = this.e.m("display");
				var1.o("Name");
				if (var1.c_()) {
					this.e.o("display");
					if (this.e.c_()) {
						this.d((NBTCompoundTag) null);
					}
				}

			}
		}
	}

	public boolean s() {
		return this.e == null ? false : (!this.e.b("display", 10) ? false : this.e.m("display").b("Name", 8));
	}

	public amx u() {
		return this.b().g(this);
	}

	public boolean v() {
		return !this.b().f_(this) ? false : !this.w();
	}

	public void a(apf var1, int var2) {
		if (this.e == null) {
			this.d(new NBTCompoundTag());
		}

		if (!this.e.b("ench", 9)) {
			this.e.a("ench", (NBTTag) (new NBTListTag()));
		}

		NBTListTag var3 = this.e.c("ench", 10);
		NBTCompoundTag var4 = new NBTCompoundTag();
		var4.a("id", (short) var1.B);
		var4.a("lvl", (short) ((byte) var2));
		var3.a((NBTTag) var4);
	}

	public boolean w() {
		return this.e != null && this.e.b("ench", 9);
	}

	public void a(String var1, NBTTag var2) {
		if (this.e == null) {
			this.d(new NBTCompoundTag());
		}

		this.e.a(var1, var2);
	}

	public boolean x() {
		return this.b().s();
	}

	public boolean y() {
		return this.g != null;
	}

	public void a(adk var1) {
		this.g = var1;
	}

	public adk z() {
		return this.g;
	}

	public int A() {
		return this.n() && this.e.b("RepairCost", 3) ? this.e.f("RepairCost") : 0;
	}

	public void c(int var1) {
		if (!this.n()) {
			this.e = new NBTCompoundTag();
		}

		this.e.a("RepairCost", var1);
	}

	public Multimap B() {
		Object var1;
		if (this.n() && this.e.b("AttributeModifiers", 9)) {
			var1 = HashMultimap.create();
			NBTListTag var2 = this.e.c("AttributeModifiers", 10);

			for (int var3 = 0; var3 < var2.c(); ++var3) {
				NBTCompoundTag var4 = var2.b(var3);
				ya var5 = afs.a(var4);
				if (var5 != null && var5.a().getLeastSignificantBits() != 0L && var5.a().getMostSignificantBits() != 0L) {
					((Multimap) var1).put(var4.j("AttributeName"), var5);
				}
			}
		} else {
			var1 = this.b().i();
		}

		return (Multimap) var1;
	}

	public void a(alq var1) {
		this.d = var1;
	}

	public ho C() {
		hy var1 = new hy(this.q());
		if (this.s()) {
			var1.b().b(Boolean.valueOf(true));
		}

		ho var2 = (new hy("[")).a(var1).a("]");
		if (this.d != null) {
			NBTCompoundTag var3 = new NBTCompoundTag();
			this.b(var3);
			var2.b().a(new hr(hs.c, new hy(var3.toString())));
			var2.b().a(this.u().e);
		}

		return var2;
	}

	public boolean c(atr var1) {
		if (var1 == this.h) {
			return this.i;
		} else {
			this.h = var1;
			if (this.n() && this.e.b("CanDestroy", 9)) {
				NBTListTag var2 = this.e.c("CanDestroy", 8);

				for (int var3 = 0; var3 < var2.c(); ++var3) {
					atr var4 = atr.b(var2.f(var3));
					if (var4 == var1) {
						this.i = true;
						return true;
					}
				}
			}

			this.i = false;
			return false;
		}
	}

	public boolean d(atr var1) {
		if (var1 == this.j) {
			return this.k;
		} else {
			this.j = var1;
			if (this.n() && this.e.b("CanPlaceOn", 9)) {
				NBTListTag var2 = this.e.c("CanPlaceOn", 8);

				for (int var3 = 0; var3 < var2.c(); ++var3) {
					atr var4 = atr.b(var2.f(var3));
					if (var4 == var1) {
						this.k = true;
						return true;
					}
				}
			}

			this.k = false;
			return false;
		}
	}

}
