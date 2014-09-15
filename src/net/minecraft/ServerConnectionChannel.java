package net.minecraft;

import net.minecraft.util.io.netty.channel.Channel;
import net.minecraft.util.io.netty.channel.ChannelException;
import net.minecraft.util.io.netty.channel.ChannelInitializer;
import net.minecraft.util.io.netty.channel.ChannelOption;
import net.minecraft.util.io.netty.handler.timeout.ReadTimeoutHandler;

class ServerConnectionChannel extends ChannelInitializer<Channel> {

	final ServerConnection serverConnection;

	ServerConnectionChannel(ServerConnection var1) {
		this.serverConnection = var1;
	}

	protected void initChannel(Channel channel) {
		try {
			channel.config().setOption(ChannelOption.IP_TOS, Integer.valueOf(24));
		} catch (ChannelException ex) {
		}

		try {
			channel.config().setOption(ChannelOption.TCP_NODELAY, Boolean.valueOf(false));
		} catch (ChannelException ex) {
		}

		channel.pipeline()
			.addLast("timeout", new ReadTimeoutHandler(30))
			.addLast("legacy_query", new LegacyPingHandler(this.serverConnection))
			.addLast("splitter", new PacketSplitter())
			.addLast("decoder", new PacketDecoder(PacketDirection.SERVERBOUND))
			.addLast("prepender", new PacketPrepender())
			.addLast("encoder", new PacketEncoder(PacketDirection.CLIENTBOUND));
		NetworkManager networkManager = new NetworkManager(PacketDirection.SERVERBOUND);
		serverConnection.getNetworkManagers().add(networkManager);
		channel.pipeline().addLast("packet_handler", networkManager);
		networkManager.setPacketListener(new HandshakeListener(serverConnection.getMinecraftServer(), networkManager));
	}

}
