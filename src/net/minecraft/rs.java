package net.minecraft;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.exceptions.AuthenticationUnavailableException;
import java.math.BigInteger;
import java.util.UUID;

class rs extends Thread {

	// $FF: synthetic field
	final rq a;

	rs(rq var1, String var2) {
		super(var2);
		this.a = var1;
	}

	public void run() {
		GameProfile var1 = rq.b(this.a);

		try {
			String var2 = (new BigInteger(ug.a(rq.c(this.a), rq.a(this.a).P().getPublic(), rq.d(this.a)))).toString(16);
			rq.a(this.a, rq.a(this.a).aB().hasJoinedServer(new GameProfile((UUID) null, var1.getName()), var2));
			if (rq.b(this.a) != null) {
				rq.e().info("UUID of player " + rq.b(this.a).getName() + " is " + rq.b(this.a).getId());
				rq.a(this.a, rt.d);
			} else if (rq.a(this.a).S()) {
				rq.e().warn("Failed to verify username but will let them in anyway!");
				rq.a(this.a, this.a.a(var1));
				rq.a(this.a, rt.d);
			} else {
				this.a.a("Failed to verify username!");
				rq.e().error("Username \'" + rq.b(this.a).getName() + "\' tried to join with an invalid session");
			}
		} catch (AuthenticationUnavailableException var3) {
			if (rq.a(this.a).S()) {
				rq.e().warn("Authentication servers are down but will let them in anyway!");
				rq.a(this.a, this.a.a(var1));
				rq.a(this.a, rt.d);
			} else {
				this.a.a("Authentication servers are down. Please try again later, sorry!");
				rq.e().error("Couldn\'t verify username because servers are unavailable");
			}
		}

	}
}
