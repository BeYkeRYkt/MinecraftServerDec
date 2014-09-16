package net.minecraft;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
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
			ICommandHandler var3 = server.getCommandHandler();

			try {
				this.lastOutput = null;
				this.succCount = var3.handleCommand(this, this.command);
			} catch (Throwable var7) {
				CrashReport var5 = CrashReport.generateCrashReport(var7, "Executing command block");
				CrashReportSystemDetails var6 = var5.generateSystemDetails("Command to be executed");
				var6.addDetails("Command", new aqg(this));
				var6.addDetails("Name", new aqh(this));
				throw new ReportedException(var5);
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

	public boolean t_() {
		MinecraftServer var1 = MinecraftServer.getInstance();
		return var1 == null || !var1.hasUniverse() || var1.getWorld().getGameRules().b("commandBlockOutput");
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

	public boolean a(EntityHuman var1) {
		if (!var1.playerProperties.instabuild) {
			return false;
		} else {
			if (var1.getWorld().isStatic) {
				var1.a(this);
			}

			return true;
		}
	}

	public CommandBlockStatistic getStatistic() {
		return this.statistic;
	}

}
