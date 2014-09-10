package net.minecraft;

import com.google.common.collect.Lists;
import java.util.List;

class qr {

	private final List b;
	private final ChunkCoordIntPair c;
	private short[] d;
	private int e;
	private int f;
	private long g;
	// $FF: synthetic field
	final qq a;

	public qr(qq var1, int var2, int var3) {
		this.a = var1;
		this.b = Lists.newArrayList();
		this.d = new short[64];
		this.c = new ChunkCoordIntPair(var2, var3);
		var1.a().b.c(var2, var3);
	}

	public void a(EntityPlayer var1) {
		if (this.b.contains(var1)) {
			qq.c().debug("Failed to add player. {} already is in chunk {}, {}", new Object[] { var1, Integer.valueOf(this.c.chunkX), Integer.valueOf(this.c.chunkZ) });
		} else {
			if (this.b.isEmpty()) {
				this.g = qq.a(this.a).getLastUpdate();
			}

			this.b.add(var1);
			var1.f.add(this.c);
		}
	}

	public void b(EntityPlayer var1) {
		if (this.b.contains(var1)) {
			Chunk var2 = qq.a(this.a).a(this.c.chunkX, this.c.chunkZ);
			if (var2.i()) {
				var1.playerConncetion.sendPacket((Packet) (new PacketPlayOutChunkData(var2, true, 0)));
			}

			this.b.remove(var1);
			var1.f.remove(this.c);
			if (this.b.isEmpty()) {
				long var3 = (long) this.c.chunkX + 2147483647L | (long) this.c.chunkZ + 2147483647L << 32;
				this.a(var2);
				qq.b(this.a).d(var3);
				qq.c(this.a).remove(this);
				if (this.e > 0) {
					qq.d(this.a).remove(this);
				}

				this.a.a().b.b(this.c.chunkX, this.c.chunkZ);
			}

		}
	}

	public void a() {
		this.a(qq.a(this.a).a(this.c.chunkX, this.c.chunkZ));
	}

	private void a(Chunk var1) {
		var1.c(var1.getInhabitedTime() + qq.a(this.a).getLastUpdate() - this.g);
		this.g = qq.a(this.a).getLastUpdate();
	}

	public void a(int var1, int var2, int var3) {
		if (this.e == 0) {
			qq.d(this.a).add(this);
		}

		this.f |= 1 << (var2 >> 4);
		if (this.e < 64) {
			short var4 = (short) (var1 << 12 | var3 << 8 | var2);

			for (int var5 = 0; var5 < this.e; ++var5) {
				if (this.d[var5] == var4) {
					return;
				}
			}

			this.d[this.e++] = var4;
		}

	}

	public void a(Packet var1) {
		for (int var2 = 0; var2 < this.b.size(); ++var2) {
			EntityPlayer var3 = (EntityPlayer) this.b.get(var2);
			if (!var3.f.contains(this.c)) {
				var3.playerConncetion.sendPacket(var1);
			}
		}

	}

	public void b() {
		if (this.e != 0) {
			int var1;
			int var2;
			int var3;
			if (this.e == 1) {
				var1 = (this.d[0] >> 12 & 15) + this.c.chunkX * 16;
				var2 = this.d[0] & 255;
				var3 = (this.d[0] >> 8 & 15) + this.c.chunkZ * 16;
				Position var4 = new Position(var1, var2, var3);
				this.a((Packet) (new PacketPlayOutBlockChange(qq.a(this.a), var4)));
				if (qq.a(this.a).getBlockState(var4).getBlock().x()) {
					this.a(qq.a(this.a).getTileEntity(var4));
				}
			} else {
				int var7;
				if (this.e == 64) {
					var1 = this.c.chunkX * 16;
					var2 = this.c.chunkZ * 16;
					this.a((Packet) (new PacketPlayOutChunkData(qq.a(this.a).a(this.c.chunkX, this.c.chunkZ), false, this.f)));

					for (var3 = 0; var3 < 16; ++var3) {
						if ((this.f & 1 << var3) != 0) {
							var7 = var3 << 4;
							List var5 = qq.a(this.a).a(var1, var7, var2, var1 + 16, var7 + 16, var2 + 16);

							for (int var6 = 0; var6 < var5.size(); ++var6) {
								this.a((TileEntity) var5.get(var6));
							}
						}
					}
				} else {
					this.a((Packet) (new PacketPlayOutMultiBlockChange(this.e, this.d, qq.a(this.a).a(this.c.chunkX, this.c.chunkZ))));

					for (var1 = 0; var1 < this.e; ++var1) {
						var2 = (this.d[var1] >> 12 & 15) + this.c.chunkX * 16;
						var3 = this.d[var1] & 255;
						var7 = (this.d[var1] >> 8 & 15) + this.c.chunkZ * 16;
						Position var8 = new Position(var2, var3, var7);
						if (qq.a(this.a).getBlockState(var8).getBlock().x()) {
							this.a(qq.a(this.a).getTileEntity(var8));
						}
					}
				}
			}

			this.e = 0;
			this.f = 0;
		}
	}

	private void a(TileEntity var1) {
		if (var1 != null) {
			Packet var2 = var1.getUpdatePacket();
			if (var2 != null) {
				this.a(var2);
			}
		}

	}

	// $FF: synthetic method
	static ChunkCoordIntPair a(qr var0) {
		return var0.c;
	}

	// $FF: synthetic method
	static List b(qr var0) {
		return var0.b;
	}
}
