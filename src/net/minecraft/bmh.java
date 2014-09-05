package net.minecraft;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;

public class bmh extends bmg {

	public bma a;
	public bmb b;
	public List c = Lists.newArrayList();

	public bmh() {
	}

	public bmh(int var1, Random var2, int var3, int var4) {
		super(0, var2, var3, var4);
	}

	public Position a() {
		return this.b != null ? this.b.a() : super.a();
	}
}
