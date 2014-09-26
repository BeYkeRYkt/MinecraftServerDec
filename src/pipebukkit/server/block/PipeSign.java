package pipebukkit.server.block;

import net.minecraft.ChatComponentText;
import net.minecraft.TileEntitySign;

import org.bukkit.block.Sign;

public class PipeSign extends PipeBlockState implements Sign {

	private TileEntitySign sign;
	private String lines[] = new String[4];

	public PipeSign(PipeBlock block) {
		super(block);
		sign = (TileEntitySign) getTileEntity();
		for (int i = 0; i < sign.lines.length && i < lines.length; i++) {
			lines[i] = sign.lines[i].getComponentVaue();
		}
	}

	@Override
	public String getLine(int index) throws IndexOutOfBoundsException {
		return getLines()[index];
	}

	@Override
	public String[] getLines() {
		return lines;
	}

	@Override
	public void setLine(int index, String data) throws IndexOutOfBoundsException {
		lines[index] = data;
	}

	@Override
	public boolean update(boolean force, boolean applyPhysics) {
		if (super.update(force, applyPhysics)) {
			for (int i = 0; i < sign.lines.length && i < lines.length; i++) {
				sign.lines[i] = new ChatComponentText(lines[i]);
			}
			return true;
		}
		return false;
	}

}
