package net.slimesurvival.common.item.material;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jetbrains.annotations.Nullable;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.slimesurvival.common.registry.ModEnchantments;
import net.slimesurvival.util.TooltipHelper;
import net.slimesurvival.util.interfaces.InitialStackStateProvider;
import net.slimesurvival.util.settings.ExtendableTooltipSettings;

public class MagmaticMagmaItem extends Item implements InitialStackStateProvider {
	public ExtendableTooltipSettings tooltipSettings;

	public MagmaticMagmaItem(Settings settings, ExtendableTooltipSettings tooltipSettings) {
		super(settings);
		this.tooltipSettings = tooltipSettings;
	}



	@Override
	public boolean hasGlint(ItemStack stack) {
		return true;
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		TooltipHelper.addExtendableTooltip(tooltip, tooltipSettings);
	}

	@Override
	public void initializeState(ItemStack stack) {
		Map<Enchantment, Integer> defaultEnchants = new HashMap<>();

		defaultEnchants.put(ModEnchantments.AUTOSMELT_ENCHANTMENT, 2);
		defaultEnchants.put(Enchantments.FIRE_ASPECT, 4);
		EnchantmentHelper.set(defaultEnchants, stack);
	}
}