package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ty {

	protected static Map a = Maps.newHashMap();
	public static List b = Lists.newArrayList();
	public static List c = Lists.newArrayList();
	public static List d = Lists.newArrayList();
	public static List e = Lists.newArrayList();
	public static PlayerStatistic f = (new tn("stat.leaveGame", new hz("stat.leaveGame", new Object[0]))).i().h();
	public static PlayerStatistic g = (new tn("stat.playOneMinute", new hz("stat.playOneMinute", new Object[0]), PlayerStatistic.h)).i().h();
	public static PlayerStatistic h = (new tn("stat.timeSinceDeath", new hz("stat.timeSinceDeath", new Object[0]), PlayerStatistic.h)).i().h();
	public static PlayerStatistic i = (new tn("stat.walkOneCm", new hz("stat.walkOneCm", new Object[0]), PlayerStatistic.i)).i().h();
	public static PlayerStatistic j = (new tn("stat.crouchOneCm", new hz("stat.crouchOneCm", new Object[0]), PlayerStatistic.i)).i().h();
	public static PlayerStatistic k = (new tn("stat.sprintOneCm", new hz("stat.sprintOneCm", new Object[0]), PlayerStatistic.i)).i().h();
	public static PlayerStatistic l = (new tn("stat.swimOneCm", new hz("stat.swimOneCm", new Object[0]), PlayerStatistic.i)).i().h();
	public static PlayerStatistic m = (new tn("stat.fallOneCm", new hz("stat.fallOneCm", new Object[0]), PlayerStatistic.i)).i().h();
	public static PlayerStatistic n = (new tn("stat.climbOneCm", new hz("stat.climbOneCm", new Object[0]), PlayerStatistic.i)).i().h();
	public static PlayerStatistic o = (new tn("stat.flyOneCm", new hz("stat.flyOneCm", new Object[0]), PlayerStatistic.i)).i().h();
	public static PlayerStatistic p = (new tn("stat.diveOneCm", new hz("stat.diveOneCm", new Object[0]), PlayerStatistic.i)).i().h();
	public static PlayerStatistic q = (new tn("stat.minecartOneCm", new hz("stat.minecartOneCm", new Object[0]), PlayerStatistic.i)).i().h();
	public static PlayerStatistic r = (new tn("stat.boatOneCm", new hz("stat.boatOneCm", new Object[0]), PlayerStatistic.i)).i().h();
	public static PlayerStatistic s = (new tn("stat.pigOneCm", new hz("stat.pigOneCm", new Object[0]), PlayerStatistic.i)).i().h();
	public static PlayerStatistic t = (new tn("stat.horseOneCm", new hz("stat.horseOneCm", new Object[0]), PlayerStatistic.i)).i().h();
	public static PlayerStatistic u = (new tn("stat.jump", new hz("stat.jump", new Object[0]))).i().h();
	public static PlayerStatistic v = (new tn("stat.drop", new hz("stat.drop", new Object[0]))).i().h();
	public static PlayerStatistic w = (new tn("stat.damageDealt", new hz("stat.damageDealt", new Object[0]), PlayerStatistic.j)).h();
	public static PlayerStatistic x = (new tn("stat.damageTaken", new hz("stat.damageTaken", new Object[0]), PlayerStatistic.j)).h();
	public static PlayerStatistic y = (new tn("stat.deaths", new hz("stat.deaths", new Object[0]))).h();
	public static PlayerStatistic z = (new tn("stat.mobKills", new hz("stat.mobKills", new Object[0]))).h();
	public static PlayerStatistic A = (new tn("stat.animalsBred", new hz("stat.animalsBred", new Object[0]))).h();
	public static PlayerStatistic B = (new tn("stat.playerKills", new hz("stat.playerKills", new Object[0]))).h();
	public static PlayerStatistic C = (new tn("stat.fishCaught", new hz("stat.fishCaught", new Object[0]))).h();
	public static PlayerStatistic D = (new tn("stat.junkFished", new hz("stat.junkFished", new Object[0]))).h();
	public static PlayerStatistic E = (new tn("stat.treasureFished", new hz("stat.treasureFished", new Object[0]))).h();
	public static PlayerStatistic F = (new tn("stat.talkedToVillager", new hz("stat.talkedToVillager", new Object[0]))).h();
	public static PlayerStatistic G = (new tn("stat.tradedWithVillager", new hz("stat.tradedWithVillager", new Object[0]))).h();
	public static final PlayerStatistic[] H = new PlayerStatistic[4096];
	public static final PlayerStatistic[] I = new PlayerStatistic[32000];
	public static final PlayerStatistic[] J = new PlayerStatistic[32000];
	public static final PlayerStatistic[] K = new PlayerStatistic[32000];

	public static void a() {
		c();
		d();
		e();
		b();
		tl.a();
		xb.a();
	}

	private static void b() {
		HashSet var0 = Sets.newHashSet();
		Iterator var1 = aop.a().b().iterator();

		while (var1.hasNext()) {
			aoo var2 = (aoo) var1.next();
			if (var2.b() != null) {
				var0.add(var2.b().b());
			}
		}

		var1 = aok.a().b().values().iterator();

		while (var1.hasNext()) {
			amj var5 = (amj) var1.next();
			var0.add(var5.b());
		}

		var1 = var0.iterator();

		while (var1.hasNext()) {
			alq var6 = (alq) var1.next();
			if (var6 != null) {
				int var3 = alq.b(var6);
				String var4 = a(var6);
				if (var4 != null) {
					I[var3] = (new to("stat.craftItem.", var4, new hz("stat.craftItem", new Object[] { (new amj(var6)).C() }), var6)).h();
				}
			}
		}

		a(I);
	}

	private static void c() {
		Iterator var0 = atr.c.iterator();

		while (var0.hasNext()) {
			atr var1 = (atr) var0.next();
			alq var2 = alq.a(var1);
			if (var2 != null) {
				int var3 = atr.a(var1);
				String var4 = a(var2);
				if (var4 != null && var1.I()) {
					H[var3] = (new to("stat.mineBlock.", var4, new hz("stat.mineBlock", new Object[] { (new amj(var1)).C() }), var2)).h();
					e.add((to) H[var3]);
				}
			}
		}

		a(H);
	}

	private static void d() {
		Iterator var0 = alq.e.iterator();

		while (var0.hasNext()) {
			alq var1 = (alq) var0.next();
			if (var1 != null) {
				int var2 = alq.b(var1);
				String var3 = a(var1);
				if (var3 != null) {
					J[var2] = (new to("stat.useItem.", var3, new hz("stat.useItem", new Object[] { (new amj(var1)).C() }), var1)).h();
					if (!(var1 instanceof aju)) {
						d.add((to) J[var2]);
					}
				}
			}
		}

		a(J);
	}

	private static void e() {
		Iterator var0 = alq.e.iterator();

		while (var0.hasNext()) {
			alq var1 = (alq) var0.next();
			if (var1 != null) {
				int var2 = alq.b(var1);
				String var3 = a(var1);
				if (var3 != null && var1.m()) {
					K[var2] = (new to("stat.breakItem.", var3, new hz("stat.breakItem", new Object[] { (new amj(var1)).C() }), var1)).h();
				}
			}
		}

		a(K);
	}

	private static String a(alq var0) {
		oa var1 = (oa) alq.e.c(var0);
		return var1 != null ? var1.toString().replace(':', '.') : null;
	}

	private static void a(PlayerStatistic[] var0) {
		a(var0, aty.j, aty.i);
		a(var0, aty.l, aty.k);
		a(var0, aty.aZ, aty.aU);
		a(var0, aty.am, aty.al);
		a(var0, aty.aD, aty.aC);
		a(var0, aty.bc, aty.bb);
		a(var0, aty.ck, aty.cj);
		a(var0, aty.aF, aty.aE);
		a(var0, aty.bK, aty.bJ);
		a(var0, aty.T, aty.U);
		a(var0, aty.bL, aty.bM);
		a(var0, aty.cO, aty.cP);
		a(var0, aty.c, aty.d);
		a(var0, aty.ak, aty.d);
	}

	private static void a(PlayerStatistic[] var0, atr var1, atr var2) {
		int var3 = atr.a(var1);
		int var4 = atr.a(var2);
		if (var0[var3] != null && var0[var4] == null) {
			var0[var4] = var0[var3];
		} else {
			b.remove(var0[var3]);
			e.remove(var0[var3]);
			c.remove(var0[var3]);
			var0[var3] = var0[var4];
		}
	}

	public static PlayerStatistic a(xc var0) {
		String var1 = xb.b(var0.a);
		return var1 == null ? null : (new PlayerStatistic("stat.killEntity." + var1, new hz("stat.entityKill", new Object[] { new hz("entity." + var1 + ".name", new Object[0]) }))).h();
	}

	public static PlayerStatistic b(xc var0) {
		String var1 = xb.b(var0.a);
		return var1 == null ? null : (new PlayerStatistic("stat.entityKilledBy." + var1, new hz("stat.entityKilledBy", new Object[] { new hz("entity." + var1 + ".name", new Object[0]) }))).h();
	}

	public static PlayerStatistic a(String var0) {
		return (PlayerStatistic) a.get(var0);
	}

}
