package net.minecraft;

public class TileEntityLightDetector extends TileEntity implements ITickable {

	public void doTick() {
		if (this.world != null && !this.world.isStatic && this.world.getTime() % 20L == 0L) {
			this.block = this.getBlock();
			if (this.block instanceof BlockDaylightDetector) {
				((BlockDaylightDetector) this.block).d(this.world, this.position);
			}
		}

	}
}
