package slimesurvival.mixins;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.entity.Entity;
import net.minecraft.loot.LootDataType;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import slimesurvival.SlimeSurvival;

@Mixin(Explosion.class)
public abstract class ExplosionMixin {
	@Shadow @Final private double x;
	@Shadow @Final private double y;
	@Shadow @Final private double z;
	@Shadow @Final private Entity entity;
	@Shadow @Final private ObjectArrayList<BlockPos> affectedBlocks;
	@Shadow @Final private World world;

	
	@Inject(method = "affectWorld(Z)V", at = @At("HEAD"), cancellable = false)
	private void affectWorld(boolean spawnParticles, CallbackInfo ci) {

		if (this.world instanceof ServerWorld) {
			LootCondition lootCondition = this.world.getServer().getLootManager().getElement(LootDataType.PREDICATES, SlimeSurvival.ID("can_affect_blocks"));

			LootContextParameterSet lootContextParameterSet = new LootContextParameterSet.Builder((ServerWorld) world)
				.add(LootContextParameters.ORIGIN, new Vec3d(x, y, z))
				.addOptional(LootContextParameters.THIS_ENTITY, this.entity)
				.build(LootContextTypes.COMMAND);
			LootContext lootContext = new LootContext.Builder(lootContextParameterSet).build(null);

			if (!affectedBlocks.isEmpty()) SlimeSurvival.LOGGER.info("blocks are not empty");
			if (lootCondition != null) SlimeSurvival.LOGGER.info("loot condition is not null");
			if (!lootCondition.test(lootContext)) SlimeSurvival.LOGGER.info("tnt should not be able to affect blocks");

			if (!affectedBlocks.isEmpty() && lootCondition != null && !lootCondition.test(lootContext)) {
				SlimeSurvival.LOGGER.info("how in the fuck");
				affectedBlocks.clear();
			}
		}
	}
}
