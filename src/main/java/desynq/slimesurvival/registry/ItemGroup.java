package desynq.slimesurvival.registry;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemStack;
import desynq.slimesurvival.SlimeSurvival;



public class ItemGroup {
	public static final net.minecraft.item.ItemGroup Materials = FabricItemGroupBuilder.create(SlimeSurvival.ID("materials")).icon(() -> new ItemStack(ModItems.Polar_Bear_Fur)).build();

	public static final net.minecraft.item.ItemGroup Weapons = FabricItemGroupBuilder.create(SlimeSurvival.ID("materials")).icon(() -> new ItemStack(ModItems.Rift_Battleaxe)).build();
}
