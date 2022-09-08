package net.slimesurvival.common.item.weapon.ranged;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.slimesurvival.common.interfaces.InitialStackStateProvider;
import net.slimesurvival.common.item.CustomBowItem;
import net.slimesurvival.common.registry.ModItemGroups;

public class MystiteShortbow extends CustomBowItem implements InitialStackStateProvider {
	
	public MystiteShortbow(Settings settings) {
		super(settings
			.maxDamage(2000)
			.fireproof()
			.group(ModItemGroups.RANGED_WEAPONS)
		);
	}



	@Override
	public double getBaseProjectileDamage() {
		return 2.0;
	}



	@Override
	public void initializeState(ItemStack stack) {
		Map<Enchantment, Integer> defaultEnchants = new HashMap<>();

		defaultEnchants.put(Enchantments.QUICK_CHARGE, 2);

		EnchantmentHelper.set(defaultEnchants, stack);
	}
}
