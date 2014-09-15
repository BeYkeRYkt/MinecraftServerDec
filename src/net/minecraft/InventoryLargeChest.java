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

	public int n_() {
		return this.b.n_() + this.c.n_();
	}

	public boolean a(IInventory var1) {
		return this.b == var1 || this.c == var1;
	}

	public String getName() {
		return this.b.k_() ? this.b.getName() : (this.c.k_() ? this.c.getName() : this.a);
	}

	public boolean k_() {
		return this.b.k_() || this.c.k_();
	}

	public IChatBaseComponent getComponentName() {
		return (IChatBaseComponent) (this.k_() ? new ChatComponentText(this.getName()) : new ChatMessage(this.getName(), new Object[0]));
	}

	public ItemStack a(int var1) {
		return var1 >= this.b.n_() ? this.c.a(var1 - this.b.n_()) : this.b.a(var1);
	}

	public ItemStack a(int var1, int var2) {
		return var1 >= this.b.n_() ? this.c.a(var1 - this.b.n_(), var2) : this.b.a(var1, var2);
	}

	public ItemStack b(int var1) {
		return var1 >= this.b.n_() ? this.c.b(var1 - this.b.n_()) : this.b.b(var1);
	}

	public void a(int var1, ItemStack var2) {
		if (var1 >= this.b.n_()) {
			this.c.a(var1 - this.b.n_(), var2);
		} else {
			this.b.a(var1, var2);
		}

	}

	public int p_() {
		return this.b.p_();
	}

	public void update() {
		this.b.update();
		this.c.update();
	}

	public boolean a(EntityHuman var1) {
		return this.b.a(var1) && this.c.a(var1);
	}

	public void b(EntityHuman var1) {
		this.b.b(var1);
		this.c.b(var1);
	}

	public void c(EntityHuman var1) {
		this.b.c(var1);
		this.c.c(var1);
	}

	public boolean b(int var1, ItemStack var2) {
		return true;
	}

	public int a_(int var1) {
		return 0;
	}

	public void b(int var1, int var2) {
	}

	public int g() {
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

	public String k() {
		return this.b.k();
	}

	public Container a(PlayerInventory var1, EntityHuman var2) {
		return new ContainerChest(var1, this, var2);
	}

	public void l() {
		this.b.l();
		this.c.l();
	}
}
