package net.slimesurvival.common.item.ammo;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.slimesurvival.common.registry.ModItemGroups;
import net.slimesurvival.util.provider.ExtendableTooltipProvider;

public class PistolAmmo extends Item implements ExtendableTooltipProvider {

	public PistolAmmo(Settings settings) {
		super(settings.group(ModItemGroups.AMMO).maxCount(64));
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