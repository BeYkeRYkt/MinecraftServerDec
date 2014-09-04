package net.minecraft;

import com.google.gson.JsonParseException;
import net.minecraft.server.MinecraftServer;

public class bdj extends bcm {

	public final ho[] a = new ho[] { new hy(""), new hy(""), new hy(""), new hy("") };
	public int f = -1;
	private boolean g = true;
	private ahd h;
	private final af i = new af();

	public void b(NBTCompoundTag var1) {
		super.b(var1);

		for (int var2 = 0; var2 < 4; ++var2) {
			String var3 = hp.a(this.a[var2]);
			var1.put("Text" + (var2 + 1), var3);
		}

		this.i.b(var1);
	}

	public void a(NBTCompoundTag var1) {
		this.g = false;
		super.a(var1);
		bdk var2 = new bdk(this);

		for (int var3 = 0; var3 < 4; ++var3) {
			String var4 = var1.getString("Text" + (var3 + 1));

			try {
				ho var5 = hp.a(var4);

				try {
					this.a[var3] = hq.a(var2, var5, (Entity) null);
				} catch (di var7) {
					this.a[var3] = var5;
				}
			} catch (JsonParseException var8) {
				this.a[var3] = new hy(var4);
			}
		}

		this.i.a(var1);
	}

	public id x_() {
		ho[] var1 = new ho[4];
		System.arraycopy(this.a, 0, var1, 0, 4);
		return new ll(this.b, this.c, var1);
	}

	public boolean b() {
		return this.g;
	}

	public void a(ahd var1) {
		this.h = var1;
	}

	public ahd c() {
		return this.h;
	}

	public boolean b(ahd var1) {
		bdl var2 = new bdl(this, var1);

		for (int var3 = 0; var3 < this.a.length; ++var3) {
			hv var4 = this.a[var3] == null ? null : this.a[var3].b();
			if (var4 != null && var4.h() != null) {
				hm var5 = var4.h();
				if (var5.a() == hn.c) {
					MinecraftServer.getInstance().getCommandHandler().a(var2, var5.b());
				}
			}
		}

		return true;
	}

	public af d() {
		return this.i;
	}

	// $FF: synthetic method
	static af a(bdj var0) {
		return var0.i;
	}
}
