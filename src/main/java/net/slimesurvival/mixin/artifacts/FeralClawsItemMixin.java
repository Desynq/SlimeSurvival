package net.slimesurvival.mixin.artifacts;

import java.util.UUID;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import com.google.common.collect.Multimap;

import artifacts.Artifacts;
import artifacts.common.item.curio.CurioItem;
import artifacts.common.item.curio.hands.FeralClawsItem;
import dev.emi.trinkets.api.SlotReference;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;

@Mixin(FeralClawsItem.class)
public class FeralClawsItemMixin extends CurioItem {

	/* (non-Javadoc)
	 * @see artifacts.common.item.curio.CurioItem#applyModifiers(net.minecraft.item.ItemStack, dev.emi.trinkets.api.SlotReference, net.minecraft.entity.LivingEntity, java.util.UUID)
	 */
	@Overwrite
	protected Multimap<EntityAttribute, EntityAttributeModifier> applyModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
		Multimap<EntityAttribute, EntityAttributeModifier> result = super.applyModifiers(stack, slot, entity, uuid);

		result.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(uuid, Artifacts.id("feral_claws_attack_speed").toString(), 0.25, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
		result.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(uuid, Artifacts.id("feral_claws_armor").toString(), -0.25, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));

		return result;
	}
}
