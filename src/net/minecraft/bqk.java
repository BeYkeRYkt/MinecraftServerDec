package net.minecraft;

import java.io.File;
import java.io.FilenameFilter;

class bqk implements FilenameFilter {

	// $FF: synthetic field
	final WorldLoaderServer a;

	bqk(WorldLoaderServer var1) {
		this.a = var1;
	}

	public boolean accept(File var1, String var2) {
		return var2.endsWith(".mcr");
	}
}
