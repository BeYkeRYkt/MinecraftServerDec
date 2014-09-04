package net.minecraft;

import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public class vb {

	private static final Pattern a = Pattern.compile("(?i)\\u00A7[0-9A-FK-OR]");

	public static boolean b(String var0) {
		return StringUtils.isEmpty(var0);
	}

}
