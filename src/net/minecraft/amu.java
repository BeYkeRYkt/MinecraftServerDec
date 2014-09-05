package net.minecraft;

import com.google.common.collect.Sets;
import java.util.Set;

public class amu extends aks {

	private static final Set c = Sets.newHashSet((Object[]) (new Block[] { aty.cs, aty.q, aty.e, aty.E, aty.ah, aty.ag, aty.T, aty.D, aty.R, aty.o, aty.aI, aty.S, aty.p, aty.y, aty.x, aty.aD, aty.Y, aty.aV, aty.cB, aty.av, aty.aC, aty.A, aty.cM, aty.b, aty.U }));

	protected amu(ami var1) {
		super(2.0F, var1, c);
	}

	public boolean b(Block var1) {
		return var1 == aty.Z ? this.b.d() == 3 : (var1 != aty.ah && var1 != aty.ag ? (var1 != aty.bP && var1 != aty.bT ? (var1 != aty.R && var1 != aty.o ? (var1 != aty.S && var1 != aty.p ? (var1 != aty.y && var1 != aty.x ? (var1 != aty.aC && var1 != aty.aD ? (var1.r() == bof.e ? true : (var1.r() == bof.f ? true : var1.r() == bof.g)) : this.b.d() >= 2) : this.b.d() >= 1) : this.b.d() >= 1) : this.b.d() >= 2) : this.b.d() >= 2) : this.b.d() >= 2);
	}

	public float a(ItemStack var1, Block var2) {
		return var2.r() != bof.f && var2.r() != bof.g && var2.r() != bof.e ? super.a(var1, var2) : this.a;
	}

}
