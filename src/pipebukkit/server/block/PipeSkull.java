package pipebukkit.server.block;

import net.minecraft.TileEntitySkull;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.com.google.common.collect.HashBiMap;
import net.minecraft.util.com.mojang.authlib.GameProfile;

import org.bukkit.SkullType;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Skull;

public class PipeSkull extends PipeBlockState implements Skull {

	private static HashBiMap<Integer, SkullType> skullTypeMap = HashBiMap.create(); 
	private static HashBiMap<Integer, BlockFace> blockFaceMap = HashBiMap.create();
	static {
		skullTypeMap.put(0, SkullType.SKELETON);
		skullTypeMap.put(1, SkullType.WITHER);
		skullTypeMap.put(2, SkullType.ZOMBIE);
		skullTypeMap.put(3, SkullType.PLAYER);
		skullTypeMap.put(4, SkullType.CREEPER);
		blockFaceMap.put(0, BlockFace.NORTH);
		blockFaceMap.put(1, BlockFace.NORTH_NORTH_EAST);
		blockFaceMap.put(2, BlockFace.NORTH_EAST);
		blockFaceMap.put(3, BlockFace.EAST_NORTH_EAST);
		blockFaceMap.put(4, BlockFace.EAST);
		blockFaceMap.put(5, BlockFace.EAST_SOUTH_EAST);
		blockFaceMap.put(6, BlockFace.SOUTH_EAST);
		blockFaceMap.put(7, BlockFace.SOUTH_SOUTH_EAST);
		blockFaceMap.put(8, BlockFace.SOUTH);
		blockFaceMap.put(9, BlockFace.SOUTH_SOUTH_WEST);
		blockFaceMap.put(10, BlockFace.SOUTH_WEST);
		blockFaceMap.put(11, BlockFace.WEST_SOUTH_WEST);
		blockFaceMap.put(12, BlockFace.WEST);
		blockFaceMap.put(13, BlockFace.WEST_NORTH_WEST);
		blockFaceMap.put(14, BlockFace.NORTH_WEST);
		blockFaceMap.put(15, BlockFace.NORTH_NORTH_WEST);
	}

	private TileEntitySkull skull;
	private GameProfile profile;
	private SkullType type;
	private BlockFace rotation;

	public PipeSkull(PipeBlock block) {
		super(block);
		skull = (TileEntitySkull) getTileEntity();
		profile = skull.getGameProfile();
		type = skullTypeMap.get(skull.getSkullType());
		rotation = blockFaceMap.get(skull.getRotation());
	}

	@Override
	public boolean hasOwner() {
		return profile != null;
	}

	@Override
	public String getOwner() {
		return profile.getName();
	}

	@Override
	public boolean setOwner(String owner) {
		if (owner == null || owner.length() > 16) {
			return false;
		}
		GameProfile profile = MinecraftServer.getInstance().getUserCache().getProfile(owner);
		if (profile == null) {
			return false;
		}
		if (type != SkullType.PLAYER) {
			type = SkullType.PLAYER;
		}
		this.profile = profile;
		return true;
	}

	@Override
	public SkullType getSkullType() {
		return type;
	}

	@Override
	public void setSkullType(SkullType type) {
		this.type = type;
	}

	@Override
	public BlockFace getRotation() {
		return rotation;
	}

	@Override
	public void setRotation(BlockFace rotation) {
		this.rotation = rotation;
	}

	@Override
	public boolean update(boolean force, boolean applyPhysics) {
		if (super.update(force, applyPhysics)) {
			if (type == SkullType.PLAYER) {
				skull.setGameProfile(profile);
			} else {
				skull.setSkullType(skullTypeMap.inverse().get(skull));
			}
			skull.setRotation(blockFaceMap.inverse().get(rotation));
			skull.update();
		}
		return false;
	}

}
