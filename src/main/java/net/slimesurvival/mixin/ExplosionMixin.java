package net.slimesurvival.mixin;

import java.util.List;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import net.slimesurvival.common.registry.ModDimensions;

@Mixin(Explosion.class)
public class ExplosionMixin {
	@Final
	@Shadow
	private double x;

	@Final
	@Shadow
	private double y;

	@Final
	@Shadow
	private double z;

	@Final
	@Shadow
	private Entity entity;

	@Final
	@Shadow
	private List<BlockPos> affectedBlocks;

	@Final
	@Shadow
	private World world;

	@Inject(method = "affectWorld(Z)V", at = @At("HEAD"), cancellable = false)
	private void affectWorld(boolean spawnParticles, CallbackInfo ci) {
		if (!affectedBlocks.isEmpty() && ModDimensions.ANTIGRIEF_DIMENSIONS.contains(this.world.getRegistryKey())) {
			affectedBlocks.clear();
		}
	}
}
