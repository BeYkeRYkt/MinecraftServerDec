package net.minecraft;

public class DamageSource {

	public static DamageSource FIRE = (new DamageSource("inFire")).n();
	public static DamageSource LIGHTNING = new DamageSource("lightningBolt");
	public static DamageSource BURN = (new DamageSource("onFire")).k().n();
	public static DamageSource LAVA = (new DamageSource("lava")).n();
	public static DamageSource STUCK = (new DamageSource("inWall")).k();
	public static DamageSource DROWN = (new DamageSource("drown")).k();
	public static DamageSource STARVE = (new DamageSource("starve")).k().m();
	public static DamageSource CACTUS = new DamageSource("cactus");
	public static DamageSource FALL = (new DamageSource("fall")).k();
	public static DamageSource OUT_OF_WORLD = (new DamageSource("outOfWorld")).k().l();
	public static DamageSource GENERIC = (new DamageSource("generic")).k();
	public static DamageSource MAGIC = (new DamageSource("magic")).k().t();
	public static DamageSource WITHER = (new DamageSource("wither")).k();
	public static DamageSource ANVIL = new DamageSource("anvil");
	public static DamageSource FALLING_BLOCK = new DamageSource("fallingBlock");
	private boolean q;
	private boolean r;
	private boolean s;
	private float t = 0.3F;
	private boolean u;
	private boolean v;
	private boolean w;
	private boolean x;
	private boolean y;
	public String translationIndex;

	public static DamageSource mobAttack(EntityLiving var0) {
		return new EntityDamageSource("mob", var0);
	}

	public static DamageSource playerAttack(EntityHuman var0) {
		return new EntityDamageSource("player", var0);
	}

	public static DamageSource arrow(EntityArrow var0, Entity var1) {
		return (new EntityDamageSourceIndirect("arrow", var0, var1)).b();
	}

	public static DamageSource fireball(EntityFireball var0, Entity var1) {
		return var1 == null ? (new EntityDamageSourceIndirect("onFire", var0, var0)).n().b() : (new EntityDamageSourceIndirect("fireball", var0, var1)).n().b();
	}

	public static DamageSource projectile(Entity var0, Entity var1) {
		return (new EntityDamageSourceIndirect("thrown", var0, var1)).b();
	}

	public static DamageSource magic(Entity var0, Entity var1) {
		return (new EntityDamageSourceIndirect("indirectMagic", var0, var1)).k().t();
	}

	public static DamageSource thorns(Entity var0) {
		return (new EntityDamageSource("thorns", var0)).v().t();
	}

	public static DamageSource explosion(Explosion var0) {
		return var0 != null && var0.getIgniter() != null ? (new EntityDamageSource("explosion.player", var0.getIgniter())).q().d() : (new DamageSource("explosion")).q().d();
	}

	public boolean a() {
		return this.v;
	}

	public DamageSource b() {
		this.v = true;
		return this;
	}

	public boolean c() {
		return this.y;
	}

	public DamageSource d() {
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

	protected DamageSource(String var1) {
		this.translationIndex = var1;
	}

	public Entity i() {
		return this.getDamager();
	}

	public Entity getDamager() {
		return null;
	}

	protected DamageSource k() {
		this.q = true;
		this.t = 0.0F;
		return this;
	}

	protected DamageSource l() {
		this.r = true;
		return this;
	}

	protected DamageSource m() {
		this.s = true;
		this.t = 0.0F;
		return this;
	}

	protected DamageSource n() {
		this.u = true;
		return this;
	}

	public IChatBaseComponent getLocalizedDeathMessage(EntityLiving entityLiving) {
		EntityLiving killer = entityLiving.getKiller();
		String message = "death.attack." + this.translationIndex;
		String messageWithKiller = message + ".player";
		return killer != null && LocaleI18n.c(messageWithKiller) ? new ChatMessage(messageWithKiller, new Object[] { entityLiving.getComponentName(), killer.getComponentName() }) : new ChatMessage(message, new Object[] { entityLiving.getComponentName() });
	}

	public boolean o() {
		return this.u;
	}

	public String p() {
		return this.translationIndex;
	}

	public DamageSource q() {
		this.w = true;
		return this;
	}

	public boolean r() {
		return this.w;
	}

	public boolean s() {
		return this.x;
	}

	public DamageSource t() {
		this.x = true;
		return this;
	}

	public boolean u() {
		Entity var1 = this.getDamager();
		return var1 instanceof EntityHuman && ((EntityHuman) var1).playerProperties.instabuild;
	}

}
