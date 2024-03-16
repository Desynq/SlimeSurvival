package slimesurvival.mixins;

import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import slimesurvival.helpers.MixinHelper;

@Mixin(LayeredCauldronBlock.class)
public class LeveledCauldronBlockMixin {
	
	/**
	 * Stops cauldrons from extinguishing unextinguishable entities
	 * @see net.minecraft.world.level.block.LayeredCauldronBlock#entityInside()
	 */
	@Redirect(
		method = "entityInside()V",
		at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;isOnFire()Z", opcode = Opcodes.INVOKEVIRTUAL, ordinal = 0)
	)
	private boolean onEntityCollision_isOnFireRedirect(Entity entity) {
		return !MixinHelper.isUnextinguishable(entity) && entity.isOnFire();
	}
}
