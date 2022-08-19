package net.slimesurvival.common.item.misc;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.slimesurvival.common.interfaces.ExtendableTooltipProvider;
import net.slimesurvival.common.item.MixingBowlItem;
import net.slimesurvival.common.registry.ModItemGroups;
import net.slimesurvival.common.registry.ModItems;

public class MixingBowl extends MixingBowlItem implements ExtendableTooltipProvider {

	public MixingBowl(Settings settings) {
		super(settings
			.group(ModItemGroups.Materials)
			.maxDamage(32)
			.recipeRemainder(ModItems.MIXING_BOWL)
		);
	}






	@Override
	public boolean hasTooltip() {
		return true;
	}
	@Override
	public boolean hasDetails() {
		return true;
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