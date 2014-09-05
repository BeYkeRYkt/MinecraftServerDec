package net.minecraft;

import com.google.common.collect.Sets;
import java.util.Set;

public class ane extends aks {

	private static final Set c = Sets.newHashSet((Object[]) (new Block[] { aty.aL, aty.d, aty.ak, aty.c, aty.n, aty.bw, aty.m, aty.aJ, aty.aH, aty.aW }));

	public ane(ami var1) {
		super(1.0F, var1, c);
	}

	public boolean b(Block var1) {
		return var1 == aty.aH ? true : var1 == aty.aJ;
	}

}
