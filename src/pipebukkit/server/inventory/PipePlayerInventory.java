package pipebukkit.server.inventory;

import org.apache.commons.lang.Validate;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import net.minecraft.EntityHuman;
import net.minecraft.EntityPlayer;
import net.minecraft.InventoryPlayer;
import net.minecraft.Item;
import net.minecraft.PacketPlayOutHeldItemChange;

public class PipePlayerInventory extends PipeInventory implements PlayerInventory, EntityEquipment {

	private EntityHuman owner;

	public PipePlayerInventory(EntityHuman owner) {
		super(owner.playerInventory);
	}

	@Override
	public InventoryType getType() {
		return InventoryType.PLAYER;
	}

	@Override
	public int getHeldItemSlot() {
		return owner.playerInventory.itemInHandIndex;
	}

	@Override
	public void setHeldItemSlot(int slot) {
		Validate.isTrue(slot >= 0 && slot < InventoryPlayer.getHotbarSize(), "Slot is not between 0 and 8 inclusive");
		owner.playerInventory.itemInHandIndex = slot;
		if (owner instanceof EntityPlayer) {
			((EntityPlayer) owner).playerConnection.sendPacket(new PacketPlayOutHeldItemChange(slot));
		}
	}

	@Override
	public ItemStack getItemInHand() {
		return new PipeItemStack(owner.playerInventory.getItemInHand());
	}

	@Override
	public void setItemInHand(ItemStack itemStack) {
		setItem(getHeldItemSlot(), itemStack);
	}

	@Override
	public int clear(int id, int data) {
		int cleared = 0;
		for (int i = 0; i < owner.playerInventory.contents.length; i++) {
			net.minecraft.ItemStack itemStack = owner.playerInventory.contents[i];
			if (itemStack != null) {
				if ((id == -1 || Item.getId(itemStack.getItem()) == id) && (data == -1 || itemStack.getWearout() == data)) {
					owner.playerInventory.contents[i] = null;
					cleared++;
				}
			}
		}
		for (int i = 0; i < owner.playerInventory.armor.length; i++) {
			net.minecraft.ItemStack itemStack = owner.playerInventory.armor[i];
			if (itemStack != null) {
				if ((id == -1 || Item.getId(itemStack.getItem()) == id) && (data == -1 || itemStack.getWearout() == data)) {
					owner.playerInventory.armor[i] = null;
					cleared++;
				}
			}
		}
		return cleared;
	}

	@Override
	public ItemStack[] getArmorContents() {
		ItemStack[] result = new ItemStack[4];
		for (int i = 0; i < 4; i++) {
			result[i] = new PipeItemStack(owner.playerInventory.armor[i]);
		}
		return result;
	}

	@Override
	public ItemStack getBoots() {
		return new PipeItemStack(owner.getArmor(0));
	}

	@Override
	public ItemStack getLeggings() {
		return new PipeItemStack(owner.getArmor(1));
	}

	@Override
	public ItemStack getChestplate() {
		return new PipeItemStack(owner.getArmor(2));
	}

	@Override
	public ItemStack getHelmet() {
		return new PipeItemStack(owner.getArmor(3));
	}

	@Override
	public void setArmorContents(ItemStack[] armorContents) {
		if (armorContents == null) {
			armorContents = new ItemStack[4];
		}
		for (int i = 0; i < 4; i++) {
			owner.playerInventory.armor[i] = new PipeItemStack(armorContents[i]).getHandle();
		}
	}

	@Override
	public void setBoots(ItemStack boots) {
		owner.setArmor(0, new PipeItemStack(boots).getHandle());
	}

	@Override
	public void setLeggings(ItemStack leggins) {
		owner.setArmor(1, new PipeItemStack(leggins).getHandle());
	}

	@Override
	public void setChestplate(ItemStack chestplate) {
		owner.setArmor(2, new PipeItemStack(chestplate).getHandle());
	}

	@Override
	public void setHelmet(ItemStack helmet) {
		owner.setArmor(3, new PipeItemStack(helmet).getHandle());
	}

	@Override
	public HumanEntity getHolder() {
		return owner.getBukkitEntity(HumanEntity.class);
	}

	@Override
	public float getBootsDropChance() {
		return 1;
	}

	@Override
	public float getChestplateDropChance() {
		return 1;
	}

	@Override
	public float getHelmetDropChance() {
		return 1;
	}

	@Override
	public float getItemInHandDropChance() {
		return 1;
	}

	@Override
	public float getLeggingsDropChance() {
		return 1;
	}

	@Override
	public void setBootsDropChance(float chance) {
	}

	@Override
	public void setChestplateDropChance(float chance) {
	}

	@Override
	public void setHelmetDropChance(float chance) {
	}

	@Override
	public void setItemInHandDropChance(float chance) {
	}

	@Override
	public void setLeggingsDropChance(float chance) {
	}

}
