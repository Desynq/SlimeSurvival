package net.slimesurvival.mixin.scarpet;

import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import carpet.script.exception.InternalExpressionException;
import carpet.script.value.ListValue;
import carpet.script.value.NumericValue;
import carpet.script.value.Value;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.slimesurvival.common.registry.ModDamageSources;

// carpet.script.value.EntityValue
@Mixin(targets = "carpet/script/value/EntityValue$2", remap = false)
public class EntityValueModifierMixin extends HashMap<String, BiConsumer<Entity, Value>> {

	@Inject(method = "<init>", at = @At("TAIL"), remap = false)
	private void addFeatureModifiers(CallbackInfo ci) {

		put("damage", (e, v) -> {
			LivingEntity livingEntity = e instanceof LivingEntity ? (LivingEntity) e : null;
			if (livingEntity == null) throw new InternalExpressionException("Expected a living entity as the entity");

			if (!(v instanceof ListValue)) throw new InternalExpressionException("Expected a list of 2 or 3 parameters as a second argument");
			List<Value> vals = ((ListValue) v).getItems();

			Float amount = NumericValue.asNumber(vals.get(0)).getFloat();
			String source = vals.get(1).getString();
			
			if(vals.size() == 2) {
				switch (source) {
					case "basic": {
						livingEntity.timeUntilRegen = 0;
						livingEntity.damage(ModDamageSources.BASIC_DAMAGE, amount);
						break;
					}
					case "generic": {
						livingEntity.damage(DamageSource.GENERIC, amount);
						break;
					}
				}
			}
		});
	}
}
