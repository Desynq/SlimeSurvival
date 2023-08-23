package slimesurvival.mixins.scarpet;

import java.util.HashMap;
import java.util.function.BiFunction;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import carpet.script.utils.InputValidator;
import carpet.script.value.BooleanValue;
import carpet.script.value.EntityValue;
import carpet.script.value.Value;
import net.minecraft.advancement.Advancement;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.loot.LootDataType;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;


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

			LootContextParameterSet lootContextParameterSet = (new LootContextParameterSet.Builder((ServerWorld) entity.getWorld()))
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
	}
}
