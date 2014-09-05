package net.minecraft;

import com.google.common.base.Predicate;
import java.util.List;
import java.util.Random;

public class auy extends ati {

	public static final bev b = bev.a("shape", atl.class, (Predicate) (new auz()));
	public static final bet M = bet.a("powered");

	public auy() {
		super(true);
		this.j(this.L.b().a(M, Boolean.valueOf(false)).a(b, atl.a));
		this.a(true);
	}

	public int a(World var1) {
		return 20;
	}

	public boolean g() {
		return true;
	}

	public void a(World var1, Position var2, bec var3, Entity var4) {
		if (!var1.D) {
			if (!((Boolean) var3.b(M)).booleanValue()) {
				this.e(var1, var2, var3);
			}
		}
	}

	public void a(World var1, Position var2, bec var3, Random var4) {
	}

	public void b(World var1, Position var2, bec var3, Random var4) {
		if (!var1.D && ((Boolean) var3.b(M)).booleanValue()) {
			this.e(var1, var2, var3);
		}
	}

	public int a(ard var1, Position var2, bec var3, PaintingDirection var4) {
		return ((Boolean) var3.b(M)).booleanValue() ? 15 : 0;
	}

	public int b(ard var1, Position var2, bec var3, PaintingDirection var4) {
		return !((Boolean) var3.b(M)).booleanValue() ? 0 : (var4 == PaintingDirection.b ? 15 : 0);
	}

	private void e(World var1, Position var2, bec var3) {
		boolean var4 = ((Boolean) var3.b(M)).booleanValue();
		boolean var5 = false;
		List var6 = this.a(var1, var2, adx.class, new Predicate[0]);
		if (!var6.isEmpty()) {
			var5 = true;
		}

		if (var5 && !var4) {
			var1.a(var2, var3.a(M, Boolean.valueOf(true)), 3);
			var1.c(var2, (Block) this);
			var1.c(var2.b(), (Block) this);
			var1.b(var2, var2);
		}

		if (!var5 && var4) {
			var1.a(var2, var3.a(M, Boolean.valueOf(false)), 3);
			var1.c(var2, (Block) this);
			var1.c(var2.b(), (Block) this);
			var1.b(var2, var2);
		}

		if (var5) {
			var1.a(var2, (Block) this, this.a(var1));
		}

		var1.e(var2, this);
	}

	public void c(World var1, Position var2, bec var3) {
		super.c(var1, var2, var3);
		this.e(var1, var2, var3);
	}

	public bex l() {
		return b;
	}

	public boolean N() {
		return true;
	}

	public int l(World var1, Position var2) {
		if (((Boolean) var1.p(var2).b(M)).booleanValue()) {
			List var3 = this.a(var1, var2, aeb.class, new Predicate[0]);
			if (!var3.isEmpty()) {
				return ((aeb) var3.get(0)).j().j();
			}

			List var4 = this.a(var1, var2, adx.class, new Predicate[] { EntityPredicates.c });
			if (!var4.isEmpty()) {
				return Container.b((IInventory) var4.get(0));
			}
		}

		return 0;
	}

	protected List a(World var1, Position var2, Class var3, Predicate... var4) {
		brt var5 = this.a(var2);
		return var4.length != 1 ? var1.a(var3, var5) : var1.a(var3, var5, var4[0]);
	}

	private brt a(Position var1) {
		float var2 = 0.2F;
		return new brt((double) ((float) var1.n() + 0.2F), (double) var1.o(), (double) ((float) var1.p() + 0.2F), (double) ((float) (var1.n() + 1) - 0.2F), (double) ((float) (var1.o() + 1) - 0.2F), (double) ((float) (var1.p() + 1) - 0.2F));
	}

	public bec a(int var1) {
		return this.P().a(b, atl.a(var1 & 7)).a(M, Boolean.valueOf((var1 & 8) > 0));
	}

	public int c(bec var1) {
		byte var2 = 0;
		int var3 = var2 | ((atl) var1.b(b)).a();
		if (((Boolean) var1.b(M)).booleanValue()) {
			var3 |= 8;
		}

		return var3;
	}

	protected bed e() {
		return new bed(this, new bex[] { b, M });
	}

}
