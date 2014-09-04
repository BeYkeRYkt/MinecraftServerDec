package net.minecraft;

public class adk extends adj {

	private float c = 1.0F;

	public adk(World var1) {
		super(var1);
	}

	public adk(World var1, dt var2, ej var3) {
		super(var1, var2);
		this.a(var3);
	}

	protected void h() {
		this.H().a(8, 5);
		this.H().a(9, Byte.valueOf((byte) 0));
	}

	public float ao() {
		return 0.0F;
	}

	public boolean a(wh var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else if (!var1.c() && this.o() != null) {
			if (!this.o.D) {
				this.a(var1.j(), false);
				this.a((amj) null);
			}

			return true;
		} else {
			return super.a(var1, var2);
		}
	}

	public int l() {
		return 12;
	}

	public int m() {
		return 12;
	}

	public void b(Entity var1) {
		this.a(var1, true);
	}

	public void a(Entity var1, boolean var2) {
		if (this.o.Q().b("doTileDrops")) {
			amj var3 = this.o();
			if (var1 instanceof ahd) {
				ahd var4 = (ahd) var1;
				if (var4.by.d) {
					this.b(var3);
					return;
				}
			}

			if (var2) {
				this.a(new amj(amk.bP), 0.0F);
			}

			if (var3 != null && this.V.nextFloat() < this.c) {
				var3 = var3.k();
				this.b(var3);
				this.a(var3, 0.0F);
			}

		}
	}

	private void b(amj var1) {
		if (var1 != null) {
			if (var1.b() == amk.bd) {
				bqe var2 = ((amn) var1.b()).a(var1, this.o);
				var2.h.remove("frame-" + this.F());
			}

			var1.a((adk) null);
		}
	}

	public amj o() {
		return this.H().f(8);
	}

	public void a(amj var1) {
		this.a(var1, true);
	}

	private void a(amj var1, boolean var2) {
		if (var1 != null) {
			var1 = var1.k();
			var1.b = 1;
			var1.a(this);
		}

		this.H().b(8, var1);
		this.H().i(8);
		if (var2 && this.a != null) {
			this.o.e(this.a, aty.a);
		}

	}

	public int p() {
		return this.H().a(9);
	}

	public void a(int var1) {
		this.a(var1, true);
	}

	private void a(int var1, boolean var2) {
		this.H().b(9, Byte.valueOf((byte) (var1 % 8)));
		if (var2 && this.a != null) {
			this.o.e(this.a, aty.a);
		}

	}

	public void b(NBTCompoundTag var1) {
		if (this.o() != null) {
			var1.a("Item", (NBTTag) this.o().b(new NBTCompoundTag()));
			var1.a("ItemRotation", (byte) this.p());
			var1.a("ItemDropChance", this.c);
		}

		super.b(var1);
	}

	public void a(NBTCompoundTag var1) {
		NBTCompoundTag var2 = var1.m("Item");
		if (var2 != null && !var2.c_()) {
			this.a(amj.a(var2), false);
			this.a(var1.d("ItemRotation"), false);
			if (var1.b("ItemDropChance", 99)) {
				this.c = var1.h("ItemDropChance");
			}

			if (var1.c("Direction")) {
				this.a(this.p() * 2, false);
			}
		}

		super.a(var1);
	}

	public boolean e(ahd var1) {
		if (this.o() == null) {
			amj var2 = var1.bz();
			if (var2 != null && !this.o.D) {
				this.a(var2);
				if (!var1.by.d && --var2.b <= 0) {
					var1.bg.a(var1.bg.c, (amj) null);
				}
			}
		} else if (!this.o.D) {
			this.a(this.p() + 1);
		}

		return true;
	}

	public int q() {
		return this.o() == null ? 0 : this.p() % 8 + 1;
	}
}
