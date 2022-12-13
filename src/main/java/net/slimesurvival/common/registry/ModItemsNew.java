package net.slimesurvival.common.registry;

import io.wispforest.owo.registration.reflect.ItemRegistryContainer;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.slimesurvival.common.item.CustomItem;
import net.slimesurvival.common.item.FoodComponents;
import net.slimesurvival.common.item.SSItemGroups.Tabs;
import net.slimesurvival.common.item.armor.*;
import net.slimesurvival.common.item.material.*;
import net.slimesurvival.common.item.misc.*;
import net.slimesurvival.common.item.tool.*;
import net.slimesurvival.util.StackGenerators;
import net.slimesurvival.util.Tooltips;
import net.slimesurvival.util.settings.CustomItemSettings;
import net.slimesurvival.util.settings.ExtendableTooltipSettings;
import net.slimesurvival.util.settings.ItemSettings;

// this is such a mess...
public class ModItemsNew implements ItemRegistryContainer {

	public static final Item ICON = new Item(ItemSettings.getPreset(Tabs.ICONS).stackGenerator(StackGenerators.ICON_STACK_GENERATOR));

	// Misc
	public static final Item LEXICON = new LexiconItem(ItemSettings.getPreset(Tabs.MISC).maxCount(1));






	// Mob Drops
	public static final Item POLAR_BEAR_FUR = new MaterialItem();
	public static final Item CREEPER_FLESH = new Item(ItemSettings.getPreset(Tabs.MATERIALS).food(FoodComponents.CREEPER_FLESH));

	// Fishing
	public static final Item AXOLOTL_GILLS = new MaterialItem();

	// Crafting Ingredients
	public static final Item MAGMATIC_MAGMA = new MagmaticMagmaItem(ItemSettings.getPreset(Tabs.MATERIALS).maxCount(1), new ExtendableTooltipSettings().hasDetails());
	public static final Item MYSTITE_TOOL_ROD = new MaterialItem();

	// Misc
	public static final Item SMALL_LEATHER = new MaterialItem();


	// Minerals
	public static final Item CINNABAR = new MaterialItem();
	public static final Item MYSTITE_ORE = new MaterialItem();
	public static final Item QUICKSILVER = new QuicksilverItem(ItemSettings.getPreset(Tabs.MATERIALS).food(FoodComponents.QUICKSILVER));
	public static final Item RAW_GALENA = new MaterialItem();

	// Pieces/Chunks
	public static final Item CINNABAR_CHUNK = new MaterialItem();
	public static final Item RAW_GALENA_PIECE = new MaterialItem();
	public static final Item RAW_SILVER_PIECE = new MaterialItem();

	// Dust
	public static final Item COPPER_SULFATE = new Item(ItemSettings.getPreset(Tabs.MATERIALS).food(FoodComponents.COPPER_SULFATE));
	public static final Item NITER = new MaterialItem();
	public static final Item COPPER_DUST = new MaterialItem();
	public static final Item SILVER_DUST = new MaterialItem();
	public static final Item SULFUR_DUST = new MaterialItem();

	// Ingots
	public static final Item ENDERIUM_ALLOY = new CustomItem(ItemSettings.getPreset(Tabs.MATERIALS), new CustomItemSettings().hasGlint());
	public static final Item LEAD_INGOT = new Item(ItemSettings.getPreset(Tabs.MATERIALS).food(FoodComponents.LEAD_INGOT));
	public static final Item MYSTITE_INGOT = new MaterialItem();




	/**
	 * Crafting
	*/

	public static final Item MIXING_BOWL = new MixingBowlItem(
			ItemSettings.getPreset(Tabs.CRAFTING)
					.maxDamage(32)
					.recipeRemainder(ModItemsNew.MIXING_BOWL),
			Tooltips.MIXING_BOWL);
	public static final Item REINFORCED_MIXING_BOWL = new MixingBowlItem(
			ItemSettings.getPreset(Tabs.CRAFTING)
					.maxDamage(256)
					.recipeRemainder(ModItemsNew.REINFORCED_MIXING_BOWL)
					.fireproof(),
			Tooltips.MIXING_BOWL);
	public static final Item ETERNAL_MIXING_BOWL = new MixingBowlItem(
			ItemSettings.getPreset(Tabs.CRAFTING)
					.maxDamage(4096)
					.recipeRemainder(ModItemsNew.ETERNAL_MIXING_BOWL)
					.fireproof(),
			Tooltips.MIXING_BOWL);



	/**
	 * Tools
	*/

	public static final Item EXPERIENCE_CRYSTAL = new ExperienceCrystalItem(ItemSettings.getPreset(Tabs.TOOLS));

	public static final Item MOLTEN_PICKAXE = new MoltenPickaxeItem(ItemSettings.getPreset(Tabs.TOOLS));
	public static final Item MOLTEN_AXE = new MoltenAxeItem(ItemSettings.getPreset(Tabs.TOOLS));
	public static final Item MOLTEN_SHOVEL = new MoltenShovelItem(ItemSettings.getPreset(Tabs.TOOLS));







	// Armor

	public enum ArmorTypes {
		AXOLOTL,
		MYSTITE,
		TURTLE,
	}

	private static int axolotlArmorIndex = 3;
	private static int mystiteArmorIndex = 3;
	private static int turtleArmorIndex = 3;
	private static Item getArmorItem(ArmorTypes armorType) {
		EquipmentSlot slot;
		switch (armorType) {
			case AXOLOTL:
				slot = EquipmentSlot.fromTypeIndex(EquipmentSlot.Type.ARMOR, axolotlArmorIndex--);
				return new AxolotlArmor(slot, ItemSettings.getPreset(Tabs.ARMOR));
			case MYSTITE:
				slot = EquipmentSlot.fromTypeIndex(EquipmentSlot.Type.ARMOR, mystiteArmorIndex--);
				return new MystiteArmor(slot, ItemSettings.getPreset(Tabs.ARMOR).fireproof());
			case TURTLE:
				slot = EquipmentSlot.fromTypeIndex(EquipmentSlot.Type.ARMOR, turtleArmorIndex--);
				return new TurtleArmor(slot, ItemSettings.getPreset(Tabs.ARMOR));
			default:
				return null;
		}
	}


	public static final Item MYSTITE_HELMET = getArmorItem(ArmorTypes.MYSTITE);
	public static final Item MYSTITE_CHESTPLATE = getArmorItem(ArmorTypes.MYSTITE);
	public static final Item MYSTITE_LEGGINGS = getArmorItem(ArmorTypes.MYSTITE);
	public static final Item MYSTITE_BOOTS = getArmorItem(ArmorTypes.MYSTITE);

	public static final Item TURTLE_HELMET = getArmorItem(ArmorTypes.TURTLE);
	public static final Item TURTLE_CHESTPLATE = getArmorItem(ArmorTypes.TURTLE);
	public static final Item TURTLE_LEGGINGS = getArmorItem(ArmorTypes.TURTLE);
	public static final Item TURTLE_BOOTS = getArmorItem(ArmorTypes.TURTLE);

	public static final Item AXOLOTL_HELMET = getArmorItem(ArmorTypes.AXOLOTL);
	public static final Item AXOLOTL_CHESTPLATE = getArmorItem(ArmorTypes.AXOLOTL);
	public static final Item AXOLOTL_LEGGINGS = getArmorItem(ArmorTypes.AXOLOTL);
	public static final Item AXOLOTL_BOOTS = getArmorItem(ArmorTypes.AXOLOTL);
}
