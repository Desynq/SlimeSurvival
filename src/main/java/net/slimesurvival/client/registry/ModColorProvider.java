package net.slimesurvival.client.registry;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.item.DyeableItem;
import net.slimesurvival.common.registry.ModItems;

public class ModColorProvider {
	public static void register() {
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> tintIndex > 0 ? -1 : ((DyeableItem)((Object)stack.getItem())).getColor(stack), ModItems.AXOLOTL_HELMET, ModItems.AXOLOTL_CHESTPLATE, ModItems.AXOLOTL_LEGGINGS, ModItems.AXOLOTL_BOOTS);
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> tintIndex > 0 ? -1 : ((DyeableItem)((Object)stack.getItem())).getColor(stack), ModItems.TURTLE_HELMET, ModItems.TURTLE_CHESTPLATE, ModItems.TURTLE_LEGGINGS, ModItems.TURTLE_BOOTS);
	}
}
