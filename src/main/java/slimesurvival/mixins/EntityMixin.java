package slimesurvival.mixins;

import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.entity.Entity;
import slimesurvival.helpers.MixinHelper;

@Mixin(Entity.class)
public class EntityMixin {
	/**
	 * Water state is updated every tick and if the player is in water, they are extinguished every tick
	 * Chose to redirect extinguish()V method directly since there are multiple unrelated side effects, making a redirect at the if statement difficult
	 * @see net.minecraft.entity.Entity#checkWaterState()
	 */
	@Redirect(method = "checkWaterState()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;extinguish()V"))
	private void extinguish(Entity thisEntity) {
		if (MixinHelper.isUnextinguishable(thisEntity)) return;
		thisEntity.extinguish();
	}

	/**
	 * Entities are extinguished if they are moving while on fire and either in powder snow or wet
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
	 * Stops extinguish sound from playing for unextinguishable entities (while moving and either in powder snow or wet)
	 * The extinguish sound plays when you're both in a block that sets you on fire while also being extinguished at the same time
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
