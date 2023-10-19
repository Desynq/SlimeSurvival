package slimesurvival.common.registry;

import io.wispforest.owo.registration.annotations.AssignedName;
import io.wispforest.owo.registration.reflect.ItemRegistryContainer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import slimesurvival.common.item.GunItem;
import slimesurvival.common.item.ModArmorMaterials;

// net.minecraft.item.Items
public class ModItems implements ItemRegistryContainer {
	public static final Item BOLT_ACTION_RIFLE = new GunItem(new FabricItemSettings());
	public static final Item TRENCH_SHOTGUN = new GunItem(new FabricItemSettings());
	public static final Item ASSAULT_RIFLE = new GunItem(new FabricItemSettings());
	public static final Item COALITION_PDW = new GunItem(new FabricItemSettings());

	public static final Item HEAVY_RIFLE_AMMO = new Item(new FabricItemSettings());
	public static final Item SHOTGUN_AMMO = new Item(new FabricItemSettings());
	public static final Item RIFLE_AMMO = new Item(new FabricItemSettings());
	public static final Item PISTOL_AMMO = new Item(new FabricItemSettings());



	@AssignedName("material/mystite_ingot")
	public static final Item MYSTITE_INGOT = new Item(new FabricItemSettings());

	@AssignedName("material/axolotl_gills")
	public static final Item AXOLOTL_GILLS = new Item(new FabricItemSettings());




	public static final Item MYSTITE_HELMET = new ArmorItem(ModArmorMaterials.MYSTITE, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof());
	public static final Item MYSTITE_CHESTPLATE = new ArmorItem(ModArmorMaterials.MYSTITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof());
	public static final Item MYSTITE_LEGGINGS = new ArmorItem(ModArmorMaterials.MYSTITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof());
	public static final Item MYSTITE_BOOTS = new ArmorItem(ModArmorMaterials.MYSTITE, ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof());
}
