package net.slimesurvival.common.item.ammo;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.slimesurvival.common.interfaces.ExtendableTooltipProvider;
import net.slimesurvival.common.registry.ModItemGroups;

public class RifleAmmo extends Item implements ExtendableTooltipProvider {

	public RifleAmmo(Settings settings) {
		super(settings.group(ModItemGroups.AMMO).maxCount(120));
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