package net.minecraft;

public enum amx {

	a("COMMON", 0, EnumChatFormat.WHITE, "Common"), 
	b("UNCOMMON", 1, EnumChatFormat.YELLOW, "Uncommon"), 
	c("RARE", 2, EnumChatFormat.AQUA, "Rare"), 
	d("EPIC", 3, EnumChatFormat.LIGHT_PURPLE, "Epic");

	public final EnumChatFormat e;
	public final String f;

	private amx(String var1, int var2, EnumChatFormat var3, String var4) {
		this.e = var3;
		this.f = var4;
	}

}
