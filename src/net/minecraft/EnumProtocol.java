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
			registerPacket(PacketDirection.SERVERBOUND, PacketSetProtocol.class);
		}
	},
	PLAY(0) {
		{
			registerPacket(PacketDirection.CLIENTBOUND, PacketKeepAlive.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketJoinGame.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketChatMessage.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketTimeUpdate.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketEntityEquipment.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketSpawnPosition.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketUpdateHealth.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketRespawn.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketPlayerPositionAndLook.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketHeldItemChange.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketUseBed.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketAnimation.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketSpawnPlayer.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketCollectItem.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketSpawnObject.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketSpawnMob.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketSpawnPainting.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketSpawnExpirienceOrb.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketEntityVelocity.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketDestroyEntities.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketEntity.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketEntityRelativeMove.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketEntityLook.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketEntityRelativeLookMove.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketEntityTeleport.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketEntityHeadLook.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketEntityStatus.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketAttachEntity.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketEntityMetadata.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketEntityEffect.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketRemoveEntityEffect.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketSetExpirience.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketEntityProperties.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketChunkData.class);
			registerPacket(PacketDirection.CLIENTBOUND, PacketMultiBlockChange.class);
			registerPacket(PacketDirection.CLIENTBOUND, iw.class);
			registerPacket(PacketDirection.CLIENTBOUND, iv.class);
			registerPacket(PacketDirection.CLIENTBOUND, it.class);
			registerPacket(PacketDirection.CLIENTBOUND, js.class);
			registerPacket(PacketDirection.CLIENTBOUND, jm.class);
			registerPacket(PacketDirection.CLIENTBOUND, jt.class);
			registerPacket(PacketDirection.CLIENTBOUND, jv.class);
			registerPacket(PacketDirection.CLIENTBOUND, ju.class);
			registerPacket(PacketDirection.CLIENTBOUND, jo.class);
			registerPacket(PacketDirection.CLIENTBOUND, in.class);
			registerPacket(PacketDirection.CLIENTBOUND, je.class);
			registerPacket(PacketDirection.CLIENTBOUND, jd.class);
			registerPacket(PacketDirection.CLIENTBOUND, jh.class);
			registerPacket(PacketDirection.CLIENTBOUND, jf.class);
			registerPacket(PacketDirection.CLIENTBOUND, jg.class);
			registerPacket(PacketDirection.CLIENTBOUND, jc.class);
			registerPacket(PacketDirection.CLIENTBOUND, ll.class);
			registerPacket(PacketDirection.CLIENTBOUND, jx.class);
			registerPacket(PacketDirection.CLIENTBOUND, iu.class);
			registerPacket(PacketDirection.CLIENTBOUND, kc.class);
			registerPacket(PacketDirection.CLIENTBOUND, is.class);
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
