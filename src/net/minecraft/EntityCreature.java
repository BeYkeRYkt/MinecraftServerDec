package net.minecraft;

import java.util.UUID;

public abstract class EntityCreature extends xn {

	public static final UUID bi = UUID.fromString("E199AD21-BA8A-4C53-8D13-6182D5C69D3A");
	public static final AttributeModifier bj = (new AttributeModifier(bi, "Fleeing speed bonus", 2.0D, 2)).setSerializable(false);
	private Position a;
	private float b;
	private zb c;
	private boolean bk;

	public EntityCreature(World var1) {
		super(var1);
		this.a = Position.a;
		this.b = -1.0F;
		this.c = new zo(this, 1.0D);
	}

	public float a(Position var1) {
		return 0.0F;
	}

	public boolean bQ() {
		return super.bQ() && this.a(new Position(this.locationX, this.aQ().b, this.locationZ)) >= 0.0F;
	}

	public boolean cd() {
		return !this.h.m();
	}

	public boolean ce() {
		return this.d(new Position(this));
	}

	public boolean d(Position var1) {
		return this.b == -1.0F ? true : this.a.i(var1) < (double) (this.b * this.b);
	}

	public void a(Position var1, int var2) {
		this.a = var1;
		this.b = (float) var2;
	}

	public Position cf() {
		return this.a;
	}

	public float cg() {
		return this.b;
	}

	public void ch() {
		this.b = -1.0F;
	}

	public boolean ci() {
		return this.b != -1.0F;
	}

	protected void bZ() {
		super.bZ();
		if (this.cb() && this.cc() != null && this.cc().o == this.o) {
			Entity var1 = this.cc();
			this.a(new Position((int) var1.locationX, (int) var1.locationY, (int) var1.locationZ), 5);
			float var2 = this.g(var1);
			if (this instanceof xx && ((xx) this).cl()) {
				if (var2 > 10.0F) {
					this.a(true, true);
				}

				return;
			}

			if (!this.bk) {
				this.i.a(2, this.c);
				if (this.s() instanceof aay) {
					((aay) this.s()).a(false);
				}

				this.bk = true;
			}

			this.n(var2);
			if (var2 > 4.0F) {
				this.s().a(var1, 1.0D);
			}

			if (var2 > 6.0F) {
				double var3 = (var1.locationX - this.locationX) / (double) var2;
				double var5 = (var1.locationY - this.locationY) / (double) var2;
				double var7 = (var1.locationZ - this.locationZ) / (double) var2;
				this.motionX += var3 * Math.abs(var3) * 0.4D;
				this.motionY += var5 * Math.abs(var5) * 0.4D;
				this.motionZ += var7 * Math.abs(var7) * 0.4D;
			}

			if (var2 > 10.0F) {
				this.a(true, true);
			}
		} else if (!this.cb() && this.bk) {
			this.bk = false;
			this.i.a(this.c);
			if (this.s() instanceof aay) {
				((aay) this.s()).a(true);
			}

			this.ch();
		}

	}

	protected void n(float var1) {
	}

}
