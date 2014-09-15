package net.minecraft;

public enum EnchantmentSlotType {

	ALL, ARMOR, ARMOR_FEET, ARMOR_LEGS, ARMOR_TORSO, ARMOR_HEAD, WEAPON, DIGGER, FISHING_ROD, BREAKABLE, BOW;

	public boolean canEnchant(Item item) {
		if (this == ALL) {
			return true;
		} else if (this == BREAKABLE && item.usesDurability()) {
			return true;
		} else if (item instanceof ItemArmor) {
			if (this == ARMOR) {
				return true;
			} else {
				ItemArmor armor = (ItemArmor) item;
				return armor.b == 0 ? this == ARMOR_HEAD : (armor.b == 2 ? this == ARMOR_LEGS : (armor.b == 1 ? this == ARMOR_TORSO : (armor.b == 3 ? this == ARMOR_FEET : false)));
			}
		} else {
			return item instanceof ItemSword ? this == WEAPON : (item instanceof ItemTool ? this == DIGGER : (item instanceof ItemBow ? this == BOW : (item instanceof ItemFishingRod ? this == FISHING_ROD : false)));
		}
	}

}
