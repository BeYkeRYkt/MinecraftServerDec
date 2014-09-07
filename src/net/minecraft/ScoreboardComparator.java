package net.minecraft;

import java.util.Comparator;

final class ScoreboardComparator implements Comparator<ScoreboardScore> {

	public int compare(ScoreboardScore score1, ScoreboardScore score2) {
		return score1.getScore() > score2.getScore() ? 1 : (score1.getScore() < score2.getScore() ? -1 : score2.getPlayerName().compareToIgnoreCase(score1.getPlayerName()));
	}

}
