package net.minecraft;

public class EntityMinecartChest extends aed {

	public EntityMinecartChest(World var1) {
		super(var1);
	}

	public EntityMinecartChest(World var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	public void a(DamageSource var1) {
		super.a(var1);
		this.a(Item.getItemOf((Block) Blocks.ae), 1, 0.0F);
	}

	public int n_() {
		return 27;
	}

	public MinecartType s() {
		return MinecartType.CHEST;
	}

	public bec u() {
		return Blocks.ae.P().a(BlockChest.a, PaintingDirection.c);
	}

	public int w() {
		return 8;
	}

	public String k() {
		return "minecraft:chest";
	}

	public Container a(PlayerInventory var1, EntityHuman var2) {
		return new aim(var1, this, var2);
	}
}
