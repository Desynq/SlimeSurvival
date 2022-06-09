package desynq.slimesurvival.toolmaterial;

import desynq.slimesurvival.registry.ModItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class MystiteMaterial implements ToolMaterial {
	public static final MystiteMaterial INSTANCE = new MystiteMaterial();

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
		return 30;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(ModItems.Mystite_Ingot);
	}
}
