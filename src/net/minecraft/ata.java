package net.minecraft;

public class ata implements vv {

	private final World a;
	private final Position b;

	public ata(World var1, Position var2) {
		this.a = var1;
		this.b = var2;
	}

	public String getName() {
		return "anvil";
	}

	public boolean k_() {
		return false;
	}

	public IChatBaseComponent getComponentName() {
		return new ChatMessage(Blocks.ANVIL.getName() + ".name", new Object[0]);
	}

	public Container a(PlayerInventory var1, EntityHuman var2) {
		return new ContainerAnvil(var1, this.a, this.b, var2);
	}

	public String k() {
		return "minecraft:anvil";
	}
}
