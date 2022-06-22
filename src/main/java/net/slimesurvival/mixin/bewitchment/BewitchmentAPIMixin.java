package net.slimesurvival.mixin.bewitchment;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import moriyashiine.bewitchment.api.BewitchmentAPI;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.slimesurvival.item.weapon.Duskbreaker;

@Mixin(BewitchmentAPI.class)
public class BewitchmentAPIMixin {

	@Inject(method = "isSourceFromSilver", at = @At("HEAD"), cancellable = true)
	private static void isSourceFromSilver(DamageSource source, CallbackInfoReturnable<Boolean> cir) {
		if (source.getSource() instanceof LivingEntity livingEntity && livingEntity.getMainHandStack().getItem() instanceof Duskbreaker) {
			cir.setReturnValue(true);
		}
	}
}