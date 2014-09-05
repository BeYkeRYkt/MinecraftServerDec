package net.minecraft;

import java.util.Iterator;
import net.minecraft.server.MinecraftServer;

public class cl extends ab implements y {

	public cl() {
		this.a(new TimeCommand());
		this.a(new GameModeCommand());
		this.a(new DifficultyCommand());
		this.a(new DefaultGameModeCommand());
		this.a(new KillCommand());
		this.a(new ToggleDownfallCommand());
		this.a(new WeatherCommand());
		this.a(new XPCommand());
		this.a(new TeleportCommand());
		this.a(new GiveCommand());
		this.a(new ReplaceItemCommand());
		this.a(new StatsCommand());
		this.a(new EffectCommand());
		this.a(new EnchantCommand());
		this.a(new ParticleCommand());
		this.a(new MeCommand());
		this.a(new SeedCommand());
		this.a(new HelpCommand());
		this.a(new DebugCommand());
		this.a(new TellCommand());
		this.a(new SayCommand());
		this.a(new SpawnPointCommand());
		this.a(new SetWorldSpawnCommand());
		this.a(new GameRuleCommand());
		this.a(new ClearCommand());
		this.a(new TestforCommand());
		this.a(new SpreadPlayersCommand());
		this.a(new PlaySoundCommand());
		this.a(new ScoreboardCommand());
		this.a(new ExecuteCommand());
		this.a(new TriggerCommand());
		this.a(new AchievmentCommand());
		this.a(new SummonCommand());
		this.a(new SetBlockCommand());
		this.a(new FillCommand());
		this.a(new CloneCommand());
		this.a(new TestforBlocksCommand());
		this.a(new BlockDataCommand());
		this.a(new TestforBlockCommand());
		this.a(new TellRawCommand());
		this.a(new WorldBorderCommand());
		this.a(new TitleCommand());
		this.a(new EntityDataCommand());
		if (MinecraftServer.getInstance().isDedicated()) {
			this.a(new OpCommand());
			this.a(new DeopCommand());
			this.a(new ServerStopCommand());
			this.a(new ServerSaveCommand());
			this.a(new DisableAutoSaveCommand());
			this.a(new EnableAutoSaveCommand());
			this.a(new BanIPCommand());
			this.a(new UnbanIPCommand());
			this.a(new BanNameCommand());
			this.a(new BanListCommand());
			this.a(new UnbanNameCommand());
			this.a(new KickCommand());
			this.a(new ListCommand());
			this.a(new WhitelistCommand());
			this.a(new SetIdleCommand());
		} else {
			this.a(new PublishCommand());
		}

		AbstractCommand.a((y) this);
	}

	public void a(CommandSenderInterface var1, CommandInterface var2, int var3, String var4, Object... var5) {
		boolean var6 = true;
		MinecraftServer var7 = MinecraftServer.getInstance();
		if (!var1.t_()) {
			var6 = false;
		}

		hz var8 = new hz("chat.type.admin", new Object[] { var1.d_(), new hz(var4, var5) });
		var8.b().a(FormattingCode.h);
		var8.b().b(Boolean.valueOf(true));
		if (var6) {
			Iterator var9 = var7.getPlayerList().players.iterator();

			while (var9.hasNext()) {
				EntityHuman var10 = (EntityHuman) var9.next();
				if (var10 != var1 && var7.getPlayerList().g(var10.getGameProfile()) && var2.a(var1)) {
					var10.a((IJSONComponent) var8);
				}
			}
		}

		if (var1 != var7 && var7.worlds[0].Q().b("logAdminCommands")) {
			var7.a((IJSONComponent) var8);
		}

		boolean var11 = var7.worlds[0].Q().b("sendCommandFeedback");
		if (var1 instanceof aqf) {
			var11 = ((aqf) var1).m();
		}

		if ((var3 & 1) != 1 && var11) {
			var1.a(new hz(var4, var5));
		}

	}
}
