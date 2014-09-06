package net.minecraft;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;

public abstract class bmm extends bgt {

	private bmr d;
	protected Map e = Maps.newHashMap();

	public abstract String a();

	protected final void a(World var1, int var2, int var3, int var4, int var5, bgk var6) {
		this.a(var1);
		if (!this.e.containsKey(Long.valueOf(ChunkCoordIntPair.toLongHash(var2, var3)))) {
			this.b.nextInt();

			try {
				if (this.a(var2, var3)) {
					bmv var7 = this.b(var2, var3);
					this.e.put(Long.valueOf(ChunkCoordIntPair.toLongHash(var2, var3)), var7);
					this.a(var2, var3, var7);
				}

			} catch (Throwable var10) {
				CrashReport var8 = CrashReport.generateCrashReport(var10, "Exception preparing structure feature");
				CrashReportSystemDetails var9 = var8.generateSystemDetails("Feature being prepared");
				var9.addDetails("Is feature chunk", (Callable) (new bmn(this, var2, var3)));
				var9.addDetails("Chunk location", (Object) String.format("%d,%d", new Object[] { Integer.valueOf(var2), Integer.valueOf(var3) }));
				var9.addDetails("Chunk pos hash", (Callable) (new bmo(this, var2, var3)));
				var9.addDetails("Structure type", (Callable) (new bmp(this)));
				throw new ReportedException(var8);
			}
		}
	}

	public boolean a(World var1, Random var2, ChunkCoordIntPair var3) {
		this.a(var1);
		int var4 = (var3.chunkX << 4) + 8;
		int var5 = (var3.chunkZ << 4) + 8;
		boolean var6 = false;
		Iterator var7 = this.e.values().iterator();

		while (var7.hasNext()) {
			bmv var8 = (bmv) var7.next();
			if (var8.d() && var8.a(var3) && var8.a().a(var4, var5, var4 + 15, var5 + 15)) {
				var8.a(var1, var2, new bjb(var4, var5, var4 + 15, var5 + 15));
				var8.b(var3);
				var6 = true;
				this.a(var8.e(), var8.f(), var8);
			}
		}

		return var6;
	}

	public boolean b(Position var1) {
		this.a(this.c);
		return this.c(var1) != null;
	}

	protected bmv c(Position var1) {
		Iterator var2 = this.e.values().iterator();

		while (var2.hasNext()) {
			bmv var3 = (bmv) var2.next();
			if (var3.d() && var3.a().b((fd) var1)) {
				Iterator var4 = var3.b().iterator();

				while (var4.hasNext()) {
					bms var5 = (bms) var4.next();
					if (var5.c().b((fd) var1)) {
						return var3;
					}
				}
			}
		}

		return null;
	}

	public boolean a(World var1, Position var2) {
		this.a(var1);
		Iterator var3 = this.e.values().iterator();

		bmv var4;
		do {
			if (!var3.hasNext()) {
				return false;
			}

			var4 = (bmv) var3.next();
		} while (!var4.d() || !var4.a().b((fd) var2));

		return true;
	}

	public Position b(World var1, Position var2) {
		this.c = var1;
		this.a(var1);
		this.b.setSeed(var1.J());
		long var3 = this.b.nextLong();
		long var5 = this.b.nextLong();
		long var7 = (long) (var2.getX() >> 4) * var3;
		long var9 = (long) (var2.getZ() >> 4) * var5;
		this.b.setSeed(var7 ^ var9 ^ var1.J());
		this.a(var1, var2.getX() >> 4, var2.getZ() >> 4, 0, 0, (bgk) null);
		double var11 = Double.MAX_VALUE;
		Position var13 = null;
		Iterator var14 = this.e.values().iterator();

		Position var17;
		double var18;
		while (var14.hasNext()) {
			bmv var15 = (bmv) var14.next();
			if (var15.d()) {
				bms var16 = (bms) var15.b().get(0);
				var17 = var16.a();
				var18 = var17.i(var2);
				if (var18 < var11) {
					var11 = var18;
					var13 = var17;
				}
			}
		}

		if (var13 != null) {
			return var13;
		} else {
			List var20 = this.y_();
			if (var20 != null) {
				Position var21 = null;
				Iterator var22 = var20.iterator();

				while (var22.hasNext()) {
					var17 = (Position) var22.next();
					var18 = var17.i(var2);
					if (var18 < var11) {
						var11 = var18;
						var21 = var17;
					}
				}

				return var21;
			} else {
				return null;
			}
		}
	}

	protected List y_() {
		return null;
	}

	private void a(World var1) {
		if (this.d == null) {
			this.d = (bmr) var1.a(bmr.class, this.a());
			if (this.d == null) {
				this.d = new bmr(this.a());
				var1.a(this.a(), (bqc) this.d);
			} else {
				NBTCompoundTag var2 = this.d.a();
				Iterator var3 = var2.getKeys().iterator();

				while (var3.hasNext()) {
					String var4 = (String) var3.next();
					NBTTag var5 = var2.getTag(var4);
					if (var5.getId() == 10) {
						NBTCompoundTag var6 = (NBTCompoundTag) var5;
						if (var6.hasKey("ChunkX") && var6.hasKey("ChunkZ")) {
							int var7 = var6.getInt("ChunkX");
							int var8 = var6.getInt("ChunkZ");
							bmv var9 = bmq.a(var6, var1);
							if (var9 != null) {
								this.e.put(Long.valueOf(ChunkCoordIntPair.toLongHash(var7, var8)), var9);
							}
						}
					}
				}
			}
		}

	}

	private void a(int var1, int var2, bmv var3) {
		this.d.a(var3.a(var1, var2), var1, var2);
		this.d.c();
	}

	protected abstract boolean a(int var1, int var2);

	protected abstract bmv b(int var1, int var2);
}
