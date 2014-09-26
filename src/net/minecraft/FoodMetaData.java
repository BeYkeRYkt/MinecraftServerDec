package net.minecraft;

public class FoodMetaData {

	private int foodLevel = 20;
	private float foodSaturationLevel = 5.0F;
	private float foodExhaustionLevel;
	private int foodTickTimer;
	private int e = 20;

	public void a(int var1, float var2) {
		this.foodLevel = Math.min(var1 + this.foodLevel, 20);
		this.foodSaturationLevel = Math.min(this.foodSaturationLevel + (float) var1 * var2 * 2.0F, (float) this.foodLevel);
	}

	public void a(ItemFood var1, ItemStack var2) {
		this.a(var1.h(var2), var1.i(var2));
	}

	public void a(EntityHuman var1) {
		Difficulty var2 = var1.world.getDifficulty();
		this.e = this.foodLevel;
		if (this.foodExhaustionLevel > 4.0F) {
			this.foodExhaustionLevel -= 4.0F;
			if (this.foodSaturationLevel > 0.0F) {
				this.foodSaturationLevel = Math.max(this.foodSaturationLevel - 1.0F, 0.0F);
			} else if (var2 != Difficulty.PEACEFUL) {
				this.foodLevel = Math.max(this.foodLevel - 1, 0);
			}
		}

		if (var1.world.getGameRules().isGameRule("naturalRegeneration") && this.foodLevel >= 18 && var1.cl()) {
			++this.foodTickTimer;
			if (this.foodTickTimer >= 80) {
				var1.g(1.0F);
				this.a(3.0F);
				this.foodTickTimer = 0;
			}
		} else if (this.foodLevel <= 0) {
			++this.foodTickTimer;
			if (this.foodTickTimer >= 80) {
				if (var1.getHealth() > 10.0F || var2 == Difficulty.HARD || var1.getHealth() > 1.0F && var2 == Difficulty.NORMAL) {
					var1.receiveDamage(DamageSource.STARVE, 1.0F);
				}

				this.foodTickTimer = 0;
			}
		} else {
			this.foodTickTimer = 0;
		}

	}

	public void a(NBTCompoundTag var1) {
		if (var1.isTagAssignableFrom("foodLevel", 99)) {
			this.foodLevel = var1.getInt("foodLevel");
			this.foodTickTimer = var1.getInt("foodTickTimer");
			this.foodSaturationLevel = var1.getFloat("foodSaturationLevel");
			this.foodExhaustionLevel = var1.getFloat("foodExhaustionLevel");
		}

	}

	public void b(NBTCompoundTag var1) {
		var1.put("foodLevel", this.foodLevel);
		var1.put("foodTickTimer", this.foodTickTimer);
		var1.put("foodSaturationLevel", this.foodSaturationLevel);
		var1.put("foodExhaustionLevel", this.foodExhaustionLevel);
	}

	public int getFoodLevel() {
		return this.foodLevel;
	}

	public boolean c() {
		return this.foodLevel < 20;
	}

	public void a(float var1) {
		this.foodExhaustionLevel = Math.min(this.foodExhaustionLevel + var1, 40.0F);
	}

	public float getSaturationLevel() {
		return this.foodSaturationLevel;
	}

	public void a(int var1) {
		this.foodLevel = var1;
	}
}
