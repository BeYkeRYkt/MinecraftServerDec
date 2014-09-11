package net.minecraft;

public class acz extends Entity {

	public final acy a;
	public final String b;

	public acz(acy var1, String var2, float var3, float var4) {
		super(var1.a());
		this.a(var3, var4);
		this.a = var1;
		this.b = var2;
	}

	protected void h() {
	}

	protected void a(NBTCompoundTag var1) {
	}

	protected void b(NBTCompoundTag var1) {
	}

	public boolean ad() {
		return true;
	}

	public boolean damageEntity(DamageSource var1, float var2) {
		return this.b(var1) ? false : this.a.a(this, var1, var2);
	}

	public boolean k(Entity var1) {
		return this == var1 || this.a == var1;
	}
}
