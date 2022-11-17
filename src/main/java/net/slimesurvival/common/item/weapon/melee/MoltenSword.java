package net.slimesurvival.common.item.weapon.melee;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.slimesurvival.common.item.SSToolMaterials;
import net.slimesurvival.common.registry.ModEnchantments;
import net.slimesurvival.common.registry.ModItemGroups;
import net.slimesurvival.util.interfaces.InitialStackStateProvider;

public class MoltenSword extends SwordItem implements InitialStackStateProvider {

	public MoltenSword(Settings settings) {
		super(SSToolMaterials.MOLTEN, 7, -2.4F, settings.group(ModItemGroups.TOOLS));
	}

	@Override
	public void initializeState(ItemStack stack) {
		Map<Enchantment, Integer> defaultEnchants = new HashMap<>();

		defaultEnchants.put(ModEnchantments.AUTOSMELT_ENCHANTMENT, 2);
		defaultEnchants.put(Enchantments.FIRE_ASPECT, 3);
		EnchantmentHelper.set(defaultEnchants, stack);
	}
}
