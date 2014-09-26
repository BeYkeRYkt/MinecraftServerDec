package pipebukkit.server.block;

import net.minecraft.TileEntityHopper;

import org.bukkit.block.Hopper;
import org.bukkit.inventory.Inventory;

import pipebukkit.server.inventory.PipeHopperInventory;

public class PipeHopper extends PipeBlockState implements Hopper {

	private TileEntityHopper hopper;

	public PipeHopper(PipeBlock block) {
		super(block);
		hopper = (TileEntityHopper) getTileEntity();
	}

	@Override
	public Inventory getInventory() {
		return new PipeHopperInventory(hopper);
	}

	@Override
	public boolean update(boolean force, boolean applyPhysics) {
		if (super.update(force, applyPhysics)) {
			hopper.update();
			return true;
		}
		return false;
	}

}
