package net.slimesurvival.mixin;

import net.minecraft.item.ToolMaterials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ToolMaterials.class)
public class ToolMaterialsMixin {
	@Inject(method = "getDurability", at = @At("RETURN"), cancellable = true)

	public void getDurabilityInject(CallbackInfoReturnable<Integer> cir) {
		if ((ToolMaterials) (Object) this == ToolMaterials.GOLD) {
			cir.setReturnValue(180);
		}
	}
}