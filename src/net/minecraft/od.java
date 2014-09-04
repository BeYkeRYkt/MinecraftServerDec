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
		ave.M.a(amk.g, new oe());
		ave.M.a(amk.aP, new on());
		ave.M.a(amk.aD, new oo());
		ave.M.a(amk.bK, new op());
		ave.M.a(amk.bz, new oq());
		ave.M.a(amk.bJ, new os());
		ave.M.a(amk.cb, new ot());
		ave.M.a(amk.bL, new ou());
		ave.M.a(amk.aE, new ov());
		of var0 = new of();
		ave.M.a(amk.ay, var0);
		ave.M.a(amk.ax, var0);
		ave.M.a(amk.aw, new og());
		ave.M.a(amk.d, new oh());
		ave.M.a(amk.aW, new oi());
		ave.M.a(alq.a(aty.W), new oj());
		ave.M.a(amk.bX, new ok());
		ave.M.a(alq.a(aty.aU), new ol());
		ave.M.a(alq.a(aty.bX), new om());
	}

	public static void c() {
		if (!b) {
			b = true;
			if (c.isDebugEnabled()) {
				d();
			}

			atr.R();
			avx.j();
			alq.t();
			ty.a();
			b();
		}
	}

	private static void d() {
		System.setErr(new pc("STDERR", System.err));
		System.setOut(new pc("STDOUT", a));
	}

}
