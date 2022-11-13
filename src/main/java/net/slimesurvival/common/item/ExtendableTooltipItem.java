package net.slimesurvival.common.item;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.slimesurvival.util.interfaces.ExtendableTooltipProvider;
import net.slimesurvival.util.settings.ExtendableTooltipSettings;

public class ExtendableTooltipItem extends Item implements ExtendableTooltipProvider {
	public ExtendableTooltipSettings tooltipSettings;

	public ExtendableTooltipItem(Settings settings, ExtendableTooltipSettings tooltipSettings) {
		super(settings);
		this.tooltipSettings = tooltipSettings;
	}


	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		addExtendableTooltips(tooltip, tooltipSettings);
	}
}
