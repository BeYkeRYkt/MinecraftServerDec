package net.minecraft;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

public class bgo implements JsonDeserializer, JsonSerializer {

	public bgn a(JsonElement var1, Type var2, JsonDeserializationContext var3) {
		JsonObject var4 = var1.getAsJsonObject();
		bgn var5 = new bgn();

		try {
			var5.b = uh.a(var4, "coordinateScale", var5.b);
			var5.c = uh.a(var4, "heightScale", var5.c);
			var5.e = uh.a(var4, "lowerLimitScale", var5.e);
			var5.d = uh.a(var4, "upperLimitScale", var5.d);
			var5.f = uh.a(var4, "depthNoiseScaleX", var5.f);
			var5.g = uh.a(var4, "depthNoiseScaleZ", var5.g);
			var5.h = uh.a(var4, "depthNoiseScaleExponent", var5.h);
			var5.i = uh.a(var4, "mainNoiseScaleX", var5.i);
			var5.j = uh.a(var4, "mainNoiseScaleY", var5.j);
			var5.k = uh.a(var4, "mainNoiseScaleZ", var5.k);
			var5.l = uh.a(var4, "baseSize", var5.l);
			var5.m = uh.a(var4, "stretchY", var5.m);
			var5.n = uh.a(var4, "biomeDepthWeight", var5.n);
			var5.o = uh.a(var4, "biomeDepthOffset", var5.o);
			var5.p = uh.a(var4, "biomeScaleWeight", var5.p);
			var5.q = uh.a(var4, "biomeScaleOffset", var5.q);
			var5.r = uh.a(var4, "seaLevel", var5.r);
			var5.s = uh.a(var4, "useCaves", var5.s);
			var5.t = uh.a(var4, "useDungeons", var5.t);
			var5.u = uh.a(var4, "dungeonChance", var5.u);
			var5.v = uh.a(var4, "useStrongholds", var5.v);
			var5.w = uh.a(var4, "useVillages", var5.w);
			var5.x = uh.a(var4, "useMineShafts", var5.x);
			var5.y = uh.a(var4, "useTemples", var5.y);
			var5.z = uh.a(var4, "useMonuments", var5.z);
			var5.A = uh.a(var4, "useRavines", var5.A);
			var5.B = uh.a(var4, "useWaterLakes", var5.B);
			var5.C = uh.a(var4, "waterLakeChance", var5.C);
			var5.D = uh.a(var4, "useLavaLakes", var5.D);
			var5.E = uh.a(var4, "lavaLakeChance", var5.E);
			var5.F = uh.a(var4, "useLavaOceans", var5.F);
			var5.G = uh.a(var4, "fixedBiome", var5.G);
			if (var5.G < 38 && var5.G >= -1) {
				if (var5.G >= arm.x.az) {
					var5.G += 2;
				}
			} else {
				var5.G = -1;
			}

			var5.H = uh.a(var4, "biomeSize", var5.H);
			var5.I = uh.a(var4, "riverSize", var5.I);
			var5.J = uh.a(var4, "dirtSize", var5.J);
			var5.K = uh.a(var4, "dirtCount", var5.K);
			var5.L = uh.a(var4, "dirtMinHeight", var5.L);
			var5.M = uh.a(var4, "dirtMaxHeight", var5.M);
			var5.N = uh.a(var4, "gravelSize", var5.N);
			var5.O = uh.a(var4, "gravelCount", var5.O);
			var5.P = uh.a(var4, "gravelMinHeight", var5.P);
			var5.Q = uh.a(var4, "gravelMaxHeight", var5.Q);
			var5.R = uh.a(var4, "graniteSize", var5.R);
			var5.S = uh.a(var4, "graniteCount", var5.S);
			var5.T = uh.a(var4, "graniteMinHeight", var5.T);
			var5.U = uh.a(var4, "graniteMaxHeight", var5.U);
			var5.V = uh.a(var4, "dioriteSize", var5.V);
			var5.W = uh.a(var4, "dioriteCount", var5.W);
			var5.X = uh.a(var4, "dioriteMinHeight", var5.X);
			var5.Y = uh.a(var4, "dioriteMaxHeight", var5.Y);
			var5.Z = uh.a(var4, "andesiteSize", var5.Z);
			var5.aa = uh.a(var4, "andesiteCount", var5.aa);
			var5.ab = uh.a(var4, "andesiteMinHeight", var5.ab);
			var5.ac = uh.a(var4, "andesiteMaxHeight", var5.ac);
			var5.ad = uh.a(var4, "coalSize", var5.ad);
			var5.ae = uh.a(var4, "coalCount", var5.ae);
			var5.af = uh.a(var4, "coalMinHeight", var5.af);
			var5.ag = uh.a(var4, "coalMaxHeight", var5.ag);
			var5.ah = uh.a(var4, "ironSize", var5.ah);
			var5.ai = uh.a(var4, "ironCount", var5.ai);
			var5.aj = uh.a(var4, "ironMinHeight", var5.aj);
			var5.ak = uh.a(var4, "ironMaxHeight", var5.ak);
			var5.al = uh.a(var4, "goldSize", var5.al);
			var5.am = uh.a(var4, "goldCount", var5.am);
			var5.an = uh.a(var4, "goldMinHeight", var5.an);
			var5.ao = uh.a(var4, "goldMaxHeight", var5.ao);
			var5.ap = uh.a(var4, "redstoneSize", var5.ap);
			var5.aq = uh.a(var4, "redstoneCount", var5.aq);
			var5.ar = uh.a(var4, "redstoneMinHeight", var5.ar);
			var5.as = uh.a(var4, "redstoneMaxHeight", var5.as);
			var5.at = uh.a(var4, "diamondSize", var5.at);
			var5.au = uh.a(var4, "diamondCount", var5.au);
			var5.av = uh.a(var4, "diamondMinHeight", var5.av);
			var5.aw = uh.a(var4, "diamondMaxHeight", var5.aw);
			var5.ax = uh.a(var4, "lapisSize", var5.ax);
			var5.ay = uh.a(var4, "lapisCount", var5.ay);
			var5.az = uh.a(var4, "lapisCenterHeight", var5.az);
			var5.aA = uh.a(var4, "lapisSpread", var5.aA);
		} catch (Exception var7) {
			;
		}

		return var5;
	}

	public JsonElement a(bgn var1, Type var2, JsonSerializationContext var3) {
		JsonObject var4 = new JsonObject();
		var4.addProperty("coordinateScale", (Number) Float.valueOf(var1.b));
		var4.addProperty("heightScale", (Number) Float.valueOf(var1.c));
		var4.addProperty("lowerLimitScale", (Number) Float.valueOf(var1.e));
		var4.addProperty("upperLimitScale", (Number) Float.valueOf(var1.d));
		var4.addProperty("depthNoiseScaleX", (Number) Float.valueOf(var1.f));
		var4.addProperty("depthNoiseScaleZ", (Number) Float.valueOf(var1.g));
		var4.addProperty("depthNoiseScaleExponent", (Number) Float.valueOf(var1.h));
		var4.addProperty("mainNoiseScaleX", (Number) Float.valueOf(var1.i));
		var4.addProperty("mainNoiseScaleY", (Number) Float.valueOf(var1.j));
		var4.addProperty("mainNoiseScaleZ", (Number) Float.valueOf(var1.k));
		var4.addProperty("baseSize", (Number) Float.valueOf(var1.l));
		var4.addProperty("stretchY", (Number) Float.valueOf(var1.m));
		var4.addProperty("biomeDepthWeight", (Number) Float.valueOf(var1.n));
		var4.addProperty("biomeDepthOffset", (Number) Float.valueOf(var1.o));
		var4.addProperty("biomeScaleWeight", (Number) Float.valueOf(var1.p));
		var4.addProperty("biomeScaleOffset", (Number) Float.valueOf(var1.q));
		var4.addProperty("seaLevel", (Number) Integer.valueOf(var1.r));
		var4.addProperty("useCaves", Boolean.valueOf(var1.s));
		var4.addProperty("useDungeons", Boolean.valueOf(var1.t));
		var4.addProperty("dungeonChance", (Number) Integer.valueOf(var1.u));
		var4.addProperty("useStrongholds", Boolean.valueOf(var1.v));
		var4.addProperty("useVillages", Boolean.valueOf(var1.w));
		var4.addProperty("useMineShafts", Boolean.valueOf(var1.x));
		var4.addProperty("useTemples", Boolean.valueOf(var1.y));
		var4.addProperty("useMonuments", Boolean.valueOf(var1.z));
		var4.addProperty("useRavines", Boolean.valueOf(var1.A));
		var4.addProperty("useWaterLakes", Boolean.valueOf(var1.B));
		var4.addProperty("waterLakeChance", (Number) Integer.valueOf(var1.C));
		var4.addProperty("useLavaLakes", Boolean.valueOf(var1.D));
		var4.addProperty("lavaLakeChance", (Number) Integer.valueOf(var1.E));
		var4.addProperty("useLavaOceans", Boolean.valueOf(var1.F));
		var4.addProperty("fixedBiome", (Number) Integer.valueOf(var1.G));
		var4.addProperty("biomeSize", (Number) Integer.valueOf(var1.H));
		var4.addProperty("riverSize", (Number) Integer.valueOf(var1.I));
		var4.addProperty("dirtSize", (Number) Integer.valueOf(var1.J));
		var4.addProperty("dirtCount", (Number) Integer.valueOf(var1.K));
		var4.addProperty("dirtMinHeight", (Number) Integer.valueOf(var1.L));
		var4.addProperty("dirtMaxHeight", (Number) Integer.valueOf(var1.M));
		var4.addProperty("gravelSize", (Number) Integer.valueOf(var1.N));
		var4.addProperty("gravelCount", (Number) Integer.valueOf(var1.O));
		var4.addProperty("gravelMinHeight", (Number) Integer.valueOf(var1.P));
		var4.addProperty("gravelMaxHeight", (Number) Integer.valueOf(var1.Q));
		var4.addProperty("graniteSize", (Number) Integer.valueOf(var1.R));
		var4.addProperty("graniteCount", (Number) Integer.valueOf(var1.S));
		var4.addProperty("graniteMinHeight", (Number) Integer.valueOf(var1.T));
		var4.addProperty("graniteMaxHeight", (Number) Integer.valueOf(var1.U));
		var4.addProperty("dioriteSize", (Number) Integer.valueOf(var1.V));
		var4.addProperty("dioriteCount", (Number) Integer.valueOf(var1.W));
		var4.addProperty("dioriteMinHeight", (Number) Integer.valueOf(var1.X));
		var4.addProperty("dioriteMaxHeight", (Number) Integer.valueOf(var1.Y));
		var4.addProperty("andesiteSize", (Number) Integer.valueOf(var1.Z));
		var4.addProperty("andesiteCount", (Number) Integer.valueOf(var1.aa));
		var4.addProperty("andesiteMinHeight", (Number) Integer.valueOf(var1.ab));
		var4.addProperty("andesiteMaxHeight", (Number) Integer.valueOf(var1.ac));
		var4.addProperty("coalSize", (Number) Integer.valueOf(var1.ad));
		var4.addProperty("coalCount", (Number) Integer.valueOf(var1.ae));
		var4.addProperty("coalMinHeight", (Number) Integer.valueOf(var1.af));
		var4.addProperty("coalMaxHeight", (Number) Integer.valueOf(var1.ag));
		var4.addProperty("ironSize", (Number) Integer.valueOf(var1.ah));
		var4.addProperty("ironCount", (Number) Integer.valueOf(var1.ai));
		var4.addProperty("ironMinHeight", (Number) Integer.valueOf(var1.aj));
		var4.addProperty("ironMaxHeight", (Number) Integer.valueOf(var1.ak));
		var4.addProperty("goldSize", (Number) Integer.valueOf(var1.al));
		var4.addProperty("goldCount", (Number) Integer.valueOf(var1.am));
		var4.addProperty("goldMinHeight", (Number) Integer.valueOf(var1.an));
		var4.addProperty("goldMaxHeight", (Number) Integer.valueOf(var1.ao));
		var4.addProperty("redstoneSize", (Number) Integer.valueOf(var1.ap));
		var4.addProperty("redstoneCount", (Number) Integer.valueOf(var1.aq));
		var4.addProperty("redstoneMinHeight", (Number) Integer.valueOf(var1.ar));
		var4.addProperty("redstoneMaxHeight", (Number) Integer.valueOf(var1.as));
		var4.addProperty("diamondSize", (Number) Integer.valueOf(var1.at));
		var4.addProperty("diamondCount", (Number) Integer.valueOf(var1.au));
		var4.addProperty("diamondMinHeight", (Number) Integer.valueOf(var1.av));
		var4.addProperty("diamondMaxHeight", (Number) Integer.valueOf(var1.aw));
		var4.addProperty("lapisSize", (Number) Integer.valueOf(var1.ax));
		var4.addProperty("lapisCount", (Number) Integer.valueOf(var1.ay));
		var4.addProperty("lapisCenterHeight", (Number) Integer.valueOf(var1.az));
		var4.addProperty("lapisSpread", (Number) Integer.valueOf(var1.aA));
		return var4;
	}

	// $FF: synthetic method
	public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) {
		return this.a(var1, var2, var3);
	}

	// $FF: synthetic method
	public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
		return this.a((bgn) var1, var2, var3);
	}
}
