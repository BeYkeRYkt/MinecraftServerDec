package net.minecraft;

final class atn implements Runnable {

	// $FF: synthetic field
	final World a;
	// $FF: synthetic field
	final Position b;

	atn(World var1, Position var2) {
		this.a = var1;
		this.b = var2;
	}

	public void run() {
		Chunk var1 = this.a.f(this.b);

		for (int var2 = this.b.o() - 1; var2 >= 0; --var2) {
			Position var3 = new Position(this.b.n(), var2, this.b.p());
			if (!var1.d(var3)) {
				break;
			}

			bec var4 = this.a.p(var3);
			if (var4.c() == aty.bY) {
				((WorldServer) this.a).a((Runnable) (new ato(this, var3)));
			}
		}

	}
}
