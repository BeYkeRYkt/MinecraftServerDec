package net.minecraft;

public class ys extends yv {

	private int g;
	private int h = -1;

	public ys(EntityInsentient var1) {
		super(var1);
	}

	public boolean a() {
		if (!super.a()) {
			return false;
		} else if (!this.a.world.getGameRules().b("mobGriefing")) {
			return false;
		} else {
			return !c.f(this.a.world, this.b);
		}
	}

	public void c() {
		super.c();
		this.g = 0;
	}

	public boolean b() {
		double var1 = this.a.b(this.b);
		boolean var3;
		if (this.g <= 240) {
			if (!c.f(this.a.world, this.b) && var1 < 4.0D) {
				var3 = true;
				return var3;
			}
		}

		var3 = false;
		return var3;
	}

	public void d() {
		super.d();
		this.a.world.c(this.a.getId(), this.b, -1);
	}

	public void e() {
		super.e();
		if (this.a.bb().nextInt(20) == 0) {
			this.a.world.triggerEffect(1010, this.b, 0);
		}

		++this.g;
		int var1 = (int) ((float) this.g / 240.0F * 10.0F);
		if (var1 != this.h) {
			this.a.world.c(this.a.getId(), this.b, var1);
			this.h = var1;
		}

		if (this.g == 240 && this.a.world.getDifficulty() == Difficulty.HARD) {
			this.a.world.g(this.b);
			this.a.world.triggerEffect(1012, this.b, 0);
			this.a.world.triggerEffect(2001, this.b, Block.getBlockId((Block) this.c));
		}

	}
}
