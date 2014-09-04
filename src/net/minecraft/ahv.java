package net.minecraft;

import java.util.Iterator;
import java.util.List;

public class ahv extends ahr {

	private amj c;

	public ahv(World var1) {
		super(var1);
	}

	public ahv(World var1, EntityLiving var2, int var3) {
		this(var1, var2, new amj(amk.bz, 1, var3));
	}

	public ahv(World var1, EntityLiving var2, amj var3) {
		super(var1, var2);
		this.c = var3;
	}

	public ahv(World var1, double var2, double var4, double var6, amj var8) {
		super(var1, var2, var4, var6);
		this.c = var8;
	}

	protected float m() {
		return 0.05F;
	}

	protected float j() {
		return 0.5F;
	}

	protected float l() {
		return -20.0F;
	}

	public void a(int var1) {
		if (this.c == null) {
			this.c = new amj(amk.bz, 1, 0);
		}

		this.c.b(var1);
	}

	public int o() {
		if (this.c == null) {
			this.c = new amj(amk.bz, 1, 0);
		}

		return this.c.i();
	}

	protected void a(bru var1) {
		if (!this.o.D) {
			List var2 = amk.bz.h(this.c);
			if (var2 != null && !var2.isEmpty()) {
				brt var3 = this.aQ().b(4.0D, 2.0D, 4.0D);
				List var4 = this.o.a(EntityLiving.class, var3);
				if (!var4.isEmpty()) {
					Iterator var5 = var4.iterator();

					while (var5.hasNext()) {
						EntityLiving var6 = (EntityLiving) var5.next();
						double var7 = this.h(var6);
						if (var7 < 16.0D) {
							double var9 = 1.0D - Math.sqrt(var7) / 4.0D;
							if (var6 == var1.d) {
								var9 = 1.0D;
							}

							Iterator var11 = var2.iterator();

							while (var11.hasNext()) {
								wq var12 = (wq) var11.next();
								int var13 = var12.a();
								if (wp.a[var13].b()) {
									wp.a[var13].a(this, this.n(), var6, var12.c(), var9);
								} else {
									int var14 = (int) (var9 * (double) var12.b() + 0.5D);
									if (var14 > 20) {
										var6.c(new wq(var13, var14, var12.c()));
									}
								}
							}
						}
					}
				}
			}

			this.o.b(2002, new dt(this), this.o());
			this.J();
		}

	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		if (var1.isTagAssignableFrom("Potion", 10)) {
			this.c = amj.a(var1.getCompound("Potion"));
		} else {
			this.a(var1.getInt("potionValue"));
		}

		if (this.c == null) {
			this.J();
		}

	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		if (this.c != null) {
			var1.put("Potion", (NBTTag) this.c.b(new NBTCompoundTag()));
		}

	}
}
