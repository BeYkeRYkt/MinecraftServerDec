package pipebukkit.server.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.minecraft.EntityArrow;
import net.minecraft.server.MinecraftServer;

import org.bukkit.Bukkit;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

public abstract class PipeEntity implements Entity {

	protected net.minecraft.Entity nmsEntity;
	private EntityDamageEvent lastDamage;

	public PipeEntity(net.minecraft.Entity nmsEntity) {
		this.nmsEntity = nmsEntity;
	}

	public net.minecraft.Entity getHandle() {
		return nmsEntity;
	}

	@Override
	public List<MetadataValue> getMetadata(String metadataKey) {
		MinecraftServer.getInstance().getPipeServer().getEntityMetadataStorage().getMetadata(this, metadataKey);
		return null;
	}

	@Override
	public boolean hasMetadata(String metadataKey) {
		return MinecraftServer.getInstance().getPipeServer().getEntityMetadataStorage().hasMetadata(this, metadataKey);
	}

	@Override
	public void removeMetadata(String metadataKey, Plugin owningPlugin) {
		MinecraftServer.getInstance().getPipeServer().getEntityMetadataStorage().removeMetadata(this, metadataKey, owningPlugin);
	}

	@Override
	public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
		MinecraftServer.getInstance().getPipeServer().getEntityMetadataStorage().setMetadata(this, metadataKey, newMetadataValue);
	}

	@Override
	public boolean eject() {
		if (isEmpty()) {
			return false;
		}
		nmsEntity.passenger.mount(null);
		return true;
	}

	@Override
	public int getEntityId() {
		return nmsEntity.getId();
	}

	@Override
	public float getFallDistance() {
		return nmsEntity.fallDistance;
	}

	@Override
	public int getFireTicks() {
		return nmsEntity.fireTicks;
	}

	@Override
	public EntityDamageEvent getLastDamageCause() {
		return lastDamage;
	}

	@Override
	public Location getLocation() {
		return new Location(getWorld(), nmsEntity.locationX, nmsEntity.locationY, nmsEntity.locationZ, nmsEntity.yaw, nmsEntity.pitch);
	}

	@Override
	public Location getLocation(Location store) {
		if (store != null) {
			store.setWorld(getWorld());
			store.setX(nmsEntity.locationX);
			store.setY(nmsEntity.locationY);
			store.setZ(nmsEntity.locationZ);
			store.setYaw(nmsEntity.yaw);
			store.setPitch(nmsEntity.pitch);
		}
		return store;
	}

	@Override
	public int getMaxFireTicks() {
		return nmsEntity.maxFireTicks;
	}

	@Override
	public List<Entity> getNearbyEntities(double x, double y, double z) {
		 List<net.minecraft.Entity> nmsEntityList = nmsEntity.world.getEntities(nmsEntity, nmsEntity.getBoundingBox().grow(x, y, z));
		 List<Entity> list = new ArrayList<Entity>((int) (nmsEntityList.size() * 1.5));
		 for (net.minecraft.Entity nmsEntity : nmsEntityList) {
			 list.add(nmsEntity.getBukkitEntity(Entity.class));
		 }
		return list;
	}

	@Override
	public Entity getPassenger() {
		return nmsEntity.passenger.getBukkitEntity(Entity.class);
	}

	@Override
	public Server getServer() {
		return Bukkit.getServer();
	}

	@Override
	public int getTicksLived() {
		return nmsEntity.ticksLived;
	}

	@Override
	public UUID getUniqueId() {
		return nmsEntity.getUUID();
	}

	@Override
	public Entity getVehicle() {
		return nmsEntity.vehicle.getBukkitEntity(Entity.class);
	}

	@Override
	public Vector getVelocity() {
		return new Vector(nmsEntity.motionX, nmsEntity.motionY, nmsEntity.motionZ);
	}

	@Override
	public World getWorld() {
		return nmsEntity.world.getBukkitWorld();
	}

	@Override
	public boolean isDead() {
		return nmsEntity.dead;
	}

	@Override
	public boolean isEmpty() {
		return nmsEntity.passenger == null;
	}

	@Override
	public boolean isInsideVehicle() {
		return nmsEntity.vehicle != null;
	}

	@Override
	public boolean isOnGround() {
		if (nmsEntity instanceof EntityArrow) {
			return ((EntityArrow) nmsEntity).isInGround();
		}
		return nmsEntity.onGround;
	}

	@Override
	public boolean isValid() {
		return nmsEntity.isAlive() && nmsEntity.valid;
	}

	@Override
	public boolean leaveVehicle() {
		if (!isInsideVehicle()) {
			return false;
		}
		nmsEntity.mount(null);
		return true;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void playEffect(EntityEffect effect) {
		nmsEntity.world.broadcastEntityEffect(nmsEntity, effect.getData());
	}

	@Override
	public void remove() {
		nmsEntity.dead = true;
	}

	@Override
	public void setFallDistance(float dist) {
		nmsEntity.fallDistance = dist;
	}

	@Override
	public void setFireTicks(int ticks) {
		nmsEntity.fireTicks = ticks;
	}

	@Override
	public void setLastDamageCause(EntityDamageEvent event) {
		lastDamage = event;
	}

	@Override
	public boolean setPassenger(Entity entity) {
		if (entity instanceof PipeEntity) {
			((PipeEntity) entity).getHandle().mount(nmsEntity);
			return true;
		}
		return false;
	}

	@Override
	public void setTicksLived(int ticks) {
		nmsEntity.ticksLived = ticks;
	}

	@Override
	public void setVelocity(Vector vector) {
		nmsEntity.motionX = vector.getX();
		nmsEntity.motionY = vector.getY();
		nmsEntity.motionZ = vector.getZ();
	}

	@Override
	public boolean teleport(Location location) {
		return teleport(location, TeleportCause.PLUGIN);
	}

	@Override
	public boolean teleport(Entity entity) {
		return teleport(entity, TeleportCause.PLUGIN);
	}

	@Override
	public boolean teleport(Location location, TeleportCause cause) {
		return teleport0(location, cause);
	}

	@Override
	public boolean teleport(Entity entity, TeleportCause cause) {
		return teleport0(entity.getLocation(), cause);
	}

	private boolean teleport0(Location location, TeleportCause cause) {
		if (nmsEntity.passenger != null || nmsEntity.dead || getWorld() != location.getWorld()) {
			return false;
		}
		nmsEntity.mount(null);
		nmsEntity.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
		return true;
	}

	@SuppressWarnings("unchecked")
	public <T extends net.minecraft.Entity> T getHandle(Class<T> returnType) {
		return (T) nmsEntity;
	}

}
