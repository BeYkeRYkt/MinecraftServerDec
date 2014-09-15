package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public enum EnumChatFormat {

	BLACK("BLACK", '0', 0), 
	DARK_BLUE("DARK_BLUE", '1', 1), 
	DARK_GREEN("DARK_GREEN", '2', 2), 
	DARK_AQUA("DARK_AQUA", '3', 3), 
	DARK_RED("DARK_RED", '4', 4), 
	DARK_PURPLE("DARK_PURPLE", '5', 5),
	GOLD("GOLD", '6', 6), 
	GRAY("GRAY", '7', 7), 
	DARK_GRAY("DARK_GRAY", '8', 8), 
	BLUE("BLUE", '9', 9), 
	GREEN("GREEN", 'a', 10), 
	AQUA("AQUA", 'b', 11),
	RED("RED", 'c', 12), 
	LIGHT_PURPLE("LIGHT_PURPLE", 'd', 13), 
	YELLOW("YELLOW", 'e', 14), 
	WHITE("WHITE", 'f', 15), 
	OBFUSCATED("OBFUSCATED", 'k', true), 
	BOLD("BOLD", 'l', true), 
	STRIKETHROUGH("STRIKETHROUGH", 'm', true), 
	UNDERLINE("UNDERLINE", 'n', true), 
	ITALIC("ITALIC", 'o', true), 
	RESET("RESET", 'r', -1);

	private static final Map<String, EnumChatFormat> byName = Maps.newHashMap();
	static {
		for (EnumChatFormat format : values()) {
			byName.put(cleanupName(format.name), format);
		}
	}

	private static String cleanupName(String name) {
		return name.toLowerCase().replaceAll("[^a-z]", "");
	}

	public static EnumChatFormat getByName(String name) {
		return name == null ? null : (EnumChatFormat) byName.get(cleanupName(name));
	}

	public static EnumChatFormat getById(int id) {
		if (id < 0) {
			return RESET;
		} else {
			for (EnumChatFormat format : values()) {
				if (format.getId() == id) {
					return format;
				}
			}
			return null;
		}
	}

	public static Collection<String> getCodes(boolean includeColors, boolean includeFormattingCodes) {
		ArrayList<String> list = Lists.newArrayList();

		for (EnumChatFormat format : values()) {
			if ((!format.isColorCode() || includeColors) && (!format.isFormattingCode() || includeFormattingCodes)) {
				list.add(format.getEnumLCName());
			}
		}

		return list;
	}

	private final String name;
	private final boolean formattingCode;
	private final String replaceName;
	private final int id;

	private EnumChatFormat(String name, char replaceChar, int id) {
		this(name, replaceChar, false, id);
	}

	private EnumChatFormat(String name, char replaceChar, boolean isFormattingCode) {
		this(name, replaceChar, isFormattingCode, -1);
	}

	private EnumChatFormat(String name, char replaceChar, boolean isFormattingCode, int id) {
		this.name = name;
		this.formattingCode = isFormattingCode;
		this.id = id;
		this.replaceName = "§" + replaceChar;
	}

	public int getId() {
		return this.id;
	}

	public boolean isFormattingCode() {
		return this.formattingCode;
	}

	public boolean isColorCode() {
		return !this.formattingCode && this != RESET;
	}

	public String getEnumLCName() {
		return this.name().toLowerCase();
	}

	public String toString() {
		return this.replaceName;
	}

}
