package net.minecraft;

import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import java.util.List;

public class PacketPlayOutListItem implements Packet<PlayOutPacketListener> {

	private ListItemAction action;
	private final List<ListEntry> entries = Lists.newArrayList();

	public PacketPlayOutListItem() {
	}

	public PacketPlayOutListItem(ListItemAction action, EntityPlayer... players) {
		this.action = action;
		for (EntityPlayer player : players) {
			entries.add(new ListEntry(player.getGameProfile(), player.ping, player.playerInteractManager.getGameMode(), player.getPlayerListName()));
		}
	}

	public PacketPlayOutListItem(ListItemAction action, Iterable<EntityPlayer> players) {
		this.action = action;
		for (EntityPlayer player : players) {
			entries.add(new ListEntry(player.getGameProfile(), player.ping, player.playerInteractManager.getGameMode(), player.getPlayerListName()));
		}
	}

	public void readData(PacketDataSerializer serializer) {
		this.action = (ListItemAction) serializer.readEnum(ListItemAction.class);
		int count = serializer.readVarInt();

		for (int i = 0; i < count; ++i) {
			GameProfile profile = null;
			int ping = 0;
			GameMode gameMode = null;
			IChatBaseComponent listName = null;
			switch (action) {
				case ADD_PLAYER: {
					profile = new GameProfile(serializer.readUUID(), serializer.readString(16));
					int propertyCount = serializer.readVarInt();

					for (int j = 0; j < propertyCount; ++j) {
						String propertyName = serializer.readString(32767);
						String propertyValue = serializer.readString(32767);
						if (serializer.readBoolean()) {
							profile.getProperties().put(propertyName, new Property(propertyName, propertyValue, serializer.readString(32767)));
						} else {
							profile.getProperties().put(propertyName, new Property(propertyName, propertyValue));
						}
					}

					gameMode = GameMode.getById(serializer.readVarInt());
					ping = serializer.readVarInt();
					if (serializer.readBoolean()) {
						listName = serializer.readJSONComponent();
					}
					break;
				}
				case UPDATE_GAME_MODE: {
					profile = new GameProfile(serializer.readUUID(), (String) null);
					gameMode = GameMode.getById(serializer.readVarInt());
					break;
				}
				case UPDATE_LATENCY: {
					profile = new GameProfile(serializer.readUUID(), (String) null);
					ping = serializer.readVarInt();
					break;
				}
				case UPDATE_DISPLAY_NAME: {
					profile = new GameProfile(serializer.readUUID(), (String) null);
					if (serializer.readBoolean()) {
						listName = serializer.readJSONComponent();
					}
					break;
				}
				case REMOVE_PLAYER: {
					profile = new GameProfile(serializer.readUUID(), (String) null);
					break;
				}
			}

			this.entries.add(new ListEntry(profile, ping, gameMode, listName));
		}

	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeEnum(action);
		serializer.writeVarInt(entries.size());

		for (ListEntry listentry : entries) {
			switch (action) {
				case ADD_PLAYER: {
					serializer.writeUUID(listentry.getGameProfile().getId());
					serializer.writeString(listentry.getGameProfile().getName());
					serializer.writeVarInt(listentry.getGameProfile().getProperties().size());

					for (Property property : listentry.getGameProfile().getProperties().values()) {
						serializer.writeString(property.getName());
						serializer.writeString(property.getValue());
						if (property.hasSignature()) {
							serializer.writeBoolean(true);
							serializer.writeString(property.getSignature());
						} else {
							serializer.writeBoolean(false);
						}
					}

					serializer.writeVarInt(listentry.getGameMode().getId());
					serializer.writeVarInt(listentry.getPing());
					if (listentry.getListName() == null) {
						serializer.writeBoolean(false);
					} else {
						serializer.writeBoolean(true);
						serializer.writeJSONComponent(listentry.getListName());
					}
					break;
				}
				case UPDATE_GAME_MODE: {
					serializer.writeUUID(listentry.getGameProfile().getId());
					serializer.writeVarInt(listentry.getGameMode().getId());
					break;
				}
				case UPDATE_LATENCY: {
					serializer.writeUUID(listentry.getGameProfile().getId());
					serializer.writeVarInt(listentry.getPing());
					break;
				}
				case UPDATE_DISPLAY_NAME: {
					serializer.writeUUID(listentry.getGameProfile().getId());
					if (listentry.getListName() == null) {
						serializer.writeBoolean(false);
					} else {
						serializer.writeBoolean(true);
						serializer.writeJSONComponent(listentry.getListName());
					}
					break;
				}
				case REMOVE_PLAYER: {
					serializer.writeUUID(listentry.getGameProfile().getId());
				}
			}
		}

	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

	public static enum ListItemAction {
		ADD_PLAYER, UPDATE_GAME_MODE, UPDATE_LATENCY, UPDATE_DISPLAY_NAME, REMOVE_PLAYER;
	}

	private static class ListEntry {

		private final int ping;
		private final GameMode gameMode;
		private final GameProfile gameProfile;
		private final IChatBaseComponent listname;

		public ListEntry(GameProfile gameProfile, int ping, GameMode gameMode, IChatBaseComponent listname) {
			this.gameProfile = gameProfile;
			this.ping = ping;
			this.gameMode = gameMode;
			this.listname = listname;
		}

		public GameProfile getGameProfile() {
			return this.gameProfile;
		}

		public int getPing() {
			return this.ping;
		}

		public GameMode getGameMode() {
			return this.gameMode;
		}

		public IChatBaseComponent getListName() {
			return this.listname;
		}

	}

}
