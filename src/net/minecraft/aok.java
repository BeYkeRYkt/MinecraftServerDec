package net.minecraft;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class aok {

	private static final aok a = new aok();
	private Map b = Maps.newHashMap();
	private Map c = Maps.newHashMap();

	public static aok a() {
		return a;
	}

	private aok() {
		this.a(aty.p, new amj(amk.j), 0.7F);
		this.a(aty.o, new amj(amk.k), 1.0F);
		this.a(aty.ag, new amj(amk.i), 1.0F);
		this.a((atr) aty.m, new amj(aty.w), 0.1F);
		this.a(amk.al, new amj(amk.am), 0.35F);
		this.a(amk.bi, new amj(amk.bj), 0.35F);
		this.a(amk.bk, new amj(amk.bl), 0.35F);
		this.a(amk.bo, new amj(amk.bp), 0.35F);
		this.a(amk.bm, new amj(amk.bn), 0.35F);
		this.a(aty.e, new amj(aty.b), 0.1F);
		this.a(new amj(aty.bf, 1, bbc.b), new amj(aty.bf, 1, bbc.N), 0.1F);
		this.a(amk.aI, new amj(amk.aH), 0.3F);
		this.a(aty.aL, new amj(aty.cz), 0.35F);
		this.a((atr) aty.aK, new amj(amk.aW, 1, akv.n.b()), 0.2F);
		this.a(aty.r, new amj(amk.h, 1, 1), 0.15F);
		this.a(aty.s, new amj(amk.h, 1, 1), 0.15F);
		this.a(aty.bP, new amj(amk.bO), 1.0F);
		this.a(amk.bS, new amj(amk.bT), 0.35F);
		this.a(aty.aV, new amj(amk.cf), 0.1F);
		this.a(new amj(aty.v, 1, 1), new amj(aty.v, 1, 0), 0.15F);
		ali[] var1 = ali.values();
		int var2 = var1.length;

		for (int var3 = 0; var3 < var2; ++var3) {
			ali var4 = var1[var3];
			if (var4.g()) {
				this.a(new amj(amk.aU, 1, var4.a()), new amj(amk.aV, 1, var4.a()), 0.35F);
			}
		}

		this.a(aty.q, new amj(amk.h), 0.1F);
		this.a(aty.aC, new amj(amk.aC), 0.7F);
		this.a(aty.x, new amj(amk.aW, 1, akv.l.b()), 0.2F);
		this.a(aty.co, new amj(amk.cg), 0.2F);
	}

	public void a(atr var1, amj var2, float var3) {
		this.a(alq.a(var1), var2, var3);
	}

	public void a(alq var1, amj var2, float var3) {
		this.a(new amj(var1, 1, 32767), var2, var3);
	}

	public void a(amj var1, amj var2, float var3) {
		this.b.put(var1, var2);
		this.c.put(var2, Float.valueOf(var3));
	}

	public amj a(amj var1) {
		Iterator var2 = this.b.entrySet().iterator();

		Entry var3;
		do {
			if (!var2.hasNext()) {
				return null;
			}

			var3 = (Entry) var2.next();
		} while (!this.a(var1, (amj) var3.getKey()));

		return (amj) var3.getValue();
	}

	private boolean a(amj var1, amj var2) {
		return var2.b() == var1.b() && (var2.i() == 32767 || var2.i() == var1.i());
	}

	public Map b() {
		return this.b;
	}

	public float b(amj var1) {
		Iterator var2 = this.c.entrySet().iterator();

		Entry var3;
		do {
			if (!var2.hasNext()) {
				return 0.0F;
			}

			var3 = (Entry) var2.next();
		} while (!this.a(var1, (amj) var3.getKey()));

		return ((Float) var3.getValue()).floatValue();
	}

}
