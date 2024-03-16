package slimesurvival.mixins;

import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import slimesurvival.common.registry.ModEntityAttributes;
import slimesurvival.helpers.MixinHelper;

// net.minecraft.entity.SlimeEntity
@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

	/**
	 * @see net.minecraft.world.entity.LivingEntity#createLivingAttributes()
	 */
	@Inject(method = "createLivingAttributes()Lnet/minecraft/world/entity/ai/attributes/AttributeSupplier$Builder;", require = 1, allow = 1, at = @At("RETURN"))
	private static void addSlimeSurvivalEntityAttributes(final CallbackInfoReturnable<AttributeSupplier.Builder> info) {
		info.getReturnValue()
				.add(ModEntityAttributes.DODGE_CHANCE)
				.add(ModEntityAttributes.CHANCE_TO_NOT_CONSUME_AMMO)
				.add(ModEntityAttributes.MAX_MANA)
				.add(ModEntityAttributes.PASSIVE_MANA_REGEN_RATE);
	}



	/**
	 * Stops unextinguishable living entities from being extinguished every tick while alive and either in powder snow or wet
	 * @see net.minecraft.world.entity.LivingEntity#baseTick()
	 */
	@Redirect(
		method = "baseTick()V",
		at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;isAlive()Z", opcode = Opcodes.INVOKEVIRTUAL, ordinal = 1)
	)
	private boolean baseTick_isAliveRedirect(LivingEntity livingEntity) {
		return !MixinHelper.isUnextinguishable(livingEntity) && livingEntity.isAlive();
	}
}
