package net.minecraft;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public abstract class MobSpawnerAbstract {

	private int spawnDelay = 20;
	private String mobName = "Pig";
	private final List<TileEntityMobSpawnerData> mobs = Lists.newArrayList();
	private TileEntityMobSpawnerData data;
	private int minSpawnDelay = 200;
	private int maxSpawnDelay = 800;
	private int spawnCount = 4;
	private int naxNearbyEntites = 6;
	private int requiredPlayerRange = 16;
	private int spawnRange = 4;

	public int getDelay() {
		return spawnDelay;
	}

	public void setDelay(int delay) {
		this.spawnDelay = delay;
	}

	public String getEntityId() {
		if (this.getData() == null) {
			if (this.mobName.equals("Minecart")) {
				this.mobName = "MinecartRideable";
			}

			return this.mobName;
		} else {
			return TileEntityMobSpawnerData.a(this.getData());
		}
	}

	public void setMobName(String mobName) {
		this.mobName = mobName;
	}

	private boolean hasPlayerNearby() {
		Position position = this.getPosition();
		return this.getWorld().hasNearbyPlayer(position.getX() + 0.5D, position.getY() + 0.5D, position.getZ() + 0.5D, this.requiredPlayerRange);
	}

	public void doTick() {
		if (this.hasPlayerNearby()) {
			Position position = this.getPosition();
			if (this.getWorld().isStatic) {
				double x = (position.getX() + this.getWorld().random.nextFloat());
				double y = (position.getY() + this.getWorld().random.nextFloat());
				double z = (position.getZ() + this.getWorld().random.nextFloat());
				this.getWorld().addParticle(Particle.l, x, y, z, 0.0D, 0.0D, 0.0D, new int[0]);
				this.getWorld().addParticle(Particle.A, x, y, z, 0.0D, 0.0D, 0.0D, new int[0]);
				if (this.spawnDelay > 0) {
					--this.spawnDelay;
				}
			} else {
				if (this.spawnDelay == -1) {
					this.h();
				}

				if (this.spawnDelay > 0) {
					--this.spawnDelay;
					return;
				}

				boolean var13 = false;

				for (int i = 0; i < this.spawnCount; ++i) {
					Entity entity = EntityTypes.createEntity(this.getEntityId(), this.getWorld());
					if (entity == null) {
						return;
					}

					int entitiesNearby = this.getWorld().getEntititesInAABB(entity.getClass(), (new AxisAlignedBB(position.getX(), position.getY(), position.getZ(), (position.getX() + 1), (position.getY() + 1), (position.getZ() + 1))).grow(this.spawnRange, this.spawnRange, this.spawnRange)).size();
					if (entitiesNearby >= this.naxNearbyEntites) {
						this.h();
						return;
					}

					double x = position.getX() + (this.getWorld().random.nextDouble() - this.getWorld().random.nextDouble()) * this.spawnRange + 0.5D;
					double y = (position.getY() + this.getWorld().random.nextInt(3) - 1);
					double z = position.getZ() + (this.getWorld().random.nextDouble() - this.getWorld().random.nextDouble()) * this.spawnRange + 0.5D;
					EntityInsentient entityinsentient = entity instanceof EntityInsentient ? (EntityInsentient) entity : null;
					entity.setPositionRotation(x, y, z, this.getWorld().random.nextFloat() * 360.0F, 0.0F);
					if (entityinsentient == null || entityinsentient.bQ() && entityinsentient.bR()) {
						this.a(entity, true);
						this.getWorld().triggerEffect(2004, position, 0);
						if (entityinsentient != null) {
							entityinsentient.y();
						}

						var13 = true;
					}
				}

				if (var13) {
					this.h();
				}
			}

		}
	}

	private Entity a(Entity var1, boolean var2) {
		if (this.getData() != null) {
			NBTCompoundTag var3 = new NBTCompoundTag();
			var1.writeIfNoPassenger(var3);
			Iterator<?> var4 = TileEntityMobSpawnerData.b(this.getData()).getKeys().iterator();

			while (var4.hasNext()) {
				String var5 = (String) var4.next();
				NBTTag var6 = TileEntityMobSpawnerData.b(this.getData()).getTag(var5);
				var3.put(var5, var6.getCopy());
			}

			var1.load(var3);
			if (var1.world != null && var2) {
				var1.world.addEntity(var1);
			}

			NBTCompoundTag var12;
			for (Entity var11 = var1; var3.isTagAssignableFrom("Riding", 10); var3 = var12) {
				var12 = var3.getCompound("Riding");
				Entity var13 = EntityTypes.createEntity(var12.getString("id"), var1.world);
				if (var13 != null) {
					NBTCompoundTag var7 = new NBTCompoundTag();
					var13.writeIfNoPassenger(var7);
					Iterator<?> var8 = var12.getKeys().iterator();

					while (var8.hasNext()) {
						String var9 = (String) var8.next();
						NBTTag var10 = var12.getTag(var9);
						var7.put(var9, var10.getCopy());
					}

					var13.load(var7);
					var13.setPositionRotation(var11.locationX, var11.locationY, var11.locationZ, var11.yaw, var11.pitch);
					if (var1.world != null && var2) {
						var1.world.addEntity(var13);
					}

					var11.mount(var13);
				}

				var11 = var13;
			}
		} else if (var1 instanceof EntityLiving && var1.world != null && var2) {
			((EntityInsentient) var1).a(var1.world.E(new Position(var1)), (xq) null);
			var1.world.addEntity(var1);
		}

		return var1;
	}

	private void h() {
		if (this.maxSpawnDelay <= this.minSpawnDelay) {
			this.spawnDelay = this.minSpawnDelay;
		} else {
			int var10003 = this.maxSpawnDelay - this.minSpawnDelay;
			this.spawnDelay = this.minSpawnDelay + this.getWorld().random.nextInt(var10003);
		}

		if (this.mobs.size() > 0) {
			this.setData((TileEntityMobSpawnerData) WeightedRandom.a(this.getWorld().random, this.mobs));
		}

		this.a(1);
	}

	public void read(NBTCompoundTag var1) {
		this.mobName = var1.getString("EntityId");
		this.spawnDelay = var1.getShort("Delay");
		this.mobs.clear();
		if (var1.isTagAssignableFrom("SpawnPotentials", 9)) {
			NBTListTag var2 = var1.getList("SpawnPotentials", 10);

			for (int var3 = 0; var3 < var2.getSize(); ++var3) {
				this.mobs.add(new TileEntityMobSpawnerData(this, var2.getCompound(var3)));
			}
		}

		if (var1.isTagAssignableFrom("SpawnData", 10)) {
			this.setData(new TileEntityMobSpawnerData(this, var1.getCompound("SpawnData"), this.mobName));
		} else {
			this.setData((TileEntityMobSpawnerData) null);
		}

		if (var1.isTagAssignableFrom("MinSpawnDelay", 99)) {
			this.minSpawnDelay = var1.getShort("MinSpawnDelay");
			this.maxSpawnDelay = var1.getShort("MaxSpawnDelay");
			this.spawnCount = var1.getShort("SpawnCount");
		}

		if (var1.isTagAssignableFrom("MaxNearbyEntities", 99)) {
			this.naxNearbyEntites = var1.getShort("MaxNearbyEntities");
			this.requiredPlayerRange = var1.getShort("RequiredPlayerRange");
		}

		if (var1.isTagAssignableFrom("SpawnRange", 99)) {
			this.spawnRange = var1.getShort("SpawnRange");
		}

		if (this.getWorld() != null) {
		}

	}

	public void write(NBTCompoundTag var1) {
		var1.put("EntityId", this.getEntityId());
		var1.put("Delay", (short) this.spawnDelay);
		var1.put("MinSpawnDelay", (short) this.minSpawnDelay);
		var1.put("MaxSpawnDelay", (short) this.maxSpawnDelay);
		var1.put("SpawnCount", (short) this.spawnCount);
		var1.put("MaxNearbyEntities", (short) this.naxNearbyEntites);
		var1.put("RequiredPlayerRange", (short) this.requiredPlayerRange);
		var1.put("SpawnRange", (short) this.spawnRange);
		if (this.getData() != null) {
			var1.put("SpawnData", TileEntityMobSpawnerData.b(this.getData()).getCopy());
		}

		if (this.getData() != null || this.mobs.size() > 0) {
			NBTListTag var2 = new NBTListTag();
			if (this.mobs.size() > 0) {
				Iterator<TileEntityMobSpawnerData> var3 = this.mobs.iterator();

				while (var3.hasNext()) {
					TileEntityMobSpawnerData var4 = (TileEntityMobSpawnerData) var3.next();
					var2.addTag((NBTTag) var4.a());
				}
			} else {
				var2.addTag((NBTTag) this.getData().a());
			}

			var1.put("SpawnPotentials", (NBTTag) var2);
		}

	}

	public boolean b(int var1) {
		if (var1 == 1 && this.getWorld().isStatic) {
			this.spawnDelay = this.minSpawnDelay;
			return true;
		} else {
			return false;
		}
	}

	private TileEntityMobSpawnerData getData() {
		return this.data;
	}

	public void setData(TileEntityMobSpawnerData data) {
		this.data = data;
	}

	public abstract void a(int var1);

	public abstract World getWorld();

	public abstract Position getPosition();

}
