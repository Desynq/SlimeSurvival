package net.slimesurvival.item.material;

import java.util.List;

import net.slimesurvival.util.Tooltip;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

public class EnderiumAlloy extends Item {
	public EnderiumAlloy(Settings settings) {
		super(settings);
	}



	@Override
	public boolean hasGlint(ItemStack stack) {
		return true;
	}



	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		super.appendTooltip(itemStack, world, tooltip, tooltipContext);
		tooltip.add(Tooltip.showDetailsTooltip);

		if (InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), 340)) {
			tooltip.remove(Tooltip.showDetailsTooltip);

			tooltip.add(new TranslatableText("item.slimesurvival.enderium_alloy.detail[0]"));
			tooltip.add(new TranslatableText("item.slimesurvival.enderium_alloy.detail[1]"));
			tooltip.add(new TranslatableText(""));
			tooltip.add(new TranslatableText("item.slimesurvival.enderium_alloy.detail[2]"));
			tooltip.add(new TranslatableText("item.slimesurvival.enderium_alloy.detail[3]"));
		}
	}
}