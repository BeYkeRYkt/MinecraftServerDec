package net.minecraft;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class CombatTracker {

	private final List a = Lists.newArrayList();
	private final EntityLiving b;
	private int c;
	private int d;
	private int e;
	private boolean f;
	private boolean g;
	private String h;

	public CombatTracker(EntityLiving var1) {
		this.b = var1;
	}

	public void a() {
		this.j();
		if (this.b.j_()) {
			Block var1 = this.b.world.getBlockState(new Position(this.b.locationX, this.b.getBoundingBox().minY, this.b.locationZ)).getBlock();
			if (var1 == Blocks.LADDER) {
				this.h = "ladder";
			} else if (var1 == Blocks.VINE) {
				this.h = "vines";
			}
		} else if (this.b.V()) {
			this.h = "water";
		}

	}

	public void a(DamageSource var1, float var2, float var3) {
		this.g();
		this.a();
		wf var4 = new wf(var1, this.b.W, var2, var3, this.h, this.b.O);
		this.a.add(var4);
		this.c = this.b.W;
		this.g = true;
		if (var4.f() && !this.f && this.b.isAlive()) {
			this.f = true;
			this.d = this.b.W;
			this.e = this.d;
			this.b.g_();
		}

	}

	public IChatBaseComponent getMessage() {
		if (this.a.size() == 0) {
			return new ChatMessage("death.attack.generic", new Object[] { this.b.getComponentName() });
		} else {
			wf var1 = this.i();
			wf var2 = (wf) this.a.get(this.a.size() - 1);
			IChatBaseComponent var4 = var2.h();
			Entity var5 = var2.a().j();
			Object var3;
			if (var1 != null && var2.a() == DamageSource.i) {
				IChatBaseComponent var6 = var1.h();
				if (var1.a() != DamageSource.i && var1.a() != DamageSource.j) {
					if (var6 != null && (var4 == null || !var6.equals(var4))) {
						Entity var9 = var1.a().j();
						ItemStack var8 = var9 instanceof EntityLiving ? ((EntityLiving) var9).getItemInHand() : null;
						if (var8 != null && var8.s()) {
							var3 = new ChatMessage("death.fell.assist.item", new Object[] { this.b.getComponentName(), var6, var8.C() });
						} else {
							var3 = new ChatMessage("death.fell.assist", new Object[] { this.b.getComponentName(), var6 });
						}
					} else if (var4 != null) {
						ItemStack var7 = var5 instanceof EntityLiving ? ((EntityLiving) var5).getItemInHand() : null;
						if (var7 != null && var7.s()) {
							var3 = new ChatMessage("death.fell.finish.item", new Object[] { this.b.getComponentName(), var4, var7.C() });
						} else {
							var3 = new ChatMessage("death.fell.finish", new Object[] { this.b.getComponentName(), var4 });
						}
					} else {
						var3 = new ChatMessage("death.fell.killer", new Object[] { this.b.getComponentName() });
					}
				} else {
					var3 = new ChatMessage("death.fell.accident." + this.a(var1), new Object[] { this.b.getComponentName() });
				}
			} else {
				var3 = var2.a().b(this.b);
			}

			return (IChatBaseComponent) var3;
		}
	}

	public EntityLiving getEntity() {
		EntityLiving var1 = null;
		EntityHuman var2 = null;
		float var3 = 0.0F;
		float var4 = 0.0F;
		Iterator var5 = this.a.iterator();

		while (var5.hasNext()) {
			wf var6 = (wf) var5.next();
			if (var6.a().j() instanceof EntityHuman && (var2 == null || var6.c() > var4)) {
				var4 = var6.c();
				var2 = (EntityHuman) var6.a().j();
			}

			if (var6.a().j() instanceof EntityLiving && (var1 == null || var6.c() > var3)) {
				var3 = var6.c();
				var1 = (EntityLiving) var6.a().j();
			}
		}

		if (var2 != null && var4 >= var3 / 3.0F) {
			return var2;
		} else {
			return var1;
		}
	}

	private wf i() {
		wf var1 = null;
		wf var2 = null;
		byte var3 = 0;
		float var4 = 0.0F;

		for (int var5 = 0; var5 < this.a.size(); ++var5) {
			wf var6 = (wf) this.a.get(var5);
			wf var7 = var5 > 0 ? (wf) this.a.get(var5 - 1) : null;
			if ((var6.a() == DamageSource.i || var6.a() == DamageSource.j) && var6.i() > 0.0F && (var1 == null || var6.i() > var4)) {
				if (var5 > 0) {
					var1 = var7;
				} else {
					var1 = var6;
				}

				var4 = var6.i();
			}

			if (var6.g() != null && (var2 == null || var6.c() > (float) var3)) {
				var2 = var6;
			}
		}

		if (var4 > 5.0F && var1 != null) {
			return var1;
		} else if (var3 > 5 && var2 != null) {
			return var2;
		} else {
			return null;
		}
	}

	private String a(wf var1) {
		return var1.g() == null ? "generic" : var1.g();
	}

	public int getDuration() {
		return this.f ? this.b.W - this.d : this.e - this.d;
	}

	private void j() {
		this.h = null;
	}

	public void g() {
		int var1 = this.f ? 300 : 100;
		if (this.g && (!this.b.isAlive() || this.b.W - this.c > var1)) {
			boolean var2 = this.f;
			this.g = false;
			this.f = false;
			this.e = this.b.W;
			if (var2) {
				this.b.j();
			}

			this.a.clear();
		}

	}

	public EntityLiving getPlayer() {
		return this.b;
	}
}
