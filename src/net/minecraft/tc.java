package net.minecraft;

import net.minecraft.server.MinecraftServer;

public class tc implements CommandSenderInterface {

	private static final tc a = new tc();
	private StringBuffer b = new StringBuffer();

	public static tc h() {
		return a;
	}

	public void i() {
		this.b.setLength(0);
	}

	public String j() {
		return this.b.toString();
	}

	public String getName() {
		return "Rcon";
	}

	public IChatBaseComponent getComponentName() {
		return new ChatComponentText(this.getName());
	}

	public void sendChatMessage(IChatBaseComponent var1) {
		this.b.append(var1.getJsonMessage());
	}

	public boolean canExecuteCommand(int var1, String var2) {
		return true;
	}

	public Position getEntityPosition() {
		return new Position(0, 0, 0);
	}

	public Vec3D getCenter() {
		return new Vec3D(0.0D, 0.0D, 0.0D);
	}

	public World getWorld() {
		return MinecraftServer.getInstance().getWorld();
	}

	public Entity getEntity() {
		return null;
	}

	public boolean t_() {
		return true;
	}

	public void a(ag var1, int var2) {
	}

}
