package pipebukkit.server.block;

import net.minecraft.BlockJukeBox;
import net.minecraft.Blocks;
import net.minecraft.Item;
import net.minecraft.Position;
import net.minecraft.TileEntityRecordPlayer;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.block.Jukebox;

public class PipeJukebox extends PipeBlockState implements Jukebox {

	private TileEntityRecordPlayer jukebox;

	public PipeJukebox(PipeBlock block) {
		super(block);
		jukebox = (TileEntityRecordPlayer) getTileEntity();
	}

	@Override
	public boolean eject() {
		boolean result = isPlaying();
		((BlockJukeBox) Blocks.JUKEBOX).dropRecord(jukebox.getWorld(), new Position(getX(), getY(), getZ()), null);
		return result;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Material getPlaying() {
		return Material.getMaterial(Item.getId(jukebox.getRecord().getItem()));
	}

	@Override
	public boolean isPlaying() {
		return getRawData() == 1;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setPlaying(Material material) {
		Item item = Item.getById(material.getId());
		if (material == null || material == Material.AIR || item == null) {
			jukebox.setRecord(null);
		} else {
			jukebox.setRecord(new net.minecraft.ItemStack(item));
		}
		jukebox.update();
		if (jukebox.getRecord() == null) {
			getBlock().setData((byte) 0);
		} else {
			getBlock().setData((byte) 1);
		}
		getWorld().playEffect(getLocation(), Effect.RECORD_PLAY, Item.getId(jukebox.getRecord().getItem()));
	}

}
