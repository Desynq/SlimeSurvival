package net.slimesurvival.common.item;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.slimesurvival.common.registry.ModItemsNew;

public enum SSToolMaterials implements ToolMaterial {
	MYSTITE(MiningLevels.NETHERITE + 1, 3000, 12.0F, 0.0F, 25, Ingredient.ofItems(ModItemsNew.MYSTITE_INGOT)),
	MOLTEN(MiningLevels.NETHERITE, 1797, 6.0F, 0.0F, 20, Ingredient.ofItems(Items.NETHERITE_INGOT));



	private final int miningLevel;
	private final int itemDurability;
	private final float miningSpeed;
	private final float attackDamage;
	private final int enchantability;
	private final Ingredient repairIngredient;

	private SSToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Ingredient repairIngredient) {
		this.miningLevel = miningLevel;
		this.itemDurability = itemDurability;
		this.miningSpeed = miningSpeed;
		this.attackDamage = attackDamage;
		this.enchantability = enchantability;
		this.repairIngredient = repairIngredient;
	}

	@Override
	public int getDurability() {
		return this.itemDurability;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return this.miningSpeed;
	}

	@Override
	public float getAttackDamage() {
		return this.attackDamage;
	}

	@Override
	public int getMiningLevel() {
		return this.miningLevel;
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredient;
	}
}
