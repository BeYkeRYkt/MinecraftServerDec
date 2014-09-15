package net.minecraft;

import net.minecraft.util.io.netty.util.internal.ThreadLocalRandom;
import java.util.Random;
import java.util.UUID;
import org.apache.commons.lang3.Validate;

public class AttributeModifier {

	private final double amount;
	private final int operation;
	private final String name;
	private final UUID uuid;
	private boolean serialize;

	public AttributeModifier(String var1, double var2, int var4) {
		this(MathHelper.a((Random) ThreadLocalRandom.current()), var1, var2, var4);
	}

	public AttributeModifier(UUID uuid, String name, double var3, int operation) {
		this.serialize = true;
		this.uuid = uuid;
		this.name = name;
		this.amount = var3;
		this.operation = operation;
		Validate.notEmpty(name, "Modifier name cannot be empty", new Object[0]);
		Validate.inclusiveBetween(0L, 2L, (long) operation, "Invalid operation");
	}

	public UUID getUUID() {
		return this.uuid;
	}

	public String getName() {
		return this.name;
	}

	public int getOperation() {
		return this.operation;
	}

	public double getAmount() {
		return this.amount;
	}

	public boolean isSerializable() {
		return this.serialize;
	}

	public AttributeModifier setSerializable(boolean flag) {
		this.serialize = flag;
		return this;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj != null && this.getClass() == obj.getClass()) {
			AttributeModifier var2 = (AttributeModifier) obj;
			if (this.uuid != null) {
				if (!this.uuid.equals(var2.uuid)) {
					return false;
				}
			} else if (var2.uuid != null) {
				return false;
			}

			return true;
		} else {
			return false;
		}
	}

	public int hashCode() {
		return this.uuid != null ? this.uuid.hashCode() : 0;
	}

	public String toString() {
		return "AttributeModifier{amount=" + this.amount + ", operation=" + this.operation + ", name=\'" + this.name + '\'' + ", id=" + this.uuid + ", serialize=" + this.serialize + '}';
	}

}
