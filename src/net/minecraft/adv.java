package net.minecraft;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;

public class adv extends Entity {

	private bec d;
	public int a;
	public boolean b = true;
	private boolean e;
	private boolean f;
	private int g = 40;
	private float h = 2.0F;
	public NBTCompoundTag c;

	public adv(World var1) {
		super(var1);
	}

	public adv(World var1, double var2, double var4, double var6, bec var8) {
		super(var1);
		this.d = var8;
		this.k = true;
		this.a(0.98F, 0.98F);
		this.b(var2, var4, var6);
		this.v = 0.0D;
		this.w = 0.0D;
		this.x = 0.0D;
		this.p = var2;
		this.q = var4;
		this.r = var6;
	}

	protected boolean r_() {
		return false;
	}

	protected void h() {
	}

	public boolean ad() {
		return !this.I;
	}

	public void s_() {
		atr var1 = this.d.c();
		if (var1.r() == bof.a) {
			this.J();
		} else {
			this.p = this.s;
			this.q = this.t;
			this.r = this.u;
			dt var2;
			if (this.a++ == 0) {
				var2 = new dt(this);
				if (this.o.p(var2).c() == var1) {
					this.o.g(var2);
				} else if (!this.o.D) {
					this.J();
					return;
				}
			}

			this.w -= 0.03999999910593033D;
			this.d(this.v, this.w, this.x);
			this.v *= 0.9800000190734863D;
			this.w *= 0.9800000190734863D;
			this.x *= 0.9800000190734863D;
			if (!this.o.D) {
				var2 = new dt(this);
				if (this.C) {
					this.v *= 0.699999988079071D;
					this.x *= 0.699999988079071D;
					this.w *= -0.5D;
					if (this.o.p(var2).c() != aty.M) {
						this.J();
						if (!this.e && this.o.a(var1, var2, true, ej.b, (Entity) null, (amj) null) && !avt.d(this.o, var2.b()) && this.o.a(var2, this.d, 3)) {
							if (var1 instanceof avt) {
								((avt) var1).a_(this.o, var2);
							}

							if (this.c != null && var1 instanceof avs) {
								bcm var3 = this.o.s(var2);
								if (var3 != null) {
									NBTCompoundTag var4 = new NBTCompoundTag();
									var3.b(var4);
									Iterator var5 = this.c.c().iterator();

									while (var5.hasNext()) {
										String var6 = (String) var5.next();
										NBTTag var7 = this.c.a(var6);
										if (!var6.equals("x") && !var6.equals("y") && !var6.equals("z")) {
											var4.a(var6, var7.getCopy());
										}
									}

									var3.a(var4);
									var3.o_();
								}
							}
						} else if (this.b && !this.e && this.o.Q().b("doTileDrops")) {
							this.a(new amj(var1, 1, var1.a(this.d)), 0.0F);
						}
					}
				} else if (this.a > 100 && !this.o.D && (var2.o() < 1 || var2.o() > 256) || this.a > 600) {
					if (this.b && this.o.Q().b("doTileDrops")) {
						this.a(new amj(var1, 1, var1.a(this.d)), 0.0F);
					}

					this.J();
				}
			}

		}
	}

	public void e(float var1, float var2) {
		atr var3 = this.d.c();
		if (this.f) {
			int var4 = uv.f(var1 - 1.0F);
			if (var4 > 0) {
				ArrayList var5 = Lists.newArrayList((Iterable) this.o.b((Entity) this, this.aQ()));
				boolean var6 = var3 == aty.cf;
				wh var7 = var6 ? wh.n : wh.o;
				Iterator var8 = var5.iterator();

				while (var8.hasNext()) {
					Entity var9 = (Entity) var8.next();
					var9.a(var7, (float) Math.min(uv.d((float) var4 * this.h), this.g));
				}

				if (var6 && (double) this.V.nextFloat() < 0.05000000074505806D + (double) var4 * 0.05D) {
					int var10 = ((Integer) this.d.b(asz.b)).intValue();
					++var10;
					if (var10 > 2) {
						this.e = true;
					} else {
						this.d = this.d.a(asz.b, Integer.valueOf(var10));
					}
				}
			}
		}

	}

	protected void b(NBTCompoundTag var1) {
		atr var2 = this.d != null ? this.d.c() : aty.a;
		oa var3 = (oa) atr.c.c(var2);
		var1.a("Block", var3 == null ? "" : var3.toString());
		var1.a("Data", (byte) var2.c(this.d));
		var1.a("Time", (byte) this.a);
		var1.a("DropItem", this.b);
		var1.a("HurtEntities", this.f);
		var1.a("FallHurtAmount", this.h);
		var1.a("FallHurtMax", this.g);
		if (this.c != null) {
			var1.a("TileEntityData", (NBTTag) this.c);
		}

	}

	protected void a(NBTCompoundTag var1) {
		int var2 = var1.d("Data") & 255;
		if (var1.b("Block", 8)) {
			this.d = atr.b(var1.j("Block")).a(var2);
		} else if (var1.b("TileID", 99)) {
			this.d = atr.c(var1.f("TileID")).a(var2);
		} else {
			this.d = atr.c(var1.d("Tile") & 255).a(var2);
		}

		this.a = var1.d("Time") & 255;
		atr var3 = this.d.c();
		if (var1.b("HurtEntities", 99)) {
			this.f = var1.n("HurtEntities");
			this.h = var1.h("FallHurtAmount");
			this.g = var1.f("FallHurtMax");
		} else if (var3 == aty.cf) {
			this.f = true;
		}

		if (var1.b("DropItem", 99)) {
			this.b = var1.n("DropItem");
		}

		if (var1.b("TileEntityData", 10)) {
			this.c = var1.m("TileEntityData");
		}

		if (var3 == null || var3.r() == bof.a) {
			this.d = aty.m.P();
		}

	}

	public void a(boolean var1) {
		this.f = var1;
	}

	public void a(j var1) {
		super.a(var1);
		if (this.d != null) {
			atr var2 = this.d.c();
			var1.a("Immitating block ID", (Object) Integer.valueOf(atr.a(var2)));
			var1.a("Immitating block data", (Object) Integer.valueOf(var2.c(this.d)));
		}

	}

	public bec l() {
		return this.d;
	}
}
