package net.minecraft;

import com.google.common.collect.Sets;
import java.util.Set;
import java.util.UUID;

public class EntityEnderman extends EntityMonster {

	private static final UUID b = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
	private static final AttributeModifier c = (new AttributeModifier(b, "Attacking speed boost", 0.15000000596046448D, 0)).setSerializable(false);
	private static final Set bk = Sets.newIdentityHashSet();
	private boolean bl;

	public EntityEnderman(World var1) {
		super(var1);
		this.a(0.6F, 2.9F);
		this.S = 1.0F;
		this.i.a(0, new yy(this));
		this.i.a(2, new zk(this, 1.0D, false));
		this.i.a(7, new zy(this, 1.0D));
		this.i.a(8, new zh(this, EntityHuman.class, 8.0F));
		this.i.a(8, new zx(this));
		this.i.a(10, new aet(this));
		this.i.a(11, new aev(this));
		this.bg.a(1, new aal(this, false, new Class[0]));
		this.bg.a(2, new aeu(this));
		this.bg.a(3, new aaq(this, EntityEndermite.class, 10, true, false, new aes(this)));
	}

	protected void aW() {
		super.aW();
		this.a(afs.a).a(40.0D);
		this.a(afs.d).a(0.30000001192092896D);
		this.a(afs.e).a(7.0D);
		this.a(afs.b).a(64.0D);
	}

	protected void h() {
		super.h();
		this.dataWatcher.a(16, new Short((short) 0));
		this.dataWatcher.a(17, new Byte((byte) 0));
		this.dataWatcher.a(18, new Byte((byte) 0));
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		BlockState var2 = this.ck();
		var1.put("carried", (short) Block.getBlockId(var2.getBlock()));
		var1.put("carriedData", (short) var2.getBlock().c(var2));
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		BlockState var2;
		if (var1.isTagAssignableFrom("carried", 8)) {
			var2 = Block.b(var1.getString("carried")).a(var1.getShort("carriedData") & '\uffff');
		} else {
			var2 = Block.c(var1.getShort("carried")).a(var1.getShort("carriedData") & '\uffff');
		}

		this.a(var2);
	}

	private boolean c(EntityHuman var1) {
		ItemStack var2 = var1.playerInventory.armor[3];
		if (var2 != null && var2.getItem() == Item.getItemOf(Blocks.PUMPKIN)) {
			return false;
		} else {
			Vec3D var3 = var1.d(1.0F).a();
			Vec3D var4 = new Vec3D(this.locationX - var1.locationX, this.aQ().minY + (double) (this.K / 2.0F) - (var1.locationY + (double) var1.aR()), this.locationZ - var1.locationZ);
			double var5 = var4.b();
			var4 = var4.a();
			double var7 = var3.b(var4);
			return var7 > 1.0D - 0.025D / var5 ? var1.t(this) : false;
		}
	}

	public float aR() {
		return 2.55F;
	}

	public void m() {
		if (this.world.D) {
			for (int var1 = 0; var1 < 2; ++var1) {
				this.world.a(Particle.y, this.locationX + (this.V.nextDouble() - 0.5D) * (double) this.J, this.locationY + this.V.nextDouble() * (double) this.K - 0.25D, this.locationZ + (this.V.nextDouble() - 0.5D) * (double) this.J, (this.V.nextDouble() - 0.5D) * 2.0D, -this.V.nextDouble(), (this.V.nextDouble() - 0.5D) * 2.0D, new int[0]);
			}
		}

		this.aW = false;
		super.m();
	}

	protected void E() {
		if (this.U()) {
			this.a(DamageSource.f, 1.0F);
		}

		if (this.cm() && !this.bl && this.V.nextInt(100) == 0) {
			this.a(false);
		}

		if (this.world.w()) {
			float var1 = this.c(1.0F);
			if (var1 > 0.5F && this.world.i(new Position(this)) && this.V.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F) {
				this.d((EntityLiving) null);
				this.a(false);
				this.bl = false;
				this.n();
			}
		}

		super.E();
	}

	protected boolean n() {
		double var1 = this.locationX + (this.V.nextDouble() - 0.5D) * 64.0D;
		double var3 = this.locationY + (double) (this.V.nextInt(64) - 32);
		double var5 = this.locationZ + (this.V.nextDouble() - 0.5D) * 64.0D;
		return this.k(var1, var3, var5);
	}

	protected boolean b(Entity var1) {
		Vec3D var2 = new Vec3D(this.locationX - var1.locationX, this.aQ().minY + (double) (this.K / 2.0F) - var1.locationY + (double) var1.aR(), this.locationZ - var1.locationZ);
		var2 = var2.a();
		double var3 = 16.0D;
		double var5 = this.locationX + (this.V.nextDouble() - 0.5D) * 8.0D - var2.x * var3;
		double var7 = this.locationY + (double) (this.V.nextInt(16) - 8) - var2.y * var3;
		double var9 = this.locationZ + (this.V.nextDouble() - 0.5D) * 8.0D - var2.z * var3;
		return this.k(var5, var7, var9);
	}

	protected boolean k(double var1, double var3, double var5) {
		double var7 = this.locationX;
		double var9 = this.locationY;
		double var11 = this.locationZ;
		this.locationX = var1;
		this.locationY = var3;
		this.locationZ = var5;
		boolean var13 = false;
		Position var14 = new Position(this.locationX, this.locationY, this.locationZ);
		if (this.world.isLoaded(var14)) {
			boolean var15 = false;

			while (!var15 && var14.getY() > 0) {
				Position var16 = var14.b();
				Block var17 = this.world.getBlockState(var16).getBlock();
				if (var17.getMaterial().isSolid()) {
					var15 = true;
				} else {
					--this.locationY;
					var14 = var16;
				}
			}

			if (var15) {
				super.updatePosition(this.locationX, this.locationY, this.locationZ);
				if (this.world.a((Entity) this, this.aQ()).isEmpty() && !this.world.d(this.aQ())) {
					var13 = true;
				}
			}
		}

		if (!var13) {
			this.b(var7, var9, var11);
			return false;
		} else {
			short var28 = 128;

			for (int var29 = 0; var29 < var28; ++var29) {
				double var30 = (double) var29 / ((double) var28 - 1.0D);
				float var19 = (this.V.nextFloat() - 0.5F) * 0.2F;
				float var20 = (this.V.nextFloat() - 0.5F) * 0.2F;
				float var21 = (this.V.nextFloat() - 0.5F) * 0.2F;
				double var22 = var7 + (this.locationX - var7) * var30 + (this.V.nextDouble() - 0.5D) * (double) this.J * 2.0D;
				double var24 = var9 + (this.locationY - var9) * var30 + this.V.nextDouble() * (double) this.K;
				double var26 = var11 + (this.locationZ - var11) * var30 + (this.V.nextDouble() - 0.5D) * (double) this.J * 2.0D;
				this.world.a(Particle.y, var22, var24, var26, (double) var19, (double) var20, (double) var21, new int[0]);
			}

			this.world.makeSound(var7, var9, var11, "mob.endermen.portal", 1.0F, 1.0F);
			this.a("mob.endermen.portal", 1.0F, 1.0F);
			return true;
		}
	}

	protected String z() {
		return this.cm() ? "mob.endermen.scream" : "mob.endermen.idle";
	}

	protected String bn() {
		return "mob.endermen.hit";
	}

	protected String bo() {
		return "mob.endermen.death";
	}

	protected Item A() {
		return Items.ENDER_PEARL;
	}

	protected void b(boolean var1, int var2) {
		Item var3 = this.A();
		if (var3 != null) {
			int var4 = this.V.nextInt(2 + var2);

			for (int var5 = 0; var5 < var4; ++var5) {
				this.a(var3, 1);
			}
		}

	}

	public void a(BlockState var1) {
		this.dataWatcher.b(16, Short.valueOf((short) (Block.f(var1) & '\uffff')));
	}

	public BlockState ck() {
		return Block.d(this.dataWatcher.b(16) & '\uffff');
	}

	public boolean a(DamageSource var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			if (var1.j() == null || !(var1.j() instanceof EntityEndermite)) {
				if (!this.world.D) {
					this.a(true);
				}

				if (var1 instanceof wi && var1.j() instanceof EntityHuman) {
					if (var1.j() instanceof EntityPlayer && ((EntityPlayer) var1.j()).playerInteractManager.isCreative()) {
						this.a(false);
					} else {
						this.bl = true;
					}
				}

				if (var1 instanceof wj) {
					this.bl = false;

					for (int var4 = 0; var4 < 64; ++var4) {
						if (this.n()) {
							return true;
						}
					}

					return false;
				}
			}

			boolean var3 = super.a(var1, var2);
			if (var1.e() && this.V.nextInt(10) != 0) {
				this.n();
			}

			return var3;
		}
	}

	public boolean cm() {
		return this.dataWatcher.a(18) > 0;
	}

	public void a(boolean var1) {
		this.dataWatcher.b(18, Byte.valueOf((byte) (var1 ? 1 : 0)));
	}

	// $FF: synthetic method
	static AttributeModifier cn() {
		return c;
	}

	// $FF: synthetic method
	static boolean a(EntityEnderman var0, EntityHuman var1) {
		return var0.c(var1);
	}

	// $FF: synthetic method
	static boolean a(EntityEnderman var0, boolean var1) {
		return var0.bl = var1;
	}

	// $FF: synthetic method
	static Set co() {
		return bk;
	}

	static {
		bk.add(Blocks.GRASS);
		bk.add(Blocks.DIRT);
		bk.add(Blocks.SAND);
		bk.add(Blocks.GRAVEL);
		bk.add(Blocks.YELLOW_FLOWER);
		bk.add(Blocks.RED_FLOWER);
		bk.add(Blocks.BRWON_MUSHROOM);
		bk.add(Blocks.RED_MUSHROOM);
		bk.add(Blocks.TNT);
		bk.add(Blocks.CACTUS);
		bk.add(Blocks.CLAY);
		bk.add(Blocks.PUMPKIN);
		bk.add(Blocks.MELON_BLOCK);
		bk.add(Blocks.MYCELIUM);
	}
}
