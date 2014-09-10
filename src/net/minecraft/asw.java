package net.minecraft;

public class asw extends ary {

	protected bhp M;

	public asw() {
		this.M = new bim(Blocks.END_STONE);
	}

	protected void a(BiomeBase var1) {
		this.a();
		if (this.b.nextInt(5) == 0) {
			int var2 = this.b.nextInt(16) + 8;
			int var3 = this.b.nextInt(16) + 8;
			this.M.b(this.a, this.b, this.a.r(this.c.a(var2, 0, var3)));
		}

		if (this.c.getX() == 0 && this.c.getZ() == 0) {
			EntityEnderDragon var4 = new EntityEnderDragon(this.a);
			var4.setPositionRotation(0.0D, 128.0D, 0.0D, this.b.nextFloat() * 360.0F, 0.0F);
			this.a.d((Entity) var4);
		}

	}
}
