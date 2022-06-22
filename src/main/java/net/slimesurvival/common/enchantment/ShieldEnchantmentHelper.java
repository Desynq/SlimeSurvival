package net.slimesurvival.common.enchantment;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.slimesurvival.registry.ModEnchantments;

public class ShieldEnchantmentHelper extends EnchantmentHelper {

	public static boolean hasBarbed(LivingEntity entity) {
		return getEquipmentLevel(ModEnchantments.BARBED_ENCHANTMENT, entity) == 1;
	}
}