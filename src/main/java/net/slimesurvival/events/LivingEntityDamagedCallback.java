package net.slimesurvival.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

public interface LivingEntityDamagedCallback {
	Event<LivingEntityDamagedCallback> EVENT = EventFactory.createArrayBacked(
		LivingEntityDamagedCallback.class,
		(listeners) -> (entity, attacker, random) -> {
			if (entity != null && attacker != null) {
				for (LivingEntityDamagedCallback listener : listeners) {
					listener.damage(entity, attacker, random);
				}
			}
		}
	);

	void damage(LivingEntity entity, DamageSource source, float amount);
}
