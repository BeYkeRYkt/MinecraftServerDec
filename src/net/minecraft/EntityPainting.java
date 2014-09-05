package net.minecraft;

import com.google.common.collect.Lists;
import java.util.ArrayList;

public class EntityPainting extends adj {

	public PaintingType type;

	public EntityPainting(World var1) {
		super(var1);
	}

	public EntityPainting(World var1, Position var2, PaintingDirection var3) {
		super(var1, var2);
		ArrayList var4 = Lists.newArrayList();
		PaintingType[] var5 = PaintingType.values();
		int var6 = var5.length;

		for (int var7 = 0; var7 < var6; ++var7) {
			PaintingType var8 = var5[var7];
			this.type = var8;
			this.a(var3);
			if (this.j()) {
				var4.add(var8);
			}
		}

		if (!var4.isEmpty()) {
			this.type = (PaintingType) var4.get(this.V.nextInt(var4.size()));
		}

		this.a(var3);
	}

	public void b(NBTCompoundTag var1) {
		var1.put("Motive", this.type.name);
		super.b(var1);
	}

	public void a(NBTCompoundTag var1) {
		String var2 = var1.getString("Motive");
		PaintingType[] var3 = PaintingType.values();
		int var4 = var3.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			PaintingType var6 = var3[var5];
			if (var6.name.equals(var2)) {
				this.type = var6;
			}
		}

		if (this.type == null) {
			this.type = PaintingType.a;
		}

		super.a(var1);
	}

	public int l() {
		return this.type.C;
	}

	public int m() {
		return this.type.D;
	}

	public void b(Entity var1) {
		if (this.o.Q().b("doTileDrops")) {
			if (var1 instanceof EntityHuman) {
				EntityHuman var2 = (EntityHuman) var1;
				if (var2.by.instabuild) {
					return;
				}
			}

			this.a(new ItemStack(amk.an), 0.0F);
		}
	}

	public void b(double var1, double var3, double var5, float var7, float var8) {
		Position var9 = new Position(var1 - this.locationX, var3 - this.locationY, var5 - this.locationZ);
		Position var10 = this.a.a((fd) var9);
		this.b((double) var10.n(), (double) var10.o(), (double) var10.p());
	}
}
