package pipebukkit.server.inventory;

import net.minecraft.TileEntityFurnace;

import org.bukkit.block.Furnace;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.ItemStack;

public class PipeFurnaceInventory extends PipeInventory implements FurnaceInventory {

	public PipeFurnaceInventory(TileEntityFurnace nmsInventory) {
		super(nmsInventory);
	}

	@Override
	public InventoryType getType() {
		return InventoryType.FURNACE;
	}

	@Override
	public ItemStack getFuel() {
		return getItem(1);
	}

	@Override
	public ItemStack getResult() {
		return getItem(2);
	}

	@Override
	public ItemStack getSmelting() {
		return getItem(0);
	}

	@Override
	public void setFuel(ItemStack fuel) {
		setItem(1, fuel);
	}

	@Override
	public void setResult(ItemStack result) {
		setItem(2, result);
	}

	@Override
	public void setSmelting(ItemStack smelting) {
		setItem(0, smelting);
	}

	@Override
	public Furnace getHolder() {
		return (Furnace) nmsInventory.getHolder();
	}

}
