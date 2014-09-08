package net.minecraft;

// $FF: synthetic class
class rn {

	// $FF: synthetic field
	static final int[] a;
	// $FF: synthetic field
	static final int[] b;
	// $FF: synthetic field
	static final int[] c = new int[PacketPlayInClientStatus.ClientStatusAction.values().length];

	static {
		try {
			c[PacketPlayInClientStatus.ClientStatusAction.PERFORM_RESPAWN.ordinal()] = 1;
		} catch (NoSuchFieldError var16) {
			;
		}

		try {
			c[PacketPlayInClientStatus.ClientStatusAction.REQUEST_STATS.ordinal()] = 2;
		} catch (NoSuchFieldError var15) {
			;
		}

		try {
			c[PacketPlayInClientStatus.ClientStatusAction.OPEN_INVENTORY_ACHIEVEMENT.ordinal()] = 3;
		} catch (NoSuchFieldError var14) {
			;
		}

		b = new int[PacketPlayInEntityAction.EntityActionAction.values().length];

		try {
			b[PacketPlayInEntityAction.EntityActionAction.START_SNEAKING.ordinal()] = 1;
		} catch (NoSuchFieldError var13) {
			;
		}

		try {
			b[PacketPlayInEntityAction.EntityActionAction.STOP_SNEAKING.ordinal()] = 2;
		} catch (NoSuchFieldError var12) {
			;
		}

		try {
			b[PacketPlayInEntityAction.EntityActionAction.START_SPRINTING.ordinal()] = 3;
		} catch (NoSuchFieldError var11) {
			;
		}

		try {
			b[PacketPlayInEntityAction.EntityActionAction.STOP_SPRINTING.ordinal()] = 4;
		} catch (NoSuchFieldError var10) {
			;
		}

		try {
			b[PacketPlayInEntityAction.EntityActionAction.STOP_SLEEPING.ordinal()] = 5;
		} catch (NoSuchFieldError var9) {
			;
		}

		try {
			b[PacketPlayInEntityAction.EntityActionAction.RIDING_JUMP.ordinal()] = 6;
		} catch (NoSuchFieldError var8) {
			;
		}

		try {
			b[PacketPlayInEntityAction.EntityActionAction.OPEN_INVENTORY.ordinal()] = 7;
		} catch (NoSuchFieldError var7) {
			;
		}

		a = new int[PacketPlayInPlayerDigging.PlayerDiggingAction.values().length];

		try {
			a[PacketPlayInPlayerDigging.PlayerDiggingAction.DROP_ITEM.ordinal()] = 1;
		} catch (NoSuchFieldError var6) {
			;
		}

		try {
			a[PacketPlayInPlayerDigging.PlayerDiggingAction.DROP_ALL_ITEMS.ordinal()] = 2;
		} catch (NoSuchFieldError var5) {
			;
		}

		try {
			a[PacketPlayInPlayerDigging.PlayerDiggingAction.RELEASE_USE_ITEM.ordinal()] = 3;
		} catch (NoSuchFieldError var4) {
			;
		}

		try {
			a[PacketPlayInPlayerDigging.PlayerDiggingAction.START_DESTROY_BLOCK.ordinal()] = 4;
		} catch (NoSuchFieldError var3) {
			;
		}

		try {
			a[PacketPlayInPlayerDigging.PlayerDiggingAction.ABORT_DESTROY_BLOCK.ordinal()] = 5;
		} catch (NoSuchFieldError var2) {
			;
		}

		try {
			a[PacketPlayInPlayerDigging.PlayerDiggingAction.STOP_DESTROY_BLOCK.ordinal()] = 6;
		} catch (NoSuchFieldError var1) {
			;
		}

	}
}
