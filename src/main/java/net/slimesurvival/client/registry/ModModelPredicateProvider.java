package net.slimesurvival.client.registry;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import net.slimesurvival.SlimeSurvival;
import net.slimesurvival.common.item.misc.ExperienceCrystal;
import net.slimesurvival.common.registry.ModItems;

public class ModModelPredicateProvider {
	
	public static void register() {
		ModelPredicateProviderRegistry.register(ModItems.EXPERIENCE_CRYSTAL, SlimeSurvival.ID("fill"), (stack, world, entity, seed) -> (float)ExperienceCrystal.getStoredExperience(stack) / 3000.0f);



		ModelPredicateProviderRegistry.register(ModItems.MYSTITE_LONGBOW, new Identifier("pull"), (stack, world, entity, seed) -> {
			if (entity == null) {
				return 0.0f;
			}
			if (entity.getActiveItem() != stack) {
				return 0.0f;
			}
			return (float) (stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20.0f;
		});
		ModelPredicateProviderRegistry.register(ModItems.MYSTITE_LONGBOW, new Identifier("pulling"), (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0f : 0.0f);







		ModelPredicateProviderRegistry.register(ModItems.MYSTITE_SHORTBOW, new Identifier("pull"), (stack, world, entity, seed) -> {
			if (entity == null) {
				return 0.0f;
			}
			if (entity.getActiveItem() != stack) {
				return 0.0f;
			}
			return (float) (stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20.0f;
		});
		ModelPredicateProviderRegistry.register(ModItems.MYSTITE_SHORTBOW, new Identifier("pulling"), (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0f : 0.0f);












		ModelPredicateProviderRegistry.register(ModItems.ZEUS_BOW, new Identifier("pull"), (stack, world, entity, seed) -> {
			if (entity == null) {
				return 0.0f;
			}
			if (entity.getActiveItem() != stack) {
				return 0.0f;
			}
			return (float) (stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20.0f;
		});
		ModelPredicateProviderRegistry.register(ModItems.ZEUS_BOW, new Identifier("pulling"), (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0f : 0.0f);
	}
}
