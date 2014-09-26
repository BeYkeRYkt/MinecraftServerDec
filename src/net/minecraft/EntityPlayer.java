package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import net.minecraft.util.com.mojang.authlib.GameProfile;
import net.minecraft.util.io.netty.buffer.Unpooled;

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
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

import pipebukkit.server.entity.PipePlayer;

public class EntityPlayer extends EntityHuman implements ICrafting {

	private String locale = "en_US";
	public PlayerConnection playerConnection;
	public final MinecraftServer minecraftserver;
	public final PlayerInteractManager playerInteractManager;
	public double d;
	public double e;
	public final List f = Lists.newLinkedList();
	private final List bH = Lists.newLinkedList();
	private final StatisticManager statisticManager;
	private float bJ = Float.MIN_VALUE;
	private float lastHealth = -1.0E8F;
	private int lastFoodLevel = -99999999;
	private boolean lastSaturationLevel = true;
	private int lastXpTotal = -99999999;
	private int bO = 60;
	private EnumChatFlag chatFlag;
	private boolean isColorsEnabled = true;
	private long lastActiveTime = System.currentTimeMillis();
	private Entity bS = null;
	private int windowId;
	public boolean updatingSlots;
	public int ping;
	public boolean viewingCredits;

	public EntityPlayer(MinecraftServer var1, WorldServer var2, GameProfile var3, PlayerInteractManager var4) {
		super(var2, var3);
		var4.b = this;
		this.playerInteractManager = var4;
		Position var5 = var2.getSpawnPosition();
		if (!var2.worldProvider.noSkyLight() && var2.getWorldData().getGameMode() != EnumGameMode.ADVENTURE) {
			int var6 = Math.max(5, var1.isSpawnProtectionEnabled() - 6);
			int var7 = MathHelper.toFixedPointInt(var2.getWorldBorder().getDistance((double) var5.getX(), (double) var5.getZ()));
			if (var7 < var6) {
				var6 = var7;
			}

			if (var7 <= 1) {
				var6 = 1;
			}

			var5 = var2.r(var5.a(this.random.nextInt(var6 * 2) - var6, 0, this.random.nextInt(var6 * 2) - var6));
		}

		this.minecraftserver = var1;
		this.statisticManager = var1.getPlayerList().getPLayerStatistic((EntityHuman) this);
		this.S = 0.0F;
		this.a(var5, 0.0F, 0.0F);

		while (!var2.getCubes((Entity) this, this.getBoundingBox()).isEmpty() && this.locationY < 255.0D) {
			this.b(this.locationX, this.locationY + 1.0D, this.locationZ);
		}

	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		if (var1.isTagAssignableFrom("playerGameType", 99)) {
			if (MinecraftServer.getInstance().av()) {
				this.playerInteractManager.setGameMode(MinecraftServer.getInstance().getServerGameMode());
			} else {
				this.playerInteractManager.setGameMode(EnumGameMode.getById(var1.getInt("playerGameType")));
			}
		}

	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.put("playerGameType", this.playerInteractManager.getGameMode().getId());
	}

	public void a(int var1) {
		super.a(var1);
		this.lastXpTotal = -1;
	}

	public void b(int var1) {
		super.b(var1);
		this.lastXpTotal = -1;
	}

	public void f_() {
		this.activeContainer.addSlotListener((ICrafting) this);
	}

	public void g_() {
		super.g_();
		this.playerConnection.sendPacket((Packet) (new PacketPlayOutCombatEvent(this.br(), CombatEvent.ENTER_COMBAT)));
	}

	public void j() {
		super.j();
		this.playerConnection.sendPacket((Packet) (new PacketPlayOutCombatEvent(this.br(), CombatEvent.END_COMBAT)));
	}

	public void doTick() {
		this.playerInteractManager.a();
		--this.bO;
		if (this.noDamageTicks > 0) {
			--this.noDamageTicks;
		}

		this.activeContainer.b();
		if (!this.world.isStatic && !this.activeContainer.isContainerValid((EntityHuman) this)) {
			this.closeWindow();
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

			this.playerConnection.sendPacket((Packet) (new PacketPlayOutDestroyEntities(var2)));
		}

		if (!this.f.isEmpty()) {
			ArrayList var6 = Lists.newArrayList();
			Iterator var8 = this.f.iterator();
			ArrayList var9 = Lists.newArrayList();

			Chunk var5;
			while (var8.hasNext() && var6.size() < 10) {
				ChunkCoordIntPair var10 = (ChunkCoordIntPair) var8.next();
				if (var10 != null) {
					if (this.world.isLoaded(new Position(var10.chunkX << 4, 0, var10.chunkZ << 4))) {
						var5 = this.world.a(var10.chunkX, var10.chunkZ);
						if (var5.i()) {
							var6.add(var5);
							var9.addAll(((WorldServer) this.world).a(var10.chunkX * 16, 0, var10.chunkZ * 16, var10.chunkX * 16 + 16, 256, var10.chunkZ * 16 + 16));
							var8.remove();
						}
					}
				} else {
					var8.remove();
				}
			}

			if (!var6.isEmpty()) {
				if (var6.size() == 1) {
					this.playerConnection.sendPacket((Packet) (new PacketPlayOutChunkData((Chunk) var6.get(0), true, '\uffff')));
				} else {
					this.playerConnection.sendPacket((Packet) (new PacketPlayOutMapChunkBulk(var6)));
				}

				Iterator var11 = var9.iterator();

				while (var11.hasNext()) {
					TileEntity var12 = (TileEntity) var11.next();
					this.a(var12);
				}

				var11 = var6.iterator();

				while (var11.hasNext()) {
					var5 = (Chunk) var11.next();
					this.getWorldServer().getEntityTracker().a(this, var5);
				}
			}
		}

		Entity var7 = this.C();
		if (var7 != this) {
			if (!var7.isAlive()) {
				this.e(this);
			} else {
				this.setLocation(var7.locationX, var7.locationY, var7.locationZ, var7.yaw, var7.pitch);
				this.minecraftserver.getPlayerList().d(this);
				if (this.aw()) {
					this.e(this);
				}
			}
		}

	}

	public void doTickByPacket() {
		try {
			super.doTick();

			for (int i = 0; i < this.playerInventory.getSize(); ++i) {
				ItemStack itemStack = this.playerInventory.getItem(i);
				if (itemStack != null && itemStack.getItem().f()) {
					Packet var8 = ((ItemMap) itemStack.getItem()).c(itemStack, this.world, this);
					if (var8 != null) {
						this.playerConnection.sendPacket(var8);
					}
				}
			}

			if (this.getHealth() != this.lastHealth || this.lastFoodLevel != this.fooddata.getFoodLevel() || this.fooddata.getSaturationLevel() == 0.0F != this.lastSaturationLevel) {
				this.playerConnection.sendPacket(new PacketPlayOutUpdateHealth(this.getHealth(), this.fooddata.getFoodLevel(), this.fooddata.getSaturationLevel()));
				this.lastHealth = this.getHealth();
				this.lastFoodLevel = this.fooddata.getFoodLevel();
				this.lastSaturationLevel = this.fooddata.getSaturationLevel() == 0.0F;
			}

			if (this.getHealth() + this.bM() != this.bJ) {
				this.bJ = this.getHealth() + this.bM();
				Collection var5 = this.co().a(IScoreboardCriteria.health);
				Iterator var7 = var5.iterator();

				while (var7.hasNext()) {
					ScoreboardObjective var9 = (ScoreboardObjective) var7.next();
					this.co().c(this.getName(), var9).updateForList(Arrays.asList(new EntityHuman[] { this }));
				}
			}

			if (this.xpTotal != this.lastXpTotal) {
				this.lastXpTotal = this.xpTotal;
				this.playerConnection.sendPacket(new PacketPlayOutSetExpirience(this.xp, this.xpTotal, this.xpLevel));
			}

			if (this.ticksLived % 20 * 5 == 0 && !this.getStatisticManager().a(AchievementList.L)) {
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
		BiomeBase var1 = this.world.b(new Position(MathHelper.toFixedPointInt(this.locationX), 0, MathHelper.toFixedPointInt(this.locationZ)));
		String var2 = var1.ah;
		AchievmentSet var3 = (AchievmentSet) this.getStatisticManager().b((Statistic) AchievementList.L);
		if (var3 == null) {
			var3 = (AchievmentSet) this.getStatisticManager().a(AchievementList.L, new AchievmentSet());
		}

		var3.add(var2);
		if (this.getStatisticManager().b(AchievementList.L) && var3.size() >= BiomeBase.n.size()) {
			HashSet var4 = Sets.newHashSet((Iterable) BiomeBase.n);
			Iterator var5 = var3.iterator();

			while (var5.hasNext()) {
				String var6 = (String) var5.next();
				Iterator var7 = var4.iterator();

				while (var7.hasNext()) {
					BiomeBase var8 = (BiomeBase) var7.next();
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

	public void die(DamageSource source) {
		if (this.world.getGameRules().isGameRule("showDeathMessages")) {
			ScoreboardTeamBase var2 = this.bN();
			if (var2 != null && var2.getDeathMessageVisibility() != ScoreboardTeamNameTagVisibility.ALWAYS) {
				if (var2.getDeathMessageVisibility() == ScoreboardTeamNameTagVisibility.HIDE_FOR_OTHER_TEAMS) {
					this.minecraftserver.getPlayerList().a((EntityHuman) this, this.br().getMessage());
				} else if (var2.getDeathMessageVisibility() == ScoreboardTeamNameTagVisibility.HIDE_FOR_OWN_TEAM) {
					this.minecraftserver.getPlayerList().b((EntityHuman) this, this.br().getMessage());
				}
			} else {
				this.minecraftserver.getPlayerList().sendMessage(this.br().getMessage());
			}
		}

		if (!this.world.getGameRules().isGameRule("keepInventory")) {
			this.playerInventory.dropAllItems();
		}

		Collection var6 = this.world.Z().a(IScoreboardCriteria.deathCount);
		Iterator var3 = var6.iterator();

		while (var3.hasNext()) {
			ScoreboardObjective var4 = (ScoreboardObjective) var3.next();
			ScoreboardScore var5 = this.co().c(this.getName(), var4);
			var5.incrementScore();
		}

		EntityLiving killer = this.getKiller();
		if (killer != null) {
			MonsterEggInfo eggInfo = (MonsterEggInfo) EntityTypes.eggInfo.get(Integer.valueOf(EntityTypes.getFixedId(killer)));
			if (eggInfo != null) {
				this.b(eggInfo.e);
			}

			killer.b(this, this.aU);
		}

		this.b(StatisticList.y);
		this.a(StatisticList.h);
		this.br().g();
	}

	public boolean receiveDamage(DamageSource source, float damage) {
		if (this.ignoresDamageType(source)) {
			return false;
		} else {
			boolean isFallDamage = this.minecraftserver.isDedicated() && this.isPvPEnabled() && "fall".equals(source.translationIndex);
			if (!isFallDamage && this.bO > 0 && source != DamageSource.OUT_OF_WORLD) {
				return false;
			} else {
				if (source instanceof EntityDamageSource) {
					Entity damager = source.getDamager();
					if (damager instanceof EntityHuman && !this.canReveiveDamageFrom((EntityHuman) damager)) {
						return false;
					}

					if (damager instanceof EntityArrow) {
						EntityArrow arrow = (EntityArrow) damager;
						if (arrow.shooter instanceof EntityHuman && !this.canReveiveDamageFrom((EntityHuman) arrow.shooter)) {
							return false;
						}
					}
				}

				return super.receiveDamage(source, damage);
			}
		}
	}

	public boolean canReveiveDamageFrom(EntityHuman var1) {
		return !this.isPvPEnabled() ? false : super.canReveiveDamageFrom(var1);
	}

	private boolean isPvPEnabled() {
		return this.minecraftserver.isPVPEnabled();
	}

	public void viewCredits(int dimenstionId) {
		if (this.dimensionId == 1 && dimenstionId == 1) {
			this.b((Statistic) AchievementList.D);
			this.world.e((Entity) this);
			this.viewingCredits = true;
			this.playerConnection.sendPacket(new PacketPlayOutChangeGameState(4, 0.0F));
		} else {
			if (this.dimensionId == 0 && dimenstionId == 1) {
				this.b((Statistic) AchievementList.C);
				Position spawn = this.minecraftserver.getWorldServer(dimenstionId).getDimensionSpawn();
				if (spawn != null) {
					this.playerConnection.movePlayer((double) spawn.getX(), (double) spawn.getY(), (double) spawn.getZ(), 0.0F, 0.0F);
				}

				dimenstionId = 1;
			} else {
				this.b((Statistic) AchievementList.y);
			}

			this.minecraftserver.getPlayerList().a(this, dimenstionId);
			this.lastXpTotal = -1;
			this.lastHealth = -1.0F;
			this.lastFoodLevel = -1;
		}

	}

	public boolean a(EntityPlayer var1) {
		return var1.isSpectator() ? this.C() == this : (this.isSpectator() ? false : super.a(var1));
	}

	private void a(TileEntity var1) {
		if (var1 != null) {
			Packet var2 = var1.getUpdatePacket();
			if (var2 != null) {
				this.playerConnection.sendPacket(var2);
			}
		}

	}

	public void a(Entity var1, int var2) {
		super.a(var1, var2);
		this.activeContainer.b();
	}

	public EnumBedResult a(Position var1) {
		EnumBedResult var2 = super.a(var1);
		if (var2 == EnumBedResult.OK) {
			PacketPlayOutUseBed var3 = new PacketPlayOutUseBed(this, var1);
			this.getWorldServer().getEntityTracker().a((Entity) this, (Packet) var3);
			this.playerConnection.movePlayer(this.locationX, this.locationY, this.locationZ, this.yaw, this.pitch);
			this.playerConnection.sendPacket((Packet) var3);
		}

		return var2;
	}

	public void a(boolean var1, boolean var2, boolean var3) {
		if (this.isSleeping()) {
			this.getWorldServer().getEntityTracker().b(this, new PacketPlayOutAnimation(this, 2));
		}

		super.a(var1, var2, var3);
		if (this.playerConnection != null) {
			this.playerConnection.movePlayer(this.locationX, this.locationY, this.locationZ, this.yaw, this.pitch);
		}

	}

	public void mount(Entity var1) {
		Entity var2 = this.vehicle;
		super.mount(var1);
		if (var1 != var2) {
			this.playerConnection.sendPacket((Packet) (new PacketPlayOutAttachEntity(0, this, this.vehicle)));
			this.playerConnection.movePlayer(this.locationX, this.locationY, this.locationZ, this.yaw, this.pitch);
		}

	}

	protected void a(double var1, boolean var3, Block var4, Position var5) {
	}

	public void a(double var1, boolean var3) {
		int var4 = MathHelper.toFixedPointInt(this.locationX);
		int var5 = MathHelper.toFixedPointInt(this.locationY - 0.20000000298023224D);
		int var6 = MathHelper.toFixedPointInt(this.locationZ);
		Position var7 = new Position(var4, var5, var6);
		Block var8 = this.world.getBlockState(var7).getBlock();
		if (var8.getMaterial() == Material.AIR) {
			Block var9 = this.world.getBlockState(var7.getDown()).getBlock();
			if (var9 instanceof BlockFence || var9 instanceof BlockCobbleWall || var9 instanceof BlockFenceGate) {
				var7 = var7.getDown();
				var8 = this.world.getBlockState(var7).getBlock();
			}
		}

		super.a(var1, var3, var8, var7);
	}

	public void a(TileEntitySign var1) {
		var1.a((EntityHuman) this);
		this.playerConnection.sendPacket((Packet) (new PacketPlayOutSignEditorOpen(var1.getPosition())));
	}

	private void nextWindowId() {
		this.windowId = this.windowId % 100 + 1;
	}

	public void openTypedInventory(IInventoryHasType inventory) {
		this.nextWindowId();
		this.playerConnection.sendPacket(new PacketPlayOutOpenWindow(this.windowId, inventory.getInventoryType(), inventory.getComponentName()));
		this.activeContainer = inventory.getContainer(this.playerInventory, this);
		this.activeContainer.windowId = this.windowId;
		this.activeContainer.addSlotListener((ICrafting) this);
	}

	public void openInventory(IInventory inventory) {
		if (this.activeContainer != this.defaultContainer) {
			this.closeWindow();
		}

		if (inventory instanceof ILockable) {
			ILockable lockable = (ILockable) inventory;
			if (lockable.isLocked() && !this.a(lockable.getLock()) && !this.isSpectator()) {
				this.playerConnection.sendPacket(new PacketPlayOutChatMessage(new ChatMessage("container.isLocked", new Object[] { inventory.getComponentName() }), (byte) 2));
				this.playerConnection.sendPacket(new PacketPlayOutSoundEffect("random.door_close", this.locationX, this.locationY, this.locationZ, 1.0F, 1.0F));
				return;
			}
		}

		this.nextWindowId();
		if (inventory instanceof IInventoryHasType) {
			this.playerConnection.sendPacket(new PacketPlayOutOpenWindow(this.windowId, ((IInventoryHasType) inventory).getInventoryType(), inventory.getComponentName(), inventory.getSize()));
			this.activeContainer = ((IInventoryHasType) inventory).getContainer(this.playerInventory, this);
		} else {
			this.playerConnection.sendPacket(new PacketPlayOutOpenWindow(this.windowId, "minecraft:container", inventory.getComponentName(), inventory.getSize()));
			this.activeContainer = new ContainerChest(this.playerInventory, inventory, this);
		}

		this.activeContainer.windowId = this.windowId;
		this.activeContainer.addSlotListener((ICrafting) this);
	}

	public void openMerchantInventory(IMerchant merchant) {
		this.nextWindowId();
		this.activeContainer = new ContainerMerchant(this.playerInventory, merchant, this.world);
		this.activeContainer.windowId = this.windowId;
		this.activeContainer.addSlotListener((ICrafting) this);
		InventoryMerchant inventory = ((ContainerMerchant) this.activeContainer).e();
		IChatBaseComponent name = merchant.getComponentName();
		this.playerConnection.sendPacket(new PacketPlayOutOpenWindow(this.windowId, "minecraft:villager", name, inventory.getSize()));
		MerchantRecipeList recipes = merchant.getRecipes(this);
		if (recipes != null) {
			PacketDataSerializer serializer = new PacketDataSerializer(Unpooled.buffer());
			serializer.writeInt(this.windowId);
			recipes.writeData(serializer);
			this.playerConnection.sendPacket(new PacketPlayOutPluginMessage("MC|TrList", serializer));
		}

	}

	public void openHorseInventory(EntityHorse horse, IInventory inventory) {
		if (this.activeContainer != this.defaultContainer) {
			this.closeWindow();
		}

		this.nextWindowId();
		this.playerConnection.sendPacket(new PacketPlayOutOpenWindow(this.windowId, "EntityHorse", inventory.getComponentName(), inventory.getSize(), horse.getId()));
		this.activeContainer = new ContainerHorse(this.playerInventory, inventory, horse, this);
		this.activeContainer.windowId = this.windowId;
		this.activeContainer.addSlotListener((ICrafting) this);
	}

	public void openBook(ItemStack book) {
		Item item = book.getItem();
		if (item == Items.WRITTEN_BOOK) {
			this.playerConnection.sendPacket(new PacketPlayOutPluginMessage("MC|BOpen", new PacketDataSerializer(Unpooled.buffer())));
		}

	}

	public void sendContainerItem(Container container, int slot, ItemStack itemStack) {
		if (!(container.getSlot(slot) instanceof ajj)) {
			if (!this.updatingSlots) {
				this.playerConnection.sendPacket(new PacketPlayOutSetSlot(container.windowId, slot, itemStack));
			}
		}
	}

	public void sendContainerItems(Container container) {
		this.sendContainerItems(container, container.getContents());
	}

	public void sendContainerItems(Container container, List<ItemStack> itemStacks) {
		this.playerConnection.sendPacket(new PacketPlayOutWindowItems(container.windowId, itemStacks));
		this.playerConnection.sendPacket(new PacketPlayOutSetSlot(-1, -1, this.playerInventory.getCarried()));
	}

	public void sendContainerProperty(Container container, int property, int value) {
		this.playerConnection.sendPacket(new PacketPlayOutWindowProperty(container.windowId, property, value));
	}

	public void sendContainerProperties(Container container, IInventory inventory) {
		for (int i = 0; i < inventory.getPropertiesCount(); ++i) {
			this.playerConnection.sendPacket(new PacketPlayOutWindowProperty(container.windowId, i, inventory.getProperty(i)));
		}

	}

	public void closeWindow() {
		this.playerConnection.sendPacket(new PacketPlayOutCloseWindow(this.activeContainer.windowId));
		this.removeWindow();
	}

	public void broadcastCarriedItem() {
		if (!this.updatingSlots) {
			this.playerConnection.sendPacket(new PacketPlayOutSetSlot(-1, -1, this.playerInventory.getCarried()));
		}
	}

	public void removeWindow() {
		this.activeContainer.onClose((EntityHuman) this);
		this.activeContainer = this.defaultContainer;
	}

	public void handleSteerVehicle(float var1, float var2, boolean var3, boolean var4) {
		if (this.vehicle != null) {
			if (var1 >= -1.0F && var1 <= 1.0F) {
				this.aX = var1;
			}

			if (var2 >= -1.0F && var2 <= 1.0F) {
				this.aY = var2;
			}

			this.aW = var3;
			this.setSneaking(var4);
		}

	}

	public void a(Statistic var1, int var2) {
		if (var1 != null) {
			this.statisticManager.b(this, var1, var2);
			Iterator var3 = this.co().a(var1.getCrteria()).iterator();

			while (var3.hasNext()) {
				ScoreboardObjective var4 = (ScoreboardObjective) var3.next();
				this.co().c(this.getName(), var4).addScore(var2);
			}

			if (this.statisticManager.e()) {
				this.statisticManager.sendStatistics(this);
			}

		}
	}

	public void a(Statistic var1) {
		if (var1 != null) {
			this.statisticManager.a(this, var1, 0);
			Iterator var2 = this.co().a(var1.getCrteria()).iterator();

			while (var2.hasNext()) {
				ScoreboardObjective var3 = (ScoreboardObjective) var2.next();
				this.co().c(this.getName(), var3).setScore(0);
			}

			if (this.statisticManager.e()) {
				this.statisticManager.sendStatistics(this);
			}

		}
	}

	public void q() {
		if (this.passenger != null) {
			this.passenger.mount((Entity) this);
		}

		if (this.isSleeping) {
			this.a(true, false, false);
		}

	}

	public void r() {
		this.lastHealth = -1.0E8F;
	}

	public void b(IChatBaseComponent var1) {
		this.playerConnection.sendPacket((Packet) (new PacketPlayOutChatMessage(var1)));
	}

	protected void s() {
		this.playerConnection.sendPacket((Packet) (new PacketPlayOutEntityStatus(this, (byte) 9)));
		super.s();
	}

	public void a(ItemStack var1, int var2) {
		super.a(var1, var2);
		if (var1 != null && var1.getItem() != null && var1.getItem().e(var1) == EnumAnimation.EAT) {
			this.getWorldServer().getEntityTracker().b(this, new PacketPlayOutAnimation(this, 3));
		}

	}

	public void a(EntityHuman var1, boolean var2) {
		super.a(var1, var2);
		this.lastXpTotal = -1;
		this.lastHealth = -1.0F;
		this.lastFoodLevel = -1;
		this.bH.addAll(((EntityPlayer) var1).bH);
	}

	protected void a(MobEffect var1) {
		super.a(var1);
		this.playerConnection.sendPacket((Packet) (new PacketPlayOutEntityEffect(this.getId(), var1)));
	}

	protected void a(MobEffect var1, boolean var2) {
		super.a(var1, var2);
		this.playerConnection.sendPacket((Packet) (new PacketPlayOutEntityEffect(this.getId(), var1)));
	}

	protected void b(MobEffect var1) {
		super.b(var1);
		this.playerConnection.sendPacket((Packet) (new PacketPlayOutRemoveEntityEffect(this.getId(), var1)));
	}

	public void updatePosition(double var1, double var3, double var5) {
		this.playerConnection.movePlayer(var1, var3, var5, this.yaw, this.pitch);
	}

	public void b(Entity var1) {
		this.getWorldServer().getEntityTracker().b(this, new PacketPlayOutAnimation(var1, 4));
	}

	public void c(Entity var1) {
		this.getWorldServer().getEntityTracker().b(this, new PacketPlayOutAnimation(var1, 5));
	}

	public void t() {
		if (this.playerConnection != null) {
			this.playerConnection.sendPacket((Packet) (new PacketPlayOutPlayerAbilities(this.playerProperties)));
			this.B();
		}
	}

	public WorldServer getWorldServer() {
		return this.world;
	}

	public void setGameMode(EnumGameMode mode) {
		@SuppressWarnings("deprecation")
		PlayerGameModeChangeEvent gameModeChangeEvent = new PlayerGameModeChangeEvent(getBukkitEntity(Player.class), GameMode.getByValue(mode.getId()));
		Bukkit.getPluginManager().callEvent(gameModeChangeEvent);
		if (gameModeChangeEvent.isCancelled()) {
			return;
		}
		this.playerInteractManager.setGameMode(mode);
		this.playerConnection.sendPacket(new PacketPlayOutChangeGameState(3, mode.getId()));
		if (mode == EnumGameMode.SPECTATOR) {
			this.mount((Entity) null);
		} else {
			this.e(this);
		}

		this.t();
		this.bO();
	}

	public boolean isSpectator() {
		return this.playerInteractManager.getGameMode() == EnumGameMode.SPECTATOR;
	}

	public void sendChatMessage(IChatBaseComponent json) {
		this.playerConnection.sendPacket(new PacketPlayOutChatMessage(json));
	}

	public boolean canExecuteCommand(int permLevel, String command) {
		if ("seed".equals(command) && !this.minecraftserver.isDedicated()) {
			return true;
		} else if (!"tell".equals(command) && !"help".equals(command) && !"me".equals(command) && !"trigger".equals(command)) {
			if (this.minecraftserver.getPlayerList().isOp(this.getGameProfile())) {
				OpListEntry var3 = (OpListEntry) this.minecraftserver.getPlayerList().getOpList().get(this.getGameProfile());
				return var3 != null ? var3.getPermissionLevel() >= permLevel : this.minecraftserver.getOpPermissionLevel() >= permLevel;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	public String w() {
		String var1 = this.playerConnection.networkManager.getAddress().toString();
		var1 = var1.substring(var1.indexOf("/") + 1);
		var1 = var1.substring(0, var1.indexOf(":"));
		return var1;
	}

	public void setClientSettings(PacketPlayInClientSettings settings) {
		this.locale = settings.getLocale();
		this.chatFlag = settings.getChatFlag();
		this.isColorsEnabled = settings.isChatColorsEnabled();
		this.getDataWatcher().b(10, Byte.valueOf((byte) settings.getDisplayedSkinParts()));
	}

	public EnumChatFlag getChatFlag() {
		return this.chatFlag;
	}

	public void a(String var1, String var2) {
		this.playerConnection.sendPacket((Packet) (new PacketPlayOutResourcePackSend(var1, var2)));
	}

	public Position getEntityPosition() {
		return new Position(this.locationX, this.locationY + 0.5D, this.locationZ);
	}

	public void updateLastActiveTime() {
		this.lastActiveTime = MinecraftServer.getCurrentMillis();
	}

	public StatisticManager getStatisticManager() {
		return this.statisticManager;
	}

	public void d(Entity var1) {
		if (var1 instanceof EntityHuman) {
			this.playerConnection.sendPacket((Packet) (new PacketPlayOutDestroyEntities(new int[] { var1.getId() })));
		} else {
			this.bH.add(Integer.valueOf(var1.getId()));
		}

	}

	protected void B() {
		if (this.isSpectator()) {
			this.bi();
			this.e(true);
		} else {
			super.B();
		}

		this.getWorldServer().getEntityTracker().a(this);
	}

	public Entity C() {
		return (Entity) (this.bS == null ? this : this.bS);
	}

	public void e(Entity var1) {
		Entity var2 = this.C();
		this.bS = (Entity) (var1 == null ? this : var1);
		if (var2 != this.bS) {
			this.playerConnection.sendPacket((Packet) (new PacketPlayOutCamera(this.bS)));
			this.updatePosition(this.bS.locationX, this.bS.locationY, this.bS.locationZ);
		}

	}

	public void attackEntity(Entity entity) {
		if (this.playerInteractManager.getGameMode() == EnumGameMode.SPECTATOR) {
			this.e(entity);
		} else {
			super.attackEntity(entity);
		}

	}

	public long getLastActiveTime() {
		return this.lastActiveTime;
	}

	public IChatBaseComponent getPlayerListName() {
		return null;
	}

	private Player bukkitplayer;
	@SuppressWarnings("unchecked")
	public <T extends org.bukkit.entity.Entity> T getBukkitEntity(Class<T> returnType) {
		if (bukkitplayer == null) {
			bukkitplayer = new PipePlayer(this);
		}
		return (T) bukkitplayer;
	}

}
