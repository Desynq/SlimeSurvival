package net.slimesurvival.common.item.material;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class PolarBearFur extends Item {
	public PolarBearFur(Settings settings) {
		super(settings);
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		tooltip.add( Text.translatable("item.slimesurvival.polar_bear_fur.tooltip") );
		tooltip.add( Text.translatable("item.slimesurvival.polar_bear_fur.tooltip2") );
	}
}
