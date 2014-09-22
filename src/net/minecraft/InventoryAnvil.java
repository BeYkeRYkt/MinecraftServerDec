package net.minecraft;

import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.InventoryHolder;

class InventoryAnvil extends InventorySubcontainer {

	private final ContainerAnvil anvilContainer;
	private EntityHuman player;

	InventoryAnvil(EntityHuman player, ContainerAnvil anvilContainer, String name, boolean hasCustomName, int size) {
		super(name, hasCustomName, size);
		this.anvilContainer = anvilContainer;
	}

	public void update() {
		super.update();
		this.anvilContainer.a(this);
	}

	@Override
	public InventoryHolder getHolder() {
		return player.getBukkitEntity(HumanEntity.class);
	}

}
