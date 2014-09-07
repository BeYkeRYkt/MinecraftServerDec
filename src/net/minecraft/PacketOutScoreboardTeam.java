package net.minecraft;

import com.google.common.collect.Lists;

import java.util.Collection;

public class PacketOutScoreboardTeam implements Packet<PlayClientboundPacketListener> {

	private String name = "";
	private String displayName = "";
	private String prefix = "";
	private String suffix = "";
	private String visibility;
	private int color;
	private Collection<String> players;
	private int mode;
	private int optionData;

	public PacketOutScoreboardTeam() {
		this.visibility = ScoreboardTeamNameTagVisibility.ALWAYS.name;
		this.color = -1;
		this.players = Lists.newArrayList();
	}

	public PacketOutScoreboardTeam(ScoreboardTeam team, int mode) {
		this.visibility = ScoreboardTeamNameTagVisibility.ALWAYS.name;
		this.color = -1;
		this.players = Lists.newArrayList();
		this.name = team.getName();
		this.mode = mode;
		if (mode == 0 || mode == 2) {
			this.displayName = team.getDisplayName();
			this.prefix = team.getPrefix();
			this.suffix = team.getSuffix();
			this.optionData = team.packOptionData();
			this.visibility = team.getTagVisibility().name;
			this.color = team.getColor().getId();
		}

		if (mode == 0) {
			this.players.addAll(team.getPlayerNameSet());
		}
	}

	public PacketOutScoreboardTeam(ScoreboardTeam team, Collection<String> players, int mode) {
		this.visibility = ScoreboardTeamNameTagVisibility.ALWAYS.name;
		this.color = -1;
		this.players = Lists.newArrayList();
		if (mode != 3 && mode != 4) {
			throw new IllegalArgumentException("Method must be join or leave for player constructor");
		} else if (players != null && !players.isEmpty()) {
			this.mode = mode;
			this.name = team.getName();
			this.players.addAll(players);
		} else {
			throw new IllegalArgumentException("Players cannot be null/empty");
		}
	}

	public void readData(PacketDataSerializer serializer) {
		this.name = serializer.readString(16);
		this.mode = serializer.readByte();
		if (this.mode == 0 || this.mode == 2) {
			this.displayName = serializer.readString(32);
			this.prefix = serializer.readString(16);
			this.suffix = serializer.readString(16);
			this.optionData = serializer.readByte();
			this.visibility = serializer.readString(32);
			this.color = serializer.readByte();
		}

		if (this.mode == 0 || this.mode == 3 || this.mode == 4) {
			int playersCount = serializer.readVarInt();

			for (int i = 0; i < playersCount; ++i) {
				this.players.add(serializer.readString(40));
			}
		}
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeString(this.name);
		serializer.writeByte(this.mode);
		if (this.mode == 0 || this.mode == 2) {
			serializer.writeString(this.displayName);
			serializer.writeString(this.prefix);
			serializer.writeString(this.suffix);
			serializer.writeByte(this.optionData);
			serializer.writeString(this.visibility);
			serializer.writeByte(this.color);
		}

		if (this.mode == 0 || this.mode == 3 || this.mode == 4) {
			serializer.writeVarInt(this.players.size());

			for (String player : this.players) {
				serializer.writeString(player);
			}
		}

	}

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

}
