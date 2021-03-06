package net.minecraft;

import java.util.List;

public class EntityMinecartHopper extends InventoryMinecart implements IHopper {

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

	public MinecartType getType() {
		return MinecartType.HOPPER;
	}

	public IBlockState u() {
		return Blocks.HOPPER.getBlockState();
	}

	public int w() {
		return 1;
	}

	public int getSize() {
		return 5;
	}

	public boolean e(EntityHuman var1) {
		if (!this.world.isStatic) {
			var1.openInventory((IInventory) this);
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

	public void doTick() {
		super.doTick();
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
		if (TileEntityHopper.a((IHopper) this)) {
			return true;
		} else {
			List var1 = this.world.getEntititesInAABB(EntityItem.class, this.getBoundingBox().grow(0.25D, 0.0D, 0.25D), EntityPredicates.a);
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

	protected void writeAdditionalData(NBTCompoundTag var1) {
		super.writeAdditionalData(var1);
		var1.put("TransferCooldown", this.b);
	}

	protected void readAdditionalData(NBTCompoundTag var1) {
		super.readAdditionalData(var1);
		this.b = var1.getInt("TransferCooldown");
	}

	public void m(int var1) {
		this.b = var1;
	}

	public boolean E() {
		return this.b > 0;
	}

	public String getInventoryType() {
		return "minecraft:hopper";
	}

	public Container getContainer(InventoryPlayer var1, EntityHuman var2) {
		return new ContainerHopper(var1, this, var2);
	}

}
