package net.minecraft;

import java.io.IOException;

public class jl implements id<ik> {

	private int a;
	private NBTCompoundTag b;

	public jl() {
	}

	public jl(int var1, NBTCompoundTag var2) {
		this.a = var1;
		this.b = var2;
	}

	public void a(hd var1) throws IOException {
		this.a = var1.e();
		this.b = var1.h();
	}

	public void b(hd var1) {
		var1.b(this.a);
		var1.a(this.b);
	}

	public void a(ik var1) {
		var1.a(this);
	}
}
