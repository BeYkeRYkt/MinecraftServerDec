package net.minecraft;

import com.google.common.base.Charsets;
import com.google.common.collect.Iterators;
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
import java.io.Writer;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;
import org.apache.commons.io.IOUtils;

public class ry {

	public static final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
	private final Map c = Maps.newHashMap();
	private final Map d = Maps.newHashMap();
	private final LinkedList e = Lists.newLinkedList();
	private final MinecraftServer f;
	protected final Gson b;
	private final File g;
	private static final ParameterizedType h = new sa();

	public ry(MinecraftServer var1, File var2) {
		this.f = var1;
		this.g = var2;
		GsonBuilder var3 = new GsonBuilder();
		var3.registerTypeHierarchyAdapter(sb.class, new sc(this, (rz) null));
		this.b = var3.create();
		this.b();
	}

	private static GameProfile a(MinecraftServer var0, String var1) {
		GameProfile[] var2 = new GameProfile[1];
		rz var3 = new rz(var2);
		var0.getGameProfileRepository().findProfilesByNames(new String[] { var1 }, Agent.MINECRAFT, var3);
		if (!var0.isOnlineMode() && var2[0] == null) {
			UUID var4 = ahd.a(new GameProfile((UUID) null, var1));
			GameProfile var5 = new GameProfile(var4, var1);
			var3.onProfileLookupSucceeded(var5);
		}

		return var2[0];
	}

	public void a(GameProfile var1) {
		this.a(var1, (Date) null);
	}

	private void a(GameProfile var1, Date var2) {
		UUID var3 = var1.getId();
		if (var2 == null) {
			Calendar var4 = Calendar.getInstance();
			var4.setTime(new Date());
			var4.add(2, 1);
			var2 = var4.getTime();
		}

		String var7 = var1.getName().toLowerCase(Locale.ROOT);
		sb var5 = new sb(this, var1, var2, (rz) null);
		if (this.d.containsKey(var3)) {
			sb var6 = (sb) this.d.get(var3);
			this.c.remove(var6.a().getName().toLowerCase(Locale.ROOT));
			this.c.put(var1.getName().toLowerCase(Locale.ROOT), var5);
			this.e.remove(var1);
		} else {
			this.d.put(var3, var5);
			this.c.put(var7, var5);
		}

		this.e.addFirst(var1);
	}

	public GameProfile a(String var1) {
		String var2 = var1.toLowerCase(Locale.ROOT);
		sb var3 = (sb) this.c.get(var2);
		if (var3 != null && (new Date()).getTime() >= sb.a(var3).getTime()) {
			this.d.remove(var3.a().getId());
			this.c.remove(var3.a().getName().toLowerCase(Locale.ROOT));
			this.e.remove(var3.a());
			var3 = null;
		}

		GameProfile var4;
		if (var3 != null) {
			var4 = var3.a();
			this.e.remove(var4);
			this.e.addFirst(var4);
		} else {
			var4 = a(this.f, var2);
			if (var4 != null) {
				this.a(var4);
				var3 = (sb) this.c.get(var2);
			}
		}

		this.c();
		return var3 == null ? null : var3.a();
	}

	public String[] a() {
		ArrayList var1 = Lists.newArrayList((Iterable) this.c.keySet());
		return (String[]) var1.toArray(new String[var1.size()]);
	}

	public GameProfile a(UUID var1) {
		sb var2 = (sb) this.d.get(var1);
		return var2 == null ? null : var2.a();
	}

	private sb b(UUID var1) {
		sb var2 = (sb) this.d.get(var1);
		if (var2 != null) {
			GameProfile var3 = var2.a();
			this.e.remove(var3);
			this.e.addFirst(var3);
		}

		return var2;
	}

	public void b() {
		List var1 = null;
		BufferedReader var2 = null;

		label64: {
			try {
				var2 = Files.newReader(this.g, Charsets.UTF_8);
				var1 = (List) this.b.fromJson((Reader) var2, (Type) h);
				break label64;
			} catch (FileNotFoundException var7) {
				;
			} finally {
				IOUtils.closeQuietly((Reader) var2);
			}

			return;
		}

		if (var1 != null) {
			this.c.clear();
			this.d.clear();
			this.e.clear();
			var1 = Lists.reverse(var1);
			Iterator var3 = var1.iterator();

			while (var3.hasNext()) {
				sb var4 = (sb) var3.next();
				if (var4 != null) {
					this.a(var4.a(), var4.b());
				}
			}
		}

	}

	public void c() {
		String var1 = this.b.toJson((Object) this.a(1000));
		BufferedWriter var2 = null;

		try {
			var2 = Files.newWriter(this.g, Charsets.UTF_8);
			var2.write(var1);
			return;
		} catch (FileNotFoundException var8) {
			return;
		} catch (IOException var9) {
			;
		} finally {
			IOUtils.closeQuietly((Writer) var2);
		}

	}

	private List a(int var1) {
		ArrayList var2 = Lists.newArrayList();
		ArrayList var3 = Lists.newArrayList(Iterators.limit(this.e.iterator(), var1));
		Iterator var4 = var3.iterator();

		while (var4.hasNext()) {
			GameProfile var5 = (GameProfile) var4.next();
			sb var6 = this.b(var5.getId());
			if (var6 != null) {
				var2.add(var6);
			}
		}

		return var2;
	}

}
