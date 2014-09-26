package pipebukkit.server.block;

import net.minecraft.TileEntityMobSpawner;

import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EntityType;

@SuppressWarnings("deprecation")
public class PipeMobSpawner extends PipeBlockState implements CreatureSpawner {

	private TileEntityMobSpawner spawner;

	public PipeMobSpawner(PipeBlock block) {
		super(block);
		spawner = (TileEntityMobSpawner) getTileEntity();
	}

	@Override
	public CreatureType getCreatureType() {
		return CreatureType.fromEntityType(getSpawnedType());
	}

	@Override
	public EntityType getSpawnedType() {
		return EntityType.fromName(getCreatureTypeId());
	}

	@Override
	public String getCreatureTypeId() {
		return getCreatureTypeName();
	}

	@Override
	public String getCreatureTypeName() {
		return spawner.getSpawner().getEntityId();
	}

	@Override
	public int getDelay() {
		return spawner.getSpawner().getDelay();
	}

	@Override
	public void setCreatureType(CreatureType type) {
		setSpawnedType(type.toEntityType());
	}

	@Override
	public void setSpawnedType(EntityType type) {
		setCreatureTypeByName(type.getName());
	}

	@Override
	public void setCreatureTypeByName(String name) {
		setCreatureTypeId(name);
	}

	@Override
	public void setCreatureTypeId(String id) {
		spawner.getSpawner().setMobName(id);
	}

	@Override
	public void setDelay(int delay) {
		spawner.getSpawner().setDelay(delay);
	}

}
