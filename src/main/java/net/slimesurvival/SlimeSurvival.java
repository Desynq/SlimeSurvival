package net.slimesurvival;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import carpet.script.CarpetExpression;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.slimesurvival.addons.carpet.script.api.Advancements;
import net.slimesurvival.common.registry.ModAttributes;
import net.slimesurvival.common.registry.ModBlocks;
import net.slimesurvival.common.registry.ModDimensionTypes;
import net.slimesurvival.common.registry.ModDimensions;
import net.slimesurvival.common.registry.ModEnchantments;
import net.slimesurvival.common.registry.ModItemTags;
import net.slimesurvival.common.registry.ModItems;
import net.slimesurvival.common.registry.ModLootHandler;
import net.slimesurvival.common.registry.ModPowerFactories;
import net.slimesurvival.common.registry.ModRecipeSerializers;
import net.slimesurvival.common.registry.ModStatusEffects;

public class SlimeSurvival implements CarpetExtension, ModInitializer {
	public static Identifier ID(String path) {
		return new Identifier(MOD_ID, path);
	}

	public static final String MOD_ID = "slimesurvival";
	public static final String MOD_NAME = "Slime Survival";




	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



	@Override
	public void onInitialize() {
		ModAttributes.register();
		ModBlocks.register();
		ModItems.register();
		ModEnchantments.register();
		ModStatusEffects.register();

		ModPowerFactories.register();


		// Data-Driven
		ModItemTags.register();
		ModRecipeSerializers.register();

		ModLootHandler.register();

		ModDimensions.register();
		ModDimensionTypes.register();



		CarpetServer.manageExtension(this);



		LOGGER.info("Slime Survival is now ruining everyone's fun for fun!");
	}



	@Override
	public void scarpetApi(CarpetExpression expression) {
		Advancements.apply(expression.getExpr());
	}
}
