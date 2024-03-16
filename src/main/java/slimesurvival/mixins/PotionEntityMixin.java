package slimesurvival.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrownPotion;
import slimesurvival.helpers.MixinHelper;

@Mixin(ThrownPotion.class)
public class PotionEntityMixin {
	/**
	 * Stops unextinguishable living entities from being extinguished by thrown water potions
	 * @see net.minecraft.world.entity.projectile.ThrownPotion#applyWater()
	 */
	@Redirect(
		method = "applyWater()V",
		at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;isOnFire()Z")
	)
	private boolean isOnFire(LivingEntity livingEntity) {
		return !MixinHelper.isUnextinguishable(livingEntity) && livingEntity.isOnFire();
	}
}
