package net.minecraft;

public class InventoryAnvil implements IInventoryHasType {

	private final World world;
	private final Position position;

	public InventoryAnvil(World var1, Position var2) {
		this.world = var1;
		this.position = var2;
	}

	public String getName() {
		return "anvil";
	}

	public boolean hasCustomName() {
		return false;
	}

	public IChatBaseComponent getComponentName() {
		return new ChatMessage(Blocks.ANVIL.getName() + ".name", new Object[0]);
	}

	public Container getContainer(InventoryPlayer inventory, EntityHuman human) {
		return new ContainerAnvil(this, inventory, this.world, this.position, human);
	}

	public String getInventoryType() {
		return "minecraft:anvil";
	}
}
