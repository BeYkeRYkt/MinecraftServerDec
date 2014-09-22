package pipebukkit.server.inventory;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.MerchantInventory;

import net.minecraft.IInventory;

public class PipeMerchantInventory extends PipeInventory implements MerchantInventory {

	public PipeMerchantInventory(IInventory nmsInventory) {
		super(nmsInventory);
	}

	@Override
	public InventoryType getType() {
		return InventoryType.MERCHANT;
	}

}
