package net.minecraft;

import net.minecraft.PacketOutWorldBorder.WorldBorderAction;

class PlayerUpdaterWorldBorderChangeListener implements WorldBorderChangeListener {

	final PlayerList playerList;

	PlayerUpdaterWorldBorderChangeListener(PlayerList playerList) {
		this.playerList = playerList;
	}

	public void onSizeSet(WorldBorder worldborder, double size) {
		this.playerList.sendPacket(new PacketOutWorldBorder(worldborder, WorldBorderAction.SET_SIZE));
	}

	public void onSizeChange(WorldBorder worldborder, double oldRadius, double newRadius, long time) {
		this.playerList.sendPacket(new PacketOutWorldBorder(worldborder, WorldBorderAction.LERP_SIZE));
	}

	public void onSetCenter(WorldBorder worldborder, double x, double z) {
		this.playerList.sendPacket(new PacketOutWorldBorder(worldborder, WorldBorderAction.SET_CENTER));
	}

	public void onSetWarningTime(WorldBorder worldborder, int time) {
		this.playerList.sendPacket(new PacketOutWorldBorder(worldborder, WorldBorderAction.SET_WARNING_TIME));
	}

	public void onSetWarningBlocks(WorldBorder worldborder, int blocks) {
		this.playerList.sendPacket(new PacketOutWorldBorder(worldborder, WorldBorderAction.SET_WARNING_BLOCKS));
	}

	public void onSetDamageAmount(WorldBorder worldborder, double damage) {
	}

	public void onSetDamageBuffer(WorldBorder worldborder, double buffer) {
	}

}
