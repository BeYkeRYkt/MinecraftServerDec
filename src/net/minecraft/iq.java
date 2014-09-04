package net.minecraft;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class iq implements id<ik> {

	private int a;
	private UUID b;
	private int c;
	private int d;
	private int e;
	private byte f;
	private byte g;
	private int h;
	private xv i;
	private List j;

	public iq() {
	}

	public iq(ahd var1) {
		this.a = var1.F();
		this.b = var1.cc().getId();
		this.c = NumberConverter.c(var1.s * 32.0D);
		this.d = NumberConverter.c(var1.t * 32.0D);
		this.e = NumberConverter.c(var1.u * 32.0D);
		this.f = (byte) ((int) (var1.y * 256.0F / 360.0F));
		this.g = (byte) ((int) (var1.z * 256.0F / 360.0F));
		amj var2 = var1.bg.h();
		this.h = var2 == null ? 0 : alq.b(var2.b());
		this.i = var1.H();
	}

	public void a(hd var1) throws IOException {
		this.a = var1.e();
		this.b = var1.g();
		this.c = var1.readInt();
		this.d = var1.readInt();
		this.e = var1.readInt();
		this.f = var1.readByte();
		this.g = var1.readByte();
		this.h = var1.readShort();
		this.j = xv.b(var1);
	}

	public void b(hd var1) {
		var1.b(this.a);
		var1.a(this.b);
		var1.writeInt(this.c);
		var1.writeInt(this.d);
		var1.writeInt(this.e);
		var1.writeByte(this.f);
		var1.writeByte(this.g);
		var1.writeShort(this.h);
		this.i.a(var1);
	}

	public void a(ik var1) {
		var1.a(this);
	}
}
