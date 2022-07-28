package net.slimesurvival;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import carpet.script.CarpetExpression;
import net.slimesurvival.addons.carpet.script.api.Advancements;
import net.slimesurvival.common.event.*;
import net.slimesurvival.registry.*;

public class SlimeSurvival implements CarpetExtension, ModInitializer {
	public static Identifier ID(String path) {
		return new Identifier(MOD_ID, path);
	}

	private static final String MOD_ID = "slimesurvival";




	public static final Logger LOGGER = LoggerFactory.getLogger("slimesurvival");



	@Override
	public void onInitialize() {
		ModBlocks.register();
		ModMaterials.register();
		ModItems.register();
		ModEnchantments.register();
		ModStats.register();

		ModPowers.register();


		ShieldBlock.register();


		CarpetServer.manageExtension(this);



		LOGGER.info("Slime Survival is now ruining everyone's fun for fun!");
	}



	@Override
	public void scarpetApi(CarpetExpression expression) {
		Advancements.apply(expression.getExpr());
	}
}
