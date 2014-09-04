package net.minecraft;

public enum amx {

	a("COMMON", 0, FormattingCode.p, "Common"), 
	b("UNCOMMON", 1, FormattingCode.o, "Uncommon"), 
	c("RARE", 2, FormattingCode.l, "Rare"), 
	d("EPIC", 3, FormattingCode.n, "Epic");

	public final FormattingCode e;
	public final String f;

	private amx(String var1, int var2, FormattingCode var3, String var4) {
		this.e = var3;
		this.f = var4;
	}

}
