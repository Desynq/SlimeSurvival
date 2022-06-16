package net.slimesurvival.item.trinket;

import java.util.List;
import java.util.UUID;

import com.google.common.collect.Multimap;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import net.slimesurvival.util.Tooltip;

public class WinterCoat extends TrinketItem {

	public WinterCoat(Settings settings) {
		super(settings);
	}



	public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
		var modifiers = super.getModifiers(stack, slot, entity, uuid);
		// +4 Armor
		modifiers.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(uuid, "slimesurvival:winter_coat_armor", 4, EntityAttributeModifier.Operation.ADDITION));
		return modifiers;
	}



	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		super.appendTooltip(itemStack, world, tooltip, tooltipContext);
		tooltip.add(Tooltip.showDetailsTooltip);

		if (InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), 340)) {
			tooltip.remove(Tooltip.showDetailsTooltip);

			tooltip.add(new TranslatableText("item.slimesurvival.winter_coat.detail_0"));
			tooltip.add(new TranslatableText("item.slimesurvival.winter_coat.detail_1"));
		}
	}
}
