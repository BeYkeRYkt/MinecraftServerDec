package net.minecraft;

import com.google.common.collect.Maps;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class fb implements ez {

	private static final Logger a = LogManager.getLogger();
	protected final Map c = this.b();

	protected Map b() {
		return Maps.newHashMap();
	}

	public Object a(Object var1) {
		return this.c.get(var1);
	}

	public void a(Object var1, Object var2) {
		Validate.notNull(var1);
		Validate.notNull(var2);
		if (this.c.containsKey(var1)) {
			a.debug("Adding duplicate key \'" + var1 + "\' to registry");
		}

		this.c.put(var1, var2);
	}

	public Set c() {
		return Collections.unmodifiableSet(this.c.keySet());
	}

	public boolean d(Object var1) {
		return this.c.containsKey(var1);
	}

	public Iterator iterator() {
		return this.c.values().iterator();
	}

}
