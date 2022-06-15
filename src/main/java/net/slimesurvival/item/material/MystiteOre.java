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

public class MystiteOre extends Item {
	public MystiteOre(Settings settings) {
		super(settings);
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		super.appendTooltip(itemStack, world, tooltip, tooltipContext);
		tooltip.add(Tooltip.showDetailsTooltip);
		tooltip.add(Tooltip.showHowToObtainTooltip);

		if (InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), 340)) {
			tooltip.remove(Tooltip.showDetailsTooltip);
			tooltip.remove(Tooltip.showHowToObtainTooltip);

			tooltip.add(new TranslatableText("item.slimesurvival.mystite_ore.detail[0]"));
			tooltip.add(new TranslatableText("item.slimesurvival.mystite_ore.detail[1]"));
		} else if (InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), 341)) {
			tooltip.remove(Tooltip.showDetailsTooltip);
			tooltip.remove(Tooltip.showHowToObtainTooltip);

			tooltip.add(new TranslatableText("item.slimesurvival.mystite_ore.how_to_obtain[0]"));
			tooltip.add(new TranslatableText("item.slimesurvival.mystite_ore.how_to_obtain[1]"));
		}
	}
}
