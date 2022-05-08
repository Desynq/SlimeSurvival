package desynq.slimesurvival;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import desynq.slimesurvival.item.material.AxolotlGills;
import desynq.slimesurvival.item.material.MystiteIngot;
import desynq.slimesurvival.item.material.PolarBearFur;
import desynq.slimesurvival.item.material.WoolOfBat;

public class SlimeSurvival implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("slimesurvival");





	public static final ItemGroup Materials = FabricItemGroupBuilder.build(new Identifier("slimesurvival", "materials"), () -> new ItemStack(SlimeSurvival.Polar_Bear_Fur));




	public static final PolarBearFur Polar_Bear_Fur = new PolarBearFur(new FabricItemSettings().group(SlimeSurvival.Materials).maxCount(32));
	public static final WoolOfBat Wool_Of_Bat = new WoolOfBat(new FabricItemSettings().group(SlimeSurvival.Materials).maxCount(32));
	public static final AxolotlGills Axolotl_Gills = new AxolotlGills(new FabricItemSettings().group(SlimeSurvival.Materials).maxCount(32));
	public static final MystiteIngot Mystite_Ingot = new MystiteIngot(new FabricItemSettings().group(SlimeSurvival.Materials).maxCount(32));





	@Override
	public void onInitialize() {
		registerItems();

		LOGGER.info("Slime Survival is now ruining everyone's fun for fun!");
	}





	private void registerItems() {
		Registry.register(Registry.ITEM, new Identifier("slimesurvival", "polar_bear_fur"), Polar_Bear_Fur);
		Registry.register(Registry.ITEM, new Identifier("slimesurvival", "wool_of_bat"), Wool_Of_Bat);
		Registry.register(Registry.ITEM, new Identifier("slimesurvival", "axolotl_gills"), Axolotl_Gills);
		Registry.register(Registry.ITEM, new Identifier("slimesurvival", "mystite_ingot"), Mystite_Ingot);
	}
}
