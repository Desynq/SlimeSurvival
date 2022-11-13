package net.slimesurvival.common.registry;

import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.util.registry.Registry;
import net.slimesurvival.util.RegistryHelper;

public class ModEntityAttributes {

	public static final EntityAttribute DODGE_CHANCE_ATTRIBUTE = Registry.register(Registry.ATTRIBUTE, RegistryHelper.id("dodge_chance"), new ClampedEntityAttribute("attribute.name.slimesurvival.dodge_chance", 0.00, 0.0, 1.0));
	
	public static void register() {}
}
