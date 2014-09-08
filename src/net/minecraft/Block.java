package net.minecraft;

import java.util.List;
import java.util.Random;

public class Block {

	private static final RegistryObjectName air = new RegistryObjectName("air");

	public static final RegistryBlocks BLOCKREGISTRY = new RegistryBlocks(air);
	public static final RegistryID IDREGISTRY = new RegistryID();
	public static final BlockSound e = new BlockSound("stone", 1.0F, 1.0F);
	public static final BlockSound f = new BlockSound("wood", 1.0F, 1.0F);
	public static final BlockSound g = new BlockSound("gravel", 1.0F, 1.0F);
	public static final BlockSound h = new BlockSound("grass", 1.0F, 1.0F);
	public static final BlockSound i = new BlockSound("stone", 1.0F, 1.0F);
	public static final BlockSound j = new BlockSound("stone", 1.0F, 1.5F);
	public static final BlockSound k = new BlockSoundStone("stone", 1.0F, 1.0F);
	public static final BlockSound l = new BlockSound("cloth", 1.0F, 1.0F);
	public static final BlockSound m = new BlockSound("sand", 1.0F, 1.0F);
	public static final BlockSound n = new BlockSound("snow", 1.0F, 1.0F);
	public static final BlockSound o = new BlockSoundLadder("ladder", 1.0F, 1.0F);
	public static final BlockSound p = new BlockSoundAnvil("anvil", 0.3F, 1.0F);
	public static final BlockSound q = new BlockSoundSlime("slime", 1.0F, 1.0F);

	public static void registerBlocks() {
		registerBlock(0, air, (new BlockAir()).setName("air"));
		registerBlock(1, "stone", (new BlockStone()).c(1.5F).b(10.0F).a(i).setName("stone"));
		registerBlock(2, "grass", (new BlockGrass()).c(0.6F).a(h).setName("grass"));
		registerBlock(3, "dirt", (new BlockDirt()).c(0.5F).a(g).setName("dirt"));
		Block stoneBrick = (new Block(Material.STONE)).c(2.0F).b(10.0F).a(i).setName("stonebrick").a(CreativeModeTab.BUILDING_BLOCKS);
		registerBlock(4, "cobblestone", stoneBrick);
		Block wood = (new BlockWood()).c(2.0F).b(5.0F).a(f).setName("wood");
		registerBlock(5, "planks", wood);
		registerBlock(6, "sapling", (new BlockSapling()).c(0.0F).a(h).setName("sapling"));
		registerBlock(7, "bedrock", (new Block(Material.STONE)).v().b(6000000.0F).a(i).setName("bedrock").J().a(CreativeModeTab.BUILDING_BLOCKS));
		registerBlock(8, "flowing_water", (new BlockFlowing(Material.WATER)).c(100.0F).e(3).setName("water").J());
		registerBlock(9, "water", (new BlockStationary(Material.WATER)).c(100.0F).e(3).setName("water").J());
		registerBlock(10, "flowing_lava", (new BlockFlowing(Material.LAVA)).c(100.0F).a(1.0F).setName("lava").J());
		registerBlock(11, "lava", (new BlockStationary(Material.LAVA)).c(100.0F).a(1.0F).setName("lava").J());
		registerBlock(12, "sand", (new BlockSand()).c(0.5F).a(m).setName("sand"));
		registerBlock(13, "gravel", (new BlockGravel()).c(0.6F).a(g).setName("gravel"));
		registerBlock(14, "gold_ore", (new BlockOre()).c(3.0F).b(5.0F).a(i).setName("oreGold"));
		registerBlock(15, "iron_ore", (new BlockOre()).c(3.0F).b(5.0F).a(i).setName("oreIron"));
		registerBlock(16, "coal_ore", (new BlockOre()).c(3.0F).b(5.0F).a(i).setName("oreCoal"));
		registerBlock(17, "log", (new BlockLog1()).setName("log"));
		registerBlock(18, "leaves", (new BlockLeaves1()).setName("leaves"));
		registerBlock(19, "sponge", (new BlockSponge()).c(0.6F).a(h).setName("sponge"));
		registerBlock(20, "glass", (new BlockGlass(Material.SHATTERABLE, false)).c(0.3F).a(k).setName("glass"));
		registerBlock(21, "lapis_ore", (new BlockOre()).c(3.0F).b(5.0F).a(i).setName("oreLapis"));
		registerBlock(22, "lapis_block", (new BlockOreBlock(MaterialMapColor.H)).c(3.0F).b(5.0F).a(i).setName("blockLapis").a(CreativeModeTab.BUILDING_BLOCKS));
		registerBlock(23, "dispenser", (new BlockDispenser()).c(3.5F).a(i).setName("dispenser"));
		Block sandStone = (new BlockSandStone()).a(i).c(0.8F).setName("sandStone");
		registerBlock(24, "sandstone", sandStone);
		registerBlock(25, "noteblock", (new BlockNote()).c(0.8F).setName("musicBlock"));
		registerBlock(26, "bed", (new BlockBed()).a(f).c(0.2F).setName("bed").J());
		registerBlock(27, "golden_rail", (new BlockPoweredRail()).c(0.7F).a(j).setName("goldenRail"));
		registerBlock(28, "detector_rail", (new BlockMinecartDetector()).c(0.7F).a(j).setName("detectorRail"));
		registerBlock(29, "sticky_piston", (new BlockPiston(true)).setName("pistonStickyBase"));
		registerBlock(30, "web", (new BlockWeb()).e(1).c(4.0F).setName("web"));
		registerBlock(31, "tallgrass", (new BlockLongGrass()).c(0.0F).a(h).setName("tallgrass"));
		registerBlock(32, "deadbush", (new BlockDeadBush()).c(0.0F).a(h).setName("deadbush"));
		registerBlock(33, "piston", (new BlockPiston(false)).setName("pistonBase"));
		registerBlock(34, "piston_head", new BlockPistonExtension());
		registerBlock(35, "wool", (new BlockCloth(Material.CLOTH)).c(0.8F).a(l).setName("cloth"));
		registerBlock(36, "piston_extension", new BlockPistonMoving());
		registerBlock(37, "yellow_flower", (new BlockYellowFlower()).c(0.0F).a(h).setName("flower1"));
		registerBlock(38, "red_flower", (new BlockRedFlower()).c(0.0F).a(h).setName("flower2"));
		Block mushroom1 = (new BlockMushroom()).c(0.0F).a(h).a(0.125F).setName("mushroom");
		registerBlock(39, "brown_mushroom", mushroom1);
		Block mushroom2 = (new BlockMushroom()).c(0.0F).a(h).setName("mushroom");
		registerBlock(40, "red_mushroom", mushroom2);
		registerBlock(41, "gold_block", (new BlockOreBlock(MaterialMapColor.F)).c(3.0F).b(10.0F).a(j).setName("blockGold"));
		registerBlock(42, "iron_block", (new BlockOreBlock(MaterialMapColor.h)).c(5.0F).b(10.0F).a(j).setName("blockIron"));
		registerBlock(43, "double_stone_slab", (new BlockDoubleStep()).c(2.0F).b(10.0F).a(i).setName("stoneSlab"));
		registerBlock(44, "stone_slab", (new BlockSingleStep()).c(2.0F).b(10.0F).a(i).setName("stoneSlab"));
		Block stone = (new Block(Material.STONE)).c(2.0F).b(10.0F).a(i).setName("brick").a(CreativeModeTab.BUILDING_BLOCKS);
		registerBlock(45, "brick_block", stone);
		registerBlock(46, "tnt", (new BlockTNT()).c(0.0F).a(h).setName("tnt"));
		registerBlock(47, "bookshelf", (new BlockBookshelf()).c(1.5F).a(f).setName("bookshelf"));
		registerBlock(48, "mossy_cobblestone", (new Block(Material.STONE)).c(2.0F).b(10.0F).a(i).setName("stoneMoss").a(CreativeModeTab.BUILDING_BLOCKS));
		registerBlock(49, "obsidian", (new BlockObsidian()).c(50.0F).b(2000.0F).a(i).setName("obsidian"));
		registerBlock(50, "torch", (new BlockTorch()).c(0.0F).a(0.9375F).a(f).setName("torch"));
		registerBlock(51, "fire", (new BlockFire()).c(0.0F).a(1.0F).a(l).setName("fire").J());
		registerBlock(52, "mob_spawner", (new BlockMobSpawner()).c(5.0F).a(j).setName("mobSpawner").J());
		registerBlock(53, "oak_stairs", (new BlockStairs(wood.getBlockState().a(BlockWood.a, ayx.a))).setName("stairsWood"));
		registerBlock(54, "chest", (new BlockChest(0)).c(2.5F).a(f).setName("chest"));
		registerBlock(55, "redstone_wire", (new BlockRedstoneWire()).c(0.0F).a(e).setName("redstoneDust").J());
		registerBlock(56, "diamond_ore", (new BlockOre()).c(3.0F).b(5.0F).a(i).setName("oreDiamond"));
		registerBlock(57, "diamond_block", (new BlockOreBlock(MaterialMapColor.G)).c(5.0F).b(10.0F).a(j).setName("blockDiamond"));
		registerBlock(58, "crafting_table", (new BlockWorkbench()).c(2.5F).a(f).setName("workbench"));
		registerBlock(59, "wheat", (new BlockCrops()).setName("crops"));
		Block soil = (new BlockSoil()).c(0.6F).a(g).setName("farmland");
		registerBlock(60, "farmland", soil);
		registerBlock(61, "furnace", (new BlockFurnace(false)).c(3.5F).a(i).setName("furnace").a(CreativeModeTab.DECORATIONS));
		registerBlock(62, "lit_furnace", (new BlockFurnace(true)).c(3.5F).a(i).a(0.875F).setName("furnace"));
		registerBlock(63, "standing_sign", (new BlockStandingSign()).c(1.0F).a(f).setName("sign").J());
		registerBlock(64, "wooden_door", (new BlockDoor(Material.WOOD)).c(3.0F).a(f).setName("doorOak").J());
		registerBlock(65, "ladder", (new BlockLadder()).c(0.4F).a(o).setName("ladder"));
		registerBlock(66, "rail", (new BlockMinecartTrack()).c(0.7F).a(j).setName("rail"));
		registerBlock(67, "stone_stairs", (new BlockStairs(stoneBrick.getBlockState())).setName("stairsStone"));
		registerBlock(68, "wall_sign", (new BlockWallSign()).c(1.0F).a(f).setName("sign").J());
		registerBlock(69, "lever", (new BlockLever()).c(0.5F).a(f).setName("lever"));
		registerBlock(70, "stone_pressure_plate", (new BlockPressurePlateBinary(Material.STONE, azh.b)).c(0.5F).a(i).setName("pressurePlateStone"));
		registerBlock(71, "iron_door", (new BlockDoor(Material.ORE)).c(5.0F).a(j).setName("doorIron").J());
		registerBlock(72, "wooden_pressure_plate", (new BlockPressurePlateBinary(Material.WOOD, azh.a)).c(0.5F).a(f).setName("pressurePlateWood"));
		registerBlock(73, "redstone_ore", (new BlockRedstoneOre(false)).c(3.0F).b(5.0F).a(i).setName("oreRedstone").a(CreativeModeTab.BUILDING_BLOCKS));
		registerBlock(74, "lit_redstone_ore", (new BlockRedstoneOre(true)).a(0.625F).c(3.0F).b(5.0F).a(i).setName("oreRedstone"));
		registerBlock(75, "unlit_redstone_torch", (new BlockRedstoneTorch(false)).c(0.0F).a(f).setName("notGate"));
		registerBlock(76, "redstone_torch", (new BlockRedstoneTorch(true)).c(0.0F).a(0.5F).a(f).setName("notGate").a(CreativeModeTab.REDSTONE));
		registerBlock(77, "stone_button", (new BlockStoneButton()).c(0.5F).a(i).setName("button"));
		registerBlock(78, "snow_layer", (new BlockSnow()).c(0.1F).a(n).setName("snow").e(0));
		registerBlock(79, "ice", (new BlockIce()).c(0.5F).e(3).a(k).setName("ice"));
		registerBlock(80, "snow", (new BlockSnowBlock()).c(0.2F).a(n).setName("snow"));
		registerBlock(81, "cactus", (new BlockCactus()).c(0.4F).a(l).setName("cactus"));
		registerBlock(82, "clay", (new BlockClay()).c(0.6F).a(g).setName("clay"));
		registerBlock(83, "reeds", (new BlockReed()).c(0.0F).a(h).setName("reeds").J());
		registerBlock(84, "jukebox", (new BlockJukeBox()).c(2.0F).b(10.0F).a(i).setName("jukebox"));
		registerBlock(85, "fence", (new BlockFence(Material.WOOD)).c(2.0F).b(5.0F).a(f).setName("fence"));
		Block pumpkin = (new BlockPumpkin()).c(1.0F).a(f).setName("pumpkin");
		registerBlock(86, "pumpkin", pumpkin);
		registerBlock(87, "netherrack", (new BlockBloodStone()).c(0.4F).a(i).setName("hellrock"));
		registerBlock(88, "soul_sand", (new BlockSlowSand()).c(0.5F).a(m).setName("hellsand"));
		registerBlock(89, "glowstone", (new BlockLightStone(Material.SHATTERABLE)).c(0.3F).a(k).a(1.0F).setName("lightgem"));
		registerBlock(90, "portal", (new BlockPortal()).c(-1.0F).a(k).a(0.75F).setName("portal"));
		registerBlock(91, "lit_pumpkin", (new BlockPumpkin()).c(1.0F).a(f).a(1.0F).setName("litpumpkin"));
		registerBlock(92, "cake", (new BlockCake()).c(0.5F).a(l).setName("cake").J());
		registerBlock(93, "unpowered_repeater", (new BlockRepeater(false)).c(0.0F).a(f).setName("diode").J());
		registerBlock(94, "powered_repeater", (new BlockRepeater(true)).c(0.0F).a(f).setName("diode").J());
		registerBlock(95, "stained_glass", (new BlockStainedGlass(Material.SHATTERABLE)).c(0.3F).a(k).setName("stainedGlass"));
		registerBlock(96, "trapdoor", (new BlockTrapdoor(Material.WOOD)).c(3.0F).a(f).setName("trapdoor").J());
		registerBlock(97, "monster_egg", (new BlockMonsterEggs()).c(0.75F).setName("monsterStoneEgg"));
		Block smoothbrick = (new BlockSmoothBrick()).c(1.5F).b(10.0F).a(i).setName("stonebricksmooth");
		registerBlock(98, "stonebrick", smoothbrick);
		registerBlock(99, "brown_mushroom_block", (new BlockHugeMushroom(Material.WOOD, mushroom1)).c(0.2F).a(f).setName("mushroom"));
		registerBlock(100, "red_mushroom_block", (new BlockHugeMushroom(Material.WOOD, mushroom2)).c(0.2F).a(f).setName("mushroom"));
		registerBlock(101, "iron_bars", (new BlockThin(Material.ORE, true)).c(5.0F).b(10.0F).a(j).setName("fenceIron"));
		registerBlock(102, "glass_pane", (new BlockThin(Material.SHATTERABLE, false)).c(0.3F).a(k).setName("thinGlass"));
		Block melon = (new BlockMelon()).c(1.0F).a(f).setName("melon");
		registerBlock(103, "melon_block", melon);
		registerBlock(104, "pumpkin_stem", (new BlockStem(pumpkin)).c(0.0F).a(f).setName("pumpkinStem"));
		registerBlock(105, "melon_stem", (new BlockStem(melon)).c(0.0F).a(f).setName("pumpkinStem"));
		registerBlock(106, "vine", (new BlockVine()).c(0.2F).a(h).setName("vine"));
		registerBlock(107, "fence_gate", (new BlockFenceGate()).c(2.0F).b(5.0F).a(f).setName("fenceGate"));
		registerBlock(108, "brick_stairs", (new BlockStairs(stone.getBlockState())).setName("stairsBrick"));
		registerBlock(109, "stone_brick_stairs", (new BlockStairs(smoothbrick.getBlockState().a(BlockSmoothBrick.a, bbd.a))).setName("stairsStoneBrickSmooth"));
		registerBlock(110, "mycelium", (new BlockMycel()).c(0.6F).a(h).setName("mycel"));
		registerBlock(111, "waterlily", (new BlockWaterLily()).c(0.0F).a(h).setName("waterlily"));
		Block netherBrick = (new BlockNetherBrick()).c(2.0F).b(10.0F).a(i).setName("netherBrick").a(CreativeModeTab.BUILDING_BLOCKS);
		registerBlock(112, "nether_brick", netherBrick);
		registerBlock(113, "nether_brick_fence", (new BlockFence(Material.STONE)).c(2.0F).b(10.0F).a(i).setName("netherFence"));
		registerBlock(114, "nether_brick_stairs", (new BlockStairs(netherBrick.getBlockState())).setName("stairsNetherBrick"));
		registerBlock(115, "nether_wart", (new BlockNetherWart()).setName("netherStalk"));
		registerBlock(116, "enchanting_table", (new BlockEnchantmentTable()).c(5.0F).b(2000.0F).setName("enchantmentTable"));
		registerBlock(117, "brewing_stand", (new BlockBrewingStand()).c(0.5F).a(0.125F).setName("brewingStand"));
		registerBlock(118, "cauldron", (new BlockCauldron()).c(2.0F).setName("cauldron"));
		registerBlock(119, "end_portal", (new BlockEnderPortal(Material.PORTAL)).c(-1.0F).b(6000000.0F));
		registerBlock(120, "end_portal_frame", (new BlockEnderPortalFrame()).a(k).a(0.125F).c(-1.0F).setName("endPortalFrame").b(6000000.0F).a(CreativeModeTab.DECORATIONS));
		registerBlock(121, "end_stone", (new Block(Material.STONE)).c(3.0F).b(15.0F).a(i).setName("whiteStone").a(CreativeModeTab.BUILDING_BLOCKS));
		registerBlock(122, "dragon_egg", (new BlockDragonEgg()).c(3.0F).b(15.0F).a(i).a(0.125F).setName("dragonEgg"));
		registerBlock(123, "redstone_lamp", (new BlockRedstoneLamp(false)).c(0.3F).a(k).setName("redstoneLight").a(CreativeModeTab.REDSTONE));
		registerBlock(124, "lit_redstone_lamp", (new BlockRedstoneLamp(true)).c(0.3F).a(k).setName("redstoneLight"));
		registerBlock(125, "double_wooden_slab", (new BlockDoubleWoodStep()).c(2.0F).b(5.0F).a(f).setName("woodSlab"));
		registerBlock(126, "wooden_slab", (new BlockSingleWoodStep()).c(2.0F).b(5.0F).a(f).setName("woodSlab"));
		registerBlock(127, "cocoa", (new BlockCocoa()).c(0.2F).b(5.0F).a(f).setName("cocoa"));
		registerBlock(128, "sandstone_stairs", (new BlockStairs(sandStone.getBlockState().a(BlockSandStone.a, bae.c))).setName("stairsSandStone"));
		registerBlock(129, "emerald_ore", (new BlockOre()).c(3.0F).b(5.0F).a(i).setName("oreEmerald"));
		registerBlock(130, "ender_chest", (new BlockEnderChest()).c(22.5F).b(1000.0F).a(i).setName("enderChest").a(0.5F));
		registerBlock(131, "tripwire_hook", (new BlockTripwireHook()).setName("tripWireSource"));
		registerBlock(132, "tripwire", (new BlockTripwire()).setName("tripWire"));
		registerBlock(133, "emerald_block", (new BlockOreBlock(MaterialMapColor.I)).c(5.0F).b(10.0F).a(j).setName("blockEmerald"));
		registerBlock(134, "spruce_stairs", (new BlockStairs(wood.getBlockState().a(BlockWood.a, ayx.b))).setName("stairsWoodSpruce"));
		registerBlock(135, "birch_stairs", (new BlockStairs(wood.getBlockState().a(BlockWood.a, ayx.c))).setName("stairsWoodBirch"));
		registerBlock(136, "jungle_stairs", (new BlockStairs(wood.getBlockState().a(BlockWood.a, ayx.d))).setName("stairsWoodJungle"));
		registerBlock(137, "command_block", (new BlockCommand()).v().b(6000000.0F).setName("commandBlock"));
		registerBlock(138, "beacon", (new BlockBeacon()).setName("beacon").a(1.0F));
		registerBlock(139, "cobblestone_wall", (new BlockCobbleWall(stoneBrick)).setName("cobbleWall"));
		registerBlock(140, "flower_pot", (new BlockFlowerPot()).c(0.0F).a(e).setName("flowerPot"));
		registerBlock(141, "carrots", (new BlockCarrots()).setName("carrots"));
		registerBlock(142, "potatoes", (new BlockPotatoes()).setName("potatoes"));
		registerBlock(143, "wooden_button", (new BlockWoodButton()).c(0.5F).a(f).setName("button"));
		registerBlock(144, "skull", (new BlockSkull()).c(1.0F).a(i).setName("skull"));
		registerBlock(145, "anvil", (new BlockAnvil()).c(5.0F).a(p).b(2000.0F).setName("anvil"));
		registerBlock(146, "trapped_chest", (new BlockChest(1)).c(2.5F).a(f).setName("chestTrap"));
		registerBlock(147, "light_weighted_pressure_plate", (new BlockPressurePlateWeighted("gold_block", Material.ORE, 15)).c(0.5F).a(f).setName("weightedPlate_light"));
		registerBlock(148, "heavy_weighted_pressure_plate", (new BlockPressurePlateWeighted("iron_block", Material.ORE, 150)).c(0.5F).a(f).setName("weightedPlate_heavy"));
		registerBlock(149, "unpowered_comparator", (new BlockRedstoneComparator(false)).c(0.0F).a(f).setName("comparator").J());
		registerBlock(150, "powered_comparator", (new BlockRedstoneComparator(true)).c(0.0F).a(0.625F).a(f).setName("comparator").J());
		registerBlock(151, "daylight_detector", new BlockDaylightDetector(false));
		registerBlock(152, "redstone_block", (new BlockRedstone(MaterialMapColor.f)).c(5.0F).b(10.0F).a(j).setName("blockRedstone"));
		registerBlock(153, "quartz_ore", (new BlockOre()).c(3.0F).b(5.0F).a(i).setName("netherquartz"));
		registerBlock(154, "hopper", (new BlockHopper()).c(3.0F).b(8.0F).a(j).setName("hopper"));
		Block blockQuartz = (new BlockQuartz()).a(i).c(0.8F).setName("quartzBlock");
		registerBlock(155, "quartz_block", blockQuartz);
		registerBlock(156, "quartz_stairs", (new BlockStairs(blockQuartz.getBlockState().a(BlockQuartz.a, azn.a))).setName("stairsQuartz"));
		registerBlock(157, "activator_rail", (new BlockPoweredRail()).c(0.7F).a(j).setName("activatorRail"));
		registerBlock(158, "dropper", (new BlockDropper()).c(3.5F).a(i).setName("dropper"));
		registerBlock(159, "stained_hardened_clay", (new BlockCloth(Material.STONE)).c(1.25F).b(7.0F).a(i).setName("clayHardenedStained"));
		registerBlock(160, "stained_glass_pane", (new BlockStainedGlassPane()).c(0.3F).a(k).setName("thinStainedGlass"));
		registerBlock(161, "leaves2", (new BlockLeaves2()).setName("leaves"));
		registerBlock(162, "log2", (new BlockLog2()).setName("log"));
		registerBlock(163, "acacia_stairs", (new BlockStairs(wood.getBlockState().a(BlockWood.a, ayx.e))).setName("stairsWoodAcacia"));
		registerBlock(164, "dark_oak_stairs", (new BlockStairs(wood.getBlockState().a(BlockWood.a, ayx.f))).setName("stairsWoodDarkOak"));
		registerBlock(165, "slime", (new BlockSlime()).setName("slime").a(q));
		registerBlock(166, "barrier", (new BlockBarrier()).setName("barrier"));
		registerBlock(167, "iron_trapdoor", (new BlockTrapdoor(Material.ORE)).c(5.0F).a(j).setName("ironTrapdoor").J());
		registerBlock(168, "prismarine", (new BlockPrismarine()).c(1.5F).b(10.0F).a(i).setName("prismarine"));
		registerBlock(169, "sea_lantern", (new bah(Material.SHATTERABLE)).c(0.3F).a(k).a(1.0F).setName("seaLantern"));
		registerBlock(170, "hay_block", (new BlockHay()).c(0.5F).a(h).setName("hayBlock").a(CreativeModeTab.BUILDING_BLOCKS));
		registerBlock(171, "carpet", (new BlockCarpet()).c(0.1F).a(l).setName("woolCarpet").e(0));
		registerBlock(172, "hardened_clay", (new BlockHardenedClay()).c(1.25F).b(7.0F).a(i).setName("clayHardened"));
		registerBlock(173, "coal_block", (new Block(Material.STONE)).c(5.0F).b(10.0F).a(i).setName("blockCoal").a(CreativeModeTab.BUILDING_BLOCKS));
		registerBlock(174, "packed_ice", (new BlockPackedIce()).c(0.5F).a(k).setName("icePacked"));
		registerBlock(175, "double_plant", new BlockTallPlant());
		registerBlock(176, "standing_banner", (new BlockStandingBanner()).c(1.0F).a(f).setName("banner").J());
		registerBlock(177, "wall_banner", (new BlockWallBanner()).c(1.0F).a(f).setName("banner").J());
		registerBlock(178, "daylight_detector_inverted", new BlockDaylightDetector(true));
		Block redSandStone = (new BlockRedSandStone()).a(i).c(0.8F).setName("redSandStone");
		registerBlock(179, "red_sandstone", redSandStone);
		registerBlock(180, "red_sandstone_stairs", (new BlockStairs(redSandStone.getBlockState().a(BlockRedSandStone.a, azr.c))).setName("stairsRedSandStone"));
		registerBlock(181, "double_stone_slab2", (new BlockDoubleStoneStep2()).c(2.0F).b(10.0F).a(i).setName("stoneSlab2"));
		registerBlock(182, "stone_slab2", (new BlockSingleStoneStep2()).c(2.0F).b(10.0F).a(i).setName("stoneSlab2"));
		registerBlock(183, "spruce_fence_gate", (new BlockFenceGate()).c(2.0F).b(5.0F).a(f).setName("spruceFenceGate"));
		registerBlock(184, "birch_fence_gate", (new BlockFenceGate()).c(2.0F).b(5.0F).a(f).setName("birchFenceGate"));
		registerBlock(185, "jungle_fence_gate", (new BlockFenceGate()).c(2.0F).b(5.0F).a(f).setName("jungleFenceGate"));
		registerBlock(186, "dark_oak_fence_gate", (new BlockFenceGate()).c(2.0F).b(5.0F).a(f).setName("darkOakFenceGate"));
		registerBlock(187, "acacia_fence_gate", (new BlockFenceGate()).c(2.0F).b(5.0F).a(f).setName("acaciaFenceGate"));
		registerBlock(188, "spruce_fence", (new BlockFence(Material.WOOD)).c(2.0F).b(5.0F).a(f).setName("spruceFence"));
		registerBlock(189, "birch_fence", (new BlockFence(Material.WOOD)).c(2.0F).b(5.0F).a(f).setName("birchFence"));
		registerBlock(190, "jungle_fence", (new BlockFence(Material.WOOD)).c(2.0F).b(5.0F).a(f).setName("jungleFence"));
		registerBlock(191, "dark_oak_fence", (new BlockFence(Material.WOOD)).c(2.0F).b(5.0F).a(f).setName("darkOakFence"));
		registerBlock(192, "acacia_fence", (new BlockFence(Material.WOOD)).c(2.0F).b(5.0F).a(f).setName("acaciaFence"));
		registerBlock(193, "spruce_door", (new BlockDoor(Material.WOOD)).c(3.0F).a(f).setName("doorSpruce").J());
		registerBlock(194, "birch_door", (new BlockDoor(Material.WOOD)).c(3.0F).a(f).setName("doorBirch").J());
		registerBlock(195, "jungle_door", (new BlockDoor(Material.WOOD)).c(3.0F).a(f).setName("doorJungle").J());
		registerBlock(196, "acacia_door", (new BlockDoor(Material.WOOD)).c(3.0F).a(f).setName("doorAcacia").J());
		registerBlock(197, "dark_oak_door", (new BlockDoor(Material.WOOD)).c(3.0F).a(f).setName("doorDarkOak").J());
		BLOCKREGISTRY.validate();


		for (Object obj : BLOCKREGISTRY) {
			Block block = (Block) obj;
			if (block.material == Material.AIR) {
				block.v = false;
			} else {
				boolean flag = false;

				boolean b1 = block instanceof BlockStairs;
				boolean b2 = block instanceof BlockStepAbstract;
				boolean b3 = block == soil;
				boolean b4 = block.t;
				boolean b5 = block.s == 0;

				if (b1 || b2 || b3 || b4 || b5) {
					flag = true;
				}

				block.v = flag;
			}
		}

		for (Object obj : BLOCKREGISTRY) {
			Block block = (Block) obj;
			for (Object becObj : block.O().a()) {
				BlockState bec = (BlockState) becObj;
				int id = BLOCKREGISTRY.getBlockId(block) << 4 | block.c(bec);
				IDREGISTRY.register(bec, id);
			}
		}

	}

	protected boolean r;
	protected int s;
	protected boolean t;
	protected int u;
	protected boolean v;
	protected float w;
	protected float x;
	protected boolean y = true;
	protected boolean z;
	protected boolean A;
	protected double B;
	protected double C;
	protected double D;
	protected double E;
	protected double F;
	protected double G;
	public BlockSound H;
	public float I;
	protected final Material material;
	public float K;
	protected final bed L;
	private BlockState blockState;
	private String name;

	public static int getBlockId(Block block) {
		return BLOCKREGISTRY.getBlockId(block);
	}

	public static int f(BlockState var0) {
		return getBlockId(var0.getBlock()) + (var0.getBlock().c(var0) << 12);
	}

	public static Block c(int var0) {
		return (Block) BLOCKREGISTRY.getById(var0);
	}

	public static BlockState d(int var0) {
		int var1 = var0 & 4095;
		int var2 = var0 >> 12 & 15;
		return c(var1).a(var2);
	}

	public static Block a(Item var0) {
		return var0 instanceof ItemBlock ? ((ItemBlock) var0).getBlock() : null;
	}

	public static Block b(String var0) {
		RegistryObjectName var1 = new RegistryObjectName(var0);
		if (BLOCKREGISTRY.d(var1)) {
			return (Block) BLOCKREGISTRY.getByName(var1);
		} else {
			try {
				return (Block) BLOCKREGISTRY.getById(Integer.parseInt(var0));
			} catch (NumberFormatException var3) {
				return null;
			}
		}
	}

	public boolean m() {
		return this.r;
	}

	public int n() {
		return this.s;
	}

	public int p() {
		return this.u;
	}

	public boolean q() {
		return this.v;
	}

	public Material getMaterial() {
		return this.material;
	}

	public MaterialMapColor g(BlockState var1) {
		return this.getMaterial().getMapColor();
	}

	public BlockState a(int var1) {
		return this.getBlockState();
	}

	public int c(BlockState var1) {
		if (var1 != null && !var1.a().isEmpty()) {
			throw new IllegalArgumentException("Don\'t know how to convert " + var1 + " back into data...");
		} else {
			return 0;
		}
	}

	public BlockState a(BlockState var1, ard var2, Position var3) {
		return var1;
	}

	protected Block(Material var1) {
		this.H = e;
		this.I = 1.0F;
		this.K = 0.6F;
		this.material = var1;
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		this.r = this.c();
		this.s = this.c() ? 255 : 0;
		this.t = !var1.blocksLight();
		this.L = this.e();
		this.setBlockState(this.L.b());
	}

	protected Block a(BlockSound var1) {
		this.H = var1;
		return this;
	}

	protected Block e(int var1) {
		this.s = var1;
		return this;
	}

	protected Block a(float var1) {
		this.u = (int) (15.0F * var1);
		return this;
	}

	protected Block b(float var1) {
		this.x = var1 * 3.0F;
		return this;
	}

	public boolean s() {
		return this.material.isSolid() && this.d();
	}

	public boolean t() {
		return this.material.k() && this.d() && !this.g();
	}

	public boolean u() {
		return this.material.isSolid() && this.d();
	}

	public boolean d() {
		return true;
	}

	public boolean b(ard var1, Position var2) {
		return !this.material.isSolid();
	}

	public int b() {
		return 3;
	}

	public boolean f(World var1, Position var2) {
		return false;
	}

	protected Block c(float var1) {
		this.w = var1;
		if (this.x < var1 * 5.0F) {
			this.x = var1 * 5.0F;
		}

		return this;
	}

	protected Block v() {
		this.c(-1.0F);
		return this;
	}

	public float g(World var1, Position var2) {
		return this.w;
	}

	protected Block a(boolean var1) {
		this.z = var1;
		return this;
	}

	public boolean w() {
		return this.z;
	}

	public boolean x() {
		return this.A;
	}

	protected final void a(float var1, float var2, float var3, float var4, float var5, float var6) {
		this.B = (double) var1;
		this.C = (double) var2;
		this.D = (double) var3;
		this.E = (double) var4;
		this.F = (double) var5;
		this.G = (double) var6;
	}

	public boolean b(ard var1, Position var2, BlockFace var3) {
		return var1.getBlockState(var2).getBlock().getMaterial().isBuildable();
	}

	public void a(World var1, Position var2, BlockState var3, AxisAlignedBB var4, List<AxisAlignedBB> var5, Entity var6) {
		AxisAlignedBB var7 = this.a(var1, var2, var3);
		if (var7 != null && var4.b(var7)) {
			var5.add(var7);
		}

	}

	public AxisAlignedBB a(World var1, Position var2, BlockState var3) {
		return new AxisAlignedBB((double) var2.getX() + this.B, (double) var2.getY() + this.C, (double) var2.getZ() + this.D, (double) var2.getX() + this.E, (double) var2.getY() + this.F, (double) var2.getZ() + this.G);
	}

	public boolean c() {
		return true;
	}

	public boolean a(BlockState var1, boolean var2) {
		return this.y();
	}

	public boolean y() {
		return true;
	}

	public void a(World var1, Position var2, BlockState var3, Random var4) {
		this.b(var1, var2, var3, var4);
	}

	public void b(World var1, Position var2, BlockState var3, Random var4) {
	}

	public void d(World var1, Position var2, BlockState var3) {
	}

	public void a(World var1, Position var2, BlockState var3, Block var4) {
	}

	public int a(World var1) {
		return 10;
	}

	public void c(World var1, Position var2, BlockState var3) {
	}

	public void b(World var1, Position var2, BlockState var3) {
	}

	public int a(Random var1) {
		return 1;
	}

	public Item a(BlockState var1, Random var2, int var3) {
		return Item.getItemOf(this);
	}

	public float a(EntityHuman var1, World var2, Position var3) {
		float var4 = this.g(var2, var3);
		return var4 < 0.0F ? 0.0F : (!var1.b(this) ? var1.a(this) / var4 / 100.0F : var1.a(this) / var4 / 30.0F);
	}

	public final void b(World var1, Position var2, BlockState var3, int var4) {
		this.a(var1, var2, var3, 1.0F, var4);
	}

	public void a(World var1, Position var2, BlockState var3, float var4, int var5) {
		if (!var1.D) {
			int var6 = this.a(var5, var1.s);

			for (int var7 = 0; var7 < var6; ++var7) {
				if (var1.s.nextFloat() <= var4) {
					Item var8 = this.a(var3, var1.s, var5);
					if (var8 != null) {
						a(var1, var2, new ItemStack(var8, 1, this.a(var3)));
					}
				}
			}

		}
	}

	public static void a(World var0, Position var1, ItemStack var2) {
		if (!var0.D && var0.Q().b("doTileDrops")) {
			float var3 = 0.5F;
			double var4 = (double) (var0.s.nextFloat() * var3) + (double) (1.0F - var3) * 0.5D;
			double var6 = (double) (var0.s.nextFloat() * var3) + (double) (1.0F - var3) * 0.5D;
			double var8 = (double) (var0.s.nextFloat() * var3) + (double) (1.0F - var3) * 0.5D;
			EntityItem var10 = new EntityItem(var0, (double) var1.getX() + var4, (double) var1.getY() + var6, (double) var1.getZ() + var8, var2);
			var10.p();
			var0.d((Entity) var10);
		}
	}

	protected void b(World var1, Position var2, int var3) {
		if (!var1.D) {
			while (var3 > 0) {
				int var4 = EntityExpirienceOrb.a(var3);
				var3 -= var4;
				var1.d((Entity) (new EntityExpirienceOrb(var1, (double) var2.getX() + 0.5D, (double) var2.getY() + 0.5D, (double) var2.getZ() + 0.5D, var4)));
			}
		}

	}

	public int a(BlockState var1) {
		return 0;
	}

	public float a(Entity var1) {
		return this.x / 5.0F;
	}

	public MovingObjectPosition a(World var1, Position var2, Vec3D var3, Vec3D var4) {
		this.a((ard) var1, var2);
		var3 = var3.b((double) (-var2.getX()), (double) (-var2.getY()), (double) (-var2.getZ()));
		var4 = var4.b((double) (-var2.getX()), (double) (-var2.getY()), (double) (-var2.getZ()));
		Vec3D var5 = var3.a(var4, this.B);
		Vec3D var6 = var3.a(var4, this.E);
		Vec3D var7 = var3.b(var4, this.C);
		Vec3D var8 = var3.b(var4, this.F);
		Vec3D var9 = var3.c(var4, this.D);
		Vec3D var10 = var3.c(var4, this.G);
		if (!this.a(var5)) {
			var5 = null;
		}

		if (!this.a(var6)) {
			var6 = null;
		}

		if (!this.b(var7)) {
			var7 = null;
		}

		if (!this.b(var8)) {
			var8 = null;
		}

		if (!this.c(var9)) {
			var9 = null;
		}

		if (!this.c(var10)) {
			var10 = null;
		}

		Vec3D var11 = null;
		if (var5 != null && (var11 == null || var3.g(var5) < var3.g(var11))) {
			var11 = var5;
		}

		if (var6 != null && (var11 == null || var3.g(var6) < var3.g(var11))) {
			var11 = var6;
		}

		if (var7 != null && (var11 == null || var3.g(var7) < var3.g(var11))) {
			var11 = var7;
		}

		if (var8 != null && (var11 == null || var3.g(var8) < var3.g(var11))) {
			var11 = var8;
		}

		if (var9 != null && (var11 == null || var3.g(var9) < var3.g(var11))) {
			var11 = var9;
		}

		if (var10 != null && (var11 == null || var3.g(var10) < var3.g(var11))) {
			var11 = var10;
		}

		if (var11 == null) {
			return null;
		} else {
			BlockFace var12 = null;
			if (var11 == var5) {
				var12 = BlockFace.WEST;
			}

			if (var11 == var6) {
				var12 = BlockFace.EAST;
			}

			if (var11 == var7) {
				var12 = BlockFace.DOWN;
			}

			if (var11 == var8) {
				var12 = BlockFace.UP;
			}

			if (var11 == var9) {
				var12 = BlockFace.NORTH;
			}

			if (var11 == var10) {
				var12 = BlockFace.SOUTH;
			}

			return new MovingObjectPosition(var11.b((double) var2.getX(), (double) var2.getY(), (double) var2.getZ()), var12, var2);
		}
	}

	private boolean a(Vec3D var1) {
		return var1 == null ? false : var1.y >= this.C && var1.y <= this.F && var1.z >= this.D && var1.z <= this.G;
	}

	private boolean b(Vec3D var1) {
		return var1 == null ? false : var1.x >= this.B && var1.x <= this.E && var1.z >= this.D && var1.z <= this.G;
	}

	private boolean c(Vec3D var1) {
		return var1 == null ? false : var1.x >= this.B && var1.x <= this.E && var1.y >= this.C && var1.y <= this.F;
	}

	public void a(World var1, Position var2, aqo var3) {
	}

	public boolean a(World var1, Position var2, BlockFace var3, ItemStack var4) {
		return this.a(var1, var2, var3);
	}

	public boolean a(World var1, Position var2, BlockFace var3) {
		return this.c(var1, var2);
	}

	public boolean c(World var1, Position var2) {
		return var1.getBlockState(var2).getBlock().material.j();
	}

	public boolean a(World var1, Position var2, BlockState var3, EntityHuman var4, BlockFace var5, float var6, float var7, float var8) {
		return false;
	}

	public void a(World var1, Position var2, Entity var3) {
	}

	public BlockState a(World var1, Position var2, BlockFace var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		return this.a(var7);
	}

	public void a(World var1, Position var2, EntityHuman var3) {
	}

	public Vec3D a(World var1, Position var2, Entity var3, Vec3D var4) {
		return var4;
	}

	public void a(ard var1, Position var2) {
	}

	public final double z() {
		return this.B;
	}

	public final double A() {
		return this.E;
	}

	public final double B() {
		return this.C;
	}

	public final double C() {
		return this.F;
	}

	public final double D() {
		return this.D;
	}

	public final double E() {
		return this.G;
	}

	public int a(ard var1, Position var2, BlockState var3, BlockFace var4) {
		return 0;
	}

	public boolean g() {
		return false;
	}

	public void a(World var1, Position var2, BlockState var3, Entity var4) {
	}

	public int b(ard var1, Position var2, BlockState var3, BlockFace var4) {
		return 0;
	}

	public void h() {
	}

	public void a(World var1, EntityHuman var2, Position var3, BlockState var4, TileEntity var5) {
		var2.b(StatisticList.MINE_BLOCK_COUNT[getBlockId(this)]);
		var2.a(0.025F);
		if (this.G() && aph.e(var2)) {
			ItemStack var7 = this.i(var4);
			if (var7 != null) {
				a(var1, var3, var7);
			}
		} else {
			int var6 = aph.f(var2);
			this.b(var1, var3, var4, var6);
		}

	}

	protected boolean G() {
		return this.d() && !this.A;
	}

	protected ItemStack i(BlockState var1) {
		int var2 = 0;
		Item var3 = Item.getItemOf(this);
		if (var3 != null && var3.k()) {
			var2 = this.c(var1);
		}

		return new ItemStack(var3, 1, var2);
	}

	public int a(int var1, Random var2) {
		return this.a(var2);
	}

	public void a(World var1, Position var2, BlockState var3, EntityLiving var4, ItemStack var5) {
	}

	public Block setName(String name) {
		this.name = name;
		return this;
	}

	public String getLocalizedName() {
		return LocaleI18n.get(this.getName() + ".name");
	}

	public String getName() {
		return "tile." + this.name;
	}

	public boolean a(World var1, Position var2, BlockState var3, int var4, int var5) {
		return false;
	}

	public boolean I() {
		return this.y;
	}

	protected Block J() {
		this.y = false;
		return this;
	}

	public int i() {
		return this.material.m();
	}

	public void a(World var1, Position var2, Entity var3, float var4) {
		var3.e(var4, 1.0F);
	}

	public void a(World var1, Entity var2) {
		var2.motionY = 0.0D;
	}

	public int j(World var1, Position var2) {
		return this.a(var1.getBlockState(var2));
	}

	public Block a(CreativeModeTab var1) {
		return this;
	}

	public void a(World var1, Position var2, BlockState var3, EntityHuman var4) {
	}

	public void k(World var1, Position var2) {
	}

	public boolean M() {
		return true;
	}

	public boolean a(aqo var1) {
		return true;
	}

	public boolean b(Block var1) {
		return this == var1;
	}

	public static boolean a(Block var0, Block var1) {
		return var0 != null && var1 != null ? (var0 == var1 ? true : var0.b(var1)) : false;
	}

	public boolean N() {
		return false;
	}

	public int l(World var1, Position var2) {
		return 0;
	}

	protected bed e() {
		return new bed(this, new bex[0]);
	}

	public bed O() {
		return this.L;
	}

	protected final void setBlockState(BlockState blockState) {
		this.blockState = blockState;
	}

	public final BlockState getBlockState() {
		return this.blockState;
	}


	private static void registerBlock(int id, RegistryObjectName registeredBlock, Block block) {
		BLOCKREGISTRY.register(id, registeredBlock, block);
	}

	private static void registerBlock(int id, String blockName, Block var2) {
		registerBlock(id, new RegistryObjectName(blockName), var2);
	}

}
