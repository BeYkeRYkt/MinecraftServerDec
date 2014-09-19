package net.minecraft;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class Village {

	private World a;
	private final List b = Lists.newArrayList();
	private Position c;
	private Position d;
	private int e;
	private int f;
	private int g;
	private int h;
	private int i;
	private TreeMap j;
	private List k;
	private int l;

	public Village() {
		this.c = Position.ZERO;
		this.d = Position.ZERO;
		this.j = new TreeMap();
		this.k = Lists.newArrayList();
	}

	public Village(World var1) {
		this.c = Position.ZERO;
		this.d = Position.ZERO;
		this.j = new TreeMap();
		this.k = Lists.newArrayList();
		this.a = var1;
	}

	public void a(World var1) {
		this.a = var1;
	}

	public void a(int var1) {
		this.g = var1;
		this.m();
		this.l();
		if (var1 % 20 == 0) {
			this.k();
		}

		if (var1 % 30 == 0) {
			this.j();
		}

		int var2 = this.h / 10;
		if (this.l < var2 && this.b.size() > 20 && this.a.random.nextInt(7000) == 0) {
			Vec3D var3 = this.a(this.d, 2, 4, 2);
			if (var3 != null) {
				EntityIronGolem var4 = new EntityIronGolem(this.a);
				var4.b(var3.x, var3.y, var3.z);
				this.a.addEntity((Entity) var4);
				++this.l;
			}
		}

	}

	private Vec3D a(Position var1, int var2, int var3, int var4) {
		for (int var5 = 0; var5 < 10; ++var5) {
			Position var6 = var1.a(this.a.random.nextInt(16) - 8, this.a.random.nextInt(6) - 3, this.a.random.nextInt(16) - 8);
			if (this.a(var6) && this.a(new Position(var2, var3, var4), var6)) {
				return new Vec3D((double) var6.getX(), (double) var6.getY(), (double) var6.getZ());
			}
		}

		return null;
	}

	private boolean a(Position var1, Position var2) {
		if (!World.a((ard) this.a, var2.b())) {
			return false;
		} else {
			int var3 = var2.getX() - var1.getX() / 2;
			int var4 = var2.getZ() - var1.getZ() / 2;

			for (int var5 = var3; var5 < var3 + var1.getX(); ++var5) {
				for (int var6 = var2.getY(); var6 < var2.getY() + var1.getY(); ++var6) {
					for (int var7 = var4; var7 < var4 + var1.getZ(); ++var7) {
						if (this.a.getBlockState(new Position(var5, var6, var7)).getBlock().t()) {
							return false;
						}
					}
				}
			}

			return true;
		}
	}

	private void j() {
		List var1 = this.a.getEntititesInAABB(EntityIronGolem.class, new AxisAlignedBB((double) (this.d.getX() - this.e), (double) (this.d.getY() - 4), (double) (this.d.getZ() - this.e), (double) (this.d.getX() + this.e), (double) (this.d.getY() + 4), (double) (this.d.getZ() + this.e)));
		this.l = var1.size();
	}

	private void k() {
		List var1 = this.a.getEntititesInAABB(EntityVillager.class, new AxisAlignedBB((double) (this.d.getX() - this.e), (double) (this.d.getY() - 4), (double) (this.d.getZ() - this.e), (double) (this.d.getX() + this.e), (double) (this.d.getY() + 4), (double) (this.d.getZ() + this.e)));
		this.h = var1.size();
		if (this.h == 0) {
			this.j.clear();
		}

	}

	public Position a() {
		return this.d;
	}

	public int b() {
		return this.e;
	}

	public int c() {
		return this.b.size();
	}

	public int d() {
		return this.g - this.f;
	}

	public int e() {
		return this.h;
	}

	public boolean a(Position var1) {
		return this.d.i(var1) < (double) (this.e * this.e);
	}

	public List f() {
		return this.b;
	}

	public abh b(Position var1) {
		abh var2 = null;
		int var3 = Integer.MAX_VALUE;
		Iterator var4 = this.b.iterator();

		while (var4.hasNext()) {
			abh var5 = (abh) var4.next();
			int var6 = var5.a(var1);
			if (var6 < var3) {
				var2 = var5;
				var3 = var6;
			}
		}

		return var2;
	}

	public abh c(Position var1) {
		abh var2 = null;
		int var3 = Integer.MAX_VALUE;
		Iterator var4 = this.b.iterator();

		while (var4.hasNext()) {
			abh var5 = (abh) var4.next();
			int var6 = var5.a(var1);
			if (var6 > 256) {
				var6 *= 1000;
			} else {
				var6 = var5.c();
			}

			if (var6 < var3) {
				var2 = var5;
				var3 = var6;
			}
		}

		return var2;
	}

	public abh e(Position var1) {
		if (this.d.i(var1) > (double) (this.e * this.e)) {
			return null;
		} else {
			Iterator var2 = this.b.iterator();

			abh var3;
			do {
				if (!var2.hasNext()) {
					return null;
				}

				var3 = (abh) var2.next();
			} while (var3.d().getX() != var1.getX() || var3.d().getZ() != var1.getZ() || Math.abs(var3.d().getY() - var1.getY()) > 1);

			return var3;
		}
	}

	public void a(abh var1) {
		this.b.add(var1);
		this.c = this.c.a((fd) var1.d());
		this.n();
		this.f = var1.h();
	}

	public boolean g() {
		return this.b.isEmpty();
	}

	public void a(EntityLiving var1) {
		Iterator var2 = this.k.iterator();

		abj var3;
		do {
			if (!var2.hasNext()) {
				this.k.add(new abj(this, var1, this.g));
				return;
			}

			var3 = (abj) var2.next();
		} while (var3.a != var1);

		var3.b = this.g;
	}

	public EntityLiving b(EntityLiving var1) {
		double var2 = Double.MAX_VALUE;
		abj var4 = null;

		for (int var5 = 0; var5 < this.k.size(); ++var5) {
			abj var6 = (abj) this.k.get(var5);
			double var7 = var6.a.getDistanceSquared(var1);
			if (var7 <= var2) {
				var4 = var6;
				var2 = var7;
			}
		}

		return var4 != null ? var4.a : null;
	}

	public EntityHuman c(EntityLiving var1) {
		double var2 = Double.MAX_VALUE;
		EntityHuman var4 = null;
		Iterator var5 = this.j.keySet().iterator();

		while (var5.hasNext()) {
			String var6 = (String) var5.next();
			if (this.d(var6)) {
				EntityHuman var7 = this.a.a(var6);
				if (var7 != null) {
					double var8 = var7.getDistanceSquared(var1);
					if (var8 <= var2) {
						var4 = var7;
						var2 = var8;
					}
				}
			}
		}

		return var4;
	}

	private void l() {
		Iterator var1 = this.k.iterator();

		while (var1.hasNext()) {
			abj var2 = (abj) var1.next();
			if (!var2.a.isAlive() || Math.abs(this.g - var2.b) > 300) {
				var1.remove();
			}
		}

	}

	private void m() {
		boolean var1 = false;
		boolean var2 = this.a.random.nextInt(50) == 0;
		Iterator var3 = this.b.iterator();

		while (var3.hasNext()) {
			abh var4 = (abh) var3.next();
			if (var2) {
				var4.a();
			}

			if (!this.f(var4.d()) || Math.abs(this.g - var4.h()) > 1200) {
				this.c = this.c.a((fd) var4.d().a(-1));
				var1 = true;
				var4.a(true);
				var3.remove();
			}
		}

		if (var1) {
			this.n();
		}

	}

	private boolean f(Position var1) {
		Block var2 = this.a.getBlockState(var1).getBlock();
		return var2 instanceof BlockDoor ? var2.getMaterial() == Material.WOOD : false;
	}

	private void n() {
		int var1 = this.b.size();
		if (var1 == 0) {
			this.d = new Position(0, 0, 0);
			this.e = 0;
		} else {
			this.d = new Position(this.c.getX() / var1, this.c.getY() / var1, this.c.getZ() / var1);
			int var2 = 0;

			abh var4;
			for (Iterator var3 = this.b.iterator(); var3.hasNext(); var2 = Math.max(var4.a(this.d), var2)) {
				var4 = (abh) var3.next();
			}

			this.e = Math.max(32, (int) Math.sqrt((double) var2) + 1);
		}
	}

	public int a(String var1) {
		Integer var2 = (Integer) this.j.get(var1);
		return var2 != null ? var2.intValue() : 0;
	}

	public int a(String var1, int var2) {
		int var3 = this.a(var1);
		int var4 = MathHelper.a(var3 + var2, -30, 10);
		this.j.put(var1, Integer.valueOf(var4));
		return var4;
	}

	public boolean d(String var1) {
		return this.a(var1) <= -15;
	}

	public void a(NBTCompoundTag var1) {
		this.h = var1.getInt("PopSize");
		this.e = var1.getInt("Radius");
		this.l = var1.getInt("Golems");
		this.f = var1.getInt("Stable");
		this.g = var1.getInt("Tick");
		this.i = var1.getInt("MTick");
		this.d = new Position(var1.getInt("CX"), var1.getInt("CY"), var1.getInt("CZ"));
		this.c = new Position(var1.getInt("ACX"), var1.getInt("ACY"), var1.getInt("ACZ"));
		NBTListTag var2 = var1.getList("Doors", 10);

		for (int var3 = 0; var3 < var2.getSize(); ++var3) {
			NBTCompoundTag var4 = var2.getCompound(var3);
			abh var5 = new abh(new Position(var4.getInt("X"), var4.getInt("Y"), var4.getInt("Z")), var4.getInt("IDX"), var4.getInt("IDZ"), var4.getInt("TS"));
			this.b.add(var5);
		}

		NBTListTag var6 = var1.getList("Players", 10);

		for (int var7 = 0; var7 < var6.getSize(); ++var7) {
			NBTCompoundTag var8 = var6.getCompound(var7);
			this.j.put(var8.getString("Name"), Integer.valueOf(var8.getInt("S")));
		}

	}

	public void b(NBTCompoundTag var1) {
		var1.put("PopSize", this.h);
		var1.put("Radius", this.e);
		var1.put("Golems", this.l);
		var1.put("Stable", this.f);
		var1.put("Tick", this.g);
		var1.put("MTick", this.i);
		var1.put("CX", this.d.getX());
		var1.put("CY", this.d.getY());
		var1.put("CZ", this.d.getZ());
		var1.put("ACX", this.c.getX());
		var1.put("ACY", this.c.getY());
		var1.put("ACZ", this.c.getZ());
		NBTListTag var2 = new NBTListTag();
		Iterator var3 = this.b.iterator();

		while (var3.hasNext()) {
			abh var4 = (abh) var3.next();
			NBTCompoundTag var5 = new NBTCompoundTag();
			var5.put("X", var4.d().getX());
			var5.put("Y", var4.d().getY());
			var5.put("Z", var4.d().getZ());
			var5.put("IDX", var4.f());
			var5.put("IDZ", var4.g());
			var5.put("TS", var4.h());
			var2.addTag((NBTTag) var5);
		}

		var1.put("Doors", (NBTTag) var2);
		NBTListTag var7 = new NBTListTag();
		Iterator var8 = this.j.keySet().iterator();

		while (var8.hasNext()) {
			String var9 = (String) var8.next();
			NBTCompoundTag var6 = new NBTCompoundTag();
			var6.put("Name", var9);
			var6.put("S", ((Integer) this.j.get(var9)).intValue());
			var7.addTag((NBTTag) var6);
		}

		var1.put("Players", (NBTTag) var7);
	}

	public void h() {
		this.i = this.g;
	}

	public boolean i() {
		return this.i == 0 || this.g - this.i >= 3600;
	}

	public void b(int var1) {
		Iterator var2 = this.j.keySet().iterator();

		while (var2.hasNext()) {
			String var3 = (String) var2.next();
			this.a(var3, var1);
		}

	}
}
