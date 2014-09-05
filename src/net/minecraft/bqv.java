package net.minecraft;

import java.util.concurrent.Callable;

class bqv implements Callable {

	// $FF: synthetic field
	final WorldData a;

	bqv(WorldData var1) {
		this.a = var1;
	}

	public String a() {
		String var1 = "Unknown?";

		try {
			switch (WorldData.j(this.a)) {
				case 19132:
					var1 = "McRegion";
					break;
				case 19133:
					var1 = "Anvil";
			}
		} catch (Throwable var3) {
			;
		}

		return String.format("0x%05X - %s", new Object[] { Integer.valueOf(WorldData.j(this.a)), var1 });
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
