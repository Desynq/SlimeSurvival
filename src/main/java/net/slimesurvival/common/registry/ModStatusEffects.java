package net.slimesurvival.common.registry;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.registry.Registry;
import net.slimesurvival.SlimeSurvival;
import net.slimesurvival.common.status_effect.Unsafe;

public class ModStatusEffects {

	public static final StatusEffect UNSAFE_STATUS_EFFECT = Registry.register(Registry.STATUS_EFFECT, SlimeSurvival.ID("unsafe"), new Unsafe());



	public static void register() {
	}
}
