package net.minecraft;

import com.google.common.base.Function;

public class ItemMultiTexture extends ItemBlock {

	protected final Block block;
	protected final Function<ItemStack, String> function;

	public ItemMultiTexture(Block block, Block var2, Function<ItemStack, String> var3) {
		super(block);
		this.block = var2;
		this.function = var3;
		this.setDurability(0);
		this.a(true);
	}

	public ItemMultiTexture(Block block1, Block block2, final String[] textures) {
		this(block1, block2, new Function<ItemStack, String>() {
			@Override
			public String apply(ItemStack item) {
				int data = item.i();
				if (data < 0 || data >= textures.length) {
					data = 0;
				}

				return textures[data];
			}
		});
	}

	public int a(int var1) {
		return var1;
	}

	public String getName(ItemStack var1) {
		return super.getName() + "." + (String) this.function.apply(var1);
	}

}
