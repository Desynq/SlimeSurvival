package net.slimesurvival.item.material;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.slimesurvival.util.provider.ExtendableTooltipProvider;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class MystiteIngot extends Item implements ExtendableTooltipProvider {
	public MystiteIngot(Settings settings) {
		super(settings);
	}

	@Override
	public String tooltipTranslationKey() {
		return this.getTranslationKey();
	}

	@Override
	public boolean hasTooltip() {
		return false;
	}
	@Override
	public boolean hasHowToObtain() {
		return false;
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tryAppend(tooltip);
	}
}
