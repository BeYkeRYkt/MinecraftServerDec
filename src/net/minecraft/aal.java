package net.minecraft;

import java.util.Iterator;
import java.util.List;

public class aal extends aaw {

	private boolean a;
	private int b;
	private final Class[] c;

	public aal(EntityCreature var1, boolean var2, Class... var3) {
		super(var1, false);
		this.a = var2;
		this.c = var3;
		this.a(1);
	}

	public boolean a() {
		int var1 = this.e.bd();
		return var1 != this.b && this.a(this.e.bc(), false);
	}

	public void c() {
		this.e.d(this.e.bc());
		this.b = this.e.bd();
		if (this.a) {
			double var1 = this.f();
			List var3 = this.e.o.a(this.e.getClass(), (new AxisAlignedBB(this.e.locationX, this.e.locationY, this.e.locationZ, this.e.locationX + 1.0D, this.e.locationY + 1.0D, this.e.locationZ + 1.0D)).b(var1, 10.0D, var1));
			Iterator var4 = var3.iterator();

			while (var4.hasNext()) {
				EntityCreature var5 = (EntityCreature) var4.next();
				if (this.e != var5 && var5.u() == null && !var5.c(this.e.bc())) {
					boolean var6 = false;
					Class[] var7 = this.c;
					int var8 = var7.length;

					for (int var9 = 0; var9 < var8; ++var9) {
						Class var10 = var7[var9];
						if (var5.getClass() == var10) {
							var6 = true;
							break;
						}
					}

					if (!var6) {
						this.a(var5, this.e.bc());
					}
				}
			}
		}

		super.c();
	}

	protected void a(EntityCreature var1, EntityLiving var2) {
		var1.d(var2);
	}
}
