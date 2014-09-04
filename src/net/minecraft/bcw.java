package net.minecraft;

public class bcw extends bcm implements pm {

	public void c() {
		if (this.b != null && !this.b.D && this.b.K() % 20L == 0L) {
			this.e = this.w();
			if (this.e instanceof auv) {
				((auv) this.e).d(this.b, this.c);
			}
		}

	}
}
