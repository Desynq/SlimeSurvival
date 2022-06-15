package net.slimesurvival.item.weapon;

import java.util.List;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import net.slimesurvival.util.Tooltip;

public class BanHammer extends SwordItem {
	public BanHammer(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Item.Settings settings) {
		super(toolMaterial, attackDamage, attackSpeed, settings);
	}



	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		super.appendTooltip(itemStack, world, tooltip, tooltipContext);

		tooltip.add(new TranslatableText("item.slimesurvival.ban_hammer.tooltip"));
		tooltip.add(Tooltip.showDetailsTooltip);

		if (InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), 340)) {
			tooltip.remove(Tooltip.showDetailsTooltip);
			//tooltip.subList(2, tooltip.size()).clear();

			tooltip.add(new TranslatableText("item.slimesurvival.ban_hammer.detail[0]"));
			tooltip.add(new TranslatableText("item.slimesurvival.ban_hammer.detail[1]"));
		}
	}
}
