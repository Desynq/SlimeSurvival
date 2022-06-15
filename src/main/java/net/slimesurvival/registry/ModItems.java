package net.slimesurvival.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.slimesurvival.armor.*;
import net.slimesurvival.item.material.*;
import net.slimesurvival.item.weapon.*;
import net.slimesurvival.toolmaterial.*;



public class ModItems {
	public static final Item ICON = ModItems.register("icon", new Item(new FabricItemSettings()));



	public static final Item POLAR_BEAR_FUR = ModItems.register("polar_bear_fur", new PolarBearFur(new FabricItemSettings().group(ModItemGroup.Materials).maxCount(32)));
	public static final Item AXOLOTL_GILLS = ModItems.register("axolotl_gills", new AxolotlGills(new FabricItemSettings().group(ModItemGroup.Materials).maxCount(32)));
	public static final Item MYSTITE_INGOT = ModItems.register("mystite_ingot", new MystiteIngot(new FabricItemSettings().group(ModItemGroup.Materials).maxCount(32)));
	public static final Item MYSTITE_TOOL_ROD = ModItems.register("mystite_tool_rod", new MystiteToolRod(new FabricItemSettings().group(ModItemGroup.Materials).maxCount(32)));
	public static final Item MYSTITE_ORE = ModItems.register("mystite_ore", new MystiteOre(new FabricItemSettings().group(ModItemGroup.Materials).maxCount(32)));
	public static final Item ENDERIUM_ALLOY = ModItems.register("enderium_alloy", new EnderiumAlloy(new FabricItemSettings().group(ModItemGroup.Materials).maxCount(32)));





	public static final Item RIFT_BATTLEAXE = ModItems.register("rift_battleaxe", (Item)new RiftBattleaxe(MystiteMaterial.INSTANCE, 29.0F, -3.25F, new FabricItemSettings().group(ModItemGroup.Weapons)));
	public static final Item BAN_HAMMER = ModItems.register("ban_hammer", (Item)new BanHammer(MystiteMaterial.INSTANCE, 2147483647, 16.0F, new FabricItemSettings().group(ModItemGroup.Weapons)));





	public static final ArmorMaterial MYSTITE_ARMOR_MATERIAL = MystiteArmorMaterial.getInstance();

	public static final Item MYSTITE_HELMET = ModItems.register("mystite_helmet", (Item)new MystiteArmor(MYSTITE_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().fireproof().group(ModItemGroup.Armor)));
	public static final Item MYSTITE_CHESTPLATE = ModItems.register("mystite_chestplate", (Item)new MystiteArmor(MYSTITE_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().fireproof().group(ModItemGroup.Armor)));
	public static final Item MYSTITE_LEGGINGS = ModItems.register("mystite_leggings", (Item)new MystiteArmor(MYSTITE_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().fireproof().group(ModItemGroup.Armor)));
	public static final Item MYSTITE_BOOTS = ModItems.register("mystite_boots", (Item)new MystiteArmor(MYSTITE_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().fireproof().group(ModItemGroup.Armor)));






	public static final Item GMOD_BLOCK = ModItems.register(ModBlocks.GMOD_BLOCK, ModItemGroup.BLOCKS);

	public static final Item SOLID_BLACK = ModItems.register(ModBlocks.SOLID_BLACK, ModItemGroup.BLOCKS);
	public static final Item SOLID_BLUE = ModItems.register(ModBlocks.SOLID_BLUE, ModItemGroup.BLOCKS);
	public static final Item SOLID_GREEN = ModItems.register(ModBlocks.SOLID_GREEN, ModItemGroup.BLOCKS);
	public static final Item SOLID_MAGENTA = ModItems.register(ModBlocks.SOLID_MAGENTA, ModItemGroup.BLOCKS);
	public static final Item SOLID_RED = ModItems.register(ModBlocks.SOLID_RED, ModItemGroup.BLOCKS);
	public static final Item SOLID_WHITE = ModItems.register(ModBlocks.SOLID_WHITE, ModItemGroup.BLOCKS);
	public static final Item SOLID_YELLOW = ModItems.register(ModBlocks.SOLID_YELLOW, ModItemGroup.BLOCKS);













	private static Item register(Block block, ItemGroup group) {
		return ModItems.register(new BlockItem(block, new FabricItemSettings().group(group)));
	}

	private static Item register(BlockItem item) {
		return ModItems.register(item.getBlock(), (Item)item);
	}

	protected static Item register(Block block, Item item) {
		return ModItems.register(Registry.BLOCK.getId(block), item);
	}

	private static Item register(String id, Item item) {
		return ModItems.register(new Identifier("slimesurvival" ,id), item);
	}

	private static Item register(Identifier id, Item item) {
		return Registry.register(Registry.ITEM, id, item);
	}



	public static void register() {}
}