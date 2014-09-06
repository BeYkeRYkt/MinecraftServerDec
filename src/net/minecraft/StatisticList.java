package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StatisticList {

	protected static Map a = Maps.newHashMap();
	public static List b = Lists.newArrayList();
	public static List c = Lists.newArrayList();
	public static List d = Lists.newArrayList();
	public static List e = Lists.newArrayList();
	public static Statistic f = (new tn("stat.leaveGame", new hz("stat.leaveGame", new Object[0]))).i().h();
	public static Statistic g = (new tn("stat.playOneMinute", new hz("stat.playOneMinute", new Object[0]), Statistic.h)).i().h();
	public static Statistic h = (new tn("stat.timeSinceDeath", new hz("stat.timeSinceDeath", new Object[0]), Statistic.h)).i().h();
	public static Statistic i = (new tn("stat.walkOneCm", new hz("stat.walkOneCm", new Object[0]), Statistic.i)).i().h();
	public static Statistic j = (new tn("stat.crouchOneCm", new hz("stat.crouchOneCm", new Object[0]), Statistic.i)).i().h();
	public static Statistic k = (new tn("stat.sprintOneCm", new hz("stat.sprintOneCm", new Object[0]), Statistic.i)).i().h();
	public static Statistic l = (new tn("stat.swimOneCm", new hz("stat.swimOneCm", new Object[0]), Statistic.i)).i().h();
	public static Statistic m = (new tn("stat.fallOneCm", new hz("stat.fallOneCm", new Object[0]), Statistic.i)).i().h();
	public static Statistic n = (new tn("stat.climbOneCm", new hz("stat.climbOneCm", new Object[0]), Statistic.i)).i().h();
	public static Statistic o = (new tn("stat.flyOneCm", new hz("stat.flyOneCm", new Object[0]), Statistic.i)).i().h();
	public static Statistic p = (new tn("stat.diveOneCm", new hz("stat.diveOneCm", new Object[0]), Statistic.i)).i().h();
	public static Statistic q = (new tn("stat.minecartOneCm", new hz("stat.minecartOneCm", new Object[0]), Statistic.i)).i().h();
	public static Statistic r = (new tn("stat.boatOneCm", new hz("stat.boatOneCm", new Object[0]), Statistic.i)).i().h();
	public static Statistic s = (new tn("stat.pigOneCm", new hz("stat.pigOneCm", new Object[0]), Statistic.i)).i().h();
	public static Statistic t = (new tn("stat.horseOneCm", new hz("stat.horseOneCm", new Object[0]), Statistic.i)).i().h();
	public static Statistic u = (new tn("stat.jump", new hz("stat.jump", new Object[0]))).i().h();
	public static Statistic v = (new tn("stat.drop", new hz("stat.drop", new Object[0]))).i().h();
	public static Statistic w = (new tn("stat.damageDealt", new hz("stat.damageDealt", new Object[0]), Statistic.j)).h();
	public static Statistic x = (new tn("stat.damageTaken", new hz("stat.damageTaken", new Object[0]), Statistic.j)).h();
	public static Statistic y = (new tn("stat.deaths", new hz("stat.deaths", new Object[0]))).h();
	public static Statistic z = (new tn("stat.mobKills", new hz("stat.mobKills", new Object[0]))).h();
	public static Statistic A = (new tn("stat.animalsBred", new hz("stat.animalsBred", new Object[0]))).h();
	public static Statistic B = (new tn("stat.playerKills", new hz("stat.playerKills", new Object[0]))).h();
	public static Statistic C = (new tn("stat.fishCaught", new hz("stat.fishCaught", new Object[0]))).h();
	public static Statistic D = (new tn("stat.junkFished", new hz("stat.junkFished", new Object[0]))).h();
	public static Statistic E = (new tn("stat.treasureFished", new hz("stat.treasureFished", new Object[0]))).h();
	public static Statistic F = (new tn("stat.talkedToVillager", new hz("stat.talkedToVillager", new Object[0]))).h();
	public static Statistic G = (new tn("stat.tradedWithVillager", new hz("stat.tradedWithVillager", new Object[0]))).h();
	public static final Statistic[] H = new Statistic[4096];
	public static final Statistic[] I = new Statistic[32000];
	public static final Statistic[] J = new Statistic[32000];
	public static final Statistic[] K = new Statistic[32000];

	public static void register() {
		c();
		d();
		e();
		b();
		tl.a();
		EntityTypes.someEmptyMethodIDKWhyItsThere();
	}

	private static void b() {
		HashSet var0 = Sets.newHashSet();
		Iterator var1 = aop.a().b().iterator();

		while (var1.hasNext()) {
			aoo var2 = (aoo) var1.next();
			if (var2.b() != null) {
				var0.add(var2.b().getItem());
			}
		}

		var1 = aok.a().b().values().iterator();

		while (var1.hasNext()) {
			ItemStack var5 = (ItemStack) var1.next();
			var0.add(var5.getItem());
		}

		var1 = var0.iterator();

		while (var1.hasNext()) {
			Item var6 = (Item) var1.next();
			if (var6 != null) {
				int var3 = Item.getId(var6);
				String var4 = a(var6);
				if (var4 != null) {
					I[var3] = (new to("stat.craftItem.", var4, new hz("stat.craftItem", new Object[] { (new ItemStack(var6)).C() }), var6)).h();
				}
			}
		}

		a(I);
	}

	private static void c() {
		Iterator var0 = Block.BLOCKREGISTRY.iterator();

		while (var0.hasNext()) {
			Block var1 = (Block) var0.next();
			Item var2 = Item.getItemOf(var1);
			if (var2 != null) {
				int var3 = Block.getBlockId(var1);
				String var4 = a(var2);
				if (var4 != null && var1.I()) {
					H[var3] = (new to("stat.mineBlock.", var4, new hz("stat.mineBlock", new Object[] { (new ItemStack(var1)).C() }), var2)).h();
					e.add((to) H[var3]);
				}
			}
		}

		a(H);
	}

	private static void d() {
		Iterator var0 = Item.REGISTRY.iterator();

		while (var0.hasNext()) {
			Item var1 = (Item) var0.next();
			if (var1 != null) {
				int var2 = Item.getId(var1);
				String var3 = a(var1);
				if (var3 != null) {
					J[var2] = (new to("stat.useItem.", var3, new hz("stat.useItem", new Object[] { (new ItemStack(var1)).C() }), var1)).h();
					if (!(var1 instanceof ItemBlock)) {
						d.add((to) J[var2]);
					}
				}
			}
		}

		a(J);
	}

	private static void e() {
		Iterator var0 = Item.REGISTRY.iterator();

		while (var0.hasNext()) {
			Item var1 = (Item) var0.next();
			if (var1 != null) {
				int var2 = Item.getId(var1);
				String var3 = a(var1);
				if (var3 != null && var1.usesDurability()) {
					K[var2] = (new to("stat.breakItem.", var3, new hz("stat.breakItem", new Object[] { (new ItemStack(var1)).C() }), var1)).h();
				}
			}
		}

		a(K);
	}

	private static String a(Item var0) {
		RegistryObjectName var1 = (RegistryObjectName) Item.REGISTRY.c(var0);
		return var1 != null ? var1.toString().replace(':', '.') : null;
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
		String var1 = EntityTypes.getNameById(info.fixedId);
		return var1 == null ? null : (new Statistic("stat.killEntity." + var1, new hz("stat.entityKill", new Object[] { new hz("entity." + var1 + ".name", new Object[0]) }))).h();
	}

	public static Statistic loadKilledByEntityCount(MonsterEggInfo info) {
		String name = EntityTypes.getNameById(info.fixedId);
		return name == null ? null : (new Statistic("stat.entityKilledBy." + name, new hz("stat.entityKilledBy", new Object[] { new hz("entity." + name + ".name", new Object[0]) }))).h();
	}

	public static Statistic a(String var0) {
		return (Statistic) a.get(var0);
	}

}
