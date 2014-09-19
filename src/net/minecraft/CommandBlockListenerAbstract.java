package net.minecraft;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.minecraft.server.MinecraftServer;

public abstract class CommandBlockListenerAbstract implements CommandSenderInterface {

	private static final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

	private int succCount;
	private boolean trackOutput = true;
	private IChatBaseComponent lastOutput = null;
	private String command = "";
	private String customName = "@";
	private final CommandBlockStatistic statistic = new CommandBlockStatistic();

	public int getSuccessCount() {
		return this.succCount;
	}

	public IChatBaseComponent getLastOutput() {
		return this.lastOutput;
	}

	public void write(NBTCompoundTag tag) {
		tag.put("Command", this.command);
		tag.put("SuccessCount", this.succCount);
		tag.put("CustomName", this.customName);
		tag.put("TrackOutput", this.trackOutput);
		if (this.lastOutput != null && this.trackOutput) {
			tag.put("LastOutput", ChatSerializer.toJsonString(this.lastOutput));
		}

		this.statistic.write(tag);
	}

	public void read(NBTCompoundTag tag) {
		this.command = tag.getString("Command");
		this.succCount = tag.getInt("SuccessCount");
		if (tag.isTagAssignableFrom("CustomName", 8)) {
			this.customName = tag.getString("CustomName");
		}

		if (tag.isTagAssignableFrom("TrackOutput", 1)) {
			this.trackOutput = tag.getBoolean("TrackOutput");
		}

		if (tag.isTagAssignableFrom("LastOutput", 8) && this.trackOutput) {
			this.lastOutput = ChatSerializer.fromJsonString(tag.getString("LastOutput"));
		}

		this.statistic.read(tag);
	}

	public boolean canExecuteCommand(int var1, String command) {
		return var1 <= 2;
	}

	public void setCommand(String command) {
		this.command = command;
		this.succCount = 0;
	}

	public String getCommand() {
		return this.command;
	}

	public void executeCommand(World world) {
		if (world.isStatic) {
			this.succCount = 0;
		}

		MinecraftServer server = MinecraftServer.getInstance();
		if (server != null && server.hasUniverse() && server.isCommandBlockEnabled()) {
			ICommandHandler commandHandler = server.getCommandHandler();

			try {
				this.lastOutput = null;
				this.succCount = commandHandler.handleCommand(this, this.command);
			} catch (Throwable t) {
				CrashReport crashReportDetails = CrashReport.generateCrashReport(t, "Executing command block");
				CrashReportSystemDetails crashReportSystemDetails = crashReportDetails.generateSystemDetails("Command to be executed");
				crashReportSystemDetails.addDetails("Command", getCommand());
				crashReportSystemDetails.addDetails("Name", getName());
				throw new ReportedException(crashReportDetails);
			}
		} else {
			this.succCount = 0;
		}

	}

	public String getName() {
		return this.customName;
	}

	public IChatBaseComponent getComponentName() {
		return new ChatComponentText(this.getName());
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public void sendChatMessage(IChatBaseComponent message) {
		if (this.trackOutput && this.getWorld() != null && !this.getWorld().isStatic) {
			this.lastOutput = (new ChatComponentText("[" + format.format(new Date()) + "] ")).a(message);
			this.updateEntity();
		}
	}

	public boolean isCommandBlockOuputEnabled() {
		MinecraftServer minecraftServer = MinecraftServer.getInstance();
		return minecraftServer == null || !minecraftServer.hasUniverse() || minecraftServer.getWorld().getGameRules().b("commandBlockOutput");
	}

	public void a(ag var1, int var2) {
		this.statistic.a(this, var1, var2);
	}

	public abstract void updateEntity();

	public void setLastOutput(IChatBaseComponent lastOutput) {
		this.lastOutput = lastOutput;
	}

	public void setTrackOutput(boolean trackOutput) {
		this.trackOutput = trackOutput;
	}

	public boolean isTrackOutputEnabled() {
		return this.trackOutput;
	}

	public boolean canOpen(EntityHuman who) {
		if (!who.playerProperties.instabuild) {
			return false;
		} else {
			if (who.getWorld().isStatic) {
				who.a(this);
			}

			return true;
		}
	}

	public CommandBlockStatistic getStatistic() {
		return this.statistic;
	}

}
