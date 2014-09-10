package net.minecraft;

import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.server.MinecraftServer;

public class arr {

	private final WorldChunkManager a;
	private long b;
	private LongHashMap c = new LongHashMap();
	private List d = Lists.newArrayList();

	public arr(WorldChunkManager var1) {
		this.a = var1;
	}

	public ars a(int var1, int var2) {
		var1 >>= 4;
		var2 >>= 4;
		long var3 = (long) var1 & 4294967295L | ((long) var2 & 4294967295L) << 32;
		ars var5 = (ars) this.c.getEntry(var3);
		if (var5 == null) {
			var5 = new ars(this, var1, var2);
			this.c.put(var3, var5);
			this.d.add(var5);
		}

		var5.e = MinecraftServer.getCurrentMillis();
		return var5;
	}

	public BiomeBase a(int var1, int var2, BiomeBase var3) {
		BiomeBase var4 = this.a(var1, var2).a(var1, var2);
		return var4 == null ? var3 : var4;
	}

	public void a() {
		long var1 = MinecraftServer.getCurrentMillis();
		long var3 = var1 - this.b;
		if (var3 > 7500L || var3 < 0L) {
			this.b = var1;

			for (int var5 = 0; var5 < this.d.size(); ++var5) {
				ars var6 = (ars) this.d.get(var5);
				long var7 = var1 - var6.e;
				if (var7 > 30000L || var7 < 0L) {
					this.d.remove(var5--);
					long var9 = (long) var6.c & 4294967295L | ((long) var6.d & 4294967295L) << 32;
					this.c.remove(var9);
				}
			}
		}

	}

	public BiomeBase[] c(int var1, int var2) {
		return this.a(var1, var2).b;
	}

	// $FF: synthetic method
	static WorldChunkManager a(arr var0) {
		return var0.a;
	}
}
