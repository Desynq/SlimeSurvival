package net.slimesurvival.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.LootConditionManager;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.slimesurvival.SlimeSurvival;

@Mixin(SmallFireballEntity.class)
public class SmallFireballEntityMixin {
	@Final
	@Shadow
	private World world;

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


	@Redirect(
		method = "onBlockHit",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/world/Gamerules;getBoolean(Lnet/minecraft/world/GameRules$Key;)Z"
		)
	)
	private boolean antigriefProtection(GameRules gameRules, GameRules.Key<GameRules.BooleanRule> rule) {
		if (this.world instanceof ServerWorld) {
			LootContext.Builder builder = new LootContext.Builder((ServerWorld) this.world)
				.parameter(LootContextParameters.ORIGIN, new Vec3d(x, y, z))
				.optionalParameter(LootContextParameters.THIS_ENTITY, this.entity);
			LootConditionManager lootConditionManager = ((ServerWorld) this.world).getServer().getPredicateManager();
			LootCondition lootCondition = lootConditionManager.get(SlimeSurvival.ID("can_affect_blocks"));

			if (!lootCondition.test(builder.build(LootContextTypes.COMMAND))) {
				return false;
			}
		}
		return gameRules.getBoolean(rule);
	}
}
