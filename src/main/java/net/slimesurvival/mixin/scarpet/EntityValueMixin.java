package net.slimesurvival.mixin.scarpet;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.function.BiFunction;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import carpet.script.exception.InternalExpressionException;
import carpet.script.utils.InputValidator;
import carpet.script.value.BooleanValue;
import carpet.script.value.EntityValue;
import carpet.script.value.ListValue;
import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import carpet.script.value.Value;
import io.github.apace100.origins.origin.OriginLayers;
import io.github.apace100.origins.registry.ModComponents;
import net.minecraft.advancement.Advancement;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

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


		put("advancement", (e, a) -> {
			if (e instanceof ServerPlayerEntity) {
				Advancement advancement = e.getServer().getAdvancementLoader().get(InputValidator.identifierOf(a.getString()));
				if (advancement == null) return Value.NULL;

				return BooleanValue.of(((ServerPlayerEntity) e).getAdvancementTracker().getProgress(advancement).isDone());
			}
			return Value.NULL;
		});




		put("owner", (e, a) -> {
			if (e instanceof TameableEntity) {
				return new EntityValue(((TameableEntity)e).getOwner());
			} else if (e instanceof ProjectileEntity) {
				return new EntityValue(((ProjectileEntity)e).getOwner());
			}
			return Value.NULL;
		});


		put("attribute_modifier", (e, a) -> {
			if (!(e instanceof LivingEntity) || a == null || !(a instanceof ListValue)) return Value.NULL;
			List<Value> args = ((ListValue) a).getItems();

			if (args.size() != 2) throw new InternalExpressionException("'has_attribute_modifier' needs two arguments");

			Identifier id = InputValidator.identifierOf(args.get(0).getString());
			UUID uuid = UUID.fromString(args.get(1).getString());
			EntityAttribute attribute = Registry.ATTRIBUTE.get(id);


			EntityAttributeInstance attributeInstance = ((LivingEntity)e).getAttributeInstance(attribute);
			return new NumericValue(attributeInstance.getModifier(uuid).getValue());
		});
	}
}
