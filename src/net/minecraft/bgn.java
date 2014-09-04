package net.minecraft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class bgn {

	static final Gson a = (new GsonBuilder()).registerTypeAdapter(bgn.class, new bgo()).create();
	public float b = 684.412F;
	public float c = 684.412F;
	public float d = 512.0F;
	public float e = 512.0F;
	public float f = 200.0F;
	public float g = 200.0F;
	public float h = 0.5F;
	public float i = 80.0F;
	public float j = 160.0F;
	public float k = 80.0F;
	public float l = 8.5F;
	public float m = 12.0F;
	public float n = 1.0F;
	public float o = 0.0F;
	public float p = 1.0F;
	public float q = 0.0F;
	public int r = 63;
	public boolean s = true;
	public boolean t = true;
	public int u = 8;
	public boolean v = true;
	public boolean w = true;
	public boolean x = true;
	public boolean y = true;
	public boolean z = true;
	public boolean A = true;
	public boolean B = true;
	public int C = 4;
	public boolean D = true;
	public int E = 80;
	public boolean F = false;
	public int G = -1;
	public int H = 4;
	public int I = 4;
	public int J = 33;
	public int K = 10;
	public int L = 0;
	public int M = 256;
	public int N = 33;
	public int O = 8;
	public int P = 0;
	public int Q = 256;
	public int R = 33;
	public int S = 10;
	public int T = 0;
	public int U = 80;
	public int V = 33;
	public int W = 10;
	public int X = 0;
	public int Y = 80;
	public int Z = 33;
	public int aa = 10;
	public int ab = 0;
	public int ac = 80;
	public int ad = 17;
	public int ae = 20;
	public int af = 0;
	public int ag = 128;
	public int ah = 9;
	public int ai = 20;
	public int aj = 0;
	public int ak = 64;
	public int al = 9;
	public int am = 2;
	public int an = 0;
	public int ao = 32;
	public int ap = 8;
	public int aq = 8;
	public int ar = 0;
	public int as = 16;
	public int at = 8;
	public int au = 1;
	public int av = 0;
	public int aw = 16;
	public int ax = 7;
	public int ay = 1;
	public int az = 16;
	public int aA = 16;

	public static bgn a(String var0) {
		if (var0.length() == 0) {
			return new bgn();
		} else {
			try {
				return (bgn) a.fromJson(var0, bgn.class);
			} catch (Exception var2) {
				return new bgn();
			}
		}
	}

	public String toString() {
		return a.toJson((Object) this);
	}

	public bgn() {
		this.a();
	}

	public void a() {
		this.b = 684.412F;
		this.c = 684.412F;
		this.d = 512.0F;
		this.e = 512.0F;
		this.f = 200.0F;
		this.g = 200.0F;
		this.h = 0.5F;
		this.i = 80.0F;
		this.j = 160.0F;
		this.k = 80.0F;
		this.l = 8.5F;
		this.m = 12.0F;
		this.n = 1.0F;
		this.o = 0.0F;
		this.p = 1.0F;
		this.q = 0.0F;
		this.r = 63;
		this.s = true;
		this.t = true;
		this.u = 8;
		this.v = true;
		this.w = true;
		this.x = true;
		this.y = true;
		this.z = true;
		this.A = true;
		this.B = true;
		this.C = 4;
		this.D = true;
		this.E = 80;
		this.F = false;
		this.G = -1;
		this.H = 4;
		this.I = 4;
		this.J = 33;
		this.K = 10;
		this.L = 0;
		this.M = 256;
		this.N = 33;
		this.O = 8;
		this.P = 0;
		this.Q = 256;
		this.R = 33;
		this.S = 10;
		this.T = 0;
		this.U = 80;
		this.V = 33;
		this.W = 10;
		this.X = 0;
		this.Y = 80;
		this.Z = 33;
		this.aa = 10;
		this.ab = 0;
		this.ac = 80;
		this.ad = 17;
		this.ae = 20;
		this.af = 0;
		this.ag = 128;
		this.ah = 9;
		this.ai = 20;
		this.aj = 0;
		this.ak = 64;
		this.al = 9;
		this.am = 2;
		this.an = 0;
		this.ao = 32;
		this.ap = 8;
		this.aq = 8;
		this.ar = 0;
		this.as = 16;
		this.at = 8;
		this.au = 1;
		this.av = 0;
		this.aw = 16;
		this.ax = 7;
		this.ay = 1;
		this.az = 16;
		this.aA = 16;
	}

	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else if (var1 != null && this.getClass() == var1.getClass()) {
			bgn var2 = (bgn) var1;
			return this.aa != var2.aa ? false : (this.ac != var2.ac ? false : (this.ab != var2.ab ? false : (this.Z != var2.Z ? false : (Float.compare(var2.l, this.l) != 0 ? false : (Float.compare(var2.o, this.o) != 0 ? false : (Float.compare(var2.n, this.n) != 0 ? false : (Float.compare(var2.q, this.q) != 0 ? false : (Float.compare(var2.p, this.p) != 0 ? false : (this.H != var2.H ? false : (this.ae != var2.ae ? false : (this.ag != var2.ag ? false : (this.af != var2.af ? false
					: (this.ad != var2.ad ? false : (Float.compare(var2.b, this.b) != 0 ? false : (Float.compare(var2.h, this.h) != 0 ? false : (Float.compare(var2.f, this.f) != 0 ? false : (Float.compare(var2.g, this.g) != 0 ? false : (this.au != var2.au ? false : (this.aw != var2.aw ? false : (this.av != var2.av ? false : (this.at != var2.at ? false : (this.W != var2.W ? false : (this.Y != var2.Y ? false : (this.X != var2.X ? false : (this.V != var2.V ? false : (this.K != var2.K ? false
							: (this.M != var2.M ? false : (this.L != var2.L ? false : (this.J != var2.J ? false : (this.u != var2.u ? false : (this.G != var2.G ? false : (this.am != var2.am ? false : (this.ao != var2.ao ? false : (this.an != var2.an ? false : (this.al != var2.al ? false : (this.S != var2.S ? false : (this.U != var2.U ? false : (this.T != var2.T ? false : (this.R != var2.R ? false : (this.O != var2.O ? false : (this.Q != var2.Q ? false : (this.P != var2.P ? false
									: (this.N != var2.N ? false : (Float.compare(var2.c, this.c) != 0 ? false : (this.ai != var2.ai ? false : (this.ak != var2.ak ? false : (this.aj != var2.aj ? false : (this.ah != var2.ah ? false : (this.az != var2.az ? false : (this.ay != var2.ay ? false : (this.ax != var2.ax ? false : (this.aA != var2.aA ? false : (this.E != var2.E ? false : (Float.compare(var2.e, this.e) != 0 ? false : (Float.compare(var2.i, this.i) != 0 ? false : (Float.compare(var2.j,
											this.j) != 0 ? false : (Float.compare(var2.k, this.k) != 0 ? false : (this.aq != var2.aq ? false : (this.as != var2.as ? false : (this.ar != var2.ar ? false : (this.ap != var2.ap ? false : (this.I != var2.I ? false : (this.r != var2.r ? false : (Float.compare(var2.m, this.m) != 0 ? false : (Float.compare(var2.d, this.d) != 0 ? false : (this.s != var2.s ? false : (this.t != var2.t ? false : (this.D != var2.D ? false : (this.F != var2.F ? false
											: (this.x != var2.x ? false : (this.A != var2.A ? false : (this.v != var2.v ? false : (this.y != var2.y ? false : (this.z != var2.z ? false : (this.w != var2.w ? false : (this.B != var2.B ? false : this.C == var2.C))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))));
		} else {
			return false;
		}
	}

	public int hashCode() {
		int var1 = this.b != 0.0F ? Float.floatToIntBits(this.b) : 0;
		var1 = 31 * var1 + (this.c != 0.0F ? Float.floatToIntBits(this.c) : 0);
		var1 = 31 * var1 + (this.d != 0.0F ? Float.floatToIntBits(this.d) : 0);
		var1 = 31 * var1 + (this.e != 0.0F ? Float.floatToIntBits(this.e) : 0);
		var1 = 31 * var1 + (this.f != 0.0F ? Float.floatToIntBits(this.f) : 0);
		var1 = 31 * var1 + (this.g != 0.0F ? Float.floatToIntBits(this.g) : 0);
		var1 = 31 * var1 + (this.h != 0.0F ? Float.floatToIntBits(this.h) : 0);
		var1 = 31 * var1 + (this.i != 0.0F ? Float.floatToIntBits(this.i) : 0);
		var1 = 31 * var1 + (this.j != 0.0F ? Float.floatToIntBits(this.j) : 0);
		var1 = 31 * var1 + (this.k != 0.0F ? Float.floatToIntBits(this.k) : 0);
		var1 = 31 * var1 + (this.l != 0.0F ? Float.floatToIntBits(this.l) : 0);
		var1 = 31 * var1 + (this.m != 0.0F ? Float.floatToIntBits(this.m) : 0);
		var1 = 31 * var1 + (this.n != 0.0F ? Float.floatToIntBits(this.n) : 0);
		var1 = 31 * var1 + (this.o != 0.0F ? Float.floatToIntBits(this.o) : 0);
		var1 = 31 * var1 + (this.p != 0.0F ? Float.floatToIntBits(this.p) : 0);
		var1 = 31 * var1 + (this.q != 0.0F ? Float.floatToIntBits(this.q) : 0);
		var1 = 31 * var1 + this.r;
		var1 = 31 * var1 + (this.s ? 1 : 0);
		var1 = 31 * var1 + (this.t ? 1 : 0);
		var1 = 31 * var1 + this.u;
		var1 = 31 * var1 + (this.v ? 1 : 0);
		var1 = 31 * var1 + (this.w ? 1 : 0);
		var1 = 31 * var1 + (this.x ? 1 : 0);
		var1 = 31 * var1 + (this.y ? 1 : 0);
		var1 = 31 * var1 + (this.z ? 1 : 0);
		var1 = 31 * var1 + (this.A ? 1 : 0);
		var1 = 31 * var1 + (this.B ? 1 : 0);
		var1 = 31 * var1 + this.C;
		var1 = 31 * var1 + (this.D ? 1 : 0);
		var1 = 31 * var1 + this.E;
		var1 = 31 * var1 + (this.F ? 1 : 0);
		var1 = 31 * var1 + this.G;
		var1 = 31 * var1 + this.H;
		var1 = 31 * var1 + this.I;
		var1 = 31 * var1 + this.J;
		var1 = 31 * var1 + this.K;
		var1 = 31 * var1 + this.L;
		var1 = 31 * var1 + this.M;
		var1 = 31 * var1 + this.N;
		var1 = 31 * var1 + this.O;
		var1 = 31 * var1 + this.P;
		var1 = 31 * var1 + this.Q;
		var1 = 31 * var1 + this.R;
		var1 = 31 * var1 + this.S;
		var1 = 31 * var1 + this.T;
		var1 = 31 * var1 + this.U;
		var1 = 31 * var1 + this.V;
		var1 = 31 * var1 + this.W;
		var1 = 31 * var1 + this.X;
		var1 = 31 * var1 + this.Y;
		var1 = 31 * var1 + this.Z;
		var1 = 31 * var1 + this.aa;
		var1 = 31 * var1 + this.ab;
		var1 = 31 * var1 + this.ac;
		var1 = 31 * var1 + this.ad;
		var1 = 31 * var1 + this.ae;
		var1 = 31 * var1 + this.af;
		var1 = 31 * var1 + this.ag;
		var1 = 31 * var1 + this.ah;
		var1 = 31 * var1 + this.ai;
		var1 = 31 * var1 + this.aj;
		var1 = 31 * var1 + this.ak;
		var1 = 31 * var1 + this.al;
		var1 = 31 * var1 + this.am;
		var1 = 31 * var1 + this.an;
		var1 = 31 * var1 + this.ao;
		var1 = 31 * var1 + this.ap;
		var1 = 31 * var1 + this.aq;
		var1 = 31 * var1 + this.ar;
		var1 = 31 * var1 + this.as;
		var1 = 31 * var1 + this.at;
		var1 = 31 * var1 + this.au;
		var1 = 31 * var1 + this.av;
		var1 = 31 * var1 + this.aw;
		var1 = 31 * var1 + this.ax;
		var1 = 31 * var1 + this.ay;
		var1 = 31 * var1 + this.az;
		var1 = 31 * var1 + this.aA;
		return var1;
	}

	public bgl b() {
		return new bgl(this, (bgm) null);
	}

}
