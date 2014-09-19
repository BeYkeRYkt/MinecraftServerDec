package pipebukkit.server.block;

import net.minecraft.TileEntityChest;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;

import pipebukkit.server.inventory.PipeChestInventory;
import pipebukkit.server.inventory.PipeDoubleChestInventory;

public class PipeChest extends PipeBlockState implements Chest {

	private static BlockFace[] horisontalFaces = new BlockFace[4]; 
	static {
		horisontalFaces[0] = BlockFace.NORTH;
		horisontalFaces[1] = BlockFace.EAST;
		horisontalFaces[2] = BlockFace.SOUTH;
		horisontalFaces[3] = BlockFace.WEST;
	}

	private TileEntityChest chest;

	public PipeChest(PipeBlock block) {
		super(block);
		chest = (TileEntityChest) getTileEntity();
	}

	@Override
	public Inventory getInventory() {
		Material chestMaterial = getBlock().getType();
		for (BlockFace face : horisontalFaces) {
			Block relative = getBlock().getRelative(face);
			if (relative.getType() == chestMaterial) {
				TileEntityChest connectedChest = (TileEntityChest) getTileEntity(relative);
				if (face != BlockFace.NORTH && face != BlockFace.WEST) {
					return new PipeDoubleChestInventory(chest, connectedChest);
				} else {
					return new PipeDoubleChestInventory(connectedChest, chest);
				}
			}
		}
		return getBlockInventory();
	}

	@Override
	public Inventory getBlockInventory() {
		return new PipeChestInventory(chest);
	}

	@Override
	public boolean update(boolean force, boolean applyPhysics) {
		if (super.update(force, applyPhysics)) {
			chest.update();
			return true;
		}
		return false;
	}

}
