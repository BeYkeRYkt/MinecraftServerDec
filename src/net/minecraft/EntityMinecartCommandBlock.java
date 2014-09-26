package net.minecraft;

public class EntityMinecartCommandBlock extends adx {

	private final CommandBlockListenerAbstract listener = new EntityMinecartCommandListener(this);
	private int b = 0;

	public EntityMinecartCommandBlock(World var1) {
		super(var1);
	}

	public EntityMinecartCommandBlock(World var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	protected void h() {
		super.h();
		this.getDataWatcher().a(23, "");
		this.getDataWatcher().a(24, "");
	}

	protected void readAdditionalData(NBTCompoundTag var1) {
		super.readAdditionalData(var1);
		this.listener.read(var1);
		this.getDataWatcher().b(23, this.getListener().getCommand());
		this.getDataWatcher().b(24, ChatSerializer.toJsonString(this.getListener().getLastOutput()));
	}

	protected void writeAdditionalData(NBTCompoundTag var1) {
		super.writeAdditionalData(var1);
		this.listener.write(var1);
	}

	public MinecartType getType() {
		return MinecartType.COMMAND_BLOCK;
	}

	public IBlockState u() {
		return Blocks.COMMAND_BLOCK.getBlockState();
	}

	public CommandBlockListenerAbstract getListener() {
		return this.listener;
	}

	public void a(int var1, int var2, int var3, boolean var4) {
		if (var4 && this.ticksLived - this.b >= 4) {
			this.getListener().executeCommand(this.world);
			this.b = this.ticksLived;
		}

	}

	public boolean e(EntityHuman var1) {
		this.listener.canOpen(var1);
		return false;
	}

	public void i(int var1) {
		super.i(var1);
		if (var1 == 24) {
			try {
				this.listener.setLastOutput(ChatSerializer.fromJsonString(this.getDataWatcher().e(24)));
			} catch (Throwable var3) {
				;
			}
		} else if (var1 == 23) {
			this.listener.setCommand(this.getDataWatcher().e(23));
		}
	}

}
