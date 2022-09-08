package net.slimesurvival.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.slimesurvival.common.item.CustomBowItem;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(BowItem.class)
public class BowItemMixin {

	@Inject(method = "onStoppedUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/EnchantmentHelper;getLevel(Lnet/minecraft/enchantment/Enchantment;Lnet/minecraft/item/ItemStack;)I", ordinal = 3), locals = LocalCapture.CAPTURE_FAILSOFT)
	private void onStoppedUsingMixin(ItemStack stack, World world, LivingEntity user, int remainingUseTicks, CallbackInfo info, PlayerEntity playerEntity, boolean bl, ItemStack itemStack, int i, float f, boolean bl2, ArrowItem arrowItem, PersistentProjectileEntity persistentProjectileEntity) {
		if (stack.getItem() instanceof CustomBowItem bowItemStack) {
			persistentProjectileEntity.setDamage(persistentProjectileEntity.getDamage() * bowItemStack.getBaseProjectileDamage() + 1F);
		}
	}



	// @Inject(method = "releaseUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/BowItem;getPullProgress(I)F"), cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
	// public void releaseUsing$invokeGetUseDuration(ItemStack bow, World world, LivingEntity livingEntity, int useDuration, CallbackInfo callbackInfo, PlayerEntity player, boolean hasInfiniteAmmo, ItemStack arrows, int charge) {
	// 	if (!ArrowLooseCallback.EVENT.invoker().onArrowLoose(player, bow, world, charge, !arrows.isEmpty() || hasInfiniteAmmo)) callbackInfo.cancel();
	// }
}