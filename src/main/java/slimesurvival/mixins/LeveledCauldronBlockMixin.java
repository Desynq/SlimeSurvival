package slimesurvival.mixins;

import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import slimesurvival.helpers.MixinHelper;

@Mixin(LeveledCauldronBlock.class)
public class LeveledCauldronBlockMixin {
	
	/**
	 * Stops cauldrons from extinguishing unextinguishable entities
	 * @see net.minecraft.block.LeveledCauldronBlock#onEntityCollision(BlockState, World, BlockPos, Entity)
	 */
	@Redirect(
		method = "onEntityCollision(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/entity/Entity;)V",
		at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;isOnFire()Z", opcode = Opcodes.INVOKEVIRTUAL, ordinal = 0)
	)
	private boolean onEntityCollision_isOnFireRedirect(Entity entity) {
		return !MixinHelper.isUnextinguishable(entity) && entity.isOnFire();
	}
}
