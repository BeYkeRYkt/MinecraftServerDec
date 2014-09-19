package net.minecraft;

import net.minecraft.util.com.mojang.authlib.GameProfile;
import java.util.UUID;

final class DispenseBehaviorSkull extends DispenseBehaviorItem {

	private boolean b = true;

	protected ItemStack b(ISourceBlock var1, ItemStack var2) {
		World var3 = var1.getWorld();
		BlockFace var4 = BlockDispenser.b(var1.getData());
		Position var5 = var1.getPosition().getRelative(var4);
		BlockSkull var6 = Blocks.SKULL;
		if (var3.d(var5) && var6.b(var3, var5, var2)) {
			if (!var3.isStatic) {
				var3.setBlockAt(var5, var6.getBlockState().a(BlockSkull.a, BlockFace.UP), 3);
				TileEntity var7 = var3.getTileEntity(var5);
				if (var7 instanceof TileEntitySkull) {
					if (var2.getWearout() == 3) {
						GameProfile var8 = null;
						if (var2.hasTag()) {
							NBTCompoundTag var9 = var2.getTag();
							if (var9.isTagAssignableFrom("SkullOwner", 10)) {
								var8 = GameProfileSerializer.deserialize(var9.getCompound("SkullOwner"));
							} else if (var9.isTagAssignableFrom("SkullOwner", 8)) {
								var8 = new GameProfile((UUID) null, var9.getString("SkullOwner"));
							}
						}

						((TileEntitySkull) var7).setGameProfile(var8);
					} else {
						((TileEntitySkull) var7).setSkullType(var2.getWearout());
					}

					((TileEntitySkull) var7).setRotation(var4.getOpposite().toDirection() * 4);
					Blocks.SKULL.a(var3, var5, (TileEntitySkull) var7);
				}

				--var2.amount;
			}
		} else {
			this.b = false;
		}

		return var2;
	}

	protected void a(ISourceBlock var1) {
		if (this.b) {
			var1.getWorld().triggerEffect(1000, var1.getPosition(), 0);
		} else {
			var1.getWorld().triggerEffect(1001, var1.getPosition(), 0);
		}

	}
}
