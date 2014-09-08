package net.minecraft;

public interface PlayInPacketListener extends PacketListener {

	void a(mv packet);

	void handle(PacketPlayInChatMessage packet);

	void a(lt packet);

	void a(lv packet);

	void a(lx packet);

	void a(ly packet);

	void a(lz packet);

	void a(ma packet);

	void a(mb packet);

	void a(mc packet);

	void handle(PacketPlayInUseEntity packet);

	void handle(PacketPlayInKeepAlive packet);

	void handle(PacketPlayInPlayer packet);

	void a(mk packet);

	void handle(PacketPlayInPlayerDigging packet);

	void a(mn packet);

	void a(mp packet);

	void a(ms packet);

	void a(mt packet);

	void a(mu packet);

	void handle(PacketPlayInBlockPlace packet);

	void a(mw packet);

	void a(mq packet);

}
