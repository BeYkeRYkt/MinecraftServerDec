package pipebukkit.server.inventory;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.HorseInventory;
import org.bukkit.inventory.ItemStack;

import net.minecraft.IInventory;

public class PipeHorseInventory extends PipeInventory implements HorseInventory {

	public PipeHorseInventory(IInventory nmsInventory) {
		super(nmsInventory);
	}

	@Override
	public InventoryType getType() {
		//TODO: return horse type
		return null;
	}

	@Override
	public ItemStack getArmor() {
		return getItem(1);
	}

	@Override
	public ItemStack getSaddle() {
		return getItem(0);
	}

	@Override
	public void setArmor(ItemStack armor) {
		setItem(1, armor);
	}

	@Override
	public void setSaddle(ItemStack saddle) {
		setItem(0, saddle);
	}

}
