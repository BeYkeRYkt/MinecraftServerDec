package net.minecraft;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import com.google.common.collect.Queues;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Chunk {

	private static final Logger c = LogManager.getLogger();
	private final ChunkSection[] chunkSections;
	private final byte[] biomes;
	private final int[] f;
	private final boolean[] g;
	private boolean h;
	private final World i;
	private final int[] j;
	public final int x;
	public final int y;
	private boolean k;
	private final Map l;
	private final uc[] m;
	private boolean n;
	private boolean o;
	private boolean p;
	private boolean q;
	private boolean r;
	private long s;
	private int t;
	private long u;
	private int v;
	private ConcurrentLinkedQueue w;

	public Chunk(World var1, int var2, int var3) {
		this.chunkSections = new ChunkSection[16];
		this.biomes = new byte[256];
		this.f = new int[256];
		this.g = new boolean[256];
		this.l = Maps.newHashMap();
		this.v = 4096;
		this.w = Queues.newConcurrentLinkedQueue();
		this.m = (uc[]) (new uc[16]);
		this.i = var1;
		this.x = var2;
		this.y = var3;
		this.j = new int[256];

		for (int var4 = 0; var4 < this.m.length; ++var4) {
			this.m[var4] = new uc(Entity.class);
		}

		Arrays.fill(this.f, -999);
		Arrays.fill(this.biomes, (byte) -1);
	}

	public Chunk(World var1, bgk var2, int var3, int var4) {
		this(var1, var3, var4);
		short var5 = 256;
		boolean var6 = !var1.worldProvider.noSkyLight();

		for (int var7 = 0; var7 < 16; ++var7) {
			for (int var8 = 0; var8 < 16; ++var8) {
				for (int var9 = 0; var9 < var5; ++var9) {
					int var10 = var7 * var5 * 16 | var8 * var5 | var9;
					bec var11 = var2.a(var10);
					if (var11.getBlock().r() != Material.AIR) {
						int var12 = var9 >> 4;
						if (this.chunkSections[var12] == null) {
							this.chunkSections[var12] = new ChunkSection(var12 << 4, var6);
						}

						this.chunkSections[var12].a(var7, var9 & 15, var8, var11);
					}
				}
			}
		}

	}

	public boolean a(int var1, int var2) {
		return var1 == this.x && var2 == this.y;
	}

	public int f(Position var1) {
		return this.b(var1.getX() & 15, var1.getZ() & 15);
	}

	public int b(int var1, int var2) {
		return this.j[var2 << 4 | var1];
	}

	public int g() {
		for (int var1 = this.chunkSections.length - 1; var1 >= 0; --var1) {
			if (this.chunkSections[var1] != null) {
				return this.chunkSections[var1].d();
			}
		}

		return 0;
	}

	public ChunkSection[] getChunkSections() {
		return this.chunkSections;
	}

	public void b() {
		int var1 = this.g();
		this.t = Integer.MAX_VALUE;

		for (int var2 = 0; var2 < 16; ++var2) {
			int var3 = 0;

			while (var3 < 16) {
				this.f[var2 + (var3 << 4)] = -999;
				int var4 = var1 + 16;

				while (true) {
					if (var4 > 0) {
						if (this.e(var2, var4 - 1, var3) == 0) {
							--var4;
							continue;
						}

						this.j[var3 << 4 | var2] = var4;
						if (var4 < this.t) {
							this.t = var4;
						}
					}

					if (!this.i.worldProvider.noSkyLight()) {
						var4 = 15;
						int var5 = var1 + 16 - 1;

						do {
							int var6 = this.e(var2, var5, var3);
							if (var6 == 0 && var4 != 15) {
								var6 = 1;
							}

							var4 -= var6;
							if (var4 > 0) {
								ChunkSection var7 = this.chunkSections[var5 >> 4];
								if (var7 != null) {
									var7.a(var2, var5 & 15, var3, var4);
									this.i.n(new Position((this.x << 4) + var2, var5, (this.y << 4) + var3));
								}
							}

							--var5;
						} while (var5 > 0 && var4 > 0);
					}

					++var3;
					break;
				}
			}
		}

		this.q = true;
	}

	private void d(int var1, int var2) {
		this.g[var1 + var2 * 16] = true;
		this.k = true;
	}

	private void h(boolean var1) {
		this.i.B.a("recheckGaps");
		if (this.i.a(new Position(this.x * 16 + 8, 0, this.y * 16 + 8), (int) 16)) {
			for (int var2 = 0; var2 < 16; ++var2) {
				for (int var3 = 0; var3 < 16; ++var3) {
					if (this.g[var2 + var3 * 16]) {
						this.g[var2 + var3 * 16] = false;
						int var4 = this.b(var2, var3);
						int var5 = this.x * 16 + var2;
						int var6 = this.y * 16 + var3;
						int var7 = Integer.MAX_VALUE;

						Iterator var8;
						BlockFace var9;
						for (var8 = en.a.iterator(); var8.hasNext(); var7 = Math.min(var7, this.i.b(var5 + var9.g(), var6 + var9.i()))) {
							var9 = (BlockFace) var8.next();
						}

						this.c(var5, var6, var7);
						var8 = en.a.iterator();

						while (var8.hasNext()) {
							var9 = (BlockFace) var8.next();
							this.c(var5 + var9.g(), var6 + var9.i(), var4);
						}

						if (var1) {
							this.i.B.b();
							return;
						}
					}
				}
			}

			this.k = false;
		}

		this.i.B.b();
	}

	private void c(int var1, int var2, int var3) {
		int var4 = this.i.m(new Position(var1, 0, var2)).getY();
		if (var4 > var3) {
			this.a(var1, var2, var3, var4 + 1);
		} else if (var4 < var3) {
			this.a(var1, var2, var4, var3 + 1);
		}

	}

	private void a(int var1, int var2, int var3, int var4) {
		if (var4 > var3 && this.i.a(new Position(var1, 0, var2), (int) 16)) {
			for (int var5 = var3; var5 < var4; ++var5) {
				this.i.c(arf.a, new Position(var1, var5, var2));
			}

			this.q = true;
		}

	}

	private void d(int var1, int var2, int var3) {
		int var4 = this.j[var3 << 4 | var1] & 255;
		int var5 = var4;
		if (var2 > var4) {
			var5 = var2;
		}

		while (var5 > 0 && this.e(var1, var5 - 1, var3) == 0) {
			--var5;
		}

		if (var5 != var4) {
			this.i.a(var1 + this.x * 16, var3 + this.y * 16, var5, var4);
			this.j[var3 << 4 | var1] = var5;
			int var6 = this.x * 16 + var1;
			int var7 = this.y * 16 + var3;
			int var8;
			int var13;
			if (!this.i.worldProvider.noSkyLight()) {
				ChunkSection var9;
				if (var5 < var4) {
					for (var8 = var5; var8 < var4; ++var8) {
						var9 = this.chunkSections[var8 >> 4];
						if (var9 != null) {
							var9.a(var1, var8 & 15, var3, 15);
							this.i.n(new Position((this.x << 4) + var1, var8, (this.y << 4) + var3));
						}
					}
				} else {
					for (var8 = var4; var8 < var5; ++var8) {
						var9 = this.chunkSections[var8 >> 4];
						if (var9 != null) {
							var9.a(var1, var8 & 15, var3, 0);
							this.i.n(new Position((this.x << 4) + var1, var8, (this.y << 4) + var3));
						}
					}
				}

				var8 = 15;

				while (var5 > 0 && var8 > 0) {
					--var5;
					var13 = this.e(var1, var5, var3);
					if (var13 == 0) {
						var13 = 1;
					}

					var8 -= var13;
					if (var8 < 0) {
						var8 = 0;
					}

					ChunkSection var10 = this.chunkSections[var5 >> 4];
					if (var10 != null) {
						var10.a(var1, var5 & 15, var3, var8);
					}
				}
			}

			var8 = this.j[var3 << 4 | var1];
			var13 = var4;
			int var14 = var8;
			if (var8 < var4) {
				var13 = var8;
				var14 = var4;
			}

			if (var8 < this.t) {
				this.t = var8;
			}

			if (!this.i.worldProvider.noSkyLight()) {
				Iterator var11 = en.a.iterator();

				while (var11.hasNext()) {
					BlockFace var12 = (BlockFace) var11.next();
					this.a(var6 + var12.g(), var7 + var12.i(), var13, var14);
				}

				this.a(var6, var7, var13, var14);
			}

			this.q = true;
		}
	}

	public int b(Position var1) {
		return this.a(var1).n();
	}

	private int e(int var1, int var2, int var3) {
		return this.f(var1, var2, var3).n();
	}

	private Block f(int var1, int var2, int var3) {
		Block var4 = Blocks.AIR;
		if (var2 >= 0 && var2 >> 4 < this.chunkSections.length) {
			ChunkSection var5 = this.chunkSections[var2 >> 4];
			if (var5 != null) {
				try {
					var4 = var5.b(var1, var2 & 15, var3);
				} catch (Throwable var8) {
					CrashReport var7 = CrashReport.generateCrashReport(var8, "Getting block");
					throw new ReportedException(var7);
				}
			}
		}

		return var4;
	}

	public Block a(int var1, int var2, int var3) {
		try {
			return this.f(var1 & 15, var2, var3 & 15);
		} catch (ReportedException var6) {
			CrashReportSystemDetails var5 = var6.getCrashReport().generateSystemDetails("Block being got");
			var5.addDetails("Location", (Callable) (new bfi(this, var1, var2, var3)));
			throw var6;
		}
	}

	public Block a(Position var1) {
		try {
			return this.f(var1.getX() & 15, var1.getY(), var1.getZ() & 15);
		} catch (ReportedException var4) {
			CrashReportSystemDetails var3 = var4.getCrashReport().generateSystemDetails("Block being got");
			var3.addDetails("Location", (Callable) (new bfj(this, var1)));
			throw var4;
		}
	}

	public bec g(Position var1) {
		if (this.i.G() == LevelType.DEBUG) {
			bec var7 = null;
			if (var1.getY() == 60) {
				var7 = Blocks.BARRIER.P();
			}

			if (var1.getY() == 70) {
				var7 = bgp.b(var1.getX(), var1.getZ());
			}

			return var7 == null ? Blocks.AIR.P() : var7;
		} else {
			try {
				if (var1.getY() >= 0 && var1.getY() >> 4 < this.chunkSections.length) {
					ChunkSection var2 = this.chunkSections[var1.getY() >> 4];
					if (var2 != null) {
						int var8 = var1.getX() & 15;
						int var9 = var1.getY() & 15;
						int var5 = var1.getZ() & 15;
						return var2.a(var8, var9, var5);
					}
				}

				return Blocks.AIR.P();
			} catch (Throwable var6) {
				CrashReport var3 = CrashReport.generateCrashReport(var6, "Getting block state");
				CrashReportSystemDetails var4 = var3.generateSystemDetails("Block being got");
				var4.addDetails("Location", (Callable) (new bfk(this, var1)));
				throw new ReportedException(var3);
			}
		}
	}

	private int g(int var1, int var2, int var3) {
		if (var2 >> 4 >= this.chunkSections.length) {
			return 0;
		} else {
			ChunkSection var4 = this.chunkSections[var2 >> 4];
			return var4 != null ? var4.c(var1, var2 & 15, var3) : 0;
		}
	}

	public int c(Position var1) {
		return this.g(var1.getX() & 15, var1.getY(), var1.getZ() & 15);
	}

	public bec a(Position var1, bec var2) {
		int var3 = var1.getX() & 15;
		int var4 = var1.getY();
		int var5 = var1.getZ() & 15;
		int var6 = var5 << 4 | var3;
		if (var4 >= this.f[var6] - 1) {
			this.f[var6] = -999;
		}

		int var7 = this.j[var6];
		bec var8 = this.g(var1);
		if (var8 == var2) {
			return null;
		} else {
			Block var9 = var2.getBlock();
			Block var10 = var8.getBlock();
			ChunkSection var11 = this.chunkSections[var4 >> 4];
			boolean var12 = false;
			if (var11 == null) {
				if (var9 == Blocks.AIR) {
					return null;
				}

				var11 = this.chunkSections[var4 >> 4] = new ChunkSection(var4 >> 4 << 4, !this.i.worldProvider.noSkyLight());
				var12 = var4 >= var7;
			}

			var11.a(var3, var4 & 15, var5, var2);
			if (var10 != var9) {
				if (!this.i.D) {
					var10.b(this.i, var1, var8);
				} else if (var10 instanceof avs) {
					this.i.t(var1);
				}
			}

			if (var11.b(var3, var4 & 15, var5) != var9) {
				return null;
			} else {
				if (var12) {
					this.b();
				} else {
					int var13 = var9.n();
					int var14 = var10.n();
					if (var13 > 0) {
						if (var4 >= var7) {
							this.d(var3, var4 + 1, var5);
						}
					} else if (var4 == var7 - 1) {
						this.d(var3, var4, var5);
					}

					if (var13 != var14 && (var13 < var14 || this.a(arf.a, var1) > 0 || this.a(arf.b, var1) > 0)) {
						this.d(var3, var5);
					}
				}

				TileEntity var15;
				if (var10 instanceof avs) {
					var15 = this.a(var1, bfl.c);
					if (var15 != null) {
						var15.E();
					}
				}

				if (!this.i.D && var10 != var9) {
					var9.c(this.i, var1, var2);
				}

				if (var9 instanceof avs) {
					var15 = this.a(var1, bfl.c);
					if (var15 == null) {
						var15 = ((avs) var9).a(this.i, var9.c(var2));
						this.i.a(var1, var15);
					}

					if (var15 != null) {
						var15.E();
					}
				}

				this.q = true;
				return var8;
			}
		}
	}

	public int a(arf var1, Position var2) {
		int var3 = var2.getX() & 15;
		int var4 = var2.getY();
		int var5 = var2.getZ() & 15;
		ChunkSection var6 = this.chunkSections[var4 >> 4];
		return var6 == null ? (this.d(var2) ? var1.c : 0) : (var1 == arf.a ? (this.i.worldProvider.noSkyLight() ? 0 : var6.d(var3, var4 & 15, var5)) : (var1 == arf.b ? var6.e(var3, var4 & 15, var5) : var1.c));
	}

	public void a(arf var1, Position var2, int var3) {
		int var4 = var2.getX() & 15;
		int var5 = var2.getY();
		int var6 = var2.getZ() & 15;
		ChunkSection var7 = this.chunkSections[var5 >> 4];
		if (var7 == null) {
			var7 = this.chunkSections[var5 >> 4] = new ChunkSection(var5 >> 4 << 4, !this.i.worldProvider.noSkyLight());
			this.b();
		}

		this.q = true;
		if (var1 == arf.a) {
			if (!this.i.worldProvider.noSkyLight()) {
				var7.a(var4, var5 & 15, var6, var3);
			}
		} else if (var1 == arf.b) {
			var7.b(var4, var5 & 15, var6, var3);
		}

	}

	public int a(Position var1, int var2) {
		int var3 = var1.getX() & 15;
		int var4 = var1.getY();
		int var5 = var1.getZ() & 15;
		ChunkSection var6 = this.chunkSections[var4 >> 4];
		if (var6 == null) {
			return !this.i.worldProvider.noSkyLight() && var2 < arf.a.c ? arf.a.c - var2 : 0;
		} else {
			int var7 = this.i.worldProvider.noSkyLight() ? 0 : var6.d(var3, var4 & 15, var5);
			var7 -= var2;
			int var8 = var6.e(var3, var4 & 15, var5);
			if (var8 > var7) {
				var7 = var8;
			}

			return var7;
		}
	}

	public void a(Entity var1) {
		this.r = true;
		int var2 = DataTypesConverter.toFixedPointInt(var1.locationX / 16.0D);
		int var3 = DataTypesConverter.toFixedPointInt(var1.locationZ / 16.0D);
		if (var2 != this.x || var3 != this.y) {
			c.warn("Wrong location! (" + var2 + ", " + var3 + ") should be (" + this.x + ", " + this.y + "), " + var1, new Object[] { var1 });
			var1.J();
		}

		int var4 = DataTypesConverter.toFixedPointInt(var1.locationY / 16.0D);
		if (var4 < 0) {
			var4 = 0;
		}

		if (var4 >= this.m.length) {
			var4 = this.m.length - 1;
		}

		var1.ad = true;
		var1.ae = this.x;
		var1.af = var4;
		var1.ag = this.y;
		this.m[var4].add(var1);
	}

	public void b(Entity var1) {
		this.a(var1, var1.af);
	}

	public void a(Entity var1, int var2) {
		if (var2 < 0) {
			var2 = 0;
		}

		if (var2 >= this.m.length) {
			var2 = this.m.length - 1;
		}

		this.m[var2].remove(var1);
	}

	public boolean d(Position var1) {
		int var2 = var1.getX() & 15;
		int var3 = var1.getY();
		int var4 = var1.getZ() & 15;
		return var3 >= this.j[var4 << 4 | var2];
	}

	private TileEntity i(Position var1) {
		Block var2 = this.a(var1);
		return !var2.x() ? null : ((avs) var2).a(this.i, this.c(var1));
	}

	public TileEntity a(Position var1, bfl var2) {
		TileEntity var3 = (TileEntity) this.l.get(var1);
		if (var3 == null) {
			if (var2 == bfl.a) {
				var3 = this.i(var1);
				this.i.a(var1, var3);
			} else if (var2 == bfl.b) {
				this.w.add(var1);
			}
		} else if (var3.x()) {
			this.l.remove(var1);
			return null;
		}

		return var3;
	}

	public void a(TileEntity var1) {
		this.a(var1.v(), var1);
		if (this.h) {
			this.i.a(var1);
		}

	}

	public void a(Position var1, TileEntity var2) {
		var2.a(this.i);
		var2.a(var1);
		if (this.a(var1) instanceof avs) {
			if (this.l.containsKey(var1)) {
				((TileEntity) this.l.get(var1)).y();
			}

			var2.D();
			this.l.put(var1, var2);
		}
	}

	public void e(Position var1) {
		if (this.h) {
			TileEntity var2 = (TileEntity) this.l.remove(var1);
			if (var2 != null) {
				var2.y();
			}
		}

	}

	public void c() {
		this.h = true;
		this.i.a(this.l.values());

		for (int var1 = 0; var1 < this.m.length; ++var1) {
			Iterator var2 = this.m[var1].iterator();

			while (var2.hasNext()) {
				Entity var3 = (Entity) var2.next();
				var3.ah();
			}

			this.i.b((Collection) this.m[var1]);
		}

	}

	public void d() {
		this.h = false;
		Iterator var1 = this.l.values().iterator();

		while (var1.hasNext()) {
			TileEntity var2 = (TileEntity) var1.next();
			this.i.b(var2);
		}

		for (int var3 = 0; var3 < this.m.length; ++var3) {
			this.i.c((Collection) this.m[var3]);
		}

	}

	public void e() {
		this.q = true;
	}

	public void a(Entity var1, brt var2, List var3, Predicate var4) {
		int var5 = DataTypesConverter.toFixedPointInt((var2.b - 2.0D) / 16.0D);
		int var6 = DataTypesConverter.toFixedPointInt((var2.e + 2.0D) / 16.0D);
		var5 = DataTypesConverter.a(var5, 0, this.m.length - 1);
		var6 = DataTypesConverter.a(var6, 0, this.m.length - 1);

		for (int var7 = var5; var7 <= var6; ++var7) {
			Iterator var8 = this.m[var7].iterator();

			while (var8.hasNext()) {
				Entity var9 = (Entity) var8.next();
				if (var9 != var1 && var9.aQ().b(var2) && (var4 == null || var4.apply(var9))) {
					var3.add(var9);
					Entity[] var10 = var9.aC();
					if (var10 != null) {
						for (int var11 = 0; var11 < var10.length; ++var11) {
							var9 = var10[var11];
							if (var9 != var1 && var9.aQ().b(var2) && (var4 == null || var4.apply(var9))) {
								var3.add(var9);
							}
						}
					}
				}
			}
		}

	}

	public void a(Class var1, brt var2, List var3, Predicate var4) {
		int var5 = DataTypesConverter.toFixedPointInt((var2.b - 2.0D) / 16.0D);
		int var6 = DataTypesConverter.toFixedPointInt((var2.e + 2.0D) / 16.0D);
		var5 = DataTypesConverter.a(var5, 0, this.m.length - 1);
		var6 = DataTypesConverter.a(var6, 0, this.m.length - 1);

		for (int var7 = var5; var7 <= var6; ++var7) {
			Iterator var8 = this.m[var7].b(var1).iterator();

			while (var8.hasNext()) {
				Entity var9 = (Entity) var8.next();
				if (var9.aQ().b(var2) && (var4 == null || var4.apply(var9))) {
					var3.add(var9);
				}
			}
		}

	}

	public boolean a(boolean var1) {
		if (var1) {
			if (this.r && this.i.K() != this.s || this.q) {
				return true;
			}
		} else if (this.r && this.i.K() >= this.s + 600L) {
			return true;
		}

		return this.q;
	}

	public Random a(long var1) {
		return new Random(this.i.J() + (long) (this.x * this.x * 4987142) + (long) (this.x * 5947611) + (long) (this.y * this.y) * 4392871L + (long) (this.y * 389711) ^ var1);
	}

	public boolean f() {
		return false;
	}

	public void a(IChunkProvider var1, IChunkProvider var2, int var3, int var4) {
		boolean var5 = var1.a(var3, var4 - 1);
		boolean var6 = var1.a(var3 + 1, var4);
		boolean var7 = var1.a(var3, var4 + 1);
		boolean var8 = var1.a(var3 - 1, var4);
		boolean var9 = var1.a(var3 - 1, var4 - 1);
		boolean var10 = var1.a(var3 + 1, var4 + 1);
		boolean var11 = var1.a(var3 - 1, var4 + 1);
		boolean var12 = var1.a(var3 + 1, var4 - 1);
		if (var6 && var7 && var10) {
			if (!this.n) {
				var1.a(var2, var3, var4);
			} else {
				var1.a(var2, this, var3, var4);
			}
		}

		Chunk var13;
		if (var8 && var7 && var11) {
			var13 = var1.d(var3 - 1, var4);
			if (!var13.n) {
				var1.a(var2, var3 - 1, var4);
			} else {
				var1.a(var2, var13, var3 - 1, var4);
			}
		}

		if (var5 && var6 && var12) {
			var13 = var1.d(var3, var4 - 1);
			if (!var13.n) {
				var1.a(var2, var3, var4 - 1);
			} else {
				var1.a(var2, var13, var3, var4 - 1);
			}
		}

		if (var9 && var5 && var8) {
			var13 = var1.d(var3 - 1, var4 - 1);
			if (!var13.n) {
				var1.a(var2, var3 - 1, var4 - 1);
			} else {
				var1.a(var2, var13, var3 - 1, var4 - 1);
			}
		}

	}

	public Position h(Position var1) {
		int var2 = var1.getX() & 15;
		int var3 = var1.getZ() & 15;
		int var4 = var2 | var3 << 4;
		Position var5 = new Position(var1.getX(), this.f[var4], var1.getZ());
		if (var5.getY() == -999) {
			int var6 = this.g() + 15;
			var5 = new Position(var1.getX(), var6, var1.getZ());
			int var7 = -1;

			while (var5.getY() > 0 && var7 == -1) {
				Block var8 = this.a(var5);
				Material var9 = var8.r();
				if (!var9.isSolid() && !var9.isLiquid()) {
					var5 = var5.b();
				} else {
					var7 = var5.getY() + 1;
				}
			}

			this.f[var4] = var7;
		}

		return new Position(var1.getX(), this.f[var4], var1.getZ());
	}

	public void b(boolean var1) {
		if (this.k && !this.i.worldProvider.noSkyLight() && !var1) {
			this.h(this.i.D);
		}

		this.p = true;
		if (!this.o && this.n) {
			this.n();
		}

		while (!this.w.isEmpty()) {
			Position var2 = (Position) this.w.poll();
			if (this.a(var2, bfl.c) == null && this.a(var2).x()) {
				TileEntity var3 = this.i(var2);
				this.i.a(var2, var3);
				this.i.b(var2, var2);
			}
		}

	}

	public boolean i() {
		return this.p && this.n && this.o;
	}

	public ChunkCoordIntPair j() {
		return new ChunkCoordIntPair(this.x, this.y);
	}

	public boolean c(int var1, int var2) {
		if (var1 < 0) {
			var1 = 0;
		}

		if (var2 >= 256) {
			var2 = 255;
		}

		for (int var3 = var1; var3 <= var2; var3 += 16) {
			ChunkSection var4 = this.chunkSections[var3 >> 4];
			if (var4 != null && !var4.isEmpty()) {
				return false;
			}
		}

		return true;
	}

	public void a(ChunkSection[] var1) {
		if (this.chunkSections.length != var1.length) {
			c.warn("Could not set level chunk sections, array length is " + var1.length + " instead of " + this.chunkSections.length);
		} else {
			for (int var2 = 0; var2 < this.chunkSections.length; ++var2) {
				this.chunkSections[var2] = var1[var2];
			}

		}
	}

	public arm a(Position var1, arz var2) {
		int var3 = var1.getX() & 15;
		int var4 = var1.getZ() & 15;
		int var5 = this.biomes[var4 << 4 | var3] & 255;
		arm var6;
		if (var5 == 255) {
			var6 = var2.a(var1, arm.q);
			var5 = var6.az;
			this.biomes[var4 << 4 | var3] = (byte) (var5 & 255);
		}

		var6 = arm.e(var5);
		return var6 == null ? arm.q : var6;
	}

	public byte[] getBiomes() {
		return this.biomes;
	}

	public void a(byte[] var1) {
		if (this.biomes.length != var1.length) {
			c.warn("Could not set level chunk biomes, array length is " + var1.length + " instead of " + this.biomes.length);
		} else {
			for (int var2 = 0; var2 < this.biomes.length; ++var2) {
				this.biomes[var2] = var1[var2];
			}

		}
	}

	public void l() {
		this.v = 0;
	}

	public void m() {
		Position var1 = new Position(this.x << 4, 0, this.y << 4);

		for (int var2 = 0; var2 < 8; ++var2) {
			if (this.v >= 4096) {
				return;
			}

			int var3 = this.v % 16;
			int var4 = this.v / 16 % 16;
			int var5 = this.v / 256;
			++this.v;

			for (int var6 = 0; var6 < 16; ++var6) {
				Position var7 = var1.a(var4, (var3 << 4) + var6, var5);
				boolean var8 = var6 == 0 || var6 == 15 || var4 == 0 || var4 == 15 || var5 == 0 || var5 == 15;
				if (this.chunkSections[var3] == null && var8 || this.chunkSections[var3] != null && this.chunkSections[var3].b(var4, var6, var5).r() == Material.AIR) {
					BlockFace[] var9 = BlockFace.values();
					int var10 = var9.length;

					for (int var11 = 0; var11 < var10; ++var11) {
						BlockFace var12 = var9[var11];
						Position var13 = var7.a(var12);
						if (this.i.p(var13).getBlock().p() > 0) {
							this.i.x(var13);
						}
					}

					this.i.x(var7);
				}
			}
		}

	}

	public void n() {
		this.n = true;
		this.o = true;
		Position var1 = new Position(this.x << 4, 0, this.y << 4);
		if (!this.i.worldProvider.noSkyLight()) {
			if (this.i.a(var1.a(-1, 0, -1), var1.a(16, 63, 16))) {
				label42: for (int var2 = 0; var2 < 16; ++var2) {
					for (int var3 = 0; var3 < 16; ++var3) {
						if (!this.e(var2, var3)) {
							this.o = false;
							break label42;
						}
					}
				}

				if (this.o) {
					Iterator var5 = en.a.iterator();

					while (var5.hasNext()) {
						BlockFace var6 = (BlockFace) var5.next();
						int var4 = var6.c() == em.a ? 16 : 1;
						this.i.f(var1.a(var6, var4)).a(var6.d());
					}

					this.y();
				}
			} else {
				this.o = false;
			}
		}

	}

	private void y() {
		for (int var1 = 0; var1 < this.g.length; ++var1) {
			this.g[var1] = true;
		}

		this.h(false);
	}

	private void a(BlockFace var1) {
		if (this.n) {
			int var2;
			if (var1 == BlockFace.f) {
				for (var2 = 0; var2 < 16; ++var2) {
					this.e(15, var2);
				}
			} else if (var1 == BlockFace.e) {
				for (var2 = 0; var2 < 16; ++var2) {
					this.e(0, var2);
				}
			} else if (var1 == BlockFace.d) {
				for (var2 = 0; var2 < 16; ++var2) {
					this.e(var2, 15);
				}
			} else if (var1 == BlockFace.c) {
				for (var2 = 0; var2 < 16; ++var2) {
					this.e(var2, 0);
				}
			}

		}
	}

	private boolean e(int var1, int var2) {
		Position var3 = new Position(this.x << 4, 0, this.y << 4);
		int var4 = this.g();
		boolean var5 = false;
		boolean var6 = false;

		int var7;
		Position var8;
		for (var7 = var4 + 16 - 1; var7 > 63 || var7 > 0 && !var6; --var7) {
			var8 = var3.a(var1, var7, var2);
			int var9 = this.b(var8);
			if (var9 == 255 && var7 < 63) {
				var6 = true;
			}

			if (!var5 && var9 > 0) {
				var5 = true;
			} else if (var5 && var9 == 0 && !this.i.x(var8)) {
				return false;
			}
		}

		for (; var7 > 0; --var7) {
			var8 = var3.a(var1, var7, var2);
			if (this.a(var8).p() > 0) {
				this.i.x(var8);
			}
		}

		return true;
	}

	public boolean o() {
		return this.h;
	}

	public World getWorld() {
		return this.i;
	}

	public int[] q() {
		return this.j;
	}

	public void a(int[] var1) {
		if (this.j.length != var1.length) {
			c.warn("Could not set level chunk heightmap, array length is " + var1.length + " instead of " + this.j.length);
		} else {
			for (int var2 = 0; var2 < this.j.length; ++var2) {
				this.j[var2] = var1[var2];
			}

		}
	}

	public Map r() {
		return this.l;
	}

	public uc[] s() {
		return this.m;
	}

	public boolean t() {
		return this.n;
	}

	public void d(boolean var1) {
		this.n = var1;
	}

	public boolean u() {
		return this.o;
	}

	public void e(boolean var1) {
		this.o = var1;
	}

	public void f(boolean var1) {
		this.q = var1;
	}

	public void g(boolean var1) {
		this.r = var1;
	}

	public void b(long var1) {
		this.s = var1;
	}

	public int v() {
		return this.t;
	}

	public long w() {
		return this.u;
	}

	public void c(long var1) {
		this.u = var1;
	}

}
