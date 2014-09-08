package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

import net.minecraft.PacketPlayInClientStatus.ClientStatusAction;
import net.minecraft.PacketPlayInPlayerDigging.PlayerDiggingAction;
import net.minecraft.PacketPlayInUseEntity.UseEntityAction;
import net.minecraft.server.MinecraftServer;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlayerConnection implements PlayInPacketListener, pm {

	private static final Logger logger = LogManager.getLogger();

	public final NetworkManager networkManager;
	private final MinecraftServer minecraftserver;
	public EntityPlayer player;
	private int e;
	private int f;
	private int g;
	private int i;
	private long j;
	private long k;
	private int l;
	private int m;
	private IntHashMap n = new IntHashMap();
	private double o;
	private double p;
	private double q;
	private boolean checkMovement = true;

	public PlayerConnection(MinecraftServer minecraftserver, NetworkManager networkManager, EntityPlayer player) {
		this.minecraftserver = minecraftserver;
		this.networkManager = networkManager;
		networkManager.setPacketListener((PacketListener) this);
		this.player = player;
		player.playerConncetion = this;
	}

	public void c() {
		++this.e;
		this.minecraftserver.profiler.a("keepAlive");
		if ((long) this.e - this.k > 40L) {
			this.k = (long) this.e;
			this.j = this.d();
			this.i = (int) this.j;
			this.sendPacket((Packet) (new PacketPlayOutKeepAlive(this.i)));
		}

		this.minecraftserver.profiler.b();
		if (this.l > 0) {
			--this.l;
		}

		if (this.m > 0) {
			--this.m;
		}

		if (this.player.D() > 0L && this.minecraftserver.ay() > 0 && MinecraftServer.getCurrentMillis() - this.player.D() > (long) (this.minecraftserver.ay() * 1000 * 60)) {
			this.c("You have been idle for too long!");
		}

	}

	public NetworkManager getNetworkManager() {
		return this.networkManager;
	}

	public void c(String var1) {
		ChatComponentText var2 = new ChatComponentText(var1);
		this.networkManager.handleSendPacket(new PacketPlayOutDisconnect(var2), new rk(this, var2));
		this.networkManager.disableAutoRead();
		Futures.getUnchecked(this.minecraftserver.a((Runnable) (new rl(this))));
	}

	public void handle(PacketPlayInSteerVehicle var1) {
		ig.a(var1, this, this.player.u());
		this.player.a(var1.getSidewaysSpeed(), var1.getForwardSpeed(), var1.isJump(), var1.isUnmount());
	}

	public void handle(PacketPlayInPlayer var1) {
		ig.a(var1, this, this.player.u());
		WorldServer var2 = this.minecraftserver.a(this.player.dimensionId);
		if (!this.player.i) {
			double var3 = this.player.locationX;
			double var5 = this.player.locationY;
			double var7 = this.player.locationZ;
			double var9 = 0.0D;
			double var11 = var1.getX() - this.o;
			double var13 = var1.getFeetY() - this.p;
			double var15 = var1.getZ() - this.q;
			if (var1.hasPosition()) {
				var9 = var11 * var11 + var13 * var13 + var15 * var15;
				if (!this.checkMovement && var9 < 0.25D) {
					this.checkMovement = true;
				}
			}

			if (this.checkMovement) {
				this.f = this.e;
				double var19;
				double var21;
				double var23;
				if (this.player.m != null) {
					float var47 = this.player.yaw;
					float var18 = this.player.pitch;
					this.player.m.al();
					var19 = this.player.locationX;
					var21 = this.player.locationY;
					var23 = this.player.locationZ;
					if (var1.hasLook()) {
						var47 = var1.getYaw();
						var18 = var1.getPitch();
					}

					this.player.onGround = var1.isOnGround();
					this.player.l();
					this.player.a(var19, var21, var23, var47, var18);
					if (this.player.m != null) {
						this.player.m.al();
					}

					this.minecraftserver.getPlayerList().d(this.player);
					if (this.player.m != null) {
						if (var9 > 4.0D) {
							Entity var48 = this.player.m;
							this.player.playerConncetion.sendPacket((Packet) (new PacketPlayOutEntityTeleport(var48)));
							this.a(this.player.locationX, this.player.locationY, this.player.locationZ, this.player.yaw, this.player.pitch);
						}

						this.player.m.ai = true;
					}

					if (this.checkMovement) {
						this.o = this.player.locationX;
						this.p = this.player.locationY;
						this.q = this.player.locationZ;
					}

					var2.g(this.player);
					return;
				}

				if (this.player.bI()) {
					this.player.l();
					this.player.a(this.o, this.p, this.q, this.player.yaw, this.player.pitch);
					var2.g(this.player);
					return;
				}

				double var17 = this.player.locationY;
				this.o = this.player.locationX;
				this.p = this.player.locationY;
				this.q = this.player.locationZ;
				var19 = this.player.locationX;
				var21 = this.player.locationY;
				var23 = this.player.locationZ;
				float var25 = this.player.yaw;
				float var26 = this.player.pitch;
				if (var1.hasPosition() && var1.getFeetY() == -999.0D) {
					var1.setHasPosition(false);
				}

				if (var1.hasPosition()) {
					var19 = var1.getX();
					var21 = var1.getFeetY();
					var23 = var1.getZ();
					if (Math.abs(var1.getX()) > 3.0E7D || Math.abs(var1.getZ()) > 3.0E7D) {
						this.c("Illegal position");
						return;
					}
				}

				if (var1.hasLook()) {
					var25 = var1.getYaw();
					var26 = var1.getPitch();
				}

				this.player.l();
				this.player.a(this.o, this.p, this.q, var25, var26);
				if (!this.checkMovement) {
					return;
				}

				double var27 = var19 - this.player.locationX;
				double var29 = var21 - this.player.locationY;
				double var31 = var23 - this.player.locationZ;
				double var33 = Math.min(Math.abs(var27), Math.abs(this.player.motionX));
				double var35 = Math.min(Math.abs(var29), Math.abs(this.player.motionY));
				double var37 = Math.min(Math.abs(var31), Math.abs(this.player.motionZ));
				double var39 = var33 * var33 + var35 * var35 + var37 * var37;
				if (var39 > 100.0D && (!this.minecraftserver.isSinglePlayer() || !this.minecraftserver.R().equals(this.player.d_()))) {
					logger.warn(this.player.d_() + " moved too quickly! " + var27 + "," + var29 + "," + var31 + " (" + var33 + ", " + var35 + ", " + var37 + ")");
					this.a(this.o, this.p, this.q, this.player.yaw, this.player.pitch);
					return;
				}

				float var41 = 0.0625F;
				boolean var42 = var2.a((Entity) this.player, this.player.aQ().d((double) var41, (double) var41, (double) var41)).isEmpty();
				if (this.player.onGround && !var1.isOnGround() && var29 > 0.0D) {
					this.player.bE();
				}

				this.player.d(var27, var29, var31);
				this.player.onGround = var1.isOnGround();
				double var43 = var29;
				var27 = var19 - this.player.locationX;
				var29 = var21 - this.player.locationY;
				if (var29 > -0.5D || var29 < 0.5D) {
					var29 = 0.0D;
				}

				var31 = var23 - this.player.locationZ;
				var39 = var27 * var27 + var29 * var29 + var31 * var31;
				boolean var45 = false;
				if (var39 > 0.0625D && !this.player.bI() && !this.player.playerInteractManager.d()) {
					var45 = true;
					logger.warn(this.player.d_() + " moved wrongly!");
				}

				this.player.a(var19, var21, var23, var25, var26);
				this.player.k(this.player.locationX - var3, this.player.locationY - var5, this.player.locationZ - var7);
				if (!this.player.T) {
					boolean var46 = var2.a((Entity) this.player, this.player.aQ().d((double) var41, (double) var41, (double) var41)).isEmpty();
					if (var42 && (var45 || !var46) && !this.player.bI()) {
						this.a(this.o, this.p, this.q, var25, var26);
						return;
					}
				}

				AxisAlignedBB var49 = this.player.aQ().b((double) var41, (double) var41, (double) var41).a(0.0D, -0.55D, 0.0D);
				if (!this.minecraftserver.isFlightAllowed() && !this.player.by.mayfly && !var2.c(var49)) {
					if (var43 >= -0.03125D) {
						++this.g;
						if (this.g > 80) {
							logger.warn(this.player.d_() + " was kicked for floating too long!");
							this.c("Flying is not enabled on this server");
							return;
						}
					}
				} else {
					this.g = 0;
				}

				this.player.onGround = var1.isOnGround();
				this.minecraftserver.getPlayerList().d(this.player);
				this.player.a(this.player.locationY - var17, var1.isOnGround());
			} else if (this.e - this.f > 20) {
				this.a(this.o, this.p, this.q, this.player.yaw, this.player.pitch);
			}

		}
	}

	public void a(double var1, double var3, double var5, float var7, float var8) {
		this.a(var1, var3, var5, var7, var8, Collections.emptySet());
	}

	public void a(double var1, double var3, double var5, float var7, float var8, Set var9) {
		this.checkMovement = false;
		this.o = var1;
		this.p = var3;
		this.q = var5;
		if (var9.contains(PositionFlag.X)) {
			this.o += this.player.locationX;
		}

		if (var9.contains(PositionFlag.Y)) {
			this.p += this.player.locationY;
		}

		if (var9.contains(PositionFlag.Z)) {
			this.q += this.player.locationZ;
		}

		float var10 = var7;
		float var11 = var8;
		if (var9.contains(PositionFlag.PITCH)) {
			var10 = var7 + this.player.yaw;
		}

		if (var9.contains(PositionFlag.YAW)) {
			var11 = var8 + this.player.pitch;
		}

		this.player.a(this.o, this.p, this.q, var10, var11);
		this.player.playerConncetion.sendPacket((Packet) (new PacketPlayOutPlayerPositionAndLook(var1, var3, var5, var7, var8, var9)));
	}

	public void handle(PacketPlayInPlayerDigging var1) {
		ig.a(var1, this, this.player.u());
		WorldServer var2 = this.minecraftserver.a(this.player.dimensionId);
		Position var3 = var1.getPosition();
		this.player.z();
		switch (rn.a[var1.getAction().ordinal()]) {
			case 1:
				if (!this.player.v()) {
					this.player.a(false);
				}

				return;
			case 2:
				if (!this.player.v()) {
					this.player.a(true);
				}

				return;
			case 3:
				this.player.bT();
				return;
			case 4:
			case 5:
			case 6:
				double var4 = this.player.locationX - ((double) var3.getX() + 0.5D);
				double var6 = this.player.locationY - ((double) var3.getY() + 0.5D) + 1.5D;
				double var8 = this.player.locationZ - ((double) var3.getZ() + 0.5D);
				double var10 = var4 * var4 + var6 * var6 + var8 * var8;
				if (var10 > 36.0D) {
					return;
				} else if (var3.getY() >= this.minecraftserver.al()) {
					return;
				} else {
					if (var1.getAction() == PlayerDiggingAction.START_DESTROY_BLOCK) {
						if (!this.minecraftserver.a((World) var2, var3, (EntityHuman) this.player) && var2.getWorldBorder().isInside(var3)) {
							this.player.playerInteractManager.a(var3, var1.getFace());
						} else {
							this.player.playerConncetion.sendPacket((Packet) (new PacketPlayOutBlockChange(var2, var3)));
						}
					} else {
						if (var1.getAction() == PlayerDiggingAction.STOP_DESTROY_BLOCK) {
							this.player.playerInteractManager.a(var3);
						} else if (var1.getAction() == PlayerDiggingAction.ABORT_DESTROY_BLOCK) {
							this.player.playerInteractManager.e();
						}

						if (var2.p(var3).getBlock().r() != Material.AIR) {
							this.player.playerConncetion.sendPacket((Packet) (new PacketPlayOutBlockChange(var2, var3)));
						}
					}

					return;
				}
			default:
				throw new IllegalArgumentException("Invalid player action");
		}
	}

	public void handle(PacketPlayInBlockPlace var1) {
		ig.a(var1, this, this.player.u());
		WorldServer var2 = this.minecraftserver.a(this.player.dimensionId);
		ItemStack var3 = this.player.playerInventory.getItemInHand();
		boolean var4 = false;
		Position var5 = var1.getPosition();
		BlockFace var6 = BlockFace.getById(var1.getDirection());
		this.player.z();
		if (var1.getDirection() == 255) {
			if (var3 == null) {
				return;
			}

			this.player.playerInteractManager.a(this.player, var2, var3);
		} else if (var5.getY() >= this.minecraftserver.al() - 1 && (var6 == BlockFace.UP || var5.getY() >= this.minecraftserver.al())) {
			ChatMessage var7 = new ChatMessage("build.tooHigh", new Object[] { Integer.valueOf(this.minecraftserver.al()) });
			var7.b().a(EnumChatFormat.RED);
			this.player.playerConncetion.sendPacket((Packet) (new PacketPlayOutChatMessage(var7)));
			var4 = true;
		} else {
			if (this.checkMovement && this.player.e((double) var5.getX() + 0.5D, (double) var5.getY() + 0.5D, (double) var5.getZ() + 0.5D) < 64.0D && !this.minecraftserver.a((World) var2, var5, (EntityHuman) this.player) && var2.getWorldBorder().isInside(var5)) {
				this.player.playerInteractManager.a(this.player, var2, var3, var5, var6, var1.getCursorX(), var1.getCursorY(), var1.getCursorZ());
			}

			var4 = true;
		}

		if (var4) {
			this.player.playerConncetion.sendPacket((Packet) (new PacketPlayOutBlockChange(var2, var5)));
			this.player.playerConncetion.sendPacket((Packet) (new PacketPlayOutBlockChange(var2, var5.a(var6))));
		}

		var3 = this.player.playerInventory.getItemInHand();
		if (var3 != null && var3.b == 0) {
			this.player.playerInventory.contents[this.player.playerInventory.c] = null;
			var3 = null;
		}

		if (var3 == null || var3.l() == 0) {
			this.player.g = true;
			this.player.playerInventory.contents[this.player.playerInventory.c] = ItemStack.b(this.player.playerInventory.contents[this.player.playerInventory.c]);
			ajk var8 = this.player.activeContainer.a((IInventory) this.player.playerInventory, this.player.playerInventory.c);
			this.player.activeContainer.b();
			this.player.g = false;
			if (!ItemStack.b(this.player.playerInventory.getItemInHand(), var1.getItem())) {
				this.sendPacket((Packet) (new PacketPlayOutSetSlot(this.player.activeContainer.d, var8.e, this.player.playerInventory.getItemInHand())));
			}
		}

	}

	public void handle(PacketPlayInSpectate var1) {
		ig.a(var1, this, this.player.u());
		if (this.player.v()) {
			Entity var2 = null;
			WorldServer[] var3 = this.minecraftserver.worlds;
			int var4 = var3.length;

			for (int var5 = 0; var5 < var4; ++var5) {
				WorldServer var6 = var3[var5];
				if (var6 != null) {
					var2 = var1.getEntity(var6);
					if (var2 != null) {
						break;
					}
				}
			}

			if (var2 != null) {
				this.player.e(this.player);
				this.player.a((Entity) null);
				if (var2.o != this.player.o) {
					WorldServer var7 = this.player.u();
					WorldServer var8 = (WorldServer) var2.o;
					this.player.dimensionId = var2.dimensionId;
					this.sendPacket((Packet) (new PacketPlayOutRespawn(this.player.dimensionId, var7.getDifficulty(), var7.P().getLevelType(), this.player.playerInteractManager.getGameMode())));
					var7.f(this.player);
					this.player.I = false;
					this.player.b(var2.locationX, var2.locationY, var2.locationZ, var2.yaw, var2.pitch);
					if (this.player.ai()) {
						var7.a((Entity) this.player, false);
						var8.d(this.player);
						var8.a((Entity) this.player, false);
					}

					this.player.a((World) var8);
					this.minecraftserver.getPlayerList().a(this.player, var7);
					this.player.a(var2.locationX, var2.locationY, var2.locationZ);
					this.player.playerInteractManager.a(var8);
					this.minecraftserver.getPlayerList().b(this.player, var8);
					this.minecraftserver.getPlayerList().f(this.player);
				} else {
					this.player.a(var2.locationX, var2.locationY, var2.locationZ);
				}
			}
		}

	}

	public void handle(PacketPlayInResourcePackStatus var1) {
	}

	public void handle(IChatBaseComponent var1) {
		logger.info(this.player.d_() + " lost connection: " + var1);
		this.minecraftserver.aF();
		ChatMessage var2 = new ChatMessage("multiplayer.player.left", new Object[] { this.player.e_() });
		var2.b().a(EnumChatFormat.YELLOW);
		this.minecraftserver.getPlayerList().a((IChatBaseComponent) var2);
		this.player.q();
		this.minecraftserver.getPlayerList().e(this.player);
		if (this.minecraftserver.isSinglePlayer() && this.player.d_().equals(this.minecraftserver.R())) {
			logger.info("Stopping singleplayer server as player logged out");
			this.minecraftserver.stopTicking();
		}

	}

	public void handle(PacketPlayInHeldItemChange var1) {
		ig.a(var1, this, this.player.u());
		if (var1.getSlot() >= 0 && var1.getSlot() < PlayerInventory.i()) {
			this.player.playerInventory.c = var1.getSlot();
			this.player.z();
		} else {
			logger.warn(this.player.d_() + " tried to set an invalid carried item");
		}
	}

	public void handle(PacketPlayInChatMessage var1) {
		ig.a(var1, this, this.player.u());
		if (this.player.y() == EnumChatFlag.HIDDEN) {
			ChatMessage var4 = new ChatMessage("chat.cannotSend", new Object[0]);
			var4.b().a(EnumChatFormat.RED);
			this.sendPacket((Packet) (new PacketPlayOutChatMessage(var4)));
		} else {
			this.player.z();
			String var2 = var1.getMessage();
			var2 = StringUtils.normalizeSpace(var2);

			for (int var3 = 0; var3 < var2.length(); ++var3) {
				if (!v.a(var2.charAt(var3))) {
					this.c("Illegal characters in chat");
					return;
				}
			}

			if (var2.startsWith("/")) {
				this.d(var2);
			} else {
				ChatMessage var5 = new ChatMessage("chat.type.text", new Object[] { this.player.e_(), var2 });
				this.minecraftserver.getPlayerList().a(var5, false);
			}

			this.l += 20;
			if (this.l > 200 && !this.minecraftserver.getPlayerList().g(this.player.getGameProfile())) {
				this.c("disconnect.spam");
			}

		}
	}

	private void d(String var1) {
		this.minecraftserver.getCommandHandler().a(this.player, var1);
	}

	public void handle(PacketPlayInAnimation var1) {
		ig.a(var1, this, this.player.u());
		this.player.z();
		this.player.bv();
	}

	public void handle(PacketPlayInEntityAction var1) {
		ig.a(var1, this, this.player.u());
		this.player.z();
		switch (rn.b[var1.getAction().ordinal()]) {
			case 1:
				this.player.c(true);
				break;
			case 2:
				this.player.c(false);
				break;
			case 3:
				this.player.d(true);
				break;
			case 4:
				this.player.d(false);
				break;
			case 5:
				this.player.a(false, true, true);
				this.checkMovement = false;
				break;
			case 6:
				if (this.player.m instanceof EntityHorse) {
					((EntityHorse) this.player.m).v(var1.getHorseJumpBoost());
				}
				break;
			case 7:
				if (this.player.m instanceof EntityHorse) {
					((EntityHorse) this.player.m).g(this.player);
				}
				break;
			default:
				throw new IllegalArgumentException("Invalid client command!");
		}

	}

	public void handle(PacketPlayInUseEntity var1) {
		ig.a(var1, this, this.player.u());
		WorldServer var2 = this.minecraftserver.a(this.player.dimensionId);
		Entity var3 = var1.getEntity((World) var2);
		this.player.z();
		if (var3 != null) {
			boolean var4 = this.player.t(var3);
			double var5 = 36.0D;
			if (!var4) {
				var5 = 9.0D;
			}

			if (this.player.h(var3) < var5) {
				if (var1.getAction() == UseEntityAction.INTERACT) {
					this.player.u(var3);
				} else if (var1.getAction() == UseEntityAction.INTERACT_AT) {
					var3.a((EntityHuman) this.player, var1.getInteractedAt());
				} else if (var1.getAction() == UseEntityAction.ATTACK) {
					if (var3 instanceof EntityItem || var3 instanceof EntityExpirienceOrb || var3 instanceof EntityArrow || var3 == this.player) {
						this.c("Attempting to attack an invalid entity");
						this.minecraftserver.f("Player " + this.player.d_() + " tried to attack an invalid entity");
						return;
					}

					this.player.f(var3);
				}
			}
		}

	}

	public void handle(PacketPlayInClientStatus var1) {
		ig.a(var1, this, this.player.u());
		this.player.z();
		ClientStatusAction var2 = var1.getAction();
		switch (rn.c[var2.ordinal()]) {
			case 1:
				if (this.player.i) {
					this.player = this.minecraftserver.getPlayerList().a(this.player, 0, true);
				} else if (this.player.u().P().isHardcore()) {
					if (this.minecraftserver.isSinglePlayer() && this.player.d_().equals(this.minecraftserver.R())) {
						this.player.playerConncetion.c("You have died. Game over, man, it\'s game over!");
						this.minecraftserver.Z();
					} else {
						sw var3 = new sw(this.player.getGameProfile(), (Date) null, "(You just lost the game)", (Date) null, "Death in Hardcore");
						this.minecraftserver.getPlayerList().i().a((sr) var3);
						this.player.playerConncetion.c("You have died. Game over, man, it\'s game over!");
					}
				} else {
					if (this.player.bm() > 0.0F) {
						return;
					}

					this.player = this.minecraftserver.getPlayerList().a(this.player, 0, false);
				}
				break;
			case 2:
				this.player.A().a(this.player);
				break;
			case 3:
				this.player.b((Statistic) AchievementList.f);
		}

	}

	public void handle(PacketPlayInCloseWindow var1) {
		ig.a(var1, this, this.player.u());
		this.player.p();
	}

	public void handle(PacketPlayInClickWindow var1) {
		ig.a(var1, this, this.player.u());
		this.player.z();
		if (this.player.activeContainer.d == var1.getWindowId() && this.player.activeContainer.c(this.player)) {
			if (this.player.v()) {
				ArrayList var2 = Lists.newArrayList();

				for (int var3 = 0; var3 < this.player.activeContainer.c.size(); ++var3) {
					var2.add(((ajk) this.player.activeContainer.c.get(var3)).d());
				}

				this.player.a(this.player.activeContainer, (List) var2);
			} else {
				ItemStack var5 = this.player.activeContainer.a(var1.getSlot(), var1.getButton(), var1.getMode(), this.player);
				if (ItemStack.b(var1.getItem(), var5)) {
					this.player.playerConncetion.sendPacket((Packet) (new PacketPlayOutConfirmTransaction(var1.getWindowId(), var1.getAction(), true)));
					this.player.g = true;
					this.player.activeContainer.b();
					this.player.o();
					this.player.g = false;
				} else {
					this.n.a(this.player.activeContainer.d, Short.valueOf(var1.getAction()));
					this.player.playerConncetion.sendPacket((Packet) (new PacketPlayOutConfirmTransaction(var1.getWindowId(), var1.getAction(), false)));
					this.player.activeContainer.a(this.player, false);
					ArrayList var6 = Lists.newArrayList();

					for (int var4 = 0; var4 < this.player.activeContainer.c.size(); ++var4) {
						var6.add(((ajk) this.player.activeContainer.c.get(var4)).d());
					}

					this.player.a(this.player.activeContainer, (List) var6);
				}
			}
		}

	}

	public void handle(PacketPlayInEnchantItem var1) {
		ig.a(var1, this, this.player.u());
		this.player.z();
		if (this.player.activeContainer.d == var1.getWindowId() && this.player.activeContainer.c(this.player) && !this.player.v()) {
			this.player.activeContainer.a((EntityHuman) this.player, var1.getEnchantment());
			this.player.activeContainer.b();
		}

	}

	public void handle(PacketPlayInCreativeInventoryAction var1) {
		ig.a(var1, this, this.player.u());
		if (this.player.playerInteractManager.d()) {
			boolean var2 = var1.getWindowId() < 0;
			ItemStack var3 = var1.getItem();
			if (var3 != null && var3.hasTag() && var3.getTag().isTagAssignableFrom("BlockEntityTag", 10)) {
				NBTCompoundTag var4 = var3.getTag().getCompound("BlockEntityTag");
				if (var4.hasKey("x") && var4.hasKey("y") && var4.hasKey("z")) {
					Position var5 = new Position(var4.getInt("x"), var4.getInt("y"), var4.getInt("z"));
					TileEntity var6 = this.player.o.s(var5);
					if (var6 != null) {
						NBTCompoundTag var7 = new NBTCompoundTag();
						var6.write(var7);
						var7.remove("x");
						var7.remove("y");
						var7.remove("z");
						var3.a("BlockEntityTag", (NBTTag) var7);
					}
				}
			}

			boolean var8 = var1.getWindowId() >= 1 && var1.getWindowId() < 36 + PlayerInventory.i();
			boolean var9 = var3 == null || var3.getItem() != null;
			boolean var10 = var3 == null || var3.i() >= 0 && var3.b <= 64 && var3.b > 0;
			if (var8 && var9 && var10) {
				if (var3 == null) {
					this.player.defaultContainer.a(var1.getWindowId(), (ItemStack) null);
				} else {
					this.player.defaultContainer.a(var1.getWindowId(), var3);
				}

				this.player.defaultContainer.a(this.player, true);
			} else if (var2 && var9 && var10 && this.m < 200) {
				this.m += 20;
				EntityItem var11 = this.player.a(var3, true);
				if (var11 != null) {
					var11.j();
				}
			}
		}

	}

	public void handle(PacketPlayInConfirmTransaction var1) {
		ig.a(var1, this, this.player.u());
		Short var2 = (Short) this.n.a(this.player.activeContainer.d);
		if (var2 != null && var1.getAction() == var2.shortValue() && this.player.activeContainer.d == var1.getWindowId() && !this.player.activeContainer.c(this.player) && !this.player.v()) {
			this.player.activeContainer.a(this.player, true);
		}

	}

	public void handle(PacketPlayInUpdateSign var1) {
		ig.a(var1, this, this.player.u());
		this.player.z();
		WorldServer var2 = this.minecraftserver.a(this.player.dimensionId);
		Position var3 = var1.getPosition();
		if (var2.e(var3)) {
			TileEntity var4 = var2.s(var3);
			if (!(var4 instanceof TileEntitySign)) {
				return;
			}

			TileEntitySign var5 = (TileEntitySign) var4;
			if (!var5.b() || var5.c() != this.player) {
				this.minecraftserver.f("Player " + this.player.d_() + " just tried to change non-editable sign");
				return;
			}

			System.arraycopy(var1.getLines(), 0, var5.a, 0, 4);
			var5.o_();
			var2.h(var3);
		}

	}

	public void handle(PacketPlayInKeepAlive var1) {
		if (var1.getKeepAliveId() == this.i) {
			int var2 = (int) (this.d() - this.j);
			this.player.ping = (this.player.ping * 3 + var2) / 4;
		}

	}

	private long d() {
		return System.nanoTime() / 1000000L;
	}

	public void handle(PacketPlayInPlayAbilities var1) {
		ig.a(var1, this, this.player.u());
		this.player.by.flying = var1.isFlying() && this.player.by.mayfly;
	}

	public void handle(PacketPlayInTabComplete var1) {
		ig.a(var1, this, this.player.u());
		ArrayList var2 = Lists.newArrayList();
		Iterator var3 = this.minecraftserver.getTabCompleteList((CommandSenderInterface) this.player, var1.getText(), var1.getPosition()).iterator();

		while (var3.hasNext()) {
			String var4 = (String) var3.next();
			var2.add(var4);
		}

		this.player.playerConncetion.sendPacket((Packet) (new PacketPlayOutTabComplete((String[]) var2.toArray(new String[var2.size()]))));
	}

	public void handle(PacketPlayInClientSettings var1) {
		ig.a(var1, this, this.player.u());
		this.player.a(var1);
	}

	public void handle(PacketPlayInPluginMessage var1) {
		ig.a(var1, this, this.player.u());
		PacketDataSerializer var2;
		ItemStack var3;
		ItemStack var4;
		if ("MC|BEdit".equals(var1.getChannelName())) {
			var2 = new PacketDataSerializer(Unpooled.wrappedBuffer((ByteBuf) var1.getMessage()));

			try {
				var3 = var2.readItemStack();
				if (var3 != null) {
					if (!ItemBookAndQuill.b(var3.getTag())) {
						throw new IOException("Invalid book tag!");
					}

					var4 = this.player.playerInventory.getItemInHand();
					if (var4 == null) {
						return;
					}

					if (var3.getItem() == Items.WRITABLE_BOOK && var3.getItem() == var4.getItem()) {
						var4.a("pages", (NBTTag) var3.getTag().getList("pages", 8));
					}

					return;
				}
			} catch (Exception var38) {
				logger.error("Couldn\'t handle book info", (Throwable) var38);
				return;
			} finally {
				var2.release();
			}

			return;
		} else if ("MC|BSign".equals(var1.getChannelName())) {
			var2 = new PacketDataSerializer(Unpooled.wrappedBuffer((ByteBuf) var1.getMessage()));

			try {
				var3 = var2.readItemStack();
				if (var3 != null) {
					if (!ItemWrittenBook.b(var3.getTag())) {
						throw new IOException("Invalid book tag!");
					}

					var4 = this.player.playerInventory.getItemInHand();
					if (var4 == null) {
						return;
					}

					if (var3.getItem() == Items.WRITTEN_BOK && var4.getItem() == Items.WRITABLE_BOOK) {
						var4.a("author", (NBTTag) (new NBTStringTag(this.player.d_())));
						var4.a("title", (NBTTag) (new NBTStringTag(var3.getTag().getString("title"))));
						var4.a("pages", (NBTTag) var3.getTag().getList("pages", 8));
						var4.a(Items.WRITTEN_BOK);
					}

					return;
				}
			} catch (Exception var36) {
				logger.error("Couldn\'t sign book", (Throwable) var36);
				return;
			} finally {
				var2.release();
			}

			return;
		} else if ("MC|TrSel".equals(var1.getChannelName())) {
			try {
				int var40 = var1.getMessage().readInt();
				Container var42 = this.player.activeContainer;
				if (var42 instanceof ajf) {
					((ajf) var42).d(var40);
				}
			} catch (Exception var35) {
				logger.error("Couldn\'t select trade", (Throwable) var35);
			}
		} else if ("MC|AdvCdm".equals(var1.getChannelName())) {
			if (!this.minecraftserver.isCommandBlockEnabled()) {
				this.player.sendChatMessage((IChatBaseComponent) (new ChatMessage("advMode.notEnabled", new Object[0])));
			} else if (this.player.a(2, "") && this.player.by.instabuild) {
				var2 = var1.getMessage();

				try {
					byte var43 = var2.readByte();
					aqf var46 = null;
					if (var43 == 0) {
						TileEntity var5 = this.player.o.s(new Position(var2.readInt(), var2.readInt(), var2.readInt()));
						if (var5 instanceof TileEntityCommand) {
							var46 = ((TileEntityCommand) var5).b();
						}
					} else if (var43 == 1) {
						Entity var48 = this.player.o.getEntity(var2.readInt());
						if (var48 instanceof EntityMinecartCommandBlock) {
							var46 = ((EntityMinecartCommandBlock) var48).j();
						}
					}

					String var49 = var2.readString(var2.readableBytes());
					boolean var6 = var2.readBoolean();
					if (var46 != null) {
						var46.a(var49);
						var46.a(var6);
						if (!var6) {
							var46.b((IChatBaseComponent) null);
						}

						var46.h();
						this.player.sendChatMessage((IChatBaseComponent) (new ChatMessage("advMode.setCommand.success", new Object[] { var49 })));
					}
				} catch (Exception var33) {
					logger.error("Couldn\'t set command block", (Throwable) var33);
				} finally {
					var2.release();
				}
			} else {
				this.player.sendChatMessage((IChatBaseComponent) (new ChatMessage("advMode.notAllowed", new Object[0])));
			}
		} else if ("MC|Beacon".equals(var1.getChannelName())) {
			if (this.player.activeContainer instanceof aig) {
				try {
					var2 = var1.getMessage();
					int var44 = var2.readInt();
					int var47 = var2.readInt();
					aig var50 = (aig) this.player.activeContainer;
					ajk var51 = var50.a(0);
					if (var51.e()) {
						var51.a(1);
						IInventory var7 = var50.e();
						var7.b(1, var44);
						var7.b(2, var47);
						var7.o_();
					}
				} catch (Exception var32) {
					logger.error("Couldn\'t set beacon", (Throwable) var32);
				}
			}
		} else if ("MC|ItemName".equals(var1.getChannelName()) && this.player.activeContainer instanceof aid) {
			aid var41 = (aid) this.player.activeContainer;
			if (var1.getMessage() != null && var1.getMessage().readableBytes() >= 1) {
				String var45 = v.a(var1.getMessage().readString(32767));
				if (var45.length() <= 30) {
					var41.a(var45);
				}
			} else {
				var41.a("");
			}
		}

	}

	public void sendPacket(Packet<? extends PacketListener> packet) {
		if (packet instanceof PacketPlayOutChatMessage) {
			PacketPlayOutChatMessage var2 = (PacketPlayOutChatMessage) packet;
			EnumChatFlag var3 = this.player.y();
			if (var3 == EnumChatFlag.HIDDEN) {
				return;
			}

			if (var3 == EnumChatFlag.SYSTEM && !var2.isChatMessage()) {
				return;
			}
		}

		try {
			this.networkManager.handleSendPacket(packet);
		} catch (Throwable var5) {
			CrashReport var6 = CrashReport.generateCrashReport(var5, "Sending packet");
			CrashReportSystemDetails var4 = var6.generateSystemDetails("Packet being sent");
			var4.addDetails("Packet class", (Callable) (new rm(this, packet)));
			throw new ReportedException(var6);
		}
	}

}
