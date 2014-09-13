package net.minecraft;

import net.minecraft.server.MinecraftServer;

public class DemoWorldServer extends WorldServer {

	private static final long DEMO_SEED = (long) "North Carolina".hashCode();
	public static final WorldSettings DEMO_WORLD_SETTINGS = (new WorldSettings(DEMO_SEED, EnumGameMode.SURVIVAL, true, false, LevelType.DEFAULT)).enableBonusChest();

	public DemoWorldServer(MinecraftServer minecraftServer, IDataManager dataManager, WorldData worldData, int dimension, MethodProfiler methodProfiler) {
		super(minecraftServer, dataManager, worldData, dimension, methodProfiler);
		this.worldData.applySettings(DEMO_WORLD_SETTINGS);
	}

}
