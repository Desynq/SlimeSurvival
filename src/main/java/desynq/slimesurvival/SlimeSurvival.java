package desynq.slimesurvival;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import desynq.slimesurvival.item.PolarBearFur;

public class SlimeSurvival implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("slimesurvival");




	public static final ItemGroup Materials = FabricItemGroupBuilder.create(
		new Identifier("slimesurvival", "materials"))
		.icon(() -> new ItemStack(Items.LEATHER))
		.build();




	public static final PolarBearFur Polar_Bear_Fur = new PolarBearFur(
		new FabricItemSettings()
		.group(SlimeSurvival.Materials)
		.maxCount(32));





	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("slimesurvival", "polar_bear_fur"), Polar_Bear_Fur);


		LOGGER.info("Slime Survival is now ruining everyone's fun for fun!");
	}
}
