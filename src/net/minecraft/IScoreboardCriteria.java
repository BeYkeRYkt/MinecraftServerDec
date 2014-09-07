package net.minecraft;

import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;

public interface IScoreboardCriteria {

	Map<String, IScoreboardCriteria> byName = Maps.newHashMap();
	IScoreboardCriteria dummy = new ScoreboardBaseCriteria("dummy");
	IScoreboardCriteria trigger = new ScoreboardBaseCriteria("trigger");
	IScoreboardCriteria deathCount = new ScoreboardBaseCriteria("deathCount");
	IScoreboardCriteria playerKillCount = new ScoreboardBaseCriteria("playerKillCount");
	IScoreboardCriteria totalKillCount = new ScoreboardBaseCriteria("totalKillCount");
	IScoreboardCriteria health = new ScoreboardHealthCriteria("health");
	IScoreboardCriteria[] teamKill = new IScoreboardCriteria[] { 
		new ScoreboardKillCriteria("teamkill.", EnumChatFormat.BLACK), 
		new ScoreboardKillCriteria("teamkill.", EnumChatFormat.DARK_BLUE), 
		new ScoreboardKillCriteria("teamkill.", EnumChatFormat.DARK_GREEN), 
		new ScoreboardKillCriteria("teamkill.", EnumChatFormat.DARK_AQUA), 
		new ScoreboardKillCriteria("teamkill.", EnumChatFormat.DARK_RED), 
		new ScoreboardKillCriteria("teamkill.", EnumChatFormat.DARK_PURPLE), 
		new ScoreboardKillCriteria("teamkill.", EnumChatFormat.GOLD), 
		new ScoreboardKillCriteria("teamkill.", EnumChatFormat.GRAY), 
		new ScoreboardKillCriteria("teamkill.", EnumChatFormat.DARK_GRAY), 
		new ScoreboardKillCriteria("teamkill.", EnumChatFormat.BLUE), 
		new ScoreboardKillCriteria("teamkill.", EnumChatFormat.GREEN), 
		new ScoreboardKillCriteria("teamkill.", EnumChatFormat.AQUA), 
		new ScoreboardKillCriteria("teamkill.", EnumChatFormat.RED), 
		new ScoreboardKillCriteria("teamkill.", EnumChatFormat.LIGHT_PURPLE), 
		new ScoreboardKillCriteria("teamkill.", EnumChatFormat.YELLOW), 
		new ScoreboardKillCriteria("teamkill.", EnumChatFormat.WHITE) 
	};
	IScoreboardCriteria[] killedByTeam = new IScoreboardCriteria[] { 
		new ScoreboardKillCriteria("killedByTeam.", EnumChatFormat.BLACK), 
		new ScoreboardKillCriteria("killedByTeam.", EnumChatFormat.DARK_BLUE), 
		new ScoreboardKillCriteria("killedByTeam.", EnumChatFormat.DARK_GREEN), 
		new ScoreboardKillCriteria("killedByTeam.", EnumChatFormat.DARK_AQUA), 
		new ScoreboardKillCriteria("killedByTeam.", EnumChatFormat.DARK_RED), 
		new ScoreboardKillCriteria("killedByTeam.", EnumChatFormat.DARK_PURPLE), 
		new ScoreboardKillCriteria("killedByTeam.", EnumChatFormat.GOLD), 
		new ScoreboardKillCriteria("killedByTeam.", EnumChatFormat.GRAY), 
		new ScoreboardKillCriteria("killedByTeam.", EnumChatFormat.DARK_GRAY), 
		new ScoreboardKillCriteria("killedByTeam.", EnumChatFormat.BLUE), 
		new ScoreboardKillCriteria("killedByTeam.", EnumChatFormat.GREEN), 
		new ScoreboardKillCriteria("killedByTeam.", EnumChatFormat.AQUA), 
		new ScoreboardKillCriteria("killedByTeam.", EnumChatFormat.RED), 
		new ScoreboardKillCriteria("killedByTeam.", EnumChatFormat.LIGHT_PURPLE), 
		new ScoreboardKillCriteria("killedByTeam.", EnumChatFormat.YELLOW),
		new ScoreboardKillCriteria("killedByTeam.", EnumChatFormat.WHITE) 
	};

	String getName();

	int getScoreModifier(List<EntityHuman> list);

	boolean isReadOnly();

	bsl c();

}
