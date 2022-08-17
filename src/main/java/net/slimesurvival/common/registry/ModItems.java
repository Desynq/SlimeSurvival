package net.slimesurvival.common.registry;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;

import moriyashiine.bewitchment.common.registry.BWMaterials;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.slimesurvival.common.armor.*;
import net.slimesurvival.common.item.ammo.*;
import net.slimesurvival.common.item.material.*;
import net.slimesurvival.common.item.misc.*;
import net.slimesurvival.common.item.tool.*;
import net.slimesurvival.common.item.trinket.*;
import net.slimesurvival.common.item.weapon.*;



public class ModItems {
	public static final Item ICON = ModItems.register("icon", new Item(new FabricItemSettings()));



	public static final Item LEXICON = ModItems.register("lexicon", new Lexicon(new FabricItemSettings()));

	public static final Item EXPERIENCE_CRYSTAL = ModItems.register("experience_crystal", new ExperienceCrystal(new FabricItemSettings()));
	public static final Item MIXING_BOWL = ModItems.register("mixing_bowl", new MixingBowl(new FabricItemSettings()));





	public static final Item POLAR_BEAR_FUR = ModItems.register("polar_bear_fur", new PolarBearFur(new FabricItemSettings().group(ModItemGroups.Materials).maxCount(32)));
	public static final Item AXOLOTL_GILLS = ModItems.register("axolotl_gills", new AxolotlGills(new FabricItemSettings().group(ModItemGroups.Materials).maxCount(32)));
	public static final Item MYSTITE_INGOT = ModItems.register("mystite_ingot", new MystiteIngot(new FabricItemSettings().group(ModItemGroups.Materials).maxCount(32)));
	public static final Item MYSTITE_TOOL_ROD = ModItems.register("mystite_tool_rod", new MystiteToolRod(new FabricItemSettings().group(ModItemGroups.Materials).maxCount(32)));
	public static final Item MYSTITE_ORE = ModItems.register("mystite_ore", new MystiteOre(new FabricItemSettings().group(ModItemGroups.Materials).maxCount(32)));
	public static final Item ENDERIUM_ALLOY = ModItems.register("enderium_alloy", new EnderiumAlloy(new FabricItemSettings().group(ModItemGroups.Materials).maxCount(32)));

	public static final Item CINNABAR = ModItems.register("cinnabar", new Cinnabar(new FabricItemSettings()));
	public static final Item CINNABAR_CHUNK = ModItems.register("cinnabar_chunk", new CinnabarChunk(new FabricItemSettings()));
	public static final Item COPPER_SULFATE = ModItems.register("copper_sulfate", new CopperSulfate(new FabricItemSettings()));
	public static final Item CREEPER_FLESH = ModItems.register("creeper_flesh", new CreeperFlesh(new FabricItemSettings()));
	public static final Item LEAD_INGOT = ModItems.register("lead_ingot", new LeadIngot(new FabricItemSettings()));
	public static final Item MAGMATIC_MAGMA = ModItems.register("magmatic_magma", new MagmaticMagma(new FabricItemSettings()));
	public static final Item QUICKSILVER = ModItems.register("quicksilver", new Quicksilver(new FabricItemSettings()));
	public static final Item RAW_GALENA = ModItems.register("raw_galena", new RawGalena(new FabricItemSettings()));
	public static final Item RAW_GALENA_PIECE = ModItems.register("raw_galena_piece", new RawGalenaPiece(new FabricItemSettings()));
	public static final Item SMALL_LEATHER = ModItems.register("small_leather", new SmallLeather(new FabricItemSettings()));
	public static final Item SULFUR = ModItems.register("sulfur", new Sulfur(new FabricItemSettings()));






	public static final Item MOLTEN_PICKAXE = ModItems.register("molten_pickaxe", new MoltenPickaxe(new FabricItemSettings()));
	public static final Item MOLTEN_AXE = ModItems.register("molten_axe", new MoltenAxe(new FabricItemSettings()));
	public static final Item MOLTEN_SHOVEL = ModItems.register("molten_shovel", new MoltenShovel(new FabricItemSettings()));



	public static final Item MOLTEN_SWORD = ModItems.register("molten_sword", new MoltenSword(new FabricItemSettings()));
	public static final Item RIFT_BATTLEAXE = ModItems.register("rift_battleaxe", new RiftBattleaxe(ModToolMaterials.MYSTITE, 29.0F, -3.25F, new FabricItemSettings().group(ModItemGroups.Weapons)));


	public static final Item DUSKBREAKER = ModItems.register("duskbreaker", (Item)new Duskbreaker(BWMaterials.SILVER_TOOL, 5, -2.0F, new FabricItemSettings().group(ModItemGroups.Weapons)));
	public static final Item BAN_HAMMER = ModItems.register("ban_hammer", (Item)new BanHammer(ToolMaterials.DIAMOND, Integer.MAX_VALUE, 16.0F, new FabricItemSettings().group(ModItemGroups.Weapons)));



	public static final Item MYSTITE_BOW = ModItems.register("mystite_bow", (Item)new MystiteBow(new Item.Settings()
		.maxDamage(ModToolMaterials.MYSTITE.getDurability())
		.fireproof()
		.group(ModItemGroups.Weapons)
	));

	public static final Item ZEUS_BOW = register("zeus_bow", (Item)new ZeusBow(new Item.Settings()
		.maxDamage(1337)
		.group(ModItemGroups.Weapons)
	));








	public static final ArmorMaterial MYSTITE_ARMOR_MATERIAL = MystiteArmorMaterial.getInstance();

	public static final Item MYSTITE_HELMET = ModItems.register("mystite_helmet", (Item)new MystiteArmor(MYSTITE_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().fireproof().group(ModItemGroups.Equipment)));
	public static final Item MYSTITE_CHESTPLATE = ModItems.register("mystite_chestplate", (Item)new MystiteArmor(MYSTITE_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().fireproof().group(ModItemGroups.Equipment)));
	public static final Item MYSTITE_LEGGINGS = ModItems.register("mystite_leggings", (Item)new MystiteArmor(MYSTITE_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().fireproof().group(ModItemGroups.Equipment)));
	public static final Item MYSTITE_BOOTS = ModItems.register("mystite_boots", (Item)new MystiteArmor(MYSTITE_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().fireproof().group(ModItemGroups.Equipment)));









	public static final Item NETHERITE_SHIELD = ModItems.register("netherite_shield", (Item)new FabricShieldItem(new FabricItemSettings().maxDamage(2500).group(ModItemGroups.Equipment), 60, 13, Items.NETHERITE_INGOT));
	public static final Item DRAGON_SHIELD = ModItems.register("dragon_shield", (Item)new FabricShieldItem(new FabricItemSettings().maxDamage(3200).group(ModItemGroups.Equipment), 20, 13, Items.NETHERITE_INGOT));




	public static final Item BOLT_ACTION_RIFLE = ModItems.register("bolt_action_rifle", (Item)new BoltActionRifle(new FabricItemSettings()));





	public static final Item HEAVY_RIFLE_AMMO = ModItems.register("heavy_rifle_ammo", (Item)new HeavyRifleAmmo(new FabricItemSettings()));
	public static final Item RIFLE_AMMO = ModItems.register("rifle_ammo", (Item)new RifleAmmo(new FabricItemSettings()));
	public static final Item PISTOL_AMMO = ModItems.register("pistol_ammo", (Item)new PistolAmmo(new FabricItemSettings()));
	public static final Item SHOTGUN_AMMO = ModItems.register("shotgun_ammo", (Item)new ShotgunAmmo(new FabricItemSettings()));

















	public static final Item UTILITY_BELT = ModItems.register("utility_belt", new UtilityBelt(new FabricItemSettings().group(ModItemGroups.Equipment).maxCount(1)));

	public static final Item WINTER_COAT = ModItems.register("winter_coat", new WinterCoat(new FabricItemSettings().group(ModItemGroups.Equipment).maxCount(1)));
	public static final Item COUNTERCURSE_MANTRA = ModItems.register("countercurse_mantra", new CountercurseMantra(new FabricItemSettings().group(ModItemGroups.Equipment).maxCount(1)));
	public static final Item REACTOR_CORE = ModItems.register("reactor_core", new ReactorCore(new FabricItemSettings().group(ModItemGroups.Equipment).maxCount(1)));

	public static final Item SHAPED_GLASS = ModItems.register("shaped_glass", new ShapedGlass(new FabricItemSettings().group(ModItemGroups.Equipment).maxCount(1)));
	public static final Item BlOODSTAINED_GLASS = ModItems.register("bloodstained_glass", new BloodstainedGlass(new FabricItemSettings().group(ModItemGroups.Equipment).maxCount(1)));









	public static final Item GMOD_BLOCK = ModItems.register(ModBlocks.GMOD_BLOCK, ModItemGroups.BLOCKS);

	public static final Item SOLID_BLACK = ModItems.register(ModBlocks.SOLID_BLACK, ModItemGroups.BLOCKS);
	public static final Item SOLID_BLUE = ModItems.register(ModBlocks.SOLID_BLUE, ModItemGroups.BLOCKS);
	public static final Item SOLID_GREEN = ModItems.register(ModBlocks.SOLID_GREEN, ModItemGroups.BLOCKS);
	public static final Item SOLID_MAGENTA = ModItems.register(ModBlocks.SOLID_MAGENTA, ModItemGroups.BLOCKS);
	public static final Item SOLID_RED = ModItems.register(ModBlocks.SOLID_RED, ModItemGroups.BLOCKS);
	public static final Item SOLID_WHITE = ModItems.register(ModBlocks.SOLID_WHITE, ModItemGroups.BLOCKS);
	public static final Item SOLID_YELLOW = ModItems.register(ModBlocks.SOLID_YELLOW, ModItemGroups.BLOCKS);













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