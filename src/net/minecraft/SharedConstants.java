package net.minecraft;

public class SharedConstants {

	public static boolean isAllowedChatCharacter(char c) {
		return c != 167 && c >= 32 && c != 127;
	}

	public static String cleanupString(String string) {
		StringBuilder sb = new StringBuilder();
		for (char c : string.toCharArray()) {
			if (isAllowedChatCharacter(c)) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

}
