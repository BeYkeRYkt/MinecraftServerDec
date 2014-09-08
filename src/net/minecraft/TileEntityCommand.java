package net.minecraft;

public class TileEntityCommand extends TileEntity {

	private final CommandBlockListenerAbstract listener = new TileEntityCommandListener(this);

	public void write(NBTCompoundTag tag) {
		super.write(tag);
		this.listener.write(tag);
	}

	public void read(NBTCompoundTag tag) {
		super.read(tag);
		this.listener.read(tag);
	}

	public Packet<? extends PacketListener> getUpdatePacket() {
		NBTCompoundTag tag = new NBTCompoundTag();
		this.write(tag);
		return new PacketPlayOutUpdateBlockEntity(this.position, 2, tag);
	}

	public CommandBlockListenerAbstract getListener() {
		return this.listener;
	}

	public CommandBlockStatistic getStatistic() {
		return this.listener.getStatistic();
	}

}
