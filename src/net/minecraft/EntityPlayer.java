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

import net.minecraft.PacketPlayOutCombatEvent.CombatEvent;
import net.minecraft.server.MinecraftServer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EntityPlayer extends EntityHuman implements ICrafting {

	private static final Logger logger = LogManager.getLogger();
	private String locale = "en_US";
	public PlayerConnection playerConncetion;
	public final MinecraftServer minecraftserver;
	public final PlayerInteractManager playerInteractManager;
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
	private EnumChatFlag bP;
	private boolean bQ = true;
	private long bR = System.currentTimeMillis();
	private Entity bS = null;
	private int bT;
	public boolean g;
	public int ping;
	public boolean i;

	public EntityPlayer(MinecraftServer var1, WorldServer var2, GameProfile var3, PlayerInteractManager var4) {
		super(var2, var3);
		var4.b = this;
		this.playerInteractManager = var4;
		Position var5 = var2.M();
		if (!var2.worldProvider.noSkyLight() && var2.P().r() != GameMode.ADVENTURE) {
			int var6 = Math.max(5, var1.isSpawnProtectionEnabled() - 6);
			int var7 = DataTypesConverter.toFixedPointInt(var2.getWorldBorder().getDistance((double) var5.getX(), (double) var5.getZ()));
			if (var7 < var6) {
				var6 = var7;
			}

			if (var7 <= 1) {
				var6 = 1;
			}

			var5 = var2.r(var5.a(this.V.nextInt(var6 * 2) - var6, 0, this.V.nextInt(var6 * 2) - var6));
		}

		this.minecraftserver = var1;
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
				this.playerInteractManager.a(MinecraftServer.getInstance().getServerGameMode());
			} else {
				this.playerInteractManager.a(GameMode.getById(var1.getInt("playerGameType")));
			}
		}

	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.put("playerGameType", this.playerInteractManager.getGameMode().getId());
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
		this.playerConncetion.sendPacket((Packet) (new PacketPlayOutCombatEvent(this.br(), CombatEvent.ENTER_COMBAT)));
	}

	public void j() {
		super.j();
		this.playerConncetion.sendPacket((Packet) (new PacketPlayOutCombatEvent(this.br(), CombatEvent.END_COMBAT)));
	}

	public void s_() {
		this.playerInteractManager.a();
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

			this.playerConncetion.sendPacket((Packet) (new PacketPlayOutDestroyEntities(var2)));
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
					this.playerConncetion.sendPacket((Packet) (new PacketPlayOutChunkData((Chunk) var6.get(0), true, '\uffff')));
				} else {
					this.playerConncetion.sendPacket((Packet) (new PacketPlayOutMapChunkBulk(var6)));
				}

				Iterator var11 = var9.iterator();

				while (var11.hasNext()) {
					TileEntity var12 = (TileEntity) var11.next();
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
				this.minecraftserver.getPlayerList().d(this);
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
					Packet var8 = ((ItemMap) var6.getItem()).c(var6, this.o, this);
					if (var8 != null) {
						this.playerConncetion.sendPacket(var8);
					}
				}
			}

			if (this.bm() != this.bK || this.bL != this.fooddata.a() || this.fooddata.e() == 0.0F != this.bM) {
				this.playerConncetion.sendPacket((Packet) (new PacketPlayOutUpdateHealth(this.bm(), this.fooddata.a(), this.fooddata.e())));
				this.bK = this.bm();
				this.bL = this.fooddata.a();
				this.bM = this.fooddata.e() == 0.0F;
			}

			if (this.bm() + this.bM() != this.bJ) {
				this.bJ = this.bm() + this.bM();
				Collection var5 = this.co().a(IScoreboardCriteria.health);
				Iterator var7 = var5.iterator();

				while (var7.hasNext()) {
					ScoreboardObjective var9 = (ScoreboardObjective) var7.next();
					this.co().c(this.d_(), var9).updateForList(Arrays.asList(new EntityHuman[] { this }));
				}
			}

			if (this.bA != this.bN) {
				this.bN = this.bA;
				this.playerConncetion.sendPacket((Packet) (new PacketPlayOutSetExpirience(this.bB, this.bA, this.bz)));
			}

			if (this.W % 20 * 5 == 0 && !this.A().a(AchievementList.L)) {
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
		AchievmentSet var3 = (AchievmentSet) this.A().b((Statistic) AchievementList.L);
		if (var3 == null) {
			var3 = (AchievmentSet) this.A().a(AchievementList.L, new AchievmentSet());
		}

		var3.add(var2);
		if (this.A().b(AchievementList.L) && var3.size() >= arm.n.size()) {
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
				this.b((Statistic) AchievementList.L);
			}
		}

	}

	public void a(DamageSource var1) {
		if (this.o.Q().b("showDeathMessages")) {
			ScoreboardTeamBase var2 = this.bN();
			if (var2 != null && var2.getDeathMessageVisibility() != ScoreboardTeamNameTagVisibility.ALWAYS) {
				if (var2.getDeathMessageVisibility() == ScoreboardTeamNameTagVisibility.HIDE_FOR_OTHER_TEAMS) {
					this.minecraftserver.getPlayerList().a((EntityHuman) this, this.br().getMessage());
				} else if (var2.getDeathMessageVisibility() == ScoreboardTeamNameTagVisibility.HIDE_FOR_OWN_TEAM) {
					this.minecraftserver.getPlayerList().b((EntityHuman) this, this.br().getMessage());
				}
			} else {
				this.minecraftserver.getPlayerList().a(this.br().getMessage());
			}
		}

		if (!this.o.Q().b("keepInventory")) {
			this.playerInventory.n();
		}

		Collection var6 = this.o.Z().a(IScoreboardCriteria.deathCount);
		Iterator var3 = var6.iterator();

		while (var3.hasNext()) {
			ScoreboardObjective var4 = (ScoreboardObjective) var3.next();
			ScoreboardScore var5 = this.co().c(this.d_(), var4);
			var5.incrementScore();
		}

		EntityLiving var7 = this.bs();
		if (var7 != null) {
			MonsterEggInfo var8 = (MonsterEggInfo) EntityTypes.eggInfo.get(Integer.valueOf(EntityTypes.getFixedId(var7)));
			if (var8 != null) {
				this.b(var8.e);
			}

			var7.b(this, this.aU);
		}

		this.b(StatisticList.y);
		this.a(StatisticList.h);
		this.br().g();
	}

	public boolean a(DamageSource var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			boolean var3 = this.minecraftserver.isDedicated() && this.cq() && "fall".equals(var1.p);
			if (!var3 && this.bO > 0 && var1 != DamageSource.j) {
				return false;
			} else {
				if (var1 instanceof wi) {
					Entity var4 = var1.j();
					if (var4 instanceof EntityHuman && !this.a((EntityHuman) var4)) {
						return false;
					}

					if (var4 instanceof EntityArrow) {
						EntityArrow var5 = (EntityArrow) var4;
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
		return this.minecraftserver.isPVPEnabled();
	}

	public void c(int var1) {
		if (this.dimensionId == 1 && var1 == 1) {
			this.b((Statistic) AchievementList.D);
			this.o.e((Entity) this);
			this.i = true;
			this.playerConncetion.sendPacket((Packet) (new PacketPlayOutChangeGameState(4, 0.0F)));
		} else {
			if (this.dimensionId == 0 && var1 == 1) {
				this.b((Statistic) AchievementList.C);
				Position var2 = this.minecraftserver.a(var1).m();
				if (var2 != null) {
					this.playerConncetion.a((double) var2.getX(), (double) var2.getY(), (double) var2.getZ(), 0.0F, 0.0F);
				}

				var1 = 1;
			} else {
				this.b((Statistic) AchievementList.y);
			}

			this.minecraftserver.getPlayerList().a(this, var1);
			this.bN = -1;
			this.bK = -1.0F;
			this.bL = -1;
		}

	}

	public boolean a(EntityPlayer var1) {
		return var1.v() ? this.C() == this : (this.v() ? false : super.a(var1));
	}

	private void a(TileEntity var1) {
		if (var1 != null) {
			Packet var2 = var1.getUpdatePacket();
			if (var2 != null) {
				this.playerConncetion.sendPacket(var2);
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
			PacketPlayOutUseBed var3 = new PacketPlayOutUseBed(this, var1);
			this.u().s().a((Entity) this, (Packet) var3);
			this.playerConncetion.a(this.locationX, this.locationY, this.locationZ, this.yaw, this.pitch);
			this.playerConncetion.sendPacket((Packet) var3);
		}

		return var2;
	}

	public void a(boolean var1, boolean var2, boolean var3) {
		if (this.bI()) {
			this.u().s().b(this, new PacketPlayOutAnimation(this, 2));
		}

		super.a(var1, var2, var3);
		if (this.playerConncetion != null) {
			this.playerConncetion.a(this.locationX, this.locationY, this.locationZ, this.yaw, this.pitch);
		}

	}

	public void a(Entity var1) {
		Entity var2 = this.m;
		super.a(var1);
		if (var1 != var2) {
			this.playerConncetion.sendPacket((Packet) (new PacketPlayOutAttachEntity(0, this, this.m)));
			this.playerConncetion.a(this.locationX, this.locationY, this.locationZ, this.yaw, this.pitch);
		}

	}

	protected void a(double var1, boolean var3, Block var4, Position var5) {
	}

	public void a(double var1, boolean var3) {
		int var4 = DataTypesConverter.toFixedPointInt(this.locationX);
		int var5 = DataTypesConverter.toFixedPointInt(this.locationY - 0.20000000298023224D);
		int var6 = DataTypesConverter.toFixedPointInt(this.locationZ);
		Position var7 = new Position(var4, var5, var6);
		Block var8 = this.o.p(var7).getBlock();
		if (var8.r() == Material.AIR) {
			Block var9 = this.o.p(var7.b()).getBlock();
			if (var9 instanceof BlockFence || var9 instanceof BlockCobbleWall || var9 instanceof BlockFenceGate) {
				var7 = var7.b();
				var8 = this.o.p(var7).getBlock();
			}
		}

		super.a(var1, var3, var8, var7);
	}

	public void a(TileEntitySign var1) {
		var1.a((EntityHuman) this);
		this.playerConncetion.sendPacket((Packet) (new PacketPlayOutSignEditorOpen(var1.v())));
	}

	private void cr() {
		this.bT = this.bT % 100 + 1;
	}

	public void a(vv var1) {
		this.cr();
		this.playerConncetion.sendPacket((Packet) (new PacketPlayOutOpenWindow(this.bT, var1.k(), var1.e_())));
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
				this.playerConncetion.sendPacket((Packet) (new PacketPlayOutChatMessage(new ChatMessage("container.isLocked", new Object[] { var1.e_() }), (byte) 2)));
				this.playerConncetion.sendPacket((Packet) (new PacketPlayOutSoundEffect("random.door_close", this.locationX, this.locationY, this.locationZ, 1.0F, 1.0F)));
				return;
			}
		}

		this.cr();
		if (var1 instanceof vv) {
			this.playerConncetion.sendPacket((Packet) (new PacketPlayOutOpenWindow(this.bT, ((vv) var1).k(), var1.e_(), var1.n_())));
			this.activeContainer = ((vv) var1).a(this.playerInventory, this);
		} else {
			this.playerConncetion.sendPacket((Packet) (new PacketPlayOutOpenWindow(this.bT, "minecraft:container", var1.e_(), var1.n_())));
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
		IChatBaseComponent var3 = var1.e_();
		this.playerConncetion.sendPacket((Packet) (new PacketPlayOutOpenWindow(this.bT, "minecraft:villager", var3, var2.n_())));
		aqd var4 = var1.b_(this);
		if (var4 != null) {
			PacketDataSerializer var5 = new PacketDataSerializer(Unpooled.buffer());
			var5.writeInt(this.bT);
			var4.a(var5);
			this.playerConncetion.sendPacket((Packet) (new PacketPlayOutPluginMessage("MC|TrList", var5)));
		}

	}

	public void a(EntityHorse var1, IInventory var2) {
		if (this.activeContainer != this.defaultContainer) {
			this.n();
		}

		this.cr();
		this.playerConncetion.sendPacket((Packet) (new PacketPlayOutOpenWindow(this.bT, "EntityHorse", var2.e_(), var2.n_(), var1.getId())));
		this.activeContainer = new aiy(this.playerInventory, var2, var1, this);
		this.activeContainer.d = this.bT;
		this.activeContainer.a((ICrafting) this);
	}

	public void a(ItemStack var1) {
		Item var2 = var1.getItem();
		if (var2 == Items.WRITTEN_BOK) {
			this.playerConncetion.sendPacket((Packet) (new PacketPlayOutPluginMessage("MC|BOpen", new PacketDataSerializer(Unpooled.buffer()))));
		}

	}

	public void a(Container var1, int var2, ItemStack var3) {
		if (!(var1.a(var2) instanceof ajj)) {
			if (!this.g) {
				this.playerConncetion.sendPacket((Packet) (new PacketPlayOutSetSlot(var1.d, var2, var3)));
			}
		}
	}

	public void a(Container var1) {
		this.a(var1, var1.a());
	}

	public void a(Container var1, List var2) {
		this.playerConncetion.sendPacket((Packet) (new PacketPlayOutWindowItems(var1.d, var2)));
		this.playerConncetion.sendPacket((Packet) (new PacketPlayOutSetSlot(-1, -1, this.playerInventory.p())));
	}

	public void a(Container var1, int var2, int var3) {
		this.playerConncetion.sendPacket((Packet) (new PacketPlayOutWindowProperty(var1.d, var2, var3)));
	}

	public void a(Container var1, IInventory var2) {
		for (int var3 = 0; var3 < var2.g(); ++var3) {
			this.playerConncetion.sendPacket((Packet) (new PacketPlayOutWindowProperty(var1.d, var3, var2.a_(var3))));
		}

	}

	public void n() {
		this.playerConncetion.sendPacket((Packet) (new PacketPlayOutCloseWindow(this.activeContainer.d)));
		this.p();
	}

	public void o() {
		if (!this.g) {
			this.playerConncetion.sendPacket((Packet) (new PacketPlayOutSetSlot(-1, -1, this.playerInventory.p())));
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

	public void a(Statistic var1, int var2) {
		if (var1 != null) {
			this.bI.b(this, var1, var2);
			Iterator var3 = this.co().a(var1.getCrteria()).iterator();

			while (var3.hasNext()) {
				ScoreboardObjective var4 = (ScoreboardObjective) var3.next();
				this.co().c(this.d_(), var4).addScore(var2);
			}

			if (this.bI.e()) {
				this.bI.a(this);
			}

		}
	}

	public void a(Statistic var1) {
		if (var1 != null) {
			this.bI.a(this, var1, 0);
			Iterator var2 = this.co().a(var1.getCrteria()).iterator();

			while (var2.hasNext()) {
				ScoreboardObjective var3 = (ScoreboardObjective) var2.next();
				this.co().c(this.d_(), var3).setScore(0);
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

	public void b(IChatBaseComponent var1) {
		this.playerConncetion.sendPacket((Packet) (new PacketPlayOutChatMessage(var1)));
	}

	protected void s() {
		this.playerConncetion.sendPacket((Packet) (new PacketPlayOutEntityStatus(this, (byte) 9)));
		super.s();
	}

	public void a(ItemStack var1, int var2) {
		super.a(var1, var2);
		if (var1 != null && var1.getItem() != null && var1.getItem().e(var1) == ano.b) {
			this.u().s().b(this, new PacketPlayOutAnimation(this, 3));
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
		this.playerConncetion.sendPacket((Packet) (new PacketPlayOutEntityEffect(this.getId(), var1)));
	}

	protected void a(MobEffect var1, boolean var2) {
		super.a(var1, var2);
		this.playerConncetion.sendPacket((Packet) (new PacketPlayOutEntityEffect(this.getId(), var1)));
	}

	protected void b(MobEffect var1) {
		super.b(var1);
		this.playerConncetion.sendPacket((Packet) (new PacketPlayOutRemoveEntityEffect(this.getId(), var1)));
	}

	public void a(double var1, double var3, double var5) {
		this.playerConncetion.a(var1, var3, var5, this.yaw, this.pitch);
	}

	public void b(Entity var1) {
		this.u().s().b(this, new PacketPlayOutAnimation(var1, 4));
	}

	public void c(Entity var1) {
		this.u().s().b(this, new PacketPlayOutAnimation(var1, 5));
	}

	public void t() {
		if (this.playerConncetion != null) {
			this.playerConncetion.sendPacket((Packet) (new PacketPlayOutPlayerAbilities(this.by)));
			this.B();
		}
	}

	public WorldServer u() {
		return (WorldServer) this.o;
	}

	public void a(GameMode var1) {
		this.playerInteractManager.a(var1);
		this.playerConncetion.sendPacket((Packet) (new PacketPlayOutChangeGameState(3, (float) var1.getId())));
		if (var1 == GameMode.SPECTATOR) {
			this.a((Entity) null);
		} else {
			this.e(this);
		}

		this.t();
		this.bO();
	}

	public boolean v() {
		return this.playerInteractManager.getGameMode() == GameMode.SPECTATOR;
	}

	public void sendChatMessage(IChatBaseComponent json) {
		this.playerConncetion.sendPacket(new PacketPlayOutChatMessage(json));
	}

	public boolean a(int var1, String var2) {
		if ("seed".equals(var2) && !this.minecraftserver.isDedicated()) {
			return true;
		} else if (!"tell".equals(var2) && !"help".equals(var2) && !"me".equals(var2) && !"trigger".equals(var2)) {
			if (this.minecraftserver.getPlayerList().g(this.getGameProfile())) {
				sq var3 = (sq) this.minecraftserver.getPlayerList().n().b((Object) this.getGameProfile());
				return var3 != null ? var3.a() >= var1 : this.minecraftserver.getOpPermissionLevel() >= var1;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	public String w() {
		String var1 = this.playerConncetion.a.b().toString();
		var1 = var1.substring(var1.indexOf("/") + 1);
		var1 = var1.substring(0, var1.indexOf(":"));
		return var1;
	}

	public void a(PacketPlayInClientSettings var1) {
		this.locale = var1.getLocale();
		this.bP = var1.getChatFlag();
		this.bQ = var1.isChatColorsEnabled();
		this.getDataWatcher().b(10, Byte.valueOf((byte) var1.getDisplayedSkinParts()));
	}

	public EnumChatFlag y() {
		return this.bP;
	}

	public void a(String var1, String var2) {
		this.playerConncetion.sendPacket((Packet) (new PacketPlayOutResourcePackSend(var1, var2)));
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
			this.playerConncetion.sendPacket((Packet) (new PacketPlayOutDestroyEntities(new int[] { var1.getId() })));
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
			this.playerConncetion.sendPacket((Packet) (new PacketPlayOutCamera(this.bS)));
			this.a(this.bS.locationX, this.bS.locationY, this.bS.locationZ);
		}

	}

	public void f(Entity var1) {
		if (this.playerInteractManager.getGameMode() == GameMode.SPECTATOR) {
			this.e(var1);
		} else {
			super.f(var1);
		}

	}

	public long D() {
		return this.bR;
	}

	public IChatBaseComponent getPlayerListName() {
		return null;
	}

}
