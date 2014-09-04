package net.minecraft;

import java.util.Vector;
import javax.swing.JList;
import net.minecraft.server.MinecraftServer;

public class qc extends JList implements pm {

	private MinecraftServer a;
	private int b;

	public qc(MinecraftServer var1) {
		this.a = var1;
		var1.a((pm) this);
	}

	public void c() {
		if (this.b++ % 20 == 0) {
			Vector var1 = new Vector();

			for (int var2 = 0; var2 < this.a.an().e.size(); ++var2) {
				var1.add(((qw) this.a.an().e.get(var2)).d_());
			}

			this.setListData(var1);
		}

	}
}
