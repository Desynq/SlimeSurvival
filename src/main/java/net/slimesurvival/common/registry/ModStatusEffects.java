package net.slimesurvival.common.registry;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.slimesurvival.common.status_effect.*;
import net.slimesurvival.util.RegistryHelper;

public class ModStatusEffects {
	public static final StatusEffect RIFTING_STATUS_EFFECT = new RiftingStatusEffect();



	public static String register() {
		register(RegistryHelper.id("rifting"), RIFTING_STATUS_EFFECT);

		return "Registered Status Effects.";
	}

	private static void register(Identifier id, StatusEffect statusEffect) {
		Registry.register(Registry.STATUS_EFFECT, id, statusEffect);
	}
}
