package net.slimesurvival.common.registry;

import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import net.minecraft.util.registry.Registry;
import net.slimesurvival.common.power.*;

public class ModPowerFactories {

	public static void register() {
		register(BouncyPower.getFactory());
	}



	private static void register(PowerFactory<?> serializer) {
		Registry.register(ApoliRegistries.POWER_FACTORY, serializer.getSerializerId(), serializer);
	}
}
