package net.minecraft;

import com.google.common.collect.Maps;
import java.util.Map;

public class amy extends alq {

	private static final Map b = Maps.newHashMap();
	public final String a;

	protected amy(String var1) {
		this.a = var1;
		this.h = 1;
		this.a(akf.f);
		b.put("records." + var1, this);
	}

	public boolean a(amj var1, ahd var2, World var3, dt var4, ej var5, float var6, float var7, float var8) {
		bec var9 = var3.p(var4);
		if (var9.c() == aty.aN && !((Boolean) var9.b(axc.a)).booleanValue()) {
			if (var3.D) {
				return true;
			} else {
				((axc) aty.aN).a(var3, var4, var9, var1);
				var3.a((ahd) null, 1005, var4, alq.b((alq) this));
				--var1.b;
				return true;
			}
		} else {
			return false;
		}
	}

	public amx g(amj var1) {
		return amx.c;
	}

}
