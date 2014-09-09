package net.minecraft;

public class PacketAsyncToSyncThrower {

	public static void schedulePacketHandleIfNeeded(Packet<? extends PacketListener> packet, PacketListener listener, ITaskScheduler scheduler) {
		if (!scheduler.isMainThread()) {
			scheduler.scheduleSyncTask(new ih(packet, listener));
			throw UhandledPacketException.instance;
		}
	}

}
