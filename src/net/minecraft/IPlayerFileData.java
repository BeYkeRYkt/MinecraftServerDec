package net.minecraft;

public interface IPlayerFileData {

	void save(EntityHuman var1);

	NBTCompoundTag load(EntityHuman var1);

	String[] getSeenPlayers();
}
