package net.minecraft;

import java.util.Iterator;
import net.minecraft.server.MinecraftServer;

public class qp implements ara {

	private MinecraftServer a;
	private WorldServer b;

	public qp(MinecraftServer var1, WorldServer var2) {
		this.a = var1;
		this.b = var2;
	}

	public void a(int var1, boolean var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
	}

	public void a(Entity var1) {
		this.b.s().a(var1);
	}

	public void b(Entity var1) {
		this.b.s().b(var1);
	}

	public void a(String var1, double var2, double var4, double var6, float var8, float var9) {
		this.a.getPlayerList().a(var2, var4, var6, var8 > 1.0F ? (double) (16.0F * var8) : 16.0D, this.b.worldProvider.getDimensionId(), new PacketPlayOutSoundEffect(var1, var2, var4, var6, var8, var9));
	}

	public void a(EntityHuman var1, String var2, double var3, double var5, double var7, float var9, float var10) {
		this.a.getPlayerList().a(var1, var3, var5, var7, var9 > 1.0F ? (double) (16.0F * var9) : 16.0D, this.b.worldProvider.getDimensionId(), new PacketPlayOutSoundEffect(var2, var3, var5, var7, var9, var10));
	}

	public void a(int var1, int var2, int var3, int var4, int var5, int var6) {
	}

	public void a(Position var1) {
		this.b.t().a(var1);
	}

	public void b(Position var1) {
	}

	public void a(String var1, Position var2) {
	}

	public void a(EntityHuman var1, int var2, Position var3, int var4) {
		this.a.getPlayerList().a(var1, (double) var3.getX(), (double) var3.getY(), (double) var3.getZ(), 64.0D, this.b.worldProvider.getDimensionId(), new PacketPlayOutEffect(var2, var3, var4, false));
	}

	public void a(int var1, Position var2, int var3) {
		this.a.getPlayerList().sendPacket((Packet) (new PacketPlayOutEffect(var1, var2, var3, true)));
	}

	public void b(int var1, Position var2, int var3) {
		Iterator var4 = this.a.getPlayerList().players.iterator();

		while (var4.hasNext()) {
			EntityPlayer var5 = (EntityPlayer) var4.next();
			if (var5 != null && var5.world == this.b && var5.getId() != var1) {
				double var6 = (double) var2.getX() - var5.locationX;
				double var8 = (double) var2.getY() - var5.locationY;
				double var10 = (double) var2.getZ() - var5.locationZ;
				if (var6 * var6 + var8 * var8 + var10 * var10 < 1024.0D) {
					var5.playerConncetion.sendPacket((Packet) (new PacketPlayOutBlockBreakAnimation(var1, var2, var3)));
				}
			}
		}

	}
}
