package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bfy implements bfq, brq {

	private static final Logger a = LogManager.getLogger();
	private List b = Lists.newArrayList();
	private Set c = Sets.newHashSet();
	private Object d = new Object();
	private final File e;

	public bfy(File var1) {
		this.e = var1;
	}

	public bfh a(World var1, int var2, int var3) throws IOException {
		NBTCompoundTag var4 = null;
		aqm var5 = new aqm(var2, var3);
		Object var6 = this.d;
		synchronized (this.d) {
			if (this.c.contains(var5)) {
				for (int var7 = 0; var7 < this.b.size(); ++var7) {
					if (((bfz) this.b.get(var7)).a.equals(var5)) {
						var4 = ((bfz) this.b.get(var7)).b;
						break;
					}
				}
			}
		}

		if (var4 == null) {
			DataInputStream var10 = RegionFileCache.getInputStream(this.e, var2, var3);
			if (var10 == null) {
				return null;
			}

			var4 = fz.a(var10);
		}

		return this.a(var1, var2, var3, var4);
	}

	protected bfh a(World var1, int var2, int var3, NBTCompoundTag var4) {
		if (!var4.b("Level", 10)) {
			a.error("Chunk file at " + var2 + "," + var3 + " is missing level data, skipping");
			return null;
		} else if (!var4.m("Level").b("Sections", 9)) {
			a.error("Chunk file at " + var2 + "," + var3 + " is missing block data, skipping");
			return null;
		} else {
			bfh var5 = this.a(var1, var4.m("Level"));
			if (!var5.a(var2, var3)) {
				a.error("Chunk file at " + var2 + "," + var3 + " is in the wrong location; relocating. (Expected " + var2 + ", " + var3 + ", got " + var5.a + ", " + var5.b + ")");
				var4.a("xPos", var2);
				var4.a("zPos", var3);
				var5 = this.a(var1, var4.m("Level"));
			}

			return var5;
		}
	}

	public void a(World var1, bfh var2) throws aqz {
		var1.I();

		try {
			NBTCompoundTag var3 = new NBTCompoundTag();
			NBTCompoundTag var4 = new NBTCompoundTag();
			var3.a("Level", (NBTTag) var4);
			this.a(var2, var1, var4);
			this.a(var2.j(), var3);
		} catch (Exception var5) {
			var5.printStackTrace();
		}

	}

	protected void a(aqm var1, NBTCompoundTag var2) {
		Object var3 = this.d;
		synchronized (this.d) {
			if (this.c.contains(var1)) {
				for (int var4 = 0; var4 < this.b.size(); ++var4) {
					if (((bfz) this.b.get(var4)).a.equals(var1)) {
						this.b.set(var4, new bfz(var1, var2));
						return;
					}
				}
			}

			this.b.add(new bfz(var1, var2));
			this.c.add(var1);
			FileIOThread.getInstance().a(this);
		}
	}

	public boolean c() {
		bfz var1 = null;
		Object var2 = this.d;
		synchronized (this.d) {
			if (this.b.isEmpty()) {
				return false;
			}

			var1 = (bfz) this.b.remove(0);
			this.c.remove(var1.a);
		}

		if (var1 != null) {
			try {
				this.a(var1);
			} catch (Exception var4) {
				var4.printStackTrace();
			}
		}

		return true;
	}

	private void a(bfz var1) throws IOException {
		DataOutputStream var2 = RegionFileCache.getOutputStream(this.e, var1.a.a, var1.a.b);
		fz.a(var1.b, (DataOutput) var2);
		var2.close();
	}

	public void b(World var1, bfh var2) {
	}

	public void a() {
	}

	public void b() {
		while (this.c()) {
			;
		}

	}

	private void a(bfh var1, World var2, NBTCompoundTag var3) {
		var3.a("V", (byte) 1);
		var3.a("xPos", var1.a);
		var3.a("zPos", var1.b);
		var3.a("LastUpdate", var2.K());
		var3.a("HeightMap", var1.q());
		var3.a("TerrainPopulated", var1.t());
		var3.a("LightPopulated", var1.u());
		var3.a("InhabitedTime", var1.w());
		bfm[] var4 = var1.h();
		NBTListTag var5 = new NBTListTag();
		boolean var6 = !var2.t.o();
		bfm[] var7 = var4;
		int var8 = var4.length;

		NBTCompoundTag var11;
		for (int var9 = 0; var9 < var8; ++var9) {
			bfm var10 = var7[var9];
			if (var10 != null) {
				var11 = new NBTCompoundTag();
				var11.a("Y", (byte) (var10.d() >> 4 & 255));
				byte[] var12 = new byte[var10.g().length];
				bff var13 = new bff();
				bff var14 = null;

				for (int var15 = 0; var15 < var10.g().length; ++var15) {
					char var16 = var10.g()[var15];
					int var17 = var15 & 15;
					int var18 = var15 >> 8 & 15;
					int var19 = var15 >> 4 & 15;
					if (var16 >> 12 != 0) {
						if (var14 == null) {
							var14 = new bff();
						}

						var14.a(var17, var18, var19, var16 >> 12);
					}

					var12[var15] = (byte) (var16 >> 4 & 255);
					var13.a(var17, var18, var19, var16 & 15);
				}

				var11.a("Blocks", var12);
				var11.a("Data", var13.a());
				if (var14 != null) {
					var11.a("Add", var14.a());
				}

				var11.a("BlockLight", var10.h().a());
				if (var6) {
					var11.a("SkyLight", var10.i().a());
				} else {
					var11.a("SkyLight", new byte[var10.h().a().length]);
				}

				var5.a((NBTTag) var11);
			}
		}

		var3.a("Sections", (NBTTag) var5);
		var3.a("Biomes", var1.k());
		var1.g(false);
		NBTListTag var20 = new NBTListTag();

		Iterator var22;
		for (var8 = 0; var8 < var1.s().length; ++var8) {
			var22 = var1.s()[var8].iterator();

			while (var22.hasNext()) {
				Entity var24 = (Entity) var22.next();
				var11 = new NBTCompoundTag();
				if (var24.d(var11)) {
					var1.g(true);
					var20.a((NBTTag) var11);
				}
			}
		}

		var3.a("Entities", (NBTTag) var20);
		NBTListTag var21 = new NBTListTag();
		var22 = var1.r().values().iterator();

		while (var22.hasNext()) {
			bcm var25 = (bcm) var22.next();
			var11 = new NBTCompoundTag();
			var25.b(var11);
			var21.a((NBTTag) var11);
		}

		var3.a("TileEntities", (NBTTag) var21);
		List var23 = var2.a(var1, false);
		if (var23 != null) {
			long var26 = var2.K();
			NBTListTag var27 = new NBTListTag();
			Iterator var28 = var23.iterator();

			while (var28.hasNext()) {
				ark var29 = (ark) var28.next();
				NBTCompoundTag var30 = new NBTCompoundTag();
				oa var31 = (oa) atr.c.c(var29.a());
				var30.a("i", var31 == null ? "" : var31.toString());
				var30.a("x", var29.a.n());
				var30.a("y", var29.a.o());
				var30.a("z", var29.a.p());
				var30.a("t", (int) (var29.b - var26));
				var30.a("p", var29.c);
				var27.a((NBTTag) var30);
			}

			var3.a("TileTicks", (NBTTag) var27);
		}

	}

	private bfh a(World var1, NBTCompoundTag var2) {
		int var3 = var2.f("xPos");
		int var4 = var2.f("zPos");
		bfh var5 = new bfh(var1, var3, var4);
		var5.a(var2.l("HeightMap"));
		var5.d(var2.n("TerrainPopulated"));
		var5.e(var2.n("LightPopulated"));
		var5.c(var2.g("InhabitedTime"));
		NBTListTag var6 = var2.c("Sections", 10);
		byte var7 = 16;
		bfm[] var8 = new bfm[var7];
		boolean var9 = !var1.t.o();

		for (int var10 = 0; var10 < var6.c(); ++var10) {
			NBTCompoundTag var11 = var6.b(var10);
			byte var12 = var11.d("Y");
			bfm var13 = new bfm(var12 << 4, var9);
			byte[] var14 = var11.k("Blocks");
			bff var15 = new bff(var11.k("Data"));
			bff var16 = var11.b("Add", 7) ? new bff(var11.k("Add")) : null;
			char[] var17 = new char[var14.length];

			for (int var18 = 0; var18 < var17.length; ++var18) {
				int var19 = var18 & 15;
				int var20 = var18 >> 8 & 15;
				int var21 = var18 >> 4 & 15;
				int var22 = var16 != null ? var16.a(var19, var20, var21) : 0;
				var17[var18] = (char) (var22 << 12 | (var14[var18] & 255) << 4 | var15.a(var19, var20, var21));
			}

			var13.a(var17);
			var13.a(new bff(var11.k("BlockLight")));
			if (var9) {
				var13.b(new bff(var11.k("SkyLight")));
			}

			var13.e();
			var8[var12] = var13;
		}

		var5.a(var8);
		if (var2.b("Biomes", 7)) {
			var5.a(var2.k("Biomes"));
		}

		NBTListTag var23 = var2.c("Entities", 10);
		if (var23 != null) {
			for (int var24 = 0; var24 < var23.c(); ++var24) {
				NBTCompoundTag var26 = var23.b(var24);
				Entity var29 = xb.a(var26, var1);
				var5.g(true);
				if (var29 != null) {
					var5.a(var29);
					Entity var32 = var29;

					for (NBTCompoundTag var35 = var26; var35.b("Riding", 10); var35 = var35.m("Riding")) {
						Entity var37 = xb.a(var35.m("Riding"), var1);
						if (var37 != null) {
							var5.a(var37);
							var32.a(var37);
						}

						var32 = var37;
					}
				}
			}
		}

		NBTListTag var25 = var2.c("TileEntities", 10);
		if (var25 != null) {
			for (int var27 = 0; var27 < var25.c(); ++var27) {
				NBTCompoundTag var30 = var25.b(var27);
				bcm var33 = bcm.c(var30);
				if (var33 != null) {
					var5.a(var33);
				}
			}
		}

		if (var2.b("TileTicks", 9)) {
			NBTListTag var28 = var2.c("TileTicks", 10);
			if (var28 != null) {
				for (int var31 = 0; var31 < var28.c(); ++var31) {
					NBTCompoundTag var34 = var28.b(var31);
					atr var36;
					if (var34.b("i", 8)) {
						var36 = atr.b(var34.j("i"));
					} else {
						var36 = atr.c(var34.f("i"));
					}

					var1.b(new dt(var34.f("x"), var34.f("y"), var34.f("z")), var36, var34.f("t"), var34.f("p"));
				}
			}
		}

		return var5;
	}

}