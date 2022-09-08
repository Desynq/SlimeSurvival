package net.slimesurvival.common.item.weapon.gun;

import java.util.List;

import blue.endless.jankson.annotation.Nullable;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.slimesurvival.common.interfaces.ExtendableTooltipProvider;
import net.slimesurvival.common.registry.ModItemGroups;

public class BoltActionRifle extends Item implements ExtendableTooltipProvider {

	public BoltActionRifle(Settings settings) {
		super(settings
			.group(ModItemGroups.RANGED_WEAPONS)
			.maxDamage(120)
		);
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
