package net.slimesurvival.util;

import java.util.function.BiConsumer;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;

public class StackGenerators {

	/**
	 * Generates {@link ModItemsNew#ICON_MAX} icons, displaying all the available
	 * icons
	 * I suck at making javadocs, ok
	 */
	public static final int ICON_MAX = 17;
	public static final BiConsumer<Item, DefaultedList<ItemStack>> ICON_STACK_GENERATOR = (item, stacks) -> {
		for (int i = 0; i <= ICON_MAX; i++) {
			ItemStack stack = new ItemStack(item);
			stack.getOrCreateNbt().putInt("CustomModelData", i);
			stack.setCustomName(Text.of(String.valueOf(i)));
			stacks.add(stack);
		}
	};
}
