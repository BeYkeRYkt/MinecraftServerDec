package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class StatisticList {

	protected static Map<String, Statistic> list = Maps.newHashMap();
	public static List<Statistic> b = Lists.newArrayList();
	public static List<Statistic> c = Lists.newArrayList();
	public static List<CraftingStatistic> d = Lists.newArrayList();
	public static List<CraftingStatistic> e = Lists.newArrayList();
	public static Statistic f = (new CounterStatistic("stat.leaveGame", new ChatMessage("stat.leaveGame", new Object[0]))).setLocal().h();
	public static Statistic g = (new CounterStatistic("stat.playOneMinute", new ChatMessage("stat.playOneMinute", new Object[0]), Statistic.timeCounter)).setLocal().h();
	public static Statistic h = (new CounterStatistic("stat.timeSinceDeath", new ChatMessage("stat.timeSinceDeath", new Object[0]), Statistic.timeCounter)).setLocal().h();
	public static Statistic i = (new CounterStatistic("stat.walkOneCm", new ChatMessage("stat.walkOneCm", new Object[0]), Statistic.distancesCounter)).setLocal().h();
	public static Statistic j = (new CounterStatistic("stat.crouchOneCm", new ChatMessage("stat.crouchOneCm", new Object[0]), Statistic.distancesCounter)).setLocal().h();
	public static Statistic k = (new CounterStatistic("stat.sprintOneCm", new ChatMessage("stat.sprintOneCm", new Object[0]), Statistic.distancesCounter)).setLocal().h();
	public static Statistic l = (new CounterStatistic("stat.swimOneCm", new ChatMessage("stat.swimOneCm", new Object[0]), Statistic.distancesCounter)).setLocal().h();
	public static Statistic m = (new CounterStatistic("stat.fallOneCm", new ChatMessage("stat.fallOneCm", new Object[0]), Statistic.distancesCounter)).setLocal().h();
	public static Statistic n = (new CounterStatistic("stat.climbOneCm", new ChatMessage("stat.climbOneCm", new Object[0]), Statistic.distancesCounter)).setLocal().h();
	public static Statistic o = (new CounterStatistic("stat.flyOneCm", new ChatMessage("stat.flyOneCm", new Object[0]), Statistic.distancesCounter)).setLocal().h();
	public static Statistic p = (new CounterStatistic("stat.diveOneCm", new ChatMessage("stat.diveOneCm", new Object[0]), Statistic.distancesCounter)).setLocal().h();
	public static Statistic q = (new CounterStatistic("stat.minecartOneCm", new ChatMessage("stat.minecartOneCm", new Object[0]), Statistic.distancesCounter)).setLocal().h();
	public static Statistic r = (new CounterStatistic("stat.boatOneCm", new ChatMessage("stat.boatOneCm", new Object[0]), Statistic.distancesCounter)).setLocal().h();
	public static Statistic s = (new CounterStatistic("stat.pigOneCm", new ChatMessage("stat.pigOneCm", new Object[0]), Statistic.distancesCounter)).setLocal().h();
	public static Statistic t = (new CounterStatistic("stat.horseOneCm", new ChatMessage("stat.horseOneCm", new Object[0]), Statistic.distancesCounter)).setLocal().h();
	public static Statistic u = (new CounterStatistic("stat.jump", new ChatMessage("stat.jump", new Object[0]))).setLocal().h();
	public static Statistic v = (new CounterStatistic("stat.drop", new ChatMessage("stat.drop", new Object[0]))).setLocal().h();
	public static Statistic w = (new CounterStatistic("stat.damageDealt", new ChatMessage("stat.damageDealt", new Object[0]), Statistic.damageCounter)).h();
	public static Statistic x = (new CounterStatistic("stat.damageTaken", new ChatMessage("stat.damageTaken", new Object[0]), Statistic.damageCounter)).h();
	public static Statistic y = (new CounterStatistic("stat.deaths", new ChatMessage("stat.deaths", new Object[0]))).h();
	public static Statistic z = (new CounterStatistic("stat.mobKills", new ChatMessage("stat.mobKills", new Object[0]))).h();
	public static Statistic A = (new CounterStatistic("stat.animalsBred", new ChatMessage("stat.animalsBred", new Object[0]))).h();
	public static Statistic B = (new CounterStatistic("stat.playerKills", new ChatMessage("stat.playerKills", new Object[0]))).h();
	public static Statistic C = (new CounterStatistic("stat.fishCaught", new ChatMessage("stat.fishCaught", new Object[0]))).h();
	public static Statistic D = (new CounterStatistic("stat.junkFished", new ChatMessage("stat.junkFished", new Object[0]))).h();
	public static Statistic E = (new CounterStatistic("stat.treasureFished", new ChatMessage("stat.treasureFished", new Object[0]))).h();
	public static Statistic F = (new CounterStatistic("stat.talkedToVillager", new ChatMessage("stat.talkedToVillager", new Object[0]))).h();
	public static Statistic G = (new CounterStatistic("stat.tradedWithVillager", new ChatMessage("stat.tradedWithVillager", new Object[0]))).h();
	public static final Statistic[] MINE_BLOCK_COUNT = new Statistic[4096];
	public static final Statistic[] CRAFT_BLOCK_COUNT = new Statistic[32000];
	public static final Statistic[] USE_ITEM_COUNT = new Statistic[32000];
	public static final Statistic[] BREAK_ITEM_COUNT = new Statistic[32000];

	public static void register() {
		c();
		d();
		e();
		b();
		EntityTypes.someEmptyMethodIDKWhyItsThere();
	}

	private static void b() {
		HashSet<Item> hashset = Sets.newHashSet();

		for (IRecipe irecipe : CraftingManager.getInstance().getRecipes()) {
			if (irecipe.getResult() != null) {
				hashset.add(irecipe.getResult().getItem());
			}
		}

		for (ItemStack furnaceResultItem : RecipesFurnace.getInstance().getRecipes().values()) {
			hashset.add(furnaceResultItem.getItem());
		}

		for (Item item : hashset) {
			if (item != null) {
				int id = Item.getId(item);
				String statname = getItemStatName(item);
				if (statname != null) {
					CRAFT_BLOCK_COUNT[id] = (new CraftingStatistic("stat.craftItem.", statname, new ChatMessage("stat.craftItem", new Object[] { (new ItemStack(item)).C() }), item)).h();
				}
			}
		}

		a(CRAFT_BLOCK_COUNT);
	}

	private static void c() {
		for (Object blockObj : Block.BLOCKREGISTRY) {
			Block block = (Block) blockObj;
			Item item = Item.getItemOf(block);
			if (item != null) {
				int blockItem = Block.getBlockId(block);
				String statName = getItemStatName(item);
				if (statName != null && block.I()) {
					MINE_BLOCK_COUNT[blockItem] = (new CraftingStatistic("stat.mineBlock.", statName, new ChatMessage("stat.mineBlock", new Object[] { (new ItemStack(block)).C() }), item)).h();
					e.add((CraftingStatistic) MINE_BLOCK_COUNT[blockItem]);
				}
			}
		}

		a(MINE_BLOCK_COUNT);
	}

	private static void d() {
		for (Object itemObj : Item.REGISTRY) {
			Item item = (Item) itemObj;
			if (item != null) {
				int itemId = Item.getId(item);
				String statName = getItemStatName(item);
				if (statName != null) {
					USE_ITEM_COUNT[itemId] = (new CraftingStatistic("stat.useItem.", statName, new ChatMessage("stat.useItem", new Object[] { (new ItemStack(item)).C() }), item)).h();
					if (!(item instanceof ItemBlock)) {
						d.add((CraftingStatistic) USE_ITEM_COUNT[itemId]);
					}
				}
			}
		}

		a(USE_ITEM_COUNT);
	}

	private static void e() {
		for (Object itemObj : Item.REGISTRY) {
			Item item = (Item) itemObj;
			if (item != null) {
				int itemId = Item.getId(item);
				String statName = getItemStatName(item);
				if (statName != null && item.usesDurability()) {
					BREAK_ITEM_COUNT[itemId] = (new CraftingStatistic("stat.breakItem.", statName, new ChatMessage("stat.breakItem", new Object[] { (new ItemStack(item)).C() }), item)).h();
				}
			}
		}

		a(BREAK_ITEM_COUNT);
	}

	private static String getItemStatName(Item item) {
		RegistryObjectName registryName = (RegistryObjectName) Item.REGISTRY.c(item);
		return registryName != null ? registryName.toString().replace(':', '.') : null;
	}

	private static void a(Statistic[] var0) {
		a(var0, Blocks.WATER, Blocks.FLOWING_WATER);
		a(var0, Blocks.LAVA, Blocks.FLOWING_LAVA);
		a(var0, Blocks.LIT_PUMPKIN, Blocks.PUMPKIN);
		a(var0, Blocks.LIT_FURNACE, Blocks.FURNACE);
		a(var0, Blocks.LIT_REDSTONE_ORE, Blocks.REDSTONE_ORE);
		a(var0, Blocks.POWERED_REPEATER, Blocks.UNPOWERED_REPEATER);
		a(var0, Blocks.POWERED_COMPARATOR, Blocks.UNPOWERED_COMPARATOR);
		a(var0, Blocks.REDSTONE_TORCH, Blocks.UNLIT_REDSTONE_TORCH);
		a(var0, Blocks.LIT_REDSTONE_LAMP, Blocks.REDSTONE_LAMP);
		a(var0, Blocks.DOUBLE_STONE_SLAB, Blocks.STONE_SLAB);
		a(var0, Blocks.DOUBLE_WOODEN_SLAB, Blocks.WOODEN_SLAB);
		a(var0, Blocks.DOUBLE_STONE_SLAB2, Blocks.STONE_SLAB2);
		a(var0, Blocks.GRASS, Blocks.DIRT);
		a(var0, Blocks.FARMLAND, Blocks.DIRT);
	}

	private static void a(Statistic[] var0, Block var1, Block var2) {
		int var3 = Block.getBlockId(var1);
		int var4 = Block.getBlockId(var2);
		if (var0[var3] != null && var0[var4] == null) {
			var0[var4] = var0[var3];
		} else {
			b.remove(var0[var3]);
			e.remove(var0[var3]);
			c.remove(var0[var3]);
			var0[var3] = var0[var4];
		}
	}

	public static Statistic loadKilledEntityCount(MonsterEggInfo info) {
		String entityName = EntityTypes.getNameById(info.fixedId);
		return entityName == null ? null : (new Statistic("stat.killEntity." + entityName, new ChatMessage("stat.entityKill", new Object[] { new ChatMessage("entity." + entityName + ".name", new Object[0]) }))).h();
	}

	public static Statistic loadKilledByEntityCount(MonsterEggInfo info) {
		String entityName = EntityTypes.getNameById(info.fixedId);
		return entityName == null ? null : (new Statistic("stat.entityKilledBy." + entityName, new ChatMessage("stat.entityKilledBy", new Object[] { new ChatMessage("entity." + entityName + ".name", new Object[0]) }))).h();
	}

	public static Statistic fromName(String var0) {
		return list.get(var0);
	}

}
