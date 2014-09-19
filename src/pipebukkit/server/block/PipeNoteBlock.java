package pipebukkit.server.block;

import net.minecraft.TileEntityNote;

import org.bukkit.Instrument;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.block.NoteBlock;

public class PipeNoteBlock extends PipeBlockState implements NoteBlock {

	private TileEntityNote noteblock;

	public PipeNoteBlock(PipeBlock block) {
		super(block);
		noteblock = (TileEntityNote) getTileEntity();
	}

	@Override
	public Note getNote() {
		return new Note(getRawNote());
	}

	@Override
	public byte getRawNote() {
		return noteblock.note;
	}

	@Override
	public boolean play() {
		if (getBlock().getType() == Material.NOTE_BLOCK) {
			noteblock.play(noteblock.getWorld(), noteblock.getPosition());
			return true;
		}
		return false;
	}

	@Override
	public boolean play(byte instrument, byte note) {
		if (getBlock().getType() == Material.NOTE_BLOCK) {
			noteblock.play(noteblock.getWorld(), noteblock.getPosition(), instrument, note);
			return true;
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean play(Instrument instrument, Note note) {
		return play(instrument.getType(), note.getId());
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setNote(Note note) {
		setRawNote(note.getId());
	}

	@Override
	public void setRawNote(byte note) {
		noteblock.note = note;
	}

}
