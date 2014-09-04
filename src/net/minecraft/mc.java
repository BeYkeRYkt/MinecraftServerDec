package net.minecraft;

import io.netty.buffer.ByteBuf;
import java.io.IOException;

public class mc implements id<ls> {

	private String a;
	private hd b;

	public void a(hd var1) throws IOException {
		this.a = var1.c(20);
		int var2 = var1.readableBytes();
		if (var2 >= 0 && var2 <= 32767) {
			this.b = new hd(var1.readBytes(var2));
		} else {
			throw new IOException("Payload may not be larger than 32767 bytes");
		}
	}

	public void b(hd var1) {
		var1.a(this.a);
		var1.writeBytes((ByteBuf) this.b);
	}

	public void a(ls var1) {
		var1.a(this);
	}

	public String a() {
		return this.a;
	}

	public hd b() {
		return this.b;
	}
}
