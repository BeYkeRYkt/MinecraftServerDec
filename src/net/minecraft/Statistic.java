package net.minecraft;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Statistic {

	public final String e;
	private final IJSONComponent a;
	public boolean f;
	private final tv b;
	private final bsk c;
	private Class d;
	private static NumberFormat k = NumberFormat.getIntegerInstance(Locale.US);
	public static tv g = new tr();
	private static DecimalFormat l = new DecimalFormat("########0.00");
	public static tv h = new ts();
	public static tv i = new tt();
	public static tv j = new tu();

	public Statistic(String var1, IJSONComponent var2, tv var3) {
		this.e = var1;
		this.a = var2;
		this.b = var3;
		this.c = new bsm(this);
		bsk.a.put(this.c.a(), this.c);
	}

	public Statistic(String var1, IJSONComponent var2) {
		this(var1, var2, g);
	}

	public Statistic i() {
		this.f = true;
		return this;
	}

	public Statistic h() {
		if (StatisticList.a.containsKey(this.e)) {
			throw new RuntimeException("Duplicate stat id: \"" + ((Statistic) StatisticList.a.get(this.e)).a + "\" and \"" + this.a + "\" at id " + this.e);
		} else {
			StatisticList.b.add(this);
			StatisticList.a.put(this.e, this);
			return this;
		}
	}

	public boolean d() {
		return false;
	}

	public IJSONComponent e() {
		IJSONComponent var1 = this.a.f();
		var1.b().a(FormattingCode.h);
		var1.b().a(new hr(hs.b, new hy(this.e)));
		return var1;
	}

	public IJSONComponent j() {
		IJSONComponent var1 = this.e();
		IJSONComponent var2 = (new hy("[")).a(var1).a("]");
		var2.a(var1.b());
		return var2;
	}

	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else if (var1 != null && this.getClass() == var1.getClass()) {
			Statistic var2 = (Statistic) var1;
			return this.e.equals(var2.e);
		} else {
			return false;
		}
	}

	public int hashCode() {
		return this.e.hashCode();
	}

	public String toString() {
		return "Stat{id=" + this.e + ", nameId=" + this.a + ", awardLocallyOnly=" + this.f + ", formatter=" + this.b + ", objectiveCriteria=" + this.c + '}';
	}

	public bsk k() {
		return this.c;
	}

	public Class l() {
		return this.d;
	}

	public Statistic b(Class var1) {
		this.d = var1;
		return this;
	}

}
