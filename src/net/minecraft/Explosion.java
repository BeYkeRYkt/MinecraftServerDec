package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.entity.EntityExplodeEvent;

public class Explosion {

	private final boolean setFire;
	private final boolean breakBlocks;
	private final Random random = new Random();
	private final WorldServer world;
	private final double x;
	private final double y;
	private final double z;
	private final Entity entity;
	private final float power;
	private final List<Position> affectedBlocks = Lists.newArrayList();
	private final Map<EntityHuman, Vec3D> affectedPlayers = Maps.newHashMap();
	private boolean isCancelled = false;

	public Explosion(WorldServer world, Entity entity, double x, double y, double z, float power, boolean setFire, boolean breakBlocks) {
		this.world = world;
		this.entity = entity;
		this.power = power;
		this.x = x;
		this.y = y;
		this.z = z;
		this.setFire = setFire;
		this.breakBlocks = breakBlocks;
	}

	public void damageEntities() {
		for (int i = 0; i < 16; ++i) {
			for (int j = 0; j < 16; ++j) {
				for (int k = 0; k < 16; ++k) {
					if (i == 0 || i == 15 || j == 0 || j == 15 || k == 0 || k == 15) {
						double var6 = (double) ((float) i / 15.0F * 2.0F - 1.0F);
						double var8 = (double) ((float) j / 15.0F * 2.0F - 1.0F);
						double var10 = (double) ((float) k / 15.0F * 2.0F - 1.0F);
						double var12 = Math.sqrt(var6 * var6 + var8 * var8 + var10 * var10);
						var6 /= var12;
						var8 /= var12;
						var10 /= var12;
						float realPower = this.power * (0.7F + this.world.random.nextFloat() * 0.6F);
						double x = this.x;
						double y = this.y;
						double z = this.z;

						for (; realPower > 0.0F; realPower -= 0.22500001F) {
							Position position = new Position(x, y, z);
							IBlockState blockState = this.world.getBlockState(position);
							if (blockState.getBlock().getMaterial() != Material.AIR) {
								float powerDecrease = this.entity != null ? this.entity.a(this, this.world, position, blockState) : blockState.getBlock().a((Entity) null);
								realPower -= (powerDecrease + 0.3F) * 0.3F;
							}

							if (realPower > 0.0F && (this.entity == null || this.entity.a(this, this.world, position, blockState, realPower))) {
								affectedBlocks.add(position);
							}

							x += var6 * 0.30000001192092896D;
							y += var8 * 0.30000001192092896D;
							z += var10 * 0.30000001192092896D;
						}
					}
				}
			}
		}

		float var30 = this.power * 2.0F;
		int var4 = MathHelper.toFixedPointInt(this.x - (double) var30 - 1.0D);
		int var5 = MathHelper.toFixedPointInt(this.x + (double) var30 + 1.0D);
		int var31 = MathHelper.toFixedPointInt(this.y - (double) var30 - 1.0D);
		int var7 = MathHelper.toFixedPointInt(this.y + (double) var30 + 1.0D);
		int var32 = MathHelper.toFixedPointInt(this.z - (double) var30 - 1.0D);
		int var9 = MathHelper.toFixedPointInt(this.z + (double) var30 + 1.0D);
		List<Entity> entities = this.world.getEntities(this.entity, new AxisAlignedBB((double) var4, (double) var31, (double) var32, (double) var5, (double) var7, (double) var9));
		Vec3D var11 = new Vec3D(this.x, this.y, this.z);

		for (int i = 0; i < entities.size(); ++i) {
			Entity var13 = entities.get(i);
			if (!var13.aV()) {
				double var35 = var13.f(this.x, this.y, this.z) / (double) var30;
				if (var35 <= 1.0D) {
					double var16 = var13.locationX - this.x;
					double var18 = var13.locationY + (double) var13.getHeadHeight() - this.y;
					double var20 = var13.locationZ - this.z;
					double var36 = (double) MathHelper.sqrt(var16 * var16 + var18 * var18 + var20 * var20);
					if (var36 != 0.0D) {
						var16 /= var36;
						var18 /= var36;
						var20 /= var36;
						double var37 = (double) this.world.a(var11, var13.getBoundingBox());
						double var26 = (1.0D - var35) * var37;
						var13.receiveDamage(DamageSource.explosion(this), (float) ((int) ((var26 * var26 + var26) / 2.0D * 8.0D * (double) var30 + 1.0D)));
						double var28 = EnchantmentProtection.a(var13, var26);
						var13.motionX += var16 * var28;
						var13.motionY += var18 * var28;
						var13.motionZ += var20 * var28;
						if (var13 instanceof EntityHuman) {
							this.affectedPlayers.put((EntityHuman) var13, new Vec3D(var16 * var26, var18 * var26, var20 * var26));
						}
					}
				}
			}
		}

	}

	public void destroyBlocks(boolean displayParticles) {
		this.world.makeSound(this.x, this.y, this.z, "random.explode", 4.0F, (1.0F + (this.world.random.nextFloat() - this.world.random.nextFloat()) * 0.2F) * 0.7F);
		if (this.power >= 2.0F && this.breakBlocks) {
			this.world.addParticle(Particle.c, this.x, this.y, this.z, 1.0D, 0.0D, 0.0D, new int[0]);
		} else {
			this.world.addParticle(Particle.b, this.x, this.y, this.z, 1.0D, 0.0D, 0.0D, new int[0]);
		}

		if (this.breakBlocks) {

			org.bukkit.World bukkitWorld = world.getBukkitWorld();
			List<org.bukkit.block.Block> blocks = new ArrayList<org.bukkit.block.Block>();
			for (Position aposition : affectedBlocks) {
				blocks.add(bukkitWorld.getBlockAt(aposition.getX(), aposition.getY(), aposition.getZ()));
			}
			EntityExplodeEvent explodeEvent = new EntityExplodeEvent(
				entity != null ? entity.getBukkitEntity(org.bukkit.entity.Entity.class) : null, 
				new Location(bukkitWorld, x, y, z), 
				blocks, 
				power
			);
			Bukkit.getPluginManager().callEvent(explodeEvent);
			if (explodeEvent.isCancelled()) {
				isCancelled = true;
				return;
			}
			affectedBlocks.clear();
			for (org.bukkit.block.Block bukkitBlock : explodeEvent.blockList()) {
				affectedBlocks.add(new Position(bukkitBlock.getX(), bukkitBlock.getY(), bukkitBlock.getZ()));
			}

			for (Position position : affectedBlocks) {
				Block block = this.world.getBlockState(position).getBlock();
				if (displayParticles) {
					double var5 = (double) ((float) position.getX() + this.world.random.nextFloat());
					double var7 = (double) ((float) position.getY() + this.world.random.nextFloat());
					double var9 = (double) ((float) position.getZ() + this.world.random.nextFloat());
					double var11 = var5 - this.x;
					double var13 = var7 - this.y;
					double var15 = var9 - this.z;
					double var17 = (double) MathHelper.sqrt(var11 * var11 + var13 * var13 + var15 * var15);
					var11 /= var17;
					var13 /= var17;
					var15 /= var17;
					double var19 = 0.5D / (var17 / (double) this.power + 0.1D);
					var19 *= (double) (this.world.random.nextFloat() * this.world.random.nextFloat() + 0.3F);
					var11 *= var19;
					var13 *= var19;
					var15 *= var19;
					this.world.addParticle(Particle.a, (var5 + this.x * 1.0D) / 2.0D, (var7 + this.y * 1.0D) / 2.0D, (var9 + this.z * 1.0D) / 2.0D, var11, var13, var15, new int[0]);
					this.world.addParticle(Particle.l, var5, var7, var9, var11, var13, var15, new int[0]);
				}

				if (block.getMaterial() != Material.AIR) {
					if (block.a(this)) {
						block.dropNaturally(this.world, position, this.world.getBlockState(position), 1.0F / this.power, 0);
					}

					this.world.setBlockAt(position, Blocks.AIR.getBlockState(), 3);
					block.a(this.world, position, this);
				}
			}
		}

		if (this.setFire) {
			for (Position position : affectedBlocks) {
				if (this.world.getBlockState(position).getBlock().getMaterial() == Material.AIR && this.world.getBlockState(position.getDown()).getBlock().m() && this.random.nextInt(3) == 0) {
					this.world.a(position, Blocks.FIRE.getBlockState());
				}
			}
		}

	}

	public boolean isCancelled() {
		return isCancelled;
	}

	public Map<EntityHuman, Vec3D> getAffectedPlayers() {
		return this.affectedPlayers;
	}

	public EntityLiving getIgniter() {
		return this.entity == null ? null : (this.entity instanceof EntityTNTPrimed ? ((EntityTNTPrimed) this.entity).j() : (this.entity instanceof EntityLiving ? (EntityLiving) this.entity : null));
	}

	public void clearAffectedBlocks() {
		this.affectedBlocks.clear();
	}

	public List<Position> getAffectedBlocks() {
		return this.affectedBlocks;
	}

}
