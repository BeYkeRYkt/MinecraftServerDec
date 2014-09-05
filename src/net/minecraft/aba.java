package net.minecraft;

public class aba extends aay {

	private Position f;

	public aba(EntityInsentient var1, World var2) {
		super(var1, var2);
	}

	public bpv a(Position var1) {
		this.f = var1;
		return super.a(var1);
	}

	public bpv a(Entity var1) {
		this.f = new Position(var1);
		return super.a(var1);
	}

	public boolean a(Entity var1, double var2) {
		bpv var4 = this.a(var1);
		if (var4 != null) {
			return this.a(var4, var2);
		} else {
			this.f = new Position(var1);
			this.e = var2;
			return true;
		}
	}

	public void k() {
		if (!this.m()) {
			super.k();
		} else {
			if (this.f != null) {
				double var1 = (double) (this.b.J * this.b.J);
				if (this.b.c(this.f) >= var1 && (this.b.locationY <= (double) this.f.o() || this.b.c(new Position(this.f.n(), DataTypesConverter.toFixedPointInt(this.b.locationY), this.f.p())) >= var1)) {
					this.b.q().a((double) this.f.n(), (double) this.f.o(), (double) this.f.p(), this.e);
				} else {
					this.f = null;
				}
			}

		}
	}
}
