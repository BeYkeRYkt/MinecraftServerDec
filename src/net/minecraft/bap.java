package net.minecraft;

public class bap extends Block {

	public bap() {
		super(bof.p);
		this.a(CreativeModeTab.b);
	}

	public brt a(World var1, Position var2, bec var3) {
		float var4 = 0.125F;
		return new brt((double) var2.n(), (double) var2.o(), (double) var2.p(), (double) (var2.n() + 1), (double) ((float) (var2.o() + 1) - var4), (double) (var2.p() + 1));
	}

	public void a(World var1, Position var2, bec var3, Entity var4) {
		var4.motionX *= 0.4D;
		var4.motionZ *= 0.4D;
	}
}
