package net.minecraft;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;

public class EntityFallingBlock extends Entity {

	private BlockState d;
	public int a;
	public boolean b = true;
	private boolean e;
	private boolean f;
	private int g = 40;
	private float h = 2.0F;
	public NBTCompoundTag c;

	public EntityFallingBlock(World var1) {
		super(var1);
	}

	public EntityFallingBlock(World var1, double var2, double var4, double var6, BlockState var8) {
		super(var1);
		this.d = var8;
		this.k = true;
		this.a(0.98F, 0.98F);
		this.b(var2, var4, var6);
		this.motionX = 0.0D;
		this.motionY = 0.0D;
		this.motionZ = 0.0D;
		this.p = var2;
		this.q = var4;
		this.r = var6;
	}

	protected boolean r_() {
		return false;
	}

	protected void h() {
	}

	public boolean ad() {
		return !this.dead;
	}

	public void s_() {
		Block var1 = this.d.getBlock();
		if (var1.getMaterial() == Material.AIR) {
			this.die();
		} else {
			this.p = this.locationX;
			this.q = this.locationY;
			this.r = this.locationZ;
			Position var2;
			if (this.a++ == 0) {
				var2 = new Position(this);
				if (this.world.getBlockState(var2).getBlock() == var1) {
					this.world.g(var2);
				} else if (!this.world.D) {
					this.die();
					return;
				}
			}

			this.motionY -= 0.03999999910593033D;
			this.move(this.motionX, this.motionY, this.motionZ);
			this.motionX *= 0.9800000190734863D;
			this.motionY *= 0.9800000190734863D;
			this.motionZ *= 0.9800000190734863D;
			if (!this.world.D) {
				var2 = new Position(this);
				if (this.onGround) {
					this.motionX *= 0.699999988079071D;
					this.motionZ *= 0.699999988079071D;
					this.motionY *= -0.5D;
					if (this.world.getBlockState(var2).getBlock() != Blocks.PISTON_EXTENSION) {
						this.die();
						if (!this.e && this.world.a(var1, var2, true, BlockFace.UP, (Entity) null, (ItemStack) null) && !avt.d(this.world, var2.b()) && this.world.a(var2, this.d, 3)) {
							if (var1 instanceof avt) {
								((avt) var1).a_(this.world, var2);
							}

							if (this.c != null && var1 instanceof avs) {
								TileEntity var3 = this.world.getTileEntity(var2);
								if (var3 != null) {
									NBTCompoundTag var4 = new NBTCompoundTag();
									var3.write(var4);
									Iterator var5 = this.c.getKeys().iterator();

									while (var5.hasNext()) {
										String var6 = (String) var5.next();
										NBTTag var7 = this.c.getTag(var6);
										if (!var6.equals("x") && !var6.equals("y") && !var6.equals("z")) {
											var4.put(var6, var7.getCopy());
										}
									}

									var3.read(var4);
									var3.update();
								}
							}
						} else if (this.b && !this.e && this.world.Q().b("doTileDrops")) {
							this.a(new ItemStack(var1, 1, var1.a(this.d)), 0.0F);
						}
					}
				} else if (this.a > 100 && !this.world.D && (var2.getY() < 1 || var2.getY() > 256) || this.a > 600) {
					if (this.b && this.world.Q().b("doTileDrops")) {
						this.a(new ItemStack(var1, 1, var1.a(this.d)), 0.0F);
					}

					this.die();
				}
			}

		}
	}

	public void e(float var1, float var2) {
		Block var3 = this.d.getBlock();
		if (this.f) {
			int var4 = DataTypesConverter.f(var1 - 1.0F);
			if (var4 > 0) {
				ArrayList var5 = Lists.newArrayList((Iterable) this.world.b((Entity) this, this.getBoundingBox()));
				boolean var6 = var3 == Blocks.ANVIL;
				DamageSource var7 = var6 ? DamageSource.n : DamageSource.o;
				Iterator var8 = var5.iterator();

				while (var8.hasNext()) {
					Entity var9 = (Entity) var8.next();
					var9.a(var7, (float) Math.min(DataTypesConverter.d((float) var4 * this.h), this.g));
				}

				if (var6 && (double) this.V.nextFloat() < 0.05000000074505806D + (double) var4 * 0.05D) {
					int var10 = ((Integer) this.d.b(BlockAnvil.b)).intValue();
					++var10;
					if (var10 > 2) {
						this.e = true;
					} else {
						this.d = this.d.a(BlockAnvil.b, Integer.valueOf(var10));
					}
				}
			}
		}

	}

	protected void b(NBTCompoundTag var1) {
		Block var2 = this.d != null ? this.d.getBlock() : Blocks.AIR;
		RegistryObjectName var3 = (RegistryObjectName) Block.BLOCKREGISTRY.c(var2);
		var1.put("Block", var3 == null ? "" : var3.toString());
		var1.put("Data", (byte) var2.c(this.d));
		var1.put("Time", (byte) this.a);
		var1.put("DropItem", this.b);
		var1.put("HurtEntities", this.f);
		var1.put("FallHurtAmount", this.h);
		var1.put("FallHurtMax", this.g);
		if (this.c != null) {
			var1.put("TileEntityData", (NBTTag) this.c);
		}

	}

	protected void a(NBTCompoundTag var1) {
		int var2 = var1.getByte("Data") & 255;
		if (var1.isTagAssignableFrom("Block", 8)) {
			this.d = Block.getByName(var1.getString("Block")).a(var2);
		} else if (var1.isTagAssignableFrom("TileID", 99)) {
			this.d = Block.getById(var1.getInt("TileID")).a(var2);
		} else {
			this.d = Block.getById(var1.getByte("Tile") & 255).a(var2);
		}

		this.a = var1.getByte("Time") & 255;
		Block var3 = this.d.getBlock();
		if (var1.isTagAssignableFrom("HurtEntities", 99)) {
			this.f = var1.getBoolean("HurtEntities");
			this.h = var1.getFloat("FallHurtAmount");
			this.g = var1.getInt("FallHurtMax");
		} else if (var3 == Blocks.ANVIL) {
			this.f = true;
		}

		if (var1.isTagAssignableFrom("DropItem", 99)) {
			this.b = var1.getBoolean("DropItem");
		}

		if (var1.isTagAssignableFrom("TileEntityData", 10)) {
			this.c = var1.getCompound("TileEntityData");
		}

		if (var3 == null || var3.getMaterial() == Material.AIR) {
			this.d = Blocks.SAND.getBlockState();
		}

	}

	public void a(boolean var1) {
		this.f = var1;
	}

	public void a(CrashReportSystemDetails var1) {
		super.a(var1);
		if (this.d != null) {
			Block var2 = this.d.getBlock();
			var1.addDetails("Immitating block ID", (Object) Integer.valueOf(Block.getBlockId(var2)));
			var1.addDetails("Immitating block data", (Object) Integer.valueOf(var2.c(this.d)));
		}

	}

	public BlockState l() {
		return this.d;
	}
}
