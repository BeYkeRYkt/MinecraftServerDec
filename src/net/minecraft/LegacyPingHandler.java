package net.minecraft;

import com.google.common.base.Charsets;
import net.minecraft.util.io.netty.buffer.ByteBuf;
import net.minecraft.util.io.netty.buffer.Unpooled;
import net.minecraft.util.io.netty.channel.ChannelFutureListener;
import net.minecraft.util.io.netty.channel.ChannelHandlerContext;
import net.minecraft.util.io.netty.channel.ChannelInboundHandlerAdapter;
import java.net.InetSocketAddress;
import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LegacyPingHandler extends ChannelInboundHandlerAdapter {

	private static final Logger logger = LogManager.getLogger();

	private ServerConnection serverConnection;

	public LegacyPingHandler(ServerConnection serverConnection) {
		this.serverConnection = serverConnection;
	}

	public void channelRead(ChannelHandlerContext ctx, Object obj) {
		ByteBuf buf = (ByteBuf) obj;
		buf.markReaderIndex();
		boolean flag = true;

		try {
			try {
				if (buf.readUnsignedByte() != 254) {
					return;
				}

				InetSocketAddress address = (InetSocketAddress) ctx.channel().remoteAddress();
				MinecraftServer minecraftserver = this.serverConnection.getMinecraftServer();
				int length = buf.readableBytes();
				String response;
				switch (length) {
					case 0: {
						logger.debug("Ping: (<1.3.x) from {}:{}", new Object[] { address.getAddress(), address.getPort() });
						response = String.format("%s§%d§%d", new Object[] { minecraftserver.getMotd(), minecraftserver.getOnlinePlayersCount(), minecraftserver.getMaxPlayers() });
						break;
					}
					case 1: {
						if (buf.readUnsignedByte() != 1) {
							return;
						}

						logger.debug("Ping: (1.4-1.5.x) from {}:{}", new Object[] { address.getAddress(), address.getPort() });
						response = String.format("§1 %d %s %s %d %d", new Object[] { 127, minecraftserver.getGameVersion(), minecraftserver.getMotd(), minecraftserver.getOnlinePlayersCount(), minecraftserver.getMaxPlayers() });
						this.sendResponse(ctx, this.toByteBuf(response));
						break;
					}
					default: {
						boolean is16 = buf.readUnsignedByte() == 1;
						is16 &= buf.readUnsignedByte() == 250;
						is16 &= "MC|PingHost".equals(new String(buf.readBytes(buf.readShort() * 2).array(), Charsets.UTF_16BE));
						int s = buf.readUnsignedShort();
						is16 &= buf.readUnsignedByte() >= 73;
						is16 &= 3 + buf.readBytes(buf.readShort() * 2).array().length + 4 == s;
						is16 &= buf.readInt() <= '\uffff';
						is16 &= buf.readableBytes() == 0;
						if (!is16) {
							break;
						}

						logger.debug("Ping: (1.6) from {}:{}", new Object[] { address.getAddress(), Integer.valueOf(address.getPort()) });
						response = String.format("§1 %d %s %s %d %d", new Object[] { Integer.valueOf(127), minecraftserver.getGameVersion(), minecraftserver.getMotd(), Integer.valueOf(minecraftserver.getOnlinePlayersCount()), Integer.valueOf(minecraftserver.getMaxPlayers()) });
					}
					if (response != null) {
						ByteBuf responseByteBuf = this.toByteBuf(response);
						try {
							this.sendResponse(ctx, responseByteBuf);
						} finally {
							responseByteBuf.release();
						}
					}
				}

				buf.release();
				flag = false;
			} catch (RuntimeException ex) {
			}

		} finally {
			if (flag) {
				buf.resetReaderIndex();
				ctx.channel().pipeline().remove("legacy_query");
				ctx.fireChannelRead(obj);
			}
		}
	}

	private void sendResponse(ChannelHandlerContext ctx, ByteBuf byteBuf) {
		ctx.pipeline().firstContext().writeAndFlush(byteBuf).addListener(ChannelFutureListener.CLOSE);
	}

	private ByteBuf toByteBuf(String string) {
		ByteBuf byteBuf = Unpooled.buffer();
		byteBuf.writeByte(255);
		char[] chars = string.toCharArray();
		byteBuf.writeShort(chars.length);
		for (char c : chars) {
			byteBuf.writeChar(c);
		}
		return byteBuf;
	}

}
