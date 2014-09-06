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
		BlockDispenser.M.a(Items.g, new oe());
		BlockDispenser.M.a(Items.aP, new on());
		BlockDispenser.M.a(Items.aD, new oo());
		BlockDispenser.M.a(Items.bK, new op());
		BlockDispenser.M.a(Items.bz, new oq());
		BlockDispenser.M.a(Items.bJ, new os());
		BlockDispenser.M.a(Items.cb, new ot());
		BlockDispenser.M.a(Items.bL, new ou());
		BlockDispenser.M.a(Items.aE, new ov());
		DispenseBehaviorFilledBucket dispensebehaviorfilledbucket = new DispenseBehaviorFilledBucket();
		BlockDispenser.M.a(Items.ay, dispensebehaviorfilledbucket);
		BlockDispenser.M.a(Items.ax, dispensebehaviorfilledbucket);
		BlockDispenser.M.a(Items.aw, new og());
		BlockDispenser.M.a(Items.d, new oh());
		BlockDispenser.M.a(Items.aW, new oi());
		BlockDispenser.M.a(Item.getItemOf(Blocks.TNT), new oj());
		BlockDispenser.M.a(Items.bX, new ok());
		BlockDispenser.M.a(Item.getItemOf(Blocks.PUMPKIN), new ol());
		BlockDispenser.M.a(Item.getItemOf(Blocks.COMMAND_BLOCK), new om());
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
			registerDispensers();
		}
	}

	private static void hookOutput() {
		System.setErr(new DebugPrintStream("STDERR", System.err));
		System.setOut(new DebugPrintStream("STDOUT", stream));
	}

}
