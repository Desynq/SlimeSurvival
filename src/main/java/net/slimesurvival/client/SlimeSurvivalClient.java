package net.slimesurvival.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ClientModInitializer;
import net.slimesurvival.client.registry.ModColorProvider;
import net.slimesurvival.client.registry.ModModelPredicateProvider;

public class SlimeSurvivalClient implements ClientModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger("slimesurvival");

	@Override
	public void onInitializeClient() {
		ModColorProvider.register();
		ModModelPredicateProvider.register();

		LOGGER.info("Slime Survival client entry point is now initialized!");
	}
}
