package net.slimesurvival.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
	
	@ModifyArg(method = "damageArmor(Lnet/minecraft/entity/damage/DamageSource;F)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerInventory;damageArmor(Lnet/minecraft/entity/damage/DamageSource;F[I)V"), index = 1)
	private float reducedArmorDamage(float x) {
		return MathHelper.floor(x / 4);
	}
}
