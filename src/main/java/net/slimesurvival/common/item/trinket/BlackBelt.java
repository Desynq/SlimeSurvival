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
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.slimesurvival.SlimeSurvival;
import net.slimesurvival.common.interfaces.ExtendableTooltipProvider;
import net.slimesurvival.common.registry.ModItemGroups;

public class BlackBelt extends TrinketItem implements ExtendableTooltipProvider {

	public BlackBelt(Settings settings) {
		super(settings
			.group(ModItemGroups.TRINKETS)
			.maxCount(1)
		);
	}





	public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
		var modifiers = super.getModifiers(stack, slot, entity, uuid);

		modifiers.put(DataAttributesAPI.getAttribute(SlimeSurvival.ID("dodge_chance")).get(), new EntityAttributeModifier(uuid, "slimesurvival:black_belt", 0.05, EntityAttributeModifier.Operation.ADDITION));

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