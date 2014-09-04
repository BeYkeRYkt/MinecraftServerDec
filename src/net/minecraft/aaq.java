package net.minecraft;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.Collections;
import java.util.List;

public class aaq extends aaw {

	protected final Class a;
	private final int g;
	protected final aas b;
	protected Predicate c;
	protected EntityLiving d;

	public aaq(xu var1, Class var2, boolean var3) {
		this(var1, var2, var3, false);
	}

	public aaq(xu var1, Class var2, boolean var3, boolean var4) {
		this(var1, var2, 10, var3, var4, (Predicate) null);
	}

	public aaq(xu var1, Class var2, int var3, boolean var4, boolean var5, Predicate var6) {
		super(var1, var4, var5);
		this.a = var2;
		this.g = var3;
		this.b = new aas(var1);
		this.a(1);
		this.c = new aar(this, var6);
	}

	public boolean a() {
		if (this.g > 0 && this.e.bb().nextInt(this.g) != 0) {
			return false;
		} else {
			double var1 = this.f();
			List var3 = this.e.o.a(this.a, this.e.aQ().b(var1, 4.0D, var1), Predicates.and(this.c, xe.d));
			Collections.sort(var3, this.b);
			if (var3.isEmpty()) {
				return false;
			} else {
				this.d = (EntityLiving) var3.get(0);
				return true;
			}
		}
	}

	public void c() {
		this.e.d(this.d);
		super.c();
	}
}
