package net.minecraft;

import java.io.PrintStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class od {

	private static final PrintStream a = System.out;
	private static boolean b = false;
	private static final Logger c = LogManager.getLogger();

	public static boolean a() {
		return b;
	}

	static void b() {
		BlockDispenser.M.a(amk.g, new oe());
		BlockDispenser.M.a(amk.aP, new on());
		BlockDispenser.M.a(amk.aD, new oo());
		BlockDispenser.M.a(amk.bK, new op());
		BlockDispenser.M.a(amk.bz, new oq());
		BlockDispenser.M.a(amk.bJ, new os());
		BlockDispenser.M.a(amk.cb, new ot());
		BlockDispenser.M.a(amk.bL, new ou());
		BlockDispenser.M.a(amk.aE, new ov());
		of var0 = new of();
		BlockDispenser.M.a(amk.ay, var0);
		BlockDispenser.M.a(amk.ax, var0);
		BlockDispenser.M.a(amk.aw, new og());
		BlockDispenser.M.a(amk.d, new oh());
		BlockDispenser.M.a(amk.aW, new oi());
		BlockDispenser.M.a(Item.getItemOf(aty.W), new oj());
		BlockDispenser.M.a(amk.bX, new ok());
		BlockDispenser.M.a(Item.getItemOf(aty.aU), new ol());
		BlockDispenser.M.a(Item.getItemOf(aty.bX), new om());
	}

	public static void c() {
		if (!b) {
			b = true;
			if (c.isDebugEnabled()) {
				d();
			}

			Block.registerBlocks();
			BlockFire.j();
			Item.t();
			StatisticList.a();
			b();
		}
	}

	private static void d() {
		System.setErr(new pc("STDERR", System.err));
		System.setOut(new pc("STDOUT", a));
	}

}
