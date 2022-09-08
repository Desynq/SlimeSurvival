package net.slimesurvival.common.item.trinket;

import java.util.List;
import java.util.UUID;

import org.jetbrains.annotations.Nullable;

import com.github.clevernucleus.dataattributes.api.DataAttributesAPI;
import com.google.common.collect.Multimap;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.slimesurvival.SlimeSurvival;
import net.slimesurvival.common.interfaces.ExtendableTooltipProvider;
import net.slimesurvival.common.registry.ModItemGroups;

public class TacticalGlove extends TrinketItem implements ExtendableTooltipProvider {

	public TacticalGlove(Settings settings) {
		super(settings
			.group(ModItemGroups.Equipment)
			.maxCount(1)
		);
	}





	public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
		var modifiers = super.getModifiers(stack, slot, entity, uuid);

		modifiers.put(DataAttributesAPI.getAttribute(SlimeSurvival.ID("gun/vertical_recoil")).get(), new EntityAttributeModifier(uuid, "slimesurvival:tactical_glove", -0.1, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
		modifiers.put(DataAttributesAPI.getAttribute(SlimeSurvival.ID("gun/horizontal_recoil")).get(), new EntityAttributeModifier(uuid, "slimesurvival:tactical_glove", -0.1, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
		modifiers.put(DataAttributesAPI.getAttribute(SlimeSurvival.ID("gun/accuracy")).get(), new EntityAttributeModifier(uuid, "slimesurvival:tactical_glove", 0.15, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));

		modifiers.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(uuid, "slimesurvival:tactical_glove", -0.05, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));

		return modifiers;
	}



	@Override
	public String tooltipTranslationKey() {
		return this.getTranslationKey();
	}

	@Override
	public boolean hasDetails() {
		return true;
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tryAppend(tooltip);
		tooltip.add(Text.of(""));
	}
}
