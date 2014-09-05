package net.minecraft;

import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class qy {

	private static final Logger p = LogManager.getLogger();
	public Entity a;
	public int b;
	public int c;
	public int d;
	public int e;
	public int f;
	public int g;
	public int h;
	public int i;
	public double j;
	public double k;
	public double l;
	public int m;
	private double q;
	private double r;
	private double s;
	private boolean t;
	private boolean u;
	private int v;
	private Entity w;
	private boolean x;
	private boolean y;
	public boolean n;
	public Set o = Sets.newHashSet();

	public qy(Entity var1, int var2, int var3, boolean var4) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
		this.u = var4;
		this.d = DataTypesConverter.toFixedPointInt(var1.locationX * 32.0D);
		this.e = DataTypesConverter.toFixedPointInt(var1.locationY * 32.0D);
		this.f = DataTypesConverter.toFixedPointInt(var1.locationZ * 32.0D);
		this.g = DataTypesConverter.d(var1.yaw * 256.0F / 360.0F);
		this.h = DataTypesConverter.d(var1.pitch * 256.0F / 360.0F);
		this.i = DataTypesConverter.d(var1.aD() * 256.0F / 360.0F);
		this.y = var1.onGround;
	}

	public boolean equals(Object var1) {
		return var1 instanceof qy ? ((qy) var1).a.getId() == this.a.getId() : false;
	}

	public int hashCode() {
		return this.a.getId();
	}

	public void a(List var1) {
		this.n = false;
		if (!this.t || this.a.e(this.q, this.r, this.s) > 16.0D) {
			this.q = this.a.locationX;
			this.r = this.a.locationY;
			this.s = this.a.locationZ;
			this.t = true;
			this.n = true;
			this.b(var1);
		}

		if (this.w != this.a.m || this.a.m != null && this.m % 60 == 0) {
			this.w = this.a.m;
			this.a((Packet) (new PacketAttachEntity(0, this.a, this.a.m)));
		}

		if (this.a instanceof adk && this.m % 10 == 0) {
			adk var2 = (adk) this.a;
			ItemStack var3 = var2.o();
			if (var3 != null && var3.getItem() instanceof amn) {
				bqe var4 = amk.bd.a(var3, this.a.o);
				Iterator var5 = var1.iterator();

				while (var5.hasNext()) {
					EntityHuman var6 = (EntityHuman) var5.next();
					EntityPlayer var7 = (EntityPlayer) var6;
					var4.a(var7, var3);
					Packet var8 = amk.bd.c(var3, this.a.o, var7);
					if (var8 != null) {
						var7.a.a(var8);
					}
				}
			}

			this.b();
		}

		if (this.m % this.c == 0 || this.a.ai || this.a.getDataWatcher().a()) {
			int var23;
			int var24;
			if (this.a.m == null) {
				++this.v;
				var23 = DataTypesConverter.toFixedPointInt(this.a.locationX * 32.0D);
				var24 = DataTypesConverter.toFixedPointInt(this.a.locationY * 32.0D);
				int var25 = DataTypesConverter.toFixedPointInt(this.a.locationZ * 32.0D);
				int var27 = DataTypesConverter.d(this.a.yaw * 256.0F / 360.0F);
				int var28 = DataTypesConverter.d(this.a.pitch * 256.0F / 360.0F);
				int var29 = var23 - this.d;
				int var30 = var24 - this.e;
				int var9 = var25 - this.f;
				Object var10 = null;
				boolean var11 = Math.abs(var29) >= 4 || Math.abs(var30) >= 4 || Math.abs(var9) >= 4 || this.m % 60 == 0;
				boolean var12 = Math.abs(var27 - this.g) >= 4 || Math.abs(var28 - this.h) >= 4;
				if (this.m > 0 || this.a instanceof ahj) {
					if (var29 >= -128 && var29 < 128 && var30 >= -128 && var30 < 128 && var9 >= -128 && var9 < 128 && this.v <= 400 && !this.x && this.y == this.a.onGround) {
						if (var11 && var12) {
							var10 = new PacketEntityRelativeLookMove(this.a.getId(), (byte) var29, (byte) var30, (byte) var9, (byte) var27, (byte) var28, this.a.onGround);
						} else if (var11) {
							var10 = new PacketEntityRelativeMove(this.a.getId(), (byte) var29, (byte) var30, (byte) var9, this.a.onGround);
						} else if (var12) {
							var10 = new PacketEntityLook(this.a.getId(), (byte) var27, (byte) var28, this.a.onGround);
						}
					} else {
						this.y = this.a.onGround;
						this.v = 0;
						var10 = new PacketEntityTeleport(this.a.getId(), var23, var24, var25, (byte) var27, (byte) var28, this.a.onGround);
					}
				}

				if (this.u) {
					double var13 = this.a.motionX - this.j;
					double var15 = this.a.motionY - this.k;
					double var17 = this.a.motionZ - this.l;
					double var19 = 0.02D;
					double var21 = var13 * var13 + var15 * var15 + var17 * var17;
					if (var21 > var19 * var19 || var21 > 0.0D && this.a.motionX == 0.0D && this.a.motionY == 0.0D && this.a.motionZ == 0.0D) {
						this.j = this.a.motionX;
						this.k = this.a.motionY;
						this.l = this.a.motionZ;
						this.a((Packet) (new PacketEntityVelocity(this.a.getId(), this.j, this.k, this.l)));
					}
				}

				if (var10 != null) {
					this.a((Packet) var10);
				}

				this.b();
				if (var11) {
					this.d = var23;
					this.e = var24;
					this.f = var25;
				}

				if (var12) {
					this.g = var27;
					this.h = var28;
				}

				this.x = false;
			} else {
				var23 = DataTypesConverter.d(this.a.yaw * 256.0F / 360.0F);
				var24 = DataTypesConverter.d(this.a.pitch * 256.0F / 360.0F);
				boolean var26 = Math.abs(var23 - this.g) >= 4 || Math.abs(var24 - this.h) >= 4;
				if (var26) {
					this.a((Packet) (new PacketEntityLook(this.a.getId(), (byte) var23, (byte) var24, this.a.onGround)));
					this.g = var23;
					this.h = var24;
				}

				this.d = DataTypesConverter.toFixedPointInt(this.a.locationX * 32.0D);
				this.e = DataTypesConverter.toFixedPointInt(this.a.locationY * 32.0D);
				this.f = DataTypesConverter.toFixedPointInt(this.a.locationZ * 32.0D);
				this.b();
				this.x = true;
			}

			var23 = DataTypesConverter.d(this.a.aD() * 256.0F / 360.0F);
			if (Math.abs(var23 - this.i) >= 4) {
				this.a((Packet) (new PacketEntityHeadLook(this.a, (byte) var23)));
				this.i = var23;
			}

			this.a.ai = false;
		}

		++this.m;
		if (this.a.G) {
			this.b((Packet) (new PacketEntityVelocity(this.a)));
			this.a.G = false;
		}

	}

	private void b() {
		DataWatcher var1 = this.a.getDataWatcher();
		if (var1.a()) {
			this.b((Packet) (new PacketEntityMetadata(this.a.getId(), var1, false)));
		}

		if (this.a instanceof EntityLiving) {
			yf var2 = (yf) ((EntityLiving) this.a).bx();
			Set var3 = var2.b();
			if (!var3.isEmpty()) {
				this.b((Packet) (new PacketEntityProperties(this.a.getId(), var3)));
			}

			var3.clear();
		}

	}

	public void a(Packet var1) {
		Iterator var2 = this.o.iterator();

		while (var2.hasNext()) {
			EntityPlayer var3 = (EntityPlayer) var2.next();
			var3.a.a(var1);
		}

	}

	public void b(Packet var1) {
		this.a(var1);
		if (this.a instanceof EntityPlayer) {
			((EntityPlayer) this.a).a.a(var1);
		}

	}

	public void a() {
		Iterator var1 = this.o.iterator();

		while (var1.hasNext()) {
			EntityPlayer var2 = (EntityPlayer) var1.next();
			var2.d(this.a);
		}

	}

	public void a(EntityPlayer var1) {
		if (this.o.contains(var1)) {
			var1.d(this.a);
			this.o.remove(var1);
		}

	}

	public void b(EntityPlayer var1) {
		if (var1 != this.a) {
			if (this.c(var1)) {
				if (!this.o.contains(var1) && (this.e(var1) || this.a.n)) {
					this.o.add(var1);
					Packet var2 = this.c();
					var1.a.a(var2);
					if (!this.a.getDataWatcher().d()) {
						var1.a.a((Packet) (new PacketEntityMetadata(this.a.getId(), this.a.getDataWatcher(), true)));
					}

					NBTCompoundTag var3 = this.a.aU();
					if (var3 != null) {
						var1.a.a((Packet) (new jl(this.a.getId(), var3)));
					}

					if (this.a instanceof EntityLiving) {
						yf var4 = (yf) ((EntityLiving) this.a).bx();
						Collection var5 = var4.c();
						if (!var5.isEmpty()) {
							var1.a.a((Packet) (new PacketEntityProperties(this.a.getId(), var5)));
						}
					}

					this.j = this.a.motionX;
					this.k = this.a.motionY;
					this.l = this.a.motionZ;
					if (this.u && !(var2 instanceof PacketSpawnMob)) {
						var1.a.a((Packet) (new PacketEntityVelocity(this.a.getId(), this.a.motionX, this.a.motionY, this.a.motionZ)));
					}

					if (this.a.m != null) {
						var1.a.a((Packet) (new PacketAttachEntity(0, this.a, this.a.m)));
					}

					if (this.a instanceof xn && ((xn) this.a).cc() != null) {
						var1.a.a((Packet) (new PacketAttachEntity(1, this.a, ((xn) this.a).cc())));
					}

					if (this.a instanceof EntityLiving) {
						for (int var7 = 0; var7 < 5; ++var7) {
							ItemStack var10 = ((EntityLiving) this.a).p(var7);
							if (var10 != null) {
								var1.a.a((Packet) (new PacketEntityEquipment(this.a.getId(), var7, var10)));
							}
						}
					}

					if (this.a instanceof EntityHuman) {
						EntityHuman var8 = (EntityHuman) this.a;
						if (var8.bI()) {
							var1.a.a((Packet) (new PacketUseBed(var8, new Position(this.a))));
						}
					}

					if (this.a instanceof EntityLiving) {
						EntityLiving var9 = (EntityLiving) this.a;
						Iterator var11 = var9.bk().iterator();

						while (var11.hasNext()) {
							MobEffect var6 = (MobEffect) var11.next();
							var1.a.a((Packet) (new PacketEntityEffect(this.a.getId(), var6)));
						}
					}
				}
			} else if (this.o.contains(var1)) {
				this.o.remove(var1);
				var1.d(this.a);
			}

		}
	}

	public boolean c(EntityPlayer var1) {
		double var2 = var1.locationX - (double) (this.d / 32);
		double var4 = var1.locationZ - (double) (this.f / 32);
		return var2 >= (double) (-this.b) && var2 <= (double) this.b && var4 >= (double) (-this.b) && var4 <= (double) this.b && this.a.a(var1);
	}

	private boolean e(EntityPlayer var1) {
		return var1.u().t().a(var1, this.a.ae, this.a.ag);
	}

	public void b(List var1) {
		for (int var2 = 0; var2 < var1.size(); ++var2) {
			this.b((EntityPlayer) var1.get(var2));
		}

	}

	private Packet c() {
		if (this.a.I) {
			p.warn("Fetching addPacket for removed entity");
		}

		if (this.a instanceof adw) {
			return new PacketSpawnObject(this.a, 2, 1);
		} else if (this.a instanceof EntityPlayer) {
			return new PacketSpawnPlayer((EntityHuman) this.a);
		} else if (this.a instanceof adx) {
			adx var9 = (adx) this.a;
			return new PacketSpawnObject(this.a, 10, var9.s().a());
		} else if (this.a instanceof adu) {
			return new PacketSpawnObject(this.a, 1);
		} else if (this.a instanceof wt) {
			this.i = DataTypesConverter.d(this.a.aD() * 256.0F / 360.0F);
			return new PacketSpawnMob((EntityLiving) this.a);
		} else if (this.a instanceof ado) {
			EntityHuman var8 = ((ado) this.a).b;
			return new PacketSpawnObject(this.a, 90, var8 != null ? var8.getId() : this.a.getId());
		} else if (this.a instanceof ahj) {
			Entity var7 = ((ahj) this.a).c;
			return new PacketSpawnObject(this.a, 60, var7 != null ? var7.getId() : this.a.getId());
		} else if (this.a instanceof ahq) {
			return new PacketSpawnObject(this.a, 61);
		} else if (this.a instanceof ahv) {
			return new PacketSpawnObject(this.a, 73, ((ahv) this.a).o());
		} else if (this.a instanceof ahu) {
			return new PacketSpawnObject(this.a, 75);
		} else if (this.a instanceof aht) {
			return new PacketSpawnObject(this.a, 65);
		} else if (this.a instanceof ahk) {
			return new PacketSpawnObject(this.a, 72);
		} else if (this.a instanceof ahm) {
			return new PacketSpawnObject(this.a, 76);
		} else {
			PacketSpawnObject var2;
			if (this.a instanceof ahl) {
				ahl var6 = (ahl) this.a;
				var2 = null;
				byte var10 = 63;
				if (this.a instanceof ahp) {
					var10 = 64;
				} else if (this.a instanceof ahw) {
					var10 = 66;
				}

				if (var6.a != null) {
					var2 = new PacketSpawnObject(this.a, var10, ((ahl) this.a).a.getId());
				} else {
					var2 = new PacketSpawnObject(this.a, var10, 0);
				}

				var2.setSpeedX((int) (var6.b * 8000.0D));
				var2.setSpeedY((int) (var6.c * 8000.0D));
				var2.setSpeedZ((int) (var6.d * 8000.0D));
				return var2;
			} else if (this.a instanceof ahs) {
				return new PacketSpawnObject(this.a, 62);
			} else if (this.a instanceof aek) {
				return new PacketSpawnObject(this.a, 50);
			} else if (this.a instanceof ada) {
				return new PacketSpawnObject(this.a, 51);
			} else if (this.a instanceof adv) {
				adv var5 = (adv) this.a;
				return new PacketSpawnObject(this.a, 70, Block.f(var5.l()));
			} else if (this.a instanceof adi) {
				return new PacketSpawnObject(this.a, 78);
			} else if (this.a instanceof EntityPainting) {
				return new PacketSpawnPainting((EntityPainting) this.a);
			} else {
				Position var3;
				if (this.a instanceof adk) {
					adk var4 = (adk) this.a;
					var2 = new PacketSpawnObject(this.a, 71, var4.direction.toByte());
					var3 = var4.getPosition();
					var2.setX(DataTypesConverter.d((float) (var3.n() * 32)));
					var2.setY(DataTypesConverter.d((float) (var3.o() * 32)));
					var2.setZ(DataTypesConverter.d((float) (var3.p() * 32)));
					return var2;
				} else if (this.a instanceof adl) {
					adl var1 = (adl) this.a;
					var2 = new PacketSpawnObject(this.a, 77);
					var3 = var1.getPosition();
					var2.setX(DataTypesConverter.d((float) (var3.n() * 32)));
					var2.setY(DataTypesConverter.d((float) (var3.o() * 32)));
					var2.setZ(DataTypesConverter.d((float) (var3.p() * 32)));
					return var2;
				} else if (this.a instanceof ExpirienceOrb) {
					return new PacketSpawnExpirienceOrb((ExpirienceOrb) this.a);
				} else {
					throw new IllegalArgumentException("Don\'t know how to add " + this.a.getClass() + "!");
				}
			}
		}
	}

	public void d(EntityPlayer var1) {
		if (this.o.contains(var1)) {
			this.o.remove(var1);
			var1.d(this.a);
		}

	}

}
