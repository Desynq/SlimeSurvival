package net.slimesurvival.common.item.tool;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.slimesurvival.common.registry.ModEnchantments;
import net.slimesurvival.common.registry.ModToolMaterials;
import net.slimesurvival.util.interfaces.InitialStackStateProvider;

public class MoltenPickaxeItem extends PickaxeItem implements InitialStackStateProvider {

	public MoltenPickaxeItem(Settings settings) {
		super(ModToolMaterials.MOLTEN, 5, -2.8F, settings);
	}

	@Override
	public void initializeState(ItemStack stack) {
		Map<Enchantment, Integer> defaultEnchants = new HashMap<>();

		defaultEnchants.put(ModEnchantments.AUTOSMELT_ENCHANTMENT, 2);
		defaultEnchants.put(Enchantments.FIRE_ASPECT, 3);
		EnchantmentHelper.set(defaultEnchants, stack);
	}
}
