package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.server.MinecraftServer;

public class pk extends Scoreboard {

	private final MinecraftServer a;
	private final Set b = Sets.newHashSet();
	private bse c;

	public pk(MinecraftServer var1) {
		this.a = var1;
	}

	public void handleScoreChanged(ScoreboardScore var1) {
		super.handleScoreChanged(var1);
		if (this.b.contains(var1.getObjective())) {
			this.a.getPlayerList().sendPacket((Packet) (new PacketPlayOutUpdateScore(var1)));
		}

		this.b();
	}

	public void a(String var1) {
		super.a(var1);
		this.a.getPlayerList().sendPacket((Packet) (new PacketPlayOutUpdateScore(var1)));
		this.b();
	}

	public void a(String var1, ScoreboardObjective var2) {
		super.a(var1, var2);
		this.a.getPlayerList().sendPacket((Packet) (new PacketPlayOutUpdateScore(var1, var2)));
		this.b();
	}

	public void a(int var1, ScoreboardObjective var2) {
		ScoreboardObjective var3 = this.a(var1);
		super.a(var1, var2);
		if (var3 != var2 && var3 != null) {
			if (this.h(var3) > 0) {
				this.a.getPlayerList().sendPacket((Packet) (new PacketPlayOutDisplayScoreboard(var1, var2)));
			} else {
				this.g(var3);
			}
		}

		if (var2 != null) {
			if (this.b.contains(var2)) {
				this.a.getPlayerList().sendPacket((Packet) (new PacketPlayOutDisplayScoreboard(var1, var2)));
			} else {
				this.e(var2);
			}
		}

		this.b();
	}

	public boolean a(String var1, String var2) {
		if (super.a(var1, var2)) {
			ScoreboardTeam var3 = this.d(var2);
			this.a.getPlayerList().sendPacket((Packet) (new PacketPlayOutScoreboardTeam(var3, Arrays.asList(new String[] { var1 }), 3)));
			this.b();
			return true;
		} else {
			return false;
		}
	}

	public void a(String var1, ScoreboardTeam var2) {
		super.a(var1, var2);
		this.a.getPlayerList().sendPacket((Packet) (new PacketPlayOutScoreboardTeam(var2, Arrays.asList(new String[] { var1 }), 4)));
		this.b();
	}

	public void a(ScoreboardObjective var1) {
		super.a(var1);
		this.b();
	}

	public void b(ScoreboardObjective var1) {
		super.b(var1);
		if (this.b.contains(var1)) {
			this.a.getPlayerList().sendPacket((Packet) (new PacketPlayOutScoreboardObjective(var1, 2)));
		}

		this.b();
	}

	public void c(ScoreboardObjective var1) {
		super.c(var1);
		if (this.b.contains(var1)) {
			this.g(var1);
		}

		this.b();
	}

	public void a(ScoreboardTeam var1) {
		super.a(var1);
		this.a.getPlayerList().sendPacket((Packet) (new PacketPlayOutScoreboardTeam(var1, 0)));
		this.b();
	}

	public void handleTeamChanged(ScoreboardTeam var1) {
		super.handleTeamChanged(var1);
		this.a.getPlayerList().sendPacket((Packet) (new PacketPlayOutScoreboardTeam(var1, 2)));
		this.b();
	}

	public void c(ScoreboardTeam var1) {
		super.c(var1);
		this.a.getPlayerList().sendPacket((Packet) (new PacketPlayOutScoreboardTeam(var1, 1)));
		this.b();
	}

	public void a(bse var1) {
		this.c = var1;
	}

	protected void b() {
		if (this.c != null) {
			this.c.c();
		}

	}

	public List d(ScoreboardObjective var1) {
		ArrayList var2 = Lists.newArrayList();
		var2.add(new PacketPlayOutScoreboardObjective(var1, 0));

		for (int var3 = 0; var3 < 19; ++var3) {
			if (this.a(var3) == var1) {
				var2.add(new PacketPlayOutDisplayScoreboard(var3, var1));
			}
		}

		Iterator var5 = this.i(var1).iterator();

		while (var5.hasNext()) {
			ScoreboardScore var4 = (ScoreboardScore) var5.next();
			var2.add(new PacketPlayOutUpdateScore(var4));
		}

		return var2;
	}

	public void e(ScoreboardObjective var1) {
		List var2 = this.d(var1);
		Iterator var3 = this.a.getPlayerList().players.iterator();

		while (var3.hasNext()) {
			EntityPlayer var4 = (EntityPlayer) var3.next();
			Iterator var5 = var2.iterator();

			while (var5.hasNext()) {
				Packet var6 = (Packet) var5.next();
				var4.playerConncetion.sendPacket(var6);
			}
		}

		this.b.add(var1);
	}

	public List f(ScoreboardObjective var1) {
		ArrayList var2 = Lists.newArrayList();
		var2.add(new PacketPlayOutScoreboardObjective(var1, 1));

		for (int var3 = 0; var3 < 19; ++var3) {
			if (this.a(var3) == var1) {
				var2.add(new PacketPlayOutDisplayScoreboard(var3, var1));
			}
		}

		return var2;
	}

	public void g(ScoreboardObjective var1) {
		List var2 = this.f(var1);
		Iterator var3 = this.a.getPlayerList().players.iterator();

		while (var3.hasNext()) {
			EntityPlayer var4 = (EntityPlayer) var3.next();
			Iterator var5 = var2.iterator();

			while (var5.hasNext()) {
				Packet var6 = (Packet) var5.next();
				var4.playerConncetion.sendPacket(var6);
			}
		}

		this.b.remove(var1);
	}

	public int h(ScoreboardObjective var1) {
		int var2 = 0;

		for (int var3 = 0; var3 < 19; ++var3) {
			if (this.a(var3) == var1) {
				++var2;
			}
		}

		return var2;
	}
}
