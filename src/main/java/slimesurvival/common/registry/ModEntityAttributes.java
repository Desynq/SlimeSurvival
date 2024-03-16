package slimesurvival.common.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import slimesurvival.SlimeSurvival;

public class ModEntityAttributes {
	public static final Attribute DODGE_CHANCE = createAttribute("dodge_chance", 0, 0, Double.MAX_VALUE);
	public static final Attribute CHANCE_TO_NOT_CONSUME_AMMO = createAttribute("chance_to_not_consume_ammo", 0, 0, Double.MAX_VALUE);
	public static final Attribute MAX_MANA = createAttribute("max_mana", 100, 0, Double.MAX_VALUE);
	public static final Attribute PASSIVE_MANA_REGEN_RATE = createAttribute("max_mana", 0, 0, Double.MAX_VALUE);



	private static Attribute createAttribute(final String name, double base, double min, double max) {
		return new RangedAttribute("attribute.name." + SlimeSurvival.MOD_ID + "." + name, base, min, max).setSyncable(true);
	}

	private static void registerAttribute(Attribute attribute, String path) {
		Registry.register(BuiltInRegistries.ATTRIBUTE, SlimeSurvival.ID(path), attribute);
	}


	public static void register() {
		registerAttribute(DODGE_CHANCE, "dodge_chance");
		registerAttribute(CHANCE_TO_NOT_CONSUME_AMMO, "chance_to_not_consume_ammo");
		registerAttribute(MAX_MANA, "max_mana");
		registerAttribute(PASSIVE_MANA_REGEN_RATE, "passive_mana_regen_rate");
	}
}
