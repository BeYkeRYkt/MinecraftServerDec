package net.minecraft;

import com.google.common.collect.Iterables;
import net.minecraft.util.com.mojang.authlib.GameProfile;
import net.minecraft.util.com.mojang.authlib.properties.Property;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;

public class TileEntitySkull extends TileEntity {

	private int a;
	private int f;
	private GameProfile g = null;

	public void write(NBTCompoundTag var1) {
		super.write(var1);
		var1.put("SkullType", (byte) (this.a & 255));
		var1.put("Rot", (byte) (this.f & 255));
		if (this.g != null) {
			NBTCompoundTag var2 = new NBTCompoundTag();
			ga.a(var2, this.g);
			var1.put("Owner", (NBTTag) var2);
		}

	}

	public void read(NBTCompoundTag var1) {
		super.read(var1);
		this.a = var1.getByte("SkullType");
		this.f = var1.getByte("Rot");
		if (this.a == 3) {
			if (var1.isTagAssignableFrom("Owner", 10)) {
				this.g = ga.a(var1.getCompound("Owner"));
			} else if (var1.isTagAssignableFrom("ExtraType", 8)) {
				String var2 = var1.getString("ExtraType");
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

	public Packet getUpdatePacket() {
		NBTCompoundTag var1 = new NBTCompoundTag();
		this.write(var1);
		return new PacketPlayOutUpdateBlockEntity(this.position, 4, var1);
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
		this.update();
	}

	public static GameProfile b(GameProfile var0) {
		if (var0 != null && !vb.b(var0.getName())) {
			if (var0.isComplete() && var0.getProperties().containsKey("textures")) {
				return var0;
			} else if (MinecraftServer.getInstance() == null) {
				return var0;
			} else {
				GameProfile var1 = MinecraftServer.getInstance().getUserCache().getProfile(var0.getName());
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
