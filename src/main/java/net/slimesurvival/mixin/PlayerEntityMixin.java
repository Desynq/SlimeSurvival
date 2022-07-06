package net.slimesurvival.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.player.PlayerEntity;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

	public int immunityFrames = 0;
	PlayerEntity player = (PlayerEntity) (Object) this;

	@Inject(method = "tick", at = @At("HEAD"))
	private void onTick(CallbackInfo ci) {
		if (player.isInvulnerable()) {
			immunityFrames++;
		}
		if (immunityFrames == 3) {
			player.setInvulnerable(false);
			immunityFrames = 0;
		}
	}
}
