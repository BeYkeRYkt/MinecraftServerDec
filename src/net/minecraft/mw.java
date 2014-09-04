package net.minecraft;

import java.util.UUID;

public class mw implements id<ls> {

	private UUID a;

	public mw() {
	}

	public mw(UUID var1) {
		this.a = var1;
	}

	public void a(hd var1) {
		this.a = var1.g();
	}

	public void b(hd var1) {
		var1.a(this.a);
	}

	public void a(ls var1) {
		var1.a(this);
	}

	public Entity a(WorldServer var1) {
		return var1.a(this.a);
	}
}
