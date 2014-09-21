package pipebukkit.server.entity;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.Set;

import net.minecraft.ChatMessage;
import net.minecraft.EntityPlayer;

import org.bukkit.Achievement;
import org.bukkit.Effect;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.Sound;
import org.bukkit.Statistic;
import org.bukkit.WeatherType;
import org.bukkit.configuration.serialization.DelegateDeserialization;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.Scoreboard;

import pipebukkit.server.PipeOfflinePlayer;

@DelegateDeserialization(PipeOfflinePlayer.class)
public class PipePlayer extends PipeHumanEntity implements Player {

	public PipePlayer(EntityPlayer nmsPlayer) {
		super(nmsPlayer);
	}

	@Override
	public void abandonConversation(Conversation arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void abandonConversation(Conversation arg0, ConversationAbandonedEvent arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void acceptConversationInput(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean beginConversation(Conversation arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isConversing() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void sendRawMessage(String message) {
		if (getHandle(EntityPlayer.class).playerConnection == null) {
			return;
		}
		getHandle(EntityPlayer.class).sendChatMessage(new ChatMessage(message));
	}

	@Override
	public void sendMessage(String message) {
		sendRawMessage(message);
	}

	@Override
	public void sendMessage(String[] messages) {
		for (String message : messages) {
			sendMessage(message);
		}
	}

	@Override
	public long getFirstPlayed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getLastPlayed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Player getPlayer() {
		return this;
	}

	@Override
	public boolean hasPlayedBefore() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isBanned() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOnline() {
		return true;
	}

	@Override
	public boolean isWhitelisted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setBanned(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setWhitelisted(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Object> serialize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getListeningPluginChannels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendPluginMessage(Plugin arg0, String arg1, byte[] arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void awardAchievement(Achievement arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canSee(Player arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void chat(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decrementStatistic(Statistic arg0) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decrementStatistic(Statistic arg0, int arg1) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decrementStatistic(Statistic arg0, Material arg1) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decrementStatistic(Statistic arg0, EntityType arg1) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decrementStatistic(Statistic arg0, Material arg1, int arg2) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decrementStatistic(Statistic arg0, EntityType arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InetSocketAddress getAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getAllowFlight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Location getBedSpawnLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location getCompassTarget() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDisplayName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float getExhaustion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getExp() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getFlySpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFoodLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getHealthScale() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getPlayerListName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getPlayerTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getPlayerTimeOffset() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public WeatherType getPlayerWeather() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float getSaturation() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Scoreboard getScoreboard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getStatistic(Statistic arg0) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getStatistic(Statistic arg0, Material arg1) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getStatistic(Statistic arg0, EntityType arg1) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalExperience() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getWalkSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void giveExp(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void giveExpLevels(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasAchievement(Achievement arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void hidePlayer(Player arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void incrementStatistic(Statistic arg0) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void incrementStatistic(Statistic arg0, int arg1) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void incrementStatistic(Statistic arg0, Material arg1) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void incrementStatistic(Statistic arg0, EntityType arg1) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void incrementStatistic(Statistic arg0, Material arg1, int arg2) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void incrementStatistic(Statistic arg0, EntityType arg1, int arg2) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isFlying() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHealthScaled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPlayerTimeRelative() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSleepingIgnored() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSneaking() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSprinting() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void kickPlayer(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean performCommand(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void playEffect(Location arg0, Effect arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> void playEffect(Location arg0, Effect arg1, T arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playNote(Location arg0, byte arg1, byte arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playNote(Location arg0, Instrument arg1, Note arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playSound(Location arg0, Sound arg1, float arg2, float arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playSound(Location arg0, String arg1, float arg2, float arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAchievement(Achievement arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetPlayerTime() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetPlayerWeather() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendBlockChange(Location arg0, Material arg1, byte arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendBlockChange(Location arg0, int arg1, byte arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean sendChunkChange(Location arg0, int arg1, int arg2, int arg3, byte[] arg4) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void sendMap(MapView arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendSignChange(Location arg0, String[] arg1) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAllowFlight(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBedSpawnLocation(Location arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBedSpawnLocation(Location arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCompassTarget(Location arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDisplayName(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setExhaustion(float arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setExp(float arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFlySpeed(float arg0) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFlying(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFoodLevel(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHealthScale(double arg0) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHealthScaled(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLevel(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPlayerListName(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPlayerTime(long arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPlayerWeather(WeatherType arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setResourcePack(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSaturation(float arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setScoreboard(Scoreboard arg0) throws IllegalArgumentException, IllegalStateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSleepingIgnored(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSneaking(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSprinting(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStatistic(Statistic arg0, int arg1) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStatistic(Statistic arg0, Material arg1, int arg2) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStatistic(Statistic arg0, EntityType arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTexturePack(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTotalExperience(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setWalkSpeed(float arg0) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showPlayer(Player arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EntityType getType() {
		return EntityType.PLAYER;
	}

}
