package net.minecraft;

import io.netty.buffer.ByteBuf;
import java.io.IOException;

public class ji implements id<ik> {

	private String a;
	private hd b;

	public ji() {
	}

	public ji(String var1, hd var2) {
		this.a = var1;
		this.b = var2;
		if (var2.writerIndex() > 1048576) {
			throw new IllegalArgumentException("Payload may not be larger than 1048576 bytes");
		}
	}

	public void a(hd var1) throws IOException {
		this.a = var1.c(20);
		int var2 = var1.readableBytes();
		if (var2 >= 0 && var2 <= 1048576) {
			this.b = new hd(var1.readBytes(var2));
		} else {
			throw new IOException("Payload may not be larger than 1048576 bytes");
		}
	}

	public void b(hd var1) {
		var1.a(this.a);
		var1.writeBytes((ByteBuf) this.b);
	}

	public void a(ik var1) {
		var1.a(this);
	}
}
