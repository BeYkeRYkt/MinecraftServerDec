package net.minecraft;

public abstract class bdf extends bcm implements vv, vy {

	private vx a;

	public bdf() {
		this.a = vx.a;
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.a = vx.b(var1);
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		if (this.a != null) {
			this.a.a(var1);
		}

	}

	public boolean q_() {
		return this.a != null && !this.a.a();
	}

	public vx i() {
		return this.a;
	}

	public void a(vx var1) {
		this.a = var1;
	}

	public ho e_() {
		return (ho) (this.k_() ? new hy(this.d_()) : new hz(this.d_(), new Object[0]));
	}
}
