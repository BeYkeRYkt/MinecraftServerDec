package net.minecraft;

public class bdi extends bcm {

	public byte a;
	public boolean f;

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.put("note", this.a);
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.a = var1.d("note");
		this.a = (byte) NumberConverter.a(this.a, 0, 24);
	}

	public void b() {
		this.a = (byte) ((this.a + 1) % 25);
		this.o_();
	}

	public void a(World var1, dt var2) {
		if (var1.p(var2.a()).c().r() == bof.a) {
			bof var3 = var1.p(var2.b()).c().r();
			byte var4 = 0;
			if (var3 == bof.e) {
				var4 = 1;
			}

			if (var3 == bof.p) {
				var4 = 2;
			}

			if (var3 == bof.s) {
				var4 = 3;
			}

			if (var3 == bof.d) {
				var4 = 4;
			}

			var1.c(var2, aty.B, var4, this.a);
		}
	}
}
