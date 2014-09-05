package net.minecraft;

class so implements bez {

	// $FF: synthetic field
	final PlayerList a;

	so(PlayerList var1) {
		this.a = var1;
	}

	public void a(bfb var1, double var2) {
		this.a.sendPacket((Packet) (new kr(var1, kt.a)));
	}

	public void a(bfb var1, double var2, double var4, long var6) {
		this.a.sendPacket((Packet) (new kr(var1, kt.b)));
	}

	public void a(bfb var1, double var2, double var4) {
		this.a.sendPacket((Packet) (new kr(var1, kt.c)));
	}

	public void a(bfb var1, int var2) {
		this.a.sendPacket((Packet) (new kr(var1, kt.e)));
	}

	public void b(bfb var1, int var2) {
		this.a.sendPacket((Packet) (new kr(var1, kt.f)));
	}

	public void b(bfb var1, double var2) {
	}

	public void c(bfb var1, double var2) {
	}
}
