package net.minecraft;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.concurrent.Callable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class bcm {

	private static final Logger a = LogManager.getLogger();
	private static Map f = Maps.newHashMap();
	private static Map g = Maps.newHashMap();
	protected World b;
	protected dt c;
	protected boolean d;
	private int h;
	protected atr e;

	public bcm() {
		this.c = dt.a;
		this.h = -1;
	}

	private static void a(Class var0, String var1) {
		if (f.containsKey(var1)) {
			throw new IllegalArgumentException("Duplicate id: " + var1);
		} else {
			f.put(var1, var0);
			g.put(var0, var1);
		}
	}

	public World z() {
		return this.b;
	}

	public void a(World var1) {
		this.b = var1;
	}

	public boolean t() {
		return this.b != null;
	}

	public void a(NBTCompoundTag var1) {
		this.c = new dt(var1.f("x"), var1.f("y"), var1.f("z"));
	}

	public void b(NBTCompoundTag var1) {
		String var2 = (String) g.get(this.getClass());
		if (var2 == null) {
			throw new RuntimeException(this.getClass() + " is missing a mapping! This is a bug!");
		} else {
			var1.put("id", var2);
			var1.put("x", this.c.n());
			var1.put("y", this.c.o());
			var1.put("z", this.c.p());
		}
	}

	public static bcm c(NBTCompoundTag var0) {
		bcm var1 = null;

		try {
			Class var2 = (Class) f.get(var0.j("id"));
			if (var2 != null) {
				var1 = (bcm) var2.newInstance();
			}
		} catch (Exception var3) {
			var3.printStackTrace();
		}

		if (var1 != null) {
			var1.a(var0);
		} else {
			a.warn("Skipping BlockEntity with id " + var0.j("id"));
		}

		return var1;
	}

	public int u() {
		if (this.h == -1) {
			bec var1 = this.b.p(this.c);
			this.h = var1.c().c(var1);
		}

		return this.h;
	}

	public void o_() {
		if (this.b != null) {
			bec var1 = this.b.p(this.c);
			this.h = var1.c().c(var1);
			this.b.b(this.c, this);
			if (this.w() != aty.a) {
				this.b.e(this.c, this.w());
			}
		}

	}

	public dt v() {
		return this.c;
	}

	public atr w() {
		if (this.e == null) {
			this.e = this.b.p(this.c).c();
		}

		return this.e;
	}

	public id x_() {
		return null;
	}

	public boolean x() {
		return this.d;
	}

	public void y() {
		this.d = true;
	}

	public void D() {
		this.d = false;
	}

	public boolean c(int var1, int var2) {
		return false;
	}

	public void E() {
		this.e = null;
		this.h = -1;
	}

	public void a(j var1) {
		var1.a("Name", (Callable) (new bcn(this)));
		if (this.b != null) {
			j.a(var1, this.c, this.w(), this.u());
			var1.a("Actual block type", (Callable) (new bco(this)));
			var1.a("Actual block data value", (Callable) (new bcp(this)));
		}
	}

	public void a(dt var1) {
		this.c = var1;
	}

	// $FF: synthetic method
	static Map F() {
		return g;
	}

	static {
		a(bdc.class, "Furnace");
		a(bcr.class, "Chest");
		a(bda.class, "EnderChest");
		a(axd.class, "RecordPlayer");
		a(bcx.class, "Trap");
		a(bcy.class, "Dropper");
		a(bdj.class, "Sign");
		a(bdg.class, "MobSpawner");
		a(bdi.class, "Music");
		a(bdv.class, "Piston");
		a(bcq.class, "Cauldron");
		a(bcz.class, "EnchantTable");
		a(bdn.class, "Airportal");
		a(bct.class, "Control");
		a(bck.class, "Beacon");
		a(bdm.class, "Skull");
		a(bcw.class, "DLDetector");
		a(bde.class, "Hopper");
		a(bcv.class, "Comparator");
		a(bdb.class, "FlowerPot");
		a(bci.class, "Banner");
	}
}
