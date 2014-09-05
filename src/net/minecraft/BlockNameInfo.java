package net.minecraft;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

public class BlockNameInfo {

	protected final String modname;
	protected final String blockname;

	protected BlockNameInfo(int i, String... blockInfo) {
		this.modname = StringUtils.isEmpty(blockInfo[0]) ? "minecraft" : blockInfo[0].toLowerCase();
		this.blockname = blockInfo[1];
		Validate.notNull(this.blockname);
	}

	public BlockNameInfo(String blockName) {
		this(0, parseInfo(blockName));
	}

	protected static String[] parseInfo(String blockName) {
		String[] info = new String[] { null, blockName };
		int index = blockName.indexOf(58);
		if (index >= 0) {
			info[1] = blockName.substring(index + 1, blockName.length());
			if (index > 1) {
				info[0] = blockName.substring(0, index);
			}
		}

		return info;
	}

	public String getBlockName() {
		return this.blockname;
	}

	public String toString() {
		return this.modname + ':' + this.blockname;
	}

	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else if (!(var1 instanceof BlockNameInfo)) {
			return false;
		} else {
			BlockNameInfo var2 = (BlockNameInfo) var1;
			return this.modname.equals(var2.modname) && this.blockname.equals(var2.blockname);
		}
	}

	public int hashCode() {
		return 31 * this.modname.hashCode() + this.blockname.hashCode();
	}

}
