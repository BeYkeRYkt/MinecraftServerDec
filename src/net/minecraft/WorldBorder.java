package net.minecraft;

import com.google.common.collect.Lists;
import java.util.List;

public class WorldBorder {

	private final List<WorldBorderChangeListener> listeners = Lists.newArrayList();
	private double x = 0.0D;
	private double z = 0.0D;
	private double oldRadius = 6.0E7D;
	private double currentRadius;
	private long lerpEndTime;
	private long lerpStartTime;
	private int portalTeleportBoundary;
	private double damageAmount;
	private double damageBuffer;
	private int warningTime;
	private int warningBlocks;

	public WorldBorder() {
		this.currentRadius = this.oldRadius;
		this.portalTeleportBoundary = 29999984;
		this.damageAmount = 0.2D;
		this.damageBuffer = 5.0D;
		this.warningTime = 15;
		this.warningBlocks = 5;
	}

	public boolean a(Position var1) {
		return (double) (var1.getX() + 1) > this.b() && (double) var1.getX() < this.d() && (double) (var1.getZ() + 1) > this.c() && (double) var1.getZ() < this.e();
	}

	public boolean a(ChunkCoordIntPair var1) {
		return (double) var1.getBlockMaxX() > this.b() && (double) var1.getBlockMinX() < this.d() && (double) var1.getBlockMaxZ() > this.c() && (double) var1.getBlockMinZ() < this.e();
	}

	public boolean a(brt var1) {
		return var1.d > this.b() && var1.a < this.d() && var1.f > this.c() && var1.c < this.e();
	}

	public double a(Entity var1) {
		return this.b(var1.locationX, var1.locationZ);
	}

	public double b(double var1, double var3) {
		double var5 = var3 - this.c();
		double var7 = this.e() - var3;
		double var9 = var1 - this.b();
		double var11 = this.d() - var1;
		double var13 = Math.min(var9, var11);
		var13 = Math.min(var13, var5);
		return Math.min(var13, var7);
	}

	public bfa a() {
		return this.currentRadius < this.oldRadius ? bfa.b : (this.currentRadius > this.oldRadius ? bfa.a : bfa.c);
	}

	public double b() {
		double var1 = this.getX() - this.getOldRadius() / 2.0D;
		if (var1 < (double) (-this.portalTeleportBoundary)) {
			var1 = (double) (-this.portalTeleportBoundary);
		}

		return var1;
	}

	public double c() {
		double var1 = this.getZ() - this.getOldRadius() / 2.0D;
		if (var1 < (double) (-this.portalTeleportBoundary)) {
			var1 = (double) (-this.portalTeleportBoundary);
		}

		return var1;
	}

	public double d() {
		double var1 = this.getX() + this.getOldRadius() / 2.0D;
		if (var1 > (double) this.portalTeleportBoundary) {
			var1 = (double) this.portalTeleportBoundary;
		}

		return var1;
	}

	public double e() {
		double var1 = this.getZ() + this.getOldRadius() / 2.0D;
		if (var1 > (double) this.portalTeleportBoundary) {
			var1 = (double) this.portalTeleportBoundary;
		}

		return var1;
	}

	public double getX() {
		return this.x;
	}

	public double getZ() {
		return this.z;
	}

	public void setCenter(double x, double z) {
		this.x = x;
		this.z = z;

		for (WorldBorderChangeListener listener : this.getChangeListeners()) {
			listener.onSetCenter(this, x, z);
		}
	}

	public double getOldRadius() {
		if (this.a() != bfa.c) {
			double var1 = (double) ((float) (System.currentTimeMillis() - this.lerpStartTime) / (float) (this.lerpEndTime - this.lerpStartTime));
			if (var1 < 1.0D) {
				return this.oldRadius + (this.currentRadius - this.oldRadius) * var1;
			}

			this.setSize(this.currentRadius);
		}

		return this.oldRadius;
	}

	public long getSpeed() {
		return this.a() != bfa.c ? this.lerpEndTime - System.currentTimeMillis() : 0L;
	}

	public double getCurrentRadius() {
		return this.currentRadius;
	}

	public void setSize(double size) {
		this.oldRadius = size;
		this.currentRadius = size;
		this.lerpEndTime = System.currentTimeMillis();
		this.lerpStartTime = this.lerpEndTime;

		for (WorldBorderChangeListener listener : this.getChangeListeners()) {
			listener.onSizeSet(this, size);
		}
	}

	public void changeSize(double oldRadius, double currentRadius, long time) {
		this.oldRadius = oldRadius;
		this.currentRadius = currentRadius;
		this.lerpStartTime = System.currentTimeMillis();
		this.lerpEndTime = this.lerpStartTime + time;

		for (WorldBorderChangeListener listener : this.getChangeListeners()) {
			listener.onSizeChange(this, oldRadius, currentRadius, time);
		}
	}

	protected List<WorldBorderChangeListener> getChangeListeners() {
		return Lists.newArrayList(this.listeners);
	}

	public void addChangeListener(WorldBorderChangeListener listener) {
		this.listeners.add(listener);
	}

	public void setPortalTeleportBoundary(int portalTeleportBoundary) {
		this.portalTeleportBoundary = portalTeleportBoundary;
	}

	public int getPortalTeleportBoundary() {
		return this.portalTeleportBoundary;
	}

	public double getDamageBuffer() {
		return this.damageBuffer;
	}

	public void setDamageBuffer(double buffer) {
		this.damageBuffer = buffer;

		for (WorldBorderChangeListener listener : this.getChangeListeners()) {
			listener.onSetDamageBuffer(this, buffer);
		}
	}

	public double getDamageAmount() {
		return this.damageAmount;
	}

	public void setDamageAmount(double damage) {
		this.damageAmount = damage;

		for (WorldBorderChangeListener listener : this.getChangeListeners()) {
			listener.onSetDamageAmount(this, damage);
		}
	}

	public int getWarningTime() {
		return this.warningTime;
	}

	public void setWarningTime(int time) {
		this.warningTime = time;

		for (WorldBorderChangeListener listener : this.getChangeListeners()) {
			listener.onSetWarningTime(this, time);
		}
	}

	public int getWarningBlocks() {
		return this.warningBlocks;
	}

	public void setWarningBlocks(int blocks) {
		this.warningBlocks = blocks;

		for (WorldBorderChangeListener listener : this.getChangeListeners()) {
			listener.onSetWarningBlocks(this, blocks);
		}
	}

}
