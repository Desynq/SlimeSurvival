package net.slimesurvival.mixin.scarpet;

import java.util.ArrayList;
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
import carpet.script.value.ValueConversions;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.SlotType;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import dev.mrsterner.besmirchment.common.block.entity.PhylacteryBlockEntity;
import dev.mrsterner.besmirchment.common.transformation.LichLogic;
import io.github.apace100.origins.origin.OriginLayers;
import io.github.apace100.origins.registry.ModComponents;
import moriyashiine.bewitchment.common.registry.BWComponents;
import moriyashiine.bewitchment.common.registry.BWRegistries;
import net.bettercombat.logic.PlayerAttackHelper;
import net.minecraft.advancement.Advancement;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.minecraft.util.registry.Registry;

// carpet.script.value.EntityValue
@Mixin(targets = "carpet/script/value/EntityValue$1", remap = false)
public class EntityValueMixin extends HashMap<String, BiFunction<Entity, Value, Value>> {
	@Inject(method = "<init>", at = @At("RETURN"), remap = false)
	private void addFeatureAccessors(CallbackInfo ci) {

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
			if (e instanceof TameableEntity tameableEntity) {
				Entity owner = tameableEntity.getOwner();
				return owner == null ? Value.NULL : new EntityValue(owner);
			}
			if (e instanceof ProjectileEntity projectileEntity) {
				Entity owner = projectileEntity.getOwner();
				return owner == null ? Value.NULL : new EntityValue(owner);
			}
			return Value.NULL;
		});



		put("attribute_modifier", (e, a) -> {
			if (!(e instanceof LivingEntity) || a == null || !(a instanceof ListValue)) return Value.NULL;
			List<Value> args = ((ListValue) a).getItems();

			if (args.size() != 2) throw new InternalExpressionException("'attribute_modifier' needs two arguments");

			Identifier id = InputValidator.identifierOf(args.get(0).getString());
			UUID uuid = UUID.fromString(args.get(1).getString());


			EntityAttribute attribute;
			EntityAttributeInstance attributeInstance;
			EntityAttributeModifier attributeModifier;

			if ((attribute = Registry.ATTRIBUTE.get(id)) != null && (attributeInstance = ((LivingEntity) e).getAttributeInstance(attribute)) != null && (attributeModifier = attributeInstance.getModifier(uuid)) != null) {
				return new NumericValue(attributeModifier.getValue());
			}
			return Value.NULL;
		});





		put("dual_wielding", (e, a) -> {
			if (e instanceof PlayerEntity p) {
				return BooleanValue.of(PlayerAttackHelper.isDualWielding(p));
			}
			return Value.NULL;
		});

		put("two_handed", (e, a) -> {
			if (e instanceof PlayerEntity p) {
				return BooleanValue.of(PlayerAttackHelper.isTwoHandedWielding(p));
			}
			return Value.NULL;
		});





		put("trinkets", (e, a) -> {
			if(a == null) {
				Optional<TrinketComponent> component = TrinketsApi.getTrinketComponent((LivingEntity) (Object) e);
				if(component.isPresent()) {
					List<Value> list = new ArrayList<>();
					for (Pair<SlotReference, ItemStack> equipped : component.get().getAllEquipped()) {
						SlotReference slotReference = equipped.getLeft();
						SlotType slotType = slotReference.inventory().getSlotType();
						ItemStack stack = equipped.getRight();

						list.add(ListValue.of(
							new StringValue("trinkets:" + slotType.getGroup() + "/" + slotType.getName()),
							new NumericValue(slotReference.index()),
							ValueConversions.of(stack)
						));
					}
					return ListValue.wrap(list);
				}
			}
			return Value.NULL;
		});



		put("lich_souls", (e, a) -> {

			if (e instanceof PlayerEntity p) {
				Pair<ServerWorld, PhylacteryBlockEntity> phylactery = LichLogic.getPhylactery(p);
				if (phylactery != null) {
					int souls = phylactery.getRight().souls;
					return new NumericValue(souls);
				}
			}
			return Value.NULL;
		});



		put("bw_transformation", (e, a) -> {
			if (e instanceof PlayerEntity p) {
				return new StringValue(BWRegistries.TRANSFORMATIONS.getId(BWComponents.TRANSFORMATION_COMPONENT.get(p).getTransformation()).toString());
			}
			return Value.NULL;
		});
	}
}
