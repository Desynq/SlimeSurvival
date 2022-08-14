package net.slimesurvival.common.item.material;

import net.slimesurvival.util.provider.ExtendableTooltipProvider;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class MystiteOre extends Item implements ExtendableTooltipProvider {
	public MystiteOre(Settings settings) {
		super(settings);
	}



	@Override
	public String tooltipTranslationKey() {
		return this.getTranslationKey();
	}

	@Override
	public boolean hasDetails() {
		return true;
	}
	@Override
	public boolean hasHowToObtain() {
		return true;
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tryAppend(tooltip);
	}
}
