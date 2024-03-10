package slimesurvival.mixins;

import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import slimesurvival.helpers.MixinHelper;

public class ExtinguishMixins {

	@Mixin(LivingEntity.class)
	public static class LivingEntityMixin {
		/**
		 * TODO: Change to redirect at first condition in if statement
		 */
		@Redirect(method = "baseTick()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;extinguishWithSound()V"))
		private void baseTickExtinguishWithSound(LivingEntity thisLivingEntity) {
			if (MixinHelper.isUnextinguishable(thisLivingEntity)) return;
			thisLivingEntity.extinguishWithSound();
		}
	}



	@Mixin(Entity.class)
	public static class EntityMixin {
		/**
		 * TODO: Change to redirect at first condition in if statement
		 */
		@Redirect(method = "checkWaterState()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;extinguish()V"))
		private void extinguish(Entity thisEntity) {
			if (MixinHelper.isUnextinguishable(thisEntity)) return;
			thisEntity.extinguish();
		}

		/**
		 * Stops entity with unextinguishable power from having their fire ticks reset when moving while on fire (in powder snow or while wet)
		 * @see net.minecraft.entity.Entity#move(net.minecraft.entity.MovementType, net.minecraft.util.math.Vec3d)
		 */
		@Redirect(
			method = "move(Lnet/minecraft/entity/MovementType;Lnet/minecraft/util/math/Vec3d;)V",
			at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;isOnFire()Z", opcode = Opcodes.INVOKEVIRTUAL, ordinal = 1)
		)
		private boolean isOnFireRedirect(Entity entity) {
			return !MixinHelper.isUnextinguishable(entity) && entity.isOnFire();
		}

		/**
		 * Stops extinguish sound from playing whenever entity with unextinguishable power moves while on fire (in powder snow or while wet)
		 * @see net.minecraft.entity.Entity#move(net.minecraft.entity.MovementType, net.minecraft.util.math.Vec3d)
		 */
		@Redirect(
			method = "move(Lnet/minecraft/entity/MovementType;Lnet/minecraft/util/math/Vec3d;)V",
			at = @At(value = "FIELD", target = "Lnet/minecraft/entity/Entity;wasOnFire:Z", opcode = Opcodes.GETFIELD, ordinal = 0)
		)
		private boolean wasOnFireRedirect(Entity entity) {
			return !MixinHelper.isUnextinguishable(entity) && entity.wasOnFire;
		}
	}


	@Mixin(PotionEntity.class)
	public static class PotionEntityMixin {
		/**
		 * TODO: Change to redirect at first condition in if statement
		 */
		@Redirect(method = "applyWater()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;extinguishWithSound()V"))
		private void extinguishWithSound(LivingEntity livingEntity) {
			if (MixinHelper.isUnextinguishable(livingEntity)) return;
			livingEntity.extinguishWithSound();
		}
	}

	@Mixin(LeveledCauldronBlock.class)
	public static class LeveledCauldronBlockMixin {
		/**
		 * Stops cauldrons from extinguishing unextinguishable entities
		 * @see net.minecraft.block.LeveledCauldronBlock#onEntityCollision(BlockState, World, BlockPos, Entity)
		 */
		@Redirect(
			method = "onEntityCollision(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/entity/Entity;)V",
			at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;isOnFire()Z", opcode = Opcodes.INVOKEVIRTUAL, ordinal = 0)
		)
		private boolean isOnFireRedirect(Entity entity) {
			return !MixinHelper.isUnextinguishable(entity) && entity.isOnFire();
		}
	}
}
