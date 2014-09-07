package net.minecraft;

class SecodaryWorldServerWorldBorderCahngeListener implements WorldBorderChangeListener {

	final SecondaryWorldServer worldServer;

	SecodaryWorldServerWorldBorderCahngeListener(SecondaryWorldServer worldServer) {
		this.worldServer = worldServer;
	}

	public void onSizeSet(WorldBorder worldborder, double size) {
		this.worldServer.getWorldBorder().setSize(size);
	}

	public void onSizeChange(WorldBorder worldborder, double oldRadius, double newRadius, long time) {
		this.worldServer.getWorldBorder().changeSize(oldRadius, newRadius, time);
	}

	public void onSetCenter(WorldBorder worldborder, double x, double z) {
		this.worldServer.getWorldBorder().setCenter(x, z);
	}

	public void onSetWarningTime(WorldBorder worldborder, int time) {
		this.worldServer.getWorldBorder().setWarningTime(time);
	}

	public void onSetWarningBlocks(WorldBorder worldborder, int blocks) {
		this.worldServer.getWorldBorder().setWarningBlocks(blocks);
	}

	public void onSetDamageAmount(WorldBorder worldborder, double damage) {
		this.worldServer.getWorldBorder().setDamageAmount(damage);
	}

	public void onSetDamageBuffer(WorldBorder worldborder, double buffer) {
		this.worldServer.getWorldBorder().setDamageBuffer(buffer);
	}

}
