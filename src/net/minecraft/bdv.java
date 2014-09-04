package net.minecraft;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class bdv extends bcm implements pm {

	private bec a;
	private ej f;
	private boolean g;
	private boolean h;
	private float i;
	private float j;
	private List k = Lists.newArrayList();

	public bdv() {
	}

	public bdv(bec var1, ej var2, boolean var3, boolean var4) {
		this.a = var1;
		this.f = var2;
		this.g = var3;
		this.h = var4;
	}

	public bec b() {
		return this.a;
	}

	public int u() {
		return 0;
	}

	public boolean d() {
		return this.g;
	}

	public ej e() {
		return this.f;
	}

	public float a(float var1) {
		if (var1 > 1.0F) {
			var1 = 1.0F;
		}

		return this.j + (this.i - this.j) * var1;
	}

	private void a(float var1, float var2) {
		if (this.g) {
			var1 = 1.0F - var1;
		} else {
			--var1;
		}

		brt var3 = aty.M.a(this.b, this.c, this.a, var1, this.f);
		if (var3 != null) {
			List var4 = this.b.b((Entity) null, var3);
			if (!var4.isEmpty()) {
				this.k.addAll(var4);
				Iterator var5 = this.k.iterator();

				while (var5.hasNext()) {
					Entity var6 = (Entity) var5.next();
					if (this.a.c() == aty.cE && this.g) {
						switch (bdw.a[this.f.k().ordinal()]) {
							case 1:
								var6.v = (double) this.f.g();
								break;
							case 2:
								var6.w = (double) this.f.h();
								break;
							case 3:
								var6.x = (double) this.f.i();
						}
					} else {
						var6.d((double) (var2 * (float) this.f.g()), (double) (var2 * (float) this.f.h()), (double) (var2 * (float) this.f.i()));
					}
				}

				this.k.clear();
			}
		}

	}

	public void h() {
		if (this.j < 1.0F && this.b != null) {
			this.j = this.i = 1.0F;
			this.b.t(this.c);
			this.y();
			if (this.b.p(this.c).c() == aty.M) {
				this.b.a(this.c, this.a, 3);
				this.b.d(this.c, this.a.c());
			}
		}

	}

	public void c() {
		this.j = this.i;
		if (this.j >= 1.0F) {
			this.a(1.0F, 0.25F);
			this.b.t(this.c);
			this.y();
			if (this.b.p(this.c).c() == aty.M) {
				this.b.a(this.c, this.a, 3);
				this.b.d(this.c, this.a.c());
			}

		} else {
			this.i += 0.5F;
			if (this.i >= 1.0F) {
				this.i = 1.0F;
			}

			if (this.g) {
				this.a(this.i, this.i - this.j + 0.0625F);
			}

		}
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.a = atr.c(var1.f("blockId")).a(var1.f("blockData"));
		this.f = ej.a(var1.f("facing"));
		this.j = this.i = var1.h("progress");
		this.g = var1.n("extending");
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.a("blockId", atr.a(this.a.c()));
		var1.a("blockData", this.a.c().c(this.a));
		var1.a("facing", this.f.a());
		var1.a("progress", this.j);
		var1.a("extending", this.g);
	}
}
