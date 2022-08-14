package net.slimesurvival.common.status_effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class Unsafe extends StatusEffect {

	public Unsafe() {
		super(StatusEffectCategory.NEUTRAL, 0xE39C22);
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}

	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
	}
}
