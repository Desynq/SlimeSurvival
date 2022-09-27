package net.slimesurvival.common.item.material;

import java.util.List;
import java.util.Random;

import org.jetbrains.annotations.Nullable;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.slimesurvival.common.interfaces.ExtendableTooltipProvider;
import net.slimesurvival.common.registry.ModItemGroups;

public class LeadIngot extends Item implements ExtendableTooltipProvider {

	public LeadIngot(Settings settings) {
		super(settings.group(ModItemGroups.MATERIALS).maxCount(32).food(new FoodComponent.Builder()
			.hunger(0)
			.saturationModifier(0f)
			.alwaysEdible()
			.statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, new Random().nextInt(200 - 80 + 1 + 80)), 0.7f)
			.build()
		));
	}


	@Override
	public int getMaxUseTime(ItemStack stack) {
		return 320;
	}



	@Override
	public String tooltipTranslationKey() {
		return this.getTranslationKey();
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tryAppend(tooltip);
	}
}