package net.minecraft;

public class qk extends PlayerInteractManager {

	private boolean c;
	private boolean d;
	private int e;
	private int f;

	public qk(World var1) {
		super(var1);
	}

	public void a() {
		super.a();
		++this.f;
		long var1 = this.a.K();
		long var3 = var1 / 24000L + 1L;
		if (!this.c && this.f > 20) {
			this.c = true;
			this.b.playerConncetion.sendPacket((Packet) (new PacketOutChangeGameState(5, 0.0F)));
		}

		this.d = var1 > 120500L;
		if (this.d) {
			++this.e;
		}

		if (var1 % 24000L == 500L) {
			if (var3 <= 6L) {
				this.b.sendChatMessage((IChatBaseComponent) (new ChatMessage("demo.day." + var3, new Object[0])));
			}
		} else if (var3 == 1L) {
			if (var1 == 100L) {
				this.b.playerConncetion.sendPacket((Packet) (new PacketOutChangeGameState(5, 101.0F)));
			} else if (var1 == 175L) {
				this.b.playerConncetion.sendPacket((Packet) (new PacketOutChangeGameState(5, 102.0F)));
			} else if (var1 == 250L) {
				this.b.playerConncetion.sendPacket((Packet) (new PacketOutChangeGameState(5, 103.0F)));
			}
		} else if (var3 == 5L && var1 % 24000L == 22000L) {
			this.b.sendChatMessage((IChatBaseComponent) (new ChatMessage("demo.day.warning", new Object[0])));
		}

	}

	private void f() {
		if (this.e > 100) {
			this.b.sendChatMessage((IChatBaseComponent) (new ChatMessage("demo.reminder", new Object[0])));
			this.e = 0;
		}

	}

	public void a(Position var1, BlockFace var2) {
		if (this.d) {
			this.f();
		} else {
			super.a(var1, var2);
		}
	}

	public void a(Position var1) {
		if (!this.d) {
			super.a(var1);
		}
	}

	public boolean b(Position var1) {
		return this.d ? false : super.b(var1);
	}

	public boolean a(EntityHuman var1, World var2, ItemStack var3) {
		if (this.d) {
			this.f();
			return false;
		} else {
			return super.a(var1, var2, var3);
		}
	}

	public boolean a(EntityHuman var1, World var2, ItemStack var3, Position var4, BlockFace var5, float var6, float var7, float var8) {
		if (this.d) {
			this.f();
			return false;
		} else {
			return super.a(var1, var2, var3, var4, var5, var6, var7, var8);
		}
	}
}
