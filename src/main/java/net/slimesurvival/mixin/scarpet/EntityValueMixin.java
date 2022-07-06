package net.slimesurvival.mixin.scarpet;

import java.util.HashMap;
import java.util.function.BiFunction;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import carpet.script.utils.InputValidator;
import carpet.script.value.StringValue;
import carpet.script.value.Value;
import io.github.apace100.origins.origin.OriginLayers;
import io.github.apace100.origins.registry.ModComponents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

// carpet.script.value.EntityValue
@Mixin(targets = "carpet/script/value/EntityValue$1", remap = false)
public class EntityValueMixin extends HashMap<String, BiFunction<Entity, Value, Value>> {
	@Inject(method = "<init>", at = @At("RETURN"), remap = false)
	private void addOriginSupport(CallbackInfo ci) {
		put("origin", (e, a) -> {
			if (e instanceof PlayerEntity) {
				if (a == null) return new StringValue(ModComponents.ORIGIN.get(e).getOrigin(OriginLayers.getLayer(new Identifier("origins:origin"))).getIdentifier().toString());
				return new StringValue(ModComponents.ORIGIN.get(e).getOrigin(OriginLayers.getLayer(InputValidator.identifierOf(a.getString()))).getIdentifier().toString());
			}
			return Value.NULL;
		});
	}
}
