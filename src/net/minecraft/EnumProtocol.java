package net.minecraft;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;

import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.hash.TIntObjectHashMap;

import java.util.Iterator;
import java.util.Map;

import org.apache.logging.log4j.LogManager;

public enum EnumProtocol {

	a("HANDSHAKING", 0, -1) {
		{
			this.a(ie.a, mz.class);
		}
	},
	b("PLAY", 1, 0) {
		{
			this.a(ie.b, jp.class);
			this.a(ie.b, jw.class);
			this.a(ie.b, iz.class);
			this.a(ie.b, li.class);
			this.a(ie.b, la.class);
			this.a(ie.b, lh.class);
			this.a(ie.b, lc.class);
			this.a(ie.b, kp.class);
			this.a(ie.b, ii.class);
			this.a(ie.b, kv.class);
			this.a(ie.b, kl.class);
			this.a(ie.b, ir.class);
			this.a(ie.b, iq.class);
			this.a(ie.b, ln.class);
			this.a(ie.b, il.class);
			this.a(ie.b, io.class);
			this.a(ie.b, ip.class);
			this.a(ie.b, im.class);
			this.a(ie.b, kz.class);
			this.a(ie.b, km.class);
			this.a(ie.b, jy.class);
			this.a(ie.b, jz.class);
			this.a(ie.b, kb.class);
			this.a(ie.b, ka.class);
			this.a(ie.b, lo.class);
			this.a(ie.b, kq.class);
			this.a(ie.b, jk.class);
			this.a(ie.b, ky.class);
			this.a(ie.b, kx.class);
			this.a(ie.b, lr.class);
			this.a(ie.b, kn.class);
			this.a(ie.b, lb.class);
			this.a(ie.b, lp.class);
			this.a(ie.b, jq.class);
			this.a(ie.b, ja.class);
			this.a(ie.b, iw.class);
			this.a(ie.b, iv.class);
			this.a(ie.b, it.class);
			this.a(ie.b, js.class);
			this.a(ie.b, jm.class);
			this.a(ie.b, jt.class);
			this.a(ie.b, jv.class);
			this.a(ie.b, ju.class);
			this.a(ie.b, jo.class);
			this.a(ie.b, in.class);
			this.a(ie.b, je.class);
			this.a(ie.b, jd.class);
			this.a(ie.b, jh.class);
			this.a(ie.b, jf.class);
			this.a(ie.b, jg.class);
			this.a(ie.b, jc.class);
			this.a(ie.b, ll.class);
			this.a(ie.b, jx.class);
			this.a(ie.b, iu.class);
			this.a(ie.b, kc.class);
			this.a(ie.b, is.class);
			this.a(ie.b, kh.class);
			this.a(ie.b, kd.class);
			this.a(ie.b, iy.class);
			this.a(ie.b, ld.class);
			this.a(ie.b, lf.class);
			this.a(ie.b, kw.class);
			this.a(ie.b, le.class);
			this.a(ie.b, ji.class);
			this.a(ie.b, jj.class);
			this.a(ie.b, ix.class);
			this.a(ie.b, ke.class);
			this.a(ie.b, ku.class);
			this.a(ie.b, kr.class);
			this.a(ie.b, lj.class);
			this.a(ie.b, jn.class);
			this.a(ie.b, lm.class);
			this.a(ie.b, ko.class);
			this.a(ie.b, jl.class);
			this.a(ie.a, mf.class);
			this.a(ie.a, lu.class);
			this.a(ie.a, md.class);
			this.a(ie.a, mg.class);
			this.a(ie.a, mh.class);
			this.a(ie.a, mj.class);
			this.a(ie.a, mi.class);
			this.a(ie.a, ml.class);
			this.a(ie.a, mx.class);
			this.a(ie.a, ms.class);
			this.a(ie.a, mv.class);
			this.a(ie.a, mn.class);
			this.a(ie.a, mp.class);
			this.a(ie.a, mb.class);
			this.a(ie.a, ma.class);
			this.a(ie.a, ly.class);
			this.a(ie.a, mt.class);
			this.a(ie.a, lz.class);
			this.a(ie.a, mu.class);
			this.a(ie.a, mk.class);
			this.a(ie.a, lt.class);
			this.a(ie.a, lx.class);
			this.a(ie.a, lv.class);
			this.a(ie.a, mc.class);
			this.a(ie.a, mw.class);
			this.a(ie.a, mq.class);
		}
	},
	c("STATUS", 2, 1) {
		{
			this.a(ie.a, nx.class);
			this.a(ie.b, no.class);
			this.a(ie.a, nw.class);
			this.a(ie.b, nn.class);
		}
	},
	d("LOGIN", 3, 2) {
		{
			this.a(ie.b, ng.class);
			this.a(ie.b, ne.class);
			this.a(ie.b, nd.class);
			this.a(ie.b, nf.class);
			this.a(ie.a, ni.class);
			this.a(ie.a, nj.class);
		}
	};
	private static final TIntObjectMap e = new TIntObjectHashMap();
	private static final Map f = Maps.newHashMap();
	private final int g;
	private final Map h;

	private EnumProtocol(String var1, int var2, int var3) {
		this.h = Maps.newEnumMap(ie.class);
		this.g = var3;
	}

	protected EnumProtocol a(ie var1, Class var2) {
		Object var3 = (BiMap) this.h.get(var1);
		if (var3 == null) {
			var3 = HashBiMap.create();
			this.h.put(var1, var3);
		}

		if (((BiMap) var3).containsValue(var2)) {
			String var4 = var1 + " packet " + var2 + " is already known to ID " + ((BiMap) var3).inverse().get(var2);
			LogManager.getLogger().fatal(var4);
			throw new IllegalArgumentException(var4);
		} else {
			((BiMap) var3).put(Integer.valueOf(((BiMap) var3).size()), var2);
			return this;
		}
	}

	public Integer a(ie var1, id var2) {
		return (Integer) ((BiMap) this.h.get(var1)).inverse().get(var2.getClass());
	}

	public id a(ie var1, int var2) throws InstantiationException, IllegalAccessException {
		Class var3 = (Class) ((BiMap) this.h.get(var1)).get(Integer.valueOf(var2));
		return var3 == null ? null : (id) var3.newInstance();
	}

	public int a() {
		return this.g;
	}

	public static EnumProtocol a(int var0) {
		return (EnumProtocol) e.get(var0);
	}

	public static EnumProtocol a(id var0) {
		return (EnumProtocol) f.get(var0.getClass());
	}

	static {
		EnumProtocol[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			EnumProtocol var3 = var0[var2];
			e.put(var3.a(), var3);
			Iterator var4 = var3.h.keySet().iterator();

			while (var4.hasNext()) {
				ie var5 = (ie) var4.next();

				Class var7;
				for (Iterator var6 = ((BiMap) var3.h.get(var5)).values().iterator(); var6.hasNext(); f.put(var7, var3)) {
					var7 = (Class) var6.next();
					if (f.containsKey(var7) && f.get(var7) != var3) {
						throw new Error("Packet " + var7 + " is already assigned to protocol " + f.get(var7) + " - can\'t reassign to " + var3);
					}

					try {
						var7.newInstance();
					} catch (Throwable var9) {
						throw new Error("Packet " + var7 + " fails instantiation checks! " + var7);
					}
				}
			}
		}

	}
}
