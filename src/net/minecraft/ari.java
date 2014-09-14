package net.minecraft;

public class ari extends Position {

	public long b;
	// $FF: synthetic field
	final PortalTravelAgent c;

	public ari(PortalTravelAgent var1, Position var2, long var3) {
		super(var2.getX(), var2.getY(), var2.getZ());
		this.c = var1;
		this.b = var3;
	}
}
