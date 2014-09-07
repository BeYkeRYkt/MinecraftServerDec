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
			registerPacket(PacketDirection.SERVERBOUND, PacketInSetProtocol.class);
		}
	},
	PLAY(0) {
		{
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutKeepAlive.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutJoinGame.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutChatMessage.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutTimeUpdate.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutEntityEquipment.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutSpawnPosition.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutUpdateHealth.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutRespawn.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutPlayerPositionAndLook.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutHeldItemChange.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutUseBed.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutAnimation.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutSpawnPlayer.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutCollectItem.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutSpawnObject.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutSpawnMob.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutSpawnPainting.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutSpawnExpirienceOrb.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutEntityVelocity.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutDestroyEntities.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutEntity.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutEntityRelativeMove.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutEntityLook.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutEntityRelativeLookMove.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutEntityTeleport.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutEntityHeadLook.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutEntityStatus.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutAttachEntity.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutEntityMetadata.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutEntityEffect.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutRemoveEntityEffect.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutSetExpirience.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutEntityProperties.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutChunkData.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutMultiBlockChange.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutBlockChange.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutBlockAction.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutBlockBreakAnimation.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutMapChunkBulk.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutExplosion.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutEffect.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutSoundEffect.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutParticle.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutChangeGameState.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutSpawnGlobalEntity.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutOpenWindow.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutCloseWindow.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutSetSlot.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutWindowItems.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutWindowProperty.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutConfirmTransaction.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutUpdateSign.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutMap.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutUpdateBlockEntity.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutSignEditorOpen.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketOutStatistics.class);
			registerPacket(PacketDirection.CLIENTBOUND, kh.class);
			registerPacket(PacketDirection.CLIENTBOUND, kd.class);
			registerPacket(PacketDirection.CLIENTBOUND, iy.class);
			registerPacket(PacketDirection.CLIENTBOUND, ld.class);
			registerPacket(PacketDirection.CLIENTBOUND, lf.class);
			registerPacket(PacketDirection.CLIENTBOUND, kw.class);
			registerPacket(PacketDirection.CLIENTBOUND, le.class);
			registerPacket(PacketDirection.CLIENTBOUND, ji.class);
			registerPacket(PacketDirection.CLIENTBOUND, jj.class);
			registerPacket(PacketDirection.CLIENTBOUND, ix.class);
			registerPacket(PacketDirection.CLIENTBOUND, ke.class);
			registerPacket(PacketDirection.CLIENTBOUND, ku.class);
			registerPacket(PacketDirection.CLIENTBOUND, kr.class);
			registerPacket(PacketDirection.CLIENTBOUND, lj.class);
			registerPacket(PacketDirection.CLIENTBOUND, jn.class);
			registerPacket(PacketDirection.CLIENTBOUND, lm.class);
			registerPacket(PacketDirection.CLIENTBOUND, ko.class);
			registerPacket(PacketDirection.CLIENTBOUND, jl.class);
			registerPacket(PacketDirection.SERVERBOUND, mf.class);
			registerPacket(PacketDirection.SERVERBOUND, lu.class);
			registerPacket(PacketDirection.SERVERBOUND, md.class);
			registerPacket(PacketDirection.SERVERBOUND, mg.class);
			registerPacket(PacketDirection.SERVERBOUND, mh.class);
			registerPacket(PacketDirection.SERVERBOUND, mj.class);
			registerPacket(PacketDirection.SERVERBOUND, mi.class);
			registerPacket(PacketDirection.SERVERBOUND, ml.class);
			registerPacket(PacketDirection.SERVERBOUND, mx.class);
			registerPacket(PacketDirection.SERVERBOUND, ms.class);
			registerPacket(PacketDirection.SERVERBOUND, mv.class);
			registerPacket(PacketDirection.SERVERBOUND, mn.class);
			registerPacket(PacketDirection.SERVERBOUND, mp.class);
			registerPacket(PacketDirection.SERVERBOUND, mb.class);
			registerPacket(PacketDirection.SERVERBOUND, ma.class);
			registerPacket(PacketDirection.SERVERBOUND, ly.class);
			registerPacket(PacketDirection.SERVERBOUND, mt.class);
			registerPacket(PacketDirection.SERVERBOUND, lz.class);
			registerPacket(PacketDirection.SERVERBOUND, mu.class);
			registerPacket(PacketDirection.SERVERBOUND, mk.class);
			registerPacket(PacketDirection.SERVERBOUND, lt.class);
			registerPacket(PacketDirection.SERVERBOUND, lx.class);
			registerPacket(PacketDirection.SERVERBOUND, lv.class);
			registerPacket(PacketDirection.SERVERBOUND, mc.class);
			registerPacket(PacketDirection.SERVERBOUND, mw.class);
			registerPacket(PacketDirection.SERVERBOUND, mq.class);
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
