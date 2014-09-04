package net.minecraft;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

final class st implements ParameterizedType {

	public Type[] getActualTypeArguments() {
		return new Type[] { sr.class };
	}

	public Type getRawType() {
		return List.class;
	}

	public Type getOwnerType() {
		return null;
	}
}
