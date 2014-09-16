package net.minecraft;

public class TileEntityLightDetector extends TileEntity implements ITickable {

	public void doTick() {
		if (this.world != null && !this.world.isStatic && this.world.getTime() % 20L == 0L) {
			this.chestBlock = this.getBlock();
			if (this.chestBlock instanceof BlockDaylightDetector) {
				((BlockDaylightDetector) this.chestBlock).d(this.world, this.position);
			}
		}

	}
}
