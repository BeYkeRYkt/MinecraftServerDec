package net.minecraft;

public class TileEntityLightDetector extends TileEntity implements ITickable {

	public void doTick() {
		if (this.world != null && !this.world.isStatic && this.world.getTime() % 20L == 0L) {
			this.e = this.getBlock();
			if (this.e instanceof BlockDaylightDetector) {
				((BlockDaylightDetector) this.e).d(this.world, this.position);
			}
		}

	}
}
