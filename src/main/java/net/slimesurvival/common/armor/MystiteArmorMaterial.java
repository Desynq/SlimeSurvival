package net.slimesurvival.common.armor;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.slimesurvival.common.registry.ModItems;

public class MystiteArmorMaterial implements ArmorMaterial {

	private MystiteArmorMaterial() {
	}

	private static MystiteArmorMaterial INSTANCE = null;

	public static MystiteArmorMaterial getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new MystiteArmorMaterial();
		}
		return INSTANCE;
	}

	private static final int[] BASE_DURABILITY = new int[] {2800, 3200, 3500, 2600};
	private static final int[] PROTECTION_AMOUNTS = new int[] {5, 8, 10, 5};

	@Override
	public int getDurability(EquipmentSlot equipmentSlot) {
		return BASE_DURABILITY[equipmentSlot.getEntitySlotId()];
	}

	@Override
	public int getProtectionAmount(EquipmentSlot equipmentSlot) {
		return PROTECTION_AMOUNTS[equipmentSlot.getEntitySlotId()];
	}

	@Override
	public int getEnchantability() {
		return 25;
	}

	@Override
	public SoundEvent getEquipSound() {
		return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(ModItems.MYSTITE_INGOT);
	}

	@Override
	@Environment(EnvType.CLIENT)
	public String getName() {
		return "mystite";
	}

	@Override
	public float getToughness() {
		return 4.0F;
	}

	@Override
	public float getKnockbackResistance() {
		return 2.0F;
	}

}