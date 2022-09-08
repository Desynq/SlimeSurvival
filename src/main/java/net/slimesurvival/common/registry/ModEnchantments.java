package net.slimesurvival.common.registry;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.registry.Registry;
import net.slimesurvival.SlimeSurvival;
import net.slimesurvival.common.enchantment.*;

public class ModEnchantments {
	public static final Enchantment AUTOSMELT_ENCHANTMENT = Registry.register(Registry.ENCHANTMENT, SlimeSurvival.ID("autosmelt"), new AutosmeltEnchantment());





	public static void register() {
	}
}
