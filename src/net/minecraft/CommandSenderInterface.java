package net.minecraft;

public interface CommandSenderInterface {

	String getName();

	IChatBaseComponent getComponentName();

	void sendChatMessage(IChatBaseComponent var1);

	boolean canExecuteCommand(int var1, String var2);

	Position getEntityPosition();

	Vec3D getCenter();

	World getWorld();

	Entity getEntity();

	boolean t_();

	void a(ag var1, int var2);
}
