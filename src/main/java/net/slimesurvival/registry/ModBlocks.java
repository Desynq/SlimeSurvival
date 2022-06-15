package net.slimesurvival.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.registry.Registry;
import net.slimesurvival.SlimeSurvival;

public class ModBlocks {
	public static final Block GMOD_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(1.8F));

	public static final Block SOLID_BLACK = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(1.8F));
	public static final Block SOLID_BLUE = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(1.8F));
	public static final Block SOLID_GREEN = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(1.8F));
	public static final Block SOLID_MAGENTA = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(1.8F));
	public static final Block SOLID_RED = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(1.8F));
	public static final Block SOLID_WHITE = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(1.8F));
	public static final Block SOLID_YELLOW = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(1.8F));



	public static void register() {
		Registry.register(Registry.BLOCK, SlimeSurvival.ID("gmod_block"), GMOD_BLOCK);

		Registry.register(Registry.BLOCK, SlimeSurvival.ID("solid_black"), SOLID_BLACK);
		Registry.register(Registry.BLOCK, SlimeSurvival.ID("solid_blue"), SOLID_BLUE);
		Registry.register(Registry.BLOCK, SlimeSurvival.ID("solid_green"), SOLID_GREEN);
		Registry.register(Registry.BLOCK, SlimeSurvival.ID("solid_magenta"), SOLID_MAGENTA);
		Registry.register(Registry.BLOCK, SlimeSurvival.ID("solid_red"), SOLID_RED);
		Registry.register(Registry.BLOCK, SlimeSurvival.ID("solid_white"), SOLID_WHITE);
		Registry.register(Registry.BLOCK, SlimeSurvival.ID("solid_yellow"), SOLID_YELLOW);
	}
}
