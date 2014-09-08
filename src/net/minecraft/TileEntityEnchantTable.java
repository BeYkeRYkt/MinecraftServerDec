package net.minecraft;

import java.util.Random;

public class TileEntityEnchantTable extends TileEntity implements PacketTickable, vv {

	public int a;
	public float f;
	public float g;
	public float h;
	public float i;
	public float j;
	public float k;
	public float l;
	public float m;
	public float n;
	private static Random o = new Random();
	private String p;

	public void write(NBTCompoundTag var1) {
		super.write(var1);
		if (this.k_()) {
			var1.put("CustomName", this.p);
		}

	}

	public void read(NBTCompoundTag var1) {
		super.read(var1);
		if (var1.isTagAssignableFrom("CustomName", 8)) {
			this.p = var1.getString("CustomName");
		}

	}

	public void doTick() {
		this.k = this.j;
		this.m = this.l;
		EntityHuman var1 = this.world.a((double) ((float) this.position.getX() + 0.5F), (double) ((float) this.position.getY() + 0.5F), (double) ((float) this.position.getZ() + 0.5F), 3.0D);
		if (var1 != null) {
			double var2 = var1.locationX - (double) ((float) this.position.getX() + 0.5F);
			double var4 = var1.locationZ - (double) ((float) this.position.getZ() + 0.5F);
			this.n = (float) Math.atan2(var4, var2);
			this.j += 0.1F;
			if (this.j < 0.5F || o.nextInt(40) == 0) {
				float var6 = this.h;

				do {
					this.h += (float) (o.nextInt(4) - o.nextInt(4));
				} while (var6 == this.h);
			}
		} else {
			this.n += 0.02F;
			this.j -= 0.1F;
		}

		while (this.l >= 3.1415927F) {
			this.l -= 6.2831855F;
		}

		while (this.l < -3.1415927F) {
			this.l += 6.2831855F;
		}

		while (this.n >= 3.1415927F) {
			this.n -= 6.2831855F;
		}

		while (this.n < -3.1415927F) {
			this.n += 6.2831855F;
		}

		float var7;
		for (var7 = this.n - this.l; var7 >= 3.1415927F; var7 -= 6.2831855F) {
			;
		}

		while (var7 < -3.1415927F) {
			var7 += 6.2831855F;
		}

		this.l += var7 * 0.4F;
		this.j = DataTypesConverter.a(this.j, 0.0F, 1.0F);
		++this.a;
		this.g = this.f;
		float var3 = (this.h - this.f) * 0.4F;
		float var8 = 0.2F;
		var3 = DataTypesConverter.a(var3, -var8, var8);
		this.i += (var3 - this.i) * 0.9F;
		this.f += this.i;
	}

	public String d_() {
		return this.k_() ? this.p : "container.enchant";
	}

	public boolean k_() {
		return this.p != null && this.p.length() > 0;
	}

	public void a(String var1) {
		this.p = var1;
	}

	public IChatBaseComponent e_() {
		return (IChatBaseComponent) (this.k_() ? new ChatComponentText(this.d_()) : new ChatMessage(this.d_(), new Object[0]));
	}

	public Container a(PlayerInventory var1, EntityHuman var2) {
		return new aiq(var1, this.world, this.position);
	}

	public String k() {
		return "minecraft:enchanting_table";
	}

}
