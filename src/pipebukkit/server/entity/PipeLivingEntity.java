package pipebukkit.server.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import net.minecraft.EntityLiving;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public abstract class PipeLivingEntity extends PipeEntity implements LivingEntity {

	public PipeLivingEntity(EntityLiving nmsEntity) {
		super(nmsEntity);
	}

	@Override
	public void _INVALID_damage(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void _INVALID_damage(int arg0, Entity arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int _INVALID_getHealth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int _INVALID_getMaxHealth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void _INVALID_setHealth(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void _INVALID_setMaxHealth(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void damage(double arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void damage(double arg0, Entity arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getHealth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getMaxHealth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void resetMaxHealth() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHealth(double arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMaxHealth(double arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> arg0, Vector arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int _INVALID_getLastDamage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void _INVALID_setLastDamage(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addPotionEffect(PotionEffect arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPotionEffect(PotionEffect arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPotionEffects(Collection<PotionEffect> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<PotionEffect> getActivePotionEffects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getCanPickupItems() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getCustomName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityEquipment getEquipment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getEyeHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getEyeHeight(boolean arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Location getEyeLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getKiller() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getLastDamage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Block> getLastTwoTargetBlocks(HashSet<Byte> arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity getLeashHolder() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Block> getLineOfSight(HashSet<Byte> arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMaximumAir() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaximumNoDamageTicks() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNoDamageTicks() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRemainingAir() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getRemoveWhenFarAway() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Block getTargetBlock(HashSet<Byte> arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasLineOfSight(Entity arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasPotionEffect(PotionEffectType arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCustomNameVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLeashed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removePotionEffect(PotionEffectType arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCanPickupItems(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCustomName(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCustomNameVisible(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLastDamage(double arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean setLeashHolder(Entity arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setMaximumAir(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMaximumNoDamageTicks(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNoDamageTicks(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRemainingAir(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRemoveWhenFarAway(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Arrow shootArrow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Egg throwEgg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Snowball throwSnowball() {
		// TODO Auto-generated method stub
		return null;
	}

}
