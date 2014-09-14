package net.minecraft;

public class ItemWrittenBook extends Item {

	public ItemWrittenBook() {
		this.setMaxStackSize(1);
	}

	public static boolean isValid(NBTCompoundTag tag) {
		if (!ItemBookAndQuill.isValid(tag)) {
			return false;
		} else if (!tag.isTagAssignableFrom("title", 8)) {
			return false;
		} else {
			String title = tag.getString("title");
			return title != null && title.length() <= 32 ? tag.isTagAssignableFrom("author", 8) : false;
		}
	}

	public static int h(ItemStack var0) {
		return var0.getTag().getInt("generation");
	}

	public String a(ItemStack var1) {
		if (var1.hasTag()) {
			NBTCompoundTag var2 = var1.getTag();
			String var3 = var2.getString("title");
			if (!vb.b(var3)) {
				return var3;
			}
		}

		return super.a(var1);
	}

	public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
		if (!var2.isStatic) {
			this.a(var1, var3);
		}

		var3.a(var1);
		var3.b(StatisticList.USE_ITEM_COUNT[Item.getId((Item) this)]);
		return var1;
	}

	private void a(ItemStack var1, EntityHuman var2) {
		if (var1 != null && var1.getTag() != null) {
			NBTCompoundTag var3 = var1.getTag();
			if (!var3.getBoolean("resolved")) {
				var3.put("resolved", true);
				if (isValid(var3)) {
					NBTListTag var4 = var3.getList("pages", 8);

					for (int var5 = 0; var5 < var4.getSize(); ++var5) {
						String var6 = var4.getString(var5);

						Object var7;
						try {
							IChatBaseComponent var11 = ChatSerializer.fromJsonString(var6);
							var7 = hq.a(var2, var11, var2);
						} catch (Exception var9) {
							var7 = new ChatComponentText(var6);
						}

						var4.setTag(var5, new NBTStringTag(ChatSerializer.toJsonString((IChatBaseComponent) var7)));
					}

					var3.put("pages", (NBTTag) var4);
					if (var2 instanceof EntityPlayer && var2.bY() == var1) {
						Slot var10 = var2.activeContainer.a((IInventory) var2.playerInventory, var2.playerInventory.itemInHandIndex);
						((EntityPlayer) var2).playerConnection.sendPacket((Packet) (new PacketPlayOutSetSlot(0, var10.index, var1)));
					}

				}
			}
		}
	}
}
