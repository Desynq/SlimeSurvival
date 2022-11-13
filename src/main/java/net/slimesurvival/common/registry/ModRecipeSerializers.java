package net.slimesurvival.common.registry;

import net.minecraft.util.registry.Registry;
import net.slimesurvival.common.recipe.MixingRecipeSerializer;
import net.slimesurvival.util.RegistryHelper;

public class ModRecipeSerializers {
	
	public static String register() {
		Registry.register(Registry.RECIPE_SERIALIZER, RegistryHelper.id("mixing"), MixingRecipeSerializer.INSTANCE);

		return "Registered Recipe Serializers.";
	}
}
