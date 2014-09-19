package pipebukkit.server.block;

import net.minecraft.TileEntityCommand;

import org.bukkit.block.CommandBlock;

public class PipeCommandBlock extends PipeBlockState implements CommandBlock {

	private TileEntityCommand commandBlock;
	private String command;
	private String name;

	public PipeCommandBlock(PipeBlock block) {
		super(block);
		commandBlock = (TileEntityCommand) getTileEntity();
		command = commandBlock.getListener().getCommand();
		command = commandBlock.getListener().getName();
	}

	@Override
	public String getCommand() {
		return command;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setCommand(String command) {
		this.command = command;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean update(boolean force, boolean applyPhysics) {
		if (super.update(force, applyPhysics)) {
			commandBlock.getListener().setCommand(command);
			commandBlock.getListener().setCustomName(name);
			return true;
		}
		return false;
	}

}
