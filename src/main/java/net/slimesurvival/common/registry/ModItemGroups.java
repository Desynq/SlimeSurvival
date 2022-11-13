package net.slimesurvival.common.registry;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.slimesurvival.SlimeSurvival;


@Deprecated
public class ModItemGroups {

	public static final ItemGroup TOOLS = FabricItemGroupBuilder.create(SlimeSurvival.ID("tools")).icon(() -> new ItemStack(ModItemsNew.MOLTEN_PICKAXE)).build();








	public static final ItemGroup MATERIALS = FabricItemGroupBuilder.build(SlimeSurvival.ID("materials"), () -> new ItemStack(ModItemsNew.MYSTITE_ORE));





	public static final ItemGroup EQUIPMENT = FabricItemGroupBuilder.build(SlimeSurvival.ID("equipment"), () -> new ItemStack(ModItems.MYSTITE_HELMET));
	public static final ItemGroup TRINKETS = FabricItemGroupBuilder.build(SlimeSurvival.ID("trinkets"), () -> new ItemStack(ModItems.ARCHERY_GOGGLES));










	public static final ItemGroup WEAPONS = FabricItemGroupBuilder.build(SlimeSurvival.ID("weapons"), () -> new ItemStack(ModItems.RIFT_BATTLEAXE));



	public static final ItemGroup RANGED_WEAPONS = FabricItemGroupBuilder.build(SlimeSurvival.ID("ranged_weapons"), () -> new ItemStack(ModItems.MYSTITE_LONGBOW));



	public static final ItemGroup AMMO = FabricItemGroupBuilder.build(SlimeSurvival.ID("ammo"), () -> new ItemStack(ModItems.RIFLE_AMMO));
}