package net.minecraft;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;

public class wp {

	public static final wp[] a = new wp[32];
	private static final Map I = Maps.newHashMap();
	public static final wp b = null;
	public static final wp c = (new wp(1, new oa("speed"), false, 8171462)).c("potion.moveSpeed").b(0, 0).a(afs.d, "91AEAA56-376B-4498-935B-2F7F68070635", 0.20000000298023224D, 2);
	public static final wp d = (new wp(2, new oa("slowness"), true, 5926017)).c("potion.moveSlowdown").b(1, 0).a(afs.d, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.15000000596046448D, 2);
	public static final wp e = (new wp(3, new oa("haste"), false, 14270531)).c("potion.digSpeed").b(2, 0).a(1.5D);
	public static final wp f = (new wp(4, new oa("mining_fatigue"), true, 4866583)).c("potion.digSlowDown").b(3, 0);
	public static final wp g = (new wm(5, new oa("strength"), false, 9643043)).c("potion.damageBoost").b(4, 0).a(afs.e, "648D7064-6A60-4F59-8ABE-C2C23A6DD7A9", 2.5D, 2);
	public static final wp h = (new wo(6, new oa("instant_health"), false, 16262179)).c("potion.heal");
	public static final wp i = (new wo(7, new oa("instant_damage"), true, 4393481)).c("potion.harm");
	public static final wp j = (new wp(8, new oa("jump_boost"), false, 2293580)).c("potion.jump").b(2, 1);
	public static final wp k = (new wp(9, new oa("nausea"), true, 5578058)).c("potion.confusion").b(3, 1).a(0.25D);
	public static final wp l = (new wp(10, new oa("regeneration"), false, 13458603)).c("potion.regeneration").b(7, 0).a(0.25D);
	public static final wp m = (new wp(11, new oa("resistance"), false, 10044730)).c("potion.resistance").b(6, 1);
	public static final wp n = (new wp(12, new oa("fire_resistance"), false, 14981690)).c("potion.fireResistance").b(7, 1);
	public static final wp o = (new wp(13, new oa("water_breathing"), false, 3035801)).c("potion.waterBreathing").b(0, 2);
	public static final wp p = (new wp(14, new oa("invisibility"), false, 8356754)).c("potion.invisibility").b(0, 1);
	public static final wp q = (new wp(15, new oa("blindness"), true, 2039587)).c("potion.blindness").b(5, 1).a(0.25D);
	public static final wp r = (new wp(16, new oa("night_vision"), false, 2039713)).c("potion.nightVision").b(4, 1);
	public static final wp s = (new wp(17, new oa("hunger"), true, 5797459)).c("potion.hunger").b(1, 1);
	public static final wp t = (new wm(18, new oa("weakness"), true, 4738376)).c("potion.weakness").b(5, 0).a(afs.e, "22653B89-116E-49DC-9B6B-9971489B5BE5", 2.0D, 0);
	public static final wp u = (new wp(19, new oa("poison"), true, 5149489)).c("potion.poison").b(6, 0).a(0.25D);
	public static final wp v = (new wp(20, new oa("wither"), true, 3484199)).c("potion.wither").b(1, 2).a(0.25D);
	public static final wp w = (new wn(21, new oa("health_boost"), false, 16284963)).c("potion.healthBoost").b(2, 2).a(afs.a, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CC", 4.0D, 0);
	public static final wp x = (new wl(22, new oa("absorption"), false, 2445989)).c("potion.absorption").b(2, 2);
	public static final wp y = (new wo(23, new oa("saturation"), false, 16262179)).c("potion.saturation");
	public static final wp z = null;
	public static final wp A = null;
	public static final wp B = null;
	public static final wp C = null;
	public static final wp D = null;
	public static final wp E = null;
	public static final wp F = null;
	public static final wp G = null;
	public final int H;
	private final Map J = Maps.newHashMap();
	private final boolean K;
	private final int L;
	private String M = "";
	private int N = -1;
	private double O;
	private boolean P;

	protected wp(int var1, oa var2, boolean var3, int var4) {
		this.H = var1;
		a[var1] = this;
		I.put(var2, this);
		this.K = var3;
		if (var3) {
			this.O = 0.5D;
		} else {
			this.O = 1.0D;
		}

		this.L = var4;
	}

	public static wp b(String var0) {
		return (wp) I.get(new oa(var0));
	}

	public static String[] c() {
		String[] var0 = new String[I.size()];
		int var1 = 0;

		oa var3;
		for (Iterator var2 = I.keySet().iterator(); var2.hasNext(); var0[var1++] = var3.toString()) {
			var3 = (oa) var2.next();
		}

		return var0;
	}

	protected wp b(int var1, int var2) {
		this.N = var1 + var2 * 8;
		return this;
	}

	public int d() {
		return this.H;
	}

	public void a(EntityLiving var1, int var2) {
		if (this.H == l.H) {
			if (var1.bm() < var1.bt()) {
				var1.g(1.0F);
			}
		} else if (this.H == u.H) {
			if (var1.bm() > 1.0F) {
				var1.a(wh.l, 1.0F);
			}
		} else if (this.H == v.H) {
			var1.a(wh.m, 1.0F);
		} else if (this.H == s.H && var1 instanceof ahd) {
			((ahd) var1).a(0.025F * (float) (var2 + 1));
		} else if (this.H == y.H && var1 instanceof ahd) {
			if (!var1.o.D) {
				((ahd) var1).ck().a(var2 + 1, 1.0F);
			}
		} else if ((this.H != h.H || var1.bl()) && (this.H != i.H || !var1.bl())) {
			if (this.H == i.H && !var1.bl() || this.H == h.H && var1.bl()) {
				var1.a(wh.l, (float) (6 << var2));
			}
		} else {
			var1.g((float) Math.max(4 << var2, 0));
		}

	}

	public void a(Entity var1, Entity var2, EntityLiving var3, int var4, double var5) {
		int var7;
		if ((this.H != h.H || var3.bl()) && (this.H != i.H || !var3.bl())) {
			if (this.H == i.H && !var3.bl() || this.H == h.H && var3.bl()) {
				var7 = (int) (var5 * (double) (6 << var4) + 0.5D);
				if (var1 == null) {
					var3.a(wh.l, (float) var7);
				} else {
					var3.a(wh.b(var1, var2), (float) var7);
				}
			}
		} else {
			var7 = (int) (var5 * (double) (4 << var4) + 0.5D);
			var3.g((float) var7);
		}

	}

	public boolean b() {
		return false;
	}

	public boolean a(int var1, int var2) {
		int var3;
		if (this.H == l.H) {
			var3 = 50 >> var2;
			return var3 > 0 ? var1 % var3 == 0 : true;
		} else if (this.H == u.H) {
			var3 = 25 >> var2;
			return var3 > 0 ? var1 % var3 == 0 : true;
		} else if (this.H == v.H) {
			var3 = 40 >> var2;
			return var3 > 0 ? var1 % var3 == 0 : true;
		} else {
			return this.H == s.H;
		}
	}

	public wp c(String var1) {
		this.M = var1;
		return this;
	}

	public String a() {
		return this.M;
	}

	protected wp a(double var1) {
		this.O = var1;
		return this;
	}

	public double h() {
		return this.O;
	}

	public boolean j() {
		return this.P;
	}

	public int k() {
		return this.L;
	}

	public wp a(xy var1, String var2, double var3, int var5) {
		ya var6 = new ya(UUID.fromString(var2), this.a(), var3, var5);
		this.J.put(var1, var6);
		return this;
	}

	public void a(EntityLiving var1, yc var2, int var3) {
		Iterator var4 = this.J.entrySet().iterator();

		while (var4.hasNext()) {
			Entry var5 = (Entry) var4.next();
			xz var6 = var2.a((xy) var5.getKey());
			if (var6 != null) {
				var6.c((ya) var5.getValue());
			}
		}

	}

	public void b(EntityLiving var1, yc var2, int var3) {
		Iterator var4 = this.J.entrySet().iterator();

		while (var4.hasNext()) {
			Entry var5 = (Entry) var4.next();
			xz var6 = var2.a((xy) var5.getKey());
			if (var6 != null) {
				ya var7 = (ya) var5.getValue();
				var6.c(var7);
				var6.b(new ya(var7.a(), this.a() + " " + var3, this.a(var3, var7), var7.c()));
			}
		}

	}

	public double a(int var1, ya var2) {
		return var2.d() * (double) (var1 + 1);
	}

}
