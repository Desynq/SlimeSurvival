package net.slimesurvival.common;

import com.chocohead.mm.api.ClassTinkerers;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Formatting;

public class SlimeSurvivalEarlyRiser implements Runnable {
	
	@Override
	public void run() {
		var remapper = FabricLoader.getInstance().getMappingResolver();
		String advancementFrame = remapper.mapClassName("intermediary", "net.minecraft.class_189"); // net.minecraft.advancement.AdvancementFrame

		String formatting = 'L' + remapper.mapClassName("intermediary", "net.minecraft.class_124") + ';';
		ClassTinkerers.enumBuilder(advancementFrame, "Ljava/lang/String;", "I", formatting).addEnum("STARTER", () -> new Object[] {"starter", 78, Formatting.BLUE}).build();
	}
}
