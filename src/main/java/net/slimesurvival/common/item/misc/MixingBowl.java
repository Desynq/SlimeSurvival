package net.slimesurvival.common.item.misc;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.slimesurvival.common.interfaces.ExtendableTooltipProvider;
import net.slimesurvival.common.registry.ModItemGroups;

public class MixingBowl extends Item implements ExtendableTooltipProvider {

	public MixingBowl(Settings settings) {
		super(settings
			.group(ModItemGroups.Materials)
			.maxDamage(32)
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