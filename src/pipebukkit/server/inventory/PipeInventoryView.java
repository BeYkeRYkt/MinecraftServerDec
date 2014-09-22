package pipebukkit.server.inventory;

import org.bukkit.GameMode;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public class PipeInventoryView extends InventoryView {

	private HumanEntity player;
	private PipeInventory top;

	public PipeInventoryView(HumanEntity player, PipeInventory top) {
		this.player = player;
		this.top = top;
	}

	@Override
	public HumanEntity getPlayer() {
		return player;
	}

	@Override
	public Inventory getBottomInventory() {
		return player.getInventory();
	}

	@Override
	public Inventory getTopInventory() {
		return top;
	}

	@Override
	public InventoryType getType() {
		if (top.getType() == InventoryType.CRAFTING && player.getGameMode() == GameMode.CREATIVE) {
			return InventoryType.CREATIVE;
		}
		return top.getType();
	}

	@Override
	public int hashCode() {
		return player.hashCode() ^ top.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof PipeInventoryView)) {
			return false;
		}
		PipeInventoryView otherView = (PipeInventoryView) obj;
		return player.equals(otherView.player) && top.equals(otherView.top);
	}

}
