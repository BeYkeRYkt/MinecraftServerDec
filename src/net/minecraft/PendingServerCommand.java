package net.minecraft;

public class PendingServerCommand {

	public final String command;
	public final CommandSenderInterface sender;

	public PendingServerCommand(String command, CommandSenderInterface sender) {
		this.command = command;
		this.sender = sender;
	}

}
