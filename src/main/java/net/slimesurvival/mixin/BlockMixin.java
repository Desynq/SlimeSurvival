package net.slimesurvival.mixin;

import net.slimesurvival.power.Powers;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Block.class)
public class BlockMixin {
	@Inject(method = "onEntityLand", at = @At("HEAD"), cancellable = true)
	public void onEntityLand(BlockView world, Entity entity, CallbackInfo callbackInfo) {
		if (Powers.BOUNCY.isActive(entity) && !entity.bypassesLandingEffects()) {
			entity.setVelocity(entity.getVelocity().multiply(1.0F, -0.85F, 1.0F));
			callbackInfo.cancel();
		}
	}
}