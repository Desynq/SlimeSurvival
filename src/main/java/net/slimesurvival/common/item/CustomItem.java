package net.slimesurvival.common.item;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.slimesurvival.util.TooltipHelper;
import net.slimesurvival.util.settings.CustomItemSettings;
import net.slimesurvival.util.settings.ExtendableTooltipSettings;

public class CustomItem extends Item {
	public ExtendableTooltipSettings tooltipSettings;
	public CustomItemSettings itemSettings;

	public CustomItem(Settings settings, ExtendableTooltipSettings tooltipSettings, CustomItemSettings itemSettings) {
		super(settings);
		this.tooltipSettings = tooltipSettings;
		this.itemSettings = itemSettings;
	}
	public CustomItem(Settings settings, CustomItemSettings itemSettings) {
		super(settings);
	}



	@Override
	public boolean hasGlint(ItemStack stack) {
		return this.itemSettings.hasGlint;
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		TooltipHelper.addExtendableTooltip(tooltip, tooltipSettings);
	}
}
