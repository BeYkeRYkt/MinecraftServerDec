package net.minecraft;

import net.minecraft.server.MinecraftServer;

public class ro implements na {

	private final MinecraftServer a;
	private final gr b;

	public ro(MinecraftServer var1, gr var2) {
		this.a = var1;
		this.b = var2;
	}

	public void a(mz var1) {
		switch (rp.a[var1.a().ordinal()]) {
			case 1:
				this.b.a(EnumProtocol.d);
				hy var2;
				if (var1.b() > 47) {
					var2 = new hy("Outdated server! I\'m still on 1.8");
					this.b.a((id) (new ng(var2)));
					this.b.a((ho) var2);
				} else if (var1.b() < 47) {
					var2 = new hy("Outdated client! Please use 1.8");
					this.b.a((id) (new ng(var2)));
					this.b.a((ho) var2);
				} else {
					this.b.a((hg) (new rq(this.a, this.b)));
				}
				break;
			case 2:
				this.b.a(EnumProtocol.c);
				this.b.a((hg) (new ru(this.a, this.b)));
				break;
			default:
				throw new UnsupportedOperationException("Invalid intention " + var1.a());
		}

	}

	public void a(ho var1) {
	}
}
