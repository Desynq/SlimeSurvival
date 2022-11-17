package net.slimesurvival.common.item.tool;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.slimesurvival.common.registry.ModEnchantments;
import net.slimesurvival.common.registry.ModToolMaterials;
import net.slimesurvival.util.interfaces.InitialStackStateProvider;

public class MoltenAxeItem extends AxeItem implements InitialStackStateProvider {

	public MoltenAxeItem(Settings settings) {
		super(ModToolMaterials.MOLTEN, 9, -3.0F, settings);
	}

	@Override
	public void initializeState(ItemStack stack) {
		Map<Enchantment, Integer> defaultEnchants = new HashMap<>();

		defaultEnchants.put(ModEnchantments.AUTOSMELT_ENCHANTMENT, 2);
		defaultEnchants.put(Enchantments.FIRE_ASPECT, 3);
		EnchantmentHelper.set(defaultEnchants, stack);
	}
}