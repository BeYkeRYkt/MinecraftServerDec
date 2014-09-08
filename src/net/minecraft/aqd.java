package net.minecraft;

import java.util.ArrayList;

public class aqd extends ArrayList {

	public aqd() {
	}

	public aqd(NBTCompoundTag var1) {
		this.a(var1);
	}

	public aqc a(ItemStack var1, ItemStack var2, int var3) {
		if (var3 > 0 && var3 < this.size()) {
			aqc var6 = (aqc) this.get(var3);
			return ItemStack.c(var1, var6.a()) && (var2 == null && !var6.c() || var6.c() && ItemStack.c(var2, var6.b())) && var1.amount >= var6.a().amount && (!var6.c() || var2.amount >= var6.b().amount) ? var6 : null;
		} else {
			for (int var4 = 0; var4 < this.size(); ++var4) {
				aqc var5 = (aqc) this.get(var4);
				if (ItemStack.c(var1, var5.a()) && var1.amount >= var5.a().amount && (!var5.c() && var2 == null || var5.c() && ItemStack.c(var2, var5.b()) && var2.amount >= var5.b().amount)) {
					return var5;
				}
			}

			return null;
		}
	}

	public void a(PacketDataSerializer var1) {
		var1.writeByte((byte) (this.size() & 255));

		for (int var2 = 0; var2 < this.size(); ++var2) {
			aqc var3 = (aqc) this.get(var2);
			var1.writeItemStack(var3.a());
			var1.writeItemStack(var3.d());
			ItemStack var4 = var3.b();
			var1.writeBoolean(var4 != null);
			if (var4 != null) {
				var1.writeItemStack(var4);
			}

			var1.writeBoolean(var3.h());
			var1.writeInt(var3.e());
			var1.writeInt(var3.f());
		}

	}

	public void a(NBTCompoundTag var1) {
		NBTListTag var2 = var1.getList("Recipes", 10);

		for (int var3 = 0; var3 < var2.getSize(); ++var3) {
			NBTCompoundTag var4 = var2.getCompound(var3);
			this.add(new aqc(var4));
		}

	}

	public NBTCompoundTag a() {
		NBTCompoundTag var1 = new NBTCompoundTag();
		NBTListTag var2 = new NBTListTag();

		for (int var3 = 0; var3 < this.size(); ++var3) {
			aqc var4 = (aqc) this.get(var3);
			var2.addTag((NBTTag) var4.k());
		}

		var1.put("Recipes", (NBTTag) var2);
		return var1;
	}
}
