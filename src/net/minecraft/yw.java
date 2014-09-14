package net.minecraft;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

public class yw extends PathfinderGoal {

	private static final Predicate b = beq.a((Block) Blocks.TALLGRASS).a(BlockLongGrass.a, Predicates.equalTo(EnumGrassType.b));
	private EntityInsentient c;
	private World d;
	int a;

	public yw(EntityInsentient var1) {
		this.c = var1;
		this.d = var1.world;
		this.a(7);
	}

	public boolean a() {
		if (this.c.bb().nextInt(this.c.i_() ? 50 : 1000) != 0) {
			return false;
		} else {
			Position var1 = new Position(this.c.locationX, this.c.locationY, this.c.locationZ);
			return b.apply(this.d.getBlockState(var1)) ? true : this.d.getBlockState(var1.b()).getBlock() == Blocks.GRASS;
		}
	}

	public void c() {
		this.a = 40;
		this.d.broadcastEntityEffect((Entity) this.c, (byte) 10);
		this.c.s().n();
	}

	public void d() {
		this.a = 0;
	}

	public boolean b() {
		return this.a > 0;
	}

	public int f() {
		return this.a;
	}

	public void e() {
		this.a = Math.max(0, this.a - 1);
		if (this.a == 4) {
			Position var1 = new Position(this.c.locationX, this.c.locationY, this.c.locationZ);
			if (b.apply(this.d.getBlockState(var1))) {
				if (this.d.getGameRules().b("mobGriefing")) {
					this.d.b(var1, false);
				}

				this.c.v();
			} else {
				Position var2 = var1.b();
				if (this.d.getBlockState(var2).getBlock() == Blocks.GRASS) {
					if (this.d.getGameRules().b("mobGriefing")) {
						this.d.b(2001, var2, Block.getBlockId((Block) Blocks.GRASS));
						this.d.setBlockAt(var2, Blocks.DIRT.getBlockState(), 2);
					}

					this.c.v();
				}
			}

		}
	}

}
