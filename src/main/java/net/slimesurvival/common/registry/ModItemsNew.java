package net.slimesurvival.common.registry;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import io.wispforest.owo.registration.reflect.ItemRegistryContainer;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.slimesurvival.SlimeSurvival;
import net.slimesurvival.common.item.CustomItem;
import net.slimesurvival.common.item.FoodComponents;
import net.slimesurvival.common.item.SSItemGroups;
import net.slimesurvival.common.item.armor.*;
import net.slimesurvival.common.item.material.*;
import net.slimesurvival.common.item.misc.*;
import net.slimesurvival.common.item.tool.*;
import net.slimesurvival.util.StackGenerators;
import net.slimesurvival.util.settings.CustomItemSettings;
import net.slimesurvival.util.settings.ExtendableTooltipSettings;
import net.slimesurvival.util.settings.ItemSettings;

public class ModItemsNew implements ItemRegistryContainer {

	/**
	 * Icons
	*/

	public static final Item ICON = new Item(new OwoItemSettings()
		.group(SlimeSurvival.TABBED_ITEM_GROUP)
		.tab(SSItemGroups.Tabs.ICONS.ordinal())
		.stackGenerator(StackGenerators.ICON_STACK_GENERATOR)
	);



	// Misc
	public static final Item LEXICON = new LexiconItem(ItemSettings.MISC.maxCount(1));










	// Mob Drops
	public static final Item POLAR_BEAR_FUR = new PolarBearFur(ItemSettings.MATERIAL);
	public static final Item CREEPER_FLESH = new Item(ItemSettings.MATERIAL.food(FoodComponents.CREEPER_FLESH));

	// Fishing
	public static final Item AXOLOTL_GILLS = new AxolotlGills(ItemSettings.MATERIAL);

	// Crafting Ingredients
	public static final Item MAGMATIC_MAGMA = new MagmaticMagmaItem(ItemSettings.MATERIAL.maxCount(1), new ExtendableTooltipSettings().hasDetails());
	public static final Item MYSTITE_TOOL_ROD = new MystiteToolRod(ItemSettings.MATERIAL);

	// Minerals
	public static final Item CINNABAR = new Item(ItemSettings.MATERIAL);
	public static final Item MYSTITE_ORE = new MystiteOre(ItemSettings.MATERIAL);

	// Pieces/Chunks
	public static final Item CINNABAR_CHUNK = new Item(ItemSettings.MATERIAL);

	// Dust
	public static final Item COPPER_SULFATE = new Item(ItemSettings.MATERIAL.food(FoodComponents.COPPER_SULFATE));

	// Ingots
	public static final Item ENDERIUM_ALLOY = new CustomItem(ItemSettings.MATERIAL, new ExtendableTooltipSettings(), new CustomItemSettings().hasGlint());
	public static final Item LEAD_INGOT = new Item(ItemSettings.MATERIAL.food(FoodComponents.LEAD_INGOT));
	public static final Item MYSTITE_INGOT = new Item(ItemSettings.MATERIAL);







	/**
	 * Crafting
	*/

	public static final Item MIXING_BOWL = new MixingBowlItem(new OwoItemSettings()
		.group(SlimeSurvival.TABBED_ITEM_GROUP)
		.tab(SSItemGroups.Tabs.CRAFTING.ordinal())
		.maxDamage(32)
		.recipeRemainder(ModItemsNew.MIXING_BOWL)
	);
	public static final Item REINFORCED_MIXING_BOWL = new MixingBowlItem(new OwoItemSettings()
		.group(SlimeSurvival.TABBED_ITEM_GROUP)
		.tab(SSItemGroups.Tabs.CRAFTING.ordinal())
		.maxDamage(256)
		.recipeRemainder(ModItemsNew.MIXING_BOWL)
		.fireproof()
	);
	public static final Item ETERNAL_MIXING_BOWL = new MixingBowlItem(new OwoItemSettings()
		.group(SlimeSurvival.TABBED_ITEM_GROUP)
		.tab(SSItemGroups.Tabs.CRAFTING.ordinal())
		.maxDamage(4096)
		.recipeRemainder(ModItemsNew.MIXING_BOWL)
		.fireproof()
	);



	/**
	 * Tools
	*/

	public static final Item EXPERIENCE_CRYSTAL = new ExperienceCrystalItem(ItemSettings.TOOLS);

	public static final Item MOLTEN_PICKAXE = new MoltenPickaxeItem(ItemSettings.TOOLS);
	public static final Item MOLTEN_AXE = new MoltenAxeItem(ItemSettings.TOOLS);
	public static final Item MOLTEN_SHOVEL = new MoltenShovelItem(ItemSettings.TOOLS);







	// Armor

	public static final Item MYSTITE_HELMET = new MystiteArmor(EquipmentSlot.HEAD, ItemSettings.ARMOR.fireproof());
	public static final Item MYSTITE_CHESTPLATE = new MystiteArmor(EquipmentSlot.CHEST, ItemSettings.ARMOR.fireproof());
	public static final Item MYSTITE_LEGGINGS = new MystiteArmor(EquipmentSlot.LEGS, ItemSettings.ARMOR.fireproof());
	public static final Item MYSTITE_BOOTS = new MystiteArmor(EquipmentSlot.FEET, ItemSettings.ARMOR.fireproof());
}
