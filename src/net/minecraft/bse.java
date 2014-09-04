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
			this.b(var1.getList("Objectives", 10));
			this.c(var1.getList("PlayerScores", 10));
			if (var1.isTagAssignableFrom("DisplaySlots", 10)) {
				this.c(var1.getCompound("DisplaySlots"));
			}

			if (var1.isTagAssignableFrom("Teams", 9)) {
				this.a(var1.getList("Teams", 10));
			}

		}
	}

	protected void a(NBTListTag var1) {
		for (int var2 = 0; var2 < var1.getSize(); ++var2) {
			NBTCompoundTag var3 = var1.getCompound(var2);
			brz var4 = this.c.e(var3.getString("Name"));
			var4.a(var3.getString("DisplayName"));
			if (var3.isTagAssignableFrom("TeamColor", 8)) {
				var4.a(FormattingCode.b(var3.getString("TeamColor")));
			}

			var4.b(var3.getString("Prefix"));
			var4.c(var3.getString("Suffix"));
			if (var3.isTagAssignableFrom("AllowFriendlyFire", 99)) {
				var4.a(var3.getBoolean("AllowFriendlyFire"));
			}

			if (var3.isTagAssignableFrom("SeeFriendlyInvisibles", 99)) {
				var4.b(var3.getBoolean("SeeFriendlyInvisibles"));
			}

			bsg var5;
			if (var3.isTagAssignableFrom("NameTagVisibility", 8)) {
				var5 = bsg.a(var3.getString("NameTagVisibility"));
				if (var5 != null) {
					var4.a(var5);
				}
			}

			if (var3.isTagAssignableFrom("DeathMessageVisibility", 8)) {
				var5 = bsg.a(var3.getString("DeathMessageVisibility"));
				if (var5 != null) {
					var4.b(var5);
				}
			}

			this.a(var4, var3.getList("Players", 8));
		}

	}

	protected void a(brz var1, NBTListTag var2) {
		for (int var3 = 0; var3 < var2.getSize(); ++var3) {
			this.c.a(var2.getString(var3), var1.b());
		}

	}

	protected void c(NBTCompoundTag var1) {
		for (int var2 = 0; var2 < 19; ++var2) {
			if (var1.isTagAssignableFrom("slot_" + var2, 8)) {
				String var3 = var1.getString("slot_" + var2);
				bry var4 = this.c.b(var3);
				this.c.a(var2, var4);
			}
		}

	}

	protected void b(NBTListTag var1) {
		for (int var2 = 0; var2 < var1.getSize(); ++var2) {
			NBTCompoundTag var3 = var1.getCompound(var2);
			bsk var4 = (bsk) bsk.a.get(var3.getString("CriteriaName"));
			if (var4 != null) {
				bry var5 = this.c.a(var3.getString("Name"), var4);
				var5.a(var3.getString("DisplayName"));
				var5.a(bsl.a(var3.getString("RenderType")));
			}
		}

	}

	protected void c(NBTListTag var1) {
		for (int var2 = 0; var2 < var1.getSize(); ++var2) {
			NBTCompoundTag var3 = var1.getCompound(var2);
			bry var4 = this.c.b(var3.getString("Objective"));
			bsa var5 = this.c.c(var3.getString("Name"), var4);
			var5.c(var3.getInt("Score"));
			if (var3.hasKey("Locked")) {
				var5.a(var3.getBoolean("Locked"));
			}
		}

	}

	public void b(NBTCompoundTag var1) {
		if (this.c == null) {
			b.warn("Tried to save scoreboard without having a scoreboard...");
		} else {
			var1.put("Objectives", (NBTTag) this.b());
			var1.put("PlayerScores", (NBTTag) this.e());
			var1.put("Teams", (NBTTag) this.a());
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
			var5.put("Name", var4.b());
			var5.put("DisplayName", var4.c());
			if (var4.l().b() >= 0) {
				var5.put("TeamColor", var4.l().e());
			}

			var5.put("Prefix", var4.e());
			var5.put("Suffix", var4.f());
			var5.put("AllowFriendlyFire", var4.g());
			var5.put("SeeFriendlyInvisibles", var4.h());
			var5.put("NameTagVisibility", var4.i().e);
			var5.put("DeathMessageVisibility", var4.j().e);
			NBTListTag var6 = new NBTListTag();
			Iterator var7 = var4.d().iterator();

			while (var7.hasNext()) {
				String var8 = (String) var7.next();
				var6.addTag((NBTTag) (new NBTStringTag(var8)));
			}

			var5.put("Players", (NBTTag) var6);
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
				var2.put("slot_" + var4, var5.b());
				var3 = true;
			}
		}

		if (var3) {
			var1.put("DisplaySlots", (NBTTag) var2);
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
				var5.put("Name", var4.b());
				var5.put("CriteriaName", var4.c().a());
				var5.put("DisplayName", var4.d());
				var5.put("RenderType", var4.e().a());
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
				var5.put("Name", var4.e());
				var5.put("Objective", var4.d().b());
				var5.put("Score", var4.c());
				var5.put("Locked", var4.g());
				var1.addTag((NBTTag) var5);
			}
		}

		return var1;
	}

}
