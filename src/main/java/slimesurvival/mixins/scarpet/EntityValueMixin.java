package slimesurvival.mixins.scarpet;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
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
import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.PowerTypeReference;
import io.github.apace100.origins.origin.Origin;
import io.github.apace100.origins.origin.OriginLayer;
import io.github.apace100.origins.origin.OriginLayers;
import io.github.apace100.origins.registry.ModComponents;
import net.minecraft.advancement.Advancement;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.loot.LootDataType;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.registry.Registries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;


// carpet.script.value.EntityValue
@Mixin(targets = "carpet/script/value/EntityValue$1", remap = false)
public class EntityValueMixin extends HashMap<String, BiFunction<Entity, Value, Value>> {
	@Inject(method = "<init>", at = @At("RETURN"), remap = false)
	private void featureAccessors(CallbackInfo ci) {

		put("predicate", (entity, args) -> {
			MinecraftServer server = entity.getServer();
			if (server == null) return Value.NULL;

			LootCondition lootCondition = server.getLootManager().getElement(LootDataType.PREDICATES, InputValidator.identifierOf(args.getString()));
			if (lootCondition == null) return Value.NULL;

			LootContextParameterSet lootContextParameterSet = new LootContextParameterSet.Builder((ServerWorld) entity.getWorld())
				.add(LootContextParameters.ORIGIN, entity.getPos())
				.addOptional(LootContextParameters.THIS_ENTITY, entity)
				.build(LootContextTypes.COMMAND);
			LootContext lootContext = new LootContext.Builder(lootContextParameterSet).build(null);
			return BooleanValue.of(lootCondition.test(lootContext));
		});


		put("advancement", (entity, args) -> {
			if (entity instanceof ServerPlayerEntity) {
				Advancement advancement = entity.getServer().getAdvancementLoader().get(InputValidator.identifierOf(args.getString()));

				if (advancement != null) return BooleanValue.of(((ServerPlayerEntity) entity).getAdvancementTracker().getProgress(advancement).isDone());
			}
			return Value.NULL;
		});


		put("owner", (entity, args) -> {
			Entity ownerEntity = null;

			if (entity instanceof TameableEntity tameableEntity) ownerEntity = tameableEntity.getOwner();
			else if (entity instanceof ProjectileEntity projectileEntity) ownerEntity = projectileEntity.getOwner();

			return ownerEntity == null ? Value.NULL : new EntityValue(ownerEntity);
		});


		/*
		 * e ~ ['attribute_modifier', <attribute id>, <attribute modifier uuid>]
		 */
		put("attribute_modifier", (entity, args) -> {
			if(!(entity instanceof LivingEntity) || args == null || !(args instanceof ListValue)) return Value.NULL;

			List<Value> listArgs = ((ListValue) args).getItems();

			if (listArgs.size() != 2) throw new InternalExpressionException("'attribute_modifier' needs two arguments");

			Identifier id = InputValidator.identifierOf(listArgs.get(0).getString());
			UUID uuid = UUID.fromString(listArgs.get(1).getString());

			EntityAttribute attribute = Registries.ATTRIBUTE.get(id);
			
			Optional<EntityAttributeModifier> attributeInstanceModifier = Optional.ofNullable(attribute)
				.map(attr -> ((LivingEntity) entity).getAttributeInstance(attr))
				.map(attributeInstance -> attributeInstance.getModifier(uuid));


			return attributeInstanceModifier.map(modifier -> new NumericValue(modifier.getValue())).orElse(Value.NULL);
		});


		/*
		 * e ~ 'origin'
		 * e ~ ['origin', <origin layer>]
		 */
		put("origin", (entity, args) -> {
			OriginLayer originLayer = OriginLayers.getLayer(args == null ? new Identifier("origins:origin") : InputValidator.identifierOf(args.getString()));
			Origin origin = ModComponents.ORIGIN.get(entity).getOrigin(originLayer);

			return new StringValue(origin.getIdentifier().toString());
		});


		/*
		 * e ~ ['power', <power id>]
		 */
		put("power", (entity, args) -> {
			PowerType<Power> power = new PowerTypeReference<>(InputValidator.identifierOf(args.getString()));
			
			return power == null ? Value.NULL : BooleanValue.of(power.isActive(entity));
		});
	}
}
