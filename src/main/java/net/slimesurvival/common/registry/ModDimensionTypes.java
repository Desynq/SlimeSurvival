package net.slimesurvival.common.registry;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.dimension.DimensionType;
import net.slimesurvival.SlimeSurvival;

public class ModDimensionTypes {
	public static final RegistryKey<DimensionType> ADMIN_TEST_WORLD = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, ModDimensions.ADMIN_TEST_WORLD.getValue());


	public static final RegistryKey<DimensionType> MYST_DEADZONE = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, ModDimensions.MYST_DEADZONE.getValue());
	public static final RegistryKey<DimensionType> MYST_EPISODE_1 = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, ModDimensions.MYST_EPISODE_1.getValue());
	public static final RegistryKey<DimensionType> MYST_TRAINYARD = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, ModDimensions.MYST_TRAINYARD.getValue());

	public static final RegistryKey<DimensionType> SOUP_CS_OFFICE = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, ModDimensions.SOUP_CS_OFFICE.getValue());
	public static final RegistryKey<DimensionType> SOUP_PARADISE = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, ModDimensions.SOUP_PARADISE.getValue());
	public static final RegistryKey<DimensionType> SOUP_TRAINYARD = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, ModDimensions.SOUP_TRAINYARD.getValue());

	public static final RegistryKey<DimensionType> ZAXACO_LABYRINTH = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, ModDimensions.ZAXACO_LABYRINTH.getValue());



	public static String register() {
		SlimeSurvival.LOGGER.debug("Registering dimension types for " + SlimeSurvival.MOD_ID);

		return "Registered Dimension Types.";
	}
}
