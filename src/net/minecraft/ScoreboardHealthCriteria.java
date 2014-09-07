package net.minecraft;

import java.util.Iterator;
import java.util.List;

public class ScoreboardHealthCriteria extends ScoreboardBaseCriteria {

	public ScoreboardHealthCriteria(String var1) {
		super(var1);
	}

	public int getScoreModifier(List var1) {
		float var2 = 0.0F;

		EntityHuman var4;
		for (Iterator var3 = var1.iterator(); var3.hasNext(); var2 += var4.bm() + var4.bM()) {
			var4 = (EntityHuman) var3.next();
		}

		if (var1.size() > 0) {
			var2 /= (float) var1.size();
		}

		return DataTypesConverter.f(var2);
	}

	public boolean isReadOnly() {
		return true;
	}

	public bsl c() {
		return bsl.b;
	}
}
