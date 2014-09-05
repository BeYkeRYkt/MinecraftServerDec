package net.minecraft;

public class aqc {

	private ItemStack a;
	private ItemStack b;
	private ItemStack c;
	private int d;
	private int e;
	private boolean f;

	public aqc(NBTCompoundTag var1) {
		this.a(var1);
	}

	public aqc(ItemStack var1, ItemStack var2, ItemStack var3) {
		this(var1, var2, var3, 0, 7);
	}

	public aqc(ItemStack var1, ItemStack var2, ItemStack var3, int var4, int var5) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
		this.d = var4;
		this.e = var5;
		this.f = true;
	}

	public aqc(ItemStack var1, ItemStack var2) {
		this(var1, (ItemStack) null, var2);
	}

	public aqc(ItemStack var1, Item var2) {
		this(var1, new ItemStack(var2));
	}

	public ItemStack a() {
		return this.a;
	}

	public ItemStack b() {
		return this.b;
	}

	public boolean c() {
		return this.b != null;
	}

	public ItemStack d() {
		return this.c;
	}

	public int e() {
		return this.d;
	}

	public int f() {
		return this.e;
	}

	public void g() {
		++this.d;
	}

	public void a(int var1) {
		this.e += var1;
	}

	public boolean h() {
		return this.d >= this.e;
	}

	public boolean j() {
		return this.f;
	}

	public void a(NBTCompoundTag var1) {
		NBTCompoundTag var2 = var1.getCompound("buy");
		this.a = ItemStack.a(var2);
		NBTCompoundTag var3 = var1.getCompound("sell");
		this.c = ItemStack.a(var3);
		if (var1.isTagAssignableFrom("buyB", 10)) {
			this.b = ItemStack.a(var1.getCompound("buyB"));
		}

		if (var1.isTagAssignableFrom("uses", 99)) {
			this.d = var1.getInt("uses");
		}

		if (var1.isTagAssignableFrom("maxUses", 99)) {
			this.e = var1.getInt("maxUses");
		} else {
			this.e = 7;
		}

		if (var1.isTagAssignableFrom("rewardExp", 1)) {
			this.f = var1.getBoolean("rewardExp");
		} else {
			this.f = true;
		}

	}

	public NBTCompoundTag k() {
		NBTCompoundTag var1 = new NBTCompoundTag();
		var1.put("buy", (NBTTag) this.a.b(new NBTCompoundTag()));
		var1.put("sell", (NBTTag) this.c.b(new NBTCompoundTag()));
		if (this.b != null) {
			var1.put("buyB", (NBTTag) this.b.b(new NBTCompoundTag()));
		}

		var1.put("uses", this.d);
		var1.put("maxUses", this.e);
		var1.put("rewardExp", this.f);
		return var1;
	}
}
