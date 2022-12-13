package net.slimesurvival.common.item;

import java.util.Random;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class FoodComponents {

	public static final FoodComponent COPPER_SULFATE = new FoodComponent.Builder()
			.hunger(0)
			.saturationModifier(0f)
			.snack()
			.alwaysEdible()
			.statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200), 0.5f)
			.build();

	public static final FoodComponent CREEPER_FLESH = new FoodComponent.Builder()
			.hunger(3)
			.saturationModifier(1 / 3f)
			.alwaysEdible()
			.build();

	// the funny
	public static final FoodComponent LEAD_INGOT = new FoodComponent.Builder()
			.hunger(0)
			.saturationModifier(0f)
			.alwaysEdible()
			.statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, new Random().nextInt(201) + 1), 0.7f) // 70% chance for nausea ranging from 0 to 201 ticks
			.build();
	
	public static final FoodComponent QUICKSILVER = new FoodComponent.Builder()
			.hunger(0)
			.saturationModifier(0f)
			.alwaysEdible()
			.build();
}
