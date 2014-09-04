package net.minecraft;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

class gi extends gh {

	protected List b = Lists.newArrayList();

	public gi(String var1) {
		this.a = var1;
	}

	public NBTTag a() {
		NBTCompoundTag var1 = new NBTCompoundTag();
		Iterator var2 = this.b.iterator();

		while (var2.hasNext()) {
			gh var3 = (gh) var2.next();
			var1.a(var3.a, var3.a());
		}

		return var1;
	}
}
