package pipebukkit.server.block;

import net.minecraft.TileEntityFurnace;

import org.bukkit.block.Furnace;
import org.bukkit.inventory.FurnaceInventory;

import pipebukkit.server.inventory.PipeFurnaceInventory;

public class PipeFurnace extends PipeBlockState implements Furnace {

	private TileEntityFurnace furnace;

	public PipeFurnace(PipeBlock block) {
		super(block);
		furnace = (TileEntityFurnace) getTileEntity();
	}

	@Override
	public short getBurnTime() {
		return (short) furnace.getBurnTime();
	}

	@Override
	public short getCookTime() {
		return (short) furnace.getCookTime();
	}

	@Override
	public FurnaceInventory getInventory() {
		return new PipeFurnaceInventory(furnace);
	}

	@Override
	public void setBurnTime(short burnTime) {
		furnace.setBurnTime(burnTime);
	}

	@Override
	public void setCookTime(short cookTime) {
		furnace.setCookTime(cookTime);
	}

	@Override
	public boolean update(boolean force, boolean applyPhysics) {
		if (super.update(force, applyPhysics)) {
			furnace.update();
			return true;
		}
		return false;
	}

}
