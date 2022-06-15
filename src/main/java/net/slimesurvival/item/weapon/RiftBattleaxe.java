package net.slimesurvival.item.weapon;

import java.util.List;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import net.slimesurvival.util.Tooltip;

public class RiftBattleaxe extends AxeItem {
	public RiftBattleaxe(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
		super(material, attackDamage, attackSpeed, settings);
	}



	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		super.appendTooltip(itemStack, world, tooltip, tooltipContext);
		tooltip.add(Tooltip.showDetailsTooltip);

		if (InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), 340)) {
			tooltip.remove(Tooltip.showDetailsTooltip);

			tooltip.add(new TranslatableText("item.slimesurvival.rift_battleaxe.detail[0]"));
			tooltip.add(new TranslatableText(""));
			tooltip.add(new TranslatableText("item.slimesurvival.rift_battleaxe.detail[1]"));
			tooltip.add(new TranslatableText("item.slimesurvival.rift_battleaxe.detail[2]"));
		}
	}
}
