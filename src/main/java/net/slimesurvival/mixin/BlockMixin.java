package net.slimesurvival.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.BlastingRecipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.slimesurvival.common.registry.ModEnchantments;
import net.slimesurvival.common.registry.ModPowers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class BlockMixin {

	@Inject(method = "onEntityLand", at = @At("HEAD"), cancellable = true)
	public void onEntityLand(BlockView world, Entity entity, CallbackInfo callbackInfo) {
		if (ModPowers.BOUNCY.isActive(entity) && !entity.bypassesLandingEffects()) {
			entity.setVelocity(entity.getVelocity().multiply(1.0F, -0.85F, 1.0F));
			callbackInfo.cancel();
		}
	}





	@Inject(
		method = "getDroppedStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;)Ljava/util/List;",
		at = @At("RETURN"),
		cancellable = true
	)
	private static void getDroppedStacks(BlockState state, ServerWorld world, BlockPos pos, BlockEntity blockEntity, Entity entity, ItemStack stack, CallbackInfoReturnable<List<ItemStack>> cir) {
		List<ItemStack> items = new ArrayList<>();
		List<ItemStack> returnValue = cir.getReturnValue();
		if (EnchantmentHelper.getLevel(ModEnchantments.AUTOSMELT_ENCHANTMENT, stack) == 0) {
			cir.setReturnValue(returnValue);
			return;
		}
		for (ItemStack itemStack : returnValue) {
			Optional<BlastingRecipe> blastingRecipe = world.getRecipeManager().listAllOfType(RecipeType.BLASTING).stream().filter((recipe -> {
				return recipe.getIngredients().get(0).test(itemStack);
			})).findFirst();

			Optional<SmeltingRecipe> smeltingRecipe = world.getRecipeManager().listAllOfType(RecipeType.SMELTING).stream().filter((recipe -> {
				return recipe.getIngredients().get(0).test(itemStack);
			})).findFirst();



			if (EnchantmentHelper.getLevel(ModEnchantments.AUTOSMELT_ENCHANTMENT, stack) >= 2 && blastingRecipe.isPresent()) {
				ItemStack smelted = blastingRecipe.get().getOutput();
				smelted.setCount(itemStack.getCount());
				items.add(smelted);
			} else if (smeltingRecipe.isPresent()) {
				ItemStack smelted = smeltingRecipe.get().getOutput();
				smelted.setCount(itemStack.getCount());
				items.add(smelted);
			} else {
				items.add(itemStack);
			}


		}
		cir.setReturnValue(items);
	}
}