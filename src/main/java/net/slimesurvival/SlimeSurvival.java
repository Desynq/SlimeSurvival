package net.slimesurvival;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import carpet.script.CarpetExpression;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import io.wispforest.owo.registration.reflect.FieldRegistrationHandler;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.slimesurvival.addons.carpet.script.api.Advancements;
import net.slimesurvival.common.item.SSItemGroups;
import net.slimesurvival.common.registry.*;
import net.slimesurvival.util.RegistryHelper;

public class SlimeSurvival implements CarpetExtension, ModInitializer {
	@Deprecated
	public static Identifier ID(String path) {
		return new Identifier(MOD_ID, path);
	}



	public static final String MOD_ID = "slimesurvival";
	public static final String MOD_NAME = "Slime Survival";

	public static final OwoItemGroup TABBED_ITEM_GROUP = new SSItemGroups(RegistryHelper.id("main"));



	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Integer TOTAL_INITIALIZATION_STEPS = 14;
	public static Integer currentInitializationStep = -1;



	@Override
	public void onInitialize() {
		LOGGER.info(System.lineSeparator());
		logInit("Initializing...");

		ModEntityAttributes.register();
		logInit("Registered Entity Attributes");

		logInit(ModBlocks.register());

		logInit(ModItems.register());

		FieldRegistrationHandler.register(ModItemsNew.class, MOD_ID, true);
		logInit("Loaded oωo Items");

		logInit(ModEnchantments.register());

		logInit(ModStatusEffects.register());

		logInit(ModPowerFactories.register());

		TABBED_ITEM_GROUP.initialize();
		logInit("Loaded oωo Item Groups.");


		// Data-Driven
		ModItemTags.register();
		logInit("Loaded Mod Item Tags");
		logInit(ModRecipeSerializers.register());

		logInit(ModLootHandler.register());

		logInit(ModDimensions.register());
		logInit(ModDimensionTypes.register());



		CarpetServer.manageExtension(this);



		logInit("Finished initializing." + System.lineSeparator());
	}

	// bri'ish
	private static void logInit(String string) {
		LOGGER.info(String.format("[%d/%d] " + string, currentInitializationStep += 1, TOTAL_INITIALIZATION_STEPS));
	}



	@Override
	public void scarpetApi(CarpetExpression expression) {
		Advancements.apply(expression.getExpr());
	}
}
