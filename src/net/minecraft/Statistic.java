package net.minecraft;

public class Statistic {

	public static Counter unknownCounter = new UnknownCounter();
	public static Counter timeCounter = new TimeCounter();
	public static Counter distancesCounter = new DistancesCounter();
	public static Counter damageCounter = new DamageCounter();

	public final String name;
	public boolean local;
	private final IChatBaseComponent nameId;
	private final Counter counter;
	private final IScoreboardCriteria criteria;
	private Class<IJsonStatistic> clazz;

	public Statistic(String var1, IChatBaseComponent var2, Counter var3) {
		this.name = var1;
		this.nameId = var2;
		this.counter = var3;
		this.criteria = new ScoreboardStatisticCriteria(this);
		IScoreboardCriteria.byName.put(this.criteria.getName(), this.criteria);
	}

	public Statistic(String var1, IChatBaseComponent var2) {
		this(var1, var2, unknownCounter);
	}

	public Statistic setLocal() {
		this.local = true;
		return this;
	}

	public Statistic register() {
		if (StatisticList.list.containsKey(this.name)) {
			throw new RuntimeException("Duplicate stat id: \"" + ((Statistic) StatisticList.list.get(this.name)).nameId + "\" and \"" + this.nameId + "\" at id " + this.name);
		} else {
			StatisticList.b.add(this);
			StatisticList.list.put(this.name, this);
			return this;
		}
	}

	public boolean d() {
		return false;
	}

	public IChatBaseComponent e() {
		IChatBaseComponent var1 = this.nameId.f();
		var1.getChatModifier().setColor(EnumChatFormat.GRAY);
		var1.getChatModifier().a(new ChatHoverable(EnumHoverAction.b, new ChatComponentText(this.name)));
		return var1;
	}

	public IChatBaseComponent j() {
		IChatBaseComponent var1 = this.e();
		IChatBaseComponent var2 = (new ChatComponentText("[")).a(var1).a("]");
		var2.a(var1.getChatModifier());
		return var2;
	}

	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else if (var1 != null && this.getClass() == var1.getClass()) {
			Statistic var2 = (Statistic) var1;
			return this.name.equals(var2.name);
		} else {
			return false;
		}
	}

	public int hashCode() {
		return this.name.hashCode();
	}

	public String toString() {
		return "Stat{id=" + this.name + ", nameId=" + this.nameId + ", awardLocallyOnly=" + this.local + ", formatter=" + this.counter + ", objectiveCriteria=" + this.criteria + '}';
	}

	public IScoreboardCriteria getCrteria() {
		return this.criteria;
	}

	public Class<IJsonStatistic> l() {
		return this.clazz;
	}

	public Statistic b(Class<IJsonStatistic> clazz) {
		this.clazz = clazz;
		return this;
	}

}
