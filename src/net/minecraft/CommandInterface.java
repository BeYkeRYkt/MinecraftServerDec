package net.minecraft;

import java.util.List;

public interface CommandInterface extends Comparable<CommandInterface> {

	String getName();

	String getUsage(CommandSenderInterface var1);

	List<String> getAliases();

	void executeCommand(CommandSenderInterface var1, String[] var2) throws dp, dm, dj, di;

	boolean a(CommandSenderInterface var1);

	List getTabCompleteList(CommandSenderInterface var1, String[] var2, dt var3);

	boolean b(String[] var1, int var2);
}
