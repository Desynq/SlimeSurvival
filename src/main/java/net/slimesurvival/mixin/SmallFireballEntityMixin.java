package net.slimesurvival.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.util.hit.BlockHitResult;

@Mixin(SmallFireballEntity.class)
public abstract class SmallFireballEntityMixin {

	@Inject(
		method = "onBlockHit",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/entity/projectile/AbstractFireballEntity;onBlockHit(Lnet/minecraft/util/hit/BlockHitResult;)V",
			shift = At.Shift.AFTER
		),
		cancellable = true
	)
	private void preventFire(BlockHitResult blockHitResult, CallbackInfo ci) {
		ci.cancel();
	}
}
