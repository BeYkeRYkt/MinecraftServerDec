package net.minecraft;

public class InventoryWorkbench implements IInventoryHasType {

	private final World world;
	private final Position position;

	public InventoryWorkbench(World var1, Position var2) {
		this.world = var1;
		this.position = var2;
	}

	public String getName() {
		return null;
	}

	public boolean hasCustomName() {
		return false;
	}

	public IChatBaseComponent getComponentName() {
		return new ChatMessage(Blocks.CRAFTING_TABLE.getName() + ".name", new Object[0]);
	}

	public Container getContainer(InventoryPlayer var1, EntityHuman var2) {
		return new ContainerWorkbench(this, var1, this.world, this.position);
	}

	public String getInventoryType() {
		return "minecraft:crafting_table";
	}
}
