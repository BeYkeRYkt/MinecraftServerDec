package net.minecraft;

import java.util.Collection;
import java.util.Iterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bse extends bqc {

	private static final Logger b = LogManager.getLogger();
	private bsd c;
	private NBTCompoundTag d;

	public bse() {
		this("scoreboard");
	}

	public bse(String var1) {
		super(var1);
	}

	public void a(bsd var1) {
		this.c = var1;
		if (this.d != null) {
			this.a(this.d);
		}

	}

	public void a(NBTCompoundTag var1) {
		if (this.c == null) {
			this.d = var1;
		} else {
			this.b(var1.c("Objectives", 10));
			this.c(var1.c("PlayerScores", 10));
			if (var1.b("DisplaySlots", 10)) {
				this.c(var1.m("DisplaySlots"));
			}

			if (var1.b("Teams", 9)) {
				this.a(var1.c("Teams", 10));
			}

		}
	}

	protected void a(NBTListTag var1) {
		for (int var2 = 0; var2 < var1.getSize(); ++var2) {
			NBTCompoundTag var3 = var1.getCompound(var2);
			brz var4 = this.c.e(var3.j("Name"));
			var4.a(var3.j("DisplayName"));
			if (var3.b("TeamColor", 8)) {
				var4.a(FormattingCode.b(var3.j("TeamColor")));
			}

			var4.b(var3.j("Prefix"));
			var4.c(var3.j("Suffix"));
			if (var3.b("AllowFriendlyFire", 99)) {
				var4.a(var3.n("AllowFriendlyFire"));
			}

			if (var3.b("SeeFriendlyInvisibles", 99)) {
				var4.b(var3.n("SeeFriendlyInvisibles"));
			}

			bsg var5;
			if (var3.b("NameTagVisibility", 8)) {
				var5 = bsg.a(var3.j("NameTagVisibility"));
				if (var5 != null) {
					var4.a(var5);
				}
			}

			if (var3.b("DeathMessageVisibility", 8)) {
				var5 = bsg.a(var3.j("DeathMessageVisibility"));
				if (var5 != null) {
					var4.b(var5);
				}
			}

			this.a(var4, var3.c("Players", 8));
		}

	}

	protected void a(brz var1, NBTListTag var2) {
		for (int var3 = 0; var3 < var2.getSize(); ++var3) {
			this.c.a(var2.getString(var3), var1.b());
		}

	}

	protected void c(NBTCompoundTag var1) {
		for (int var2 = 0; var2 < 19; ++var2) {
			if (var1.b("slot_" + var2, 8)) {
				String var3 = var1.j("slot_" + var2);
				bry var4 = this.c.b(var3);
				this.c.a(var2, var4);
			}
		}

	}

	protected void b(NBTListTag var1) {
		for (int var2 = 0; var2 < var1.getSize(); ++var2) {
			NBTCompoundTag var3 = var1.getCompound(var2);
			bsk var4 = (bsk) bsk.a.get(var3.j("CriteriaName"));
			if (var4 != null) {
				bry var5 = this.c.a(var3.j("Name"), var4);
				var5.a(var3.j("DisplayName"));
				var5.a(bsl.a(var3.j("RenderType")));
			}
		}

	}

	protected void c(NBTListTag var1) {
		for (int var2 = 0; var2 < var1.getSize(); ++var2) {
			NBTCompoundTag var3 = var1.getCompound(var2);
			bry var4 = this.c.b(var3.j("Objective"));
			bsa var5 = this.c.c(var3.j("Name"), var4);
			var5.c(var3.f("Score"));
			if (var3.c("Locked")) {
				var5.a(var3.n("Locked"));
			}
		}

	}

	public void b(NBTCompoundTag var1) {
		if (this.c == null) {
			b.warn("Tried to save scoreboard without having a scoreboard...");
		} else {
			var1.a("Objectives", (NBTTag) this.b());
			var1.a("PlayerScores", (NBTTag) this.e());
			var1.a("Teams", (NBTTag) this.a());
			this.d(var1);
		}
	}

	protected NBTListTag a() {
		NBTListTag var1 = new NBTListTag();
		Collection var2 = this.c.g();
		Iterator var3 = var2.iterator();

		while (var3.hasNext()) {
			brz var4 = (brz) var3.next();
			NBTCompoundTag var5 = new NBTCompoundTag();
			var5.a("Name", var4.b());
			var5.a("DisplayName", var4.c());
			if (var4.l().b() >= 0) {
				var5.a("TeamColor", var4.l().e());
			}

			var5.a("Prefix", var4.e());
			var5.a("Suffix", var4.f());
			var5.a("AllowFriendlyFire", var4.g());
			var5.a("SeeFriendlyInvisibles", var4.h());
			var5.a("NameTagVisibility", var4.i().e);
			var5.a("DeathMessageVisibility", var4.j().e);
			NBTListTag var6 = new NBTListTag();
			Iterator var7 = var4.d().iterator();

			while (var7.hasNext()) {
				String var8 = (String) var7.next();
				var6.addTag((NBTTag) (new NBTStringTag(var8)));
			}

			var5.a("Players", (NBTTag) var6);
			var1.addTag((NBTTag) var5);
		}

		return var1;
	}

	protected void d(NBTCompoundTag var1) {
		NBTCompoundTag var2 = new NBTCompoundTag();
		boolean var3 = false;

		for (int var4 = 0; var4 < 19; ++var4) {
			bry var5 = this.c.a(var4);
			if (var5 != null) {
				var2.a("slot_" + var4, var5.b());
				var3 = true;
			}
		}

		if (var3) {
			var1.a("DisplaySlots", (NBTTag) var2);
		}

	}

	protected NBTListTag b() {
		NBTListTag var1 = new NBTListTag();
		Collection var2 = this.c.c();
		Iterator var3 = var2.iterator();

		while (var3.hasNext()) {
			bry var4 = (bry) var3.next();
			if (var4.c() != null) {
				NBTCompoundTag var5 = new NBTCompoundTag();
				var5.a("Name", var4.b());
				var5.a("CriteriaName", var4.c().a());
				var5.a("DisplayName", var4.d());
				var5.a("RenderType", var4.e().a());
				var1.addTag((NBTTag) var5);
			}
		}

		return var1;
	}

	protected NBTListTag e() {
		NBTListTag var1 = new NBTListTag();
		Collection var2 = this.c.e();
		Iterator var3 = var2.iterator();

		while (var3.hasNext()) {
			bsa var4 = (bsa) var3.next();
			if (var4.d() != null) {
				NBTCompoundTag var5 = new NBTCompoundTag();
				var5.a("Name", var4.e());
				var5.a("Objective", var4.d().b());
				var5.a("Score", var4.c());
				var5.a("Locked", var4.g());
				var1.addTag((NBTTag) var5);
			}
		}

		return var1;
	}

}
