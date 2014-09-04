package net.minecraft;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EulaAgreementChecker {

	private static final Logger logger = LogManager.getLogger();
	private final File file;
	private final boolean agreed;

	public EulaAgreementChecker(File var1) {
		this.file = var1;
		this.agreed = this.read(var1);
	}

	private boolean read(File var1) {
		FileInputStream var2 = null;
		boolean var3 = false;

		try {
			Properties var4 = new Properties();
			var2 = new FileInputStream(var1);
			var4.load(var2);
			var3 = Boolean.parseBoolean(var4.getProperty("eula", "false"));
		} catch (Exception var8) {
			logger.warn("Failed to load " + var1);
			this.write();
		} finally {
			IOUtils.closeQuietly((InputStream) var2);
		}

		return var3;
	}

	public boolean isAgreed() {
		return this.agreed;
	}

	public void write() {
		FileOutputStream var1 = null;

		try {
			Properties var2 = new Properties();
			var1 = new FileOutputStream(this.file);
			var2.setProperty("eula", "false");
			var2.store(var1, "By changing the setting below to TRUE you are indicating your agreement to our EULA (https://account.mojang.com/documents/minecraft_eula).");
		} catch (Exception var6) {
			logger.warn("Failed to save " + this.file, (Throwable) var6);
		} finally {
			IOUtils.closeQuietly((OutputStream) var1);
		}

	}

}
