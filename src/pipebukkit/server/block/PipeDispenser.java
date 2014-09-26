package pipebukkit.server.block;

import net.minecraft.BlockDispenser;
import net.minecraft.Blocks;
import net.minecraft.Position;
import net.minecraft.TileEntityDispenser;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Dispenser;
import org.bukkit.inventory.Inventory;
import org.bukkit.projectiles.BlockProjectileSource;

import pipebukkit.server.inventory.PipeDispenserInventory;
import pipebukkit.server.projectiles.PipeBlockProjectileSource;

public class PipeDispenser extends PipeBlockState implements Dispenser {

	private TileEntityDispenser dispenser;

	public PipeDispenser(PipeBlock block) {
		super(block);
		dispenser = (TileEntityDispenser) getTileEntity();
	}

	@Override
	public Inventory getInventory() {
		return new PipeDispenserInventory(dispenser);
	}

	@Override
	public boolean dispense() {
		Block block = getBlock();
		if (block.getType() == Material.DISPENSER) {
			BlockDispenser blockdispenser = (BlockDispenser) Blocks.DISPENSER;
			blockdispenser.dispense(dispenser.getWorld(), new Position(getX(), getY(), getZ()));
			return true;
		}
		return false;
	}

	@Override
	public BlockProjectileSource getBlockProjectileSource() {
		if (getBlock().getType() == Material.DISPENSER) {
			return new PipeBlockProjectileSource(dispenser);
		}
		return null;
	}

	@Override
	public boolean update(boolean force, boolean applyPhysics) {
		if (super.update(force, applyPhysics)) {
			dispenser.update();
			return true;
		}
		return false;
	}

}
