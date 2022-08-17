package net.slimesurvival.common.item.trinket;

import java.util.List;
import java.util.UUID;

import org.jetbrains.annotations.Nullable;

import com.google.common.collect.Multimap;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.slimesurvival.common.event.LivingEntityDamagedCallback;
import net.slimesurvival.common.interfaces.ExtendableTooltipProvider;
import net.slimesurvival.common.registry.ModItems;

public class BloodstainedGlass extends TrinketItem implements ExtendableTooltipProvider {

	public BloodstainedGlass(Settings settings) {
		super(settings);

		LivingEntityDamagedCallback.EVENT.register(BloodstainedGlass::onLivingDamage);
	}



	private static void onLivingDamage(LivingEntity attackedEntity, DamageSource damageSource, float damage) {
		if (damageSource.getSource() instanceof LivingEntity) {
			LivingEntity attacker = (LivingEntity) damageSource.getSource();
			if (TrinketsApi.getTrinketComponent(attacker).get().isEquipped(ModItems.BlOODSTAINED_GLASS)) {
				attacker.heal(damage / 4);
			}
		}
	}




	public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
		var modifiers = super.getModifiers(stack, slot, entity, uuid);
		
		modifiers.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(uuid, "slimesurvival:bloodstained_glass_damage", 0.75, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
		modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, new EntityAttributeModifier(uuid, "slimesurvival:bloodstained_glass_health", -0.25, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));

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
	}
}
