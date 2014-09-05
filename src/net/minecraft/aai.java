package net.minecraft;

public class aai extends zf {

	private int e;
	private EntityVillager f;

	public aai(EntityVillager var1) {
		super(var1, EntityVillager.class, 3.0F, 0.02F);
		this.f = var1;
	}

	public void c() {
		super.c();
		if (this.f.cq() && this.b instanceof EntityVillager && ((EntityVillager) this.b).cr()) {
			this.e = 10;
		} else {
			this.e = 0;
		}

	}

	public void e() {
		super.e();
		if (this.e > 0) {
			--this.e;
			if (this.e == 0) {
				wa var1 = this.f.co();

				for (int var2 = 0; var2 < var1.n_(); ++var2) {
					ItemStack var3 = var1.a(var2);
					ItemStack var4 = null;
					if (var3 != null) {
						Item var5 = var3.getItem();
						int var6;
						if ((var5 == amk.P || var5 == amk.bS || var5 == amk.bR) && var3.b > 3) {
							var6 = var3.b / 2;
							var3.b -= var6;
							var4 = new ItemStack(var5, var6, var3.i());
						} else if (var5 == amk.O && var3.b > 5) {
							var6 = var3.b / 2 / 3 * 3;
							int var7 = var6 / 3;
							var3.b -= var6;
							var4 = new ItemStack(amk.P, var7, 0);
						}

						if (var3.b <= 0) {
							var1.a(var2, (ItemStack) null);
						}
					}

					if (var4 != null) {
						double var11 = this.f.locationY - 0.30000001192092896D + (double) this.f.aR();
						EntityItem var12 = new EntityItem(this.f.o, this.f.locationX, var11, this.f.locationZ, var4);
						float var8 = 0.3F;
						float var9 = this.f.headPitch;
						float var10 = this.f.pitch;
						var12.motionX = (double) (-DataTypesConverter.a(var9 / 180.0F * 3.1415927F) * DataTypesConverter.b(var10 / 180.0F * 3.1415927F) * var8);
						var12.motionZ = (double) (DataTypesConverter.b(var9 / 180.0F * 3.1415927F) * DataTypesConverter.b(var10 / 180.0F * 3.1415927F) * var8);
						var12.motionY = (double) (-DataTypesConverter.a(var10 / 180.0F * 3.1415927F) * var8 + 0.1F);
						var12.p();
						this.f.o.d((Entity) var12);
						break;
					}
				}
			}
		}

	}
}
