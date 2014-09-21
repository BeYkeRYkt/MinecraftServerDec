package net.minecraft;

public class EntityItemFrame extends adj {

	private float c = 1.0F;

	public EntityItemFrame(World var1) {
		super(var1);
	}

	public EntityItemFrame(World var1, Position var2, BlockFace var3) {
		super(var1, var2);
		this.a(var3);
	}

	protected void h() {
		this.getDataWatcher().a(8, 5);
		this.getDataWatcher().a(9, Byte.valueOf((byte) 0));
	}

	public float ao() {
		return 0.0F;
	}

	public boolean damageEntity(DamageSource var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else if (!var1.c() && this.o() != null) {
			if (!this.world.isStatic) {
				this.a(var1.j(), false);
				this.a((ItemStack) null);
			}

			return true;
		} else {
			return super.damageEntity(var1, var2);
		}
	}

	public int l() {
		return 12;
	}

	public int m() {
		return 12;
	}

	public void b(Entity var1) {
		this.a(var1, true);
	}

	public void a(Entity var1, boolean var2) {
		if (this.world.getGameRules().isGameRule("doTileDrops")) {
			ItemStack var3 = this.o();
			if (var1 instanceof EntityHuman) {
				EntityHuman var4 = (EntityHuman) var1;
				if (var4.playerProperties.instabuild) {
					this.b(var3);
					return;
				}
			}

			if (var2) {
				this.a(new ItemStack(Items.ITEM_FRAME), 0.0F);
			}

			if (var3 != null && this.random.nextFloat() < this.c) {
				var3 = var3.getCopy();
				this.b(var3);
				this.a(var3, 0.0F);
			}

		}
	}

	private void b(ItemStack var1) {
		if (var1 != null) {
			if (var1.getItem() == Items.FILLED_MAP) {
				bqe var2 = ((ItemMapFilled) var1.getItem()).a(var1, this.world);
				var2.h.remove("frame-" + this.getId());
			}

			var1.a((EntityItemFrame) null);
		}
	}

	public ItemStack o() {
		return this.getDataWatcher().f(8);
	}

	public void a(ItemStack var1) {
		this.a(var1, true);
	}

	private void a(ItemStack var1, boolean var2) {
		if (var1 != null) {
			var1 = var1.getCopy();
			var1.amount = 1;
			var1.a(this);
		}

		this.getDataWatcher().b(8, var1);
		this.getDataWatcher().i(8);
		if (var2 && this.a != null) {
			this.world.e(this.a, Blocks.AIR);
		}

	}

	public int p() {
		return this.getDataWatcher().a(9);
	}

	public void a(int var1) {
		this.a(var1, true);
	}

	private void a(int var1, boolean var2) {
		this.getDataWatcher().b(9, Byte.valueOf((byte) (var1 % 8)));
		if (var2 && this.a != null) {
			this.world.e(this.a, Blocks.AIR);
		}

	}

	public void b(NBTCompoundTag var1) {
		if (this.o() != null) {
			var1.put("Item", (NBTTag) this.o().write(new NBTCompoundTag()));
			var1.put("ItemRotation", (byte) this.p());
			var1.put("ItemDropChance", this.c);
		}

		super.b(var1);
	}

	public void a(NBTCompoundTag var1) {
		NBTCompoundTag var2 = var1.getCompound("Item");
		if (var2 != null && !var2.isEmpty()) {
			this.a(ItemStack.fromNBT(var2), false);
			this.a(var1.getByte("ItemRotation"), false);
			if (var1.isTagAssignableFrom("ItemDropChance", 99)) {
				this.c = var1.getFloat("ItemDropChance");
			}

			if (var1.hasKey("Direction")) {
				this.a(this.p() * 2, false);
			}
		}

		super.a(var1);
	}

	public boolean e(EntityHuman var1) {
		if (this.o() == null) {
			ItemStack var2 = var1.getItemInHand();
			if (var2 != null && !this.world.isStatic) {
				this.a(var2);
				if (!var1.playerProperties.instabuild && --var2.amount <= 0) {
					var1.playerInventory.setItem(var1.playerInventory.itemInHandIndex, (ItemStack) null);
				}
			}
		} else if (!this.world.isStatic) {
			this.a(this.p() + 1);
		}

		return true;
	}

	public int q() {
		return this.o() == null ? 0 : this.p() % 8 + 1;
	}
}
