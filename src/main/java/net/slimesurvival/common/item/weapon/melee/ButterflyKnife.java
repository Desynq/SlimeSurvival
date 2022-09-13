package net.slimesurvival.common.item.weapon.melee;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.slimesurvival.common.interfaces.ExtendableTooltipProvider;
import net.slimesurvival.common.registry.ModItemGroups;
import net.slimesurvival.common.registry.ModToolMaterials;

public class ButterflyKnife extends SwordItem implements ExtendableTooltipProvider {

	public ButterflyKnife(Settings settings) {
		super(ModToolMaterials.MYSTITE, 5, 2.0F, settings
			.group(ModItemGroups.WEAPONS)
		);
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
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tryAppend(tooltip);
	}
}
