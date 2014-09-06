package net.minecraft;

public class TileEntityNote extends TileEntity {

	public byte a;
	public boolean f;

	public void write(NBTCompoundTag var1) {
		super.write(var1);
		var1.put("note", this.a);
	}

	public void read(NBTCompoundTag var1) {
		super.read(var1);
		this.a = var1.getByte("note");
		this.a = (byte) DataTypesConverter.a(this.a, 0, 24);
	}

	public void b() {
		this.a = (byte) ((this.a + 1) % 25);
		this.o_();
	}

	public void a(World var1, Position var2) {
		if (var1.p(var2.a()).getBlock().r() == Material.AIR) {
			Material var3 = var1.p(var2.b()).getBlock().r();
			byte var4 = 0;
			if (var3 == Material.STONE) {
				var4 = 1;
			}

			if (var3 == Material.SAND) {
				var4 = 2;
			}

			if (var3 == Material.SHATTERABLE) {
				var4 = 3;
			}

			if (var3 == Material.WOOD) {
				var4 = 4;
			}

			var1.c(var2, aty.B, var4, this.a);
		}
	}
}
