package net.minecraft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class no implements id<nm> {

	private static final Gson a = (new GsonBuilder()).registerTypeAdapter(nt.class, new nu()).registerTypeAdapter(nq.class, new nr()).registerTypeAdapter(ServerPing.class, new ns()).registerTypeHierarchyAdapter(ho.class, new hp()).registerTypeHierarchyAdapter(hv.class, new hx()).registerTypeAdapterFactory(new ut()).create();
	private ServerPing b;

	public no() {
	}

	public no(ServerPing var1) {
		this.b = var1;
	}

	public void a(hd var1) {
		this.b = (ServerPing) a.fromJson(var1.c(32767), ServerPing.class);
	}

	public void b(hd var1) {
		var1.a(a.toJson((Object) this.b));
	}

	public void a(nm var1) {
		var1.a(this);
	}

}
