package net.slimesurvival.common.registry;

import java.lang.reflect.Field;

import io.wispforest.owo.registration.reflect.BlockRegistryContainer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.slimesurvival.common.block.*;

public class ModBlocks implements BlockRegistryContainer {
	public static final Block GMOD_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(1.8F));


	public static final Block SOLID_BLACK = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(1.8F));
	public static final Block SOLID_BLUE = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(1.8F));
	public static final Block SOLID_GREEN = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(1.8F));
	public static final Block SOLID_MAGENTA = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(1.8F));
	public static final Block SOLID_RED = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(1.8F));
	public static final Block SOLID_WHITE = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(1.8F));
	public static final Block SOLID_YELLOW = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(1.8F));



	public static final Block ENDER_SHOP = new Block(FabricBlockSettings.of(Material.REPAIR_STATION).requiresTool().strength(8.0F, 10.0F));


	// Like TNT, but it has no functionality and serves purely as a decorational block in builds
	public static final Block FAKE_TNT = new Block(FabricBlockSettings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS));

	public static final Block CRACKED_OBSIDIAN = new CrackedObsidianBlock();



	/**
	 * Disables the creation of a default {@link net.minecraft.item.BlockItem#BlockItem} instance when registering {@link net.minecraft.block.Block#Block} instances
	 * {@link net.minecraft.item.BlockItem#BlockItem} instances should instead be registed in {@link net.slimesurvival.common.registry.ModItemsNew#ModItemsNew}
	 *
	 * @see io.wispforest.owo.registration.reflect.BlockRegistryContainer#postProcessField(java.lang.String, net.minecraft.block.Block, java.lang.String, java.lang.reflect.Field)
	 */
	@Override
	public void postProcessField(String namespace, Block value, String identifier, Field field) {
		return;
	}
}
