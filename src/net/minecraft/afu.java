package net.minecraft;

import java.util.Random;

class afu extends zy {

	private final EntitySilverfish a;
	private BlockFace b;
	private boolean c;

	public afu(EntitySilverfish var1) {
		super(var1, 1.0D, 10);
		this.a = var1;
		this.a(1);
	}

	public boolean a() {
		if (this.a.u() != null) {
			return false;
		} else if (!this.a.s().m()) {
			return false;
		} else {
			Random var1 = this.a.bb();
			if (var1.nextInt(10) == 0) {
				this.b = BlockFace.getRandom(var1);
				Position var2 = (new Position(this.a.locationX, this.a.locationY + 0.5D, this.a.locationZ)).a(this.b);
				bec var3 = this.a.o.p(var2);
				if (BlockMonsterEggs.d(var3)) {
					this.c = true;
					return true;
				}
			}

			this.c = false;
			return super.a();
		}
	}

	public boolean b() {
		return this.c ? false : super.b();
	}

	public void c() {
		if (!this.c) {
			super.c();
		} else {
			World var1 = this.a.o;
			Position var2 = (new Position(this.a.locationX, this.a.locationY + 0.5D, this.a.locationZ)).a(this.b);
			bec var3 = var1.p(var2);
			if (BlockMonsterEggs.d(var3)) {
				var1.a(var2, Blocks.MONSTER_EGG.P().a(BlockMonsterEggs.a, axu.a(var3)), 3);
				this.a.y();
				this.a.J();
			}

		}
	}
}
