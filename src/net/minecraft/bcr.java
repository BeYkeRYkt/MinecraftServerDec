package net.minecraft;

import java.util.Iterator;
import java.util.List;

public class bcr extends bdf implements pm, vq {

	private amj[] m = new amj[27];
	public boolean a;
	public bcr f;
	public bcr g;
	public bcr h;
	public bcr i;
	public float j;
	public float k;
	public int l;
	private int n;
	private int o = -1;
	private String p;

	public int n_() {
		return 27;
	}

	public amj a(int var1) {
		return this.m[var1];
	}

	public amj a(int var1, int var2) {
		if (this.m[var1] != null) {
			amj var3;
			if (this.m[var1].b <= var2) {
				var3 = this.m[var1];
				this.m[var1] = null;
				this.o_();
				return var3;
			} else {
				var3 = this.m[var1].a(var2);
				if (this.m[var1].b == 0) {
					this.m[var1] = null;
				}

				this.o_();
				return var3;
			}
		} else {
			return null;
		}
	}

	public amj b(int var1) {
		if (this.m[var1] != null) {
			amj var2 = this.m[var1];
			this.m[var1] = null;
			return var2;
		} else {
			return null;
		}
	}

	public void a(int var1, amj var2) {
		this.m[var1] = var2;
		if (var2 != null && var2.b > this.p_()) {
			var2.b = this.p_();
		}

		this.o_();
	}

	public String d_() {
		return this.k_() ? this.p : "container.chest";
	}

	public boolean k_() {
		return this.p != null && this.p.length() > 0;
	}

	public void a(String var1) {
		this.p = var1;
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		NBTListTag var2 = var1.getList("Items", 10);
		this.m = new amj[this.n_()];
		if (var1.isTagAssignableFrom("CustomName", 8)) {
			this.p = var1.getString("CustomName");
		}

		for (int var3 = 0; var3 < var2.getSize(); ++var3) {
			NBTCompoundTag var4 = var2.getCompound(var3);
			int var5 = var4.getByte("Slot") & 255;
			if (var5 >= 0 && var5 < this.m.length) {
				this.m[var5] = amj.a(var4);
			}
		}

	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		NBTListTag var2 = new NBTListTag();

		for (int var3 = 0; var3 < this.m.length; ++var3) {
			if (this.m[var3] != null) {
				NBTCompoundTag var4 = new NBTCompoundTag();
				var4.put("Slot", (byte) var3);
				this.m[var3].b(var4);
				var2.addTag((NBTTag) var4);
			}
		}

		var1.put("Items", (NBTTag) var2);
		if (this.k_()) {
			var1.put("CustomName", this.p);
		}

	}

	public int p_() {
		return 64;
	}

	public boolean a(ahd var1) {
		return this.b.s(this.c) != this ? false : var1.e((double) this.c.n() + 0.5D, (double) this.c.o() + 0.5D, (double) this.c.p() + 0.5D) <= 64.0D;
	}

	public void E() {
		super.E();
		this.a = false;
	}

	private void a(bcr var1, ej var2) {
		if (var1.x()) {
			this.a = false;
		} else if (this.a) {
			switch (bcs.a[var2.ordinal()]) {
				case 1:
					if (this.f != var1) {
						this.a = false;
					}
					break;
				case 2:
					if (this.i != var1) {
						this.a = false;
					}
					break;
				case 3:
					if (this.g != var1) {
						this.a = false;
					}
					break;
				case 4:
					if (this.h != var1) {
						this.a = false;
					}
			}
		}

	}

	public void m() {
		if (!this.a) {
			this.a = true;
			this.h = this.a(ej.e);
			this.g = this.a(ej.f);
			this.f = this.a(ej.c);
			this.i = this.a(ej.d);
		}
	}

	protected bcr a(ej var1) {
		dt var2 = this.c.a(var1);
		if (this.b(var2)) {
			bcm var3 = this.b.s(var2);
			if (var3 instanceof bcr) {
				bcr var4 = (bcr) var3;
				var4.a(this, var1.d());
				return var4;
			}
		}

		return null;
	}

	private boolean b(dt var1) {
		if (this.b == null) {
			return false;
		} else {
			atr var2 = this.b.p(var1).c();
			return var2 instanceof auj && ((auj) var2).b == this.n();
		}
	}

	public void c() {
		this.m();
		int var1 = this.c.n();
		int var2 = this.c.o();
		int var3 = this.c.p();
		++this.n;
		float var4;
		if (!this.b.D && this.l != 0 && (this.n + var1 + var2 + var3) % 200 == 0) {
			this.l = 0;
			var4 = 5.0F;
			List var5 = this.b.a(ahd.class, new brt((double) ((float) var1 - var4), (double) ((float) var2 - var4), (double) ((float) var3 - var4), (double) ((float) (var1 + 1) + var4), (double) ((float) (var2 + 1) + var4), (double) ((float) (var3 + 1) + var4)));
			Iterator var6 = var5.iterator();

			while (var6.hasNext()) {
				ahd var7 = (ahd) var6.next();
				if (var7.bi instanceof aim) {
					vq var8 = ((aim) var7.bi).e();
					if (var8 == this || var8 instanceof vp && ((vp) var8).a((vq) this)) {
						++this.l;
					}
				}
			}
		}

		this.k = this.j;
		var4 = 0.1F;
		double var14;
		if (this.l > 0 && this.j == 0.0F && this.f == null && this.h == null) {
			double var11 = (double) var1 + 0.5D;
			var14 = (double) var3 + 0.5D;
			if (this.i != null) {
				var14 += 0.5D;
			}

			if (this.g != null) {
				var11 += 0.5D;
			}

			this.b.a(var11, (double) var2 + 0.5D, var14, "random.chestopen", 0.5F, this.b.s.nextFloat() * 0.1F + 0.9F);
		}

		if (this.l == 0 && this.j > 0.0F || this.l > 0 && this.j < 1.0F) {
			float var12 = this.j;
			if (this.l > 0) {
				this.j += var4;
			} else {
				this.j -= var4;
			}

			if (this.j > 1.0F) {
				this.j = 1.0F;
			}

			float var13 = 0.5F;
			if (this.j < var13 && var12 >= var13 && this.f == null && this.h == null) {
				var14 = (double) var1 + 0.5D;
				double var9 = (double) var3 + 0.5D;
				if (this.i != null) {
					var9 += 0.5D;
				}

				if (this.g != null) {
					var14 += 0.5D;
				}

				this.b.a(var14, (double) var2 + 0.5D, var9, "random.chestclosed", 0.5F, this.b.s.nextFloat() * 0.1F + 0.9F);
			}

			if (this.j < 0.0F) {
				this.j = 0.0F;
			}
		}

	}

	public boolean c(int var1, int var2) {
		if (var1 == 1) {
			this.l = var2;
			return true;
		} else {
			return super.c(var1, var2);
		}
	}

	public void b(ahd var1) {
		if (!var1.v()) {
			if (this.l < 0) {
				this.l = 0;
			}

			++this.l;
			this.b.c(this.c, this.w(), 1, this.l);
			this.b.c(this.c, this.w());
			this.b.c(this.c.b(), this.w());
		}

	}

	public void c(ahd var1) {
		if (!var1.v() && this.w() instanceof auj) {
			--this.l;
			this.b.c(this.c, this.w(), 1, this.l);
			this.b.c(this.c, this.w());
			this.b.c(this.c.b(), this.w());
		}

	}

	public boolean b(int var1, amj var2) {
		return true;
	}

	public void y() {
		super.y();
		this.E();
		this.m();
	}

	public int n() {
		if (this.o == -1) {
			if (this.b == null || !(this.w() instanceof auj)) {
				return 0;
			}

			this.o = ((auj) this.w()).b;
		}

		return this.o;
	}

	public String k() {
		return "minecraft:chest";
	}

	public aib a(ahb var1, ahd var2) {
		return new aim(var1, this, var2);
	}

	public int a_(int var1) {
		return 0;
	}

	public void b(int var1, int var2) {
	}

	public int g() {
		return 0;
	}

	public void l() {
		for (int var1 = 0; var1 < this.m.length; ++var1) {
			this.m[var1] = null;
		}

	}
}
