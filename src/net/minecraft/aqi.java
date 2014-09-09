package net.minecraft;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public abstract class aqi {

	private int a = 20;
	private String b = "Pig";
	private final List c = Lists.newArrayList();
	private aqj d;
	private double e;
	private double f;
	private int g = 200;
	private int h = 800;
	private int i = 4;
	private Entity j;
	private int k = 6;
	private int l = 16;
	private int m = 4;

	private String f() {
		if (this.i() == null) {
			if (this.b.equals("Minecart")) {
				this.b = "MinecartRideable";
			}

			return this.b;
		} else {
			return aqj.a(this.i());
		}
	}

	public void a(String var1) {
		this.b = var1;
	}

	private boolean g() {
		Position var1 = this.b();
		return this.a().b((double) var1.getX() + 0.5D, (double) var1.getY() + 0.5D, (double) var1.getZ() + 0.5D, (double) this.l);
	}

	public void c() {
		if (this.g()) {
			Position var1 = this.b();
			double var6;
			if (this.a().D) {
				double var2 = (double) ((float) var1.getX() + this.a().s.nextFloat());
				double var4 = (double) ((float) var1.getY() + this.a().s.nextFloat());
				var6 = (double) ((float) var1.getZ() + this.a().s.nextFloat());
				this.a().a(Particle.l, var2, var4, var6, 0.0D, 0.0D, 0.0D, new int[0]);
				this.a().a(Particle.A, var2, var4, var6, 0.0D, 0.0D, 0.0D, new int[0]);
				if (this.a > 0) {
					--this.a;
				}

				this.f = this.e;
				this.e = (this.e + (double) (1000.0F / ((float) this.a + 200.0F))) % 360.0D;
			} else {
				if (this.a == -1) {
					this.h();
				}

				if (this.a > 0) {
					--this.a;
					return;
				}

				boolean var13 = false;

				for (int var3 = 0; var3 < this.i; ++var3) {
					Entity var14 = EntityTypes.createEntity(this.f(), this.a());
					if (var14 == null) {
						return;
					}

					int var5 = this.a().a(var14.getClass(), (new AxisAlignedBB((double) var1.getX(), (double) var1.getY(), (double) var1.getZ(), (double) (var1.getX() + 1), (double) (var1.getY() + 1), (double) (var1.getZ() + 1))).grow((double) this.m, (double) this.m, (double) this.m)).size();
					if (var5 >= this.k) {
						this.h();
						return;
					}

					var6 = (double) var1.getX() + (this.a().s.nextDouble() - this.a().s.nextDouble()) * (double) this.m + 0.5D;
					double var8 = (double) (var1.getY() + this.a().s.nextInt(3) - 1);
					double var10 = (double) var1.getZ() + (this.a().s.nextDouble() - this.a().s.nextDouble()) * (double) this.m + 0.5D;
					EntityInsentient var12 = var14 instanceof EntityInsentient ? (EntityInsentient) var14 : null;
					var14.setPositionRotation(var6, var8, var10, this.a().s.nextFloat() * 360.0F, 0.0F);
					if (var12 == null || var12.bQ() && var12.bR()) {
						this.a(var14, true);
						this.a().b(2004, var1, 0);
						if (var12 != null) {
							var12.y();
						}

						var13 = true;
					}
				}

				if (var13) {
					this.h();
				}
			}

		}
	}

	private Entity a(Entity var1, boolean var2) {
		if (this.i() != null) {
			NBTCompoundTag var3 = new NBTCompoundTag();
			var1.d(var3);
			Iterator var4 = aqj.b(this.i()).getKeys().iterator();

			while (var4.hasNext()) {
				String var5 = (String) var4.next();
				NBTTag var6 = aqj.b(this.i()).getTag(var5);
				var3.put(var5, var6.getCopy());
			}

			var1.load(var3);
			if (var1.world != null && var2) {
				var1.world.d(var1);
			}

			NBTCompoundTag var12;
			for (Entity var11 = var1; var3.isTagAssignableFrom("Riding", 10); var3 = var12) {
				var12 = var3.getCompound("Riding");
				Entity var13 = EntityTypes.createEntity(var12.getString("id"), var1.world);
				if (var13 != null) {
					NBTCompoundTag var7 = new NBTCompoundTag();
					var13.d(var7);
					Iterator var8 = var12.getKeys().iterator();

					while (var8.hasNext()) {
						String var9 = (String) var8.next();
						NBTTag var10 = var12.getTag(var9);
						var7.put(var9, var10.getCopy());
					}

					var13.load(var7);
					var13.setPositionRotation(var11.locationX, var11.locationY, var11.locationZ, var11.yaw, var11.pitch);
					if (var1.world != null && var2) {
						var1.world.d(var13);
					}

					var11.a(var13);
				}

				var11 = var13;
			}
		} else if (var1 instanceof EntityLiving && var1.world != null && var2) {
			((EntityInsentient) var1).a(var1.world.E(new Position(var1)), (xq) null);
			var1.world.d(var1);
		}

		return var1;
	}

	private void h() {
		if (this.h <= this.g) {
			this.a = this.g;
		} else {
			int var10003 = this.h - this.g;
			this.a = this.g + this.a().s.nextInt(var10003);
		}

		if (this.c.size() > 0) {
			this.a((aqj) vj.a(this.a().s, this.c));
		}

		this.a(1);
	}

	public void a(NBTCompoundTag var1) {
		this.b = var1.getString("EntityId");
		this.a = var1.getShort("Delay");
		this.c.clear();
		if (var1.isTagAssignableFrom("SpawnPotentials", 9)) {
			NBTListTag var2 = var1.getList("SpawnPotentials", 10);

			for (int var3 = 0; var3 < var2.getSize(); ++var3) {
				this.c.add(new aqj(this, var2.getCompound(var3)));
			}
		}

		if (var1.isTagAssignableFrom("SpawnData", 10)) {
			this.a(new aqj(this, var1.getCompound("SpawnData"), this.b));
		} else {
			this.a((aqj) null);
		}

		if (var1.isTagAssignableFrom("MinSpawnDelay", 99)) {
			this.g = var1.getShort("MinSpawnDelay");
			this.h = var1.getShort("MaxSpawnDelay");
			this.i = var1.getShort("SpawnCount");
		}

		if (var1.isTagAssignableFrom("MaxNearbyEntities", 99)) {
			this.k = var1.getShort("MaxNearbyEntities");
			this.l = var1.getShort("RequiredPlayerRange");
		}

		if (var1.isTagAssignableFrom("SpawnRange", 99)) {
			this.m = var1.getShort("SpawnRange");
		}

		if (this.a() != null) {
			this.j = null;
		}

	}

	public void b(NBTCompoundTag var1) {
		var1.put("EntityId", this.f());
		var1.put("Delay", (short) this.a);
		var1.put("MinSpawnDelay", (short) this.g);
		var1.put("MaxSpawnDelay", (short) this.h);
		var1.put("SpawnCount", (short) this.i);
		var1.put("MaxNearbyEntities", (short) this.k);
		var1.put("RequiredPlayerRange", (short) this.l);
		var1.put("SpawnRange", (short) this.m);
		if (this.i() != null) {
			var1.put("SpawnData", aqj.b(this.i()).getCopy());
		}

		if (this.i() != null || this.c.size() > 0) {
			NBTListTag var2 = new NBTListTag();
			if (this.c.size() > 0) {
				Iterator var3 = this.c.iterator();

				while (var3.hasNext()) {
					aqj var4 = (aqj) var3.next();
					var2.addTag((NBTTag) var4.a());
				}
			} else {
				var2.addTag((NBTTag) this.i().a());
			}

			var1.put("SpawnPotentials", (NBTTag) var2);
		}

	}

	public boolean b(int var1) {
		if (var1 == 1 && this.a().D) {
			this.a = this.g;
			return true;
		} else {
			return false;
		}
	}

	private aqj i() {
		return this.d;
	}

	public void a(aqj var1) {
		this.d = var1;
	}

	public abstract void a(int var1);

	public abstract World a();

	public abstract Position b();
}
