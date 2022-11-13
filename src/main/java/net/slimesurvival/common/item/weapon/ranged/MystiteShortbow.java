package net.slimesurvival.common.item.weapon.ranged;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.projectiledamage.api.IProjectileWeapon;
import net.slimesurvival.common.registry.ModItemGroups;
import net.slimesurvival.util.interfaces.InitialStackStateProvider;

public class MystiteShortbow extends BowItem implements InitialStackStateProvider {
	
	public MystiteShortbow(Settings settings) {
		super(settings
			.maxDamage(2000)
			.fireproof()
			.group(ModItemGroups.RANGED_WEAPONS)
		);
		((IProjectileWeapon) this).setProjectileDamage(10.0f);
	}



	@Override
	public void initializeState(ItemStack stack) {
		Map<Enchantment, Integer> defaultEnchants = new HashMap<>();

		defaultEnchants.put(Enchantments.QUICK_CHARGE, 2);

		EnchantmentHelper.set(defaultEnchants, stack);
	}
}
