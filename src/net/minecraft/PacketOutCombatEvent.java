package net.minecraft;

public class PacketOutCombatEvent implements Packet<PlayClientboundPacketListener> {

	public CombatEvent event;
	public int playerId;
	public int entityId;
	public int duration;
	public String message;

	public PacketOutCombatEvent() {
	}

	public PacketOutCombatEvent(CombatTracker tracker, CombatEvent combatEvent) {
		this.event = combatEvent;
		EntityLiving entity = tracker.getEntity();
		switch (combatEvent) {
			case ENTER_COMBAT: {
				this.duration = tracker.getDuration();
				this.entityId = entity == null ? -1 : entity.getId();
				break;
			}
			case END_COMBAT: { 
				this.playerId = tracker.getPlayer().getId();
				this.entityId = entity == null ? -1 : entity.getId();
				this.message = tracker.getMessage().c();
			}
			default: {
				break;
			}
		}

	}

	public void readData(PacketDataSerializer serializer) {
		this.event = (CombatEvent) serializer.readEnum(CombatEvent.class);
		if (this.event == CombatEvent.END_COMBAT) {
			this.duration = serializer.readVarInt();
			this.entityId = serializer.readInt();
		} else if (this.event == CombatEvent.ENTITY_DIED) {
			this.playerId = serializer.readVarInt();
			this.entityId = serializer.readInt();
			this.message = serializer.readString(32767);
		}

	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeEnum(this.event);
		if (this.event == CombatEvent.END_COMBAT) {
			serializer.writeVarInt(this.duration);
			serializer.writeInt(this.entityId);
		} else if (this.event == CombatEvent.ENTITY_DIED) {
			serializer.writeVarInt(this.playerId);
			serializer.writeInt(this.entityId);
			serializer.writeString(this.message);
		}

	}

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

	public static enum CombatEvent {
		ENTER_COMBAT, END_COMBAT, ENTITY_DIED;
	}

}
