package net.minecraft;

public class TileEntityLightDetector extends TileEntity implements PacketTickable {

	public void doTick() {
		if (this.world != null && !this.world.D && this.world.K() % 20L == 0L) {
			this.e = this.getBlock();
			if (this.e instanceof BlockDaylightDetector) {
				((BlockDaylightDetector) this.e).d(this.world, this.position);
			}
		}

	}
}
