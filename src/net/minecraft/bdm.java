package net.minecraft;

import com.google.common.collect.Iterables;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;

public class bdm extends bcm {

	private int a;
	private int f;
	private GameProfile g = null;

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.a("SkullType", (byte) (this.a & 255));
		var1.a("Rot", (byte) (this.f & 255));
		if (this.g != null) {
			NBTCompoundTag var2 = new NBTCompoundTag();
			ga.a(var2, this.g);
			var1.a("Owner", (NBTTag) var2);
		}

	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.a = var1.d("SkullType");
		this.f = var1.d("Rot");
		if (this.a == 3) {
			if (var1.b("Owner", 10)) {
				this.g = ga.a(var1.m("Owner"));
			} else if (var1.b("ExtraType", 8)) {
				String var2 = var1.j("ExtraType");
				if (!vb.b(var2)) {
					this.g = new GameProfile((UUID) null, var2);
					this.e();
				}
			}
		}

	}

	public GameProfile b() {
		return this.g;
	}

	public id x_() {
		NBTCompoundTag var1 = new NBTCompoundTag();
		this.b(var1);
		return new iu(this.c, 4, var1);
	}

	public void a(int var1) {
		this.a = var1;
		this.g = null;
	}

	public void a(GameProfile var1) {
		this.a = 3;
		this.g = var1;
		this.e();
	}

	private void e() {
		this.g = b(this.g);
		this.o_();
	}

	public static GameProfile b(GameProfile var0) {
		if (var0 != null && !vb.b(var0.getName())) {
			if (var0.isComplete() && var0.getProperties().containsKey("textures")) {
				return var0;
			} else if (MinecraftServer.getInstance() == null) {
				return var0;
			} else {
				GameProfile var1 = MinecraftServer.getInstance().getUserCache().a(var0.getName());
				if (var1 == null) {
					return var0;
				} else {
					Property var2 = (Property) Iterables.getFirst(var1.getProperties().get("textures"), (Object) null);
					if (var2 == null) {
						var1 = MinecraftServer.getInstance().getMinecraftSessionService().fillProfileProperties(var1, true);
					}

					return var1;
				}
			}
		} else {
			return var0;
		}
	}

	public int c() {
		return this.a;
	}

	public void b(int var1) {
		this.f = var1;
	}
}
