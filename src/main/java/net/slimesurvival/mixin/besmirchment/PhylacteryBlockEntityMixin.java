package net.slimesurvival.mixin.besmirchment;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import dev.mrsterner.besmirchment.common.block.entity.PhylacteryBlockEntity;

@Mixin(PhylacteryBlockEntity.class)
public class PhylacteryBlockEntityMixin {

	@ModifyConstant(remap = false, method = "addSouls", constant = @Constant(intValue = 8))
	private int newMaxSouls(int value) {
		return 16;
	}
}
