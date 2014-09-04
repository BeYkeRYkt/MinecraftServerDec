package net.minecraft;

public class ajh extends wa {

	private bda a;

	public ajh() {
		super("container.enderchest", false, 27);
	}

	public void a(bda var1) {
		this.a = var1;
	}

	public void a(NBTListTag var1) {
		int var2;
		for (var2 = 0; var2 < this.n_(); ++var2) {
			this.a(var2, (amj) null);
		}

		for (var2 = 0; var2 < var1.getSize(); ++var2) {
			NBTCompoundTag var3 = var1.getCompound(var2);
			int var4 = var3.d("Slot") & 255;
			if (var4 >= 0 && var4 < this.n_()) {
				this.a(var4, amj.a(var3));
			}
		}

	}

	public NBTListTag h() {
		NBTListTag var1 = new NBTListTag();

		for (int var2 = 0; var2 < this.n_(); ++var2) {
			amj var3 = this.a(var2);
			if (var3 != null) {
				NBTCompoundTag var4 = new NBTCompoundTag();
				var4.put("Slot", (byte) var2);
				var3.b(var4);
				var1.addTag((NBTTag) var4);
			}
		}

		return var1;
	}

	public boolean a(ahd var1) {
		return this.a != null && !this.a.a(var1) ? false : super.a(var1);
	}

	public void b(ahd var1) {
		if (this.a != null) {
			this.a.b();
		}

		super.b(var1);
	}

	public void c(ahd var1) {
		if (this.a != null) {
			this.a.d();
		}

		super.c(var1);
		this.a = null;
	}
}
