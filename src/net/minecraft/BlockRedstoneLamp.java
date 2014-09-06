package net.minecraft;

import java.util.Random;

public class BlockRedstoneLamp extends Block {

	private final boolean a;

	public BlockRedstoneLamp(boolean var1) {
		super(Material.BUILDABLE_GLASS);
		this.a = var1;
		if (var1) {
			this.a(1.0F);
		}

	}

	public void c(World var1, Position var2, bec var3) {
		if (!var1.D) {
			if (this.a && !var1.z(var2)) {
				var1.a(var2, Blocks.bJ.P(), 2);
			} else if (!this.a && var1.z(var2)) {
				var1.a(var2, Blocks.bK.P(), 2);
			}

		}
	}

	public void a(World var1, Position var2, bec var3, Block var4) {
		if (!var1.D) {
			if (this.a && !var1.z(var2)) {
				var1.a(var2, (Block) this, 4);
			} else if (!this.a && var1.z(var2)) {
				var1.a(var2, Blocks.bK.P(), 2);
			}

		}
	}

	public void b(World var1, Position var2, bec var3, Random var4) {
		if (!var1.D) {
			if (this.a && !var1.z(var2)) {
				var1.a(var2, Blocks.bJ.P(), 2);
			}

		}
	}

	public Item a(bec var1, Random var2, int var3) {
		return Item.getItemOf(Blocks.bJ);
	}

	protected ItemStack i(bec var1) {
		return new ItemStack(Blocks.bJ);
	}
}
