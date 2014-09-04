package net.minecraft;

import com.google.common.base.Predicate;

public abstract class avy extends auc {

	protected bev a;

	protected avy() {
		super(bof.k);
		this.j(this.L.b().a(this.l(), this.j() == awc.b ? awa.b : awa.a));
	}

	public int a(bec var1) {
		return ((awa) var1.b(this.l())).b();
	}

	public bec a(int var1) {
		return this.P().a(this.l(), awa.a(this.j(), var1));
	}

	public abstract awc j();

	public bex l() {
		if (this.a == null) {
			this.a = bev.a("type", awa.class, (Predicate) (new avz(this)));
		}

		return this.a;
	}

	public int c(bec var1) {
		return ((awa) var1.b(this.l())).b();
	}

	protected bed e() {
		return new bed(this, new bex[] { this.l() });
	}
}
