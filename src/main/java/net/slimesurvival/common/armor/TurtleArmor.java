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
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.DyeableArmorItem;
import net.minecraft.item.DyeableItem;
import net.minecraft.item.ItemStack;
import net.slimesurvival.common.interfaces.InitialStackStateProvider;
import net.slimesurvival.common.registry.ModItems;

public class TurtleArmor extends DyeableArmorItem implements InitialStackStateProvider {
	private static final UUID[] MODIFIERS = new UUID[] {
		UUID.fromString("C2B83E0A-BE81-4579-A279-ADAEB160C1EA"),
		UUID.fromString("A602B8CD-CBE9-4373-BBB8-A13A2F04D7EC"),
		UUID.fromString("11B2CF25-B4C3-4319-8CFF-0E64B2443616"),
		UUID.fromString("E7B4F348-D32C-44EE-A44B-B5AF741FA53A")
	};

	private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
	private final int protection;
	private final float toughness;
	protected final float knockbackResistance;
	protected final EquipmentSlot slot;
	protected final ArmorMaterial material;

	public TurtleArmor(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
		super(material, slot, settings);
		this.material = material;
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
		
		if (stack.getItem() == ModItems.TURTLE_HELMET) {
			defaultEnchants.put(Enchantments.RESPIRATION, 3);
			defaultEnchants.put(Enchantments.AQUA_AFFINITY, 1);
		}

		EnchantmentHelper.set(defaultEnchants, stack);

		((DyeableItem) stack.getItem()).setColor(stack, 7844892);
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