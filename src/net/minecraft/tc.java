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

	public String d_() {
		return "Rcon";
	}

	public IChatBaseComponent e_() {
		return new ChatComponentText(this.d_());
	}

	public void sendChatMessage(IChatBaseComponent var1) {
		this.b.append(var1.c());
	}

	public boolean a(int var1, String var2) {
		return true;
	}

	public Position c() {
		return new Position(0, 0, 0);
	}

	public Vec3D d() {
		return new Vec3D(0.0D, 0.0D, 0.0D);
	}

	public World e() {
		return MinecraftServer.getInstance().e();
	}

	public Entity f() {
		return null;
	}

	public boolean t_() {
		return true;
	}

	public void a(ag var1, int var2) {
	}

}
