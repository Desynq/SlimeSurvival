package slimesurvival.common.registry;

import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import slimesurvival.SlimeSurvival;

public class ModEntityAttributes {
	public static final EntityAttribute DODGE_CHANCE = createAttribute("dodge_chance", 0, 0, Double.MAX_VALUE);
	public static final EntityAttribute CHANCE_TO_NOT_CONSUME_AMMO = createAttribute("chance_to_not_consume_ammo", 0, 0, Double.MAX_VALUE);
	public static final EntityAttribute MAX_MANA = createAttribute("max_mana", 100, 0, Double.MAX_VALUE);
	public static final EntityAttribute PASSIVE_MANA_REGEN_RATE = createAttribute("max_mana", 0, 0, Double.MAX_VALUE);



	private static EntityAttribute createAttribute(final String name, double base, double min, double max) {
		return new ClampedEntityAttribute("attribute.name." + SlimeSurvival.MOD_ID + "." + name, base, min, max).setTracked(true);
	}

	private static void registerAttribute(EntityAttribute Attribute, String path) {
		Registry.register(Registries.ATTRIBUTE, SlimeSurvival.ID(path), Attribute);
	}


	public static void register() {
		registerAttribute(DODGE_CHANCE, "dodge_chance");
		registerAttribute(CHANCE_TO_NOT_CONSUME_AMMO, "chance_to_not_consume_ammo");
		registerAttribute(MAX_MANA, "max_mana");
		registerAttribute(PASSIVE_MANA_REGEN_RATE, "passive_mana_regen_rate");
	}
}
