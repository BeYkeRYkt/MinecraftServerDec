package net.minecraft;

public interface PlayInPacketListener extends PacketListener {

	void handle(PacketPlayInAnimation packet);

	void handle(PacketPlayInChatMessage packet);

	void handle(PacketPlayInTabComplete packet);

	void handle(PacketPlayInClientStatus packet);

	void handle(PacketPlayInClientSettings packet);

	void handle(PacketPlayInConfirmTransaction packet);

	void handle(PacketPlayInEnchantItem packet);

	void handle(PacketPlayInClickWindow packet);

	void handle(PacketPlayInCloseWindow packet);

	void handle(PacketPlayInPluginMessage packet);

	void handle(PacketPlayInUseEntity packet);

	void handle(PacketPlayInKeepAlive packet);

	void handle(PacketPlayInPlayer packet);

	void handle(PacketPlayInPlayAbilities packet);

	void handle(PacketPlayInPlayerDigging packet);

	void handle(PacketPlayInEntityAction packet);

	void handle(PacketPlayInSteerVehicle packet);

	void handle(PacketPlayInHeldItemChange packet);

	void handle(PacketPlayInCreativeInventoryAction packet);

	void handle(PacketPlayInUpdateSign packet);

	void handle(PacketPlayInBlockPlace packet);

	void handle(PacketPlayInSpectate packet);

	void handle(PacketPlayInResourcePackStatus packet);

}
