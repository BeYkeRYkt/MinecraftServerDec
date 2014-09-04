package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class amw extends alq {

	private Map a = Maps.newHashMap();
	private static final Map b = Maps.newLinkedHashMap();

	public amw() {
		this.c(1);
		this.a(true);
		this.d(0);
		this.a(akf.k);
	}

	public List h(amj var1) {
		if (var1.n() && var1.o().b("CustomPotionEffects", 9)) {
			ArrayList var7 = Lists.newArrayList();
			NBTListTag var3 = var1.o().c("CustomPotionEffects", 10);

			for (int var4 = 0; var4 < var3.c(); ++var4) {
				NBTCompoundTag var5 = var3.b(var4);
				wq var6 = wq.b(var5);
				if (var6 != null) {
					var7.add(var6);
				}
			}

			return var7;
		} else {
			List var2 = (List) this.a.get(Integer.valueOf(var1.i()));
			if (var2 == null) {
				var2 = ans.b(var1.i(), false);
				this.a.put(Integer.valueOf(var1.i()), var2);
			}

			return var2;
		}
	}

	public List e(int var1) {
		List var2 = (List) this.a.get(Integer.valueOf(var1));
		if (var2 == null) {
			var2 = ans.b(var1, false);
			this.a.put(Integer.valueOf(var1), var2);
		}

		return var2;
	}

	public amj b(amj var1, World var2, ahd var3) {
		if (!var3.by.instabuild) {
			--var1.b;
		}

		if (!var2.D) {
			List var4 = this.h(var1);
			if (var4 != null) {
				Iterator var5 = var4.iterator();

				while (var5.hasNext()) {
					wq var6 = (wq) var5.next();
					var3.c(new wq(var6));
				}
			}
		}

		var3.b(ty.J[alq.b((alq) this)]);
		if (!var3.by.instabuild) {
			if (var1.b <= 0) {
				return new amj(amk.bA);
			}

			var3.bg.a(new amj(amk.bA));
		}

		return var1;
	}

	public int d(amj var1) {
		return 32;
	}

	public ano e(amj var1) {
		return ano.c;
	}

	public amj a(amj var1, World var2, ahd var3) {
		if (f(var1.i())) {
			if (!var3.by.instabuild) {
				--var1.b;
			}

			var2.a((Entity) var3, "random.bow", 0.5F, 0.4F / (g.nextFloat() * 0.4F + 0.8F));
			if (!var2.D) {
				var2.d((Entity) (new ahv(var2, var3, var1)));
			}

			var3.b(ty.J[alq.b((alq) this)]);
			return var1;
		} else {
			var3.a(var1, this.d(var1));
			return var1;
		}
	}

	public static boolean f(int var0) {
		return (var0 & 16384) != 0;
	}

	public String a(amj var1) {
		if (var1.i() == 0) {
			return fi.a("item.emptyPotion.name").trim();
		} else {
			String var2 = "";
			if (f(var1.i())) {
				var2 = fi.a("potion.prefix.grenade").trim() + " ";
			}

			List var3 = amk.bz.h(var1);
			String var4;
			if (var3 != null && !var3.isEmpty()) {
				var4 = ((wq) var3.get(0)).g();
				var4 = var4 + ".postfix";
				return var2 + fi.a(var4).trim();
			} else {
				var4 = ans.c(var1.i());
				return fi.a(var4).trim() + " " + super.a(var1);
			}
		}
	}

}
