package net.minecraft;

public class WorldGenFlatLayerInfo {

	private final int a;
	private BlockState b;
	private int c;
	private int d;

	public WorldGenFlatLayerInfo(int var1, Block var2) {
		this(3, var1, var2);
	}

	public WorldGenFlatLayerInfo(int var1, int var2, Block var3) {
		this.c = 1;
		this.a = var1;
		this.c = var2;
		this.b = var3.getBlockState();
	}

	public WorldGenFlatLayerInfo(int var1, int var2, Block var3, int var4) {
		this(var1, var2, var3);
		this.b = var3.a(var4);
	}

	public int b() {
		return this.c;
	}

	public BlockState c() {
		return this.b;
	}

	private Block e() {
		return this.b.getBlock();
	}

	private int f() {
		return this.b.getBlock().c(this.b);
	}

	public int d() {
		return this.d;
	}

	public void b(int var1) {
		this.d = var1;
	}

	public String toString() {
		String var1;
		if (this.a >= 3) {
			RegistryObjectName var2 = (RegistryObjectName) Block.BLOCKREGISTRY.c(this.e());
			var1 = var2 == null ? "null" : var2.toString();
			if (this.c > 1) {
				var1 = this.c + "*" + var1;
			}
		} else {
			var1 = Integer.toString(Block.getBlockId(this.e()));
			if (this.c > 1) {
				var1 = this.c + "x" + var1;
			}
		}

		int var3 = this.f();
		if (var3 > 0) {
			var1 = var1 + ":" + var3;
		}

		return var1;
	}
}
