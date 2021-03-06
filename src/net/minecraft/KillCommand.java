package net.minecraft;

public class KillCommand extends AbstractCommand {

	public String getName() {
		return "kill";
	}

	public int a() {
		return 2;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.kill.usage";
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) throws dj, dm {
		if (var2.length == 0) {
			EntityPlayer var4 = b(var1);
			var4.setDead();
			a(var1, this, "commands.kill.successful", new Object[] { var4.getComponentName() });
		} else {
			Entity var3 = b(var1, var2[0]);
			var3.setDead();
			a(var1, this, "commands.kill.successful", new Object[] { var3.getComponentName() });
		}
	}

	public boolean b(String[] var1, int var2) {
		return var2 == 0;
	}

}
