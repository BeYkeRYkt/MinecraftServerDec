package net.minecraft;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class qs implements IChunkProvider {

	private static final Logger b = LogManager.getLogger();
	private Set c = Collections.newSetFromMap(new ConcurrentHashMap());
	private Chunk d;
	private IChunkProvider e;
	private IChunkLoader f;
	public boolean a = true;
	private ur g = new ur();
	private List h = Lists.newArrayList();
	private WorldServer i;

	public qs(WorldServer var1, IChunkLoader var2, IChunkProvider var3) {
		this.d = new bfg(var1, 0, 0);
		this.i = var1;
		this.f = var2;
		this.e = var3;
	}

	public boolean a(int var1, int var2) {
		return this.g.b(ChunkCoordIntPair.toLongHash(var1, var2));
	}

	public List a() {
		return this.h;
	}

	public void b(int var1, int var2) {
		if (this.i.worldProvider.e()) {
			if (!this.i.c(var1, var2)) {
				this.c.add(Long.valueOf(ChunkCoordIntPair.toLongHash(var1, var2)));
			}
		} else {
			this.c.add(Long.valueOf(ChunkCoordIntPair.toLongHash(var1, var2)));
		}

	}

	public void b() {
		Iterator var1 = this.h.iterator();

		while (var1.hasNext()) {
			Chunk var2 = (Chunk) var1.next();
			this.b(var2.x, var2.y);
		}

	}

	public Chunk c(int var1, int var2) {
		long var3 = ChunkCoordIntPair.toLongHash(var1, var2);
		this.c.remove(Long.valueOf(var3));
		Chunk var5 = (Chunk) this.g.a(var3);
		if (var5 == null) {
			var5 = this.e(var1, var2);
			if (var5 == null) {
				if (this.e == null) {
					var5 = this.d;
				} else {
					try {
						var5 = this.e.d(var1, var2);
					} catch (Throwable var9) {
						CrashReport var7 = CrashReport.generateCrashReport(var9, "Exception generating new chunk");
						CrashReportSystemDetails var8 = var7.generateSystemDetails("Chunk to be generated");
						var8.addDetails("Location", (Object) String.format("%d,%d", new Object[] { Integer.valueOf(var1), Integer.valueOf(var2) }));
						var8.addDetails("Position hash", (Object) Long.valueOf(var3));
						var8.addDetails("Generator", (Object) this.e.f());
						throw new ReportedException(var7);
					}
				}
			}

			this.g.a(var3, var5);
			this.h.add(var5);
			var5.c();
			var5.a(this, this, var1, var2);
		}

		return var5;
	}

	public Chunk d(int var1, int var2) {
		Chunk var3 = (Chunk) this.g.a(ChunkCoordIntPair.toLongHash(var1, var2));
		return var3 == null ? (!this.i.ad() && !this.a ? this.d : this.c(var1, var2)) : var3;
	}

	private Chunk e(int var1, int var2) {
		if (this.f == null) {
			return null;
		} else {
			try {
				Chunk var3 = this.f.loadChunk(this.i, var1, var2);
				if (var3 != null) {
					var3.b(this.i.getLastUpdate());
					if (this.e != null) {
						this.e.a(var3, var1, var2);
					}
				}

				return var3;
			} catch (Exception var4) {
				b.error("Couldn\'t load chunk", (Throwable) var4);
				return null;
			}
		}
	}

	private void a(Chunk var1) {
		if (this.f != null) {
			try {
				this.f.b(this.i, var1);
			} catch (Exception var3) {
				b.error("Couldn\'t save entities", (Throwable) var3);
			}

		}
	}

	private void b(Chunk var1) {
		if (this.f != null) {
			try {
				var1.b(this.i.getLastUpdate());
				this.f.requestChunkSave(this.i, var1);
			} catch (aqz var4) {
				b.error("Couldn\'t save chunk; already in use by another instance of Minecraft?", (Throwable) var4);
			}

		}
	}

	public void a(IChunkProvider var1, int var2, int var3) {
		Chunk var4 = this.d(var2, var3);
		if (!var4.isTerrainPopulated()) {
			var4.n();
			if (this.e != null) {
				this.e.a(var1, var2, var3);
				var4.e();
			}
		}

	}

	public boolean a(IChunkProvider var1, Chunk var2, int var3, int var4) {
		if (this.e != null && this.e.a(var1, var2, var3, var4)) {
			Chunk var5 = this.d(var3, var4);
			var5.e();
			return true;
		} else {
			return false;
		}
	}

	public boolean a(boolean var1, uy var2) {
		int var3 = 0;

		for (int var4 = 0; var4 < this.h.size(); ++var4) {
			Chunk var5 = (Chunk) this.h.get(var4);
			if (var1) {
				this.a(var5);
			}

			if (var5.a(var1)) {
				this.b(var5);
				var5.f(false);
				++var3;
				if (var3 == 24 && !var1) {
					return false;
				}
			}
		}

		return true;
	}

	public void c() {
		if (this.f != null) {
			this.f.saveAllChunks();
		}

	}

	public boolean d() {
		if (!this.i.c) {
			for (int var1 = 0; var1 < 100; ++var1) {
				if (!this.c.isEmpty()) {
					Long var2 = (Long) this.c.iterator().next();
					Chunk var3 = (Chunk) this.g.a(var2.longValue());
					if (var3 != null) {
						var3.d();
						this.b(var3);
						this.a(var3);
						this.g.d(var2.longValue());
						this.h.remove(var3);
					}

					this.c.remove(var2);
				}
			}

			if (this.f != null) {
				this.f.a();
			}
		}

		return this.e.d();
	}

	public boolean e() {
		return !this.i.c;
	}

	public String f() {
		return "ServerChunkCache: " + this.g.a() + " Drop: " + this.c.size();
	}

	public List a(xp var1, Position var2) {
		return this.e.a(var1, var2);
	}

	public Position a(World var1, String var2, Position var3) {
		return this.e.a(var1, var2, var3);
	}

	public int g() {
		return this.g.a();
	}

	public void a(Chunk var1, int var2, int var3) {
	}

	public Chunk a(Position var1) {
		return this.d(var1.getX() >> 4, var1.getZ() >> 4);
	}

}
