package net.slimesurvival.common.item.trinket;

import java.util.List;
import java.util.UUID;

import org.jetbrains.annotations.Nullable;

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
import net.projectiledamage.api.EntityAttributes_ProjectileDamage;
import net.slimesurvival.common.registry.ModItemGroups;
import net.slimesurvival.util.provider.ExtendableTooltipProvider;

public class ArcheryGoggles extends TrinketItem implements ExtendableTooltipProvider {

	public ArcheryGoggles(Settings settings) {
		super(settings
			.group(ModItemGroups.TRINKETS)
			.maxCount(1)
		);
	}





	public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
		var modifiers = super.getModifiers(stack, slot, entity, uuid);

		modifiers.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(uuid, "Archery Goggles", -0.25, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
		modifiers.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(uuid, "Archery Goggles", -0.25, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
		modifiers.put(EntityAttributes_ProjectileDamage.GENERIC_PROJECTILE_DAMAGE, new EntityAttributeModifier(uuid, "Archery Goggles", 0.5, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));

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
