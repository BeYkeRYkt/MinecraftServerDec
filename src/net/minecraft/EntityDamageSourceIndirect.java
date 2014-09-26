package net.minecraft;

public class EntityDamageSourceIndirect extends EntityDamageSource {

	private Entity r;

	public EntityDamageSourceIndirect(String var1, Entity var2, Entity var3) {
		super(var1, var2);
		this.r = var3;
	}

	public Entity i() {
		return this.q;
	}

	public Entity getDamager() {
		return this.r;
	}

	public IChatBaseComponent getLocalizedDeathMessage(EntityLiving var1) {
		IChatBaseComponent var2 = this.r == null ? this.q.getComponentName() : this.r.getComponentName();
		ItemStack var3 = this.r instanceof EntityLiving ? ((EntityLiving) this.r).getItemInHand() : null;
		String var4 = "death.attack." + this.translationIndex;
		String var5 = var4 + ".item";
		return var3 != null && var3.hasDisplayName() && LocaleI18n.c(var5) ? new ChatMessage(var5, new Object[] { var1.getComponentName(), var2, var3.C() }) : new ChatMessage(var4, new Object[] { var1.getComponentName(), var2 });
	}
}
