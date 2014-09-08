package net.minecraft;

import java.util.Vector;
import javax.swing.JList;
import net.minecraft.server.MinecraftServer;

public class qc extends JList implements PacketTickable {

	private MinecraftServer a;
	private int b;

	public qc(MinecraftServer var1) {
		this.a = var1;
		var1.a((PacketTickable) this);
	}

	public void doTick() {
		if (this.b++ % 20 == 0) {
			Vector var1 = new Vector();

			for (int var2 = 0; var2 < this.a.getPlayerList().players.size(); ++var2) {
				var1.add(((EntityPlayer) this.a.getPlayerList().players.get(var2)).d_());
			}

			this.setListData(var1);
		}

	}
}
