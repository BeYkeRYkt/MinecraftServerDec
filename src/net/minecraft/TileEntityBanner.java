package net.minecraft;

import java.util.List;

public class TileEntityBanner extends TileEntity {

	private int a;
	private NBTListTag f;
	private boolean g;
	private List h;
	private List i;
	private String j;

	public void a(ItemStack var1) {
		this.f = null;
		if (var1.hasTag() && var1.getTag().isTagAssignableFrom("BlockEntityTag", 10)) {
			NBTCompoundTag var2 = var1.getTag().getCompound("BlockEntityTag");
			if (var2.hasKey("Patterns")) {
				this.f = (NBTListTag) var2.getList("Patterns", 10).getCopy();
			}

			if (var2.isTagAssignableFrom("Base", 99)) {
				this.a = var2.getInt("Base");
			} else {
				this.a = var1.i() & 15;
			}
		} else {
			this.a = var1.i() & 15;
		}

		this.h = null;
		this.i = null;
		this.j = "";
		this.g = true;
	}

	public void write(NBTCompoundTag var1) {
		super.write(var1);
		var1.put("Base", this.a);
		if (this.f != null) {
			var1.put("Patterns", (NBTTag) this.f);
		}

	}

	public void read(NBTCompoundTag var1) {
		super.read(var1);
		this.a = var1.getInt("Base");
		this.f = var1.getList("Patterns", 10);
		this.h = null;
		this.i = null;
		this.j = null;
		this.g = true;
	}

	public Packet getUpdatePacket() {
		NBTCompoundTag var1 = new NBTCompoundTag();
		this.write(var1);
		return new PacketOutUpdateBlockEntity(this.position, 6, var1);
	}

	public int b() {
		return this.a;
	}

	public static int b(ItemStack var0) {
		NBTCompoundTag var1 = var0.a("BlockEntityTag", false);
		return var1 != null && var1.hasKey("Base") ? var1.getInt("Base") : var0.i();
	}

	public static int c(ItemStack var0) {
		NBTCompoundTag var1 = var0.a("BlockEntityTag", false);
		return var1 != null && var1.hasKey("Patterns") ? var1.getList("Patterns", 10).getSize() : 0;
	}

	public static void e(ItemStack var0) {
		NBTCompoundTag var1 = var0.a("BlockEntityTag", false);
		if (var1 != null && var1.isTagAssignableFrom("Patterns", 9)) {
			NBTListTag var2 = var1.getList("Patterns", 10);
			if (var2.getSize() > 0) {
				var2.removeTag(var2.getSize() - 1);
				if (var2.isEmpty()) {
					var0.getTag().remove("BlockEntityTag");
					if (var0.getTag().isEmpty()) {
						var0.d((NBTCompoundTag) null);
					}
				}

			}
		}
	}
}
