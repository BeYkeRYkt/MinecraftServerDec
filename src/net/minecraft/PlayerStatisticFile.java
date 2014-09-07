package net.minecraft;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import net.minecraft.server.MinecraftServer;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlayerStatisticFile extends tz {

	private static final Logger logger = LogManager.getLogger();
	private final MinecraftServer minecraftserver;
	private final File statfile;
	private final Set<Statistic> e = Sets.newHashSet();
	private int f = -300;
	private boolean g = false;

	public PlayerStatisticFile(MinecraftServer var1, File var2) {
		this.minecraftserver = var1;
		this.statfile = var2;
	}

	public void read() {
		if (this.statfile.isFile()) {
			try {
				this.a.clear();
				this.a.putAll(this.a(FileUtils.readFileToString(this.statfile)));
			} catch (IOException var2) {
				logger.error("Couldn\'t read statistics file " + this.statfile, (Throwable) var2);
			} catch (JsonParseException var3) {
				logger.error("Couldn\'t parse statistics file " + this.statfile, (Throwable) var3);
			}
		}

	}

	public void write() {
		try {
			FileUtils.writeStringToFile(this.statfile, a(this.a));
		} catch (IOException var2) {
			logger.error("Couldn\'t save stats", (Throwable) var2);
		}

	}

	public void a(EntityHuman var1, Statistic var2, int var3) {
		int var4 = var2.d() ? this.a(var2) : 0;
		super.a(var1, var2, var3);
		this.e.add(var2);
		if (var2.d() && var4 == 0 && var3 > 0) {
			this.g = true;
			if (this.minecraftserver.isAnnouncePlayerAchievmentsEnabled()) {
				this.minecraftserver.getPlayerList().a((IChatBaseComponent) (new ChatMessage("chat.type.achievement", new Object[] { var1.e_(), var2.j() })));
			}
		}

		if (var2.d() && var4 > 0 && var3 == 0) {
			this.g = true;
			if (this.minecraftserver.isAnnouncePlayerAchievmentsEnabled()) {
				this.minecraftserver.getPlayerList().a((IChatBaseComponent) (new ChatMessage("chat.type.achievement.taken", new Object[] { var1.e_(), var2.j() })));
			}
		}

	}

	public Set<Statistic> c() {
		HashSet<Statistic> var1 = Sets.newHashSet((Iterable<Statistic>) this.e);
		this.e.clear();
		this.g = false;
		return var1;
	}

	public Map<Statistic, tw> a(String var1) {
		JsonElement var2 = (new JsonParser()).parse(var1);
		if (!var2.isJsonObject()) {
			return Maps.newHashMap();
		} else {
			JsonObject var3 = var2.getAsJsonObject();
			HashMap<Statistic, tw> var4 = Maps.newHashMap();
			Iterator<?> var5 = var3.entrySet().iterator();

			while (var5.hasNext()) {
				Entry<?, ?> var6 = (Entry<?, ?>) var5.next();
				Statistic var7 = StatisticList.fromName((String) var6.getKey());
				if (var7 != null) {
					tw var8 = new tw();
					if (((JsonElement) var6.getValue()).isJsonPrimitive() && ((JsonElement) var6.getValue()).getAsJsonPrimitive().isNumber()) {
						var8.a(((JsonElement) var6.getValue()).getAsInt());
					} else if (((JsonElement) var6.getValue()).isJsonObject()) {
						JsonObject var9 = ((JsonElement) var6.getValue()).getAsJsonObject();
						if (var9.has("value") && var9.get("value").isJsonPrimitive() && var9.get("value").getAsJsonPrimitive().isNumber()) {
							var8.a(var9.getAsJsonPrimitive("value").getAsInt());
						}

						if (var9.has("progress") && var7.l() != null) {
							try {
								Constructor<?> var10 = var7.l().getConstructor(new Class[0]);
								IJsonStatistic var11 = (IJsonStatistic) var10.newInstance(new Object[0]);
								var11.a(var9.get("progress"));
								var8.a(var11);
							} catch (Throwable var12) {
								logger.warn("Invalid statistic progress in " + this.statfile, var12);
							}
						}
					}

					var4.put(var7, var8);
				} else {
					logger.warn("Invalid statistic in " + this.statfile + ": Don\'t know what " + (String) var6.getKey() + " is");
				}
			}

			return var4;
		}
	}

	public static String a(Map<Statistic, tw> var0) {
		JsonObject var1 = new JsonObject();
		Iterator<?> var2 = var0.entrySet().iterator();

		while (var2.hasNext()) {
			Entry<?, ?> var3 = (Entry<?, ?>) var2.next();
			if (((tw) var3.getValue()).b() != null) {
				JsonObject var4 = new JsonObject();
				var4.addProperty("value", (Number) Integer.valueOf(((tw) var3.getValue()).a()));

				try {
					var4.add("progress", ((tw) var3.getValue()).b().a());
				} catch (Throwable var6) {
					logger.warn("Couldn\'t save statistic " + ((Statistic) var3.getKey()).e() + ": error serializing progress", var6);
				}

				var1.add(((Statistic) var3.getKey()).name, var4);
			} else {
				var1.addProperty(((Statistic) var3.getKey()).name, (Number) Integer.valueOf(((tw) var3.getValue()).a()));
			}
		}

		return var1.toString();
	}

	public void d() {
		Iterator<Statistic> var1 = this.a.keySet().iterator();

		while (var1.hasNext()) {
			Statistic var2 = (Statistic) var1.next();
			this.e.add(var2);
		}

	}

	public void a(EntityPlayer var1) {
		int var2 = this.minecraftserver.ar();
		HashMap<Statistic, Integer> var3 = Maps.newHashMap();
		if (this.g || var2 - this.f > 300) {
			this.f = var2;
			Iterator<Statistic> var4 = this.c().iterator();

			while (var4.hasNext()) {
				Statistic var5 = (Statistic) var4.next();
				var3.put(var5, Integer.valueOf(this.a(var5)));
			}
		}

		var1.playerConncetion.sendPacket((Packet<?>) (new PacketOutStatistics(var3)));
	}

	public void b(EntityPlayer var1) {
		HashMap<Statistic, Integer> var2 = Maps.newHashMap();
		Iterator<?> var3 = AchievementList.list.iterator();

		while (var3.hasNext()) {
			Achievement var4 = (Achievement) var3.next();
			if (this.a(var4)) {
				var2.put(var4, Integer.valueOf(this.a((Statistic) var4)));
				this.e.remove(var4);
			}
		}

		var1.playerConncetion.sendPacket((Packet<?>) (new PacketOutStatistics(var2)));
	}

	public boolean e() {
		return this.g;
	}

}
