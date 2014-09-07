package net.minecraft;

public class PacketPlayOutTitle implements Packet<PlayOutPacketListener> {

	private TitleAction action;
	private IChatBaseComponent value;
	private int fadeIn;
	private int stay;
	private int fadeOut;

	public PacketPlayOutTitle() {
	}

	public PacketPlayOutTitle(TitleAction action, IChatBaseComponent value) {
		this(action, value, -1, -1, -1);
	}

	public PacketPlayOutTitle(int fadeIn, int stay, int fadeOut) {
		this(TitleAction.TIMES, (IChatBaseComponent) null, fadeIn, stay, fadeOut);
	}

	public PacketPlayOutTitle(TitleAction action, IChatBaseComponent value, int fadeIn, int stay, int fadeOut) {
		this.action = action;
		this.value = value;
		this.fadeIn = fadeIn;
		this.stay = stay;
		this.fadeOut = fadeOut;
	}

	public void readData(PacketDataSerializer serializer) {
		this.action = (TitleAction) serializer.readEnum(TitleAction.class);
		if (this.action == TitleAction.TITLE || this.action == TitleAction.SUBTITLE) {
			this.value = serializer.readJSONComponent();
		}

		if (this.action == TitleAction.TIMES) {
			this.fadeIn = serializer.readInt();
			this.stay = serializer.readInt();
			this.fadeOut = serializer.readInt();
		}
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeEnum(this.action);
		if (this.action == TitleAction.TITLE || this.action == TitleAction.SUBTITLE) {
			serializer.writeJSONComponent(this.value);
		}

		if (this.action == TitleAction.TIMES) {
			serializer.writeInt(this.fadeIn);
			serializer.writeInt(this.stay);
			serializer.writeInt(this.fadeOut);
		}

	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

	public enum TitleAction {

		TITLE, SUBTITLE, TIMES, CLEAR, RESET;

		public static TitleAction getByName(String name) {
			for (TitleAction action : values()) {
				if (action.name().equalsIgnoreCase(name)) {
					return action;
				}
			}

			return TITLE;
		}

		public static String[] getTitles() {
			String[] titles = new String[values().length];

			for (int i = 0; i < titles.length; ++i) {
				titles[i] = values()[i].name().toLowerCase();
			}

			return titles;
		}

	}

}
