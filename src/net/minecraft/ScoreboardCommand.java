package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.server.MinecraftServer;

public class ScoreboardCommand extends AbstractCommand {

	public String getName() {
		return "scoreboard";
	}

	public int a() {
		return 2;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.scoreboard.usage";
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) throws di {
		if (!this.b(var1, var2)) {
			if (var2.length < 1) {
				throw new dp("commands.scoreboard.usage", new Object[0]);
			} else {
				if (var2[0].equalsIgnoreCase("objectives")) {
					if (var2.length == 1) {
						throw new dp("commands.scoreboard.objectives.usage", new Object[0]);
					}

					if (var2[1].equalsIgnoreCase("list")) {
						this.d(var1);
					} else if (var2[1].equalsIgnoreCase("add")) {
						if (var2.length < 4) {
							throw new dp("commands.scoreboard.objectives.add.usage", new Object[0]);
						}

						this.b(var1, var2, 2);
					} else if (var2[1].equalsIgnoreCase("remove")) {
						if (var2.length != 3) {
							throw new dp("commands.scoreboard.objectives.remove.usage", new Object[0]);
						}

						this.h(var1, var2[2]);
					} else {
						if (!var2[1].equalsIgnoreCase("setdisplay")) {
							throw new dp("commands.scoreboard.objectives.usage", new Object[0]);
						}

						if (var2.length != 3 && var2.length != 4) {
							throw new dp("commands.scoreboard.objectives.setdisplay.usage", new Object[0]);
						}

						this.j(var1, var2, 2);
					}
				} else if (var2[0].equalsIgnoreCase("players")) {
					if (var2.length == 1) {
						throw new dp("commands.scoreboard.players.usage", new Object[0]);
					}

					if (var2[1].equalsIgnoreCase("list")) {
						if (var2.length > 3) {
							throw new dp("commands.scoreboard.players.list.usage", new Object[0]);
						}

						this.k(var1, var2, 2);
					} else if (var2[1].equalsIgnoreCase("add")) {
						if (var2.length < 5) {
							throw new dp("commands.scoreboard.players.add.usage", new Object[0]);
						}

						this.l(var1, var2, 2);
					} else if (var2[1].equalsIgnoreCase("remove")) {
						if (var2.length < 5) {
							throw new dp("commands.scoreboard.players.remove.usage", new Object[0]);
						}

						this.l(var1, var2, 2);
					} else if (var2[1].equalsIgnoreCase("set")) {
						if (var2.length < 5) {
							throw new dp("commands.scoreboard.players.set.usage", new Object[0]);
						}

						this.l(var1, var2, 2);
					} else if (var2[1].equalsIgnoreCase("reset")) {
						if (var2.length != 3 && var2.length != 4) {
							throw new dp("commands.scoreboard.players.reset.usage", new Object[0]);
						}

						this.m(var1, var2, 2);
					} else if (var2[1].equalsIgnoreCase("enable")) {
						if (var2.length != 4) {
							throw new dp("commands.scoreboard.players.enable.usage", new Object[0]);
						}

						this.n(var1, var2, 2);
					} else if (var2[1].equalsIgnoreCase("test")) {
						if (var2.length != 5 && var2.length != 6) {
							throw new dp("commands.scoreboard.players.test.usage", new Object[0]);
						}

						this.o(var1, var2, 2);
					} else {
						if (!var2[1].equalsIgnoreCase("operation")) {
							throw new dp("commands.scoreboard.players.usage", new Object[0]);
						}

						if (var2.length != 7) {
							throw new dp("commands.scoreboard.players.operation.usage", new Object[0]);
						}

						this.p(var1, var2, 2);
					}
				} else if (var2[0].equalsIgnoreCase("teams")) {
					if (var2.length == 1) {
						throw new dp("commands.scoreboard.teams.usage", new Object[0]);
					}

					if (var2[1].equalsIgnoreCase("list")) {
						if (var2.length > 3) {
							throw new dp("commands.scoreboard.teams.list.usage", new Object[0]);
						}

						this.f(var1, var2, 2);
					} else if (var2[1].equalsIgnoreCase("add")) {
						if (var2.length < 3) {
							throw new dp("commands.scoreboard.teams.add.usage", new Object[0]);
						}

						this.c(var1, var2, 2);
					} else if (var2[1].equalsIgnoreCase("remove")) {
						if (var2.length != 3) {
							throw new dp("commands.scoreboard.teams.remove.usage", new Object[0]);
						}

						this.e(var1, var2, 2);
					} else if (var2[1].equalsIgnoreCase("empty")) {
						if (var2.length != 3) {
							throw new dp("commands.scoreboard.teams.empty.usage", new Object[0]);
						}

						this.i(var1, var2, 2);
					} else if (var2[1].equalsIgnoreCase("join")) {
						if (var2.length < 4 && (var2.length != 3 || !(var1 instanceof EntityHuman))) {
							throw new dp("commands.scoreboard.teams.join.usage", new Object[0]);
						}

						this.g(var1, var2, 2);
					} else if (var2[1].equalsIgnoreCase("leave")) {
						if (var2.length < 3 && !(var1 instanceof EntityHuman)) {
							throw new dp("commands.scoreboard.teams.leave.usage", new Object[0]);
						}

						this.h(var1, var2, 2);
					} else {
						if (!var2[1].equalsIgnoreCase("option")) {
							throw new dp("commands.scoreboard.teams.usage", new Object[0]);
						}

						if (var2.length != 4 && var2.length != 5) {
							throw new dp("commands.scoreboard.teams.option.usage", new Object[0]);
						}

						this.d(var1, var2, 2);
					}
				}

			}
		}
	}

	private boolean b(CommandSenderInterface var1, String[] var2) throws di {
		int var3 = -1;

		for (int var4 = 0; var4 < var2.length; ++var4) {
			if (this.b(var2, var4) && "*".equals(var2[var4])) {
				if (var3 >= 0) {
					throw new di("commands.scoreboard.noMultiWildcard", new Object[0]);
				}

				var3 = var4;
			}
		}

		if (var3 < 0) {
			return false;
		} else {
			ArrayList var12 = Lists.newArrayList(this.d().d());
			String var5 = var2[var3];
			ArrayList var6 = Lists.newArrayList();
			Iterator var7 = var12.iterator();

			while (var7.hasNext()) {
				String var8 = (String) var7.next();
				var2[var3] = var8;

				try {
					this.executeCommand(var1, var2);
					var6.add(var8);
				} catch (di var11) {
					ChatMessage var10 = new ChatMessage(var11.getMessage(), var11.a());
					var10.getChatModifier().setColor(EnumChatFormat.RED);
					var1.sendChatMessage(var10);
				}
			}

			var2[var3] = var5;
			var1.a(ag.c, var6.size());
			if (var6.size() == 0) {
				throw new dp("commands.scoreboard.allMatchesFailed", new Object[0]);
			} else {
				return true;
			}
		}
	}

	protected Scoreboard d() {
		return MinecraftServer.getInstance().getWorldServer(0).Z();
	}

	protected ScoreboardObjective a(String var1, boolean var2) throws di {
		Scoreboard var3 = this.d();
		ScoreboardObjective var4 = var3.b(var1);
		if (var4 == null) {
			throw new di("commands.scoreboard.objectiveNotFound", new Object[] { var1 });
		} else if (var2 && var4.getCriteria().isReadOnly()) {
			throw new di("commands.scoreboard.objectiveReadOnly", new Object[] { var1 });
		} else {
			return var4;
		}
	}

	protected ScoreboardTeam e(String var1) throws di {
		Scoreboard var2 = this.d();
		ScoreboardTeam var3 = var2.d(var1);
		if (var3 == null) {
			throw new di("commands.scoreboard.teamNotFound", new Object[] { var1 });
		} else {
			return var3;
		}
	}

	protected void b(CommandSenderInterface var1, String[] var2, int var3) throws di {
		String var4 = var2[var3++];
		String var5 = var2[var3++];
		Scoreboard var6 = this.d();
		IScoreboardCriteria var7 = (IScoreboardCriteria) IScoreboardCriteria.byName.get(var5);
		if (var7 == null) {
			throw new dp("commands.scoreboard.objectives.add.wrongType", new Object[] { var5 });
		} else if (var6.b(var4) != null) {
			throw new di("commands.scoreboard.objectives.add.alreadyExists", new Object[] { var4 });
		} else if (var4.length() > 16) {
			throw new dl("commands.scoreboard.objectives.add.tooLong", new Object[] { var4, Integer.valueOf(16) });
		} else if (var4.length() == 0) {
			throw new dp("commands.scoreboard.objectives.add.usage", new Object[0]);
		} else {
			if (var2.length > var3) {
				String var8 = a(var1, var2, var3).getStrippedMessage();
				if (var8.length() > 32) {
					throw new dl("commands.scoreboard.objectives.add.displayTooLong", new Object[] { var8, Integer.valueOf(32) });
				}

				if (var8.length() > 0) {
					var6.a(var4, var7).setDisplayName(var8);
				} else {
					var6.a(var4, var7);
				}
			} else {
				var6.a(var4, var7);
			}

			a(var1, this, "commands.scoreboard.objectives.add.success", new Object[] { var4 });
		}
	}

	protected void c(CommandSenderInterface var1, String[] var2, int var3) throws di {
		String var4 = var2[var3++];
		Scoreboard var5 = this.d();
		if (var5.d(var4) != null) {
			throw new di("commands.scoreboard.teams.add.alreadyExists", new Object[] { var4 });
		} else if (var4.length() > 16) {
			throw new dl("commands.scoreboard.teams.add.tooLong", new Object[] { var4, Integer.valueOf(16) });
		} else if (var4.length() == 0) {
			throw new dp("commands.scoreboard.teams.add.usage", new Object[0]);
		} else {
			if (var2.length > var3) {
				String var6 = a(var1, var2, var3).getStrippedMessage();
				if (var6.length() > 32) {
					throw new dl("commands.scoreboard.teams.add.displayTooLong", new Object[] { var6, Integer.valueOf(32) });
				}

				if (var6.length() > 0) {
					var5.e(var4).setDisplayName(var6);
				} else {
					var5.e(var4);
				}
			} else {
				var5.e(var4);
			}

			a(var1, this, "commands.scoreboard.teams.add.success", new Object[] { var4 });
		}
	}

	protected void d(CommandSenderInterface var1, String[] var2, int var3) throws di {
		ScoreboardTeam var4 = this.e(var2[var3++]);
		if (var4 != null) {
			String var5 = var2[var3++].toLowerCase();
			if (!var5.equalsIgnoreCase("FormattingCode") && !var5.equalsIgnoreCase("friendlyfire") && !var5.equalsIgnoreCase("seeFriendlyInvisibles") && !var5.equalsIgnoreCase("nametagVisibility") && !var5.equalsIgnoreCase("deathMessageVisibility")) {
				throw new dp("commands.scoreboard.teams.option.usage", new Object[0]);
			} else if (var2.length == 4) {
				if (var5.equalsIgnoreCase("FormattingCode")) {
					throw new dp("commands.scoreboard.teams.option.noValue", new Object[] { var5, a(EnumChatFormat.getCodes(true, false)) });
				} else if (!var5.equalsIgnoreCase("friendlyfire") && !var5.equalsIgnoreCase("seeFriendlyInvisibles")) {
					if (!var5.equalsIgnoreCase("nametagVisibility") && !var5.equalsIgnoreCase("deathMessageVisibility")) {
						throw new dp("commands.scoreboard.teams.option.usage", new Object[0]);
					} else {
						throw new dp("commands.scoreboard.teams.option.noValue", new Object[] { var5, a(ScoreboardTeamNameTagVisibility.getNames()) });
					}
				} else {
					throw new dp("commands.scoreboard.teams.option.noValue", new Object[] { var5, a(Arrays.asList(new String[] { "true", "false" })) });
				}
			} else {
				String var6 = var2[var3];
				if (var5.equalsIgnoreCase("FormattingCode")) {
					EnumChatFormat var7 = EnumChatFormat.getByName(var6);
					if (var7 == null || var7.isFormattingCode()) {
						throw new dp("commands.scoreboard.teams.option.noValue", new Object[] { var5, a(EnumChatFormat.getCodes(true, false)) });
					}

					var4.setColor(var7);
					var4.setPrefix(var7.toString());
					var4.setSuffix(EnumChatFormat.RESET.toString());
				} else if (var5.equalsIgnoreCase("friendlyfire")) {
					if (!var6.equalsIgnoreCase("true") && !var6.equalsIgnoreCase("false")) {
						throw new dp("commands.scoreboard.teams.option.noValue", new Object[] { var5, a(Arrays.asList(new String[] { "true", "false" })) });
					}

					var4.setAllowFriendlyFire(var6.equalsIgnoreCase("true"));
				} else if (var5.equalsIgnoreCase("seeFriendlyInvisibles")) {
					if (!var6.equalsIgnoreCase("true") && !var6.equalsIgnoreCase("false")) {
						throw new dp("commands.scoreboard.teams.option.noValue", new Object[] { var5, a(Arrays.asList(new String[] { "true", "false" })) });
					}

					var4.setCanSeeFriendlyInvisibles(var6.equalsIgnoreCase("true"));
				} else {
					ScoreboardTeamNameTagVisibility var8;
					if (var5.equalsIgnoreCase("nametagVisibility")) {
						var8 = ScoreboardTeamNameTagVisibility.getByName(var6);
						if (var8 == null) {
							throw new dp("commands.scoreboard.teams.option.noValue", new Object[] { var5, a(ScoreboardTeamNameTagVisibility.getNames()) });
						}

						var4.setTagVisibility(var8);
					} else if (var5.equalsIgnoreCase("deathMessageVisibility")) {
						var8 = ScoreboardTeamNameTagVisibility.getByName(var6);
						if (var8 == null) {
							throw new dp("commands.scoreboard.teams.option.noValue", new Object[] { var5, a(ScoreboardTeamNameTagVisibility.getNames()) });
						}

						var4.setDeathMessageVisibility(var8);
					}
				}

				a(var1, this, "commands.scoreboard.teams.option.success", new Object[] { var5, var4.getName(), var6 });
			}
		}
	}

	protected void e(CommandSenderInterface var1, String[] var2, int var3) throws di {
		Scoreboard var4 = this.d();
		ScoreboardTeam var5 = this.e(var2[var3]);
		if (var5 != null) {
			var4.d(var5);
			a(var1, this, "commands.scoreboard.teams.remove.success", new Object[] { var5.getName() });
		}
	}

	protected void f(CommandSenderInterface var1, String[] var2, int var3) throws di {
		Scoreboard var4 = this.d();
		if (var2.length > var3) {
			ScoreboardTeam var5 = this.e(var2[var3]);
			if (var5 == null) {
				return;
			}

			Collection var6 = var5.getPlayerNameSet();
			var1.a(ag.e, var6.size());
			if (var6.size() <= 0) {
				throw new di("commands.scoreboard.teams.list.player.empty", new Object[] { var5.getName() });
			}

			ChatMessage var7 = new ChatMessage("commands.scoreboard.teams.list.player.count", new Object[] { Integer.valueOf(var6.size()), var5.getName() });
			var7.getChatModifier().setColor(EnumChatFormat.DARK_GREEN);
			var1.sendChatMessage(var7);
			var1.sendChatMessage(new ChatComponentText(a(var6.toArray())));
		} else {
			Collection var9 = var4.g();
			var1.a(ag.e, var9.size());
			if (var9.size() <= 0) {
				throw new di("commands.scoreboard.teams.list.empty", new Object[0]);
			}

			ChatMessage var10 = new ChatMessage("commands.scoreboard.teams.list.count", new Object[] { Integer.valueOf(var9.size()) });
			var10.getChatModifier().setColor(EnumChatFormat.DARK_GREEN);
			var1.sendChatMessage(var10);
			Iterator var11 = var9.iterator();

			while (var11.hasNext()) {
				ScoreboardTeam var8 = (ScoreboardTeam) var11.next();
				var1.sendChatMessage(new ChatMessage("commands.scoreboard.teams.list.entry", new Object[] { var8.getName(), var8.getDisplayName(), Integer.valueOf(var8.getPlayerNameSet().size()) }));
			}
		}

	}

	protected void g(CommandSenderInterface var1, String[] var2, int var3) throws di {
		Scoreboard var4 = this.d();
		String var5 = var2[var3++];
		HashSet var6 = Sets.newHashSet();
		HashSet var7 = Sets.newHashSet();
		String var8;
		if (var1 instanceof EntityHuman && var3 == var2.length) {
			var8 = b(var1).getName();
			if (var4.a(var8, var5)) {
				var6.add(var8);
			} else {
				var7.add(var8);
			}
		} else {
			while (var3 < var2.length) {
				var8 = var2[var3++];
				if (var8.startsWith("@")) {
					List var13 = c(var1, var8);
					Iterator var10 = var13.iterator();

					while (var10.hasNext()) {
						Entity var11 = (Entity) var10.next();
						String var12 = e(var1, var11.aJ().toString());
						if (var4.a(var12, var5)) {
							var6.add(var12);
						} else {
							var7.add(var12);
						}
					}
				} else {
					String var9 = e(var1, var8);
					if (var4.a(var9, var5)) {
						var6.add(var9);
					} else {
						var7.add(var9);
					}
				}
			}
		}

		if (!var6.isEmpty()) {
			var1.a(ag.c, var6.size());
			a(var1, this, "commands.scoreboard.teams.join.success", new Object[] { Integer.valueOf(var6.size()), var5, a(var6.toArray(new String[0])) });
		}

		if (!var7.isEmpty()) {
			throw new di("commands.scoreboard.teams.join.failure", new Object[] { Integer.valueOf(var7.size()), var5, a(var7.toArray(new String[0])) });
		}
	}

	protected void h(CommandSenderInterface var1, String[] var2, int var3) throws di {
		Scoreboard var4 = this.d();
		HashSet var5 = Sets.newHashSet();
		HashSet var6 = Sets.newHashSet();
		String var7;
		if (var1 instanceof EntityHuman && var3 == var2.length) {
			var7 = b(var1).getName();
			if (var4.f(var7)) {
				var5.add(var7);
			} else {
				var6.add(var7);
			}
		} else {
			while (var3 < var2.length) {
				var7 = var2[var3++];
				if (var7.startsWith("@")) {
					List var12 = c(var1, var7);
					Iterator var9 = var12.iterator();

					while (var9.hasNext()) {
						Entity var10 = (Entity) var9.next();
						String var11 = e(var1, var10.aJ().toString());
						if (var4.f(var11)) {
							var5.add(var11);
						} else {
							var6.add(var11);
						}
					}
				} else {
					String var8 = e(var1, var7);
					if (var4.f(var8)) {
						var5.add(var8);
					} else {
						var6.add(var8);
					}
				}
			}
		}

		if (!var5.isEmpty()) {
			var1.a(ag.c, var5.size());
			a(var1, this, "commands.scoreboard.teams.leave.success", new Object[] { Integer.valueOf(var5.size()), a(var5.toArray(new String[0])) });
		}

		if (!var6.isEmpty()) {
			throw new di("commands.scoreboard.teams.leave.failure", new Object[] { Integer.valueOf(var6.size()), a(var6.toArray(new String[0])) });
		}
	}

	protected void i(CommandSenderInterface var1, String[] var2, int var3) throws di {
		Scoreboard var4 = this.d();
		ScoreboardTeam var5 = this.e(var2[var3]);
		if (var5 != null) {
			ArrayList var6 = Lists.newArrayList(var5.getPlayerNameSet());
			var1.a(ag.c, var6.size());
			if (var6.isEmpty()) {
				throw new di("commands.scoreboard.teams.empty.alreadyEmpty", new Object[] { var5.getName() });
			} else {
				Iterator var7 = var6.iterator();

				while (var7.hasNext()) {
					String var8 = (String) var7.next();
					var4.a(var8, var5);
				}

				a(var1, this, "commands.scoreboard.teams.empty.success", new Object[] { Integer.valueOf(var6.size()), var5.getName() });
			}
		}
	}

	protected void h(CommandSenderInterface var1, String var2) throws di {
		Scoreboard var3 = this.d();
		ScoreboardObjective var4 = this.a(var2, false);
		var3.k(var4);
		a(var1, this, "commands.scoreboard.objectives.remove.success", new Object[] { var2 });
	}

	protected void d(CommandSenderInterface var1) throws di {
		Scoreboard var2 = this.d();
		Collection var3 = var2.c();
		if (var3.size() <= 0) {
			throw new di("commands.scoreboard.objectives.list.empty", new Object[0]);
		} else {
			ChatMessage var4 = new ChatMessage("commands.scoreboard.objectives.list.count", new Object[] { Integer.valueOf(var3.size()) });
			var4.getChatModifier().setColor(EnumChatFormat.DARK_GREEN);
			var1.sendChatMessage(var4);
			Iterator var5 = var3.iterator();

			while (var5.hasNext()) {
				ScoreboardObjective var6 = (ScoreboardObjective) var5.next();
				var1.sendChatMessage(new ChatMessage("commands.scoreboard.objectives.list.entry", new Object[] { var6.getName(), var6.getDisplayName(), var6.getCriteria().getName() }));
			}

		}
	}

	protected void j(CommandSenderInterface var1, String[] var2, int var3) throws di {
		Scoreboard var4 = this.d();
		String var5 = var2[var3++];
		int var6 = Scoreboard.i(var5);
		ScoreboardObjective var7 = null;
		if (var2.length == 4) {
			var7 = this.a(var2[var3], false);
		}

		if (var6 < 0) {
			throw new di("commands.scoreboard.objectives.setdisplay.invalidSlot", new Object[] { var5 });
		} else {
			var4.a(var6, var7);
			if (var7 != null) {
				a(var1, this, "commands.scoreboard.objectives.setdisplay.successSet", new Object[] { Scoreboard.b(var6), var7.getName() });
			} else {
				a(var1, this, "commands.scoreboard.objectives.setdisplay.successCleared", new Object[] { Scoreboard.b(var6) });
			}

		}
	}

	protected void k(CommandSenderInterface var1, String[] var2, int var3) throws di {
		Scoreboard var4 = this.d();
		if (var2.length > var3) {
			String var5 = e(var1, var2[var3]);
			Map var6 = var4.c(var5);
			var1.a(ag.e, var6.size());
			if (var6.size() <= 0) {
				throw new di("commands.scoreboard.players.list.player.empty", new Object[] { var5 });
			}

			ChatMessage var7 = new ChatMessage("commands.scoreboard.players.list.player.count", new Object[] { Integer.valueOf(var6.size()), var5 });
			var7.getChatModifier().setColor(EnumChatFormat.DARK_GREEN);
			var1.sendChatMessage(var7);
			Iterator var8 = var6.values().iterator();

			while (var8.hasNext()) {
				ScoreboardScore var9 = (ScoreboardScore) var8.next();
				var1.sendChatMessage(new ChatMessage("commands.scoreboard.players.list.player.entry", new Object[] { Integer.valueOf(var9.getScore()), var9.getObjective().getDisplayName(), var9.getObjective().getName() }));
			}
		} else {
			Collection var10 = var4.d();
			var1.a(ag.e, var10.size());
			if (var10.size() <= 0) {
				throw new di("commands.scoreboard.players.list.empty", new Object[0]);
			}

			ChatMessage var11 = new ChatMessage("commands.scoreboard.players.list.count", new Object[] { Integer.valueOf(var10.size()) });
			var11.getChatModifier().setColor(EnumChatFormat.DARK_GREEN);
			var1.sendChatMessage(var11);
			var1.sendChatMessage(new ChatComponentText(a(var10.toArray())));
		}

	}

	protected void l(CommandSenderInterface var1, String[] var2, int var3) throws di {
		String var4 = var2[var3 - 1];
		int var5 = var3;
		String var6 = e(var1, var2[var3++]);
		ScoreboardObjective var7 = this.a(var2[var3++], true);
		int var8 = var4.equalsIgnoreCase("set") ? a(var2[var3++]) : a(var2[var3++], 0);
		if (var2.length > var3) {
			Entity var9 = b(var1, var2[var5]);

			try {
				NBTCompoundTag var10 = gg.a(a(var2, var3));
				NBTCompoundTag var11 = new NBTCompoundTag();
				var9.write(var11);
				if (!TestforBlockCommand.a(var10, var11, true)) {
					throw new di("commands.scoreboard.players.set.tagMismatch", new Object[] { var6 });
				}
			} catch (gf var12) {
				throw new di("commands.scoreboard.players.set.tagError", new Object[] { var12.getMessage() });
			}
		}

		Scoreboard var13 = this.d();
		ScoreboardScore var14 = var13.c(var6, var7);
		if (var4.equalsIgnoreCase("set")) {
			var14.setScore(var8);
		} else if (var4.equalsIgnoreCase("add")) {
			var14.addScore(var8);
		} else {
			var14.removeScore(var8);
		}

		a(var1, this, "commands.scoreboard.players.set.success", new Object[] { var7.getName(), var6, Integer.valueOf(var14.getScore()) });
	}

	protected void m(CommandSenderInterface var1, String[] var2, int var3) throws di {
		Scoreboard var4 = this.d();
		String var5 = e(var1, var2[var3++]);
		if (var2.length > var3) {
			ScoreboardObjective var6 = this.a(var2[var3++], false);
			var4.d(var5, var6);
			a(var1, this, "commands.scoreboard.players.resetscore.success", new Object[] { var6.getName(), var5 });
		} else {
			var4.d(var5, (ScoreboardObjective) null);
			a(var1, this, "commands.scoreboard.players.reset.success", new Object[] { var5 });
		}

	}

	protected void n(CommandSenderInterface var1, String[] var2, int var3) throws di {
		Scoreboard var4 = this.d();
		String var5 = d(var1, var2[var3++]);
		ScoreboardObjective var6 = this.a(var2[var3], false);
		if (var6.getCriteria() != IScoreboardCriteria.trigger) {
			throw new di("commands.scoreboard.players.enable.noTrigger", new Object[] { var6.getName() });
		} else {
			ScoreboardScore var7 = var4.c(var5, var6);
			var7.setLocked(false);
			a(var1, this, "commands.scoreboard.players.enable.success", new Object[] { var6.getName(), var5 });
		}
	}

	protected void o(CommandSenderInterface var1, String[] var2, int var3) throws di {
		Scoreboard var4 = this.d();
		String var5 = e(var1, var2[var3++]);
		ScoreboardObjective var6 = this.a(var2[var3++], false);
		if (!var4.b(var5, var6)) {
			throw new di("commands.scoreboard.players.test.notFound", new Object[] { var6.getName(), var5 });
		} else {
			int var7 = var2[var3].equals("*") ? Integer.MIN_VALUE : a(var2[var3]);
			++var3;
			int var8 = var3 < var2.length && !var2[var3].equals("*") ? a(var2[var3], var7) : Integer.MAX_VALUE;
			ScoreboardScore var9 = var4.c(var5, var6);
			if (var9.getScore() >= var7 && var9.getScore() <= var8) {
				a(var1, this, "commands.scoreboard.players.test.success", new Object[] { Integer.valueOf(var9.getScore()), Integer.valueOf(var7), Integer.valueOf(var8) });
			} else {
				throw new di("commands.scoreboard.players.test.failed", new Object[] { Integer.valueOf(var9.getScore()), Integer.valueOf(var7), Integer.valueOf(var8) });
			}
		}
	}

	protected void p(CommandSenderInterface var1, String[] var2, int var3) throws di {
		Scoreboard var4 = this.d();
		String var5 = e(var1, var2[var3++]);
		ScoreboardObjective var6 = this.a(var2[var3++], true);
		String var7 = var2[var3++];
		String var8 = e(var1, var2[var3++]);
		ScoreboardObjective var9 = this.a(var2[var3], false);
		ScoreboardScore var10 = var4.c(var5, var6);
		if (!var4.b(var8, var9)) {
			throw new di("commands.scoreboard.players.operation.notFound", new Object[] { var9.getName(), var8 });
		} else {
			ScoreboardScore var11 = var4.c(var8, var9);
			if (var7.equals("+=")) {
				var10.setScore(var10.getScore() + var11.getScore());
			} else if (var7.equals("-=")) {
				var10.setScore(var10.getScore() - var11.getScore());
			} else if (var7.equals("*=")) {
				var10.setScore(var10.getScore() * var11.getScore());
			} else if (var7.equals("/=")) {
				if (var11.getScore() != 0) {
					var10.setScore(var10.getScore() / var11.getScore());
				}
			} else if (var7.equals("%=")) {
				if (var11.getScore() != 0) {
					var10.setScore(var10.getScore() % var11.getScore());
				}
			} else if (var7.equals("=")) {
				var10.setScore(var11.getScore());
			} else if (var7.equals("<")) {
				var10.setScore(Math.min(var10.getScore(), var11.getScore()));
			} else if (var7.equals(">")) {
				var10.setScore(Math.max(var10.getScore(), var11.getScore()));
			} else {
				if (!var7.equals("><")) {
					throw new di("commands.scoreboard.players.operation.invalidOperation", new Object[] { var7 });
				}

				int var12 = var10.getScore();
				var10.setScore(var11.getScore());
				var11.setScore(var12);
			}

			a(var1, this, "commands.scoreboard.players.operation.success", new Object[0]);
		}
	}

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, Position var3) {
		if (var2.length == 1) {
			return a(var2, new String[] { "objectives", "players", "teams" });
		} else {
			if (var2[0].equalsIgnoreCase("objectives")) {
				if (var2.length == 2) {
					return a(var2, new String[] { "list", "add", "remove", "setdisplay" });
				}

				if (var2[1].equalsIgnoreCase("add")) {
					if (var2.length == 4) {
						Set var4 = IScoreboardCriteria.byName.keySet();
						return a(var2, var4);
					}
				} else if (var2[1].equalsIgnoreCase("remove")) {
					if (var2.length == 3) {
						return a(var2, this.a(false));
					}
				} else if (var2[1].equalsIgnoreCase("setdisplay")) {
					if (var2.length == 3) {
						return a(var2, Scoreboard.h());
					}

					if (var2.length == 4) {
						return a(var2, this.a(false));
					}
				}
			} else if (var2[0].equalsIgnoreCase("players")) {
				if (var2.length == 2) {
					return a(var2, new String[] { "set", "add", "remove", "reset", "list", "enable", "test", "operation" });
				}

				if (!var2[1].equalsIgnoreCase("set") && !var2[1].equalsIgnoreCase("add") && !var2[1].equalsIgnoreCase("remove") && !var2[1].equalsIgnoreCase("reset")) {
					if (var2[1].equalsIgnoreCase("enable")) {
						if (var2.length == 3) {
							return a(var2, MinecraftServer.getInstance().I());
						}

						if (var2.length == 4) {
							return a(var2, this.e());
						}
					} else if (!var2[1].equalsIgnoreCase("list") && !var2[1].equalsIgnoreCase("test")) {
						if (var2[1].equalsIgnoreCase("operation")) {
							if (var2.length == 3) {
								return a(var2, this.d().d());
							}

							if (var2.length == 4) {
								return a(var2, this.a(true));
							}

							if (var2.length == 5) {
								return a(var2, new String[] { "+=", "-=", "*=", "/=", "%=", "=", "<", ">", "><" });
							}

							if (var2.length == 6) {
								return a(var2, MinecraftServer.getInstance().I());
							}

							if (var2.length == 7) {
								return a(var2, this.a(false));
							}
						}
					} else {
						if (var2.length == 3) {
							return a(var2, this.d().d());
						}

						if (var2.length == 4 && var2[1].equalsIgnoreCase("test")) {
							return a(var2, this.a(false));
						}
					}
				} else {
					if (var2.length == 3) {
						return a(var2, MinecraftServer.getInstance().I());
					}

					if (var2.length == 4) {
						return a(var2, this.a(true));
					}
				}
			} else if (var2[0].equalsIgnoreCase("teams")) {
				if (var2.length == 2) {
					return a(var2, new String[] { "add", "remove", "join", "leave", "empty", "list", "option" });
				}

				if (var2[1].equalsIgnoreCase("join")) {
					if (var2.length == 3) {
						return a(var2, this.d().f());
					}

					if (var2.length >= 4) {
						return a(var2, MinecraftServer.getInstance().I());
					}
				} else {
					if (var2[1].equalsIgnoreCase("leave")) {
						return a(var2, MinecraftServer.getInstance().I());
					}

					if (!var2[1].equalsIgnoreCase("empty") && !var2[1].equalsIgnoreCase("list") && !var2[1].equalsIgnoreCase("remove")) {
						if (var2[1].equalsIgnoreCase("option")) {
							if (var2.length == 3) {
								return a(var2, this.d().f());
							}

							if (var2.length == 4) {
								return a(var2, new String[] { "FormattingCode", "friendlyfire", "seeFriendlyInvisibles", "nametagVisibility", "deathMessageVisibility" });
							}

							if (var2.length == 5) {
								if (var2[3].equalsIgnoreCase("FormattingCode")) {
									return a(var2, EnumChatFormat.getCodes(true, false));
								}

								if (var2[3].equalsIgnoreCase("nametagVisibility") || var2[3].equalsIgnoreCase("deathMessageVisibility")) {
									return a(var2, ScoreboardTeamNameTagVisibility.getNames());
								}

								if (var2[3].equalsIgnoreCase("friendlyfire") || var2[3].equalsIgnoreCase("seeFriendlyInvisibles")) {
									return a(var2, new String[] { "true", "false" });
								}
							}
						}
					} else if (var2.length == 3) {
						return a(var2, this.d().f());
					}
				}
			}

			return null;
		}
	}

	protected List a(boolean var1) {
		Collection var2 = this.d().c();
		ArrayList var3 = Lists.newArrayList();
		Iterator var4 = var2.iterator();

		while (var4.hasNext()) {
			ScoreboardObjective var5 = (ScoreboardObjective) var4.next();
			if (!var1 || !var5.getCriteria().isReadOnly()) {
				var3.add(var5.getName());
			}
		}

		return var3;
	}

	protected List e() {
		Collection var1 = this.d().c();
		ArrayList var2 = Lists.newArrayList();
		Iterator var3 = var1.iterator();

		while (var3.hasNext()) {
			ScoreboardObjective var4 = (ScoreboardObjective) var3.next();
			if (var4.getCriteria() == IScoreboardCriteria.trigger) {
				var2.add(var4.getName());
			}
		}

		return var2;
	}

	public boolean b(String[] var1, int var2) {
		return !var1[0].equalsIgnoreCase("players") ? (var1[0].equalsIgnoreCase("teams") ? var2 == 2 : false) : (var1.length > 1 && var1[1].equalsIgnoreCase("operation") ? var2 == 2 || var2 == 5 : var2 == 2);
	}
}
