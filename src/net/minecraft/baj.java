package net.minecraft;

import com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.Random;

public class baj extends atg {

	public static final beu a = beu.a("facing");
	public static final bet b = bet.a("nodrop");
	private static final Predicate M = new bak();
	private bek N;
	private bek O;

	protected baj() {
		super(bof.q);
		this.j(this.L.b().a(a, ej.c).a(b, Boolean.valueOf(false)));
		this.a(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
	}

	public boolean c() {
		return false;
	}

	public boolean d() {
		return false;
	}

	public void a(ard var1, Position var2) {
		switch (bal.a[((ej) var1.p(var2).b(a)).ordinal()]) {
			case 1:
			default:
				this.a(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
				break;
			case 2:
				this.a(0.25F, 0.25F, 0.5F, 0.75F, 0.75F, 1.0F);
				break;
			case 3:
				this.a(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 0.5F);
				break;
			case 4:
				this.a(0.5F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F);
				break;
			case 5:
				this.a(0.0F, 0.25F, 0.25F, 0.5F, 0.75F, 0.75F);
		}

	}

	public brt a(World var1, Position var2, bec var3) {
		this.a(var1, var2);
		return super.a(var1, var2, var3);
	}

	public bec a(World var1, Position var2, ej var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		return this.P().a(a, var8.aO()).a(b, Boolean.valueOf(false));
	}

	public bcm a(World var1, int var2) {
		return new bdm();
	}

	public int j(World var1, Position var2) {
		bcm var3 = var1.s(var2);
		return var3 instanceof bdm ? ((bdm) var3).c() : super.j(var1, var2);
	}

	public void a(World var1, Position var2, bec var3, float var4, int var5) {
	}

	public void a(World var1, Position var2, bec var3, EntityHuman var4) {
		if (var4.by.instabuild) {
			var3 = var3.a(b, Boolean.valueOf(true));
			var1.a(var2, var3, 4);
		}

		super.a(var1, var2, var3, var4);
	}

	public void b(World var1, Position var2, bec var3) {
		if (!var1.D) {
			if (!((Boolean) var3.b(b)).booleanValue()) {
				bcm var4 = var1.s(var2);
				if (var4 instanceof bdm) {
					bdm var5 = (bdm) var4;
					ItemStack var6 = new ItemStack(amk.bX, 1, this.j(var1, var2));
					if (var5.c() == 3 && var5.b() != null) {
						var6.d(new NBTCompoundTag());
						NBTCompoundTag var7 = new NBTCompoundTag();
						ga.a(var7, var5.b());
						var6.getTag().put("SkullOwner", (NBTTag) var7);
					}

					a(var1, var2, var6);
				}
			}

			super.b(var1, var2, var3);
		}
	}

	public Item a(bec var1, Random var2, int var3) {
		return amk.bX;
	}

	public boolean b(World var1, Position var2, ItemStack var3) {
		return var3.i() == 1 && var2.o() >= 2 && var1.getDifficulty() != Difficulty.PEACEFUL && !var1.D ? this.j().a(var1, var2) != null : false;
	}

	public void a(World var1, Position var2, bdm var3) {
		if (var3.c() == 1 && var2.o() >= 2 && var1.getDifficulty() != Difficulty.PEACEFUL && !var1.D) {
			bek var4 = this.l();
			bem var5 = var4.a(var1, var2);
			if (var5 != null) {
				int var6;
				for (var6 = 0; var6 < 3; ++var6) {
					bei var7 = var5.a(var6, 0, 0);
					var1.a(var7.d(), var7.a().a(b, Boolean.valueOf(true)), 2);
				}

				for (var6 = 0; var6 < var4.c(); ++var6) {
					for (int var13 = 0; var13 < var4.b(); ++var13) {
						bei var8 = var5.a(var6, var13, 0);
						var1.a(var8.d(), aty.a.P(), 2);
					}
				}

				Position var12 = var5.a(1, 0, 0).d();
				adf var14 = new adf(var1);
				Position var15 = var5.a(1, 2, 0).d();
				var14.b((double) var15.n() + 0.5D, (double) var15.o() + 0.55D, (double) var15.p() + 0.5D, var5.b().k() == el.a ? 0.0F : 90.0F, 0.0F);
				var14.aG = var5.b().k() == el.a ? 0.0F : 90.0F;
				var14.n();
				Iterator var9 = var1.a(EntityHuman.class, var14.aQ().b(50.0D, 50.0D, 50.0D)).iterator();

				while (var9.hasNext()) {
					EntityHuman var10 = (EntityHuman) var9.next();
					var10.b((PlayerStatistic) tl.I);
				}

				var1.d((Entity) var14);

				int var16;
				for (var16 = 0; var16 < 120; ++var16) {
					var1.a(ew.F, (double) var12.n() + var1.s.nextDouble(), (double) (var12.o() - 2) + var1.s.nextDouble() * 3.9D, (double) var12.p() + var1.s.nextDouble(), 0.0D, 0.0D, 0.0D, new int[0]);
				}

				for (var16 = 0; var16 < var4.c(); ++var16) {
					for (int var17 = 0; var17 < var4.b(); ++var17) {
						bei var11 = var5.a(var16, var17, 0);
						var1.b(var11.d(), aty.a);
					}
				}

			}
		}
	}

	public bec a(int var1) {
		return this.P().a(a, ej.a(var1 & 7)).a(b, Boolean.valueOf((var1 & 8) > 0));
	}

	public int c(bec var1) {
		byte var2 = 0;
		int var3 = var2 | ((ej) var1.b(a)).a();
		if (((Boolean) var1.b(b)).booleanValue()) {
			var3 |= 8;
		}

		return var3;
	}

	protected bed e() {
		return new bed(this, new bex[] { a, b });
	}

	protected bek j() {
		if (this.N == null) {
			this.N = ben.a().a(new String[] { "   ", "###", "~#~" }).a('#', bei.a(beq.a(aty.aW))).a('~', bei.a(beq.a(aty.a))).b();
		}

		return this.N;
	}

	protected bek l() {
		if (this.O == null) {
			this.O = ben.a().a(new String[] { "^^^", "###", "~#~" }).a('#', bei.a(beq.a(aty.aW))).a('^', M).a('~', bei.a(beq.a(aty.a))).b();
		}

		return this.O;
	}

}
