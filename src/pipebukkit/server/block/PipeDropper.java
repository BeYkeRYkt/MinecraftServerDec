package pipebukkit.server.block;

import net.minecraft.BlockDropper;
import net.minecraft.Blocks;
import net.minecraft.Position;
import net.minecraft.TileEntityDropper;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Dropper;
import org.bukkit.inventory.Inventory;

import pipebukkit.server.inventory.PipeDropperInventory;

public class PipeDropper extends PipeBlockState implements Dropper {

	private TileEntityDropper dropper;

	public PipeDropper(PipeBlock block) {
		super(block);
		dropper = (TileEntityDropper) getTileEntity();
	}

	@Override
	public Inventory getInventory() {
		return new PipeDropperInventory(dropper);
	}

	@Override
	public void drop() {
		Block block = getBlock();
		if (block.getType() == Material.DROPPER) {
			BlockDropper blockddropper = (BlockDropper) Blocks.DROPPER;
			blockddropper.dispense(dropper.getWorld(), new Position(getX(), getY(), getZ()));
		}
	}

	@Override
	public boolean update(boolean force, boolean applyPhysics) {
		if (super.update(force, applyPhysics)) {
			dropper.update();
			return true;
		}
		return false;
	}

}
