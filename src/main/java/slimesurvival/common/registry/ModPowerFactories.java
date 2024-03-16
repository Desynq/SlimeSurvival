package slimesurvival.common.registry;

import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import net.minecraft.core.Registry;
import slimesurvival.common.power.UnextinguishablePower;

public class ModPowerFactories {
	
	public static void register() {
		register(UnextinguishablePower.getFactory());
	}

	private static void register(PowerFactory<?> serializer) {
		Registry.register(ApoliRegistries.POWER_FACTORY, serializer.getSerializerId(), serializer);
	}
}
