package net.minecraft;

import com.google.common.collect.Lists;
import java.util.List;

public class bjl extends bmm {

	private List d = Lists.newArrayList();

	public bjl() {
		this.d.add(new arq(aem.class, 10, 2, 3));
		this.d.add(new arq(afo.class, 5, 4, 4));
		this.d.add(new arq(afw.class, 10, 4, 4));
		this.d.add(new arq(afl.class, 3, 4, 4));
	}

	public String a() {
		return "Fortress";
	}

	public List b() {
		return this.d;
	}

	protected boolean a(int var1, int var2) {
		int var3 = var1 >> 4;
		int var4 = var2 >> 4;
		this.b.setSeed((long) (var3 ^ var4 << 4) ^ this.c.J());
		this.b.nextInt();
		return this.b.nextInt(3) != 0 ? false : (var1 != (var3 << 4) + 4 + this.b.nextInt(8) ? false : var2 == (var4 << 4) + 4 + this.b.nextInt(8));
	}

	protected bmv b(int var1, int var2) {
		return new bjm(this.c, this.b, var1, var2);
	}
}
