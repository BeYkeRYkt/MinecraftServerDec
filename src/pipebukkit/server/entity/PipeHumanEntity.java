package pipebukkit.server.entity;

import java.util.Set;

import org.apache.commons.lang.Validate;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.InventoryView.Property;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.permissions.PermissibleBase;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

import pipebukkit.server.inventory.PipeInventoryView;
import pipebukkit.server.inventory.PipeItemStack;
import pipebukkit.server.inventory.PipePlayerInventory;
import net.minecraft.EntityHuman;
import net.minecraft.EntityPlayer;
import net.minecraft.EnumGameMode;
import net.minecraft.server.MinecraftServer;

public abstract class PipeHumanEntity extends PipeLivingEntity implements HumanEntity {

	protected PipePlayerInventory inventory;
	protected final PermissibleBase perm = new PermissibleBase(this);

	public PipeHumanEntity(EntityHuman nmsEntity) {
		super(nmsEntity);
		inventory = new PipePlayerInventory(nmsEntity);
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin) {
		return perm.addAttachment(plugin);
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
		return perm.addAttachment(plugin, ticks);
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
		return perm.addAttachment(plugin, name, value);
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
		return perm.addAttachment(plugin, name, value, ticks);
	}

	@Override
	public Set<PermissionAttachmentInfo> getEffectivePermissions() {
		return perm.getEffectivePermissions();
	}

	@Override
	public boolean hasPermission(String name) {
		return perm.hasPermission(name);
	}

	@Override
	public boolean hasPermission(Permission permission) {
		return perm.hasPermission(permission);
	}

	@Override
	public boolean isPermissionSet(String name) {
		return perm.isPermissionSet(name);
	}

	@Override
	public boolean isPermissionSet(Permission permission) {
		return perm.isPermissionSet(permission);
	}

	@Override
	public void recalculatePermissions() {
		perm.recalculatePermissions();
	}

	@Override
	public void removeAttachment(PermissionAttachment attach) {
		perm.removeAttachment(attach);
	}

	@Override
	public boolean isOp() {
		return MinecraftServer.getInstance().getPlayerList().isOp(getHandle(EntityHuman.class).getGameProfile());
	}

	@Override
	public void setOp(boolean op) {
		if (op == isOp()) {
			return;
		}
		if (op) {
			MinecraftServer.getInstance().getPlayerList().addOp(getHandle(EntityHuman.class).getGameProfile());
		} else {
			MinecraftServer.getInstance().getPlayerList().removeOp(getHandle(EntityHuman.class).getGameProfile());
		}
		recalculatePermissions();
	}

	@Override
	public void closeInventory() {
		getHandle(EntityHuman.class).closeWindow();
	}

	@Override
	public PlayerInventory getInventory() {
		return inventory;
	}

	@Override
	public Inventory getEnderChest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getExpToLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("deprecation")
	@Override
	public GameMode getGameMode() {
		if (this instanceof PipePlayer) {
			return GameMode.getByValue(getHandle(EntityPlayer.class).playerInteractManager.getGameMode().getId());
		}
		return GameMode.SURVIVAL;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setGameMode(GameMode gameMode) {
		Validate.notNull(gameMode, "Mode cannot be null");
		if (gameMode == getGameMode()) {
			return;
		}
		if (this instanceof PipePlayer) {
			if (getHandle(EntityPlayer.class).playerConnection == null) {
				return;
			}
			getHandle(EntityPlayer.class).setGameMode(EnumGameMode.getById(gameMode.getValue()));
		}
	}

	@Override
	public ItemStack getItemInHand() {
		return getInventory().getItemInHand();
	}

	@Override
	public void setItemInHand(ItemStack itemStack) {
		getInventory().setItemInHand(itemStack);
	}

	@Override
	public ItemStack getItemOnCursor() {
		return new PipeItemStack(getHandle(EntityHuman.class).playerInventory.getCarried());
	}

	@Override
	public void setItemOnCursor(ItemStack carried) {
		getHandle(EntityHuman.class).playerInventory.setCarried(new PipeItemStack(carried).getHandle());
		if (this instanceof PipePlayer) {
			getHandle(EntityPlayer.class).broadcastCarriedItem();
		}
	}

	@Override
	public String getName() {
		return getHandle(EntityHuman.class).getName();
	}

	@Override
	public InventoryView getOpenInventory() {
		return new PipeInventoryView(this, getHandle(EntityHuman.class).activeContainer.getPipeInventory());
	}

	@Override
	public int getSleepTicks() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isBlocking() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSleeping() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public InventoryView openEnchanting(Location arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InventoryView openInventory(Inventory arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void openInventory(InventoryView arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InventoryView openWorkbench(Location arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setWindowProperty(Property arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

}
