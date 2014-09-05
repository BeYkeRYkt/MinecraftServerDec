package net.minecraft;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import java.text.DecimalFormat;
import java.util.Random;

public final class ItemStack {

	public static final DecimalFormat a = new DecimalFormat("#.###");
	public int b;
	public int c;
	private Item item;
	private NBTCompoundTag tag;
	private int f;
	private adk g;
	private Block h;
	private boolean i;
	private Block j;
	private boolean k;

	public ItemStack(Block var1) {
		this(var1, 1);
	}

	public ItemStack(Block var1, int var2) {
		this(var1, var2, 0);
	}

	public ItemStack(Block var1, int var2, int var3) {
		this(Item.getItemOf(var1), var2, var3);
	}

	public ItemStack(Item var1) {
		this(var1, 1);
	}

	public ItemStack(Item var1, int var2) {
		this(var1, var2, 0);
	}

	public ItemStack(Item var1, int var2, int var3) {
		this.h = null;
		this.i = false;
		this.j = null;
		this.k = false;
		this.item = var1;
		this.b = var2;
		this.f = var3;
		if (this.f < 0) {
			this.f = 0;
		}

	}

	public static ItemStack a(NBTCompoundTag var0) {
		ItemStack var1 = new ItemStack();
		var1.c(var0);
		return var1.getItem() != null ? var1 : null;
	}

	private ItemStack() {
		this.h = null;
		this.i = false;
		this.j = null;
		this.k = false;
	}

	public ItemStack a(int var1) {
		ItemStack var2 = new ItemStack(this.item, var1, this.f);
		if (this.tag != null) {
			var2.tag = (NBTCompoundTag) this.tag.getCopy();
		}

		this.b -= var1;
		return var2;
	}

	public Item getItem() {
		return this.item;
	}

	public boolean a(EntityHuman var1, World var2, Position var3, PaintingDirection var4, float var5, float var6, float var7) {
		boolean var8 = this.getItem().a(this, var1, var2, var3, var4, var5, var6, var7);
		if (var8) {
			var1.b(ty.J[Item.getId(this.item)]);
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

	public NBTCompoundTag b(NBTCompoundTag var1) {
		BlockNameInfo var2 = (BlockNameInfo) Item.REGISTRY.c(this.item);
		var1.put("id", var2 == null ? "minecraft:air" : var2.toString());
		var1.put("Count", (byte) this.b);
		var1.put("Damage", (short) this.f);
		if (this.tag != null) {
			var1.put("tag", (NBTTag) this.tag);
		}

		return var1;
	}

	public void c(NBTCompoundTag var1) {
		if (var1.isTagAssignableFrom("id", 8)) {
			this.item = Item.d(var1.getString("id"));
		} else {
			this.item = Item.getById(var1.getShort("id"));
		}

		this.b = var1.getByte("Count");
		this.f = var1.getShort("Damage");
		if (this.f < 0) {
			this.f = 0;
		}

		if (var1.isTagAssignableFrom("tag", 10)) {
			this.tag = var1.getCompound("tag");
			if (this.item != null) {
				this.item.a(this.tag);
			}
		}

	}

	public int c() {
		return this.getItem().j();
	}

	public boolean d() {
		return this.c() > 1 && (!this.e() || !this.g());
	}

	public boolean e() {
		return this.item == null ? false : (this.item.l() <= 0 ? false : !this.hasTag() || !this.getTag().getBoolean("Unbreakable"));
	}

	public boolean f() {
		return this.item.k();
	}

	public boolean g() {
		return this.e() && this.f > 0;
	}

	public int h() {
		return this.f;
	}

	public int i() {
		return this.f;
	}

	public void b(int var1) {
		this.f = var1;
		if (this.f < 0) {
			this.f = 0;
		}

	}

	public int j() {
		return this.item.l();
	}

	public boolean a(int var1, Random var2) {
		if (!this.e()) {
			return false;
		} else {
			if (var1 > 0) {
				int var3 = aph.a(apf.t.B, this);
				int var4 = 0;

				for (int var5 = 0; var3 > 0 && var5 < var1; ++var5) {
					if (apd.a(this, var3, var2)) {
						++var4;
					}
				}

				var1 -= var4;
				if (var1 <= 0) {
					return false;
				}
			}

			this.f += var1;
			return this.f > this.j();
		}
	}

	public void a(int var1, EntityLiving var2) {
		if (!(var2 instanceof EntityHuman) || !((EntityHuman) var2).by.instabuild) {
			if (this.e()) {
				if (this.a(var1, var2.bb())) {
					var2.b(this);
					--this.b;
					if (var2 instanceof EntityHuman) {
						EntityHuman var3 = (EntityHuman) var2;
						var3.b(ty.K[Item.getId(this.item)]);
						if (this.b == 0 && this.getItem() instanceof ajz) {
							var3.bZ();
						}
					}

					if (this.b < 0) {
						this.b = 0;
					}

					this.f = 0;
				}

			}
		}
	}

	public void a(EntityLiving var1, EntityHuman var2) {
		boolean var3 = this.item.a(this, var1, (EntityLiving) var2);
		if (var3) {
			var2.b(ty.J[Item.getId(this.item)]);
		}

	}

	public void a(World var1, Block var2, Position var3, EntityHuman var4) {
		boolean var5 = this.item.a(this, var1, var2, var3, var4);
		if (var5) {
			var4.b(ty.J[Item.getId(this.item)]);
		}

	}

	public boolean b(Block var1) {
		return this.item.b(var1);
	}

	public boolean a(EntityHuman var1, EntityLiving var2) {
		return this.item.a(this, var1, var2);
	}

	public ItemStack getCopy() {
		ItemStack var1 = new ItemStack(this.item, this.b, this.f);
		if (this.tag != null) {
			var1.tag = (NBTCompoundTag) this.tag.getCopy();
		}

		return var1;
	}

	public static boolean a(ItemStack var0, ItemStack var1) {
		return var0 == null && var1 == null ? true : (var0 != null && var1 != null ? (var0.tag == null && var1.tag != null ? false : var0.tag == null || var0.tag.equals(var1.tag)) : false);
	}

	public static boolean b(ItemStack var0, ItemStack var1) {
		return var0 == null && var1 == null ? true : (var0 != null && var1 != null ? var0.d(var1) : false);
	}

	private boolean d(ItemStack var1) {
		return this.b != var1.b ? false : (this.item != var1.item ? false : (this.f != var1.f ? false : (this.tag == null && var1.tag != null ? false : this.tag == null || this.tag.equals(var1.tag))));
	}

	public static boolean c(ItemStack var0, ItemStack var1) {
		return var0 == null && var1 == null ? true : (var0 != null && var1 != null ? var0.a(var1) : false);
	}

	public boolean a(ItemStack var1) {
		return var1 != null && this.item == var1.item && this.f == var1.f;
	}

	public String a() {
		return this.item.e_(this);
	}

	public static ItemStack b(ItemStack var0) {
		return var0 == null ? null : var0.getCopy();
	}

	public String toString() {
		return this.b + "x" + this.item.a() + "@" + this.f;
	}

	public void a(World var1, Entity var2, int var3, boolean var4) {
		if (this.c > 0) {
			--this.c;
		}

		this.item.a(this, var1, var2, var3, var4);
	}

	public void a(World var1, EntityHuman var2, int var3) {
		var2.a(ty.I[Item.getId(this.item)], var3);
		this.item.d(this, var1, var2);
	}

	public int l() {
		return this.getItem().d(this);
	}

	public ano m() {
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
			this.a(var1, (NBTTag) var3);
			return var3;
		} else {
			return null;
		}
	}

	public NBTListTag p() {
		return this.tag == null ? null : this.tag.getList("ench", 10);
	}

	public void d(NBTCompoundTag var1) {
		this.tag = var1;
	}

	public String q() {
		String var1 = this.getItem().a(this);
		if (this.tag != null && this.tag.isTagAssignableFrom("display", 10)) {
			NBTCompoundTag var2 = this.tag.getCompound("display");
			if (var2.isTagAssignableFrom("Name", 8)) {
				var1 = var2.getString("Name");
			}
		}

		return var1;
	}

	public ItemStack c(String var1) {
		if (this.tag == null) {
			this.tag = new NBTCompoundTag();
		}

		if (!this.tag.isTagAssignableFrom("display", 10)) {
			this.tag.put("display", (NBTTag) (new NBTCompoundTag()));
		}

		this.tag.getCompound("display").put("Name", var1);
		return this;
	}

	public void r() {
		if (this.tag != null) {
			if (this.tag.isTagAssignableFrom("display", 10)) {
				NBTCompoundTag var1 = this.tag.getCompound("display");
				var1.remove("Name");
				if (var1.isEmpty()) {
					this.tag.remove("display");
					if (this.tag.isEmpty()) {
						this.d((NBTCompoundTag) null);
					}
				}

			}
		}
	}

	public boolean s() {
		return this.tag == null ? false : (!this.tag.isTagAssignableFrom("display", 10) ? false : this.tag.getCompound("display").isTagAssignableFrom("Name", 8));
	}

	public amx u() {
		return this.getItem().g(this);
	}

	public boolean v() {
		return !this.getItem().f_(this) ? false : !this.w();
	}

	public void a(apf var1, int var2) {
		if (this.tag == null) {
			this.d(new NBTCompoundTag());
		}

		if (!this.tag.isTagAssignableFrom("ench", 9)) {
			this.tag.put("ench", (NBTTag) (new NBTListTag()));
		}

		NBTListTag var3 = this.tag.getList("ench", 10);
		NBTCompoundTag var4 = new NBTCompoundTag();
		var4.put("id", (short) var1.B);
		var4.put("lvl", (short) ((byte) var2));
		var3.addTag((NBTTag) var4);
	}

	public boolean w() {
		return this.tag != null && this.tag.isTagAssignableFrom("ench", 9);
	}

	public void a(String var1, NBTTag var2) {
		if (this.tag == null) {
			this.d(new NBTCompoundTag());
		}

		this.tag.put(var1, var2);
	}

	public boolean x() {
		return this.getItem().s();
	}

	public boolean y() {
		return this.g != null;
	}

	public void a(adk var1) {
		this.g = var1;
	}

	public adk z() {
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

	public void a(Item var1) {
		this.item = var1;
	}

	public IJSONComponent C() {
		hy var1 = new hy(this.q());
		if (this.s()) {
			var1.b().b(Boolean.valueOf(true));
		}

		IJSONComponent var2 = (new hy("[")).a(var1).a("]");
		if (this.item != null) {
			NBTCompoundTag var3 = new NBTCompoundTag();
			this.b(var3);
			var2.b().a(new hr(hs.c, new hy(var3.toString())));
			var2.b().a(this.u().e);
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
					Block var4 = Block.b(var2.getString(var3));
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
					Block var4 = Block.b(var2.getString(var3));
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