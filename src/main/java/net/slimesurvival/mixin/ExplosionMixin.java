package net.slimesurvival.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.entity.Entity;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.LootConditionManager;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.server.world.ServerWorld;
import net.slimesurvival.util.RegistryHelper;

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
	private ObjectArrayList<BlockPos> affectedBlocks;

	@Final
	@Shadow
	private World world;

	@Inject(method = "affectWorld(Z)V", at = @At("HEAD"), cancellable = false)
	private void affectWorld(boolean spawnParticles, CallbackInfo ci) {

		if (this.world instanceof ServerWorld) {
			LootContext.Builder builder = new LootContext.Builder((ServerWorld) this.world).parameter(LootContextParameters.ORIGIN, new Vec3d(x, y, z)).optionalParameter(LootContextParameters.THIS_ENTITY, this.entity);
			LootConditionManager lootConditionManager = ((ServerWorld) this.world).getServer().getPredicateManager();
			LootCondition lootCondition = lootConditionManager.get(RegistryHelper.id("can_affect_blocks"));

			if (!affectedBlocks.isEmpty() && lootCondition != null && !lootCondition.test(builder.build(LootContextTypes.COMMAND))) {
				affectedBlocks.clear();
			}
		}
	}
}
