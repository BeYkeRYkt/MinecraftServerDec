package net.minecraft;

public class to extends PlayerStatistic {

	private final Item a;

	public to(String var1, String var2, IJSONComponent var3, Item var4) {
		super(var1 + var2, var3);
		this.a = var4;
		int var5 = Item.getId(var4);
		if (var5 != 0) {
			bsk.a.put(var1 + var5, this.k());
		}

	}
}
