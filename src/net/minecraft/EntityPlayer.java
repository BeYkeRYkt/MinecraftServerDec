package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mojang.authlib.GameProfile;

import io.netty.buffer.Unpooled;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import net.minecraft.server.MinecraftServer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EntityPlayer extends EntityHuman implements ICrafting {

	private static final Logger bF = LogManager.getLogger();
	private String bG = "en_US";
	public rj a;
	public final MinecraftServer b;
	public final qx c;
	public double d;
	public double e;
	public final List f = Lists.newLinkedList();
	private final List bH = Lists.newLinkedList();
	private final PlayerStatisticFile bI;
	private float bJ = Float.MIN_VALUE;
	private float bK = -1.0E8F;
	private int bL = -99999999;
	private boolean bM = true;
	private int bN = -99999999;
	private int bO = 60;
	private ahg bP;
	private boolean bQ = true;
	private long bR = System.currentTimeMillis();
	private Entity bS = null;
	private int bT;
	public boolean g;
	public int h;
	public boolean i;

	public EntityPlayer(MinecraftServer var1, WorldServer var2, GameProfile var3, qx var4) {
		super(var2, var3);
		var4.b = this;
		this.c = var4;
		Position var5 = var2.M();
		if (!var2.worldProvider.noSkyLight() && var2.P().r() != GameMode.ADVENTURE) {
			int var6 = Math.max(5, var1.isSpawnProtectionEnabled() - 6);
			int var7 = DataTypesConverter.toFixedPointInt(var2.af().b((double) var5.n(), (double) var5.p()));
			if (var7 < var6) {
				var6 = var7;
			}

			if (var7 <= 1) {
				var6 = 1;
			}

			var5 = var2.r(var5.a(this.V.nextInt(var6 * 2) - var6, 0, this.V.nextInt(var6 * 2) - var6));
		}

		this.b = var1;
		this.bI = var1.getPlayerList().getPLayerStatistic((EntityHuman) this);
		this.S = 0.0F;
		this.a(var5, 0.0F, 0.0F);

		while (!var2.a((Entity) this, this.aQ()).isEmpty() && this.locationY < 255.0D) {
			this.b(this.locationX, this.locationY + 1.0D, this.locationZ);
		}

	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		if (var1.isTagAssignableFrom("playerGameType", 99)) {
			if (MinecraftServer.getInstance().av()) {
				this.c.a(MinecraftServer.getInstance().getServerGameMode());
			} else {
				this.c.a(GameMode.byId(var1.getInt("playerGameType")));
			}
		}

	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.put("playerGameType", this.c.getGameMode().getId());
	}

	public void a(int var1) {
		super.a(var1);
		this.bN = -1;
	}

	public void b(int var1) {
		super.b(var1);
		this.bN = -1;
	}

	public void f_() {
		this.activeContainer.a((ICrafting) this);
	}

	public void g_() {
		super.g_();
		this.a.a((Packet) (new ke(this.br(), kg.a)));
	}

	public void j() {
		super.j();
		this.a.a((Packet) (new ke(this.br(), kg.b)));
	}

	public void s_() {
		this.c.a();
		--this.bO;
		if (this.Z > 0) {
			--this.Z;
		}

		this.activeContainer.b();
		if (!this.o.D && !this.activeContainer.a((EntityHuman) this)) {
			this.n();
			this.activeContainer = this.defaultContainer;
		}

		while (!this.bH.isEmpty()) {
			int var1 = Math.min(this.bH.size(), Integer.MAX_VALUE);
			int[] var2 = new int[var1];
			Iterator var3 = this.bH.iterator();
			int var4 = 0;

			while (var3.hasNext() && var4 < var1) {
				var2[var4++] = ((Integer) var3.next()).intValue();
				var3.remove();
			}

			this.a.a((Packet) (new PacketDestroyEntities(var2)));
		}

		if (!this.f.isEmpty()) {
			ArrayList var6 = Lists.newArrayList();
			Iterator var8 = this.f.iterator();
			ArrayList var9 = Lists.newArrayList();

			Chunk var5;
			while (var8.hasNext() && var6.size() < 10) {
				ChunkCoordIntPair var10 = (ChunkCoordIntPair) var8.next();
				if (var10 != null) {
					if (this.o.e(new Position(var10.chunkX << 4, 0, var10.chunkZ << 4))) {
						var5 = this.o.a(var10.chunkX, var10.chunkZ);
						if (var5.i()) {
							var6.add(var5);
							var9.addAll(((WorldServer) this.o).a(var10.chunkX * 16, 0, var10.chunkZ * 16, var10.chunkX * 16 + 16, 256, var10.chunkZ * 16 + 16));
							var8.remove();
						}
					}
				} else {
					var8.remove();
				}
			}

			if (!var6.isEmpty()) {
				if (var6.size() == 1) {
					this.a.a((Packet) (new PacketChunkData((Chunk) var6.get(0), true, '\uffff')));
				} else {
					this.a.a((Packet) (new js(var6)));
				}

				Iterator var11 = var9.iterator();

				while (var11.hasNext()) {
					bcm var12 = (bcm) var11.next();
					this.a(var12);
				}

				var11 = var6.iterator();

				while (var11.hasNext()) {
					var5 = (Chunk) var11.next();
					this.u().s().a(this, var5);
				}
			}
		}

		Entity var7 = this.C();
		if (var7 != this) {
			if (!var7.ai()) {
				this.e(this);
			} else {
				this.a(var7.locationX, var7.locationY, var7.locationZ, var7.yaw, var7.pitch);
				this.b.getPlayerList().d(this);
				if (this.aw()) {
					this.e(this);
				}
			}
		}

	}

	public void l() {
		try {
			super.s_();

			for (int var1 = 0; var1 < this.playerInventory.n_(); ++var1) {
				ItemStack var6 = this.playerInventory.a(var1);
				if (var6 != null && var6.getItem().f()) {
					Packet var8 = ((ake) var6.getItem()).c(var6, this.o, this);
					if (var8 != null) {
						this.a.a(var8);
					}
				}
			}

			if (this.bm() != this.bK || this.bL != this.fooddata.a() || this.fooddata.e() == 0.0F != this.bM) {
				this.a.a((Packet) (new PacketUpdateHealth(this.bm(), this.fooddata.a(), this.fooddata.e())));
				this.bK = this.bm();
				this.bL = this.fooddata.a();
				this.bM = this.fooddata.e() == 0.0F;
			}

			if (this.bm() + this.bM() != this.bJ) {
				this.bJ = this.bm() + this.bM();
				Collection var5 = this.co().a(bsk.g);
				Iterator var7 = var5.iterator();

				while (var7.hasNext()) {
					bry var9 = (bry) var7.next();
					this.co().c(this.d_(), var9).a(Arrays.asList(new EntityHuman[] { this }));
				}
			}

			if (this.bA != this.bN) {
				this.bN = this.bA;
				this.a.a((Packet) (new PacketSetExpirience(this.bB, this.bA, this.bz)));
			}

			if (this.W % 20 * 5 == 0 && !this.A().a(tl.L)) {
				this.h_();
			}

		} catch (Throwable var4) {
			CrashReport var2 = CrashReport.generateCrashReport(var4, "Ticking player");
			CrashReportSystemDetails var3 = var2.generateSystemDetails("Player being ticked");
			this.a(var3);
			throw new ReportedException(var2);
		}
	}

	protected void h_() {
		arm var1 = this.o.b(new Position(DataTypesConverter.toFixedPointInt(this.locationX), 0, DataTypesConverter.toFixedPointInt(this.locationZ)));
		String var2 = var1.ah;
		ua var3 = (ua) this.A().b((PlayerStatistic) tl.L);
		if (var3 == null) {
			var3 = (ua) this.A().a(tl.L, new ua());
		}

		var3.add(var2);
		if (this.A().b(tl.L) && var3.size() >= arm.n.size()) {
			HashSet var4 = Sets.newHashSet((Iterable) arm.n);
			Iterator var5 = var3.iterator();

			while (var5.hasNext()) {
				String var6 = (String) var5.next();
				Iterator var7 = var4.iterator();

				while (var7.hasNext()) {
					arm var8 = (arm) var7.next();
					if (var8.ah.equals(var6)) {
						var7.remove();
					}
				}

				if (var4.isEmpty()) {
					break;
				}
			}

			if (var4.isEmpty()) {
				this.b((PlayerStatistic) tl.L);
			}
		}

	}

	public void a(wh var1) {
		if (this.o.Q().b("showDeathMessages")) {
			bsf var2 = this.bN();
			if (var2 != null && var2.j() != bsg.a) {
				if (var2.j() == bsg.c) {
					this.b.getPlayerList().a((EntityHuman) this, this.br().b());
				} else if (var2.j() == bsg.d) {
					this.b.getPlayerList().b((EntityHuman) this, this.br().b());
				}
			} else {
				this.b.getPlayerList().a(this.br().b());
			}
		}

		if (!this.o.Q().b("keepInventory")) {
			this.playerInventory.n();
		}

		Collection var6 = this.o.Z().a(bsk.d);
		Iterator var3 = var6.iterator();

		while (var3.hasNext()) {
			bry var4 = (bry) var3.next();
			bsa var5 = this.co().c(this.d_(), var4);
			var5.a();
		}

		EntityLiving var7 = this.bs();
		if (var7 != null) {
			xc var8 = (xc) EntityTypes.a.get(Integer.valueOf(EntityTypes.getFixedId(var7)));
			if (var8 != null) {
				this.b(var8.e);
			}

			var7.b(this, this.aU);
		}

		this.b(ty.y);
		this.a(ty.h);
		this.br().g();
	}

	public boolean a(wh var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			boolean var3 = this.b.isDedicated() && this.cq() && "fall".equals(var1.p);
			if (!var3 && this.bO > 0 && var1 != wh.j) {
				return false;
			} else {
				if (var1 instanceof wi) {
					Entity var4 = var1.j();
					if (var4 instanceof EntityHuman && !this.a((EntityHuman) var4)) {
						return false;
					}

					if (var4 instanceof ahj) {
						ahj var5 = (ahj) var4;
						if (var5.c instanceof EntityHuman && !this.a((EntityHuman) var5.c)) {
							return false;
						}
					}
				}

				return super.a(var1, var2);
			}
		}
	}

	public boolean a(EntityHuman var1) {
		return !this.cq() ? false : super.a(var1);
	}

	private boolean cq() {
		return this.b.isPVPEnabled();
	}

	public void c(int var1) {
		if (this.am == 1 && var1 == 1) {
			this.b((PlayerStatistic) tl.D);
			this.o.e((Entity) this);
			this.i = true;
			this.a.a((Packet) (new jo(4, 0.0F)));
		} else {
			if (this.am == 0 && var1 == 1) {
				this.b((PlayerStatistic) tl.C);
				Position var2 = this.b.a(var1).m();
				if (var2 != null) {
					this.a.a((double) var2.n(), (double) var2.o(), (double) var2.p(), 0.0F, 0.0F);
				}

				var1 = 1;
			} else {
				this.b((PlayerStatistic) tl.y);
			}

			this.b.getPlayerList().a(this, var1);
			this.bN = -1;
			this.bK = -1.0F;
			this.bL = -1;
		}

	}

	public boolean a(EntityPlayer var1) {
		return var1.v() ? this.C() == this : (this.v() ? false : super.a(var1));
	}

	private void a(bcm var1) {
		if (var1 != null) {
			Packet var2 = var1.x_();
			if (var2 != null) {
				this.a.a(var2);
			}
		}

	}

	public void a(Entity var1, int var2) {
		super.a(var1, var2);
		this.activeContainer.b();
	}

	public ahf a(Position var1) {
		ahf var2 = super.a(var1);
		if (var2 == ahf.a) {
			PacketUseBed var3 = new PacketUseBed(this, var1);
			this.u().s().a((Entity) this, (Packet) var3);
			this.a.a(this.locationX, this.locationY, this.locationZ, this.yaw, this.pitch);
			this.a.a((Packet) var3);
		}

		return var2;
	}

	public void a(boolean var1, boolean var2, boolean var3) {
		if (this.bI()) {
			this.u().s().b(this, new PacketAnimation(this, 2));
		}

		super.a(var1, var2, var3);
		if (this.a != null) {
			this.a.a(this.locationX, this.locationY, this.locationZ, this.yaw, this.pitch);
		}

	}

	public void a(Entity var1) {
		Entity var2 = this.m;
		super.a(var1);
		if (var1 != var2) {
			this.a.a((Packet) (new PacketAttachEntity(0, this, this.m)));
			this.a.a(this.locationX, this.locationY, this.locationZ, this.yaw, this.pitch);
		}

	}

	protected void a(double var1, boolean var3, Block var4, Position var5) {
	}

	public void a(double var1, boolean var3) {
		int var4 = DataTypesConverter.toFixedPointInt(this.locationX);
		int var5 = DataTypesConverter.toFixedPointInt(this.locationY - 0.20000000298023224D);
		int var6 = DataTypesConverter.toFixedPointInt(this.locationZ);
		Position var7 = new Position(var4, var5, var6);
		Block var8 = this.o.p(var7).c();
		if (var8.r() == Material.AIR) {
			Block var9 = this.o.p(var7.b()).c();
			if (var9 instanceof BlockFence || var9 instanceof BlockCobbleWall || var9 instanceof BlockFenceGate) {
				var7 = var7.b();
				var8 = this.o.p(var7).c();
			}
		}

		super.a(var1, var3, var8, var7);
	}

	public void a(bdj var1) {
		var1.a((EntityHuman) this);
		this.a.a((Packet) (new kc(var1.v())));
	}

	private void cr() {
		this.bT = this.bT % 100 + 1;
	}

	public void a(vv var1) {
		this.cr();
		this.a.a((Packet) (new je(this.bT, var1.k(), var1.e_())));
		this.activeContainer = var1.a(this.playerInventory, this);
		this.activeContainer.d = this.bT;
		this.activeContainer.a((ICrafting) this);
	}

	public void a(IInventory var1) {
		if (this.activeContainer != this.defaultContainer) {
			this.n();
		}

		if (var1 instanceof vy) {
			vy var2 = (vy) var1;
			if (var2.q_() && !this.a(var2.i()) && !this.v()) {
				this.a.a((Packet) (new PacketChatMessage(new hz("container.isLocked", new Object[] { var1.e_() }), (byte) 2)));
				this.a.a((Packet) (new jv("random.door_close", this.locationX, this.locationY, this.locationZ, 1.0F, 1.0F)));
				return;
			}
		}

		this.cr();
		if (var1 instanceof vv) {
			this.a.a((Packet) (new je(this.bT, ((vv) var1).k(), var1.e_(), var1.n_())));
			this.activeContainer = ((vv) var1).a(this.playerInventory, this);
		} else {
			this.a.a((Packet) (new je(this.bT, "minecraft:container", var1.e_(), var1.n_())));
			this.activeContainer = new aim(this.playerInventory, var1, this);
		}

		this.activeContainer.d = this.bT;
		this.activeContainer.a((ICrafting) this);
	}

	public void a(aqb var1) {
		this.cr();
		this.activeContainer = new ajf(this.playerInventory, var1, this.o);
		this.activeContainer.d = this.bT;
		this.activeContainer.a((ICrafting) this);
		aje var2 = ((ajf) this.activeContainer).e();
		IJSONComponent var3 = var1.e_();
		this.a.a((Packet) (new je(this.bT, "minecraft:villager", var3, var2.n_())));
		aqd var4 = var1.b_(this);
		if (var4 != null) {
			PacketDataSerializer var5 = new PacketDataSerializer(Unpooled.buffer());
			var5.writeInt(this.bT);
			var4.a(var5);
			this.a.a((Packet) (new ji("MC|TrList", var5)));
		}

	}

	public void a(abt var1, IInventory var2) {
		if (this.activeContainer != this.defaultContainer) {
			this.n();
		}

		this.cr();
		this.a.a((Packet) (new je(this.bT, "EntityHorse", var2.e_(), var2.n_(), var1.getId())));
		this.activeContainer = new aiy(this.playerInventory, var2, var1, this);
		this.activeContainer.d = this.bT;
		this.activeContainer.a((ICrafting) this);
	}

	public void a(ItemStack var1) {
		Item var2 = var1.getItem();
		if (var2 == amk.bN) {
			this.a.a((Packet) (new ji("MC|BOpen", new PacketDataSerializer(Unpooled.buffer()))));
		}

	}

	public void a(Container var1, int var2, ItemStack var3) {
		if (!(var1.a(var2) instanceof ajj)) {
			if (!this.g) {
				this.a.a((Packet) (new jh(var1.d, var2, var3)));
			}
		}
	}

	public void a(Container var1) {
		this.a(var1, var1.a());
	}

	public void a(Container var1, List var2) {
		this.a.a((Packet) (new jf(var1.d, var2)));
		this.a.a((Packet) (new jh(-1, -1, this.playerInventory.p())));
	}

	public void a(Container var1, int var2, int var3) {
		this.a.a((Packet) (new jg(var1.d, var2, var3)));
	}

	public void a(Container var1, IInventory var2) {
		for (int var3 = 0; var3 < var2.g(); ++var3) {
			this.a.a((Packet) (new jg(var1.d, var3, var2.a_(var3))));
		}

	}

	public void n() {
		this.a.a((Packet) (new jd(this.activeContainer.d)));
		this.p();
	}

	public void o() {
		if (!this.g) {
			this.a.a((Packet) (new jh(-1, -1, this.playerInventory.p())));
		}
	}

	public void p() {
		this.activeContainer.b((EntityHuman) this);
		this.activeContainer = this.defaultContainer;
	}

	public void a(float var1, float var2, boolean var3, boolean var4) {
		if (this.m != null) {
			if (var1 >= -1.0F && var1 <= 1.0F) {
				this.aX = var1;
			}

			if (var2 >= -1.0F && var2 <= 1.0F) {
				this.aY = var2;
			}

			this.aW = var3;
			this.c(var4);
		}

	}

	public void a(PlayerStatistic var1, int var2) {
		if (var1 != null) {
			this.bI.b(this, var1, var2);
			Iterator var3 = this.co().a(var1.k()).iterator();

			while (var3.hasNext()) {
				bry var4 = (bry) var3.next();
				this.co().c(this.d_(), var4).a(var2);
			}

			if (this.bI.e()) {
				this.bI.a(this);
			}

		}
	}

	public void a(PlayerStatistic var1) {
		if (var1 != null) {
			this.bI.a(this, var1, 0);
			Iterator var2 = this.co().a(var1.k()).iterator();

			while (var2.hasNext()) {
				bry var3 = (bry) var2.next();
				this.co().c(this.d_(), var3).c(0);
			}

			if (this.bI.e()) {
				this.bI.a(this);
			}

		}
	}

	public void q() {
		if (this.l != null) {
			this.l.a((Entity) this);
		}

		if (this.bu) {
			this.a(true, false, false);
		}

	}

	public void r() {
		this.bK = -1.0E8F;
	}

	public void b(IJSONComponent var1) {
		this.a.a((Packet) (new PacketChatMessage(var1)));
	}

	protected void s() {
		this.a.a((Packet) (new PacketEntityStatus(this, (byte) 9)));
		super.s();
	}

	public void a(ItemStack var1, int var2) {
		super.a(var1, var2);
		if (var1 != null && var1.getItem() != null && var1.getItem().e(var1) == ano.b) {
			this.u().s().b(this, new PacketAnimation(this, 3));
		}

	}

	public void a(EntityHuman var1, boolean var2) {
		super.a(var1, var2);
		this.bN = -1;
		this.bK = -1.0F;
		this.bL = -1;
		this.bH.addAll(((EntityPlayer) var1).bH);
	}

	protected void a(MobEffect var1) {
		super.a(var1);
		this.a.a((Packet) (new PacketEntityEffect(this.getId(), var1)));
	}

	protected void a(MobEffect var1, boolean var2) {
		super.a(var1, var2);
		this.a.a((Packet) (new PacketEntityEffect(this.getId(), var1)));
	}

	protected void b(MobEffect var1) {
		super.b(var1);
		this.a.a((Packet) (new PacketRemoveEntityEffect(this.getId(), var1)));
	}

	public void a(double var1, double var3, double var5) {
		this.a.a(var1, var3, var5, this.yaw, this.pitch);
	}

	public void b(Entity var1) {
		this.u().s().b(this, new PacketAnimation(var1, 4));
	}

	public void c(Entity var1) {
		this.u().s().b(this, new PacketAnimation(var1, 5));
	}

	public void t() {
		if (this.a != null) {
			this.a.a((Packet) (new kd(this.by)));
			this.B();
		}
	}

	public WorldServer u() {
		return (WorldServer) this.o;
	}

	public void a(GameMode var1) {
		this.c.a(var1);
		this.a.a((Packet) (new jo(3, (float) var1.getId())));
		if (var1 == GameMode.SPECTATOR) {
			this.a((Entity) null);
		} else {
			this.e(this);
		}

		this.t();
		this.bO();
	}

	public boolean v() {
		return this.c.getGameMode() == GameMode.SPECTATOR;
	}

	public void a(IJSONComponent var1) {
		this.a.a((Packet) (new PacketChatMessage(var1)));
	}

	public boolean a(int var1, String var2) {
		if ("seed".equals(var2) && !this.b.isDedicated()) {
			return true;
		} else if (!"tell".equals(var2) && !"help".equals(var2) && !"me".equals(var2) && !"trigger".equals(var2)) {
			if (this.b.getPlayerList().g(this.getGameProfile())) {
				sq var3 = (sq) this.b.getPlayerList().n().b((Object) this.getGameProfile());
				return var3 != null ? var3.a() >= var1 : this.b.getOpPermissionLevel() >= var1;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	public String w() {
		String var1 = this.a.a.b().toString();
		var1 = var1.substring(var1.indexOf("/") + 1);
		var1 = var1.substring(0, var1.indexOf(":"));
		return var1;
	}

	public void a(lx var1) {
		this.bG = var1.a();
		this.bP = var1.c();
		this.bQ = var1.d();
		this.getDataWatcher().b(10, Byte.valueOf((byte) var1.e()));
	}

	public ahg y() {
		return this.bP;
	}

	public void a(String var1, String var2) {
		this.a.a((Packet) (new ko(var1, var2)));
	}

	public Position c() {
		return new Position(this.locationX, this.locationY + 0.5D, this.locationZ);
	}

	public void z() {
		this.bR = MinecraftServer.getCurrentMillis();
	}

	public PlayerStatisticFile A() {
		return this.bI;
	}

	public void d(Entity var1) {
		if (var1 instanceof EntityHuman) {
			this.a.a((Packet) (new PacketDestroyEntities(new int[] { var1.getId() })));
		} else {
			this.bH.add(Integer.valueOf(var1.getId()));
		}

	}

	protected void B() {
		if (this.v()) {
			this.bi();
			this.e(true);
		} else {
			super.B();
		}

		this.u().s().a(this);
	}

	public Entity C() {
		return (Entity) (this.bS == null ? this : this.bS);
	}

	public void e(Entity var1) {
		Entity var2 = this.C();
		this.bS = (Entity) (var1 == null ? this : var1);
		if (var2 != this.bS) {
			this.a.a((Packet) (new ku(this.bS)));
			this.a(this.bS.locationX, this.bS.locationY, this.bS.locationZ);
		}

	}

	public void f(Entity var1) {
		if (this.c.getGameMode() == GameMode.SPECTATOR) {
			this.e(var1);
		} else {
			super.f(var1);
		}

	}

	public long D() {
		return this.bR;
	}

	public IJSONComponent E() {
		return null;
	}

}
