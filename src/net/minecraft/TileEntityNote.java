package net.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.event.block.NotePlayEvent;

public class TileEntityNote extends TileEntity {

	public byte note;
	public boolean f;

	public void write(NBTCompoundTag tag) {
		super.write(tag);
		tag.put("note", this.note);
	}

	public void read(NBTCompoundTag tag) {
		super.read(tag);
		this.note = tag.getByte("note");
		this.note = (byte) MathHelper.a(this.note, 0, 24);
	}

	public void b() {
		this.note = (byte) ((this.note + 1) % 25);
		this.update();
	}

	public void play(WorldServer world, Position position) {
		if (world.getBlockState(position.getUp()).getBlock().getMaterial() == Material.AIR) {
			Material material = world.getBlockState(position.getDown()).getBlock().getMaterial();
			byte instrument = 0;
			if (material == Material.STONE) {
				instrument = 1;
			}

			if (material == Material.SAND) {
				instrument = 2;
			}

			if (material == Material.SHATTERABLE) {
				instrument = 3;
			}

			if (material == Material.WOOD) {
				instrument = 4;
			}

			play(world, position, instrument, note);
		}
	}

	@SuppressWarnings("deprecation")
	public void play(WorldServer world, Position position, byte instrument, byte note) {
		NotePlayEvent notePlayEventevent = new NotePlayEvent(world.getBukkitWorld().getBlockAt(position.getX(), position.getY(), position.getZ()), Instrument.getByType(instrument), new Note(note));
		Bukkit.getPluginManager().callEvent(notePlayEventevent);
		if (notePlayEventevent.isCancelled()) {
			return;
		}

		world.playBlockAction(position, Blocks.NOTEBLOCK, notePlayEventevent.getInstrument().getType(), notePlayEventevent.getNote().getId());
	}

}
