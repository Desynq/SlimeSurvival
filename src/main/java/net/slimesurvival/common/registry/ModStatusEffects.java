package net.slimesurvival.common.registry;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.slimesurvival.SlimeSurvival;
import net.slimesurvival.common.status_effects.*;

public class ModStatusEffects {
	public static final StatusEffect RIFTING_STATUS_EFFECT = new RiftingStatusEffect();



	public static void register() {
		register(SlimeSurvival.ID("rifting"), RIFTING_STATUS_EFFECT);
	}

	private static void register(Identifier id, StatusEffect statusEffect) {
		Registry.register(Registry.STATUS_EFFECT, id, statusEffect);
	}
}
