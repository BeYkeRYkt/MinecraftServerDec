package net.minecraft;

import java.util.List;

public class EntityMinecartHopper extends aed implements bdd {

	private boolean a = true;
	private int b = -1;
	private Position c;

	public EntityMinecartHopper(World var1) {
		super(var1);
		this.c = Position.ZERO;
	}

	public EntityMinecartHopper(World var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
		this.c = Position.ZERO;
	}

	public MinecartType s() {
		return MinecartType.HOPPER;
	}

	public BlockState u() {
		return Blocks.HOPPER.getBlockState();
	}

	public int w() {
		return 1;
	}

	public int n_() {
		return 5;
	}

	public boolean e(EntityHuman var1) {
		if (!this.world.isStatic) {
			var1.a((IInventory) this);
		}

		return true;
	}

	public void a(int var1, int var2, int var3, boolean var4) {
		boolean var5 = !var4;
		if (var5 != this.y()) {
			this.i(var5);
		}

	}

	public boolean y() {
		return this.a;
	}

	public void i(boolean var1) {
		this.a = var1;
	}

	public World getWorld() {
		return this.world;
	}

	public double A() {
		return this.locationX;
	}

	public double B() {
		return this.locationY;
	}

	public double C() {
		return this.locationZ;
	}

	public void s_() {
		super.s_();
		if (!this.world.isStatic && this.isAlive() && this.y()) {
			Position var1 = new Position(this);
			if (var1.equals(this.c)) {
				--this.b;
			} else {
				this.m(0);
			}

			if (!this.E()) {
				this.m(0);
				if (this.D()) {
					this.m(4);
					this.update();
				}
			}
		}

	}

	public boolean D() {
		if (TileEntityHopper.a((bdd) this)) {
			return true;
		} else {
			List var1 = this.world.a(EntityItem.class, this.getBoundingBox().grow(0.25D, 0.0D, 0.25D), EntityPredicates.a);
			if (var1.size() > 0) {
				TileEntityHopper.a((IInventory) this, (EntityItem) var1.get(0));
			}

			return false;
		}
	}

	public void a(DamageSource var1) {
		super.a(var1);
		this.a(Item.getItemOf((Block) Blocks.HOPPER), 1, 0.0F);
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.put("TransferCooldown", this.b);
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		this.b = var1.getInt("TransferCooldown");
	}

	public void m(int var1) {
		this.b = var1;
	}

	public boolean E() {
		return this.b > 0;
	}

	public String k() {
		return "minecraft:hopper";
	}

	public Container a(PlayerInventory var1, EntityHuman var2) {
		return new aix(var1, this, var2);
	}
}
