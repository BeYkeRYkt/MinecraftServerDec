package net.minecraft;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServerProperties {

	private static final Logger logger = LogManager.getLogger();
	private final Properties properties = new Properties();
	private final File file;

	public ServerProperties(File file) {
		this.file = file;
		if (file.exists()) {
			FileInputStream var2 = null;

			try {
				var2 = new FileInputStream(file);
				this.properties.load(var2);
			} catch (Exception var12) {
				logger.warn("Failed to load " + file, (Throwable) var12);
				this.createNew();
			} finally {
				if (var2 != null) {
					try {
						var2.close();
					} catch (IOException var11) {
						;
					}
				}

			}
		} else {
			logger.warn(file + " does not exist");
			this.createNew();
		}

	}

	public void createNew() {
		logger.info("Generating new properties file");
		this.write();
	}

	public void write() {
		FileOutputStream var1 = null;

		try {
			var1 = new FileOutputStream(this.file);
			this.properties.store(var1, "Minecraft server properties");
		} catch (Exception var11) {
			logger.warn("Failed to save " + this.file, (Throwable) var11);
			this.createNew();
		} finally {
			if (var1 != null) {
				try {
					var1.close();
				} catch (IOException var10) {
					;
				}
			}

		}

	}

	public File getFile() {
		return this.file;
	}

	public String getString(String path, String defaultValue) {
		if (!this.properties.containsKey(path)) {
			this.properties.setProperty(path, defaultValue);
			this.write();
		}

		return this.properties.getProperty(path, defaultValue);
	}

	public int getInt(String path, int defaultValue) {
		try {
			return Integer.parseInt(this.getString(path, "" + defaultValue));
		} catch (Exception ex) {
			this.properties.setProperty(path, "" + defaultValue);
			this.write();
			return defaultValue;
		}
	}

	public long getLong(String path, long defaultValue) {
		try {
			return Long.parseLong(this.getString(path, "" + defaultValue));
		} catch (Exception ex) {
			this.properties.setProperty(path, "" + defaultValue);
			this.write();
			return defaultValue;
		}
	}

	public boolean getBoolean(String path, boolean defaultValue) {
		try {
			return Boolean.parseBoolean(this.getString(path, "" + defaultValue));
		} catch (Exception ex) {
			this.properties.setProperty(path, "" + defaultValue);
			this.write();
			return defaultValue;
		}
	}

	public void setProperty(String path, Object value) {
		this.properties.setProperty(path, "" + value);
	}

}
