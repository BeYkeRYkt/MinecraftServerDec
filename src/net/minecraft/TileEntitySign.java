package net.minecraft;

import com.google.gson.JsonParseException;
import net.minecraft.server.MinecraftServer;

public class TileEntitySign extends TileEntity {

	public final IChatBaseComponent[] a = new IChatBaseComponent[] { new ChatComponentText(""), new ChatComponentText(""), new ChatComponentText(""), new ChatComponentText("") };
	public int f = -1;
	private boolean g = true;
	private EntityHuman h;
	private final af i = new af();

	public void write(NBTCompoundTag var1) {
		super.write(var1);

		for (int var2 = 0; var2 < 4; ++var2) {
			String var3 = ChatSerializer.a(this.a[var2]);
			var1.put("Text" + (var2 + 1), var3);
		}

		this.i.b(var1);
	}

	public void read(NBTCompoundTag var1) {
		this.g = false;
		super.read(var1);
		bdk var2 = new bdk(this);

		for (int var3 = 0; var3 < 4; ++var3) {
			String var4 = var1.getString("Text" + (var3 + 1));

			try {
				IChatBaseComponent var5 = ChatSerializer.a(var4);

				try {
					this.a[var3] = hq.a(var2, var5, (Entity) null);
				} catch (di var7) {
					this.a[var3] = var5;
				}
			} catch (JsonParseException var8) {
				this.a[var3] = new ChatComponentText(var4);
			}
		}

		this.i.a(var1);
	}

	public Packet getUpdatePacket() {
		IChatBaseComponent[] var1 = new IChatBaseComponent[4];
		System.arraycopy(this.a, 0, var1, 0, 4);
		return new PacketPlayOutUpdateSign(this.world, this.position, var1);
	}

	public boolean b() {
		return this.g;
	}

	public void a(EntityHuman var1) {
		this.h = var1;
	}

	public EntityHuman c() {
		return this.h;
	}

	public boolean b(EntityHuman var1) {
		bdl var2 = new bdl(this, var1);

		for (int var3 = 0; var3 < this.a.length; ++var3) {
			ChatModifier var4 = this.a[var3] == null ? null : this.a[var3].b();
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
	static af a(TileEntitySign var0) {
		return var0.i;
	}
}
