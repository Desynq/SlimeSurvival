package net.slimesurvival.common.registry;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import moriyashiine.bewitchment.common.registry.BWMaterials;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.slimesurvival.SlimeSurvival;
import net.slimesurvival.common.item.SSItemGroups;
import net.slimesurvival.common.item.ammo.*;
import net.slimesurvival.common.item.trinket.*;
import net.slimesurvival.common.item.weapon.gun.*;
import net.slimesurvival.common.item.weapon.melee.*;
import net.slimesurvival.common.item.weapon.ranged.*;
import net.slimesurvival.util.RegistryHelper;


@Deprecated
public class ModItems {

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