package pipebukkit.server.block;

import org.bukkit.block.Beacon;
import org.bukkit.inventory.Inventory;

import pipebukkit.server.inventory.PipeBeaconInventory;
import net.minecraft.TileEntityBeacon;

public class PipeBeacon extends PipeBlockState implements Beacon {

	private TileEntityBeacon beacon;

	public PipeBeacon(PipeBlock block) {
		super(block);
		beacon = (TileEntityBeacon) getTileEntity();
	}

	@Override
	public Inventory getInventory() {
		return new PipeBeaconInventory(beacon);
	}

}
