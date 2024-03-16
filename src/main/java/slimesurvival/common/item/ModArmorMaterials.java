package slimesurvival.common.item;

import java.util.EnumMap;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.Util;
import slimesurvival.common.registry.ModItems;

public enum ModArmorMaterials implements ArmorMaterial {
	AXOLOTL("axolotl", 15, Util.make(new EnumMap<ArmorItem.Type, Integer>(ArmorItem.Type.class), map -> {
		map.put(ArmorItem.Type.BOOTS, 1);
		map.put(ArmorItem.Type.LEGGINGS, 4);
		map.put(ArmorItem.Type.CHESTPLATE, 5);
		map.put(ArmorItem.Type.HELMET, 2);
	}), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0f, 0.0f, Ingredient.of(ModItems.AXOLOTL_GILLS)),
	TURTLE("turtle", 33, Util.make(new EnumMap<ArmorItem.Type, Integer>(ArmorItem.Type.class), map -> {
		map.put(ArmorItem.Type.BOOTS, 3);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.CHESTPLATE, 8);
		map.put(ArmorItem.Type.HELMET, 3);
	}), 10, SoundEvents.ARMOR_EQUIP_TURTLE, 2.0f, 2.5f, Ingredient.of(Items.SCUTE)),
	MYSTITE("mystite", 200, Util.make(new EnumMap<ArmorItem.Type, Integer>(ArmorItem.Type.class), map -> {
		map.put(ArmorItem.Type.BOOTS, 5);
		map.put(ArmorItem.Type.LEGGINGS, 8);
		map.put(ArmorItem.Type.CHESTPLATE, 10);
		map.put(ArmorItem.Type.HELMET, 5);
	}), 25, SoundEvents.ARMOR_EQUIP_NETHERITE, 4.0f, 2.0f, Ingredient.of(ModItems.MYSTITE_INGOT));

	private static final EnumMap<ArmorItem.Type, Integer> BASE_DURABILITY;
	private final String name;
	private final int durabilityMultiplier;
	private final EnumMap<ArmorItem.Type, Integer> protectionAmounts;
	private final int enchantability;
	private final SoundEvent equipSound;
	private final float toughness;
	private final float knockbackResistance;
	private final Ingredient repairIngredient;

	private ModArmorMaterials(String name, int durabilityMultiplier, EnumMap<ArmorItem.Type, Integer> protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Ingredient repairIngredient) {
		this.name = name;
		this.durabilityMultiplier = durabilityMultiplier;
		this.protectionAmounts = protectionAmounts;
		this.enchantability = enchantability;
		this.equipSound = equipSound;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.repairIngredient = repairIngredient;
	}

	@Override
	public int getDurabilityForType(ArmorItem.Type type) {
		return BASE_DURABILITY.get((Object)type) * this.durabilityMultiplier;
	}

	@Override
	public int getDefenseForType(ArmorItem.Type type) {
		return this.protectionAmounts.get((Object)type);
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantability;
	}

	@Override
	public SoundEvent getEquipSound() {
		return this.equipSound;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredient;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}

	static {
		BASE_DURABILITY = Util.make(new EnumMap<ArmorItem.Type, Integer>(ArmorItem.Type.class), map -> {
			map.put(ArmorItem.Type.BOOTS, 13);
			map.put(ArmorItem.Type.LEGGINGS, 15);
			map.put(ArmorItem.Type.CHESTPLATE, 16);
			map.put(ArmorItem.Type.HELMET, 11);
		});
	}
}
