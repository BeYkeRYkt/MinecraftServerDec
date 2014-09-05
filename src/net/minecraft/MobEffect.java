package net.minecraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MobEffect {

	private static final Logger logger = LogManager.getLogger();
	private int id;
	private int duration;
	private int amplifier;
	private boolean splash;
	private boolean ambient;
	private boolean showParticles;

	public MobEffect(int id, int duration) {
		this(id, duration, 0);
	}

	public MobEffect(int id, int duration, int amplifier) {
		this(id, duration, amplifier, false, true);
	}

	public MobEffect(int id, int duration, int amplifier, boolean ambient, boolean particlesHidden) {
		this.id = id;
		this.duration = duration;
		this.amplifier = amplifier;
		this.ambient = ambient;
		this.showParticles = particlesHidden;
	}

	public MobEffect(MobEffect effect) {
		this.id = effect.id;
		this.duration = effect.duration;
		this.amplifier = effect.amplifier;
		this.ambient = effect.ambient;
		this.showParticles = effect.showParticles;
	}

	public void extend(MobEffect effect) {
		if (this.id != effect.id) {
			logger.warn("This method should only be called for matching effects!");
		}

		if (effect.amplifier > this.amplifier) {
			this.amplifier = effect.amplifier;
			this.duration = effect.duration;
		} else if (effect.amplifier == this.amplifier && this.duration < effect.duration) {
			this.duration = effect.duration;
		} else if (!effect.ambient && this.ambient) {
			this.ambient = effect.ambient;
		}

		this.showParticles = effect.showParticles;
	}

	public int getId() {
		return this.id;
	}

	public int getDuration() {
		return this.duration;
	}

	public int getAmplifier() {
		return this.amplifier;
	}

	public void setSplash(boolean splash) {
		this.splash = splash;
	}

	public boolean isAmbient() {
		return this.ambient;
	}

	public boolean isParticlesShown() {
		return this.showParticles;
	}

	public boolean tick(EntityLiving entityLiving) {
		if (this.duration > 0) {
			if (MobEffectList.byId[this.id].shouldTick(this.duration, this.amplifier)) {
				MobEffectList.byId[this.id].tick(entityLiving, this.amplifier);
			}

			this.decreaseDuration();
		}

		return this.duration > 0;
	}

	private int decreaseDuration() {
		return --this.duration;
	}

	public String getName() {
		return MobEffectList.byId[this.id].getName();
	}

	public int hashCode() {
		return this.id;
	}

	public String toString() {
		String string = "";
		if (this.getAmplifier() > 0) {
			string = this.getName() + " x " + (this.getAmplifier() + 1) + ", Duration: " + this.getDuration();
		} else {
			string = this.getName() + ", Duration: " + this.getDuration();
		}

		if (this.splash) {
			string = string + ", Splash: true";
		}

		if (!this.showParticles) {
			string = string + ", Particles: false";
		}

		return MobEffectList.byId[this.id].j() ? "(" + string + ")" : string;
	}

	public boolean equals(Object var1) {
		if (!(var1 instanceof MobEffect)) {
			return false;
		} else {
			MobEffect var2 = (MobEffect) var1;
			return this.id == var2.id && this.amplifier == var2.amplifier && this.duration == var2.duration && this.splash == var2.splash && this.ambient == var2.ambient;
		}
	}

	public NBTCompoundTag save(NBTCompoundTag tag) {
		tag.put("Id", (byte) this.getId());
		tag.put("Amplifier", (byte) this.getAmplifier());
		tag.put("Duration", this.getDuration());
		tag.put("Ambient", this.isAmbient());
		tag.put("ShowParticles", this.isParticlesShown());
		return tag;
	}

	public static MobEffect load(NBTCompoundTag tag) {
		byte id = tag.getByte("Id");
		if (id >= 0 && id < MobEffectList.byId.length && MobEffectList.byId[id] != null) {
			byte amplifier = tag.getByte("Amplifier");
			int duration = tag.getInt("Duration");
			boolean ambient = tag.getBoolean("Ambient");
			boolean showParticles = true;
			if (tag.isTagAssignableFrom("ShowParticles", 1)) {
				showParticles = tag.getBoolean("ShowParticles");
			}

			return new MobEffect(id, duration, amplifier, ambient, showParticles);
		} else {
			return null;
		}
	}

}
