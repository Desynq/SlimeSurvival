package net.slimesurvival.common.recipe;

import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.util.collection.DefaultedList;
import net.slimesurvival.common.item.misc.MixingBowlItem;
import net.slimesurvival.mixin.ShapelessRecipeMixin;

// https://github.com/FabricMC/fabric/issues/50#issuecomment-651795843
public class MixingRecipe extends ShapelessRecipe {
	
	public MixingRecipe(ShapelessRecipe original) {
		super(
			original.getId(),
			((ShapelessRecipeMixin) original).getGroup(),
			original.getOutput(),
			original.getIngredients()
		);
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return MixingRecipeSerializer.INSTANCE;
	}

	@Override
	public DefaultedList<ItemStack> getRemainder(CraftingInventory inventory) {
		DefaultedList<ItemStack> defaultedList = DefaultedList.ofSize(inventory.size(), ItemStack.EMPTY);

		for (int i = 0; i < defaultedList.size(); i++) {
			ItemStack stack = inventory.getStack(i);
			Item item = stack.getItem();

			if(item instanceof MixingBowlItem) {
				if (!stack.isDamageable()) {
					stack = stack.copy();
					defaultedList.set(i, stack);
					continue;
				}

				int newDamage = stack.getDamage() + 1;
				if (newDamage < stack.getMaxDamage()) {
					stack = stack.copy();
					stack.setDamage(newDamage);
					defaultedList.set(i, stack);
				}
			} else if (item.hasRecipeRemainder()) {
				defaultedList.set(i, new ItemStack(item.getRecipeRemainder()));
			}
		}
		return defaultedList;
	}
}
