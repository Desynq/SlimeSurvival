package slimesurvival.common.registry;

import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import slimesurvival.SlimeSurvival;

public class ModEntityAttributes {
	public static final EntityAttribute DODGE_CHANCE = createAttribute("dodge_chance", 0, 0, Integer.MAX_VALUE);
	public static final EntityAttribute CHANCE_TO_NOT_CONSUME_AMMO = createAttribute("chance_to_not_consume_ammo", 0, 0, Integer.MAX_VALUE);



	private static EntityAttribute createAttribute(final String name, double base, double min, double max) {
		return new ClampedEntityAttribute("attribute.name." + SlimeSurvival.MOD_ID + "." + name, base, min, max).setTracked(true);
	}


	public static void register() {
		Registry.register(Registries.ATTRIBUTE, SlimeSurvival.ID("dodge_chance"), DODGE_CHANCE);
	}
}
