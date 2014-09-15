package net.minecraft;

public enum EnumChatFlag {

	FULL(0, "options.chat.visibility.full"), SYSTEM(1, "options.chat.visibility.system"), HIDDEN(2, "options.chat.visibility.hidden");

	private static final EnumChatFlag[] byId = new EnumChatFlag[values().length];
	static {
		for (EnumChatFlag flag : values()) {
			byId[flag.id] = flag;
		}
	}

	private final int id;

	private EnumChatFlag(int id, String name) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public static EnumChatFlag getById(int id) {
		return byId[id % byId.length];
	}

}
