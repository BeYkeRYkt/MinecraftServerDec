package net.minecraft;

import net.minecraft.server.MinecraftServer;

public class qj extends WorldServer {

	private static final long I = (long) "North Carolina".hashCode();
	public static final arb a = (new arb(I, GameMode.SURVIVAL, true, false, LevelType.DEFAULT)).a();

	public qj(MinecraftServer var1, IDataManager var2, WorldData var3, int var4, MethodProfiler var5) {
		super(var1, var2, var3, var4, var5);
		this.worldData.a(a);
	}

}
