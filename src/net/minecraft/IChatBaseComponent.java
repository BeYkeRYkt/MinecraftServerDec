package net.minecraft;

import java.util.List;

public interface IChatBaseComponent extends Iterable {

	IChatBaseComponent a(ChatModifier var1);

	ChatModifier getChatModifier();

	IChatBaseComponent a(String var1);

	IChatBaseComponent a(IChatBaseComponent var1);

	String getComponentVaue();

	String getJsonMessage();

	List a();

	IChatBaseComponent f();

}
