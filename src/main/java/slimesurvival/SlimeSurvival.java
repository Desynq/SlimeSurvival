package slimesurvival;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import slimesurvival.registry.ModEntityAttributes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SlimeSurvival implements ModInitializer {

	public static final String MOD_ID = "slimesurvival";
	public static final String MOD_NAME = "Slime Survival";

	public static Identifier ID(String path) {
		return new Identifier(MOD_ID, path);
	}


	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("slimesurvival");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModEntityAttributes.register();

		LOGGER.info("Hello Fabric world!");
	}
}