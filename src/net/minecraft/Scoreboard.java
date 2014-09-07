package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Scoreboard {

	private final Map<String, ScoreboardObjective> a = Maps.newHashMap();
	private final Map<IScoreboardCriteria, Object> b = Maps.newHashMap();
	private final Map<String, Object> c = Maps.newHashMap();
	private final ScoreboardObjective[] d = new ScoreboardObjective[19];
	private final Map<String, ScoreboardTeam> e = Maps.newHashMap();
	private final Map<String, ScoreboardTeam> f = Maps.newHashMap();
	private static String[] g = null;

	public ScoreboardObjective b(String var1) {
		return (ScoreboardObjective) this.a.get(var1);
	}

	public ScoreboardObjective a(String var1, IScoreboardCriteria var2) {
		ScoreboardObjective var3 = this.b(var1);
		if (var3 != null) {
			throw new IllegalArgumentException("An objective with the name \'" + var1 + "\' already exists!");
		} else {
			var3 = new ScoreboardObjective(this, var1, var2);
			Object var4 = (List) this.b.get(var2);
			if (var4 == null) {
				var4 = Lists.newArrayList();
				this.b.put(var2, var4);
			}

			((List) var4).add(var3);
			this.a.put(var1, var3);
			this.a(var3);
			return var3;
		}
	}

	public Collection a(IScoreboardCriteria var1) {
		Collection var2 = (Collection) this.b.get(var1);
		return var2 == null ? Lists.newArrayList() : Lists.newArrayList((Iterable) var2);
	}

	public boolean b(String var1, ScoreboardObjective var2) {
		Map var3 = (Map) this.c.get(var1);
		if (var3 == null) {
			return false;
		} else {
			ScoreboardScore var4 = (ScoreboardScore) var3.get(var2);
			return var4 != null;
		}
	}

	public ScoreboardScore c(String var1, ScoreboardObjective var2) {
		Object var3 = (Map) this.c.get(var1);
		if (var3 == null) {
			var3 = Maps.newHashMap();
			this.c.put(var1, var3);
		}

		ScoreboardScore var4 = (ScoreboardScore) ((Map) var3).get(var2);
		if (var4 == null) {
			var4 = new ScoreboardScore(this, var2, var1);
			((Map) var3).put(var2, var4);
		}

		return var4;
	}

	public Collection i(ScoreboardObjective var1) {
		ArrayList var2 = Lists.newArrayList();
		Iterator var3 = this.c.values().iterator();

		while (var3.hasNext()) {
			Map var4 = (Map) var3.next();
			ScoreboardScore var5 = (ScoreboardScore) var4.get(var1);
			if (var5 != null) {
				var2.add(var5);
			}
		}

		Collections.sort(var2, ScoreboardScore.scoreboardComparator);
		return var2;
	}

	public Collection c() {
		return this.a.values();
	}

	public Collection d() {
		return this.c.keySet();
	}

	public void d(String var1, ScoreboardObjective var2) {
		Map var3;
		if (var2 == null) {
			var3 = (Map) this.c.remove(var1);
			if (var3 != null) {
				this.a(var1);
			}
		} else {
			var3 = (Map) this.c.get(var1);
			if (var3 != null) {
				ScoreboardScore var4 = (ScoreboardScore) var3.remove(var2);
				if (var3.size() < 1) {
					Map var5 = (Map) this.c.remove(var1);
					if (var5 != null) {
						this.a(var1);
					}
				} else if (var4 != null) {
					this.a(var1, var2);
				}
			}
		}

	}

	public Collection e() {
		Collection var1 = this.c.values();
		ArrayList var2 = Lists.newArrayList();
		Iterator var3 = var1.iterator();

		while (var3.hasNext()) {
			Map var4 = (Map) var3.next();
			var2.addAll(var4.values());
		}

		return var2;
	}

	public Map c(String var1) {
		Object var2 = (Map) this.c.get(var1);
		if (var2 == null) {
			var2 = Maps.newHashMap();
		}

		return (Map) var2;
	}

	public void k(ScoreboardObjective var1) {
		this.a.remove(var1.getName());

		for (int var2 = 0; var2 < 19; ++var2) {
			if (this.a(var2) == var1) {
				this.a(var2, (ScoreboardObjective) null);
			}
		}

		List var5 = (List) this.b.get(var1.getCriteria());
		if (var5 != null) {
			var5.remove(var1);
		}

		Iterator var3 = this.c.values().iterator();

		while (var3.hasNext()) {
			Map var4 = (Map) var3.next();
			var4.remove(var1);
		}

		this.c(var1);
	}

	public void a(int var1, ScoreboardObjective var2) {
		this.d[var1] = var2;
	}

	public ScoreboardObjective a(int var1) {
		return this.d[var1];
	}

	public ScoreboardTeam d(String var1) {
		return (ScoreboardTeam) this.e.get(var1);
	}

	public ScoreboardTeam e(String var1) {
		ScoreboardTeam var2 = this.d(var1);
		if (var2 != null) {
			throw new IllegalArgumentException("A team with the name \'" + var1 + "\' already exists!");
		} else {
			var2 = new ScoreboardTeam(this, var1);
			this.e.put(var1, var2);
			this.a(var2);
			return var2;
		}
	}

	public void d(ScoreboardTeam var1) {
		this.e.remove(var1.getName());
		Iterator var2 = var1.getPlayerNameSet().iterator();

		while (var2.hasNext()) {
			String var3 = (String) var2.next();
			this.f.remove(var3);
		}

		this.c(var1);
	}

	public boolean a(String var1, String var2) {
		if (!this.e.containsKey(var2)) {
			return false;
		} else {
			ScoreboardTeam var3 = this.d(var2);
			if (this.h(var1) != null) {
				this.f(var1);
			}

			this.f.put(var1, var3);
			var3.getPlayerNameSet().add(var1);
			return true;
		}
	}

	public boolean f(String var1) {
		ScoreboardTeam var2 = this.h(var1);
		if (var2 != null) {
			this.a(var1, var2);
			return true;
		} else {
			return false;
		}
	}

	public void a(String var1, ScoreboardTeam var2) {
		if (this.h(var1) != var2) {
			throw new IllegalStateException("Player is either on another team or not on any team. Cannot remove from team \'" + var2.getName() + "\'.");
		} else {
			this.f.remove(var1);
			var2.getPlayerNameSet().remove(var1);
		}
	}

	public Collection f() {
		return this.e.keySet();
	}

	public Collection g() {
		return this.e.values();
	}

	public ScoreboardTeam h(String var1) {
		return (ScoreboardTeam) this.f.get(var1);
	}

	public void a(ScoreboardObjective var1) {
	}

	public void b(ScoreboardObjective var1) {
	}

	public void c(ScoreboardObjective var1) {
	}

	public void handleScoreChanged(ScoreboardScore var1) {
	}

	public void a(String var1) {
	}

	public void a(String var1, ScoreboardObjective var2) {
	}

	public void a(ScoreboardTeam var1) {
	}

	public void handleTeamChanged(ScoreboardTeam var1) {
	}

	public void c(ScoreboardTeam var1) {
	}

	public static String b(int var0) {
		switch (var0) {
			case 0:
				return "list";
			case 1:
				return "sidebar";
			case 2:
				return "belowName";
			default:
				if (var0 >= 3 && var0 <= 18) {
					EnumChatFormat var1 = EnumChatFormat.getById(var0 - 3);
					if (var1 != null && var1 != EnumChatFormat.RESET) {
						return "sidebar.team." + var1.getEnumLCName();
					}
				}

				return null;
		}
	}

	public static int i(String var0) {
		if (var0.equalsIgnoreCase("list")) {
			return 0;
		} else if (var0.equalsIgnoreCase("sidebar")) {
			return 1;
		} else if (var0.equalsIgnoreCase("belowName")) {
			return 2;
		} else {
			if (var0.startsWith("sidebar.team.")) {
				String var1 = var0.substring("sidebar.team.".length());
				EnumChatFormat var2 = EnumChatFormat.getByName(var1);
				if (var2 != null && var2.getId() >= 0) {
					return var2.getId() + 3;
				}
			}

			return -1;
		}
	}

	public static String[] h() {
		if (g == null) {
			g = new String[19];

			for (int var0 = 0; var0 < 19; ++var0) {
				g[var0] = b(var0);
			}
		}

		return g;
	}

}
