package net.slimesurvival.common.item.material;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.slimesurvival.common.registry.ModItemGroups;
import net.slimesurvival.util.provider.ExtendableTooltipProvider;

public class RawGalena extends Item implements ExtendableTooltipProvider {

	public RawGalena(Settings settings) {
		super(settings.group(ModItemGroups.MATERIALS).maxCount(32));
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