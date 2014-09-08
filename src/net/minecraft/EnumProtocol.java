package net.minecraft;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;

import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.hash.TIntObjectHashMap;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;

public enum EnumProtocol {

	HANDSHAKING(-1) {
		{
			registerPacket(PacketDirection.SERVERBOUND, PacketHandshakingInSetProtocol.class);
		}
	},
	PLAY(0) {
		{
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutKeepAlive.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutJoinGame.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutChatMessage.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutTimeUpdate.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutEntityEquipment.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutSpawnPosition.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutUpdateHealth.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutRespawn.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutPlayerPositionAndLook.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutHeldItemChange.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutUseBed.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutAnimation.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutSpawnPlayer.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutCollectItem.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutSpawnObject.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutSpawnMob.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutSpawnPainting.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutSpawnExpirienceOrb.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutEntityVelocity.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutDestroyEntities.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutEntity.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutEntityRelativeMove.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutEntityLook.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutEntityRelativeLookMove.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutEntityTeleport.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutEntityHeadLook.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutEntityStatus.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutAttachEntity.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutEntityMetadata.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutEntityEffect.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutRemoveEntityEffect.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutSetExpirience.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutEntityProperties.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutChunkData.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutMultiBlockChange.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutBlockChange.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutBlockAction.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutBlockBreakAnimation.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutMapChunkBulk.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutExplosion.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutEffect.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutSoundEffect.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutParticle.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutChangeGameState.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutSpawnGlobalEntity.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutOpenWindow.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutCloseWindow.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutSetSlot.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutWindowItems.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutWindowProperty.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutConfirmTransaction.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutUpdateSign.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutMap.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutUpdateBlockEntity.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutSignEditorOpen.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutStatistics.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutListItem.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutPlayerAbilities.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutTabComplete.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutScoreboardObjective.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutUpdateScore.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutDisplayScoreboard.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutScoreboardTeam.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutPluginMessage.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutDisconnect.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutServerDifficulty.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutCombatEvent.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutCamera.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutWorldBorder.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutTitle.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutSetCompression.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutListHeaderFooter.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutResourcePackSend.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayOutUpdateEntityNBT.class);
			registerPacket(PacketDirection.SERVERBOUND, PacketPlayInKeepAlive.class);
			registerPacket(PacketDirection.SERVERBOUND, PacketPlayInChatMessage.class);
			registerPacket(PacketDirection.SERVERBOUND, PacketPlayInUseEntity.class);
			registerPacket(PacketDirection.SERVERBOUND, PacketPlayInPlayer.class);
			registerPacket(PacketDirection.SERVERBOUND, PacketPlayInPlayerPosition.class);
			registerPacket(PacketDirection.SERVERBOUND, PacketPlayInPlayerLook.class);
			registerPacket(PacketDirection.SERVERBOUND, PacketPlayInPositionLook.class);
			registerPacket(PacketDirection.SERVERBOUND, PacketPlayInPlayerDigging.class);
			registerPacket(PacketDirection.SERVERBOUND, PacketPlayInBlockPlace.class);
			registerPacket(PacketDirection.SERVERBOUND, PacketPlayInHeldItemChange.class);
			registerPacket(PacketDirection.SERVERBOUND, PacketPlayInAnimation.class);
			registerPacket(PacketDirection.SERVERBOUND, PacketPlayInEntityAction.class);
			registerPacket(PacketDirection.SERVERBOUND, PacketPlayInSteerVehicle.class);
			registerPacket(PacketDirection.SERVERBOUND, PacketPlayInCloseWindow.class);
			registerPacket(PacketDirection.SERVERBOUND, PacketPlayInClickWindow.class);
			registerPacket(PacketDirection.SERVERBOUND, PacketPlayInConfirmTransaction.class);
			registerPacket(PacketDirection.SERVERBOUND, PacketPlayInCreativeInventoryAction.class);
			registerPacket(PacketDirection.SERVERBOUND, PacketPlayInEnchantItem.class);
			registerPacket(PacketDirection.SERVERBOUND, PacketPlayInUpdateSign.class);
			registerPacket(PacketDirection.SERVERBOUND, PacketPlayInPlayAbilities.class);
			registerPacket(PacketDirection.SERVERBOUND, PacketPlayInTabComplete.class);
			registerPacket(PacketDirection.SERVERBOUND, PacketPlayInClientSettings.class);
			registerPacket(PacketDirection.SERVERBOUND, PacketPlayInClientStatus.class);
			registerPacket(PacketDirection.SERVERBOUND, PacketPlayInPluginMessage.class);
			registerPacket(PacketDirection.SERVERBOUND, PacketPlayInSpectate.class);
			registerPacket(PacketDirection.SERVERBOUND, PacketPlayInResourcePackStatus.class);
		}
	},
	STATUS(1) {
		{
			registerPacket(PacketDirection.SERVERBOUND, nx.class);
			registerPacket(PacketDirection.CLIENTBOUND, no.class);
			registerPacket(PacketDirection.SERVERBOUND, nw.class);
			registerPacket(PacketDirection.CLIENTBOUND, nn.class);
		}
	},
	LOGIN(2) {
		{
			registerPacket(PacketDirection.CLIENTBOUND, ng.class);
			registerPacket(PacketDirection.CLIENTBOUND, ne.class);
			registerPacket(PacketDirection.CLIENTBOUND, nd.class);
			registerPacket(PacketDirection.CLIENTBOUND, nf.class);
			registerPacket(PacketDirection.SERVERBOUND, ni.class);
			registerPacket(PacketDirection.SERVERBOUND, nj.class);
		}
	};

	private static final TIntObjectMap<EnumProtocol> stateIdMap = new TIntObjectHashMap<EnumProtocol>();
	private static final Map<Class<? extends Packet<? extends PacketListener>>, EnumProtocol> packetMap = Maps.newHashMap();
	static {
		for (EnumProtocol enumProtocol : values()) {
			stateIdMap.put(enumProtocol.getStateId(), enumProtocol);
			
			for (Entry<PacketDirection, BiMap<Integer,Class<? extends Packet<? extends PacketListener>>>> entry : enumProtocol.directionPacketMap.entrySet()) {
				for (Class<? extends Packet<? extends PacketListener>> packetClass : entry.getValue().values()) {
					if (packetMap.containsKey(packetClass) && packetMap.get(packetClass) != enumProtocol) {
						throw new Error("Packet " + packetClass + " is already assigned to protocol " + packetMap.get(packetClass) + " - can\'t reassign to " + enumProtocol);
					}
					try {
						packetClass.newInstance();
					} catch (Throwable var9) {
						throw new Error("Packet " + packetClass + " fails instantiation checks! " + packetClass);
					}
					packetMap.put(packetClass, enumProtocol);
				}
			}
		}
	}

	private final int stateId;
	private final Map<PacketDirection, BiMap<Integer,Class<? extends Packet<? extends PacketListener>>>> directionPacketMap;

	private EnumProtocol(int stateId) {
		this.directionPacketMap = Maps.newEnumMap(PacketDirection.class);
		this.stateId = stateId;
	}

	protected EnumProtocol registerPacket(PacketDirection direction, Class<? extends Packet<? extends PacketListener>> packetClass) {
		BiMap<Integer, Class<? extends Packet<? extends PacketListener>>> map = this.directionPacketMap.get(direction);
		if (map == null) {
			map = HashBiMap.create();
			this.directionPacketMap.put(direction, map);
		}

		if (map.containsValue(packetClass)) {
			String reason = direction + " packet " + packetClass + " is already known to ID " + map.inverse().get(packetClass);
			LogManager.getLogger().fatal(reason);
			throw new IllegalArgumentException(reason);
		} else {
			map.put(map.size(), packetClass);
			return this;
		}
	}

	public Integer getPacketId(PacketDirection direction, Packet<? extends PacketListener> packetClass) {
		return this.directionPacketMap.get(direction).inverse().get(packetClass.getClass());
	}

	public Packet<? extends PacketListener> createPacket(PacketDirection direction, int id) throws InstantiationException, IllegalAccessException {
		Class<? extends Packet<? extends PacketListener>> packetClass = this.directionPacketMap.get(direction).get(id);
		return packetClass == null ? null : packetClass.newInstance();
	}

	public int getStateId() {
		return this.stateId;
	}

	public static EnumProtocol getState(int stateId) {
		return stateIdMap.get(stateId);
	}

	public static EnumProtocol a(Packet<?> packet) {
		return packetMap.get(packet.getClass());
	}

}
