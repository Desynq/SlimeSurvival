package net.slimesurvival.common.registry;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.registry.Registry;
import net.slimesurvival.SlimeSurvival;
import net.slimesurvival.common.enchantment.*;

public class ModEnchantments {

	public static final Enchantment PUMMELING_ENCHANTMENT = Registry.register(Registry.ENCHANTMENT, SlimeSurvival.ID("pummeling"), new PummelingEnchantment(Enchantment.Rarity.COMMON, false, false));
	public static final Enchantment BARBED_ENCHANTMENT = Registry.register(Registry.ENCHANTMENT, SlimeSurvival.ID("barbed"), new BarbedEnchantment(Enchantment.Rarity.COMMON, false, false));

	public static final Enchantment AUTOSMELT_ENCHANTMENT = Registry.register(Registry.ENCHANTMENT, SlimeSurvival.ID("autosmelt"), new AutosmeltEnchantment());





	public static void register() {
	}
}
