package net.minecraft;

import com.google.common.collect.Lists;
import java.util.List;

public class BlockNote extends atg {

	private static final List a = Lists.newArrayList((Object[]) (new String[] { "harp", "bd", "snare", "hat", "bassattack" }));

	public BlockNote() {
		super(Material.WOOD);
		this.a(CreativeModeTab.REDSTONE);
	}

	public void a(World var1, Position var2, IBlockState var3, Block var4) {
		boolean var5 = var1.z(var2);
		TileEntity var6 = var1.getTileEntity(var2);
		if (var6 instanceof TileEntityNote) {
			TileEntityNote var7 = (TileEntityNote) var6;
			if (var7.f != var5) {
				if (var5) {
					var7.a(var1, var2);
				}

				var7.f = var5;
			}
		}

	}

	public boolean a(World var1, Position var2, IBlockState var3, EntityHuman var4, BlockFace var5, float var6, float var7, float var8) {
		if (var1.isStatic) {
			return true;
		} else {
			TileEntity var9 = var1.getTileEntity(var2);
			if (var9 instanceof TileEntityNote) {
				TileEntityNote var10 = (TileEntityNote) var9;
				var10.b();
				var10.a(var1, var2);
			}

			return true;
		}
	}

	public void a(World var1, Position var2, EntityHuman var3) {
		if (!var1.isStatic) {
			TileEntity var4 = var1.getTileEntity(var2);
			if (var4 instanceof TileEntityNote) {
				((TileEntityNote) var4).a(var1, var2);
			}

		}
	}

	public TileEntity a(World var1, int var2) {
		return new TileEntityNote();
	}

	private String b(int var1) {
		if (var1 < 0 || var1 >= a.size()) {
			var1 = 0;
		}

		return (String) a.get(var1);
	}

	public boolean a(World var1, Position var2, IBlockState var3, int var4, int var5) {
		float var6 = (float) Math.pow(2.0D, (double) (var5 - 12) / 12.0D);
		var1.makeSound((double) var2.getX() + 0.5D, (double) var2.getY() + 0.5D, (double) var2.getZ() + 0.5D, "note." + this.b(var4), 3.0F, var6);
		var1.addParticle(Particle.x, (double) var2.getX() + 0.5D, (double) var2.getY() + 1.2D, (double) var2.getZ() + 0.5D, (double) var5 / 24.0D, 0.0D, 0.0D, new int[0]);
		return true;
	}

	public int b() {
		return 3;
	}

}
