package net.minecraft;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class is implements id<ik> {

	private Map a;

	public is() {
	}

	public is(Map var1) {
		this.a = var1;
	}

	public void a(ik var1) {
		var1.a(this);
	}

	public void a(hd var1) {
		int var2 = var1.e();
		this.a = Maps.newHashMap();

		for (int var3 = 0; var3 < var2; ++var3) {
			PlayerStatistic var4 = ty.a(var1.c(32767));
			int var5 = var1.e();
			if (var4 != null) {
				this.a.put(var4, Integer.valueOf(var5));
			}
		}

	}

	public void b(hd var1) {
		var1.b(this.a.size());
		Iterator var2 = this.a.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry) var2.next();
			var1.a(((PlayerStatistic) var3.getKey()).e);
			var1.b(((Integer) var3.getValue()).intValue());
		}

	}
}
