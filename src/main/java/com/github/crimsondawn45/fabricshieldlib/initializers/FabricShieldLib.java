package com.github.crimsondawn45.fabricshieldlib.initializers;

import com.github.crimsondawn45.fabricshieldlib.lib.config.FabricShieldLibConfig;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldDecoratorRecipe;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldEnchantment;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * Main class for Fabric Shield Lib
 */
public class FabricShieldLib implements ModInitializer {

    /**
     * Fabric Shield Lib's modid.
     */
    public static final String MOD_ID = "fabricshieldlib";

    /**
     * Fabric Shield Lib's logger.
     */
    public static final Logger logger = LoggerFactory.getLogger(MOD_ID);
    /**
     * Fabric Shield Lib's config file
     */
    public static FabricShieldLibConfig config = new FabricShieldLibConfig();

    /**
     * Test shield item.
     */
    public static FabricBannerShieldItem fabric_banner_shield;

    /**
     * Test shield item that does not support banners
     */
    public static FabricShieldItem fabric_shield;

    /**
     * Recipe type and serializer for banner decoration recipe
     */
    public static final SpecialRecipeSerializer<FabricShieldDecoratorRecipe> FABRIC_SHIELD_DECORATION_SERIALIZER;
    public static final RecipeType<FabricShieldDecoratorRecipe> FABRIC_SHIELD_DECORATION;

    /**
     * Test shield enchantment.
     */
    public static FabricShieldEnchantment reflect_enchantment;

    static {
        //Registering Banner Recipe (Lib only)
        FABRIC_SHIELD_DECORATION = Registry.register(Registry.RECIPE_TYPE, new Identifier("fabricshieldlib", "fabric_shield_decoration"), new RecipeType<FabricShieldDecoratorRecipe>() {
            @Override
            public String toString() {return "test_recipe";}
        });
        FABRIC_SHIELD_DECORATION_SERIALIZER = Registry.register(Registry.RECIPE_SERIALIZER, new Identifier("fabricshieldlib", "fabric_shield_decoration"), new SpecialRecipeSerializer<>(FabricShieldDecoratorRecipe::new));
    }

    @Override
    public void onInitialize() {

        /**
         * Register Config
         */
        AutoConfig.register(FabricShieldLibConfig.class, GsonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(FabricShieldLibConfig.class).getConfig();   //Read config data

        /**
         * Annouce done starting up
         */
        logger.info("Fabric Shield Lib Initialized!");
    }
}
