package net.minecraft;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;

public abstract class aqf implements CommandSenderInterface {

	private static final SimpleDateFormat a = new SimpleDateFormat("HH:mm:ss");
	private int b;
	private boolean c = true;
	private IJSONComponent d = null;
	private String e = "";
	private String f = "@";
	private final af g = new af();

	public int j() {
		return this.b;
	}

	public IJSONComponent k() {
		return this.d;
	}

	public void a(NBTCompoundTag var1) {
		var1.put("Command", this.e);
		var1.put("SuccessCount", this.b);
		var1.put("CustomName", this.f);
		var1.put("TrackOutput", this.c);
		if (this.d != null && this.c) {
			var1.put("LastOutput", JSONComponentFormat.a(this.d));
		}

		this.g.b(var1);
	}

	public void b(NBTCompoundTag var1) {
		this.e = var1.getString("Command");
		this.b = var1.getInt("SuccessCount");
		if (var1.isTagAssignableFrom("CustomName", 8)) {
			this.f = var1.getString("CustomName");
		}

		if (var1.isTagAssignableFrom("TrackOutput", 1)) {
			this.c = var1.getBoolean("TrackOutput");
		}

		if (var1.isTagAssignableFrom("LastOutput", 8) && this.c) {
			this.d = JSONComponentFormat.a(var1.getString("LastOutput"));
		}

		this.g.a(var1);
	}

	public boolean a(int var1, String var2) {
		return var1 <= 2;
	}

	public void a(String var1) {
		this.e = var1;
		this.b = 0;
	}

	public String l() {
		return this.e;
	}

	public void a(World var1) {
		if (var1.D) {
			this.b = 0;
		}

		MinecraftServer var2 = MinecraftServer.getInstance();
		if (var2 != null && var2.hasUniverse() && var2.isCommandBlockEnabled()) {
			CommandHandlerInterface var3 = var2.getCommandHandler();

			try {
				this.d = null;
				this.b = var3.a(this, this.e);
			} catch (Throwable var7) {
				CrashReport var5 = CrashReport.generateCrashReport(var7, "Executing command block");
				CrashReportSystemDetails var6 = var5.generateSystemDetails("Command to be executed");
				var6.addDetails("Command", (Callable) (new aqg(this)));
				var6.addDetails("Name", (Callable) (new aqh(this)));
				throw new ReportedException(var5);
			}
		} else {
			this.b = 0;
		}

	}

	public String d_() {
		return this.f;
	}

	public IJSONComponent e_() {
		return new hy(this.d_());
	}

	public void b(String var1) {
		this.f = var1;
	}

	public void a(IJSONComponent var1) {
		if (this.c && this.e() != null && !this.e().D) {
			this.d = (new hy("[" + a.format(new Date()) + "] ")).a(var1);
			this.h();
		}

	}

	public boolean t_() {
		MinecraftServer var1 = MinecraftServer.getInstance();
		return var1 == null || !var1.hasUniverse() || var1.worlds[0].Q().b("commandBlockOutput");
	}

	public void a(ag var1, int var2) {
		this.g.a(this, var1, var2);
	}

	public abstract void h();

	public void b(IJSONComponent var1) {
		this.d = var1;
	}

	public void a(boolean var1) {
		this.c = var1;
	}

	public boolean m() {
		return this.c;
	}

	public boolean a(EntityHuman var1) {
		if (!var1.by.instabuild) {
			return false;
		} else {
			if (var1.e().D) {
				var1.a(this);
			}

			return true;
		}
	}

	public af n() {
		return this.g;
	}

}
