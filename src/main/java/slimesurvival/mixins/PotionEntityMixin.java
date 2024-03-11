package slimesurvival.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import slimesurvival.helpers.MixinHelper;

@Mixin(PotionEntity.class)
public class PotionEntityMixin {
	/**
	 * Stops unextinguishable living entities from being extinguished by thrown water potions
	 * @see net.minecraft.entity.projectile.thrown.PotionEntity#applyWater()
	 */
	@Redirect(
		method = "applyWater()V",
		at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;isOnFire()Z")
	)
	private boolean isOnFire(LivingEntity livingEntity) {
		return !MixinHelper.isUnextinguishable(livingEntity) && livingEntity.isOnFire();
	}
}
