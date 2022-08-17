package net.slimesurvival.common.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class AutosmeltEnchantment extends Enchantment {

	public AutosmeltEnchantment() {
		super(Rarity.VERY_RARE, EnchantmentTarget.DIGGER, new EquipmentSlot[] { EquipmentSlot.MAINHAND });
	}



	@Override
	public int getMinPower(int level) {
		return 25;
	}

	@Override
	public int getMaxPower(int level) {
		return 50;
	}
}
