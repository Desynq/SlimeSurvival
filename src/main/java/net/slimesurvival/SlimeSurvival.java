package net.slimesurvival;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.slimesurvival.registry.*;

public class SlimeSurvival implements ModInitializer {
	public static Identifier ID(String path) {
		return new Identifier(MOD_ID, path);
	}

	private static final String MOD_ID = "slimesurvival";




	public static final Logger LOGGER = LoggerFactory.getLogger("slimesurvival");



	@Override
	public void onInitialize() {
		ModBlocks.register();
		ModItems.register();

		LOGGER.info("Slime Survival is now ruining everyone's fun for fun!");
	}
}
