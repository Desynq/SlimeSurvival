package net.slimesurvival.common.registry;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import io.wispforest.owo.registration.reflect.ItemRegistryContainer;
import net.minecraft.item.Item;
import net.slimesurvival.util.StackGenerators;

public class ModItems implements ItemRegistryContainer {

	public static final Item ICON = new Item(new OwoItemSettings().stackGenerator(StackGenerators.ICON_STACK_GENERATOR));
}
