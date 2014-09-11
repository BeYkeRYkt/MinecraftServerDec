package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

import net.minecraft.PacketPlayInClientStatus.ClientStatusAction;
import net.minecraft.PacketPlayInPlayerDigging.PlayerDiggingAction;
import net.minecraft.PacketPlayInUseEntity.UseEntityAction;
import net.minecraft.server.MinecraftServer;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlayerConnection implements PlayInPacketListener, PacketTickable {

	private static final Logger logger = LogManager.getLogger();

	public final NetworkManager networkManager;
	private final MinecraftServer minecraftserver;
	public EntityPlayer player;
	private int currentTick;
	private int lastMoveTick;
	private int flyTime;
	private int packetKeepAliveMilliseconds;
	private long lastKeepAliveMilliseconds;
	private long lastKeepAliveTick;
	private int chatThrottle;
	private int creativeItemDropThrottle;
	private IntHashMap intHashMap = new IntHashMap();
	private double lastX;
	private double lastY;
	private double lastZ;
	private boolean checkMovement = true;

	public PlayerConnection(MinecraftServer minecraftserver, NetworkManager networkManager, EntityPlayer player) {
		this.minecraftserver = minecraftserver;
		this.networkManager = networkManager;
		networkManager.setPacketListener((PacketListener) this);
		this.player = player;
		player.playerConncetion = this;
	}

	public void doTick() {
		++this.currentTick;
		this.minecraftserver.profiler.a("keepAlive");
		if ((long) this.currentTick - this.lastKeepAliveTick > 40L) {
			this.lastKeepAliveTick = (long) this.currentTick;
			this.lastKeepAliveMilliseconds = this.getCurrentMillis();
			this.packetKeepAliveMilliseconds = (int) this.lastKeepAliveMilliseconds;
			this.sendPacket(new PacketPlayOutKeepAlive(this.packetKeepAliveMilliseconds));
		}

		this.minecraftserver.profiler.b();
		if (this.chatThrottle > 0) {
			--this.chatThrottle;
		}

		if (this.creativeItemDropThrottle > 0) {
			--this.creativeItemDropThrottle;
		}

		if (this.player.getLastActiveTime() > 0L && this.minecraftserver.getIdleTimeOut() > 0 && MinecraftServer.getCurrentMillis() - this.player.getLastActiveTime() > (long) (this.minecraftserver.getIdleTimeOut() * 1000 * 60)) {
			this.disconnect("You have been idle for too long!");
		}
	}

	public NetworkManager getNetworkManager() {
		return this.networkManager;
	}

	public void disconnect(String message) {
		ChatComponentText componenetMessage = new ChatComponentText(message);
		this.networkManager.handleSendPacket(new PacketPlayOutDisconnect(componenetMessage), new PlayerConnectionFuture(this, componenetMessage));
		this.networkManager.disableAutoRead();
		Futures.getUnchecked(this.minecraftserver.scheduleSyncTask(new NetworkManagerCloseRunnable(this)));
	}

	public void handle(PacketPlayInSteerVehicle packet) {
		PacketAsyncToSyncThrower.schedulePacketHandleIfNeeded(packet, this, this.player.getWorldServer());
		this.player.handleSteerVehicle(packet.getSidewaysSpeed(), packet.getForwardSpeed(), packet.isJump(), packet.isUnmount());
	}

	public void handle(PacketPlayInPlayer packet) {
		PacketAsyncToSyncThrower.schedulePacketHandleIfNeeded(packet, this, this.player.getWorldServer());
		WorldServer worldServer = this.minecraftserver.getWorldServer(this.player.dimensionId);
		if (!this.player.viewingCredits) {
			double playerLocX = this.player.locationX;
			double playerLocY = this.player.locationY;
			double playerLocZ = this.player.locationZ;
			double distance = 0.0D;
			double changeX = packet.getX() - this.lastX;
			double changeY = packet.getFeetY() - this.lastY;
			double changeZ = packet.getZ() - this.lastZ;
			if (packet.hasPosition()) {
				distance = changeX * changeX + changeY * changeY + changeZ * changeZ;
				if (!this.checkMovement && distance < 0.25D) {
					this.checkMovement = true;
				}
			}

			if (this.checkMovement) {
				this.lastMoveTick = this.currentTick;
				double locX;
				double locY;
				double locZ;
				if (this.player.vehicle != null) {
					float yaw = this.player.yaw;
					float pitch = this.player.pitch;
					this.player.vehicle.al();
					locX = this.player.locationX;
					locY = this.player.locationY;
					locZ = this.player.locationZ;
					if (packet.hasLook()) {
						yaw = packet.getYaw();
						pitch = packet.getPitch();
					}

					this.player.onGround = packet.isOnGround();
					this.player.l();
					this.player.setLocation(locX, locY, locZ, yaw, pitch);
					if (this.player.vehicle != null) {
						this.player.vehicle.al();
					}

					this.minecraftserver.getPlayerList().d(this.player);
					if (this.player.vehicle != null) {
						if (distance > 4.0D) {
							Entity vehicle = this.player.vehicle;
							this.player.playerConncetion.sendPacket(new PacketPlayOutEntityTeleport(vehicle));
							this.movePlayer(this.player.locationX, this.player.locationY, this.player.locationZ, this.player.yaw, this.player.pitch);
						}

						this.player.vehicle.ai = true;
					}

					if (this.checkMovement) {
						this.lastX = this.player.locationX;
						this.lastY = this.player.locationY;
						this.lastZ = this.player.locationZ;
					}

					worldServer.playerJoinedWorld(this.player);
					return;
				}

				if (this.player.isSleeping()) {
					this.player.l();
					this.player.setLocation(this.lastX, this.lastY, this.lastZ, this.player.yaw, this.player.pitch);
					worldServer.playerJoinedWorld(this.player);
					return;
				}

				double y = this.player.locationY;
				this.lastX = this.player.locationX;
				this.lastY = this.player.locationY;
				this.lastZ = this.player.locationZ;
				locX = this.player.locationX;
				locY = this.player.locationY;
				locZ = this.player.locationZ;
				float yaw = this.player.yaw;
				float pitch = this.player.pitch;
				if (packet.hasPosition() && packet.getFeetY() == -999.0D) {
					packet.setHasPosition(false);
				}

				if (packet.hasPosition()) {
					locX = packet.getX();
					locY = packet.getFeetY();
					locZ = packet.getZ();
					if (Math.abs(packet.getX()) > 3.0E7D || Math.abs(packet.getZ()) > 3.0E7D) {
						this.disconnect("Illegal position");
						return;
					}
				}

				if (packet.hasLook()) {
					yaw = packet.getYaw();
					pitch = packet.getPitch();
				}

				this.player.l();
				this.player.setLocation(this.lastX, this.lastY, this.lastZ, yaw, pitch);
				if (!this.checkMovement) {
					return;
				}

				double diffX = locX - this.player.locationX;
				double diffY = locY - this.player.locationY;
				double diffZ = locZ - this.player.locationZ;
				double realDiffX = Math.min(Math.abs(diffX), Math.abs(this.player.motionX));
				double realDiifY = Math.min(Math.abs(diffY), Math.abs(this.player.motionY));
				double realDiffZ = Math.min(Math.abs(diffZ), Math.abs(this.player.motionZ));
				double realDistance = realDiffX * realDiffX + realDiifY * realDiifY + realDiffZ * realDiffZ;
				if (realDistance > 100.0D && (!this.minecraftserver.isSinglePlayer() || !this.minecraftserver.getSinglePlayerName().equals(this.player.getName()))) {
					logger.warn(this.player.getName() + " moved too quickly! " + diffX + "," + diffY + "," + diffZ + " (" + realDiffX + ", " + realDiifY + ", " + realDiffZ + ")");
					this.movePlayer(this.lastX, this.lastY, this.lastZ, this.player.yaw, this.player.pitch);
					return;
				}

				float shrinkSize = 0.0625F;
				boolean noCollisionDetected = worldServer.getCubes(this.player, this.player.getBoundingBox().shrink(shrinkSize, shrinkSize, shrinkSize)).isEmpty();
				if (this.player.onGround && !packet.isOnGround() && diffY > 0.0D) {
					this.player.jump();
				}

				this.player.move(diffX, diffY, diffZ);
				this.player.onGround = packet.isOnGround();
				double prevDiffY = diffY;
				diffX = locX - this.player.locationX;
				diffY = locY - this.player.locationY;
				if (diffY > -0.5D || diffY < 0.5D) {
					diffY = 0.0D;
				}
				diffZ = locZ - this.player.locationZ;
				realDistance = diffX * diffX + diffY * diffY + diffZ * diffZ;
				boolean movedWrongly = false;
				if (realDistance > 0.0625D && !this.player.isSleeping() && !this.player.playerInteractManager.isCreative()) {
					movedWrongly = true;
					logger.warn(this.player.getName() + " moved wrongly!");
				}

				this.player.setLocation(locX, locY, locZ, yaw, pitch);
				this.player.k(this.player.locationX - playerLocX, this.player.locationY - playerLocY, this.player.locationZ - playerLocZ);
				if (!this.player.T) {
					if (noCollisionDetected && (movedWrongly || !worldServer.getCubes(this.player, this.player.getBoundingBox().shrink(shrinkSize, shrinkSize, shrinkSize)).isEmpty()) && !this.player.isSleeping()) {
						this.movePlayer(this.lastX, this.lastY, this.lastZ, yaw, pitch);
						return;
					}
				}

				AxisAlignedBB axisAligned = this.player.getBoundingBox().grow(shrinkSize, shrinkSize, shrinkSize).a(0.0D, -0.55D, 0.0D);
				if (!this.minecraftserver.isFlightAllowed() && !this.player.playerProperties.mayfly && !worldServer.isOnGround(axisAligned)) {
					if (prevDiffY >= -0.03125D) {
						++this.flyTime;
						if (this.flyTime > 80) {
							logger.warn(this.player.getName() + " was kicked for floating too long!");
							this.disconnect("Flying is not enabled on this server");
							return;
						}
					}
				} else {
					this.flyTime = 0;
				}

				this.player.onGround = packet.isOnGround();
				this.minecraftserver.getPlayerList().d(this.player);
				this.player.a(this.player.locationY - y, packet.isOnGround());
			} else if (this.currentTick - this.lastMoveTick > 20) {
				this.movePlayer(this.lastX, this.lastY, this.lastZ, this.player.yaw, this.player.pitch);
			}

		}
	}

	public void movePlayer(double x, double y, double z, float yaw, float pitch) {
		this.movePlayer(x, y, z, yaw, pitch, new HashSet<PositionFlag>());
	}

	public void movePlayer(double x, double y, double z, float yaw, float pitch, Set<PositionFlag> flags) {
		this.checkMovement = false;
		this.lastX = x;
		this.lastY = y;
		this.lastZ = z;
		if (flags.contains(PositionFlag.X)) {
			this.lastX += this.player.locationX;
		}

		if (flags.contains(PositionFlag.Y)) {
			this.lastY += this.player.locationY;
		}

		if (flags.contains(PositionFlag.Z)) {
			this.lastZ += this.player.locationZ;
		}

		float newYaw = yaw;
		float newPitch = pitch;
		if (flags.contains(PositionFlag.PITCH)) {
			newYaw = yaw + this.player.yaw;
		}

		if (flags.contains(PositionFlag.YAW)) {
			newPitch = pitch + this.player.pitch;
		}

		this.player.setLocation(this.lastX, this.lastY, this.lastZ, newYaw, newPitch);
		this.player.playerConncetion.sendPacket(new PacketPlayOutPlayerPositionAndLook(x, y, z, yaw, pitch, flags));
	}

	private long getCurrentMillis() {
		return System.nanoTime() / 1000000L;
	}

	public void handle(PacketPlayInPlayerDigging packet) {
		PacketAsyncToSyncThrower.schedulePacketHandleIfNeeded(packet, this, this.player.getWorldServer());
		WorldServer worldServer = this.minecraftserver.getWorldServer(this.player.dimensionId);
		Position position = packet.getPosition();
		this.player.updateLastActiveTime();
		switch (packet.getAction()) {
			case DROP_ITEM:
				if (!this.player.isSpectator()) {
					this.player.dropItemInHand(false);
				}

				return;
			case DROP_ALL_ITEMS:
				if (!this.player.isSpectator()) {
					this.player.dropItemInHand(true);
				}

				return;
			case RELEASE_USE_ITEM:
				this.player.bT();
				return;
			case START_DESTROY_BLOCK:
			case ABORT_DESTROY_BLOCK:
			case STOP_DESTROY_BLOCK:
				double diffX = this.player.locationX - ((double) position.getX() + 0.5D);
				double diffY = this.player.locationY - ((double) position.getY() + 0.5D) + 1.5D;
				double diffZ = this.player.locationZ - ((double) position.getZ() + 0.5D);
				double distanceSquared = diffX * diffX + diffY * diffY + diffZ * diffZ;
				if (distanceSquared > 36.0D) {
					return;
				} else if (position.getY() >= this.minecraftserver.getMaxBuildHeight()) {
					return;
				} else {
					if (packet.getAction() == PlayerDiggingAction.START_DESTROY_BLOCK) {
						if (!this.minecraftserver.isProtected((World) worldServer, position, (EntityHuman) this.player) && worldServer.getWorldBorder().isInside(position)) {
							this.player.playerInteractManager.a(position, packet.getFace());
						} else {
							this.player.playerConncetion.sendPacket(new PacketPlayOutBlockChange(worldServer, position));
						}
					} else {
						if (packet.getAction() == PlayerDiggingAction.STOP_DESTROY_BLOCK) {
							this.player.playerInteractManager.a(position);
						} else if (packet.getAction() == PlayerDiggingAction.ABORT_DESTROY_BLOCK) {
							this.player.playerInteractManager.e();
						}

						if (worldServer.getBlockState(position).getBlock().getMaterial() != Material.AIR) {
							this.player.playerConncetion.sendPacket(new PacketPlayOutBlockChange(worldServer, position));
						}
					}

					return;
				}
			default:
				throw new IllegalArgumentException("Invalid player action");
		}
	}

	public void handle(PacketPlayInBlockPlace packet) {
		PacketAsyncToSyncThrower.schedulePacketHandleIfNeeded(packet, this, this.player.getWorldServer());
		WorldServer worldServer = this.minecraftserver.getWorldServer(this.player.dimensionId);
		ItemStack packetItemStack = this.player.playerInventory.getItemInHand();
		boolean update = false;
		Position position = packet.getPosition();
		BlockFace blockFace = BlockFace.getById(packet.getDirection());
		this.player.updateLastActiveTime();
		if (packet.getDirection() == 255) {
			if (packetItemStack == null) {
				return;
			}

			this.player.playerInteractManager.useItem(this.player, worldServer, packetItemStack);
		} else if (position.getY() >= this.minecraftserver.getMaxBuildHeight() - 1 && (blockFace == BlockFace.UP || position.getY() >= this.minecraftserver.getMaxBuildHeight())) {
			ChatMessage chatMessage = new ChatMessage("build.tooHigh", new Object[] { Integer.valueOf(this.minecraftserver.getMaxBuildHeight()) });
			chatMessage.getChatModifier().setColor(EnumChatFormat.RED);
			this.player.playerConncetion.sendPacket(new PacketPlayOutChatMessage(chatMessage));
			update = true;
		} else {
			if (this.checkMovement && this.player.getDistanceSquared(position.getX() + 0.5D, position.getY() + 0.5D, position.getZ() + 0.5D) < 64.0D && !this.minecraftserver.isProtected(worldServer, position, this.player) && worldServer.getWorldBorder().isInside(position)) {
				this.player.playerInteractManager.interact(this.player, worldServer, packetItemStack, position, blockFace, packet.getCursorX(), packet.getCursorY(), packet.getCursorZ());
			}

			update = true;
		}

		if (update) {
			this.player.playerConncetion.sendPacket(new PacketPlayOutBlockChange(worldServer, position));
			this.player.playerConncetion.sendPacket(new PacketPlayOutBlockChange(worldServer, position.a(blockFace)));
		}

		packetItemStack = this.player.playerInventory.getItemInHand();
		if (packetItemStack != null && packetItemStack.amount == 0) {
			this.player.playerInventory.contents[this.player.playerInventory.itemInHandIndex] = null;
			packetItemStack = null;
		}

		if (packetItemStack == null || packetItemStack.l() == 0) {
			this.player.g = true;
			this.player.playerInventory.contents[this.player.playerInventory.itemInHandIndex] = ItemStack.b(this.player.playerInventory.contents[this.player.playerInventory.itemInHandIndex]);
			Slot var8 = this.player.activeContainer.a((IInventory) this.player.playerInventory, this.player.playerInventory.itemInHandIndex);
			this.player.activeContainer.b();
			this.player.g = false;
			if (!ItemStack.matches(this.player.playerInventory.getItemInHand(), packet.getItem())) {
				this.sendPacket(new PacketPlayOutSetSlot(this.player.activeContainer.windowId, var8.index, this.player.playerInventory.getItemInHand()));
			}
		}

	}

	public void handle(PacketPlayInSpectate packet) {
		PacketAsyncToSyncThrower.schedulePacketHandleIfNeeded(packet, this, this.player.getWorldServer());
		if (this.player.isSpectator()) {
			Entity entity = null;

			for (WorldServer worldServer : minecraftserver.worlds) {
				if (worldServer != null) {
					entity = packet.getEntity(worldServer);
					if (entity != null) {
						break;
					}
				}
			}

			if (entity != null) {
				this.player.e(this.player);
				this.player.mount((Entity) null);
				if (entity.world != this.player.world) {
					WorldServer playerWorldServer = this.player.getWorldServer();
					WorldServer entityWorldServer = (WorldServer) entity.world;
					this.player.dimensionId = entity.dimensionId;
					this.sendPacket(new PacketPlayOutRespawn(this.player.dimensionId, playerWorldServer.getDifficulty(), playerWorldServer.getWorldData().getLevelType(), this.player.playerInteractManager.getGameMode()));
					playerWorldServer.f(this.player);
					this.player.dead = false;
					this.player.setPositionRotation(entity.locationX, entity.locationY, entity.locationZ, entity.yaw, entity.pitch);
					if (this.player.isAlive()) {
						playerWorldServer.a((Entity) this.player, false);
						entityWorldServer.addEntity(this.player);
						entityWorldServer.a((Entity) this.player, false);
					}

					this.player.setWorld((World) entityWorldServer);
					this.minecraftserver.getPlayerList().a(this.player, playerWorldServer);
					this.player.updatePosition(entity.locationX, entity.locationY, entity.locationZ);
					this.player.playerInteractManager.setWorldServer(entityWorldServer);
					this.minecraftserver.getPlayerList().updateWorldData(this.player, entityWorldServer);
					this.minecraftserver.getPlayerList().f(this.player);
				} else {
					this.player.updatePosition(entity.locationX, entity.locationY, entity.locationZ);
				}
			}
		}
	}

	public void handle(PacketPlayInResourcePackStatus packet) {
	}

	public void handle(IChatBaseComponent packet) {
		logger.info(this.player.getName() + " lost connection: " + packet);
		this.minecraftserver.requestServerPingRefresh();
		ChatMessage chatMessage = new ChatMessage("multiplayer.player.left", new Object[] { this.player.getComponentName() });
		chatMessage.getChatModifier().setColor(EnumChatFormat.YELLOW);
		this.minecraftserver.getPlayerList().sendMessage(chatMessage);
		this.player.q();
		this.minecraftserver.getPlayerList().disconnect(this.player);
		if (this.minecraftserver.isSinglePlayer() && this.player.getName().equals(this.minecraftserver.getSinglePlayerName())) {
			logger.info("Stopping singleplayer server as player logged out");
			this.minecraftserver.stopTicking();
		}
	}

	public void handle(PacketPlayInHeldItemChange packet) {
		PacketAsyncToSyncThrower.schedulePacketHandleIfNeeded(packet, this, this.player.getWorldServer());
		if (packet.getSlot() >= 0 && packet.getSlot() < PlayerInventory.getHotbarSize()) {
			this.player.playerInventory.itemInHandIndex = packet.getSlot();
			this.player.updateLastActiveTime();
		} else {
			logger.warn(this.player.getName() + " tried to set an invalid carried item");
		}
	}

	public void handle(PacketPlayInChatMessage packet) {
		PacketAsyncToSyncThrower.schedulePacketHandleIfNeeded(packet, this, this.player.getWorldServer());
		if (this.player.getChatFlag() == EnumChatFlag.HIDDEN) {
			ChatMessage response = new ChatMessage("chat.cannotSend", new Object[0]);
			response.getChatModifier().setColor(EnumChatFormat.RED);
			this.sendPacket(new PacketPlayOutChatMessage(response));
		} else {
			this.player.updateLastActiveTime();
			String message = packet.getMessage();
			message = StringUtils.normalizeSpace(message);

			for (int i = 0; i < message.length(); ++i) {
				if (!SharedConstants.isAllowedChatCharacter(message.charAt(i))) {
					this.disconnect("Illegal characters in chat");
					return;
				}
			}

			if (message.startsWith("/")) {
				this.handleCommand(message);
			} else {
				ChatMessage chatMessage = new ChatMessage("chat.type.text", new Object[] { this.player.getComponentName(), message });
				this.minecraftserver.getPlayerList().sendMessage(chatMessage, false);
			}

			this.chatThrottle += 20;
			if (this.chatThrottle > 200 && !this.minecraftserver.getPlayerList().isOp(this.player.getGameProfile())) {
				this.disconnect("disconnect.spam");
			}

		}
	}

	private void handleCommand(String command) {
		this.minecraftserver.getCommandHandler().a(this.player, command);
	}

	public void handle(PacketPlayInAnimation packet) {
		PacketAsyncToSyncThrower.schedulePacketHandleIfNeeded(packet, this, this.player.getWorldServer());
		this.player.updateLastActiveTime();
		this.player.performHandAnimation();
	}

	public void handle(PacketPlayInEntityAction packet) {
		PacketAsyncToSyncThrower.schedulePacketHandleIfNeeded(packet, this, this.player.getWorldServer());
		this.player.updateLastActiveTime();
		switch (packet.getAction()) {
			case START_SNEAKING: {
				this.player.setSneaking(true);
				break;
			}
			case STOP_SNEAKING: {
				this.player.setSneaking(false);
				break;
			}
			case START_SPRINTING: {
				this.player.setSprinting(true);
				break;
			}
			case STOP_SPRINTING: {
				this.player.setSprinting(false);
				break;
			}
			case STOP_SLEEPING: {
				this.player.a(false, true, true);
				this.checkMovement = false;
				break;
			}
			case RIDING_JUMP: {
				if (this.player.vehicle instanceof EntityHorse) {
					((EntityHorse) this.player.vehicle).jump(packet.getHorseJumpBoost());
				}
				break;
			}
			case OPEN_INVENTORY: {
				if (this.player.vehicle instanceof EntityHorse) {
					((EntityHorse) this.player.vehicle).openChest(this.player);
				}
				break;
			}
			default: {
				throw new IllegalArgumentException("Invalid client command!");
			}
		}

	}

	public void handle(PacketPlayInUseEntity packet) {
		PacketAsyncToSyncThrower.schedulePacketHandleIfNeeded(packet, this, this.player.getWorldServer());
		WorldServer worldServer = this.minecraftserver.getWorldServer(this.player.dimensionId);
		Entity entity = packet.getEntity(worldServer);
		this.player.updateLastActiveTime();
		if (entity != null) {
			boolean flag = this.player.t(entity);
			double maxDistance = 36.0D;
			if (!flag) {
				maxDistance = 9.0D;
			}

			if (this.player.getDistanceSquared(entity) < maxDistance) {
				if (packet.getAction() == UseEntityAction.INTERACT) {
					this.player.useEntity(entity);
				} else if (packet.getAction() == UseEntityAction.INTERACT_AT) {
					entity.interactAt((EntityHuman) this.player, packet.getInteractedAt());
				} else if (packet.getAction() == UseEntityAction.ATTACK) {
					if (entity instanceof EntityItem || entity instanceof EntityExpirienceOrb || entity instanceof EntityArrow || entity == this.player) {
						this.disconnect("Attempting to attack an invalid entity");
						this.minecraftserver.logWarning("Player " + this.player.getName() + " tried to attack an invalid entity");
						return;
					}
					this.player.attackEntity(entity);
				}
			}
		}
	}

	public void handle(PacketPlayInClientStatus packet) {
		PacketAsyncToSyncThrower.schedulePacketHandleIfNeeded(packet, this, this.player.getWorldServer());
		this.player.updateLastActiveTime();
		ClientStatusAction action = packet.getAction();
		switch (action) {
			case PERFORM_RESPAWN: {
				if (this.player.viewingCredits) {
					this.player = this.minecraftserver.getPlayerList().moveToWorld(this.player, 0, true);
				} else if (this.player.getWorldServer().getWorldData().isHardcore()) {
					if (this.minecraftserver.isSinglePlayer() && this.player.getName().equals(this.minecraftserver.getSinglePlayerName())) {
						this.player.playerConncetion.disconnect("You have died. Game over, man, it\'s game over!");
						this.minecraftserver.stopSinglePlayerServer();
					} else {
						GameProfileBanEntry banEntry = new GameProfileBanEntry(this.player.getGameProfile(), (Date) null, "(You just lost the game)", (Date) null, "Death in Hardcore");
						this.minecraftserver.getPlayerList().getProfileBans().add((sr) banEntry);
						this.player.playerConncetion.disconnect("You have died. Game over, man, it\'s game over!");
					}
				} else {
					if (this.player.getHealth() > 0.0F) {
						return;
					}

					this.player = this.minecraftserver.getPlayerList().moveToWorld(this.player, 0, false);
				}
				break;
			}
			case REQUEST_STATS: {
				this.player.getStatisticManager().sendStatistics(this.player);
				break;
			}
			case OPEN_INVENTORY_ACHIEVEMENT: {
				this.player.b(AchievementList.f);
			}
		}
	}

	public void handle(PacketPlayInCloseWindow packet) {
		PacketAsyncToSyncThrower.schedulePacketHandleIfNeeded(packet, this, this.player.getWorldServer());
		this.player.closeWindow();
	}

	public void handle(PacketPlayInClickWindow packet) {
		PacketAsyncToSyncThrower.schedulePacketHandleIfNeeded(packet, this, this.player.getWorldServer());
		this.player.updateLastActiveTime();
		if (this.player.activeContainer.windowId == packet.getWindowId() && this.player.activeContainer.isTransactionsConfirmed(this.player)) {
			if (this.player.isSpectator()) {
				ArrayList<ItemStack> items = Lists.newArrayList();
				for (int i = 0; i < this.player.activeContainer.slots.size(); ++i) {
					items.add(this.player.activeContainer.slots.get(i).getItemStack());
				}
				this.player.setContainerData(this.player.activeContainer, items);
			} else {
				ItemStack item = this.player.activeContainer.a(packet.getSlot(), packet.getButton(), packet.getMode(), this.player);
				if (ItemStack.matches(packet.getItem(), item)) {
					this.player.playerConncetion.sendPacket(new PacketPlayOutConfirmTransaction(packet.getWindowId(), packet.getAction(), true));
					this.player.g = true;
					this.player.activeContainer.b();
					this.player.broadcastCarriedItem();
					this.player.g = false;
				} else {
					this.intHashMap.a(this.player.activeContainer.windowId, Short.valueOf(packet.getAction()));
					this.player.playerConncetion.sendPacket(new PacketPlayOutConfirmTransaction(packet.getWindowId(), packet.getAction(), false));
					this.player.activeContainer.notifyTransactionStatus(this.player, false);
					ArrayList<ItemStack> items = Lists.newArrayList();
					for (int i = 0; i < this.player.activeContainer.slots.size(); ++i) {
						items.add(this.player.activeContainer.slots.get(i).getItemStack());
					}
					this.player.setContainerData(this.player.activeContainer, items);
				}
			}
		}
	}

	public void handle(PacketPlayInEnchantItem packet) {
		PacketAsyncToSyncThrower.schedulePacketHandleIfNeeded(packet, this, this.player.getWorldServer());
		this.player.updateLastActiveTime();
		if (this.player.activeContainer.windowId == packet.getWindowId() && this.player.activeContainer.isTransactionsConfirmed(this.player) && !this.player.isSpectator()) {
			this.player.activeContainer.a((EntityHuman) this.player, packet.getEnchantment());
			this.player.activeContainer.b();
		}
	}

	public void handle(PacketPlayInCreativeInventoryAction packet) {
		PacketAsyncToSyncThrower.schedulePacketHandleIfNeeded(packet, this, this.player.getWorldServer());
		if (this.player.playerInteractManager.isCreative()) {
			boolean dropItem = packet.getSlot() < 0;
			ItemStack item = packet.getItem();
			if (item != null && item.hasTag() && item.getTag().isTagAssignableFrom("BlockEntityTag", 10)) {
				NBTCompoundTag itemtag = item.getTag().getCompound("BlockEntityTag");
				if (itemtag.hasKey("x") && itemtag.hasKey("y") && itemtag.hasKey("z")) {
					Position position = new Position(itemtag.getInt("x"), itemtag.getInt("y"), itemtag.getInt("z"));
					TileEntity tileEntity = this.player.world.getTileEntity(position);
					if (tileEntity != null) {
						NBTCompoundTag tag = new NBTCompoundTag();
						tileEntity.write(tag);
						tag.remove("x");
						tag.remove("y");
						tag.remove("z");
						item.addTag("BlockEntityTag", (NBTTag) tag);
					}
				}
			}

			boolean isInventoryClick = packet.getSlot() >= 1 && packet.getSlot() < 36 + PlayerInventory.getHotbarSize();
			boolean isValidItemCheck1 = item == null || item.getItem() != null;
			boolean isValidItemCheck2 = item == null || item.getDurability() >= 0 && item.amount <= 64 && item.amount > 0;
			if (isInventoryClick && isValidItemCheck1 && isValidItemCheck2) {
				if (item == null) {
					this.player.defaultContainer.setItem(packet.getSlot(), (ItemStack) null);
				} else {
					this.player.defaultContainer.setItem(packet.getSlot(), item);
				}

				this.player.defaultContainer.notifyTransactionStatus(this.player, true);
			} else if (dropItem && isValidItemCheck1 && isValidItemCheck2 && this.creativeItemDropThrottle < 200) {
				this.creativeItemDropThrottle += 20;
				EntityItem entityItem = this.player.dropItem(item, true);
				if (entityItem != null) {
					entityItem.j();
				}
			}
		}
	}

	public void handle(PacketPlayInConfirmTransaction packet) {
		PacketAsyncToSyncThrower.schedulePacketHandleIfNeeded(packet, this, this.player.getWorldServer());
		Short action = (Short) this.intHashMap.get(this.player.activeContainer.windowId);
		if (action != null && packet.getAction() == action.shortValue() && this.player.activeContainer.windowId == packet.getWindowId() && !this.player.activeContainer.isTransactionsConfirmed(this.player) && !this.player.isSpectator()) {
			this.player.activeContainer.notifyTransactionStatus(this.player, true);
		}
	}

	public void handle(PacketPlayInUpdateSign packet) {
		PacketAsyncToSyncThrower.schedulePacketHandleIfNeeded(packet, this, this.player.getWorldServer());
		this.player.updateLastActiveTime();
		WorldServer worlServer = this.minecraftserver.getWorldServer(this.player.dimensionId);
		Position position = packet.getPosition();
		if (worlServer.isLoaded(position)) {
			TileEntity tileEntity = worlServer.getTileEntity(position);
			if (!(tileEntity instanceof TileEntitySign)) {
				return;
			}

			TileEntitySign sign = (TileEntitySign) tileEntity;
			if (!sign.isEditable() || sign.getEditor() != this.player) {
				this.minecraftserver.logWarning("Player " + this.player.getName() + " just tried to change non-editable sign");
				return;
			}

			System.arraycopy(packet.getLines(), 0, sign.lines, 0, 4);
			sign.update();
			worlServer.notify(position);
		}
	}

	public void handle(PacketPlayInKeepAlive packet) {
		if (packet.getKeepAliveId() == this.packetKeepAliveMilliseconds) {
			int roundTripTime = (int) (this.getCurrentMillis() - this.lastKeepAliveMilliseconds);
			this.player.ping = (this.player.ping * 3 + roundTripTime) / 4;
		}
	}

	public void handle(PacketPlayInPlayAbilities packet) {
		PacketAsyncToSyncThrower.schedulePacketHandleIfNeeded(packet, this, this.player.getWorldServer());
		this.player.playerProperties.flying = packet.isFlying() && this.player.playerProperties.mayfly;
	}

	public void handle(PacketPlayInTabComplete packet) {
		PacketAsyncToSyncThrower.schedulePacketHandleIfNeeded(packet, this, this.player.getWorldServer());
		String[] data = minecraftserver.getTabCompleteList((CommandSenderInterface) this.player, packet.getText(), packet.getPosition()).toArray(new String[0]);
		this.player.playerConncetion.sendPacket(new PacketPlayOutTabComplete(data));
	}

	public void handle(PacketPlayInClientSettings packet) {
		PacketAsyncToSyncThrower.schedulePacketHandleIfNeeded(packet, this, this.player.getWorldServer());
		this.player.setClientSettings(packet);
	}

	public void handle(PacketPlayInPluginMessage packet) {
		PacketAsyncToSyncThrower.schedulePacketHandleIfNeeded(packet, this, this.player.getWorldServer());
		PacketDataSerializer serializer;
		ItemStack packetItemStack;
		ItemStack itemInHand;
		if ("MC|BEdit".equals(packet.getChannelName())) {
			serializer = new PacketDataSerializer(Unpooled.wrappedBuffer((ByteBuf) packet.getMessage()));

			try {
				packetItemStack = serializer.readItemStack();
				if (packetItemStack != null) {
					if (!ItemBookAndQuill.isValid(packetItemStack.getTag())) {
						throw new IOException("Invalid book tag!");
					}

					itemInHand = this.player.playerInventory.getItemInHand();
					if (itemInHand == null) {
						return;
					}

					if (packetItemStack.getItem() == Items.WRITABLE_BOOK && packetItemStack.getItem() == itemInHand.getItem()) {
						itemInHand.addTag("pages", packetItemStack.getTag().getList("pages", 8));
					}

					return;
				}
			} catch (Exception ex) {
				logger.error("Couldn\'t handle book info", ex);
				return;
			} finally {
				serializer.release();
			}

			return;
		} else if ("MC|BSign".equals(packet.getChannelName())) {
			serializer = new PacketDataSerializer(Unpooled.wrappedBuffer((ByteBuf) packet.getMessage()));

			try {
				packetItemStack = serializer.readItemStack();
				if (packetItemStack != null) {
					if (!ItemWrittenBook.isValid(packetItemStack.getTag())) {
						throw new IOException("Invalid book tag!");
					}

					itemInHand = this.player.playerInventory.getItemInHand();
					if (itemInHand == null) {
						return;
					}

					if (packetItemStack.getItem() == Items.WRITTEN_BOOK && itemInHand.getItem() == Items.WRITABLE_BOOK) {
						itemInHand.addTag("author", new NBTStringTag(this.player.getName()));
						itemInHand.addTag("title", new NBTStringTag(packetItemStack.getTag().getString("title")));
						itemInHand.addTag("pages", packetItemStack.getTag().getList("pages", 8));
						itemInHand.setItem(Items.WRITTEN_BOOK);
					}

					return;
				}
			} catch (Exception ex) {
				logger.error("Couldn\'t sign book", ex);
				return;
			} finally {
				serializer.release();
			}

			return;
		} else if ("MC|TrSel".equals(packet.getChannelName())) {
			try {
				int tradeId = packet.getMessage().readInt();
				Container activeContainer = this.player.activeContainer;
				if (activeContainer instanceof ContainerMerchant) {
					((ContainerMerchant) activeContainer).selectOffer(tradeId);
				}
			} catch (Exception ex) {
				logger.error("Couldn\'t select trade", (Throwable) ex);
			}
		} else if ("MC|AdvCdm".equals(packet.getChannelName())) {
			if (!this.minecraftserver.isCommandBlockEnabled()) {
				this.player.sendChatMessage(new ChatMessage("advMode.notEnabled", new Object[0]));
			} else if (this.player.canExecuteCommand(2, "") && this.player.playerProperties.instabuild) {
				serializer = packet.getMessage();

				try {
					byte entityId = serializer.readByte();
					CommandBlockListenerAbstract commandBlockListener = null;
					if (entityId == 0) {
						TileEntity tileEntity = this.player.world.getTileEntity(new Position(serializer.readInt(), serializer.readInt(), serializer.readInt()));
						if (tileEntity instanceof TileEntityCommand) {
							commandBlockListener = ((TileEntityCommand) tileEntity).getListener();
						}
					} else if (entityId == 1) {
						Entity entity = this.player.world.getEntity(serializer.readInt());
						if (entity instanceof EntityMinecartCommandBlock) {
							commandBlockListener = ((EntityMinecartCommandBlock) entity).getListener();
						}
					}

					String command = serializer.readString(serializer.readableBytes());
					boolean trackOutput = serializer.readBoolean();
					if (commandBlockListener != null) {
						commandBlockListener.setCommand(command);
						commandBlockListener.setTrackOutput(trackOutput);
						if (!trackOutput) {
							commandBlockListener.setLastOutput((IChatBaseComponent) null);
						}
						commandBlockListener.updateEntity();
						this.player.sendChatMessage(new ChatMessage("advMode.setCommand.success", new Object[] { command }));
					}
				} catch (Exception ex) {
					logger.error("Couldn\'t set command block", (Throwable) ex);
				} finally {
					serializer.release();
				}
			} else {
				this.player.sendChatMessage(new ChatMessage("advMode.notAllowed", new Object[0]));
			}
		} else if ("MC|Beacon".equals(packet.getChannelName())) {
			if (this.player.activeContainer instanceof ContainerBeacon) {
				try {
					serializer = packet.getMessage();
					int i1 = serializer.readInt();
					int i2 = serializer.readInt();
					ContainerBeacon containerBeacon = (ContainerBeacon) this.player.activeContainer;
					Slot slot = containerBeacon.getSlot(0);
					if (slot.hasItem()) {
						slot.a(1);
						IInventory inventory = containerBeacon.getInventory();
						inventory.b(1, i1);
						inventory.b(2, i2);
						inventory.update();
					}
				} catch (Exception var32) {
					logger.error("Couldn\'t set beacon", (Throwable) var32);
				}
			}
		} else if ("MC|ItemName".equals(packet.getChannelName()) && this.player.activeContainer instanceof ContainerAnvil) {
			ContainerAnvil containerAnvil = (ContainerAnvil) this.player.activeContainer;
			if (packet.getMessage() != null && packet.getMessage().readableBytes() >= 1) {
				String itemName = SharedConstants.cleanupString(packet.getMessage().readString(32767));
				if (itemName.length() <= 30) {
					containerAnvil.setResultItemName(itemName);
				}
			} else {
				containerAnvil.setResultItemName("");
			}
		}

	}

	public void sendPacket(final Packet<? extends PacketListener> packet) {
		if (packet instanceof PacketPlayOutChatMessage) {
			PacketPlayOutChatMessage message = (PacketPlayOutChatMessage) packet;
			EnumChatFlag chatFlag = this.player.getChatFlag();
			if (chatFlag == EnumChatFlag.HIDDEN) {
				return;
			}

			if (chatFlag == EnumChatFlag.SYSTEM && !message.isChatMessage()) {
				return;
			}
		}

		try {
			this.networkManager.handleSendPacket(packet);
		} catch (Throwable t) {
			CrashReport crashReport = CrashReport.generateCrashReport(t, "Sending packet");
			CrashReportSystemDetails crashReportDetails = crashReport.generateSystemDetails("Packet being sent");
			crashReportDetails.addDetails("Packet class", new Callable<String>() {
				@Override
				public String call() throws Exception {
					return packet.getClass().getCanonicalName();
				}
			});
			throw new ReportedException(crashReport);
		}
	}

}
