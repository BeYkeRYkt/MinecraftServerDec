package net.minecraft;

import com.google.common.collect.Maps;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class RecipesFurnace {

	private static final RecipesFurnace instance = new RecipesFurnace();
	private Map<ItemStack, ItemStack> recipes = Maps.newHashMap();
	private Map<ItemStack, Float> expdrop = Maps.newHashMap();

	public static RecipesFurnace getInstance() {
		return instance;
	}

	private RecipesFurnace() {
		this.registerRecipe(Blocks.IRON_ORE, new ItemStack(Items.IRON_INGOT), 0.7F);
		this.registerRecipe(Blocks.GOLD_ORE, new ItemStack(Items.GOLD_INGOT), 1.0F);
		this.registerRecipe(Blocks.DIAMOND_ORE, new ItemStack(Items.DIAMOND), 1.0F);
		this.registerRecipe((Block) Blocks.SAND, new ItemStack(Blocks.GLASS), 0.1F);
		this.registerRecipe(Items.PORKCHOP, new ItemStack(Items.COOCKED_PORKCHOP), 0.35F);
		this.registerRecipe(Items.BEEF, new ItemStack(Items.COOKED_BEEF), 0.35F);
		this.registerRecipe(Items.CHICKEN, new ItemStack(Items.COOKED_CHICKEN), 0.35F);
		this.registerRecipe(Items.RABBIT, new ItemStack(Items.COOCKED_RABBIT), 0.35F);
		this.registerRecipe(Items.MUTTON, new ItemStack(Items.COOKED_MUTTON), 0.35F);
		this.registerRecipe(Blocks.COBBLESTONE, new ItemStack(Blocks.STONE), 0.1F);
		this.registerRecipe(new ItemStack(Blocks.STONEBRICK, 1, BlockSmoothBrick.b), new ItemStack(Blocks.STONEBRICK, 1, BlockSmoothBrick.N), 0.1F);
		this.registerRecipe(Items.CLAY_BALL, new ItemStack(Items.BRICK), 0.3F);
		this.registerRecipe(Blocks.CLAY, new ItemStack(Blocks.HARDENED_CLAY), 0.35F);
		this.registerRecipe(Blocks.CACTUS, new ItemStack(Items.DYE, 1, akv.n.b()), 0.2F);
		this.registerRecipe(Blocks.LOG, new ItemStack(Items.COAL, 1, 1), 0.15F);
		this.registerRecipe(Blocks.LOG2, new ItemStack(Items.COAL, 1, 1), 0.15F);
		this.registerRecipe(Blocks.EMERALD_ORE, new ItemStack(Items.EMERALD), 1.0F);
		this.registerRecipe(Items.POTATO, new ItemStack(Items.BAKED_POTATO), 0.35F);
		this.registerRecipe(Blocks.NETHERRACK, new ItemStack(Items.NETHERBRICK), 0.1F);
		this.registerRecipe(new ItemStack(Blocks.SPONGE, 1, 1), new ItemStack(Blocks.SPONGE, 1, 0), 0.15F);

		for (EnumFishType type : EnumFishType.values()) {
			if (type.isCookable()) {
				this.registerRecipe(new ItemStack(Items.FISH, 1, type.getData()), new ItemStack(Items.COOKED_FISH, 1, type.getData()), 0.35F);
			}
		}

		this.registerRecipe(Blocks.COAL_ORE, new ItemStack(Items.COAL), 0.1F);
		this.registerRecipe(Blocks.REDSTONE_ORE, new ItemStack(Items.REDSTONE), 0.7F);
		this.registerRecipe(Blocks.LAPIS_ORE, new ItemStack(Items.DYE, 1, akv.l.b()), 0.2F);
		this.registerRecipe(Blocks.QUARTZ_ORE, new ItemStack(Items.QUARTZ), 0.2F);
	}

	public void registerRecipe(Block block, ItemStack result, float expdrop) {
		this.registerRecipe(Item.getItemOf(block), result, expdrop);
	}

	public void registerRecipe(Item item, ItemStack result, float expdrop) {
		this.registerRecipe(new ItemStack(item, 1, 32767), result, expdrop);
	}

	public void registerRecipe(ItemStack itemStack, ItemStack result, float expdrop) {
		this.recipes.put(itemStack, result);
		this.expdrop.put(result, expdrop);
	}

	public Map<ItemStack, ItemStack> getRecipes() {
		return this.recipes;
	}

	private boolean matches(ItemStack inputItem, ItemStack knowItem) {
		return knowItem.getItem() == inputItem.getItem() && (knowItem.getWearout() == 32767 || knowItem.getWearout() == inputItem.getWearout());
	}

	public ItemStack getSmeltResult(ItemStack inputItem) {
		Iterator<Entry<ItemStack, ItemStack>> iterator = this.recipes.entrySet().iterator();

		Entry<ItemStack, ItemStack> entry;
		do {
			if (!iterator.hasNext()) {
				return null;
			}

			entry = iterator.next();
		} while (!this.matches(inputItem, entry.getKey()));

		return entry.getValue();
	}

	public float getExpDrop(ItemStack inputItem) {
		Iterator<Entry<ItemStack, Float>> iterator = this.expdrop.entrySet().iterator();

		Entry<ItemStack, Float> entry;
		do {
			if (!iterator.hasNext()) {
				return 0.0F;
			}

			entry = iterator.next();
		} while (!this.matches(inputItem, entry.getKey()));

		return entry.getValue();
	}

	public void clearRecipes() {
		recipes.clear();
		expdrop.clear();
	}

	public void resetRecipes() {
		RecipesFurnace reset = new RecipesFurnace();
		recipes = reset.recipes;
		expdrop = reset.expdrop;
	}

}
