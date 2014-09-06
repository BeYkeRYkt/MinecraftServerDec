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
		BlockDispenser.M.a(Items.g, new oe());
		BlockDispenser.M.a(Items.aP, new on());
		BlockDispenser.M.a(Items.aD, new oo());
		BlockDispenser.M.a(Items.bK, new op());
		BlockDispenser.M.a(Items.bz, new oq());
		BlockDispenser.M.a(Items.bJ, new os());
		BlockDispenser.M.a(Items.cb, new ot());
		BlockDispenser.M.a(Items.bL, new ou());
		BlockDispenser.M.a(Items.aE, new ov());
		of var0 = new of();
		BlockDispenser.M.a(Items.ay, var0);
		BlockDispenser.M.a(Items.ax, var0);
		BlockDispenser.M.a(Items.aw, new og());
		BlockDispenser.M.a(Items.d, new oh());
		BlockDispenser.M.a(Items.aW, new oi());
		BlockDispenser.M.a(Item.getItemOf(Blocks.TNT), new oj());
		BlockDispenser.M.a(Items.bX, new ok());
		BlockDispenser.M.a(Item.getItemOf(Blocks.aU), new ol());
		BlockDispenser.M.a(Item.getItemOf(Blocks.bX), new om());
	}

	public static void c() {
		if (!b) {
			b = true;
			if (c.isDebugEnabled()) {
				d();
			}

			Block.registerBlocks();
			BlockFire.j();
			Item.registerItems();
			StatisticList.a();
			b();
		}
	}

	private static void d() {
		System.setErr(new pc("STDERR", System.err));
		System.setOut(new pc("STDOUT", a));
	}

}
