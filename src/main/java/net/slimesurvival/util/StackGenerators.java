package net.slimesurvival.util;

import java.util.function.BiConsumer;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public class StackGenerators {

	public static final int ICON_MAX = 17;
	public static final BiConsumer<Item, ItemGroup.Entries> ICON_STACK_GENERATOR = (item, entries) -> {
		for (int i = 0; i <= ICON_MAX; i++) {
			ItemStack stack = new ItemStack(item);
			stack.getOrCreateNbt().putInt("CustomModelData", i);
			stack.setCustomName(Text.of(String.valueOf(i)));

			entries.add(stack);
		}
	};
}
