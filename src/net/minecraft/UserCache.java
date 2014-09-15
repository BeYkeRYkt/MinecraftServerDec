package net.minecraft;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mojang.authlib.Agent;
import com.mojang.authlib.GameProfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.ParameterizedType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import net.minecraft.server.MinecraftServer;

import org.apache.commons.io.IOUtils;

public class UserCache {

	private final MinecraftServer minecraftserver;
	public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
	private final Map<String, UserData> nameCache = Maps.newHashMap();
	private final Map<UUID, UserData> uuidCache = new LinkedHashMap<UUID, UserData>(16, 0.75F, true);
	protected final Gson gson;
	private final File file;
	private static final ParameterizedType type = new sa();

	public UserCache(MinecraftServer minecraftserver, File file) {
		this.minecraftserver = minecraftserver;
		this.file = file;
		GsonBuilder lgson = new GsonBuilder();
		lgson.registerTypeHierarchyAdapter(UserData.class, new UserCacheParser());
		this.gson = lgson.create();
		this.loadCache();
	}

	private static GameProfile lookupName(MinecraftServer minecraftserver, String name) {
		GameProfile[] profileArray = new GameProfile[1];
		UserProfileLookupCallback callback = new UserProfileLookupCallback(profileArray);
		if (!minecraftserver.isOnlineMode()) {
			UUID uuid = EntityHuman.a(new GameProfile((UUID) null, name));
			GameProfile profile = new GameProfile(uuid, name);
			callback.onProfileLookupSucceeded(profile);
		} else {
			minecraftserver.getGameProfileRepository().findProfilesByNames(new String[] { name }, Agent.MINECRAFT, callback);
		}
		return profileArray[0];
	}

	public void saveProfile(GameProfile profile) {
		this.saveProfile(profile, null);
	}

	private void saveProfile(GameProfile profile, Date date) {
		UUID uuid = profile.getId();
		if (date == null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(2, 1);
			date = calendar.getTime();
		}

		String name = profile.getName().toLowerCase(Locale.ROOT);
		UserData newuserdata = new UserData(profile, date);
		if (this.uuidCache.containsKey(uuid)) {
			this.nameCache.remove(uuidCache.get(uuid).getProfile().getName().toLowerCase(Locale.ROOT));
			this.nameCache.put(profile.getName().toLowerCase(Locale.ROOT), newuserdata);
		} else {
			this.uuidCache.put(uuid, newuserdata);
			this.nameCache.put(name, newuserdata);
		}
	}

	public GameProfile getProfile(String name) {
		name = name.toLowerCase(Locale.ROOT);
		UserData userdata = this.nameCache.get(name);
		if (userdata != null && (new Date()).getTime() >= userdata.getDate().getTime()) {
			this.uuidCache.remove(userdata.getProfile().getId());
			this.nameCache.remove(userdata.getProfile().getName().toLowerCase(Locale.ROOT));
			userdata = null;
		}

		GameProfile profile;
		if (userdata != null) {
			profile = userdata.getProfile();
		} else {
			profile = lookupName(this.minecraftserver, name);
			if (profile != null) {
				this.saveProfile(profile);
				userdata = this.nameCache.get(name);
			}
		}

		this.dumpCache();
		return userdata == null ? null : userdata.getProfile();
	}

	public String[] getNames() {
		ArrayList<String> var1 = Lists.newArrayList((Iterable<String>) this.nameCache.keySet());
		return (String[]) var1.toArray(new String[var1.size()]);
	}

	public GameProfile getProfile(UUID uuid) {
		UserData userdata = this.uuidCache.get(uuid);
		return userdata == null ? null : userdata.getProfile();
	}

	public void loadCache() {
		List<UserData> datalist = null;
		BufferedReader reader = null;

		try {
			reader = Files.newReader(this.file, Charsets.UTF_8);
			datalist = this.gson.fromJson(reader, type);
		} catch (FileNotFoundException var7) {
		} finally {
			IOUtils.closeQuietly((Reader) reader);
		}

		if (datalist != null) {
			this.nameCache.clear();
			this.uuidCache.clear();
			datalist = Lists.reverse(datalist);
			for (UserData userdata : datalist) {
				this.saveProfile(userdata.getProfile(), userdata.getDate());
			}
		}

	}

	public void dumpCache() {
		String data = gson.toJson(getUserDataList(1000));
		BufferedWriter writer = null;
		try {
			writer = Files.newWriter(file, Charsets.UTF_8);
			writer.write(data);
		} catch (FileNotFoundException ex) {
		} catch (IOException ex) {
		} finally {
			IOUtils.closeQuietly(writer);
		}

	}

	private List<UserData> getUserDataList(int limit) {
		ArrayList<UserData> list = Lists.newArrayList();

		int count = 0;
		for (Entry<UUID, UserData> profile : uuidCache.entrySet()) {
			if (count >= limit) {
				break;
			}
			list.add(profile.getValue());
			count++;
		}

		return list;
	}

}
