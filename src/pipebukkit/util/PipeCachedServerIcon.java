package pipebukkit.util;

import org.bukkit.util.CachedServerIcon;

public class PipeCachedServerIcon implements CachedServerIcon {

	private String iconData;

	public PipeCachedServerIcon(String iconData) {
		this.iconData = iconData;
	}

	public String getData() {
		return iconData;
	}

}
