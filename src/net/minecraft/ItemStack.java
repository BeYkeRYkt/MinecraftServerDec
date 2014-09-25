package net.minecraft;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import java.text.DecimalFormat;
import java.util.Random;

public final class ItemStack {

	public static final DecimalFormat format = new DecimalFormat("#.###");

	public static ItemStack fromNBT(NBTCompoundTag tag) {
		ItemStack itemStack = new ItemStack();
		itemStack.read(tag);
		return itemStack.getItem() != null ? itemStack : null;
	}

	public static boolean isSameNBTTags(ItemStack itemStack1, ItemStack itemStack2) {
		return itemStack1 == null && itemStack2 == null ? true : (itemStack1 != null && itemStack2 != null ? (itemStack1.tag == null && itemStack2.tag != null ? false : itemStack1.tag == null || itemStack1.tag.equals(itemStack2.tag)) : false);
	}

	public static boolean matches(ItemStack itemStack1, ItemStack itemStack2) {
		return itemStack1 == null && itemStack2 == null ? true : (itemStack1 != null && itemStack2 != null ? itemStack1.isSame(itemStack2) : false);
	}

	private boolean isSame(ItemStack itemStack) {
		return this.amount != itemStack.amount ? false : (this.item != itemStack.item ? false : (this.wearout != itemStack.wearout ? false : (this.tag == null && itemStack.tag != null ? false : this.tag == null || this.tag.equals(itemStack.tag))));
	}

	public static boolean c(ItemStack itemStack1, ItemStack itemStack2) {
		return itemStack1 == null && itemStack2 == null ? true : (itemStack1 != null && itemStack2 != null ? itemStack1.a(itemStack2) : false);
	}

	public static ItemStack getCopy(ItemStack itemStack) {
		return itemStack == null ? null : itemStack.getCopy();
	}

	public int amount;
	public int c;
	private Item item;
	private NBTCompoundTag tag;
	private int wearout;
	private EntityItemFrame g;
	private Block h;
	private boolean i;
	private Block j;
	private boolean k;

	public ItemStack(Block block) {
		this(block, 1);
	}

	public ItemStack(Block block, int amount) {
		this(block, amount, 0);
	}

	public ItemStack(Block block, int amount, int wearout) {
		this(Item.getItemOf(block), amount, wearout);
	}

	public ItemStack(Item item) {
		this(item, 1);
	}

	public ItemStack(Item item, int amount) {
		this(item, amount, 0);
	}

	public ItemStack(Item item, int amount, int wearout) {
		this.h = null;
		this.i = false;
		this.j = null;
		this.k = false;
		this.item = item;
		this.amount = amount;
		this.wearout = wearout;
		if (this.wearout < 0) {
			this.wearout = 0;
		}

	}

	private ItemStack() {
		this.h = null;
		this.i = false;
		this.j = null;
		this.k = false;
	}

	public ItemStack a(int var1) {
		ItemStack var2 = new ItemStack(this.item, var1, this.wearout);
		if (this.tag != null) {
			var2.tag = (NBTCompoundTag) this.tag.getCopy();
		}

		this.amount -= var1;
		return var2;
	}

	public Item getItem() {
		return this.item;
	}

	public boolean a(EntityHuman var1, World var2, Position var3, BlockFace var4, float var5, float var6, float var7) {
		boolean var8 = this.getItem().a(this, var1, var2, var3, var4, var5, var6, var7);
		if (var8) {
			var1.b(StatisticList.USE_ITEM_COUNT[Item.getId(this.item)]);
		}

		return var8;
	}

	public float a(Block var1) {
		return this.getItem().a(this, var1);
	}

	public ItemStack a(World var1, EntityHuman var2) {
		return this.getItem().a(this, var1, var2);
	}

	public ItemStack b(World var1, EntityHuman var2) {
		return this.getItem().b(this, var1, var2);
	}

	public NBTCompoundTag write(NBTCompoundTag tag) {
		RegistryObjectName nameId = (RegistryObjectName) Item.REGISTRY.c(this.item);
		tag.put("id", nameId == null ? "minecraft:air" : nameId.toString());
		tag.put("Count", (byte) this.amount);
		tag.put("Damage", (short) this.wearout);
		if (this.tag != null) {
			tag.put("tag", (NBTTag) this.tag);
		}

		return tag;
	}

	public void read(NBTCompoundTag tag) {
		if (tag.isTagAssignableFrom("id", 8)) {
			this.item = Item.getByName(tag.getString("id"));
		} else {
			this.item = Item.getById(tag.getShort("id"));
		}

		this.amount = tag.getByte("Count");
		this.wearout = tag.getShort("Damage");
		if (this.wearout < 0) {
			this.wearout = 0;
		}

		if (tag.isTagAssignableFrom("tag", 10)) {
			this.tag = tag.getCompound("tag");
			if (this.item != null) {
				this.item.a(this.tag);
			}
		}
	}

	public int getMaxStackSize() {
		return this.getItem().getMaxStackSize();
	}

	public boolean d() {
		return this.getMaxStackSize() > 1 && (!this.e() || !this.g());
	}

	public boolean e() {
		return this.item == null ? false : (this.item.getMaxWearout() <= 0 ? false : !this.hasTag() || !this.getTag().getBoolean("Unbreakable"));
	}

	public boolean f() {
		return this.item.k();
	}

	public boolean g() {
		return this.e() && this.wearout > 0;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getWearout() {
		return this.wearout;
	}

	public void setWearout(int wearout) {
		this.wearout = wearout;
		if (this.wearout < 0) {
			this.wearout = 0;
		}

	}

	public int getMaxWearout() {
		return this.item.getMaxWearout();
	}

	public boolean a(int var1, Random var2) {
		if (!this.e()) {
			return false;
		} else {
			if (var1 > 0) {
				int var3 = aph.a(Enchantment.DURABILITY.id, this);
				int var4 = 0;

				for (int var5 = 0; var3 > 0 && var5 < var1; ++var5) {
					if (EnchantmentDurability.a(this, var3, var2)) {
						++var4;
					}
				}

				var1 -= var4;
				if (var1 <= 0) {
					return false;
				}
			}

			this.wearout += var1;
			return this.wearout > this.getMaxWearout();
		}
	}

	public void a(int var1, EntityLiving var2) {
		if (!(var2 instanceof EntityHuman) || !((EntityHuman) var2).playerProperties.instabuild) {
			if (this.e()) {
				if (this.a(var1, var2.bb())) {
					var2.b(this);
					--this.amount;
					if (var2 instanceof EntityHuman) {
						EntityHuman var3 = (EntityHuman) var2;
						var3.b(StatisticList.BREAK_ITEM_COUNT[Item.getId(this.item)]);
						if (this.amount == 0 && this.getItem() instanceof ItemBow) {
							var3.bZ();
						}
					}

					if (this.amount < 0) {
						this.amount = 0;
					}

					this.wearout = 0;
				}

			}
		}
	}

	public void a(EntityLiving var1, EntityHuman var2) {
		boolean var3 = this.item.a(this, var1, (EntityLiving) var2);
		if (var3) {
			var2.b(StatisticList.USE_ITEM_COUNT[Item.getId(this.item)]);
		}

	}

	public void a(World var1, Block var2, Position var3, EntityHuman var4) {
		boolean var5 = this.item.a(this, var1, var2, var3, var4);
		if (var5) {
			var4.b(StatisticList.USE_ITEM_COUNT[Item.getId(this.item)]);
		}

	}

	public boolean canDestroySpecialBlock(Block var1) {
		return this.item.canDestroySpecialBlock(var1);
	}

	public boolean a(EntityHuman var1, EntityLiving var2) {
		return this.item.a(this, var1, var2);
	}

	public ItemStack getCopy() {
		ItemStack var1 = new ItemStack(this.item, this.amount, this.wearout);
		if (this.tag != null) {
			var1.tag = (NBTCompoundTag) this.tag.getCopy();
		}

		return var1;
	}



	public boolean a(ItemStack var1) {
		return var1 != null && this.item == var1.item && this.wearout == var1.wearout;
	}

	public String a() {
		return this.item.getName(this);
	}

	public String toString() {
		return this.amount + "x" + this.item.getName() + "@" + this.wearout;
	}

	public void a(World var1, Entity var2, int var3, boolean var4) {
		if (this.c > 0) {
			--this.c;
		}

		this.item.a(this, var1, var2, var3, var4);
	}

	public void a(World var1, EntityHuman var2, int var3) {
		var2.a(StatisticList.CRAFT_BLOCK_COUNT[Item.getId(this.item)], var3);
		this.item.d(this, var1, var2);
	}

	public int l() {
		return this.getItem().d(this);
	}

	public EnumAnimation m() {
		return this.getItem().e(this);
	}

	public void b(World var1, EntityHuman var2, int var3) {
		this.getItem().a(this, var1, var2, var3);
	}

	public boolean hasTag() {
		return this.tag != null;
	}

	public NBTCompoundTag getTag() {
		return this.tag;
	}

	public NBTCompoundTag a(String var1, boolean var2) {
		if (this.tag != null && this.tag.isTagAssignableFrom(var1, 10)) {
			return this.tag.getCompound(var1);
		} else if (var2) {
			NBTCompoundTag var3 = new NBTCompoundTag();
			this.addTag(var1, (NBTTag) var3);
			return var3;
		} else {
			return null;
		}
	}

	public NBTListTag getEnchantmentsTag() {
		return this.tag == null ? null : this.tag.getList("ench", 10);
	}

	public boolean hasDisplayName() {
		return this.tag == null ? false : (!this.tag.isTagAssignableFrom("display", 10) ? false : this.tag.getCompound("display").isTagAssignableFrom("Name", 8));
	}

	public void setTag(NBTCompoundTag tag) {
		this.tag = tag;
	}

	public String getDisplayName() {
		String defaultName = this.getItem().a(this);
		if (this.tag != null && this.tag.isTagAssignableFrom("display", 10)) {
			NBTCompoundTag displayTag = this.tag.getCompound("display");
			if (displayTag.isTagAssignableFrom("Name", 8)) {
				defaultName = displayTag.getString("Name");
			}
		}

		return defaultName;
	}

	public ItemStack setDisplayName(String name) {
		if (this.tag == null) {
			this.tag = new NBTCompoundTag();
		}

		if (!this.tag.isTagAssignableFrom("display", 10)) {
			this.tag.put("display", new NBTCompoundTag());
		}

		this.tag.getCompound("display").put("Name", name);
		return this;
	}

	public void removeDisplayName() {
		if (this.tag != null) {
			if (this.tag.isTagAssignableFrom("display", 10)) {
				NBTCompoundTag displayTag = this.tag.getCompound("display");
				displayTag.remove("Name");
				if (displayTag.isEmpty()) {
					this.tag.remove("display");
					if (this.tag.isEmpty()) {
						this.setTag(null);
					}
				}
			}
		}
	}

	public amx u() {
		return this.getItem().g(this);
	}

	public boolean v() {
		return !this.getItem().f_(this) ? false : !this.w();
	}

	public void a(Enchantment var1, int var2) {
		if (this.tag == null) {
			this.setTag(new NBTCompoundTag());
		}

		if (!this.tag.isTagAssignableFrom("ench", 9)) {
			this.tag.put("ench", (NBTTag) (new NBTListTag()));
		}

		NBTListTag var3 = this.tag.getList("ench", 10);
		NBTCompoundTag var4 = new NBTCompoundTag();
		var4.put("id", (short) var1.id);
		var4.put("lvl", (short) ((byte) var2));
		var3.addTag((NBTTag) var4);
	}

	public boolean w() {
		return this.tag != null && this.tag.isTagAssignableFrom("ench", 9);
	}

	public void addTag(String tagName, NBTTag tag) {
		if (this.tag == null) {
			this.setTag(new NBTCompoundTag());
		}

		this.tag.put(tagName, tag);
	}

	public boolean x() {
		return this.getItem().s();
	}

	public boolean y() {
		return this.g != null;
	}

	public void a(EntityItemFrame var1) {
		this.g = var1;
	}

	public EntityItemFrame z() {
		return this.g;
	}

	public int A() {
		return this.hasTag() && this.tag.isTagAssignableFrom("RepairCost", 3) ? this.tag.getInt("RepairCost") : 0;
	}

	public void c(int var1) {
		if (!this.hasTag()) {
			this.tag = new NBTCompoundTag();
		}

		this.tag.put("RepairCost", var1);
	}

	public Multimap B() {
		Object var1;
		if (this.hasTag() && this.tag.isTagAssignableFrom("AttributeModifiers", 9)) {
			var1 = HashMultimap.create();
			NBTListTag var2 = this.tag.getList("AttributeModifiers", 10);

			for (int var3 = 0; var3 < var2.getSize(); ++var3) {
				NBTCompoundTag var4 = var2.getCompound(var3);
				AttributeModifier var5 = afs.a(var4);
				if (var5 != null && var5.getUUID().getLeastSignificantBits() != 0L && var5.getUUID().getMostSignificantBits() != 0L) {
					((Multimap) var1).put(var4.getString("AttributeName"), var5);
				}
			}
		} else {
			var1 = this.getItem().i();
		}

		return (Multimap) var1;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public IChatBaseComponent C() {
		ChatComponentText var1 = new ChatComponentText(this.getDisplayName());
		if (this.hasDisplayName()) {
			var1.getChatModifier().b(Boolean.valueOf(true));
		}

		IChatBaseComponent var2 = (new ChatComponentText("[")).a(var1).a("]");
		if (this.item != null) {
			NBTCompoundTag var3 = new NBTCompoundTag();
			this.write(var3);
			var2.getChatModifier().a(new ChatHoverable(EnumHoverAction.c, new ChatComponentText(var3.toString())));
			var2.getChatModifier().setColor(this.u().e);
		}

		return var2;
	}

	public boolean c(Block var1) {
		if (var1 == this.h) {
			return this.i;
		} else {
			this.h = var1;
			if (this.hasTag() && this.tag.isTagAssignableFrom("CanDestroy", 9)) {
				NBTListTag var2 = this.tag.getList("CanDestroy", 8);

				for (int var3 = 0; var3 < var2.getSize(); ++var3) {
					Block var4 = Block.getBlockByName(var2.getString(var3));
					if (var4 == var1) {
						this.i = true;
						return true;
					}
				}
			}

			this.i = false;
			return false;
		}
	}

	public boolean d(Block var1) {
		if (var1 == this.j) {
			return this.k;
		} else {
			this.j = var1;
			if (this.hasTag() && this.tag.isTagAssignableFrom("CanPlaceOn", 9)) {
				NBTListTag var2 = this.tag.getList("CanPlaceOn", 8);

				for (int var3 = 0; var3 < var2.getSize(); ++var3) {
					Block var4 = Block.getBlockByName(var2.getString(var3));
					if (var4 == var1) {
						this.k = true;
						return true;
					}
				}
			}

			this.k = false;
			return false;
		}
	}

}
