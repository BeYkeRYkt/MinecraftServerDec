package net.minecraft;

import java.util.Collection;

public class AttributeSnapshot {

	private final String name;
	private final double c;
	private final Collection<AttributeModifier> modifiers;

	public AttributeSnapshot(String name, double var3, Collection<AttributeModifier> var5) {
		this.name = name;
		this.c = var3;
		this.modifiers = var5;
	}

	public String getName() {
		return this.name;
	}

	public double getValue() {
		return this.c;
	}

	public Collection<AttributeModifier> getModifiers() {
		return this.modifiers;
	}

}
