package net.minecraft;

import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

class wc extends TimerTask {

	// $FF: synthetic field
	final Snooper a;

	wc(Snooper var1) {
		this.a = var1;
	}

	public void run() {
		if (Snooper.a(this.a).ac()) {
			HashMap var1;
			synchronized (Snooper.b(this.a)) {
				var1 = Maps.newHashMap(Snooper.c(this.a));
				if (Snooper.d(this.a) == 0) {
					var1.putAll(Snooper.e(this.a));
				}

				var1.put("snooper_count", Integer.valueOf(Snooper.f(this.a)));
				var1.put("snooper_token", Snooper.g(this.a));
			}

			ui.a(Snooper.h(this.a), (Map) var1, true);
		}
	}
}
