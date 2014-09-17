package net.minecraft;

public class EntityMinecartChest extends InventoryMinecart {

	public EntityMinecartChest(World var1) {
		super(var1);
	}

	public EntityMinecartChest(World var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	public void a(DamageSource var1) {
		super.a(var1);
		this.a(Item.getItemOf((Block) Blocks.CHEST), 1, 0.0F);
	}

	public int getSize() {
		return 27;
	}

	public MinecartType getType() {
		return MinecartType.CHEST;
	}

	public IBlockState u() {
		return Blocks.CHEST.getBlockState().a(BlockChest.a, BlockFace.NORTH);
	}

	public int w() {
		return 8;
	}

	public String getInventoryType() {
		return "minecraft:chest";
	}

	public Container getContainer(PlayerInventory var1, EntityHuman var2) {
		return new ContainerChest(var1, this, var2);
	}

}
