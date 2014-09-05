package net.minecraft;

import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.Validate;

public abstract class adj extends Entity {

	private int c;
	protected Position a;
	public ej b;

	public adj(World var1) {
		super(var1);
		this.a(0.5F, 0.5F);
	}

	public adj(World var1, Position var2) {
		this(var1);
		this.a = var2;
	}

	protected void h() {
	}

	protected void a(ej var1) {
		Validate.notNull(var1);
		Validate.isTrue(var1.k().c());
		this.b = var1;
		this.A = this.yaw = (float) (this.b.b() * 90);
		this.o();
	}

	private void o() {
		if (this.b != null) {
			double var1 = (double) this.a.n() + 0.5D;
			double var3 = (double) this.a.o() + 0.5D;
			double var5 = (double) this.a.p() + 0.5D;
			double var7 = 0.46875D;
			double var9 = this.a(this.l());
			double var11 = this.a(this.m());
			var1 -= (double) this.b.g() * 0.46875D;
			var5 -= (double) this.b.i() * 0.46875D;
			var3 += var11;
			ej var13 = this.b.f();
			var1 += var9 * (double) var13.g();
			var5 += var9 * (double) var13.i();
			this.locationX = var1;
			this.locationY = var3;
			this.locationZ = var5;
			double var14 = (double) this.l();
			double var16 = (double) this.m();
			double var18 = (double) this.l();
			if (this.b.k() == el.c) {
				var18 = 1.0D;
			} else {
				var14 = 1.0D;
			}

			var14 /= 32.0D;
			var16 /= 32.0D;
			var18 /= 32.0D;
			this.a(new brt(var1 - var14, var3 - var16, var5 - var18, var1 + var14, var3 + var16, var5 + var18));
		}
	}

	private double a(int var1) {
		return var1 % 32 == 0 ? 0.5D : 0.0D;
	}

	public void s_() {
		this.p = this.locationX;
		this.q = this.locationY;
		this.r = this.locationZ;
		if (this.c++ == 100 && !this.o.D) {
			this.c = 0;
			if (!this.I && !this.j()) {
				this.J();
				this.b((Entity) null);
			}
		}

	}

	public boolean j() {
		if (!this.o.a((Entity) this, this.aQ()).isEmpty()) {
			return false;
		} else {
			int var1 = Math.max(1, this.l() / 16);
			int var2 = Math.max(1, this.m() / 16);
			Position var3 = this.a.a(this.b.d());
			ej var4 = this.b.f();

			for (int var5 = 0; var5 < var1; ++var5) {
				for (int var6 = 0; var6 < var2; ++var6) {
					Position var7 = var3.a(var4, var5).b(var6);
					Block var8 = this.o.p(var7).c();
					if (!var8.r().a() && !ava.d(var8)) {
						return false;
					}
				}
			}

			List var9 = this.o.b((Entity) this, this.aQ());
			Iterator var10 = var9.iterator();

			Entity var11;
			do {
				if (!var10.hasNext()) {
					return true;
				}

				var11 = (Entity) var10.next();
			} while (!(var11 instanceof adj));

			return false;
		}
	}

	public boolean ad() {
		return true;
	}

	public boolean l(Entity var1) {
		return var1 instanceof EntityHuman ? this.a(wh.a((EntityHuman) var1), 0.0F) : false;
	}

	public ej aO() {
		return this.b;
	}

	public boolean a(wh var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			if (!this.I && !this.o.D) {
				this.J();
				this.ac();
				this.b(var1.j());
			}

			return true;
		}
	}

	public void d(double var1, double var3, double var5) {
		if (!this.o.D && !this.I && var1 * var1 + var3 * var3 + var5 * var5 > 0.0D) {
			this.J();
			this.b((Entity) null);
		}

	}

	public void g(double var1, double var3, double var5) {
		if (!this.o.D && !this.I && var1 * var1 + var3 * var3 + var5 * var5 > 0.0D) {
			this.J();
			this.b((Entity) null);
		}

	}

	public void b(NBTCompoundTag var1) {
		var1.put("Facing", (byte) this.b.b());
		var1.put("TileX", this.n().n());
		var1.put("TileY", this.n().o());
		var1.put("TileZ", this.n().p());
	}

	public void a(NBTCompoundTag var1) {
		this.a = new Position(var1.getInt("TileX"), var1.getInt("TileY"), var1.getInt("TileZ"));
		ej var2;
		if (var1.isTagAssignableFrom("Direction", 99)) {
			var2 = ej.b(var1.getByte("Direction"));
			this.a = this.a.a(var2);
		} else if (var1.isTagAssignableFrom("Facing", 99)) {
			var2 = ej.b(var1.getByte("Facing"));
		} else {
			var2 = ej.b(var1.getByte("Dir"));
		}

		this.a(var2);
	}

	public abstract int l();

	public abstract int m();

	public abstract void b(Entity var1);

	protected boolean af() {
		return false;
	}

	public void b(double var1, double var3, double var5) {
		this.locationX = var1;
		this.locationY = var3;
		this.locationZ = var5;
		Position var7 = this.a;
		this.a = new Position(var1, var3, var5);
		if (!this.a.equals(var7)) {
			this.o();
			this.ai = true;
		}

	}

	public Position n() {
		return this.a;
	}
}
