package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.concurrent.GenericFutureListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlayerConnection implements ls, pm {

	private static final Logger c = LogManager.getLogger();
	public final gr a;
	private final MinecraftServer d;
	public EntityPlayer b;
	private int e;
	private int f;
	private int g;
	private boolean h;
	private int i;
	private long j;
	private long k;
	private int l;
	private int m;
	private um n = new um();
	private double o;
	private double p;
	private double q;
	private boolean r = true;

	public PlayerConnection(MinecraftServer var1, gr var2, EntityPlayer var3) {
		this.d = var1;
		this.a = var2;
		var2.a((PacketListener) this);
		this.b = var3;
		var3.playerConncetion = this;
	}

	public void c() {
		this.h = false;
		++this.e;
		this.d.profiler.a("keepAlive");
		if ((long) this.e - this.k > 40L) {
			this.k = (long) this.e;
			this.j = this.d();
			this.i = (int) this.j;
			this.sendPacket((Packet) (new PacketOutKeepAlive(this.i)));
		}

		this.d.profiler.b();
		if (this.l > 0) {
			--this.l;
		}

		if (this.m > 0) {
			--this.m;
		}

		if (this.b.D() > 0L && this.d.ay() > 0 && MinecraftServer.getCurrentMillis() - this.b.D() > (long) (this.d.ay() * 1000 * 60)) {
			this.c("You have been idle for too long!");
		}

	}

	public gr a() {
		return this.a;
	}

	public void c(String var1) {
		hy var2 = new hy(var1);
		this.a.a(new jj(var2), new rk(this, var2), new GenericFutureListener[0]);
		this.a.k();
		Futures.getUnchecked(this.d.a((Runnable) (new rl(this))));
	}

	public void a(mp var1) {
		ig.a(var1, this, this.b.u());
		this.b.a(var1.a(), var1.b(), var1.c(), var1.d());
	}

	public void a(mg var1) {
		ig.a(var1, this, this.b.u());
		WorldServer var2 = this.d.a(this.b.dimensionId);
		this.h = true;
		if (!this.b.i) {
			double var3 = this.b.locationX;
			double var5 = this.b.locationY;
			double var7 = this.b.locationZ;
			double var9 = 0.0D;
			double var11 = var1.a() - this.o;
			double var13 = var1.b() - this.p;
			double var15 = var1.c() - this.q;
			if (var1.g()) {
				var9 = var11 * var11 + var13 * var13 + var15 * var15;
				if (!this.r && var9 < 0.25D) {
					this.r = true;
				}
			}

			if (this.r) {
				this.f = this.e;
				double var19;
				double var21;
				double var23;
				if (this.b.m != null) {
					float var47 = this.b.yaw;
					float var18 = this.b.pitch;
					this.b.m.al();
					var19 = this.b.locationX;
					var21 = this.b.locationY;
					var23 = this.b.locationZ;
					if (var1.h()) {
						var47 = var1.d();
						var18 = var1.e();
					}

					this.b.onGround = var1.f();
					this.b.l();
					this.b.a(var19, var21, var23, var47, var18);
					if (this.b.m != null) {
						this.b.m.al();
					}

					this.d.getPlayerList().d(this.b);
					if (this.b.m != null) {
						if (var9 > 4.0D) {
							Entity var48 = this.b.m;
							this.b.playerConncetion.sendPacket((Packet) (new PacketOutEntityTeleport(var48)));
							this.a(this.b.locationX, this.b.locationY, this.b.locationZ, this.b.yaw, this.b.pitch);
						}

						this.b.m.ai = true;
					}

					if (this.r) {
						this.o = this.b.locationX;
						this.p = this.b.locationY;
						this.q = this.b.locationZ;
					}

					var2.g(this.b);
					return;
				}

				if (this.b.bI()) {
					this.b.l();
					this.b.a(this.o, this.p, this.q, this.b.yaw, this.b.pitch);
					var2.g(this.b);
					return;
				}

				double var17 = this.b.locationY;
				this.o = this.b.locationX;
				this.p = this.b.locationY;
				this.q = this.b.locationZ;
				var19 = this.b.locationX;
				var21 = this.b.locationY;
				var23 = this.b.locationZ;
				float var25 = this.b.yaw;
				float var26 = this.b.pitch;
				if (var1.g() && var1.b() == -999.0D) {
					var1.a(false);
				}

				if (var1.g()) {
					var19 = var1.a();
					var21 = var1.b();
					var23 = var1.c();
					if (Math.abs(var1.a()) > 3.0E7D || Math.abs(var1.c()) > 3.0E7D) {
						this.c("Illegal position");
						return;
					}
				}

				if (var1.h()) {
					var25 = var1.d();
					var26 = var1.e();
				}

				this.b.l();
				this.b.a(this.o, this.p, this.q, var25, var26);
				if (!this.r) {
					return;
				}

				double var27 = var19 - this.b.locationX;
				double var29 = var21 - this.b.locationY;
				double var31 = var23 - this.b.locationZ;
				double var33 = Math.min(Math.abs(var27), Math.abs(this.b.motionX));
				double var35 = Math.min(Math.abs(var29), Math.abs(this.b.motionY));
				double var37 = Math.min(Math.abs(var31), Math.abs(this.b.motionZ));
				double var39 = var33 * var33 + var35 * var35 + var37 * var37;
				if (var39 > 100.0D && (!this.d.isSinglePlayer() || !this.d.R().equals(this.b.d_()))) {
					c.warn(this.b.d_() + " moved too quickly! " + var27 + "," + var29 + "," + var31 + " (" + var33 + ", " + var35 + ", " + var37 + ")");
					this.a(this.o, this.p, this.q, this.b.yaw, this.b.pitch);
					return;
				}

				float var41 = 0.0625F;
				boolean var42 = var2.a((Entity) this.b, this.b.aQ().d((double) var41, (double) var41, (double) var41)).isEmpty();
				if (this.b.onGround && !var1.f() && var29 > 0.0D) {
					this.b.bE();
				}

				this.b.d(var27, var29, var31);
				this.b.onGround = var1.f();
				double var43 = var29;
				var27 = var19 - this.b.locationX;
				var29 = var21 - this.b.locationY;
				if (var29 > -0.5D || var29 < 0.5D) {
					var29 = 0.0D;
				}

				var31 = var23 - this.b.locationZ;
				var39 = var27 * var27 + var29 * var29 + var31 * var31;
				boolean var45 = false;
				if (var39 > 0.0625D && !this.b.bI() && !this.b.c.d()) {
					var45 = true;
					c.warn(this.b.d_() + " moved wrongly!");
				}

				this.b.a(var19, var21, var23, var25, var26);
				this.b.k(this.b.locationX - var3, this.b.locationY - var5, this.b.locationZ - var7);
				if (!this.b.T) {
					boolean var46 = var2.a((Entity) this.b, this.b.aQ().d((double) var41, (double) var41, (double) var41)).isEmpty();
					if (var42 && (var45 || !var46) && !this.b.bI()) {
						this.a(this.o, this.p, this.q, var25, var26);
						return;
					}
				}

				brt var49 = this.b.aQ().b((double) var41, (double) var41, (double) var41).a(0.0D, -0.55D, 0.0D);
				if (!this.d.isFlightAllowed() && !this.b.by.mayfly && !var2.c(var49)) {
					if (var43 >= -0.03125D) {
						++this.g;
						if (this.g > 80) {
							c.warn(this.b.d_() + " was kicked for floating too long!");
							this.c("Flying is not enabled on this server");
							return;
						}
					}
				} else {
					this.g = 0;
				}

				this.b.onGround = var1.f();
				this.d.getPlayerList().d(this.b);
				this.b.a(this.b.locationY - var17, var1.f());
			} else if (this.e - this.f > 20) {
				this.a(this.o, this.p, this.q, this.b.yaw, this.b.pitch);
			}

		}
	}

	public void a(double var1, double var3, double var5, float var7, float var8) {
		this.a(var1, var3, var5, var7, var8, Collections.emptySet());
	}

	public void a(double var1, double var3, double var5, float var7, float var8, Set var9) {
		this.r = false;
		this.o = var1;
		this.p = var3;
		this.q = var5;
		if (var9.contains(PositionFlag.X)) {
			this.o += this.b.locationX;
		}

		if (var9.contains(PositionFlag.Y)) {
			this.p += this.b.locationY;
		}

		if (var9.contains(PositionFlag.Z)) {
			this.q += this.b.locationZ;
		}

		float var10 = var7;
		float var11 = var8;
		if (var9.contains(PositionFlag.PITCH)) {
			var10 = var7 + this.b.yaw;
		}

		if (var9.contains(PositionFlag.YAW)) {
			var11 = var8 + this.b.pitch;
		}

		this.b.a(this.o, this.p, this.q, var10, var11);
		this.b.playerConncetion.sendPacket((Packet) (new PacketOutPlayerPositionAndLook(var1, var3, var5, var7, var8, var9)));
	}

	public void a(ml var1) {
		ig.a(var1, this, this.b.u());
		WorldServer var2 = this.d.a(this.b.dimensionId);
		Position var3 = var1.a();
		this.b.z();
		switch (rn.a[var1.c().ordinal()]) {
			case 1:
				if (!this.b.v()) {
					this.b.a(false);
				}

				return;
			case 2:
				if (!this.b.v()) {
					this.b.a(true);
				}

				return;
			case 3:
				this.b.bT();
				return;
			case 4:
			case 5:
			case 6:
				double var4 = this.b.locationX - ((double) var3.getX() + 0.5D);
				double var6 = this.b.locationY - ((double) var3.getY() + 0.5D) + 1.5D;
				double var8 = this.b.locationZ - ((double) var3.getZ() + 0.5D);
				double var10 = var4 * var4 + var6 * var6 + var8 * var8;
				if (var10 > 36.0D) {
					return;
				} else if (var3.getY() >= this.d.al()) {
					return;
				} else {
					if (var1.c() == mm.a) {
						if (!this.d.a((World) var2, var3, (EntityHuman) this.b) && var2.af().a(var3)) {
							this.b.c.a(var3, var1.b());
						} else {
							this.b.playerConncetion.sendPacket((Packet) (new PacketOutBlockChange(var2, var3)));
						}
					} else {
						if (var1.c() == mm.c) {
							this.b.c.a(var3);
						} else if (var1.c() == mm.b) {
							this.b.c.e();
						}

						if (var2.p(var3).getBlock().r() != Material.AIR) {
							this.b.playerConncetion.sendPacket((Packet) (new PacketOutBlockChange(var2, var3)));
						}
					}

					return;
				}
			default:
				throw new IllegalArgumentException("Invalid player action");
		}
	}

	public void a(mx var1) {
		ig.a(var1, this, this.b.u());
		WorldServer var2 = this.d.a(this.b.dimensionId);
		ItemStack var3 = this.b.playerInventory.getItemInHand();
		boolean var4 = false;
		Position var5 = var1.a();
		BlockFace var6 = BlockFace.a(var1.b());
		this.b.z();
		if (var1.b() == 255) {
			if (var3 == null) {
				return;
			}

			this.b.c.a(this.b, var2, var3);
		} else if (var5.getY() >= this.d.al() - 1 && (var6 == BlockFace.b || var5.getY() >= this.d.al())) {
			hz var7 = new hz("build.tooHigh", new Object[] { Integer.valueOf(this.d.al()) });
			var7.b().a(FormattingCode.m);
			this.b.playerConncetion.sendPacket((Packet) (new PacketOutChatMessage(var7)));
			var4 = true;
		} else {
			if (this.r && this.b.e((double) var5.getX() + 0.5D, (double) var5.getY() + 0.5D, (double) var5.getZ() + 0.5D) < 64.0D && !this.d.a((World) var2, var5, (EntityHuman) this.b) && var2.af().a(var5)) {
				this.b.c.a(this.b, var2, var3, var5, var6, var1.d(), var1.e(), var1.f());
			}

			var4 = true;
		}

		if (var4) {
			this.b.playerConncetion.sendPacket((Packet) (new PacketOutBlockChange(var2, var5)));
			this.b.playerConncetion.sendPacket((Packet) (new PacketOutBlockChange(var2, var5.a(var6))));
		}

		var3 = this.b.playerInventory.getItemInHand();
		if (var3 != null && var3.b == 0) {
			this.b.playerInventory.contents[this.b.playerInventory.c] = null;
			var3 = null;
		}

		if (var3 == null || var3.l() == 0) {
			this.b.g = true;
			this.b.playerInventory.contents[this.b.playerInventory.c] = ItemStack.b(this.b.playerInventory.contents[this.b.playerInventory.c]);
			ajk var8 = this.b.activeContainer.a((IInventory) this.b.playerInventory, this.b.playerInventory.c);
			this.b.activeContainer.b();
			this.b.g = false;
			if (!ItemStack.b(this.b.playerInventory.getItemInHand(), var1.c())) {
				this.sendPacket((Packet) (new PacketOutSetSlot(this.b.activeContainer.d, var8.e, this.b.playerInventory.getItemInHand())));
			}
		}

	}

	public void a(mw var1) {
		ig.a(var1, this, this.b.u());
		if (this.b.v()) {
			Entity var2 = null;
			WorldServer[] var3 = this.d.worlds;
			int var4 = var3.length;

			for (int var5 = 0; var5 < var4; ++var5) {
				WorldServer var6 = var3[var5];
				if (var6 != null) {
					var2 = var1.a(var6);
					if (var2 != null) {
						break;
					}
				}
			}

			if (var2 != null) {
				this.b.e(this.b);
				this.b.a((Entity) null);
				if (var2.o != this.b.o) {
					WorldServer var7 = this.b.u();
					WorldServer var8 = (WorldServer) var2.o;
					this.b.dimensionId = var2.dimensionId;
					this.sendPacket((Packet) (new PacketOutRespawn(this.b.dimensionId, var7.getDifficulty(), var7.P().getLevelType(), this.b.c.getGameMode())));
					var7.f(this.b);
					this.b.I = false;
					this.b.b(var2.locationX, var2.locationY, var2.locationZ, var2.yaw, var2.pitch);
					if (this.b.ai()) {
						var7.a((Entity) this.b, false);
						var8.d(this.b);
						var8.a((Entity) this.b, false);
					}

					this.b.a((World) var8);
					this.d.getPlayerList().a(this.b, var7);
					this.b.a(var2.locationX, var2.locationY, var2.locationZ);
					this.b.c.a(var8);
					this.d.getPlayerList().b(this.b, var8);
					this.d.getPlayerList().f(this.b);
				} else {
					this.b.a(var2.locationX, var2.locationY, var2.locationZ);
				}
			}
		}

	}

	public void a(mq var1) {
	}

	public void handle(IJSONComponent var1) {
		c.info(this.b.d_() + " lost connection: " + var1);
		this.d.aF();
		hz var2 = new hz("multiplayer.player.left", new Object[] { this.b.e_() });
		var2.b().a(FormattingCode.o);
		this.d.getPlayerList().a((IJSONComponent) var2);
		this.b.q();
		this.d.getPlayerList().e(this.b);
		if (this.d.isSinglePlayer() && this.b.d_().equals(this.d.R())) {
			c.info("Stopping singleplayer server as player logged out");
			this.d.stopTicking();
		}

	}

	public void sendPacket(Packet var1) {
		if (var1 instanceof PacketOutChatMessage) {
			PacketOutChatMessage var2 = (PacketOutChatMessage) var1;
			ahg var3 = this.b.y();
			if (var3 == ahg.c) {
				return;
			}

			if (var3 == ahg.b && !var2.isChatMessage()) {
				return;
			}
		}

		try {
			this.a.a(var1);
		} catch (Throwable var5) {
			CrashReport var6 = CrashReport.generateCrashReport(var5, "Sending packet");
			CrashReportSystemDetails var4 = var6.generateSystemDetails("Packet being sent");
			var4.addDetails("Packet class", (Callable) (new rm(this, var1)));
			throw new ReportedException(var6);
		}
	}

	public void a(ms var1) {
		ig.a(var1, this, this.b.u());
		if (var1.a() >= 0 && var1.a() < PlayerInventory.i()) {
			this.b.playerInventory.c = var1.a();
			this.b.z();
		} else {
			c.warn(this.b.d_() + " tried to set an invalid carried item");
		}
	}

	public void a(lu var1) {
		ig.a(var1, this, this.b.u());
		if (this.b.y() == ahg.c) {
			hz var4 = new hz("chat.cannotSend", new Object[0]);
			var4.b().a(FormattingCode.m);
			this.sendPacket((Packet) (new PacketOutChatMessage(var4)));
		} else {
			this.b.z();
			String var2 = var1.a();
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
				hz var5 = new hz("chat.type.text", new Object[] { this.b.e_(), var2 });
				this.d.getPlayerList().a(var5, false);
			}

			this.l += 20;
			if (this.l > 200 && !this.d.getPlayerList().g(this.b.getGameProfile())) {
				this.c("disconnect.spam");
			}

		}
	}

	private void d(String var1) {
		this.d.getCommandHandler().a(this.b, var1);
	}

	public void a(mv var1) {
		ig.a(var1, this, this.b.u());
		this.b.z();
		this.b.bv();
	}

	public void a(mn var1) {
		ig.a(var1, this, this.b.u());
		this.b.z();
		switch (rn.b[var1.b().ordinal()]) {
			case 1:
				this.b.c(true);
				break;
			case 2:
				this.b.c(false);
				break;
			case 3:
				this.b.d(true);
				break;
			case 4:
				this.b.d(false);
				break;
			case 5:
				this.b.a(false, true, true);
				this.r = false;
				break;
			case 6:
				if (this.b.m instanceof EntityHorse) {
					((EntityHorse) this.b.m).v(var1.c());
				}
				break;
			case 7:
				if (this.b.m instanceof EntityHorse) {
					((EntityHorse) this.b.m).g(this.b);
				}
				break;
			default:
				throw new IllegalArgumentException("Invalid client command!");
		}

	}

	public void a(md var1) {
		ig.a(var1, this, this.b.u());
		WorldServer var2 = this.d.a(this.b.dimensionId);
		Entity var3 = var1.a((World) var2);
		this.b.z();
		if (var3 != null) {
			boolean var4 = this.b.t(var3);
			double var5 = 36.0D;
			if (!var4) {
				var5 = 9.0D;
			}

			if (this.b.h(var3) < var5) {
				if (var1.a() == me.a) {
					this.b.u(var3);
				} else if (var1.a() == me.c) {
					var3.a((EntityHuman) this.b, var1.b());
				} else if (var1.a() == me.b) {
					if (var3 instanceof EntityItem || var3 instanceof EntityExpirienceOrb || var3 instanceof EntityArrow || var3 == this.b) {
						this.c("Attempting to attack an invalid entity");
						this.d.f("Player " + this.b.d_() + " tried to attack an invalid entity");
						return;
					}

					this.b.f(var3);
				}
			}
		}

	}

	public void a(lv var1) {
		ig.a(var1, this, this.b.u());
		this.b.z();
		lw var2 = var1.a();
		switch (rn.c[var2.ordinal()]) {
			case 1:
				if (this.b.i) {
					this.b = this.d.getPlayerList().a(this.b, 0, true);
				} else if (this.b.u().P().isHardcore()) {
					if (this.d.isSinglePlayer() && this.b.d_().equals(this.d.R())) {
						this.b.playerConncetion.c("You have died. Game over, man, it\'s game over!");
						this.d.Z();
					} else {
						sw var3 = new sw(this.b.getGameProfile(), (Date) null, "(You just lost the game)", (Date) null, "Death in Hardcore");
						this.d.getPlayerList().i().a((sr) var3);
						this.b.playerConncetion.c("You have died. Game over, man, it\'s game over!");
					}
				} else {
					if (this.b.bm() > 0.0F) {
						return;
					}

					this.b = this.d.getPlayerList().a(this.b, 0, false);
				}
				break;
			case 2:
				this.b.A().a(this.b);
				break;
			case 3:
				this.b.b((Statistic) tl.f);
		}

	}

	public void a(mb var1) {
		ig.a(var1, this, this.b.u());
		this.b.p();
	}

	public void a(ma var1) {
		ig.a(var1, this, this.b.u());
		this.b.z();
		if (this.b.activeContainer.d == var1.a() && this.b.activeContainer.c(this.b)) {
			if (this.b.v()) {
				ArrayList var2 = Lists.newArrayList();

				for (int var3 = 0; var3 < this.b.activeContainer.c.size(); ++var3) {
					var2.add(((ajk) this.b.activeContainer.c.get(var3)).d());
				}

				this.b.a(this.b.activeContainer, (List) var2);
			} else {
				ItemStack var5 = this.b.activeContainer.a(var1.b(), var1.c(), var1.f(), this.b);
				if (ItemStack.b(var1.e(), var5)) {
					this.b.playerConncetion.sendPacket((Packet) (new PacketOutConfirmTransaction(var1.a(), var1.d(), true)));
					this.b.g = true;
					this.b.activeContainer.b();
					this.b.o();
					this.b.g = false;
				} else {
					this.n.a(this.b.activeContainer.d, Short.valueOf(var1.d()));
					this.b.playerConncetion.sendPacket((Packet) (new PacketOutConfirmTransaction(var1.a(), var1.d(), false)));
					this.b.activeContainer.a(this.b, false);
					ArrayList var6 = Lists.newArrayList();

					for (int var4 = 0; var4 < this.b.activeContainer.c.size(); ++var4) {
						var6.add(((ajk) this.b.activeContainer.c.get(var4)).d());
					}

					this.b.a(this.b.activeContainer, (List) var6);
				}
			}
		}

	}

	public void a(lz var1) {
		ig.a(var1, this, this.b.u());
		this.b.z();
		if (this.b.activeContainer.d == var1.a() && this.b.activeContainer.c(this.b) && !this.b.v()) {
			this.b.activeContainer.a((EntityHuman) this.b, var1.b());
			this.b.activeContainer.b();
		}

	}

	public void a(mt var1) {
		ig.a(var1, this, this.b.u());
		if (this.b.c.d()) {
			boolean var2 = var1.a() < 0;
			ItemStack var3 = var1.b();
			if (var3 != null && var3.hasTag() && var3.getTag().isTagAssignableFrom("BlockEntityTag", 10)) {
				NBTCompoundTag var4 = var3.getTag().getCompound("BlockEntityTag");
				if (var4.hasKey("x") && var4.hasKey("y") && var4.hasKey("z")) {
					Position var5 = new Position(var4.getInt("x"), var4.getInt("y"), var4.getInt("z"));
					TileEntity var6 = this.b.o.s(var5);
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

			boolean var8 = var1.a() >= 1 && var1.a() < 36 + PlayerInventory.i();
			boolean var9 = var3 == null || var3.getItem() != null;
			boolean var10 = var3 == null || var3.i() >= 0 && var3.b <= 64 && var3.b > 0;
			if (var8 && var9 && var10) {
				if (var3 == null) {
					this.b.defaultContainer.a(var1.a(), (ItemStack) null);
				} else {
					this.b.defaultContainer.a(var1.a(), var3);
				}

				this.b.defaultContainer.a(this.b, true);
			} else if (var2 && var9 && var10 && this.m < 200) {
				this.m += 20;
				EntityItem var11 = this.b.a(var3, true);
				if (var11 != null) {
					var11.j();
				}
			}
		}

	}

	public void a(ly var1) {
		ig.a(var1, this, this.b.u());
		Short var2 = (Short) this.n.a(this.b.activeContainer.d);
		if (var2 != null && var1.b() == var2.shortValue() && this.b.activeContainer.d == var1.a() && !this.b.activeContainer.c(this.b) && !this.b.v()) {
			this.b.activeContainer.a(this.b, true);
		}

	}

	public void a(mu var1) {
		ig.a(var1, this, this.b.u());
		this.b.z();
		WorldServer var2 = this.d.a(this.b.dimensionId);
		Position var3 = var1.a();
		if (var2.e(var3)) {
			TileEntity var4 = var2.s(var3);
			if (!(var4 instanceof TileEntitySign)) {
				return;
			}

			TileEntitySign var5 = (TileEntitySign) var4;
			if (!var5.b() || var5.c() != this.b) {
				this.d.f("Player " + this.b.d_() + " just tried to change non-editable sign");
				return;
			}

			System.arraycopy(var1.b(), 0, var5.a, 0, 4);
			var5.o_();
			var2.h(var3);
		}

	}

	public void a(mf var1) {
		if (var1.a() == this.i) {
			int var2 = (int) (this.d() - this.j);
			this.b.h = (this.b.h * 3 + var2) / 4;
		}

	}

	private long d() {
		return System.nanoTime() / 1000000L;
	}

	public void a(mk var1) {
		ig.a(var1, this, this.b.u());
		this.b.by.flying = var1.b() && this.b.by.mayfly;
	}

	public void a(lt var1) {
		ig.a(var1, this, this.b.u());
		ArrayList var2 = Lists.newArrayList();
		Iterator var3 = this.d.getTabCompleteList((CommandSenderInterface) this.b, var1.a(), var1.b()).iterator();

		while (var3.hasNext()) {
			String var4 = (String) var3.next();
			var2.add(var4);
		}

		this.b.playerConncetion.sendPacket((Packet) (new iy((String[]) var2.toArray(new String[var2.size()]))));
	}

	public void a(lx var1) {
		ig.a(var1, this, this.b.u());
		this.b.a(var1);
	}

	public void a(mc var1) {
		ig.a(var1, this, this.b.u());
		PacketDataSerializer var2;
		ItemStack var3;
		ItemStack var4;
		if ("MC|BEdit".equals(var1.a())) {
			var2 = new PacketDataSerializer(Unpooled.wrappedBuffer((ByteBuf) var1.b()));

			try {
				var3 = var2.readItemStack();
				if (var3 != null) {
					if (!ItemBookAndQuill.b(var3.getTag())) {
						throw new IOException("Invalid book tag!");
					}

					var4 = this.b.playerInventory.getItemInHand();
					if (var4 == null) {
						return;
					}

					if (var3.getItem() == Items.WRITABLE_BOOK && var3.getItem() == var4.getItem()) {
						var4.a("pages", (NBTTag) var3.getTag().getList("pages", 8));
					}

					return;
				}
			} catch (Exception var38) {
				c.error("Couldn\'t handle book info", (Throwable) var38);
				return;
			} finally {
				var2.release();
			}

			return;
		} else if ("MC|BSign".equals(var1.a())) {
			var2 = new PacketDataSerializer(Unpooled.wrappedBuffer((ByteBuf) var1.b()));

			try {
				var3 = var2.readItemStack();
				if (var3 != null) {
					if (!ItemWrittenBook.b(var3.getTag())) {
						throw new IOException("Invalid book tag!");
					}

					var4 = this.b.playerInventory.getItemInHand();
					if (var4 == null) {
						return;
					}

					if (var3.getItem() == Items.WRITTEN_BOK && var4.getItem() == Items.WRITABLE_BOOK) {
						var4.a("author", (NBTTag) (new NBTStringTag(this.b.d_())));
						var4.a("title", (NBTTag) (new NBTStringTag(var3.getTag().getString("title"))));
						var4.a("pages", (NBTTag) var3.getTag().getList("pages", 8));
						var4.a(Items.WRITTEN_BOK);
					}

					return;
				}
			} catch (Exception var36) {
				c.error("Couldn\'t sign book", (Throwable) var36);
				return;
			} finally {
				var2.release();
			}

			return;
		} else if ("MC|TrSel".equals(var1.a())) {
			try {
				int var40 = var1.b().readInt();
				Container var42 = this.b.activeContainer;
				if (var42 instanceof ajf) {
					((ajf) var42).d(var40);
				}
			} catch (Exception var35) {
				c.error("Couldn\'t select trade", (Throwable) var35);
			}
		} else if ("MC|AdvCdm".equals(var1.a())) {
			if (!this.d.isCommandBlockEnabled()) {
				this.b.sendChatMessage((IJSONComponent) (new hz("advMode.notEnabled", new Object[0])));
			} else if (this.b.a(2, "") && this.b.by.instabuild) {
				var2 = var1.b();

				try {
					byte var43 = var2.readByte();
					aqf var46 = null;
					if (var43 == 0) {
						TileEntity var5 = this.b.o.s(new Position(var2.readInt(), var2.readInt(), var2.readInt()));
						if (var5 instanceof TileEntityCommand) {
							var46 = ((TileEntityCommand) var5).b();
						}
					} else if (var43 == 1) {
						Entity var48 = this.b.o.a(var2.readInt());
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
							var46.b((IJSONComponent) null);
						}

						var46.h();
						this.b.sendChatMessage((IJSONComponent) (new hz("advMode.setCommand.success", new Object[] { var49 })));
					}
				} catch (Exception var33) {
					c.error("Couldn\'t set command block", (Throwable) var33);
				} finally {
					var2.release();
				}
			} else {
				this.b.sendChatMessage((IJSONComponent) (new hz("advMode.notAllowed", new Object[0])));
			}
		} else if ("MC|Beacon".equals(var1.a())) {
			if (this.b.activeContainer instanceof aig) {
				try {
					var2 = var1.b();
					int var44 = var2.readInt();
					int var47 = var2.readInt();
					aig var50 = (aig) this.b.activeContainer;
					ajk var51 = var50.a(0);
					if (var51.e()) {
						var51.a(1);
						IInventory var7 = var50.e();
						var7.b(1, var44);
						var7.b(2, var47);
						var7.o_();
					}
				} catch (Exception var32) {
					c.error("Couldn\'t set beacon", (Throwable) var32);
				}
			}
		} else if ("MC|ItemName".equals(var1.a()) && this.b.activeContainer instanceof aid) {
			aid var41 = (aid) this.b.activeContainer;
			if (var1.b() != null && var1.b().readableBytes() >= 1) {
				String var45 = v.a(var1.b().readString(32767));
				if (var45.length() <= 30) {
					var41.a(var45);
				}
			} else {
				var41.a("");
			}
		}

	}

}
