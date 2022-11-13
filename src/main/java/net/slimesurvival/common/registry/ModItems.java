package net.slimesurvival.common.registry;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import moriyashiine.bewitchment.common.registry.BWMaterials;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.slimesurvival.SlimeSurvival;
import net.slimesurvival.common.armor.AxolotlArmor;
import net.slimesurvival.common.armor.MystiteArmor;
import net.slimesurvival.common.armor.TurtleArmor;
import net.slimesurvival.common.item.DustItem;
import net.slimesurvival.common.item.RawOrePieceItem;
import net.slimesurvival.common.item.SSItemGroups;
import net.slimesurvival.common.item.ammo.HeavyRifleAmmo;
import net.slimesurvival.common.item.ammo.PistolAmmo;
import net.slimesurvival.common.item.ammo.RifleAmmo;
import net.slimesurvival.common.item.ammo.ShotgunAmmo;
import net.slimesurvival.common.item.material.LeadIngot;
import net.slimesurvival.common.item.material.MagmaticMagma;
import net.slimesurvival.common.item.material.Niter;
import net.slimesurvival.common.item.material.Quicksilver;
import net.slimesurvival.common.item.material.RawGalena;
import net.slimesurvival.common.item.material.SmallLeather;
import net.slimesurvival.common.item.trinket.ArcheryGoggles;
import net.slimesurvival.common.item.trinket.BlackBelt;
import net.slimesurvival.common.item.trinket.BloodstainedGlass;
import net.slimesurvival.common.item.trinket.CountercurseMantra;
import net.slimesurvival.common.item.trinket.ReactorCore;
import net.slimesurvival.common.item.trinket.ShapedGlass;
import net.slimesurvival.common.item.trinket.TacticalGlove;
import net.slimesurvival.common.item.trinket.UtilityBelt;
import net.slimesurvival.common.item.trinket.WinterCoat;
import net.slimesurvival.common.item.weapon.gun.BoltActionRifle;
import net.slimesurvival.common.item.weapon.melee.BanHammer;
import net.slimesurvival.common.item.weapon.melee.ButterflyKnife;
import net.slimesurvival.common.item.weapon.melee.Duskbreaker;
import net.slimesurvival.common.item.weapon.melee.MoltenSword;
import net.slimesurvival.common.item.weapon.melee.RiftBattleaxe;
import net.slimesurvival.common.item.weapon.melee.RiftDagger;
import net.slimesurvival.common.item.weapon.melee.RiftGreatsword;
import net.slimesurvival.common.item.weapon.melee.RiftHalberd;
import net.slimesurvival.common.item.weapon.melee.SentientKatana;
import net.slimesurvival.common.item.weapon.melee.Zweihander;
import net.slimesurvival.common.item.weapon.ranged.MystiteLongbow;
import net.slimesurvival.common.item.weapon.ranged.MystiteShortbow;
import net.slimesurvival.common.item.weapon.ranged.ZeusBow;
import net.slimesurvival.util.RegistryHelper;


@Deprecated
public class ModItems {

	public static final Item LEAD_INGOT = register("lead_ingot", new LeadIngot(new FabricItemSettings()));
	public static final Item MAGMATIC_MAGMA = register("magmatic_magma", new MagmaticMagma(new FabricItemSettings()));
	public static final Item NITER = register("niter", new Niter(new FabricItemSettings()));
	public static final Item QUICKSILVER = register("quicksilver", new Quicksilver(new FabricItemSettings()));
	public static final Item RAW_GALENA = register("raw_galena", new RawGalena(new FabricItemSettings()));
	public static final Item SMALL_LEATHER = register("small_leather", new SmallLeather(new FabricItemSettings()));


	public static final Item RAW_GALENA_PIECE = register("raw_galena_piece", new RawOrePieceItem(new FabricItemSettings()));
	public static final Item RAW_SILVER_PIECE = register("raw_silver_piece", new RawOrePieceItem(new FabricItemSettings()));


	public static final Item COPPER_DUST = register("copper_dust", new DustItem(new FabricItemSettings()));
	public static final Item NITER_DUST = register("niter_dust", new DustItem(new FabricItemSettings()));
	public static final Item SILVER_DUST = register("silver_dust", new DustItem(new FabricItemSettings()));
	public static final Item SULFUR_DUST = register("sulfur_dust", new DustItem(new FabricItemSettings()));







	public static final Item BAN_HAMMER = register("ban_hammer", new BanHammer(ToolMaterials.DIAMOND, Integer.MAX_VALUE, 16.0F, new FabricItemSettings().group(ModItemGroups.WEAPONS)));

	public static final Item BUTTERFLY_KNIFE = register("butterfly_knife", new ButterflyKnife(new FabricItemSettings()));

	public static final Item DUSKBREAKER = register("duskbreaker", new Duskbreaker(BWMaterials.SILVER_TOOL, 5, -2.0F, new FabricItemSettings().group(ModItemGroups.WEAPONS)));

	public static final Item MOLTEN_SWORD = register("molten_sword", new MoltenSword(new FabricItemSettings()));

	public static final Item RIFT_BATTLEAXE = register("rift_battleaxe", new RiftBattleaxe(new FabricItemSettings()));
	public static final Item RIFT_DAGGER = register("rift_dagger", new RiftDagger(new FabricItemSettings()));
	public static final Item RIFT_GREATSWORD = register("rift_greatsword", new RiftGreatsword(new FabricItemSettings()));
	public static final Item RIFT_HALBERD = register("rift_halberd", new RiftHalberd(new FabricItemSettings()));

	public static final Item SENTIENT_KATANA = register("sentient_katana", new SentientKatana(new FabricItemSettings()));

	public static final Item ZWEIHANDER = register("zweihander", new Zweihander(new FabricItemSettings()));








	public static final Item MYSTITE_SHORTBOW = register("mystite_shortbow", new MystiteShortbow(new FabricItemSettings()));
	public static final Item MYSTITE_LONGBOW = register("mystite_longbow", new MystiteLongbow(new FabricItemSettings()));

	public static final Item ZEUS_BOW = register("zeus_bow", new ZeusBow(new FabricItemSettings()));








	public static final Item MYSTITE_HELMET = register("mystite_helmet", new MystiteArmor(ModArmorMaterials.MYSTITE, EquipmentSlot.HEAD, new Item.Settings().fireproof().group(ModItemGroups.EQUIPMENT)));
	public static final Item MYSTITE_CHESTPLATE = register("mystite_chestplate", new MystiteArmor(ModArmorMaterials.MYSTITE, EquipmentSlot.CHEST, new Item.Settings().fireproof().group(ModItemGroups.EQUIPMENT)));
	public static final Item MYSTITE_LEGGINGS = register("mystite_leggings", new MystiteArmor(ModArmorMaterials.MYSTITE, EquipmentSlot.LEGS, new Item.Settings().fireproof().group(ModItemGroups.EQUIPMENT)));
	public static final Item MYSTITE_BOOTS = register("mystite_boots", new MystiteArmor(ModArmorMaterials.MYSTITE, EquipmentSlot.FEET, new Item.Settings().fireproof().group(ModItemGroups.EQUIPMENT)));



	public static final Item TURTLE_HELMET = register("turtle_helmet", new TurtleArmor(ModArmorMaterials.TURTLE, EquipmentSlot.HEAD, new FabricItemSettings().group(ModItemGroups.EQUIPMENT)));
	public static final Item TURTLE_CHESTPLATE = register("turtle_chestplate", new TurtleArmor(ModArmorMaterials.TURTLE, EquipmentSlot.CHEST, new FabricItemSettings().group(ModItemGroups.EQUIPMENT)));
	public static final Item TURTLE_LEGGINGS = register("turtle_leggings", new TurtleArmor(ModArmorMaterials.TURTLE, EquipmentSlot.LEGS, new FabricItemSettings().group(ModItemGroups.EQUIPMENT)));
	public static final Item TURTLE_BOOTS = register("turtle_boots", new TurtleArmor(ModArmorMaterials.TURTLE, EquipmentSlot.FEET, new FabricItemSettings().group(ModItemGroups.EQUIPMENT)));



	public static final Item AXOLOTL_HELMET = register("axolotl_helmet", new AxolotlArmor(ModArmorMaterials.AXOLOTL, EquipmentSlot.HEAD, new FabricItemSettings().group(ModItemGroups.EQUIPMENT)));
	public static final Item AXOLOTL_CHESTPLATE = register("axolotl_chestplate", new AxolotlArmor(ModArmorMaterials.AXOLOTL, EquipmentSlot.CHEST, new FabricItemSettings().group(ModItemGroups.EQUIPMENT)));
	public static final Item AXOLOTL_LEGGINGS = register("axolotl_leggings", new AxolotlArmor(ModArmorMaterials.AXOLOTL, EquipmentSlot.LEGS, new FabricItemSettings().group(ModItemGroups.EQUIPMENT)));
	public static final Item AXOLOTL_BOOTS = register("axolotl_boots", new AxolotlArmor(ModArmorMaterials.AXOLOTL, EquipmentSlot.FEET, new FabricItemSettings().group(ModItemGroups.EQUIPMENT)));









	public static final Item NETHERITE_SHIELD = register("netherite_shield", (Item)new FabricShieldItem(new FabricItemSettings().maxDamage(2500).group(ModItemGroups.EQUIPMENT), 60, 13, Items.NETHERITE_INGOT));
	public static final Item DRAGON_SHIELD = register("dragon_shield", (Item)new FabricShieldItem(new FabricItemSettings().maxDamage(3200).group(ModItemGroups.EQUIPMENT), 20, 13, Items.NETHERITE_INGOT));




	public static final Item BOLT_ACTION_RIFLE = register("bolt_action_rifle", (Item)new BoltActionRifle(new FabricItemSettings()));





	public static final Item HEAVY_RIFLE_AMMO = register("heavy_rifle_ammo", (Item)new HeavyRifleAmmo(new FabricItemSettings()));
	public static final Item RIFLE_AMMO = register("rifle_ammo", (Item)new RifleAmmo(new FabricItemSettings()));
	public static final Item PISTOL_AMMO = register("pistol_ammo", (Item)new PistolAmmo(new FabricItemSettings()));
	public static final Item SHOTGUN_AMMO = register("shotgun_ammo", (Item)new ShotgunAmmo(new FabricItemSettings()));

















	public static final Item UTILITY_BELT = register("utility_belt", new UtilityBelt(new OwoItemSettings()
		.group(SlimeSurvival.TABBED_ITEM_GROUP)
		.tab(SSItemGroups.Tabs.TRINKETS.ordinal())
		.maxCount(1)
	));
	public static final Item WINTER_COAT = register("winter_coat", new WinterCoat(new OwoItemSettings()
		.group(SlimeSurvival.TABBED_ITEM_GROUP)
		.tab(SSItemGroups.Tabs.TRINKETS.ordinal())
		.maxCount(1)
	));

	public static final Item COUNTERCURSE_MANTRA = register("countercurse_mantra", new CountercurseMantra(new FabricItemSettings().group(ModItemGroups.TRINKETS).maxCount(1)));
	public static final Item REACTOR_CORE = register("reactor_core", new ReactorCore(new FabricItemSettings().group(ModItemGroups.TRINKETS).maxCount(1)));

	public static final Item SHAPED_GLASS = register("shaped_glass", new ShapedGlass(new FabricItemSettings().group(ModItemGroups.TRINKETS).maxCount(1)));
	public static final Item BlOODSTAINED_GLASS = register("bloodstained_glass", new BloodstainedGlass(new FabricItemSettings().group(ModItemGroups.TRINKETS).maxCount(1)));

	public static final Item TACTICAL_GLOVE = register("tactical_glove", new TacticalGlove(new FabricItemSettings()));
	public static final Item ARCHERY_GOGGLES = register("archery_goggles", new ArcheryGoggles(new FabricItemSettings()));
	public static final Item BLACK_BELT = register("black_belt", new BlackBelt(new FabricItemSettings()));









	public static final Item GMOD_BLOCK = register(ModBlocks.GMOD_BLOCK, "blocks");

	public static final Item SOLID_BLACK = register(ModBlocks.SOLID_BLACK, "blocks");
	public static final Item SOLID_BLUE = register(ModBlocks.SOLID_BLUE, "blocks");
	public static final Item SOLID_GREEN = register(ModBlocks.SOLID_GREEN, "blocks");
	public static final Item SOLID_MAGENTA = register(ModBlocks.SOLID_MAGENTA, "blocks");
	public static final Item SOLID_RED = register(ModBlocks.SOLID_RED, "blocks");
	public static final Item SOLID_WHITE = register(ModBlocks.SOLID_WHITE, "blocks");
	public static final Item SOLID_YELLOW = register(ModBlocks.SOLID_YELLOW, "blocks");

	public static final Item FAKE_TNT = register(ModBlocks.FAKE_TNT, "blocks");

	public static final Item CRACKED_OBSIDIAN = register(ModBlocks.CRACKED_OBSIDIAN, "blocks");


	public static final Item ENDER_SHOP = register(ModBlocks.ENDER_SHOP, "blocks");













	private static Item register(Block block, String tabName) {
		return register(new BlockItem(block, new OwoItemSettings().group(SlimeSurvival.TABBED_ITEM_GROUP).tab(SSItemGroups.Tabs.BLOCKS.ordinal())));
	}

	private static Item register(BlockItem item) {
		return register(item.getBlock(), (Item)item);
	}

	protected static Item register(Block block, Item item) {
		return register(Registry.BLOCK.getId(block), item);
	}

	private static Item register(String id, Item item) {
		return register(RegistryHelper.id(id), item);
	}

	private static Item register(Identifier id, Item item) {
		return Registry.register(Registry.ITEM, id, item);
	}



	public static String register() {
		return "Registered Items.";
	}
}