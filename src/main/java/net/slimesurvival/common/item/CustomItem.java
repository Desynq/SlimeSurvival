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
	public final CustomItemSettings itemSettings;
	public final ExtendableTooltipSettings tooltipSettings;

	public CustomItem(Settings settings, CustomItemSettings itemSettings, ExtendableTooltipSettings tooltipSettings) {
		super(settings);
		this.itemSettings = itemSettings;
		this.tooltipSettings = tooltipSettings;
	}
	public CustomItem(Settings settings, CustomItemSettings itemSettings) {
		super(settings);
		this.itemSettings = itemSettings;
		this.tooltipSettings = null;
	}



	@Override
	public boolean hasGlint(ItemStack stack) {
		return this.itemSettings.hasGlint;
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		if (tooltipSettings != null) {
			TooltipHelper.addExtendableTooltip(tooltip, tooltipSettings);
		}
	}
}
