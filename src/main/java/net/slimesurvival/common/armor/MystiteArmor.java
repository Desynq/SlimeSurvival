package net.slimesurvival.common.armor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap.Builder;

import net.minecraft.block.DispenserBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.slimesurvival.common.interfaces.InitialStackStateProvider;

public class MystiteArmor extends ArmorItem implements InitialStackStateProvider {
	private static final UUID[] MODIFIERS = new UUID[] {
		UUID.fromString("11FD6B5B-87FD-426A-98D6-E9F4FB5BE8A1"),
		UUID.fromString("A68944C6-1820-4DC5-AD6C-EFA834F5A55D"),
		UUID.fromString("D2911249-938E-4405-B22C-E3F269A6E03F"),
		UUID.fromString("CCAE1236-6A4B-4B2D-945D-97961D53603E")
	};

	private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
	private final int protection;
	private final float toughness;
	protected final float knockbackResistance;
	protected final EquipmentSlot slot;
	protected final ArmorMaterial type;

	public MystiteArmor(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
		super(material, slot, settings);
		this.type = material;
		this.slot = slot;
		this.protection = material.getProtectionAmount(slot);
		this.toughness = material.getToughness();
		this.knockbackResistance = material.getKnockbackResistance();

		DispenserBlock.registerBehavior(this, DISPENSER_BEHAVIOR);
		Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
		UUID UUID = MODIFIERS[slot.getEntitySlotId()];
		builder.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(UUID, "Armor modifier", (double) this.protection, EntityAttributeModifier.Operation.ADDITION));
		builder.put(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, new EntityAttributeModifier(UUID, "Armor toughness", (double) this.toughness, EntityAttributeModifier.Operation.ADDITION));
		builder.put(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, new EntityAttributeModifier(UUID, "Armor knockback resistance", (double) this.knockbackResistance / 10.0d, EntityAttributeModifier.Operation.ADDITION));
		this.attributeModifiers = builder.build();
	}





	@Override
	public void initializeState(ItemStack stack) {
		Map<Enchantment, Integer> defaultEnchants = new HashMap<>();

		defaultEnchants.put(Enchantments.PROTECTION, 5);

		EnchantmentHelper.set(defaultEnchants, stack);
	}





	@Override
	public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
		return slot == this.slot ? this.attributeModifiers : super.getAttributeModifiers(slot);
	}

	@Override
	public boolean hasGlint(ItemStack itemStack) {
		return false;
	}

}