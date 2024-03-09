package slimesurvival.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import slimesurvival.common.registry.ModEntityAttributes;

// net.minecraft.entity.SlimeEntity
@Mixin(LivingEntity.class)
public class LivingEntityMixin {

	@Inject(method = "createLivingAttributes()Lnet/minecraft/entity/attribute/DefaultAttributeContainer$Builder;", require = 1, allow = 1, at = @At("RETURN"))
	private static void addSlimeSurvivalEntityAttributes(final CallbackInfoReturnable<DefaultAttributeContainer.Builder> info) {
		info.getReturnValue()
				.add(ModEntityAttributes.DODGE_CHANCE)
				.add(ModEntityAttributes.CHANCE_TO_NOT_CONSUME_AMMO)
				.add(ModEntityAttributes.MAX_MANA)
				.add(ModEntityAttributes.PASSIVE_MANA_REGEN_RATE);
	}
}
