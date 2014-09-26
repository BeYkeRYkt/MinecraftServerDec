package pipebukkit.server.projectiles;

import net.minecraft.TileEntityDispenser;

import org.bukkit.block.Block;
import org.bukkit.entity.Projectile;
import org.bukkit.projectiles.BlockProjectileSource;
import org.bukkit.util.Vector;

public class PipeBlockProjectileSource implements BlockProjectileSource {

	private TileEntityDispenser dispenser;

	public PipeBlockProjectileSource(TileEntityDispenser dispenser) {
		this.dispenser = dispenser;
	}

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> projectileClass) {
		return launchProjectile(projectileClass, null);
	}

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> projectileClass, Vector vector) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Block getBlock() {
		return dispenser.getWorld().getBukkitWorld().getBlockAt(dispenser.getPosition().getX(), dispenser.getPosition().getY(), dispenser.getPosition().getZ());
	}

}
