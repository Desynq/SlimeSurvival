package net.slimesurvival.mixin;

import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.slimesurvival.common.interfaces.InitialStackStateProvider;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemStack.class)
public class ItemStackMixin {
	@Inject(method = "<init>(Lnet/minecraft/item/ItemConvertible;I)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;updateEmptyState()V"))
	public void bn_init(ItemConvertible itemConvertible, int i, CallbackInfo ci) {
		ItemStack stack = (ItemStack) (Object) this;
		if (itemConvertible instanceof InitialStackStateProvider forced) {
			forced.initializeState(stack);
		}
	}
}