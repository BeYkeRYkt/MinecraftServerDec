package net.minecraft;

public interface pj {

	int getIntProperty(String var1, int var2);

	String getStringProperty(String var1, String var2);

	void setProperty(String var1, Object var2);

	void saveProperties();

	String b();

	String C();

	int D();

	String getMotd();

	String getGameVersion();

	int getOnlinePlayersCount();

	int getMaxPlayers();

	String[] I();

	String getLevelName();

	String K();

	String g(String var1);

	boolean L();

	void logInfo(String var1);

	void logWarning(String var1);

	void h(String var1);

	void i(String var1);
}
