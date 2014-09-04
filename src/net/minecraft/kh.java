package net.minecraft;

import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import java.util.Iterator;
import java.util.List;

public class kh implements id<ik> {

	private kj a;
	private final List b = Lists.newArrayList();

	public kh() {
	}

	public kh(kj var1, qw... var2) {
		this.a = var1;
		qw[] var3 = var2;
		int var4 = var2.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			qw var6 = var3[var5];
			this.b.add(new kk(this, var6.cc(), var6.h, var6.c.b(), var6.E()));
		}

	}

	public kh(kj var1, Iterable var2) {
		this.a = var1;
		Iterator var3 = var2.iterator();

		while (var3.hasNext()) {
			qw var4 = (qw) var3.next();
			this.b.add(new kk(this, var4.cc(), var4.h, var4.c.b(), var4.E()));
		}

	}

	public void a(hd var1) {
		this.a = (kj) var1.a(kj.class);
		int var2 = var1.e();

		for (int var3 = 0; var3 < var2; ++var3) {
			GameProfile var4 = null;
			int var5 = 0;
			arc var6 = null;
			ho var7 = null;
			switch (ki.a[this.a.ordinal()]) {
				case 1:
					var4 = new GameProfile(var1.g(), var1.c(16));
					int var8 = var1.e();

					for (int var9 = 0; var9 < var8; ++var9) {
						String var10 = var1.c(32767);
						String var11 = var1.c(32767);
						if (var1.readBoolean()) {
							var4.getProperties().put(var10, new Property(var10, var11, var1.c(32767)));
						} else {
							var4.getProperties().put(var10, new Property(var10, var11));
						}
					}

					var6 = arc.a(var1.e());
					var5 = var1.e();
					if (var1.readBoolean()) {
						var7 = var1.d();
					}
					break;
				case 2:
					var4 = new GameProfile(var1.g(), (String) null);
					var6 = arc.a(var1.e());
					break;
				case 3:
					var4 = new GameProfile(var1.g(), (String) null);
					var5 = var1.e();
					break;
				case 4:
					var4 = new GameProfile(var1.g(), (String) null);
					if (var1.readBoolean()) {
						var7 = var1.d();
					}
					break;
				case 5:
					var4 = new GameProfile(var1.g(), (String) null);
			}

			this.b.add(new kk(this, var4, var5, var6, var7));
		}

	}

	public void b(hd var1) {
		var1.a((Enum) this.a);
		var1.b(this.b.size());
		Iterator var2 = this.b.iterator();

		while (var2.hasNext()) {
			kk var3 = (kk) var2.next();
			switch (ki.a[this.a.ordinal()]) {
				case 1:
					var1.a(var3.a().getId());
					var1.a(var3.a().getName());
					var1.b(var3.a().getProperties().size());
					Iterator var4 = var3.a().getProperties().values().iterator();

					while (var4.hasNext()) {
						Property var5 = (Property) var4.next();
						var1.a(var5.getName());
						var1.a(var5.getValue());
						if (var5.hasSignature()) {
							var1.writeBoolean(true);
							var1.a(var5.getSignature());
						} else {
							var1.writeBoolean(false);
						}
					}

					var1.b(var3.c().a());
					var1.b(var3.b());
					if (var3.d() == null) {
						var1.writeBoolean(false);
					} else {
						var1.writeBoolean(true);
						var1.a(var3.d());
					}
					break;
				case 2:
					var1.a(var3.a().getId());
					var1.b(var3.c().a());
					break;
				case 3:
					var1.a(var3.a().getId());
					var1.b(var3.b());
					break;
				case 4:
					var1.a(var3.a().getId());
					if (var3.d() == null) {
						var1.writeBoolean(false);
					} else {
						var1.writeBoolean(true);
						var1.a(var3.d());
					}
					break;
				case 5:
					var1.a(var3.a().getId());
			}
		}

	}

	public void a(ik var1) {
		var1.a(this);
	}
}
