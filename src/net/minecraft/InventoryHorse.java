package net.minecraft;

import org.bukkit.entity.Horse;
import org.bukkit.inventory.InventoryHolder;

public class InventoryHorse extends InventorySubcontainer {

	private EntityHorse horse;

	public InventoryHorse(EntityHorse horse, String name, int size) {
		super(name, false, size);
		this.horse = horse;
	}

	@Override
	public InventoryHolder getHolder() {
		return horse.getBukkitEntity(Horse.class);
	}

}
