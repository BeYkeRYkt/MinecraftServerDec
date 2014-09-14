package net.minecraft;

import com.google.gson.JsonParseException;
import net.minecraft.server.MinecraftServer;

public class TileEntitySign extends TileEntity {

	public final IChatBaseComponent[] lines = new IChatBaseComponent[] { new ChatComponentText(""), new ChatComponentText(""), new ChatComponentText(""), new ChatComponentText("") };
	public int f = -1;
	private boolean editable = true;
	private EntityHuman h;
	private final CommandBlockStatistic i = new CommandBlockStatistic();

	public void write(NBTCompoundTag var1) {
		super.write(var1);

		for (int var2 = 0; var2 < 4; ++var2) {
			String var3 = ChatSerializer.toJsonString(this.lines[var2]);
			var1.put("Text" + (var2 + 1), var3);
		}

		this.i.write(var1);
	}

	public void read(NBTCompoundTag var1) {
		this.editable = false;
		super.read(var1);
		bdk var2 = new bdk(this);

		for (int var3 = 0; var3 < 4; ++var3) {
			String var4 = var1.getString("Text" + (var3 + 1));

			try {
				IChatBaseComponent var5 = ChatSerializer.fromJsonString(var4);

				try {
					this.lines[var3] = hq.a(var2, var5, (Entity) null);
				} catch (di var7) {
					this.lines[var3] = var5;
				}
			} catch (JsonParseException var8) {
				this.lines[var3] = new ChatComponentText(var4);
			}
		}

		this.i.read(var1);
	}

	public Packet getUpdatePacket() {
		IChatBaseComponent[] var1 = new IChatBaseComponent[4];
		System.arraycopy(this.lines, 0, var1, 0, 4);
		return new PacketPlayOutUpdateSign(this.world, this.position, var1);
	}

	public boolean isEditable() {
		return this.editable;
	}

	public void a(EntityHuman var1) {
		this.h = var1;
	}

	public EntityHuman getEditor() {
		return this.h;
	}

	public boolean b(EntityHuman var1) {
		bdl var2 = new bdl(this, var1);

		for (int var3 = 0; var3 < this.lines.length; ++var3) {
			ChatModifier var4 = this.lines[var3] == null ? null : this.lines[var3].getChatModifier();
			if (var4 != null && var4.h() != null) {
				hm var5 = var4.h();
				if (var5.a() == hn.c) {
					MinecraftServer.getInstance().getCommandHandler().handleCommand(var2, var5.b());
				}
			}
		}

		return true;
	}

	public CommandBlockStatistic d() {
		return this.i;
	}

	// $FF: synthetic method
	static CommandBlockStatistic a(TileEntitySign var0) {
		return var0.i;
	}
}
