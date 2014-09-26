package net.minecraft;

import java.io.PrintStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Bootstrap {

	private static final PrintStream stream = System.out;
	private static boolean ready = false;
	private static final Logger logger = LogManager.getLogger();

	public static boolean isReady() {
		return ready;
	}

	static void registerDispensers() {
		BlockDispenser.registry.a(Items.ARROW, new DispenseBehaviorArrow());
		BlockDispenser.registry.a(Items.EGG, new DispenseBehaviorEgg());
		BlockDispenser.registry.a(Items.SNOWBALL, new DispenseBehaviorSnowBall());
		BlockDispenser.registry.a(Items.EXP_BOTTLE, new DispenseBehaviorExpBottle());
		BlockDispenser.registry.a(Items.POTION, new DispenseBehaviorPotion());
		BlockDispenser.registry.a(Items.SPAWNEGG, new DispenseBehaviorMonsterEgg());
		BlockDispenser.registry.a(Items.FIREWORKS, new DispenseBehaviorFireworks());
		BlockDispenser.registry.a(Items.FIRE_CHARGE, new DispenseBehaviorFireball());
		BlockDispenser.registry.a(Items.BOAT, new DispenseBehaviorBoat());
		DispenseBehaviorFilledBucket dispensebehaviorfilledbucket = new DispenseBehaviorFilledBucket();
		BlockDispenser.registry.a(Items.LAVA_BUCKET, dispensebehaviorfilledbucket);
		BlockDispenser.registry.a(Items.WATER_BUCKET, dispensebehaviorfilledbucket);
		BlockDispenser.registry.a(Items.BUCKET, new DispenseBehaviorEmptyBucket());
		BlockDispenser.registry.a(Items.FLINT_AND_STEEL, new DispenseBehaviorFlintAndSteel());
		BlockDispenser.registry.a(Items.DYE, new DispenseBehaviorDye());
		BlockDispenser.registry.a(Item.getItemOf(Blocks.TNT), new DispenseBehaviorBonemeal());
		BlockDispenser.registry.a(Items.SKULL, new DispenseBehaviorSkull());
		BlockDispenser.registry.a(Item.getItemOf(Blocks.PUMPKIN), new DispenseBehaviorPumpkin());
		BlockDispenser.registry.a(Item.getItemOf(Blocks.COMMAND_BLOCK), new DispenseBehaviorCommandBlock());
	}

	public static void load() {
		if (!ready) {
			ready = true;
			if (logger.isDebugEnabled()) {
				hookOutput();
			}

			Block.registerBlocks();
			BlockFire.registerBurnableBlocks();
			Item.registerItems();
			StatisticList.register();
			AchievementList.init();
			registerDispensers();
		}
	}

	private static void hookOutput() {
		System.setErr(new DebugPrintStream("STDERR", System.err));
		System.setOut(new DebugPrintStream("STDOUT", stream));
	}

}
