package net.minecraft;

import java.util.List;
import java.util.Random;

public class BlockPistonExtension extends Block {

	public static final beu a = beu.a("facing");
	public static final bev b = bev.a("type", bdu.class);
	public static final bet M = bet.a("short");

	public BlockPistonExtension() {
		super(Material.PISTON);
		this.j(this.L.b().a(a, BlockFace.c).a(b, bdu.a).a(M, Boolean.valueOf(false)));
		this.a(i);
		this.c(0.5F);
	}

	public void a(World var1, Position var2, bec var3, EntityHuman var4) {
		if (var4.by.instabuild) {
			BlockFace var5 = (BlockFace) var3.b(a);
			if (var5 != null) {
				Position var6 = var2.a(var5.d());
				Block var7 = var1.p(var6).getBlock();
				if (var7 == Blocks.PISTON || var7 == Blocks.STICKY_PISTON) {
					var1.g(var6);
				}
			}
		}

		super.a(var1, var2, var3, var4);
	}

	public void b(World var1, Position var2, bec var3) {
		super.b(var1, var2, var3);
		BlockFace var4 = ((BlockFace) var3.b(a)).d();
		var2 = var2.a(var4);
		bec var5 = var1.p(var2);
		if ((var5.getBlock() == Blocks.PISTON || var5.getBlock() == Blocks.STICKY_PISTON) && ((Boolean) var5.b(BlockPiston.b)).booleanValue()) {
			var5.getBlock().b(var1, var2, var5, 0);
			var1.g(var2);
		}

	}

	public boolean c() {
		return false;
	}

	public boolean d() {
		return false;
	}

	public boolean c(World var1, Position var2) {
		return false;
	}

	public boolean a(World var1, Position var2, BlockFace var3) {
		return false;
	}

	public int a(Random var1) {
		return 0;
	}

	public void a(World var1, Position var2, bec var3, AxisAlignedBB var4, List var5, Entity var6) {
		this.d(var3);
		super.a(var1, var2, var3, var4, var5, var6);
		this.e(var3);
		super.a(var1, var2, var3, var4, var5, var6);
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	private void e(bec var1) {
		float var2 = 0.25F;
		float var3 = 0.375F;
		float var4 = 0.625F;
		float var5 = 0.25F;
		float var6 = 0.75F;
		switch (bdt.a[((BlockFace) var1.b(a)).ordinal()]) {
			case 1:
				this.a(0.375F, 0.25F, 0.375F, 0.625F, 1.0F, 0.625F);
				break;
			case 2:
				this.a(0.375F, 0.0F, 0.375F, 0.625F, 0.75F, 0.625F);
				break;
			case 3:
				this.a(0.25F, 0.375F, 0.25F, 0.75F, 0.625F, 1.0F);
				break;
			case 4:
				this.a(0.25F, 0.375F, 0.0F, 0.75F, 0.625F, 0.75F);
				break;
			case 5:
				this.a(0.375F, 0.25F, 0.25F, 0.625F, 0.75F, 1.0F);
				break;
			case 6:
				this.a(0.0F, 0.375F, 0.25F, 0.75F, 0.625F, 0.75F);
		}

	}

	public void a(ard var1, Position var2) {
		this.d(var1.p(var2));
	}

	public void d(bec var1) {
		float var2 = 0.25F;
		BlockFace var3 = (BlockFace) var1.b(a);
		if (var3 != null) {
			switch (bdt.a[var3.ordinal()]) {
				case 1:
					this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
					break;
				case 2:
					this.a(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
					break;
				case 3:
					this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
					break;
				case 4:
					this.a(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
					break;
				case 5:
					this.a(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
					break;
				case 6:
					this.a(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			}

		}
	}

	public void a(World var1, Position var2, bec var3, Block var4) {
		BlockFace var5 = (BlockFace) var3.b(a);
		Position var6 = var2.a(var5.d());
		bec var7 = var1.p(var6);
		if (var7.getBlock() != Blocks.PISTON && var7.getBlock() != Blocks.STICKY_PISTON) {
			var1.g(var2);
		} else {
			var7.getBlock().a(var1, var6, var7, var4);
		}

	}

	public static BlockFace b(int var0) {
		int var1 = var0 & 7;
		return var1 > 5 ? null : BlockFace.a(var1);
	}

	public bec a(int var1) {
		return this.P().a(a, b(var1)).a(b, (var1 & 8) > 0 ? bdu.b : bdu.a);
	}

	public int c(bec var1) {
		byte var2 = 0;
		int var3 = var2 | ((BlockFace) var1.b(a)).a();
		if (var1.b(b) == bdu.b) {
			var3 |= 8;
		}

		return var3;
	}

	protected bed e() {
		return new bed(this, new bex[] { a, b, M });
	}

}
