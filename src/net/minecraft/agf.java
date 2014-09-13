package net.minecraft;

class agf extends zk {

	public agf(EntitySpider var1, Class var2) {
		super(var1, var2, 1.0D, true);
	}

	public boolean b() {
		float var1 = this.b.c(1.0F);
		if (var1 >= 0.5F && this.b.bb().nextInt(100) == 0) {
			this.b.d((EntityLiving) null);
			return false;
		} else {
			return super.b();
		}
	}

	protected double a(EntityLiving var1) {
		return (double) (4.0F + var1.height);
	}
}
