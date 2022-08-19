package net.slimesurvival.common.registry;

import net.minecraft.util.registry.Registry;
import net.slimesurvival.SlimeSurvival;
import net.slimesurvival.common.recipe.MixingRecipeSerializer;

public class ModRecipeSerializers {
	
	public static void register() {
		Registry.register(Registry.RECIPE_SERIALIZER, SlimeSurvival.ID("mixing"), MixingRecipeSerializer.INSTANCE);
	}
}
