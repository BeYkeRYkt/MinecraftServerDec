package net.minecraft;

import net.minecraft.server.MinecraftServer;

class bl implements CommandSenderInterface {

	// $FF: synthetic field
	final Entity a;
	// $FF: synthetic field
	final CommandSenderInterface b;
	// $FF: synthetic field
	final Position c;
	// $FF: synthetic field
	final double d;
	// $FF: synthetic field
	final double e;
	// $FF: synthetic field
	final double f;
	// $FF: synthetic field
	final ExecuteCommand g;

	bl(ExecuteCommand var1, Entity var2, CommandSenderInterface var3, Position var4, double var5, double var7, double var9) {
		this.g = var1;
		this.a = var2;
		this.b = var3;
		this.c = var4;
		this.d = var5;
		this.e = var7;
		this.f = var9;
	}

	public String getName() {
		return this.a.getName();
	}

	public IChatBaseComponent getComponentName() {
		return this.a.getComponentName();
	}

	public void sendChatMessage(IChatBaseComponent var1) {
		this.b.sendChatMessage(var1);
	}

	public boolean canExecuteCommand(int var1, String var2) {
		return this.b.canExecuteCommand(var1, var2);
	}

	public Position getEntityPosition() {
		return this.c;
	}

	public Vec3D getCenter() {
		return new Vec3D(this.d, this.e, this.f);
	}

	public World getWorld() {
		return this.a.world;
	}

	public Entity getEntity() {
		return this.a;
	}

	public boolean t_() {
		MinecraftServer var1 = MinecraftServer.getInstance();
		return var1 == null || var1.getWorld().getGameRules().b("commandBlockOutput");
	}

	public void a(ag var1, int var2) {
		this.a.a(var1, var2);
	}
}
