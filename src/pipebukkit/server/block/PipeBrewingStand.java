package pipebukkit.server.block;

import org.bukkit.block.BrewingStand;
import org.bukkit.inventory.BrewerInventory;

import pipebukkit.server.inventory.PipeBrewingStandInventory;
import net.minecraft.TileEntityBrewingStand;

public class PipeBrewingStand extends PipeBlockState implements BrewingStand {

	private TileEntityBrewingStand brewingStand;

	public PipeBrewingStand(PipeBlock block) {
		super(block);
		brewingStand = (TileEntityBrewingStand) getTileEntity();
	}

	@Override
	public int getBrewingTime() {
		return brewingStand.getBrewTime();
	}

	@Override
	public void setBrewingTime(int time) {
		brewingStand.setBrewTime(time);
	}

	@Override
	public BrewerInventory getInventory() {
		return new PipeBrewingStandInventory(brewingStand);
	}

	@Override
	public boolean update(boolean force, boolean applyPhysics) {
		if (super.update(force, applyPhysics)) {
			brewingStand.update();
			return true;
		}
		return false;
	}

}
