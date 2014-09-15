package net.minecraft;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import net.minecraft.server.MinecraftServer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServerConnection {

	private static final Logger logger = LogManager.getLogger();
	public static final ConnectionNioEventLoopGroup serverConnectionEventGroup = new ServerConnectionNioEventLoopGroup();

	public volatile boolean open;
	private final MinecraftServer minecraftserver;
	private final List<ChannelFuture> channels = Collections.synchronizedList(new ArrayList<ChannelFuture>());
	private final List<NetworkManager> networkManagers = Collections.synchronizedList(new ArrayList<NetworkManager>());

	public ServerConnection(MinecraftServer minecraftserver) {
		this.minecraftserver = minecraftserver;
		this.open = true;
	}

	public void bindToPort(InetAddress itenAddress, int port) {
		synchronized (channels) { 
			this.channels.add((((new ServerBootstrap()).channel(NioServerSocketChannel.class)).childHandler(new ServerConnectionChannel(this)).group(serverConnectionEventGroup.getGroup()).localAddress(itenAddress, port)).bind().syncUninterruptibly());
		}
	}

	public void closeChannels() {
		this.open = false;
		for (ChannelFuture channelFuture : channels) {
			try {
				channelFuture.channel().close().sync();
			} catch (InterruptedException var4) {
				logger.error("Interrupted whilst closing channel");
			}
		}
	}

	public void doTick() {
		synchronized (this.networkManagers) {
			Iterator<NetworkManager> iterator = this.networkManagers.iterator();
			while (iterator.hasNext()) {
				NetworkManager networkmanager = iterator.next();
				if (!networkmanager.hasChannel()) {
					if (!networkmanager.isConnected()) {
						iterator.remove();
						networkmanager.closeChannel();
					} else {
						try {
							networkmanager.sendAndFlushQueuedPacket();
						} catch (Exception ex) {
							if (networkmanager.isLocal()) {
								CrashReport crashReport = CrashReport.generateCrashReport(ex, "Ticking memory connection");
								CrashReportSystemDetails crashReportDetails = crashReport.generateSystemDetails("Ticking connection");
								crashReportDetails.addDetails("Connection", (new CrashReportServerConnection(networkmanager)));
								throw new ReportedException(crashReport);
							}

							logger.warn("Failed to handle packet for " + networkmanager.getAddress(), (Throwable) ex);
							ChatComponentText text = new ChatComponentText("Internal server error");
							networkmanager.handleSendPacket(new PacketPlayOutDisconnect(text), new ServerConnectionFuture(networkmanager, text));
							networkmanager.disableAutoRead();
						}
					}
				}
			}

		}
	}

	public MinecraftServer getMinecraftServer() {
		return this.minecraftserver;
	}

	protected List<NetworkManager> getNetworkManagers() {
		return networkManagers;
	}

}
