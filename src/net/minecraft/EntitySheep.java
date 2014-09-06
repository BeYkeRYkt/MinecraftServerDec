package net.minecraft;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Random;

public class EntitySheep extends abq {

	private final ain bk = new ain(new acm(this), 2, 1);
	private static final Map bm = Maps.newEnumMap(akv.class);
	private int bn;
	private yw bo = new yw(this);

	public static float[] a(akv var0) {
		return (float[]) bm.get(var0);
	}

	public EntitySheep(World var1) {
		super(var1);
		this.a(0.9F, 1.3F);
		((aay) this.s()).a(true);
		this.i.a(0, new yy(this));
		this.i.a(1, new zu(this, 1.25D));
		this.i.a(2, new yt(this, 1.0D));
		this.i.a(3, new aag(this, 1.1D, Items.WHEAT, false));
		this.i.a(4, new za(this, 1.1D));
		this.i.a(5, this.bo);
		this.i.a(6, new zy(this, 1.0D));
		this.i.a(7, new zh(this, EntityHuman.class, 6.0F));
		this.i.a(8, new zx(this));
		this.bk.a(0, new ItemStack(Items.DYE, 1, 0));
		this.bk.a(1, new ItemStack(Items.DYE, 1, 0));
	}

	protected void E() {
		this.bn = this.bo.f();
		super.E();
	}

	public void m() {
		if (this.o.D) {
			this.bn = Math.max(0, this.bn - 1);
		}

		super.m();
	}

	protected void aW() {
		super.aW();
		this.a(afs.a).a(8.0D);
		this.a(afs.d).a(0.23000000417232513D);
	}

	protected void h() {
		super.h();
		this.dataWatcher.a(16, new Byte((byte) 0));
	}

	protected void b(boolean var1, int var2) {
		if (!this.ck()) {
			this.a(new ItemStack(Item.getItemOf(Blocks.WOOL), 1, this.cj().a()), 0.0F);
		}

		int var3 = this.V.nextInt(2) + 1 + this.V.nextInt(1 + var2);

		for (int var4 = 0; var4 < var3; ++var4) {
			if (this.au()) {
				this.a(Items.COOKED_MUTTON, 1);
			} else {
				this.a(Items.MUTTON, 1);
			}
		}

	}

	protected Item A() {
		return Item.getItemOf(Blocks.WOOL);
	}

	public boolean a(EntityHuman var1) {
		ItemStack var2 = var1.playerInventory.getItemInHand();
		if (var2 != null && var2.getItem() == Items.SHEARS && !this.ck() && !this.i_()) {
			if (!this.o.D) {
				this.l(true);
				int var3 = 1 + this.V.nextInt(3);

				for (int var4 = 0; var4 < var3; ++var4) {
					EntityItem var5 = this.a(new ItemStack(Item.getItemOf(Blocks.WOOL), 1, this.cj().a()), 1.0F);
					var5.motionY += (double) (this.V.nextFloat() * 0.05F);
					var5.motionX += (double) ((this.V.nextFloat() - this.V.nextFloat()) * 0.1F);
					var5.motionZ += (double) ((this.V.nextFloat() - this.V.nextFloat()) * 0.1F);
				}
			}

			var2.a(1, (EntityLiving) var1);
			this.a("mob.sheep.shear", 1.0F, 1.0F);
		}

		return super.a(var1);
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.put("Sheared", this.ck());
		var1.put("Color", (byte) this.cj().a());
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.l(var1.getBoolean("Sheared"));
		this.b(akv.b(var1.getByte("Color")));
	}

	protected String z() {
		return "mob.sheep.say";
	}

	protected String bn() {
		return "mob.sheep.say";
	}

	protected String bo() {
		return "mob.sheep.say";
	}

	protected void a(Position var1, Block var2) {
		this.a("mob.sheep.step", 0.15F, 1.0F);
	}

	public akv cj() {
		return akv.b(this.dataWatcher.a(16) & 15);
	}

	public void b(akv var1) {
		byte var2 = this.dataWatcher.a(16);
		this.dataWatcher.b(16, Byte.valueOf((byte) (var2 & 240 | var1.a() & 15)));
	}

	public boolean ck() {
		return (this.dataWatcher.a(16) & 16) != 0;
	}

	public void l(boolean var1) {
		byte var2 = this.dataWatcher.a(16);
		if (var1) {
			this.dataWatcher.b(16, Byte.valueOf((byte) (var2 | 16)));
		} else {
			this.dataWatcher.b(16, Byte.valueOf((byte) (var2 & -17)));
		}

	}

	public static akv a(Random var0) {
		int var1 = var0.nextInt(100);
		return var1 < 5 ? akv.p : (var1 < 10 ? akv.h : (var1 < 15 ? akv.i : (var1 < 18 ? akv.m : (var0.nextInt(500) == 0 ? akv.g : akv.a))));
	}

	public EntitySheep b(ws var1) {
		EntitySheep var2 = (EntitySheep) var1;
		EntitySheep var3 = new EntitySheep(this.o);
		var3.b(this.a((abq) this, (abq) var2));
		return var3;
	}

	public void v() {
		this.l(false);
		if (this.i_()) {
			this.a(60);
		}

	}

	public xq a(vu var1, xq var2) {
		var2 = super.a(var1, var2);
		this.b(a(this.o.s));
		return var2;
	}

	private akv a(abq var1, abq var2) {
		int var3 = ((EntitySheep) var1).cj().b();
		int var4 = ((EntitySheep) var2).cj().b();
		this.bk.a(0).b(var3);
		this.bk.a(1).b(var4);
		ItemStack var5 = aop.a().a(this.bk, ((EntitySheep) var1).o);
		int var6;
		if (var5 != null && var5.getItem() == Items.DYE) {
			var6 = var5.i();
		} else {
			var6 = this.o.s.nextBoolean() ? var3 : var4;
		}

		return akv.a(var6);
	}

	public float aR() {
		return 0.95F * this.K;
	}

	// $FF: synthetic method
	public ws a(ws var1) {
		return this.b(var1);
	}

	static {
		bm.put(akv.a, new float[] { 1.0F, 1.0F, 1.0F });
		bm.put(akv.b, new float[] { 0.85F, 0.5F, 0.2F });
		bm.put(akv.c, new float[] { 0.7F, 0.3F, 0.85F });
		bm.put(akv.d, new float[] { 0.4F, 0.6F, 0.85F });
		bm.put(akv.e, new float[] { 0.9F, 0.9F, 0.2F });
		bm.put(akv.f, new float[] { 0.5F, 0.8F, 0.1F });
		bm.put(akv.g, new float[] { 0.95F, 0.5F, 0.65F });
		bm.put(akv.h, new float[] { 0.3F, 0.3F, 0.3F });
		bm.put(akv.i, new float[] { 0.6F, 0.6F, 0.6F });
		bm.put(akv.j, new float[] { 0.3F, 0.5F, 0.6F });
		bm.put(akv.k, new float[] { 0.5F, 0.25F, 0.7F });
		bm.put(akv.l, new float[] { 0.2F, 0.3F, 0.7F });
		bm.put(akv.m, new float[] { 0.4F, 0.3F, 0.2F });
		bm.put(akv.n, new float[] { 0.4F, 0.5F, 0.2F });
		bm.put(akv.o, new float[] { 0.6F, 0.2F, 0.2F });
		bm.put(akv.p, new float[] { 0.1F, 0.1F, 0.1F });
	}
}
