package net.slimesurvival.registry;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.slimesurvival.SlimeSurvival;



public class ModItemGroups {
	public static final ItemGroup BLOCKS = FabricItemGroupBuilder.create(SlimeSurvival.ID("blocks")).icon(() -> new ItemStack(ModItems.SOLID_BLACK)).build();

	public static final ItemGroup Materials = FabricItemGroupBuilder.create(SlimeSurvival.ID("materials")).icon(() -> new ItemStack(ModItems.MYSTITE_ORE)).build();

	public static final ItemGroup Weapons = FabricItemGroupBuilder.create(SlimeSurvival.ID("weapons")).icon(() -> new ItemStack(ModItems.RIFT_BATTLEAXE)).build();

	public static final ItemGroup Armor = FabricItemGroupBuilder.create(SlimeSurvival.ID("armor")).icon(() -> new ItemStack(ModItems.MYSTITE_HELMET)).build();

	public static final ItemGroup Trinkets = FabricItemGroupBuilder.create(SlimeSurvival.ID("trinkets")).icon(() -> new ItemStack(ModItems.WINTER_COAT)).build();
}