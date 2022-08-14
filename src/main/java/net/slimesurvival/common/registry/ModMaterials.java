package net.slimesurvival.common.registry;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ModMaterials {
	public static final ToolMaterial MYSTITE_TOOL = new ToolMaterial() {
		@Override
		public int getDurability() {
			return 3000;
		}

		@Override
		public float getMiningSpeedMultiplier() {
			return 5.0F;
		}

		@Override
		public float getAttackDamage() {
			return 0.0F;
		}

		@Override
		public int getMiningLevel() {
			return 3;
		}

		@Override
		public int getEnchantability() {
			return 25;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.ofItems(ModItems.MYSTITE_INGOT);
		}
	};






	public static void register() {
	}
}
