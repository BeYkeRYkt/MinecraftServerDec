package net.minecraft;

public interface PlayOutPacketListener extends PacketListener {

	void handle(PacketPlayOutSpawnObject packet);

	void handle(PacketPlayOutSpawnExpirienceOrb packet);

	void handle(PacketPlayOutSpawnGlobalEntity packet);

	void handle(PacketPlayOutSpawnMob packet);

	void handle(PacketPlayOutScoreboardObjective packet);

	void handle(PacketPlayOutSpawnPainting packet);

	void handle(PacketPlayOutSpawnPlayer packet);

	void handle(PacketPlayOutAnimation packet);

	void handle(PacketPlayOutStatistics packet);

	void handle(PacketPlayOutBlockBreakAnimation packet);

	void handle(PacketPlayOutSignEditorOpen packet);

	void handle(PacketPlayOutUpdateBlockEntity packet);

	void handle(PacketPlayOutBlockAction packet);

	void handle(PacketPlayOutBlockChange packet);

	void handle(PacketPlayOutChatMessage packet);

	void handle(PacketPlayOutTabComplete packet);

	void handle(PacketPlayOutMultiBlockChange packet);

	void handle(PacketPlayOutMap packet);

	void handle(PacketPlayOutConfirmTransaction packet);

	void handle(PacketPlayOutCloseWindow packet);

	void handle(PacketPlayOutWindowItems packet);

	void handle(PacketPlayOutOpenWindow packet);

	void handle(PacketPlayOutWindowProperty packet);

	void handle(PacketPlayOutSetSlot packet);

	void handle(PacketPlayOutPluginMessage packet);

	void handle(PacketPlayOutDisconnect packet);

	void handle(PacketPlayOutUseBed packet);

	void handle(PacketPlayOutEntityStatus packet);

	void handle(PacketPlayOutAttachEntity packet);

	void handle(PacketPlayOutExplosion packet);

	void handle(PacketPlayOutChangeGameState packet);

	void handle(PacketPlayOutKeepAlive packet);

	void handle(PacketPlayOutChunkData packet);

	void handle(PacketPlayOutMapChunkBulk packet);

	void handle(PacketPlayOutEffect packet);

	void handle(PacketPlayOutJoinGame packet);

	void handle(PacketPlayOutEntity packet);

	void handle(PacketPlayOutPlayerPositionAndLook packet);

	void handle(PacketPlayOutParticle packet);

	void handle(PacketPlayOutPlayerAbilities packet);

	void handle(PacketPlayOutListItem packet);

	void handle(PacketPlayOutDestroyEntities packet);

	void handle(PacketPlayOutRemoveEntityEffect packet);

	void handle(PacketPlayOutRespawn packet);

	void handle(PacketPlayOutEntityHeadLook packet);

	void handle(PacketPlayOutHeldItemChange packet);

	void handle(PacketPlayOutDisplayScoreboard packet);

	void handle(PacketPlayOutEntityMetadata packet);

	void handle(PacketPlayOutEntityVelocity packet);

	void handle(PacketPlayOutEntityEquipment packet);

	void handle(PacketPlayOutSetExpirience packet);

	void handle(PacketPlayOutUpdateHealth packet);

	void handle(PacketPlayOutScoreboardTeam packet);

	void handle(PacketPlayOutUpdateScore packet);

	void handle(PacketPlayOutSpawnPosition packet);

	void handlePacket(PacketPlayOutTimeUpdate packet);

	void handle(PacketPlayOutUpdateSign packet);

	void handle(PacketPlayOutSoundEffect packet);

	void handle(PacketPlayOutCollectItem packet);

	void handle(PacketPlayOutEntityTeleport packet);

	void handle(PacketPlayOutEntityProperties packet);

	void handle(PacketPlayOutEntityEffect packet);

	void handle(PacketPlayOutCombatEvent packet);

	void handle(PacketPlayOutServerDifficulty packet);

	void handle(PacketPlayOutCamera packet);

	void handle(PacketPlayOutWorldBorder packet);

	void handle(PacketPlayOutTitle packet);

	void handle(PacketPlayOutSetCompression packet);

	void handle(PacketPlayOutListHeaderFooter packet);

	void handle(PacketPlayOutResourcePackSend packet);

	void handle(PacketPlayOutUpdateEntityNBT packet);

}
