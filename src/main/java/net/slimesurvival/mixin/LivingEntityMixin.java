package net.slimesurvival.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import net.minecraft.entity.LivingEntity;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

	@ModifyConstant(method = "isBlocking", constant = @Constant(intValue = 5))
	private int lowerShieldDelay(int use) {
		return 1;
	}
}
