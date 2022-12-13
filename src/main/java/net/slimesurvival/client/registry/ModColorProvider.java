package net.slimesurvival.client.registry;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.item.DyeableItem;
import net.slimesurvival.common.registry.ModItemsNew;

public class ModColorProvider {
	public static void register() {
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> tintIndex > 0 ? -1 : ((DyeableItem)((Object)stack.getItem())).getColor(stack), ModItemsNew.AXOLOTL_HELMET, ModItemsNew.AXOLOTL_CHESTPLATE, ModItemsNew.AXOLOTL_LEGGINGS, ModItemsNew.AXOLOTL_BOOTS);
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> tintIndex > 0 ? -1 : ((DyeableItem)((Object)stack.getItem())).getColor(stack), ModItemsNew.TURTLE_HELMET, ModItemsNew.TURTLE_CHESTPLATE, ModItemsNew.TURTLE_LEGGINGS, ModItemsNew.TURTLE_BOOTS);
	}
}
