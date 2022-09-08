package net.slimesurvival.common.registry;

import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;
import net.slimesurvival.SlimeSurvival;

public class ModItemTags {

	public static final TagKey<Item> IS_SILVER_WEAPON = TagKey.of(Registry.ITEM_KEY, SlimeSurvival.ID("is_silver_weapon"));



	public static void register() {}
}
