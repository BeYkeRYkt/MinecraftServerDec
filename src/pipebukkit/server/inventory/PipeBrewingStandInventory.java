package pipebukkit.server.inventory;

import org.bukkit.block.BrewingStand;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.BrewerInventory;
import org.bukkit.inventory.ItemStack;

import net.minecraft.IInventory;

public class PipeBrewingStandInventory extends PipeInventory implements BrewerInventory {

	public PipeBrewingStandInventory(IInventory nmsInventory) {
		super(nmsInventory);
	}

	@Override
	public InventoryType getType() {
		return InventoryType.BREWING;
	}

	@Override
	public BrewingStand getHolder() {
		return (BrewingStand) nmsInventory.getHolder();
	}

	@Override
	public ItemStack getIngredient() {
		return getItem(3);
	}

	@Override
	public void setIngredient(ItemStack ingridient) {
		setItem(3, ingridient);
	}

}
