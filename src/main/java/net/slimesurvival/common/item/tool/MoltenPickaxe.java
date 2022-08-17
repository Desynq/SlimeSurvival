package net.slimesurvival.common.item.tool;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.slimesurvival.common.interfaces.InitialStackStateProvider;
import net.slimesurvival.common.registry.ModEnchantments;
import net.slimesurvival.common.registry.ModItemGroups;
import net.slimesurvival.common.registry.ModToolMaterials;

public class MoltenPickaxe extends PickaxeItem implements InitialStackStateProvider {

	public MoltenPickaxe(Settings settings) {
		super(ModToolMaterials.MOLTEN, 5, -2.8F, settings.group(ModItemGroups.TOOLS));
	}

	@Override
	public void initializeState(ItemStack stack) {
		Map<Enchantment, Integer> defaultEnchants = new HashMap<>();

		defaultEnchants.put(ModEnchantments.AUTOSMELT_ENCHANTMENT, 2);
		defaultEnchants.put(Enchantments.FIRE_ASPECT, 3);
		EnchantmentHelper.set(defaultEnchants, stack);
	}
}
