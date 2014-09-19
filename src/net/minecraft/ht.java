package net.minecraft;

import java.util.Iterator;
import net.minecraft.server.MinecraftServer;

public class ht extends hj {

	private final String b;
	private final String c;
	private String d = "";

	public ht(String var1, String var2) {
		this.b = var1;
		this.c = var2;
	}

	public String g() {
		return this.b;
	}

	public String h() {
		return this.c;
	}

	public void b(String var1) {
		this.d = var1;
	}

	public String getComponentVaue() {
		MinecraftServer var1 = MinecraftServer.getInstance();
		if (var1 != null && var1.hasUniverse() && vb.b(this.d)) {
			Scoreboard var2 = var1.getWorldServer(0).Z();
			ScoreboardObjective var3 = var2.b(this.c);
			if (var2.b(this.b, var3)) {
				ScoreboardScore var4 = var2.c(this.b, var3);
				this.b(String.format("%d", new Object[] { Integer.valueOf(var4.getScore()) }));
			} else {
				this.d = "";
			}
		}

		return this.d;
	}

	public ht i() {
		ht var1 = new ht(this.b, this.c);
		var1.b(this.d);
		var1.a(this.getChatModifier().m());
		Iterator var2 = this.a().iterator();

		while (var2.hasNext()) {
			IChatBaseComponent var3 = (IChatBaseComponent) var2.next();
			var1.a(var3.f());
		}

		return var1;
	}

	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else if (!(var1 instanceof ht)) {
			return false;
		} else {
			ht var2 = (ht) var1;
			return this.b.equals(var2.b) && this.c.equals(var2.c) && super.equals(var1);
		}
	}

	public String toString() {
		return "ScoreComponent{name=\'" + this.b + '\'' + "objective=\'" + this.c + '\'' + ", siblings=" + this.a + ", style=" + this.getChatModifier() + '}';
	}

	// $FF: synthetic method
	public IChatBaseComponent f() {
		return this.i();
	}
}
