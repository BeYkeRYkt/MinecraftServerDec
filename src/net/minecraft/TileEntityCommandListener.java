package net.minecraft;

class TileEntityCommandListener extends CommandBlockListenerAbstract {

	final TileEntityCommand tileEntity;

	TileEntityCommandListener(TileEntityCommand tileEntity) {
		this.tileEntity = tileEntity;
	}

	public Position getEntityPosition() {
		return this.tileEntity.position;
	}

	public Vec3D getCenter() {
		return new Vec3D((double) this.tileEntity.position.getX() + 0.5D, (double) this.tileEntity.position.getY() + 0.5D, (double) this.tileEntity.position.getZ() + 0.5D);
	}

	public World getPrimaryWorld() {
		return this.tileEntity.getPrimaryWorld();
	}

	public void setCommand(String var1) {
		super.setCommand(var1);
		this.tileEntity.update();
	}

	public void updateEntity() {
		this.tileEntity.getPrimaryWorld().notify(this.tileEntity.position);
	}

	public Entity getEntity() {
		return null;
	}

}
