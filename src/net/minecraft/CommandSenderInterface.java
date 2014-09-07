package net.minecraft;

public interface CommandSenderInterface {

	String d_();

	IChatBaseComponent e_();

	void sendChatMessage(IChatBaseComponent var1);

	boolean a(int var1, String var2);

	Position c();

	Vec3D d();

	World e();

	Entity f();

	boolean t_();

	void a(ag var1, int var2);
}
