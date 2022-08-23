package net.slimesurvival.common.registry;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.slimesurvival.SlimeSurvival;

public class ModDimensions {
	public static final RegistryKey<World> ADMIN_TEST_WORLD = RegistryKey.of(Registry.WORLD_KEY, SlimeSurvival.ID("admin/test_world"));


	public static final RegistryKey<World> MYST_DEADZONE = RegistryKey.of(Registry.WORLD_KEY, SlimeSurvival.ID("myst/deadzone"));
	public static final RegistryKey<World> MYST_EPISODE_1 = RegistryKey.of(Registry.WORLD_KEY, SlimeSurvival.ID("myst/episode_1"));
	public static final RegistryKey<World> MYST_TRAINYARD = RegistryKey.of(Registry.WORLD_KEY, SlimeSurvival.ID("myst/trainyard"));

	public static final RegistryKey<World> SOUP_CS_OFFICE = RegistryKey.of(Registry.WORLD_KEY, SlimeSurvival.ID("soup/cs_office"));
	public static final RegistryKey<World> SOUP_PARADISE = RegistryKey.of(Registry.WORLD_KEY, SlimeSurvival.ID("soup/cs_office"));
	public static final RegistryKey<World> SOUP_TRAINYARD = RegistryKey.of(Registry.WORLD_KEY, SlimeSurvival.ID("soup/trainyard"));

	public static final RegistryKey<World> ZAXACO_LABYRINTH = RegistryKey.of(Registry.WORLD_KEY, SlimeSurvival.ID("zaxaco/labyrinth"));



	public static void register() {
		SlimeSurvival.LOGGER.debug("Registering dimension keys for " + SlimeSurvival.MOD_ID);
	}
}
