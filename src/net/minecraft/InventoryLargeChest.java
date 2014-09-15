package net.minecraft;

public class InventoryLargeChest implements vy {

	private String a;
	private vy b;
	private vy c;

	public InventoryLargeChest(String var1, vy var2, vy var3) {
		this.a = var1;
		if (var2 == null) {
			var2 = var3;
		}

		if (var3 == null) {
			var3 = var2;
		}

		this.b = var2;
		this.c = var3;
		if (var2.q_()) {
			var3.a(var2.i());
		} else if (var3.q_()) {
			var2.a(var3.i());
		}

	}

	public int getSize() {
		return this.b.getSize() + this.c.getSize();
	}

	public boolean a(IInventory var1) {
		return this.b == var1 || this.c == var1;
	}

	public String getName() {
		return this.b.hasCustomName() ? this.b.getName() : (this.c.hasCustomName() ? this.c.getName() : this.a);
	}

	public boolean hasCustomName() {
		return this.b.hasCustomName() || this.c.hasCustomName();
	}

	public IChatBaseComponent getComponentName() {
		return (IChatBaseComponent) (this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatMessage(this.getName(), new Object[0]));
	}

	public ItemStack getItem(int var1) {
		return var1 >= this.b.getSize() ? this.c.getItem(var1 - this.b.getSize()) : this.b.getItem(var1);
	}

	public ItemStack splitStack(int var1, int var2) {
		return var1 >= this.b.getSize() ? this.c.splitStack(var1 - this.b.getSize(), var2) : this.b.splitStack(var1, var2);
	}

	public ItemStack splitWithoutUpdate(int var1) {
		return var1 >= this.b.getSize() ? this.c.splitWithoutUpdate(var1 - this.b.getSize()) : this.b.splitWithoutUpdate(var1);
	}

	public void setItem(int var1, ItemStack var2) {
		if (var1 >= this.b.getSize()) {
			this.c.setItem(var1 - this.b.getSize(), var2);
		} else {
			this.b.setItem(var1, var2);
		}

	}

	public int getMaxStackSize() {
		return this.b.getMaxStackSize();
	}

	public void update() {
		this.b.update();
		this.c.update();
	}

	public boolean canInteract(EntityHuman var1) {
		return this.b.canInteract(var1) && this.c.canInteract(var1);
	}

	public void onContainerOpen(EntityHuman var1) {
		this.b.onContainerOpen(var1);
		this.c.onContainerOpen(var1);
	}

	public void onContainerClose(EntityHuman var1) {
		this.b.onContainerClose(var1);
		this.c.onContainerClose(var1);
	}

	public boolean b(int var1, ItemStack var2) {
		return true;
	}

	public int getProperty(int var1) {
		return 0;
	}

	public void b(int var1, int var2) {
	}

	public int getPropertiesCount() {
		return 0;
	}

	public boolean q_() {
		return this.b.q_() || this.c.q_();
	}

	public void a(vx var1) {
		this.b.a(var1);
		this.c.a(var1);
	}

	public vx i() {
		return this.b.i();
	}

	public String getInventoryType() {
		return this.b.getInventoryType();
	}

	public Container a(PlayerInventory var1, EntityHuman var2) {
		return new ContainerChest(var1, this, var2);
	}

	public void clearInventory() {
		this.b.clearInventory();
		this.c.clearInventory();
	}
}
