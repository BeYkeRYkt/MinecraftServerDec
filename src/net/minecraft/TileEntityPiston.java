package net.minecraft;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class TileEntityPiston extends TileEntity implements pm {

	private bec a;
	private PaintingDirection f;
	private boolean g;
	private boolean h;
	private float i;
	private float j;
	private List k = Lists.newArrayList();

	public TileEntityPiston() {
	}

	public TileEntityPiston(bec var1, PaintingDirection var2, boolean var3, boolean var4) {
		this.a = var1;
		this.f = var2;
		this.g = var3;
		this.h = var4;
	}

	public bec b() {
		return this.a;
	}

	public int u() {
		return 0;
	}

	public boolean d() {
		return this.g;
	}

	public PaintingDirection e() {
		return this.f;
	}

	public float a(float var1) {
		if (var1 > 1.0F) {
			var1 = 1.0F;
		}

		return this.j + (this.i - this.j) * var1;
	}

	private void a(float var1, float var2) {
		if (this.g) {
			var1 = 1.0F - var1;
		} else {
			--var1;
		}

		brt var3 = Blocks.PISTON_EXTENSION.a(this.world, this.position, this.a, var1, this.f);
		if (var3 != null) {
			List var4 = this.world.b((Entity) null, var3);
			if (!var4.isEmpty()) {
				this.k.addAll(var4);
				Iterator var5 = this.k.iterator();

				while (var5.hasNext()) {
					Entity var6 = (Entity) var5.next();
					if (this.a.getBlock() == Blocks.cE && this.g) {
						switch (bdw.a[this.f.k().ordinal()]) {
							case 1:
								var6.motionX = (double) this.f.g();
								break;
							case 2:
								var6.motionY = (double) this.f.h();
								break;
							case 3:
								var6.motionZ = (double) this.f.i();
						}
					} else {
						var6.d((double) (var2 * (float) this.f.g()), (double) (var2 * (float) this.f.h()), (double) (var2 * (float) this.f.i()));
					}
				}

				this.k.clear();
			}
		}

	}

	public void h() {
		if (this.j < 1.0F && this.world != null) {
			this.j = this.i = 1.0F;
			this.world.t(this.position);
			this.y();
			if (this.world.p(this.position).getBlock() == Blocks.PISTON_EXTENSION) {
				this.world.a(this.position, this.a, 3);
				this.world.d(this.position, this.a.getBlock());
			}
		}

	}

	public void c() {
		this.j = this.i;
		if (this.j >= 1.0F) {
			this.a(1.0F, 0.25F);
			this.world.t(this.position);
			this.y();
			if (this.world.p(this.position).getBlock() == Blocks.PISTON_EXTENSION) {
				this.world.a(this.position, this.a, 3);
				this.world.d(this.position, this.a.getBlock());
			}

		} else {
			this.i += 0.5F;
			if (this.i >= 1.0F) {
				this.i = 1.0F;
			}

			if (this.g) {
				this.a(this.i, this.i - this.j + 0.0625F);
			}

		}
	}

	public void read(NBTCompoundTag var1) {
		super.read(var1);
		this.a = Block.c(var1.getInt("blockId")).a(var1.getInt("blockData"));
		this.f = PaintingDirection.a(var1.getInt("facing"));
		this.j = this.i = var1.getFloat("progress");
		this.g = var1.getBoolean("extending");
	}

	public void write(NBTCompoundTag var1) {
		super.write(var1);
		var1.put("blockId", Block.a(this.a.getBlock()));
		var1.put("blockData", this.a.getBlock().c(this.a));
		var1.put("facing", this.f.a());
		var1.put("progress", this.j);
		var1.put("extending", this.g);
	}
}
