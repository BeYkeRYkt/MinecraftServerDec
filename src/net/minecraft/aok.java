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
		this.a(aty.p, new ItemStack(amk.j), 0.7F);
		this.a(aty.o, new ItemStack(amk.k), 1.0F);
		this.a(aty.ag, new ItemStack(amk.i), 1.0F);
		this.a((Block) aty.m, new ItemStack(aty.w), 0.1F);
		this.a(amk.al, new ItemStack(amk.am), 0.35F);
		this.a(amk.bi, new ItemStack(amk.bj), 0.35F);
		this.a(amk.bk, new ItemStack(amk.bl), 0.35F);
		this.a(amk.bo, new ItemStack(amk.bp), 0.35F);
		this.a(amk.bm, new ItemStack(amk.bn), 0.35F);
		this.a(aty.e, new ItemStack(aty.b), 0.1F);
		this.a(new ItemStack(aty.bf, 1, bbc.b), new ItemStack(aty.bf, 1, bbc.N), 0.1F);
		this.a(amk.aI, new ItemStack(amk.aH), 0.3F);
		this.a(aty.aL, new ItemStack(aty.cz), 0.35F);
		this.a((Block) aty.aK, new ItemStack(amk.aW, 1, akv.n.b()), 0.2F);
		this.a(aty.r, new ItemStack(amk.h, 1, 1), 0.15F);
		this.a(aty.s, new ItemStack(amk.h, 1, 1), 0.15F);
		this.a(aty.bP, new ItemStack(amk.bO), 1.0F);
		this.a(amk.bS, new ItemStack(amk.bT), 0.35F);
		this.a(aty.aV, new ItemStack(amk.cf), 0.1F);
		this.a(new ItemStack(aty.v, 1, 1), new ItemStack(aty.v, 1, 0), 0.15F);
		ali[] var1 = ali.values();
		int var2 = var1.length;

		for (int var3 = 0; var3 < var2; ++var3) {
			ali var4 = var1[var3];
			if (var4.g()) {
				this.a(new ItemStack(amk.aU, 1, var4.a()), new ItemStack(amk.aV, 1, var4.a()), 0.35F);
			}
		}

		this.a(aty.q, new ItemStack(amk.h), 0.1F);
		this.a(aty.aC, new ItemStack(amk.aC), 0.7F);
		this.a(aty.x, new ItemStack(amk.aW, 1, akv.l.b()), 0.2F);
		this.a(aty.co, new ItemStack(amk.cg), 0.2F);
	}

	public void a(Block var1, ItemStack var2, float var3) {
		this.a(Item.getItemOf(var1), var2, var3);
	}

	public void a(Item var1, ItemStack var2, float var3) {
		this.a(new ItemStack(var1, 1, 32767), var2, var3);
	}

	public void a(ItemStack var1, ItemStack var2, float var3) {
		this.b.put(var1, var2);
		this.c.put(var2, Float.valueOf(var3));
	}

	public ItemStack a(ItemStack var1) {
		Iterator var2 = this.b.entrySet().iterator();

		Entry var3;
		do {
			if (!var2.hasNext()) {
				return null;
			}

			var3 = (Entry) var2.next();
		} while (!this.a(var1, (ItemStack) var3.getKey()));

		return (ItemStack) var3.getValue();
	}

	private boolean a(ItemStack var1, ItemStack var2) {
		return var2.getItem() == var1.getItem() && (var2.i() == 32767 || var2.i() == var1.i());
	}

	public Map b() {
		return this.b;
	}

	public float b(ItemStack var1) {
		Iterator var2 = this.c.entrySet().iterator();

		Entry var3;
		do {
			if (!var2.hasNext()) {
				return 0.0F;
			}

			var3 = (Entry) var2.next();
		} while (!this.a(var1, (ItemStack) var3.getKey()));

		return ((Float) var3.getValue()).floatValue();
	}

}
