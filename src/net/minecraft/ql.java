package net.minecraft;

import net.minecraft.server.MinecraftServer;

public class ql extends WorldServer {

	private WorldServer a;

	public ql(MinecraftServer var1, IDataManager var2, int var3, WorldServer var4, MethodProfiler var5) {
		super(var1, var2, new bql(var4.P()), var3, var5);
		this.a = var4;
		var4.af().a((bez) (new qm(this)));
	}

	protected void a() {
	}

	public World b() {
		this.z = this.a.T();
		this.C = this.a.Z();
		String var1 = PersistentVillage.a(this.worldProvider);
		PersistentVillage var2 = (PersistentVillage) this.z.a(PersistentVillage.class, var1);
		if (var2 == null) {
			this.A = new PersistentVillage(this);
			this.z.a(var1, (bqc) this.A);
		} else {
			this.A = var2;
			this.A.a((World) this);
		}

		return this;
	}
}
