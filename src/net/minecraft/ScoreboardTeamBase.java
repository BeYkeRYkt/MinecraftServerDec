package net.minecraft;

import java.util.Collection;

public abstract class ScoreboardTeamBase {

	public boolean a(ScoreboardTeamBase var1) {
		return var1 == null ? false : this == var1;
	}

	public abstract String getName();

	public abstract String getFormattedName(String var1);

	public abstract boolean allowFriendlyFire();

	public abstract Collection getPlayerNameSet();

	public abstract ScoreboardTeamNameTagVisibility getDeathMessageVisibility();
}
