package desynq.slimesurvival.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import desynq.slimesurvival.item.material.*;
import desynq.slimesurvival.item.weapon.*;
import desynq.slimesurvival.toolmaterial.*;



public class ModItems {
	public static final PolarBearFur Polar_Bear_Fur = new PolarBearFur(new FabricItemSettings().group(ItemGroup.Materials).maxCount(32));
	public static final WoolOfBat Wool_Of_Bat = new WoolOfBat(new FabricItemSettings().group(ItemGroup.Materials).maxCount(32));
	public static final AxolotlGills Axolotl_Gills = new AxolotlGills(new FabricItemSettings().group(ItemGroup.Materials).maxCount(32));
	public static final MystiteIngot Mystite_Ingot = new MystiteIngot(new FabricItemSettings().group(ItemGroup.Materials).maxCount(32));

	public static final ToolItem Rift_Battleaxe = new RiftBattleaxe(MystiteMaterial.INSTANCE, 29.0F, -3.25F, new FabricItemSettings().group(ItemGroup.Weapons));


	public static void register() {
		Registry.register(Registry.ITEM, new Identifier("slimesurvival", "polar_bear_fur"), Polar_Bear_Fur);
		Registry.register(Registry.ITEM, new Identifier("slimesurvival", "wool_of_bat"), Wool_Of_Bat);
		Registry.register(Registry.ITEM, new Identifier("slimesurvival", "axolotl_gills"), Axolotl_Gills);
		Registry.register(Registry.ITEM, new Identifier("slimesurvival", "mystite_ingot"), Mystite_Ingot);

		Registry.register(Registry.ITEM, new Identifier("slimesurvival", "rift_battleaxe"), Rift_Battleaxe);
	}
}