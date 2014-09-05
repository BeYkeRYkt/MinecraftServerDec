package net.minecraft;

public class wh {

	public static wh a = (new wh("inFire")).n();
	public static wh b = new wh("lightningBolt");
	public static wh c = (new wh("onFire")).k().n();
	public static wh d = (new wh("lava")).n();
	public static wh e = (new wh("inWall")).k();
	public static wh f = (new wh("drown")).k();
	public static wh g = (new wh("starve")).k().m();
	public static wh h = new wh("cactus");
	public static wh i = (new wh("fall")).k();
	public static wh j = (new wh("outOfWorld")).k().l();
	public static wh k = (new wh("generic")).k();
	public static wh l = (new wh("magic")).k().t();
	public static wh m = (new wh("wither")).k();
	public static wh n = new wh("anvil");
	public static wh o = new wh("fallingBlock");
	private boolean q;
	private boolean r;
	private boolean s;
	private float t = 0.3F;
	private boolean u;
	private boolean v;
	private boolean w;
	private boolean x;
	private boolean y;
	public String p;

	public static wh a(EntityLiving var0) {
		return new wi("mob", var0);
	}

	public static wh a(EntityHuman var0) {
		return new wi("player", var0);
	}

	public static wh a(EntityArrow var0, Entity var1) {
		return (new wj("arrow", var0, var1)).b();
	}

	public static wh a(ahl var0, Entity var1) {
		return var1 == null ? (new wj("onFire", var0, var0)).n().b() : (new wj("fireball", var0, var1)).n().b();
	}

	public static wh a(Entity var0, Entity var1) {
		return (new wj("thrown", var0, var1)).b();
	}

	public static wh b(Entity var0, Entity var1) {
		return (new wj("indirectMagic", var0, var1)).k().t();
	}

	public static wh a(Entity var0) {
		return (new wi("thorns", var0)).v().t();
	}

	public static wh a(aqo var0) {
		return var0 != null && var0.c() != null ? (new wi("explosion.player", var0.c())).q().d() : (new wh("explosion")).q().d();
	}

	public boolean a() {
		return this.v;
	}

	public wh b() {
		this.v = true;
		return this;
	}

	public boolean c() {
		return this.y;
	}

	public wh d() {
		this.y = true;
		return this;
	}

	public boolean e() {
		return this.q;
	}

	public float f() {
		return this.t;
	}

	public boolean g() {
		return this.r;
	}

	public boolean h() {
		return this.s;
	}

	protected wh(String var1) {
		this.p = var1;
	}

	public Entity i() {
		return this.j();
	}

	public Entity j() {
		return null;
	}

	protected wh k() {
		this.q = true;
		this.t = 0.0F;
		return this;
	}

	protected wh l() {
		this.r = true;
		return this;
	}

	protected wh m() {
		this.s = true;
		this.t = 0.0F;
		return this;
	}

	protected wh n() {
		this.u = true;
		return this;
	}

	public IJSONComponent b(EntityLiving var1) {
		EntityLiving var2 = var1.bs();
		String var3 = "death.attack." + this.p;
		String var4 = var3 + ".player";
		return var2 != null && fi.c(var4) ? new hz(var4, new Object[] { var1.e_(), var2.e_() }) : new hz(var3, new Object[] { var1.e_() });
	}

	public boolean o() {
		return this.u;
	}

	public String p() {
		return this.p;
	}

	public wh q() {
		this.w = true;
		return this;
	}

	public boolean r() {
		return this.w;
	}

	public boolean s() {
		return this.x;
	}

	public wh t() {
		this.x = true;
		return this;
	}

	public boolean u() {
		Entity var1 = this.j();
		return var1 instanceof EntityHuman && ((EntityHuman) var1).by.instabuild;
	}

}
