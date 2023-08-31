package slimesurvival.registry;

import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import slimesurvival.SlimeSurvival;

public class ModEntityAttributes {
	public static final EntityAttribute DODGE_CHANCE = createAttribute("dodge_chance", 0, 0, 1);



	private static EntityAttribute createAttribute(final String name, double base, double min, double max) {
		return new ClampedEntityAttribute("attribute.name.generic." + SlimeSurvival.MOD_ID + "." + name, base, min, max).setTracked(true);
	}


	public static void register() {
		Registry.register(Registries.ATTRIBUTE, SlimeSurvival.ID("dodge_chance"), DODGE_CHANCE);
	}
}
