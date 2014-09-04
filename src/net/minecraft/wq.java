package net.minecraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class wq {

	private static final Logger a = LogManager.getLogger();
	private int b;
	private int c;
	private int d;
	private boolean e;
	private boolean f;
	private boolean h;

	public wq(int var1, int var2) {
		this(var1, var2, 0);
	}

	public wq(int var1, int var2, int var3) {
		this(var1, var2, var3, false, true);
	}

	public wq(int var1, int var2, int var3, boolean var4, boolean var5) {
		this.b = var1;
		this.c = var2;
		this.d = var3;
		this.f = var4;
		this.h = var5;
	}

	public wq(wq var1) {
		this.b = var1.b;
		this.c = var1.c;
		this.d = var1.d;
		this.f = var1.f;
		this.h = var1.h;
	}

	public void a(wq var1) {
		if (this.b != var1.b) {
			a.warn("This method should only be called for matching effects!");
		}

		if (var1.d > this.d) {
			this.d = var1.d;
			this.c = var1.c;
		} else if (var1.d == this.d && this.c < var1.c) {
			this.c = var1.c;
		} else if (!var1.f && this.f) {
			this.f = var1.f;
		}

		this.h = var1.h;
	}

	public int a() {
		return this.b;
	}

	public int b() {
		return this.c;
	}

	public int c() {
		return this.d;
	}

	public void a(boolean var1) {
		this.e = var1;
	}

	public boolean e() {
		return this.f;
	}

	public boolean f() {
		return this.h;
	}

	public boolean a(EntityLiving var1) {
		if (this.c > 0) {
			if (wp.a[this.b].a(this.c, this.d)) {
				this.b(var1);
			}

			this.i();
		}

		return this.c > 0;
	}

	private int i() {
		return --this.c;
	}

	public void b(EntityLiving var1) {
		if (this.c > 0) {
			wp.a[this.b].a(var1, this.d);
		}

	}

	public String g() {
		return wp.a[this.b].a();
	}

	public int hashCode() {
		return this.b;
	}

	public String toString() {
		String var1 = "";
		if (this.c() > 0) {
			var1 = this.g() + " x " + (this.c() + 1) + ", Duration: " + this.b();
		} else {
			var1 = this.g() + ", Duration: " + this.b();
		}

		if (this.e) {
			var1 = var1 + ", Splash: true";
		}

		if (!this.h) {
			var1 = var1 + ", Particles: false";
		}

		return wp.a[this.b].j() ? "(" + var1 + ")" : var1;
	}

	public boolean equals(Object var1) {
		if (!(var1 instanceof wq)) {
			return false;
		} else {
			wq var2 = (wq) var1;
			return this.b == var2.b && this.d == var2.d && this.c == var2.c && this.e == var2.e && this.f == var2.f;
		}
	}

	public NBTCompoundTag a(NBTCompoundTag var1) {
		var1.put("Id", (byte) this.a());
		var1.put("Amplifier", (byte) this.c());
		var1.put("Duration", this.b());
		var1.put("Ambient", this.e());
		var1.put("ShowParticles", this.f());
		return var1;
	}

	public static wq b(NBTCompoundTag var0) {
		byte var1 = var0.getByte("Id");
		if (var1 >= 0 && var1 < wp.a.length && wp.a[var1] != null) {
			byte var2 = var0.getByte("Amplifier");
			int var3 = var0.getInt("Duration");
			boolean var4 = var0.getBoolean("Ambient");
			boolean var5 = true;
			if (var0.isTagAssignableFrom("ShowParticles", 1)) {
				var5 = var0.getBoolean("ShowParticles");
			}

			return new wq(var1, var3, var2, var4, var5);
		} else {
			return null;
		}
	}

}
