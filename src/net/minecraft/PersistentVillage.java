package net.minecraft;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class PersistentVillage extends bqc {

	private World b;
	private final List c = Lists.newArrayList();
	private final List d = Lists.newArrayList();
	private final List e = Lists.newArrayList();
	private int f;

	public PersistentVillage(String var1) {
		super(var1);
	}

	public PersistentVillage(World var1) {
		super(a(var1.worldProvider));
		this.b = var1;
		this.c();
	}

	public void a(World var1) {
		this.b = var1;
		Iterator var2 = this.e.iterator();

		while (var2.hasNext()) {
			abi var3 = (abi) var2.next();
			var3.a(var1);
		}

	}

	public void a(Position var1) {
		if (this.c.size() <= 64) {
			if (!this.e(var1)) {
				this.c.add(var1);
			}

		}
	}

	public void a() {
		++this.f;
		Iterator var1 = this.e.iterator();

		while (var1.hasNext()) {
			abi var2 = (abi) var1.next();
			var2.a(this.f);
		}

		this.e();
		this.f();
		this.g();
		if (this.f % 400 == 0) {
			this.c();
		}

	}

	private void e() {
		Iterator var1 = this.e.iterator();

		while (var1.hasNext()) {
			abi var2 = (abi) var1.next();
			if (var2.g()) {
				var1.remove();
				this.c();
			}
		}

	}

	public List b() {
		return this.e;
	}

	public abi a(Position var1, int var2) {
		abi var3 = null;
		double var4 = 3.4028234663852886E38D;
		Iterator var6 = this.e.iterator();

		while (var6.hasNext()) {
			abi var7 = (abi) var6.next();
			double var8 = var7.a().i(var1);
			if (var8 < var4) {
				float var10 = (float) (var2 + var7.b());
				if (var8 <= (double) (var10 * var10)) {
					var3 = var7;
					var4 = var8;
				}
			}
		}

		return var3;
	}

	private void f() {
		if (!this.c.isEmpty()) {
			this.b((Position) this.c.remove(0));
		}
	}

	private void g() {
		for (int var1 = 0; var1 < this.d.size(); ++var1) {
			abh var2 = (abh) this.d.get(var1);
			abi var3 = this.a(var2.d(), 32);
			if (var3 == null) {
				var3 = new abi(this.b);
				this.e.add(var3);
				this.c();
			}

			var3.a(var2);
		}

		this.d.clear();
	}

	private void b(Position var1) {
		byte var2 = 16;
		byte var3 = 4;
		byte var4 = 16;

		for (int var5 = -var2; var5 < var2; ++var5) {
			for (int var6 = -var3; var6 < var3; ++var6) {
				for (int var7 = -var4; var7 < var4; ++var7) {
					Position var8 = var1.a(var5, var6, var7);
					if (this.f(var8)) {
						abh var9 = this.c(var8);
						if (var9 == null) {
							this.d(var8);
						} else {
							var9.a(this.f);
						}
					}
				}
			}
		}

	}

	private abh c(Position var1) {
		Iterator var2 = this.d.iterator();

		abh var3;
		do {
			if (!var2.hasNext()) {
				var2 = this.e.iterator();

				abh var4;
				do {
					if (!var2.hasNext()) {
						return null;
					}

					abi var5 = (abi) var2.next();
					var4 = var5.e(var1);
				} while (var4 == null);

				return var4;
			}

			var3 = (abh) var2.next();
		} while (var3.d().getX() != var1.getX() || var3.d().getZ() != var1.getZ() || Math.abs(var3.d().getY() - var1.getY()) > 1);

		return var3;
	}

	private void d(Position var1) {
		BlockFace var2 = BlockDoor.h(this.b, var1);
		BlockFace var3 = var2.getOpposite();
		int var4 = this.a(var1, var2, 5);
		int var5 = this.a(var1, var3, var4 + 1);
		if (var4 != var5) {
			this.d.add(new abh(var1, var4 < var5 ? var2 : var3, this.f));
		}

	}

	private int a(Position var1, BlockFace var2, int var3) {
		int var4 = 0;

		for (int var5 = 1; var5 <= 5; ++var5) {
			if (this.b.i(var1.a(var2, var5))) {
				++var4;
				if (var4 >= var3) {
					return var4;
				}
			}
		}

		return var4;
	}

	private boolean e(Position var1) {
		Iterator var2 = this.c.iterator();

		Position var3;
		do {
			if (!var2.hasNext()) {
				return false;
			}

			var3 = (Position) var2.next();
		} while (!var3.equals(var1));

		return true;
	}

	private boolean f(Position var1) {
		Block var2 = this.b.getBlockState(var1).getBlock();
		return var2 instanceof BlockDoor ? var2.getMaterial() == Material.WOOD : false;
	}

	public void a(NBTCompoundTag var1) {
		this.f = var1.getInt("Tick");
		NBTListTag var2 = var1.getList("Villages", 10);

		for (int var3 = 0; var3 < var2.getSize(); ++var3) {
			NBTCompoundTag var4 = var2.getCompound(var3);
			abi var5 = new abi();
			var5.a(var4);
			this.e.add(var5);
		}

	}

	public void b(NBTCompoundTag var1) {
		var1.put("Tick", this.f);
		NBTListTag var2 = new NBTListTag();
		Iterator var3 = this.e.iterator();

		while (var3.hasNext()) {
			abi var4 = (abi) var3.next();
			NBTCompoundTag var5 = new NBTCompoundTag();
			var4.b(var5);
			var2.addTag((NBTTag) var5);
		}

		var1.put("Villages", (NBTTag) var2);
	}

	public static String a(WorldProvider var0) {
		return "villages" + var0.getWorldSuffix();
	}
}
