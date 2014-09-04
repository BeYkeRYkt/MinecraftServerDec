package net.minecraft;

public class wj extends wi {

	private Entity r;

	public wj(String var1, Entity var2, Entity var3) {
		super(var1, var2);
		this.r = var3;
	}

	public Entity i() {
		return this.q;
	}

	public Entity j() {
		return this.r;
	}

	public ho b(EntityLiving var1) {
		ho var2 = this.r == null ? this.q.e_() : this.r.e_();
		amj var3 = this.r instanceof EntityLiving ? ((EntityLiving) this.r).bz() : null;
		String var4 = "death.attack." + this.p;
		String var5 = var4 + ".item";
		return var3 != null && var3.s() && fi.c(var5) ? new hz(var5, new Object[] { var1.e_(), var2, var3.C() }) : new hz(var4, new Object[] { var1.e_(), var2 });
	}
}
