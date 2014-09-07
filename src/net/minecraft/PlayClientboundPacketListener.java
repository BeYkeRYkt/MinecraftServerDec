package net.minecraft;

public interface PlayClientboundPacketListener extends PacketListener {

	void handle(PacketOutSpawnObject var1);

	void handle(PacketOutSpawnExpirienceOrb var1);

	void handle(PacketOutSpawnGlobalEntity var1);

	void handle(PacketOutSpawnMob var1);

	void handle(PacketOutScoreboardObjective var1);

	void handle(PacketOutSpawnPainting var1);

	void handle(PacketOutSpawnPlayer var1);

	void handle(PacketOutAnimation var1);

	void handle(PacketOutStatistics var1);

	void handle(PacketOutBlockBreakAnimation var1);

	void handle(PacketOutSignEditorOpen var1);

	void handle(PacketOutUpdateBlockEntity var1);

	void handle(PacketOutBlockAction var1);

	void handle(PacketOutBlockChange var1);

	void handle(PacketOutChatMessage var1);

	void handle(PacketOutTabComplete var1);

	void handle(PacketOutMultiBlockChange var1);

	void handle(PacketOutMap var1);

	void a(PacketOutConfirmTransaction var1);

	void handle(PacketOutCloseWindow var1);

	void handle(PacketOutWindowItems var1);

	void handle(PacketOutOpenWindow var1);

	void handle(PacketOutWindowProperty var1);

	void a(PacketOutSetSlot var1);

	void handle(PacketOutPluginMessage var1);

	void handle(PacketOutDisconnect var1);

	void handle(PacketOutUseBed var1);

	void handle(PacketOutEntityStatus var1);

	void handle(PacketOutAttachEntity var1);

	void handle(PacketOutExplosion var1);

	void a(PacketOutChangeGameState var1);

	void handle(PacketOutKeepAlive var1);

	void handle(PacketOutChunkData var1);

	void handle(PacketOutMapChunkBulk var1);

	void handle(PacketOutEffect var1);

	void handle(PacketOutJoinGame var1);

	void handle(PacketOutEntity var1);

	void handle(PacketOutPlayerPositionAndLook var1);

	void handle(PacketOutParticle var1);

	void handle(PacketOutPlayerAbilities var1);

	void handle(PacketOutListItem var1);

	void handle(PacketOutDestroyEntities var1);

	void handle(PacketOutRemoveEntityEffect var1);

	void handle(PacketOutRespawn var1);

	void handle(PacketOutEntityHeadLook var1);

	void handle(PacketOutHeldItemChange var1);

	void a(PacketOutDisplayScoreboard var1);

	void handle(PacketOutEntityMetadata var1);

	void handle(PacketOutEntityVelocity var1);

	void handle(PacketOutEntityEquipment var1);

	void handle(PacketOutSetExpirience var1);

	void handle(PacketOutUpdateHealth var1);

	void handle(PacketOutScoreboardTeam var1);

	void handle(PacketOutUpdateScore var1);

	void handle(PacketOutSpawnPosition var1);

	void handlePacket(PacketOutTimeUpdate var1);

	void handle(PacketOutUpdateSign var1);

	void handle(PacketOutSoundEffect var1);

	void handle(PacketOutCollectItem var1);

	void handle(PacketOutEntityTeleport var1);

	void handle(PacketOutEntityProperties var1);

	void handle(PacketOutEntityEffect var1);

	void handle(PacketOutCombatEvent var1);

	void handle(PacketOutServerDifficulty var1);

	void handle(PacketOutCamera var1);

	void handle(PacketOutWorldBorder var1);

	void a(lj var1);

	void a(jn var1);

	void a(lm var1);

	void a(ko var1);

	void a(jl var1);

}
