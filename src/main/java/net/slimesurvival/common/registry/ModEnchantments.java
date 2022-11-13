package net.slimesurvival.common.registry;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.registry.Registry;
import net.slimesurvival.common.enchantment.AutosmeltEnchantment;
import net.slimesurvival.util.RegistryHelper;

public class ModEnchantments {
	public static final Enchantment AUTOSMELT_ENCHANTMENT = Registry.register(Registry.ENCHANTMENT, RegistryHelper.id("autosmelt"), new AutosmeltEnchantment());





	public static String register() {
		return "Registered Enchantments.";
	}
}
