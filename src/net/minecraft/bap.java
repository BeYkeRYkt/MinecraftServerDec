package net.minecraft;

public class bap extends atr {

	public bap() {
		super(bof.p);
		this.a(akf.b);
	}

	public brt a(World var1, dt var2, bec var3) {
		float var4 = 0.125F;
		return new brt((double) var2.n(), (double) var2.o(), (double) var2.p(), (double) (var2.n() + 1), (double) ((float) (var2.o() + 1) - var4), (double) (var2.p() + 1));
	}

	public void a(World var1, dt var2, bec var3, Entity var4) {
		var4.v *= 0.4D;
		var4.x *= 0.4D;
	}
}
