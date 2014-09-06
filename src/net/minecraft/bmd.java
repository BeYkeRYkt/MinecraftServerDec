package net.minecraft;

import java.util.List;
import java.util.Random;

public class bmd extends bly {

	public void a(bms var1, List var2, Random var3) {
		if (this.m != PaintingDirection.c && this.m != PaintingDirection.f) {
			this.b((bmh) var1, var2, var3, 1, 1);
		} else {
			this.c((bmh) var1, var2, var3, 1, 1);
		}

	}

	public boolean a(World var1, Random var2, bjb var3) {
		if (this.a(var1, var3)) {
			return false;
		} else {
			this.a(var1, var3, 0, 0, 0, 4, 4, 4, true, var2, blr.c());
			this.a(var1, var2, var3, this.d, 1, 1, 0);
			if (this.m != PaintingDirection.c && this.m != PaintingDirection.f) {
				this.a(var1, var3, 0, 1, 1, 0, 3, 3, Blocks.AIR.P(), Blocks.AIR.P(), false);
			} else {
				this.a(var1, var3, 4, 1, 1, 4, 3, 3, Blocks.AIR.P(), Blocks.AIR.P(), false);
			}

			return true;
		}
	}
}
