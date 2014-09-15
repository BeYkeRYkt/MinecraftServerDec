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
		BlockDispenser.M.a(Items.ARROW, new DispenseBehaviorArrow());
		BlockDispenser.M.a(Items.EGG, new DispenseBehaviorEgg());
		BlockDispenser.M.a(Items.SNOWBALL, new DispenseBehaviorSnowBall());
		BlockDispenser.M.a(Items.EXP_BOTTLE, new DispenseBehaviorExpBottle());
		BlockDispenser.M.a(Items.POTION, new DispenseBehaviorPotion());
		BlockDispenser.M.a(Items.SPAWNEGG, new DispenseBehaviorMonsterEgg());
		BlockDispenser.M.a(Items.FIREWORKS, new DispenseBehaviorFireworks());
		BlockDispenser.M.a(Items.FIRE_CHARGE, new DispenseBehaviorFireball());
		BlockDispenser.M.a(Items.BOAT, new DispenseBehaviorBoat());
		DispenseBehaviorFilledBucket dispensebehaviorfilledbucket = new DispenseBehaviorFilledBucket();
		BlockDispenser.M.a(Items.LAVA_BUCKET, dispensebehaviorfilledbucket);
		BlockDispenser.M.a(Items.WATER_BUCKET, dispensebehaviorfilledbucket);
		BlockDispenser.M.a(Items.BUCKET, new DispenseBehaviorEmptyBucket());
		BlockDispenser.M.a(Items.FLINT_AND_STEEL, new DispenseBehaviorFlintAndSteel());
		BlockDispenser.M.a(Items.DYE, new DispenseBehaviorDye());
		BlockDispenser.M.a(Item.getItemOf(Blocks.TNT), new DispenseBehaviorBonemeal());
		BlockDispenser.M.a(Items.SKULL, new DispenseBehaviorSkull());
		BlockDispenser.M.a(Item.getItemOf(Blocks.PUMPKIN), new DispenseBehaviorPumpkin());
		BlockDispenser.M.a(Item.getItemOf(Blocks.COMMAND_BLOCK), new DispenseBehaviorCommandBlock());
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
