package net.slimesurvival.item.material;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

public class PolarBearFur extends Item {
	public PolarBearFur(Settings settings) {
		super(settings);
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		tooltip.add( new TranslatableText("item.slimesurvival.polar_bear_fur.tooltip") );
		tooltip.add( new TranslatableText("item.slimesurvival.polar_bear_fur.tooltip2") );
	}
}
