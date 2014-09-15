package net.minecraft;

import com.google.common.collect.Sets;

import java.util.Collection;
import java.util.Set;

public class ScoreboardTeam extends ScoreboardTeamBase {

	private final Scoreboard scoreboard;
	private final String name;
	private final Set<String> players = Sets.newHashSet();
	private String displayName;
	private String prefix = "";
	private String suffix = "";
	private boolean allowFriendlyFire = true;
	private boolean canSeeFriendlyInvisibles = true;
	private ScoreboardTeamNameTagVisibility tagVisibility;
	private ScoreboardTeamNameTagVisibility deathMessageVisibility;
	private EnumChatFormat color;

	public ScoreboardTeam(Scoreboard scoreboard, String name) {
		this.tagVisibility = ScoreboardTeamNameTagVisibility.ALWAYS;
		this.deathMessageVisibility = ScoreboardTeamNameTagVisibility.ALWAYS;
		this.color = EnumChatFormat.RESET;
		this.scoreboard = scoreboard;
		this.name = name;
		this.displayName = name;
	}

	public String getName() {
		return this.name;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		if (displayName == null) {
			throw new IllegalArgumentException("Name cannot be null");
		} else {
			this.displayName = displayName;
			this.scoreboard.handleTeamChanged(this);
		}
	}

	public Collection<String> getPlayerNameSet() {
		return this.players;
	}

	public String getPrefix() {
		return this.prefix;
	}

	public void setPrefix(String suffix) {
		if (suffix == null) {
			throw new IllegalArgumentException("Prefix cannot be null");
		} else {
			this.prefix = suffix;
			this.scoreboard.handleTeamChanged(this);
		}
	}

	public String getSuffix() {
		return this.suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
		this.scoreboard.handleTeamChanged(this);
	}

	public String getFormattedName(String name) {
		return this.getPrefix() + name + this.getSuffix();
	}

	public static String getPlayerDisplayName(ScoreboardTeamBase teamBase, String name) {
		return teamBase == null ? name : teamBase.getFormattedName(name);
	}

	public boolean allowFriendlyFire() {
		return this.allowFriendlyFire;
	}

	public void setAllowFriendlyFire(boolean allowFriendlyFire) {
		this.allowFriendlyFire = allowFriendlyFire;
		this.scoreboard.handleTeamChanged(this);
	}

	public boolean canSeeFriendlyInvisibles() {
		return this.canSeeFriendlyInvisibles;
	}

	public void setCanSeeFriendlyInvisibles(boolean canSeeFriendlyInvisibles) {
		this.canSeeFriendlyInvisibles = canSeeFriendlyInvisibles;
		this.scoreboard.handleTeamChanged(this);
	}

	public ScoreboardTeamNameTagVisibility getTagVisibility() {
		return this.tagVisibility;
	}

	public ScoreboardTeamNameTagVisibility getDeathMessageVisibility() {
		return this.deathMessageVisibility;
	}

	public void setTagVisibility(ScoreboardTeamNameTagVisibility tagVisibility) {
		this.tagVisibility = tagVisibility;
		this.scoreboard.handleTeamChanged(this);
	}

	public void setDeathMessageVisibility(ScoreboardTeamNameTagVisibility deathMessageVisibility) {
		this.deathMessageVisibility = deathMessageVisibility;
		this.scoreboard.handleTeamChanged(this);
	}

	public int packOptionData() {
		int i = 0;
		if (this.allowFriendlyFire()) {
			i |= 1;
		}
		if (this.canSeeFriendlyInvisibles()) {
			i |= 2;
		}
		return i;
	}

	public void setColor(EnumChatFormat color) {
		this.color = color;
	}

	public EnumChatFormat getColor() {
		return this.color;
	}

}
