package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.server.MinecraftServer;

public class pk extends bsd {

	private final MinecraftServer a;
	private final Set b = Sets.newHashSet();
	private bse c;

	public pk(MinecraftServer var1) {
		this.a = var1;
	}

	public void a(bsa var1) {
		super.a(var1);
		if (this.b.contains(var1.d())) {
			this.a.getPlayerList().a((id) (new lf(var1)));
		}

		this.b();
	}

	public void a(String var1) {
		super.a(var1);
		this.a.getPlayerList().a((id) (new lf(var1)));
		this.b();
	}

	public void a(String var1, bry var2) {
		super.a(var1, var2);
		this.a.getPlayerList().a((id) (new lf(var1, var2)));
		this.b();
	}

	public void a(int var1, bry var2) {
		bry var3 = this.a(var1);
		super.a(var1, var2);
		if (var3 != var2 && var3 != null) {
			if (this.h(var3) > 0) {
				this.a.getPlayerList().a((id) (new kw(var1, var2)));
			} else {
				this.g(var3);
			}
		}

		if (var2 != null) {
			if (this.b.contains(var2)) {
				this.a.getPlayerList().a((id) (new kw(var1, var2)));
			} else {
				this.e(var2);
			}
		}

		this.b();
	}

	public boolean a(String var1, String var2) {
		if (super.a(var1, var2)) {
			brz var3 = this.d(var2);
			this.a.getPlayerList().a((id) (new le(var3, Arrays.asList(new String[] { var1 }), 3)));
			this.b();
			return true;
		} else {
			return false;
		}
	}

	public void a(String var1, brz var2) {
		super.a(var1, var2);
		this.a.getPlayerList().a((id) (new le(var2, Arrays.asList(new String[] { var1 }), 4)));
		this.b();
	}

	public void a(bry var1) {
		super.a(var1);
		this.b();
	}

	public void b(bry var1) {
		super.b(var1);
		if (this.b.contains(var1)) {
			this.a.getPlayerList().a((id) (new ld(var1, 2)));
		}

		this.b();
	}

	public void c(bry var1) {
		super.c(var1);
		if (this.b.contains(var1)) {
			this.g(var1);
		}

		this.b();
	}

	public void a(brz var1) {
		super.a(var1);
		this.a.getPlayerList().a((id) (new le(var1, 0)));
		this.b();
	}

	public void b(brz var1) {
		super.b(var1);
		this.a.getPlayerList().a((id) (new le(var1, 2)));
		this.b();
	}

	public void c(brz var1) {
		super.c(var1);
		this.a.getPlayerList().a((id) (new le(var1, 1)));
		this.b();
	}

	public void a(bse var1) {
		this.c = var1;
	}

	protected void b() {
		if (this.c != null) {
			this.c.c();
		}

	}

	public List d(bry var1) {
		ArrayList var2 = Lists.newArrayList();
		var2.add(new ld(var1, 0));

		for (int var3 = 0; var3 < 19; ++var3) {
			if (this.a(var3) == var1) {
				var2.add(new kw(var3, var1));
			}
		}

		Iterator var5 = this.i(var1).iterator();

		while (var5.hasNext()) {
			bsa var4 = (bsa) var5.next();
			var2.add(new lf(var4));
		}

		return var2;
	}

	public void e(bry var1) {
		List var2 = this.d(var1);
		Iterator var3 = this.a.getPlayerList().players.iterator();

		while (var3.hasNext()) {
			EntityPlayer var4 = (EntityPlayer) var3.next();
			Iterator var5 = var2.iterator();

			while (var5.hasNext()) {
				id var6 = (id) var5.next();
				var4.a.a(var6);
			}
		}

		this.b.add(var1);
	}

	public List f(bry var1) {
		ArrayList var2 = Lists.newArrayList();
		var2.add(new ld(var1, 1));

		for (int var3 = 0; var3 < 19; ++var3) {
			if (this.a(var3) == var1) {
				var2.add(new kw(var3, var1));
			}
		}

		return var2;
	}

	public void g(bry var1) {
		List var2 = this.f(var1);
		Iterator var3 = this.a.getPlayerList().players.iterator();

		while (var3.hasNext()) {
			EntityPlayer var4 = (EntityPlayer) var3.next();
			Iterator var5 = var2.iterator();

			while (var5.hasNext()) {
				id var6 = (id) var5.next();
				var4.a.a(var6);
			}
		}

		this.b.remove(var1);
	}

	public int h(bry var1) {
		int var2 = 0;

		for (int var3 = 0; var3 < 19; ++var3) {
			if (this.a(var3) == var1) {
				++var2;
			}
		}

		return var2;
	}
}
