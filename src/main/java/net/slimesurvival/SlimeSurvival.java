package net.slimesurvival;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import carpet.script.CarpetExpression;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.slimesurvival.addons.carpet.script.api.Advancements;
import net.slimesurvival.addons.carpet.script.api.UUIDUtils;
import net.slimesurvival.common.item.SSItemGroup;

public class SlimeSurvival implements CarpetExtension, ModInitializer {
	@Deprecated
	public static Identifier ID(String path) {
		return new Identifier(MOD_ID, path);
	}



	public static final String MOD_ID = "slimesurvival";
	public static final String MOD_NAME = "Slime Survival";



	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



	@Override
	public void onInitialize() {
		CarpetServer.manageExtension(this);

		SSItemGroup.GROUP.initialize();
	}



	@Override
	public void scarpetApi(CarpetExpression expression) {
		Advancements.apply(expression.getExpr());
		UUIDUtils.apply(expression.getExpr());
	}
}
