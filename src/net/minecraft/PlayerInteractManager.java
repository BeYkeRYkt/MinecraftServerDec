package net.minecraft;

import net.minecraft.PacketPlayOutListItem.ListItemAction;

public class PlayerInteractManager {

	public World worldServer;
	public EntityPlayer b;
	private EnumGameMode gameMode;
	private boolean d;
	private int e;
	private Position f;
	private int g;
	private boolean h;
	private Position i;
	private int j;
	private int k;

	public PlayerInteractManager(World var1) {
		this.gameMode = EnumGameMode.NOT_SET;
		this.f = Position.ZERO;
		this.i = Position.ZERO;
		this.k = -1;
		this.worldServer = var1;
	}

	public void setGameMode(EnumGameMode gameMode) {
		this.gameMode = gameMode;
		gameMode.setGameModeProperties(this.b.playerProperties);
		this.b.t();
		this.b.minecraftserver.getPlayerList().sendPacket(new PacketPlayOutListItem(ListItemAction.UPDATE_GAME_MODE, new EntityPlayer[] { this.b }));
	}

	public EnumGameMode getGameMode() {
		return this.gameMode;
	}

	public boolean isSurvivalOrAdventure() {
		return this.gameMode.isSurvivalOrAdventure();
	}

	public boolean isCreative() {
		return this.gameMode.isCreative();
	}

	public void b(EnumGameMode var1) {
		if (this.gameMode == EnumGameMode.NOT_SET) {
			this.gameMode = var1;
		}

		this.setGameMode(this.gameMode);
	}

	public void a() {
		++this.g;
		float var3;
		int var4;
		if (this.h) {
			int var1 = this.g - this.j;
			Block var2 = this.worldServer.getBlockState(this.i).getBlock();
			if (var2.getMaterial() == Material.AIR) {
				this.h = false;
			} else {
				var3 = var2.a((EntityHuman) this.b, this.b.world, this.i) * (float) (var1 + 1);
				var4 = (int) (var3 * 10.0F);
				if (var4 != this.k) {
					this.worldServer.c(this.b.getId(), this.i, var4);
					this.k = var4;
				}

				if (var3 >= 1.0F) {
					this.h = false;
					this.b(this.i);
				}
			}
		} else if (this.d) {
			Block var5 = this.worldServer.getBlockState(this.f).getBlock();
			if (var5.getMaterial() == Material.AIR) {
				this.worldServer.c(this.b.getId(), this.f, -1);
				this.k = -1;
				this.d = false;
			} else {
				int var6 = this.g - this.e;
				var3 = var5.a((EntityHuman) this.b, this.b.world, this.i) * (float) (var6 + 1);
				var4 = (int) (var3 * 10.0F);
				if (var4 != this.k) {
					this.worldServer.c(this.b.getId(), this.f, var4);
					this.k = var4;
				}
			}
		}

	}

	public void a(Position var1, BlockFace var2) {
		if (this.isCreative()) {
			if (!this.worldServer.a((EntityHuman) null, var1, var2)) {
				this.b(var1);
			}

		} else {
			Block var3 = this.worldServer.getBlockState(var1).getBlock();
			if (this.gameMode.buildDisallowed()) {
				if (this.gameMode == EnumGameMode.SPECTATOR) {
					return;
				}

				if (!this.b.cm()) {
					ItemStack var4 = this.b.bY();
					if (var4 == null) {
						return;
					}

					if (!var4.c(var3)) {
						return;
					}
				}
			}

			this.worldServer.a((EntityHuman) null, var1, var2);
			this.e = this.g;
			float var6 = 1.0F;
			if (var3.getMaterial() != Material.AIR) {
				var3.a(this.worldServer, var1, (EntityHuman) this.b);
				var6 = var3.a((EntityHuman) this.b, this.b.world, var1);
			}

			if (var3.getMaterial() != Material.AIR && var6 >= 1.0F) {
				this.b(var1);
			} else {
				this.d = true;
				this.f = var1;
				int var5 = (int) (var6 * 10.0F);
				this.worldServer.c(this.b.getId(), var1, var5);
				this.k = var5;
			}

		}
	}

	public void a(Position var1) {
		if (var1.equals(this.f)) {
			int var2 = this.g - this.e;
			Block var3 = this.worldServer.getBlockState(var1).getBlock();
			if (var3.getMaterial() != Material.AIR) {
				float var4 = var3.a((EntityHuman) this.b, this.b.world, var1) * (float) (var2 + 1);
				if (var4 >= 0.7F) {
					this.d = false;
					this.worldServer.c(this.b.getId(), var1, -1);
					this.b(var1);
				} else if (!this.h) {
					this.d = false;
					this.h = true;
					this.i = var1;
					this.j = this.e;
				}
			}
		}

	}

	public void e() {
		this.d = false;
		this.worldServer.c(this.b.getId(), this.f, -1);
	}

	private boolean c(Position var1) {
		IBlockState var2 = this.worldServer.getBlockState(var1);
		var2.getBlock().a(this.worldServer, var1, var2, (EntityHuman) this.b);
		boolean var3 = this.worldServer.g(var1);
		if (var3) {
			var2.getBlock().d(this.worldServer, var1, var2);
		}

		return var3;
	}

	public boolean b(Position var1) {
		if (this.gameMode.isCreative() && this.b.getItemInHand() != null && this.b.getItemInHand().getItem() instanceof ItemSword) {
			return false;
		} else {
			IBlockState var2 = this.worldServer.getBlockState(var1);
			TileEntity var3 = this.worldServer.getTileEntity(var1);
			if (this.gameMode.buildDisallowed()) {
				if (this.gameMode == EnumGameMode.SPECTATOR) {
					return false;
				}

				if (!this.b.cm()) {
					ItemStack var4 = this.b.bY();
					if (var4 == null) {
						return false;
					}

					if (!var4.c(var2.getBlock())) {
						return false;
					}
				}
			}

			this.worldServer.a(this.b, 2001, var1, Block.getStateId(var2));
			boolean var7 = this.c(var1);
			if (this.isCreative()) {
				this.b.playerConnection.sendPacket((Packet) (new PacketPlayOutBlockChange(this.worldServer, var1)));
			} else {
				ItemStack var5 = this.b.bY();
				boolean var6 = this.b.b(var2.getBlock());
				if (var5 != null) {
					var5.a(this.worldServer, var2.getBlock(), var1, this.b);
					if (var5.amount == 0) {
						this.b.bZ();
					}
				}

				if (var7 && var6) {
					var2.getBlock().a(this.worldServer, (EntityHuman) this.b, var1, var2, var3);
				}
			}

			return var7;
		}
	}

	public boolean useItem(EntityHuman var1, World var2, ItemStack var3) {
		if (this.gameMode == EnumGameMode.SPECTATOR) {
			return false;
		} else {
			int var4 = var3.amount;
			int var5 = var3.getWearout();
			ItemStack var6 = var3.a(var2, var1);
			if (var6 == var3 && (var6 == null || var6.amount == var4 && var6.l() <= 0 && var6.getWearout() == var5)) {
				return false;
			} else {
				var1.playerInventory.contents[var1.playerInventory.itemInHandIndex] = var6;
				if (this.isCreative()) {
					var6.amount = var4;
					if (var6.e()) {
						var6.setWearout(var5);
					}
				}

				if (var6.amount == 0) {
					var1.playerInventory.contents[var1.playerInventory.itemInHandIndex] = null;
				}

				if (!var1.bR()) {
					((EntityPlayer) var1).a(var1.defaultContainer);
				}

				return true;
			}
		}
	}

	public boolean interact(EntityHuman var1, World var2, ItemStack var3, Position var4, BlockFace var5, float var6, float var7, float var8) {
		if (this.gameMode == EnumGameMode.SPECTATOR) {
			TileEntity var13 = var2.getTileEntity(var4);
			if (var13 instanceof ILockable) {
				Block var14 = var2.getBlockState(var4).getBlock();
				ILockable var15 = (ILockable) var13;
				if (var15 instanceof TileEntityChest && var14 instanceof BlockChest) {
					var15 = ((BlockChest) var14).d(var2, var4);
				}

				if (var15 != null) {
					var1.openDispenser((IInventory) var15);
					return true;
				}
			} else if (var13 instanceof IInventory) {
				var1.openDispenser((IInventory) var13);
				return true;
			}

			return false;
		} else {
			if (!var1.aw() || var1.getItemInHand() == null) {
				IBlockState var9 = var2.getBlockState(var4);
				if (var9.getBlock().interact(var2, var4, var9, var1, var5, var6, var7, var8)) {
					return true;
				}
			}

			if (var3 == null) {
				return false;
			} else if (this.isCreative()) {
				int var12 = var3.getWearout();
				int var10 = var3.amount;
				boolean var11 = var3.a(var1, var2, var4, var5, var6, var7, var8);
				var3.setWearout(var12);
				var3.amount = var10;
				return var11;
			} else {
				return var3.a(var1, var2, var4, var5, var6, var7, var8);
			}
		}
	}

	public void setWorldServer(WorldServer worldServer) {
		this.worldServer = worldServer;
	}

}
