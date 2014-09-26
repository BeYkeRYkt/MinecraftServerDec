package pipebukkit.server.inventory;

import org.bukkit.block.DoubleChest;
import org.bukkit.inventory.DoubleChestInventory;
import org.bukkit.inventory.Inventory;

import net.minecraft.IInventory;
import net.minecraft.InventoryLargeChest;
import net.minecraft.TileEntityChest;

public class PipeDoubleChestInventory extends PipeChestInventory implements DoubleChestInventory {

	private IInventory left;
	private IInventory right;

	public PipeDoubleChestInventory(TileEntityChest left, TileEntityChest right) {
		super(new InventoryLargeChest("Large chest", left, right));
		this.left  = left;
		this.right = right;
	}

	private PipeInventory cachedLeftSide;
	@Override
	public Inventory getLeftSide() {
		if (cachedLeftSide == null) {
			cachedLeftSide = new PipeChestInventory(left);
		}
		return cachedLeftSide;
	}

	private PipeInventory cachedRightSide;
	@Override
	public Inventory getRightSide() {
		if (cachedRightSide == null) {
			cachedRightSide = new PipeChestInventory(right);
		}
		return cachedRightSide;
	}

	@Override
	public DoubleChest getHolder() {
		return new DoubleChest(this);
	}

}
