package net.slimesurvival.common.item.weapon.ranged;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.projectiledamage.api.IProjectileWeapon;
import net.slimesurvival.common.interfaces.InitialStackStateProvider;
import net.slimesurvival.common.registry.ModItemGroups;

public class MystiteLongbow extends BowItem implements InitialStackStateProvider {
	
	public MystiteLongbow(Settings settings) {
		super(settings
			.maxDamage(3000)
			.fireproof()
			.group(ModItemGroups.RANGED_WEAPONS)
		);
		((IProjectileWeapon) this).setProjectileDamage(20.0f);
	}



	@Override
	public void initializeState(ItemStack stack) {
		Map<Enchantment, Integer> defaultEnchants = new HashMap<>();

		defaultEnchants.put(Enchantments.PIERCING, 10);

		EnchantmentHelper.set(defaultEnchants, stack);
	}
}
