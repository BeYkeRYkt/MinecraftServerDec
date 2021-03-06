package net.minecraft;

public class ayz {

	private final World a;
	private final el b;
	private final BlockFace c;
	private final BlockFace d;
	private int e = 0;
	private Position f;
	private int g;
	private int h;

	public ayz(World var1, Position var2, el var3) {
		this.a = var1;
		this.b = var3;
		if (var3 == el.a) {
			this.d = BlockFace.EAST;
			this.c = BlockFace.WEST;
		} else {
			this.d = BlockFace.NORTH;
			this.c = BlockFace.SOUTH;
		}

		for (Position var4 = var2; var2.getY() > var4.getY() - 21 && var2.getY() > 0 && this.a(var1.getBlockState(var2.getDown()).getBlock()); var2 = var2.getDown()) {
			;
		}

		int var5 = this.a(var2, this.d) - 1;
		if (var5 >= 0) {
			this.f = var2.getRelative(this.d, var5);
			this.h = this.a(this.f, this.c);
			if (this.h < 2 || this.h > 21) {
				this.f = null;
				this.h = 0;
			}
		}

		if (this.f != null) {
			this.g = this.a();
		}

	}

	protected int a(Position var1, BlockFace var2) {
		int var3;
		for (var3 = 0; var3 < 22; ++var3) {
			Position var4 = var1.getRelative(var2, var3);
			if (!this.a(this.a.getBlockState(var4).getBlock()) || this.a.getBlockState(var4.getDown()).getBlock() != Blocks.OBSIDIAN) {
				break;
			}
		}

		Block var5 = this.a.getBlockState(var1.getRelative(var2, var3)).getBlock();
		return var5 == Blocks.OBSIDIAN ? var3 : 0;
	}

	protected int a() {
		int var1;
		label56: for (this.g = 0; this.g < 21; ++this.g) {
			for (var1 = 0; var1 < this.h; ++var1) {
				Position var2 = this.f.getRelative(this.c, var1).getUp(this.g);
				Block var3 = this.a.getBlockState(var2).getBlock();
				if (!this.a(var3)) {
					break label56;
				}

				if (var3 == Blocks.PORTAL) {
					++this.e;
				}

				if (var1 == 0) {
					var3 = this.a.getBlockState(var2.getRelative(this.d)).getBlock();
					if (var3 != Blocks.OBSIDIAN) {
						break label56;
					}
				} else if (var1 == this.h - 1) {
					var3 = this.a.getBlockState(var2.getRelative(this.c)).getBlock();
					if (var3 != Blocks.OBSIDIAN) {
						break label56;
					}
				}
			}
		}

		for (var1 = 0; var1 < this.h; ++var1) {
			if (this.a.getBlockState(this.f.getRelative(this.c, var1).getUp(this.g)).getBlock() != Blocks.OBSIDIAN) {
				this.g = 0;
				break;
			}
		}

		if (this.g <= 21 && this.g >= 3) {
			return this.g;
		} else {
			this.f = null;
			this.h = 0;
			this.g = 0;
			return 0;
		}
	}

	protected boolean a(Block var1) {
		return var1.material == Material.AIR || var1 == Blocks.FIRE || var1 == Blocks.PORTAL;
	}

	public boolean b() {
		return this.f != null && this.h >= 2 && this.h <= 21 && this.g >= 3 && this.g <= 21;
	}

	public void c() {
		for (int var1 = 0; var1 < this.h; ++var1) {
			Position var2 = this.f.getRelative(this.c, var1);

			for (int var3 = 0; var3 < this.g; ++var3) {
				this.a.setBlockAt(var2.getUp(var3), Blocks.PORTAL.getBlockState().a(BlockPortal.a, this.b), 2);
			}
		}

	}

	// $FF: synthetic method
	static int a(ayz var0) {
		return var0.e;
	}

	// $FF: synthetic method
	static int b(ayz var0) {
		return var0.h;
	}

	// $FF: synthetic method
	static int c(ayz var0) {
		return var0.g;
	}
}
